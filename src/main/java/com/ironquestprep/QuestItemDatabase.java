package com.ironquestprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.api.Skill;

public final class QuestItemDatabase {
    private static final Map<String, QuestData> QUEST_DATA = buildQuestData();

    private QuestItemDatabase() {}

    public static List<RequiredItem> getItemsForUnfinishedQuests(
            Client client, BankTracker bankTracker) {
        List<RequiredItem> selected = new ArrayList<>();
        PrepAvailability.Progress progress = PrepAvailability.snapshot(client);

        for (QuestData questData : QUEST_DATA.values()) {
            Quest quest = resolveRuneLiteQuest(questData.helperName);

            /*
             * Helper-only activities / miniquests which do not
             * map to RuneLite's normal Quest enum are deliberately
             * skipped for now.
             */
            if (quest == null) {
                continue;
            }

            if (quest.getState(client) == QuestState.FINISHED) {
                continue;
            }

            for (String root : questData.roots) {
                selected.addAll(
                        resolveNode(
                                questData, root, client, bankTracker, progress, new HashSet<>()));
            }
        }

        return mergeItems(selected);
    }

    private static Map<String, QuestData> buildQuestData() {
        Map<String, QuestData> result = new LinkedHashMap<>();

        for (GeneratedQuestData.RawItem raw : GeneratedQuestData.getItems()) {
            if (!GeneratedPrepClassification.isPrepRequired(raw.getQuest(), raw.getVariable())) {
                continue;
            }

            QuestData data = result.computeIfAbsent(raw.getQuest(), QuestData::new);

            data.items.put(raw.getVariable(), raw);
        }

        for (GeneratedQuestData.RawGroup raw : GeneratedQuestData.getGroups()) {
            QuestData data = result.computeIfAbsent(raw.getQuest(), QuestData::new);

            data.groups.put(raw.getGroup(), raw);
        }

        for (QuestData data : result.values()) {
            buildRoots(data);
            for (GeneratedQuestData.RawItem raw : data.items.values())
                data.converted.put(raw.getVariable(), convertItem(data.helperName, raw));
        }

        return result;
    }

    private static void buildRoots(QuestData data) {
        Set<String> referencedGroups = new HashSet<>();

        /*
         * Find groups which are children of other groups.
         * Those are not top-level quest requirements.
         */
        for (GeneratedQuestData.RawGroup group : data.groups.values()) {
            for (String child : splitChildren(group.getChildren())) {
                if (data.groups.containsKey(child)) {
                    referencedGroups.add(child);
                }
            }
        }

        /*
         * Items without a parent group are direct quest
         * requirements.
         */
        for (GeneratedQuestData.RawItem item : data.items.values()) {
            if (isBlank(item.getGroup())) {
                data.roots.add(item.getVariable());
            }
        }

        /*
         * A group which isn't nested inside another group
         * is itself a top-level requirement.
         */
        for (Map.Entry<String, GeneratedQuestData.RawGroup> entry : data.groups.entrySet()) {
            String key = entry.getKey();

            if (referencedGroups.contains(key)) {
                continue;
            }

            if (shouldUseRootGroup(data.helperName, entry.getValue())) {
                data.roots.add(key);
            }
        }
    }

    private static boolean shouldUseRootGroup(String quest, GeneratedQuestData.RawGroup group) {
        if ("BANK_CHECKABLE".equals(group.getStatus())) {
            return true;
        }

        if ("CONDITIONAL".equals(group.getStatus())) {
            return true;
        }

        /*
         * This one is known and fully understood even though
         * the normaliser intentionally classified it as manual.
         */
        return "TheFremennikIsles".equals(quest) && "miningOreRequirement".equals(group.getGroup());
    }

    private static Quest resolveRuneLiteQuest(String helperName) {
        String enumName = GeneratedQuestMappings.getQuestEnumName(helperName);

        if (enumName == null || enumName.isEmpty()) {
            return null;
        }

        try {
            return Quest.valueOf(enumName);
        } catch (IllegalArgumentException ignored) {
            return null;
        }
    }

    private static List<RequiredItem> resolveNode(
            QuestData data,
            String key,
            Client client,
            BankTracker bankTracker,
            PrepAvailability.Progress progress,
            Set<String> trail) {
        List<RequiredItem> result = new ArrayList<>();

        if (key == null || key.isEmpty()) {
            return result;
        }

        if (!trail.add(key)) {
            return result;
        }

        try {
            GeneratedQuestData.RawItem item = data.items.get(key);

            if (item != null) {
                RequiredItem converted = data.converted.get(item.getVariable());

                if (converted != null
                        && PrepAvailability.canGather(item, converted, bankTracker, progress)) {
                    result.add(converted);
                }

                return result;
            }

            GeneratedQuestData.RawGroup group = data.groups.get(key);

            if (group == null) {
                return result;
            }

            String logic = group.getLogic();

            if ("AND".equals(logic)) {
                return resolveAndGroup(data, group, client, bankTracker, progress, trail);
            }

            if ("OR".equals(logic)) {
                return resolveOrGroup(data, group, client, bankTracker, progress, trail);
            }

            if ("CONDITIONAL".equals(logic)) {
                return resolveConditionalGroup(data, group, client, bankTracker, progress, trail);
            }

            return result;
        } finally {
            trail.remove(key);
        }
    }

    private static List<RequiredItem> resolveAndGroup(
            QuestData data,
            GeneratedQuestData.RawGroup group,
            Client client,
            BankTracker bankTracker,
            PrepAvailability.Progress progress,
            Set<String> trail) {
        List<RequiredItem> result = new ArrayList<>();

        for (String child : splitChildren(group.getChildren())) {
            result.addAll(resolveNode(data, child, client, bankTracker, progress, trail));
        }

        return result;
    }

    private static List<RequiredItem> resolveOrGroup(
            QuestData data,
            GeneratedQuestData.RawGroup group,
            Client client,
            BankTracker bankTracker,
            PrepAvailability.Progress progress,
            Set<String> trail) {
        List<RequiredItem> best = null;

        BranchScore bestScore = null;

        for (String child : splitChildren(group.getChildren())) {
            List<RequiredItem> candidate =
                    resolveNode(data, child, client, bankTracker, progress, trail);

            if (candidate.isEmpty()) {
                continue;
            }

            candidate = mergeItems(candidate);

            BranchScore score = scoreBranch(candidate, bankTracker);

            if (best == null || score.compareTo(bestScore) < 0) {
                best = candidate;

                bestScore = score;
            }
        }

        if (best == null) {
            return new ArrayList<>();
        }

        return best;
    }

    private static List<RequiredItem> resolveConditionalGroup(
            QuestData data,
            GeneratedQuestData.RawGroup group,
            Client client,
            BankTracker bankTracker,
            PrepAvailability.Progress progress,
            Set<String> trail) {
        String quest = data.helperName;

        String key = group.getGroup();

        /*
         * The Fremennik Isles:
         *
         * 55+ Mining: 6 mithril ore
         * 2-54 Mining: 7 coal
         * 1 Mining: 8 tin ore
         */
        if ("TheFremennikIsles".equals(quest) && "miningOreRequirement".equals(key)) {
            int mining = client.getRealSkillLevel(Skill.MINING);

            String child;

            if (mining >= 55) {
                child = "mithrilOre";
            } else if (mining >= 2) {
                child = "coal";
            } else {
                child = "tinOre";
            }

            return resolveNode(data, child, client, bankTracker, progress, trail);
        }

        /*
         * Royal Trouble:
         *
         * Mining 30+:
         *     5 coal OR a pickaxe
         *
         * Below 30:
         *     5 coal
         */
        if ("RoyalTrouble".equals(quest) && "coalOrPickaxe".equals(key)) {
            boolean mining30 = client.getRealSkillLevel(Skill.MINING) >= 30;

            return resolveNode(
                    data,
                    mining30 ? "coalOrPickaxe.whenTrue" : "coalOrPickaxe.whenFalse",
                    client,
                    bankTracker,
                    progress,
                    trail);
        }

        /*
         * Recipe for Disaster - Sir Amik Varze.
         *
         * If Legends' Quest is finished:
         *     machete
         *
         * Otherwise:
         *     machete + Radimus notes
         */
        if ("RFDSirAmikVarze".equals(quest) && "macheteAndRadimus".equals(key)) {
            boolean legendsFinished =
                    client.getGameState() == GameState.LOGGED_IN
                            && Quest.LEGENDS_QUEST.getState(client) == QuestState.FINISHED;

            return resolveNode(
                    data,
                    legendsFinished ? "macheteAndRadimus.whenTrue" : "macheteAndRadimus.whenFalse",
                    client,
                    bankTracker,
                    progress,
                    trail);
        }

        /*
         * Unknown conditional logic is deliberately omitted
         * instead of pretending every branch is required.
         */
        return new ArrayList<>();
    }

    static RequiredItem convertItem(String quest, GeneratedQuestData.RawItem raw) {
        if (!"BANK_CHECKABLE".equals(raw.getStatus())) {
            return null;
        }

        int quantity;

        try {
            quantity = Integer.parseInt(raw.getQuantity());
        } catch (NumberFormatException ignored) {
            return null;
        }

        if (quantity <= 0) {
            return null;
        }

        int[] itemIds = ItemSourceResolver.resolve(raw.getItemSource(), raw.getAlternateSources());

        /*
         * This currently excludes keyring-only requirements
         * because they are not physical bank items.
         */
        if (itemIds.length == 0) {
            return null;
        }

        boolean consumed = raw.isConsumed() && !isReusableTool(raw.getItemSource());

        String key = quest + ":" + raw.getVariable();

        AcquisitionInfo acquisitionInfo = IronmanAcquisitionAdvice.getInfo(raw);

        return new RequiredItem(
                key,
                itemIds,
                raw.getItemName(),
                quantity,
                acquisitionInfo,
                consumed,
                raw.getCondition());
    }

    /*
     * Pick the OR branch that best matches what the player
     * already owns.
     *
     * Priority:
     * 1. Fewest missing item types
     * 2. Lowest total missing quantity
     * 3. Fewest item types overall
     */
    private static BranchScore scoreBranch(List<RequiredItem> items, BankTracker bankTracker) {
        int missingTypes = 0;
        long missingQuantity = 0;

        for (RequiredItem item : items) {
            int missing = item.getMissingQuantity(bankTracker);

            if (missing > 0) {
                missingTypes++;
                missingQuantity += missing;
            }
        }

        return new BranchScore(missingTypes, missingQuantity, items.size());
    }

    private static boolean isReusableTool(String source) {
        if (source == null) {
            return false;
        }

        switch (source) {
            case "ItemCollections.AXES":
            case "ItemCollections.PICKAXES":
            case "ItemCollections.HAMMER":
            case "ItemCollections.CHISEL":
            case "ItemCollections.SAW":
            case "ItemCollections.MACHETE":

            case "ItemID.HAMMER":
            case "ItemID.KNIFE":
            case "ItemID.SPADE":
            case "ItemID.TINDERBOX":
            case "ItemID.CHISEL":
            case "ItemID.NEEDLE":
            case "ItemID.PESTLE_AND_MORTAR":
            case "ItemID.RAKE":
            case "ItemID.DIBBER":
            case "ItemID.SECATEURS":
            case "ItemID.FISHING_ROD":
            case "ItemID.GLASSBLOWINGPIPE":
                return true;

            default:
                return false;
        }
    }

    /*
     * Merge requirements which represent the same physical
     * bank item / acceptable item set.
     *
     * Quest Helper conditions are deliberately NOT part of
     * the merge identity. They describe quest-progress state,
     * not a different physical item.
     *
     * Consumed items are summed.
     * Reusable items use the largest quantity.
     */
    static List<RequiredItem> mergeItems(List<RequiredItem> items) {
        Map<String, MergeAccumulator> merged = new LinkedHashMap<>();

        for (RequiredItem item : items) {
            String identity = itemIdentity(item);

            MergeAccumulator accumulator =
                    merged.computeIfAbsent(identity, unused -> new MergeAccumulator(item));

            accumulator.add(item);
        }

        List<RequiredItem> result = new ArrayList<>();

        for (MergeAccumulator accumulator : merged.values()) {
            result.add(accumulator.toRequiredItem());
        }

        return result;
    }

    /*
     * Physical identity only.
     *
     * The condition used to be appended here, which meant
     * the same item could appear multiple times simply because
     * different quests had different progress conditions.
     */
    private static String itemIdentity(RequiredItem item) {
        int[] ids = item.getItemIds();

        Arrays.sort(ids);

        StringBuilder builder = new StringBuilder();

        for (int id : ids) {
            if (builder.length() > 0) {
                builder.append(',');
            }

            builder.append(id);
        }

        return builder.toString();
    }

    private static List<String> splitChildren(String children) {
        List<String> result = new ArrayList<>();

        if (children == null || children.trim().isEmpty()) {
            return result;
        }

        for (String child : children.split("\\|")) {
            String trimmed = child.trim();

            if (!trimmed.isEmpty()) {
                result.add(trimmed);
            }
        }

        return result;
    }

    private static boolean isBlank(String text) {
        return text == null || text.trim().isEmpty();
    }

    /*
     * Prefer proper region/location information over generic
     * or unknown acquisition data when several quests merge
     * into the same checklist item.
     */
    private static AcquisitionInfo chooseBetterAcquisitionInfo(
            AcquisitionInfo current, AcquisitionInfo candidate) {
        if (current == null) {
            return candidate;
        }

        if (candidate == null) {
            return current;
        }

        int currentScore = acquisitionInfoScore(current);

        int candidateScore = acquisitionInfoScore(candidate);

        if (candidateScore > currentScore) {
            return candidate;
        }

        return current;
    }

    private static int acquisitionInfoScore(AcquisitionInfo info) {
        if (info == null) {
            return -1;
        }

        AcquisitionRegion region = info.getRegion();

        if (region == AcquisitionRegion.UNKNOWN) {
            return info.hasMethod() ? 1 : 0;
        }

        if (region == AcquisitionRegion.ANYWHERE) {
            return info.hasMethod() ? 3 : 2;
        }

        if (info.hasLocation() && info.hasMethod()) {
            return 6;
        }

        if (info.hasLocation()) {
            return 5;
        }

        if (info.hasMethod()) {
            return 4;
        }

        return 3;
    }

    private static final class QuestData {
        private final Map<String, RequiredItem> converted = new LinkedHashMap<>();
        private final String helperName;

        private final Map<String, GeneratedQuestData.RawItem> items = new LinkedHashMap<>();

        private final Map<String, GeneratedQuestData.RawGroup> groups = new LinkedHashMap<>();

        private final Set<String> roots = new LinkedHashSet<>();

        private QuestData(String helperName) {
            this.helperName = helperName;
        }
    }

    private static final class MergeAccumulator {
        private final String key;
        private final int[] itemIds;
        private final String name;

        private AcquisitionInfo acquisitionInfo;
        private String condition;

        private long consumedQuantity = 0;
        private int reusableQuantity = 0;

        private MergeAccumulator(RequiredItem item) {
            this.key = item.getKey();

            this.itemIds = item.getItemIds();

            this.name = item.getName();

            this.acquisitionInfo = item.getAcquisitionInfo();

            this.condition = normaliseCondition(item.getCondition());
        }

        private void add(RequiredItem item) {
            if (item.isConsumed()) {
                consumedQuantity += item.getRequiredQuantity();
            } else {
                reusableQuantity = Math.max(reusableQuantity, item.getRequiredQuantity());
            }

            acquisitionInfo =
                    chooseBetterAcquisitionInfo(acquisitionInfo, item.getAcquisitionInfo());

            String incomingCondition = normaliseCondition(item.getCondition());

            /*
             * If merged requirements have different quest
             * conditions, don't show one arbitrary condition
             * as though it applied to the whole merged item.
             */
            if (!condition.equals(incomingCondition)) {
                condition = "";
            }
        }

        private RequiredItem toRequiredItem() {
            long quantity = Math.max(consumedQuantity, reusableQuantity);

            int finalQuantity = quantity > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) quantity;

            return new RequiredItem(
                    key,
                    itemIds,
                    name,
                    finalQuantity,
                    acquisitionInfo,
                    consumedQuantity > 0,
                    condition);
        }

        private static String normaliseCondition(String value) {
            if (value == null) {
                return "";
            }

            return value.trim();
        }
    }

    private static final class BranchScore implements Comparable<BranchScore> {
        private final int missingTypes;
        private final long missingQuantity;
        private final int totalTypes;

        private BranchScore(int missingTypes, long missingQuantity, int totalTypes) {
            this.missingTypes = missingTypes;

            this.missingQuantity = missingQuantity;

            this.totalTypes = totalTypes;
        }

        @Override
        public int compareTo(BranchScore other) {
            int comparison = Integer.compare(missingTypes, other.missingTypes);

            if (comparison != 0) {
                return comparison;
            }

            comparison = Long.compare(missingQuantity, other.missingQuantity);

            if (comparison != 0) {
                return comparison;
            }

            return Integer.compare(totalTypes, other.totalTypes);
        }
    }
}
