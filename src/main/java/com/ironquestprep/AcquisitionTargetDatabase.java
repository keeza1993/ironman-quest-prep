package com.ironquestprep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.NpcID;

/**
 * Exact/high-confidence targets used before the general AcquisitionPlace
 * navigation fallback.
 */
public final class AcquisitionTargetDatabase {
    private static final List<TargetRule> RULES = buildRules();

    private AcquisitionTargetDatabase() {}

    /**
     * Returns null when no exact rule matches.
     */
    public static GatheringTarget resolve(GatheringStep step) {
        if (step == null) {
            return null;
        }

        // Never infer a source from the requested item's name alone.
        // Match the selected location before notes that may mention alternatives.
        String location = normalise(step.getLocation());
        String instruction = normalise(step.getInstruction());
        for (String text : new String[] {location, location + " " + instruction}) {
            for (TargetRule rule : RULES) {
                if (rule.matches(text) && rule.matchesRegion(step)) {
                    GatheringTarget target = rule.create(step);
                    if (target != null) {
                        return target;
                    }
                }
            }
        }

        return null;
    }

    private static List<TargetRule> buildRules() {
        List<TargetRule> rules = new ArrayList<>();

        /*
         * =================================================
         * ITEM SPAWNS
         * =================================================
         */

        spawnPlace(rules, "Knife spawn / supply", "lumbridge", null, "pick up or buy a knife");

        spawnPlace(
                rules,
                "Shears spawn / supply",
                "lumbridge",
                null,
                "pick up or buy shears",
                "shears near lumbridge");

        spawnPlace(
                rules,
                "Swamp tar spawn",
                "lumbridge_swamp",
                null,
                "swamp tar spawn",
                "pick up swamp tar");

        /*
         * =================================================
         * EXACT NPC TARGETS
         * =================================================
         */

        npcAt(rules, NpcID.NED, "Ned", 3097, 3257, 0, null, "ned");

        npcAt(rules, NpcID.AGGIE_1OP, "Aggie", 3086, 3257, 0, null, "aggie");

        npcAt(rules, NpcID.GERRANT, "Gerrant", 3013, 3224, 0, null, "gerrant");

        npcAt(rules, NpcID.BETTY, "Betty", 3014, 3258, 0, null, "betty");

        npcAt(rules, NpcID.DUKE_OF_LUMBRIDGE, "Duke Horacio", 3209, 3222, 1, null, "duke horacio");

        npcAt(rules, NpcID.FATHER_URHNEY, "Father Urhney", 3147, 3175, 0, null, "father urhney");

        npcAt(rules, NpcID.THESSALIA_NORMAL, "Thessalia", 3204, 3417, 0, null, "thessalia");

        npcAt(rules, NpcID.WYSON, "Wyson the gardener", 3024, 3375, 0, null, "wyson");

        npcAt(rules, NpcID.NURMOF, "Nurmof", 2996, 9845, 0, null, "nurmof");

        /*
         * =================================================
         * ADDITIONAL NPC / SHOP TARGETS
         * =================================================
         */

        npcPlace(
                rules,
                NpcID.FARMING_SHOPKEEPER_1,
                "Sarah",
                "south_falador_farm",
                null,
                "sarah's farming shop",
                "sarahs farming shop");

        npcPlace(
                rules,
                NpcID.ROMMIK,
                "Rommik",
                "rimmington",
                "rimmington",
                "crafting shop",
                "crafting supplies",
                "crafting supply",
                "crafting tool");

        npcPlace(rules, NpcID.JATIX, "Jatix", "taverley", "taverley", "herblore shop", "buy vials");

        npcPlace(rules, NpcID.DEATH_SHERPA, "Tenzing", "burthorpe", null, "tenzing");

        npcPlace(rules, NpcID.SHADOW_WARRIOR_RASOOL, "Rasolo", "baxtorian_falls", null, "rasolo");

        npcPlace(
                rules,
                NpcID.SHANTAY,
                "Shantay",
                "shantay_pass",
                null,
                "shantay's shop",
                "shantay shop");

        npcPlace(
                rules,
                NpcID.LADYOFTHELAKE,
                "Lady of the Lake",
                "taverley",
                null,
                "lady of the lake");

        areaPlace(
                rules,
                "Burthorpe Slayer Master",
                "slayer_master_burthorpe",
                "burthorpe",
                "slayer master",
                "slayer supply",
                "slayer equipment");

        npcPlace(rules, NpcID.RADIMUS_ERKLE, "Radimus Erkle", "legends_guild", null, "radimus");

        npcPlace(
                rules,
                NpcID.RD_TELEPORTER_GUY,
                "Sir Tiffy Cashien",
                "falador_park",
                null,
                "sir tiffy");

        /*
         * =================================================
         * QUEST-STATE / UNDERGROUND TARGETS
         * =================================================
         */

        areaPlace(rules, "Plague City quest area", "ardougne", null, "plague city quest area");

        areaPlace(rules, "Brundt - Rellekka longhall", "rellekka", null, "brundt");

        areaPlace(rules, "Raetul - Sophanem linen shop", "sophanem", "sophanem", "buy linen");

        areaPlace(rules, "Catherby Candlemaker", "catherby", "catherby", "candlemaker");

        areaAt(rules, "Taverley Dungeon entrance", 2884, 3397, 0, null, "velrak");

        areaPlace(rules, "Myreque Hideout", "myreque_hideout", null, "myreque");

        /*
         * =================================================
         * PRECISE SHOPS / AREAS
         * =================================================
         */

        areaPlace(
                rules,
                "Lumbridge General Store",
                "lumbridge_general_store",
                "lumbridge general store",
                "empty container",
                "general store");

        areaAt(
                rules,
                "Bob's Brilliant Axes",
                3232,
                3203,
                0,
                null,
                "bob's axes",
                "bob's brilliant axes",
                "buy one from bob");

        areaAt(
                rules,
                "Mill Lane Mill",
                3166,
                3306,
                0,
                null,
                "lumbridge windmill",
                "mill lane mill");

        areaPlace(rules, "Cooks' Guild", "cooks_guild", null, "cooks' guild", "cooks guild");

        areaPlace(rules, "Taverley sawmill", "taverley_sawmill", null, "taverley sawmill");

        areaPlace(
                rules,
                "Tai Bwo Wannai supplies",
                "tai_bwo_wannai",
                "tai bwo",
                "charcoal",
                "tai bwo wannai");

        /*
         * =================================================
         * PRECISE GATHERING AREAS
         * =================================================
         */

        areaAt(
                rules,
                "Lumbridge cow field",
                3252,
                3276,
                0,
                null,
                "lumbridge cow field",
                "dairy cow");

        areaAt(
                rules,
                "Lumbridge sheep field",
                3200,
                3268,
                0,
                "lumbridge",
                "obtain wool",
                "shear a sheep");

        areaAt(rules, "Lumbridge chicken farm", 3228, 3298, 0, "lumbridge", "chicken farm");

        return Collections.unmodifiableList(rules);
    }

    private static void npcAt(
            List<TargetRule> rules,
            int npcId,
            String label,
            int x,
            int y,
            int plane,
            String required,
            String... any) {
        rules.add(
                new TargetRule(
                        TargetKind.NPC,
                        npcId,
                        label,
                        null,
                        new WorldPoint(x, y, plane),
                        required,
                        any));
    }

    private static void npcPlace(
            List<TargetRule> rules,
            int npcId,
            String label,
            String placeKey,
            String required,
            String... any) {
        rules.add(new TargetRule(TargetKind.NPC, npcId, label, placeKey, null, required, any));
    }

    private static void areaAt(
            List<TargetRule> rules,
            String label,
            int x,
            int y,
            int plane,
            String required,
            String... any) {
        rules.add(
                new TargetRule(
                        TargetKind.AREA,
                        -1,
                        label,
                        null,
                        new WorldPoint(x, y, plane),
                        required,
                        any));
    }

    private static void areaPlace(
            List<TargetRule> rules, String label, String placeKey, String required, String... any) {
        rules.add(new TargetRule(TargetKind.AREA, -1, label, placeKey, null, required, any));
    }

    private static void spawnPlace(
            List<TargetRule> rules, String label, String placeKey, String required, String... any) {
        rules.add(new TargetRule(TargetKind.SPAWN, -1, label, placeKey, null, required, any));
    }

    private static String safe(String value) {
        return value == null ? "" : value.trim();
    }

    private static String normalise(String value) {
        return safe(value).toLowerCase(Locale.ROOT);
    }

    /**
     * Phrase match with alphanumeric boundaries.
     *
     * This deliberately avoids raw String.contains() false positives such as
     * the NPC hint "ned" matching the word "needed".
     */
    static boolean containsHint(String text, String hint) {
        String cleanText = normalise(text);
        String cleanHint = normalise(hint);

        if (cleanText.isEmpty() || cleanHint.isEmpty()) {
            return false;
        }

        int fromIndex = 0;

        while (fromIndex < cleanText.length()) {
            int index = cleanText.indexOf(cleanHint, fromIndex);

            if (index < 0) {
                return false;
            }

            int end = index + cleanHint.length();

            boolean startBoundary =
                    index == 0 || !Character.isLetterOrDigit(cleanText.charAt(index - 1));

            boolean endBoundary =
                    end == cleanText.length() || !Character.isLetterOrDigit(cleanText.charAt(end));

            if (startBoundary && endBoundary) {
                return true;
            }

            fromIndex = index + 1;
        }

        return false;
    }

    private enum TargetKind {
        NPC,
        AREA,
        SPAWN
    }

    private static final class TargetRule {
        private final TargetKind kind;
        private final int npcId;
        private final String label;
        private final String placeKey;
        private final WorldPoint fixedPoint;
        private final String requiredHint;
        private final String[] anyHints;

        private TargetRule(
                TargetKind kind,
                int npcId,
                String label,
                String placeKey,
                WorldPoint fixedPoint,
                String requiredHint,
                String[] anyHints) {
            this.kind = kind;

            this.npcId = npcId;

            this.label = safe(label);

            this.placeKey = safe(placeKey);

            this.fixedPoint = fixedPoint;

            this.requiredHint = normalise(requiredHint);

            this.anyHints = anyHints == null ? new String[0] : anyHints.clone();
        }

        private boolean matchesRegion(GatheringStep step) {
            AcquisitionPlace source =
                    placeKey.isEmpty()
                            ? AcquisitionPlaceDatabase.inferFromText(label)
                            : AcquisitionPlaceDatabase.get(placeKey);
            AcquisitionPlace selected = AcquisitionPlaceDatabase.inferFromText(step.getLocation());
            AcquisitionRegion region = selected == null ? step.getRegion() : selected.getRegion();
            return source == null
                    || region == AcquisitionRegion.ANYWHERE
                    || region == AcquisitionRegion.UNKNOWN
                    || source.getRegion() == region;
        }

        private boolean matches(String text) {
            if (text == null || text.isEmpty()) {
                return false;
            }

            if (!requiredHint.isEmpty() && !containsHint(text, requiredHint)) {
                return false;
            }

            if (anyHints.length == 0) {
                return true;
            }

            for (String hint : anyHints) {
                if (containsHint(text, hint)) {
                    return true;
                }
            }

            return false;
        }

        private GatheringTarget create(GatheringStep step) {
            WorldPoint point = fixedPoint;

            if (point == null && !placeKey.isEmpty()) {
                point = AcquisitionNavigationDatabase.getWorldPoint(placeKey);
            }

            if (point == null) {
                return null;
            }

            if (kind == TargetKind.NPC) {
                return GatheringTarget.npc(npcId, label, point);
            }

            if (kind == TargetKind.SPAWN) {
                int[] ids = step.getItemIds();

                if (ids.length > 0 && step.getMethodType() == AcquisitionInfo.MethodType.SPAWN) {
                    return GatheringTarget.groundItem(ids[0], step.getItemName(), point);
                }
            }

            return GatheringTarget.area(label, point);
        }
    }
}
