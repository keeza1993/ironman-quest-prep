package com.ironquestprep;

import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.gameval.VarbitID;

/**
 * Acquisition eligibility, separate from whether a later quest needs an item.
 * Ordinary supplies remain eligible even if a helper says they CAN be obtained
 * during a quest. Quest-issued steps and locked sources do not become prep routes.
 */
public final class PrepAvailability
{
    interface Progress
    {
        boolean finished(Quest quest);
        int varp(int id);
        int varbit(int id);
    }

    private interface Gate { boolean unlocked(Progress progress); }
    private static final Map<String, Gate> GATES = buildGates();

    private PrepAvailability() { }

    static Progress snapshot(Client client)
    {
        return new Progress()
        {
            private final Map<Quest, Boolean> completed = new EnumMap<>(Quest.class);
            private final Map<Integer, Integer> varps = new HashMap<>();
            private final Map<Integer, Integer> varbits = new HashMap<>();
            private boolean loggedIn() { return client != null && client.getGameState() == GameState.LOGGED_IN; }
            @Override public boolean finished(Quest quest)
            {
                return loggedIn() && completed.computeIfAbsent(quest, q -> q.getState(client) == QuestState.FINISHED);
            }
            @Override public int varp(int id)
            {
                return loggedIn() ? varps.computeIfAbsent(id, client::getVarpValue) : 0;
            }
            @Override public int varbit(int id)
            {
                return loggedIn() ? varbits.computeIfAbsent(id, client::getVarbitValue) : 0;
            }
        };
    }

    static boolean isQuestStep(GeneratedQuestData.RawItem raw)
    {
        String quest = raw.getQuest();
        String source = raw.getItemSource();
        // These are supplied/collected in the originating quest's own steps.
        // Matching source as well as quest also covers synthetic group aliases.
        return ("DragonSlayer".equals(quest) && "ItemCollections.ANTIFIRE_SHIELDS".equals(source))
                || ("TheRestlessGhost".equals(quest) && "ItemID.AMULET_OF_GHOSTSPEAK".equals(source))
                || ("LegendsQuest".equals(quest) && "ItemID.THKARAMJAMAP".equals(source))
                || ("FairytaleI".equals(quest) && "ItemID.FAIRY_SKULL".equals(source))
                || ("ThePathOfGlouphrie".equals(quest) && "ItemID.GOLRIE_KEY_WATERFALL_QUEST".equals(source));
    }

    static boolean canGather(GeneratedQuestData.RawItem raw, RequiredItem item,
                             BankTracker bank, Progress progress)
    {
        if (isQuestStep(raw)) return false;
        Gate gate = GATES.get(raw.getItemSource());
        if (gate == null) return true;
        // An already-satisfied accepted alternative remains visible as owned.
        // Owning only part of a requirement does not prove more can be acquired.
        if (item.isComplete(bank)) return true;
        return gate.unlocked(progress);
    }

    private static Map<String, Gate> buildGates()
    {
        Map<String, Gate> gates = new HashMap<>();
        // Verified early acquisition stages in the local Quest Helper loadSteps.
        add(gates, p -> p.finished(Quest.DRAGON_SLAYER_I) || p.varp(VarPlayerID.DRAGONQUEST) >= 2,
                "ItemCollections.ANTIFIRE_SHIELDS", "ItemID.ANTIDRAGONBREATHSHIELD");
        add(gates, p -> p.finished(Quest.THE_RESTLESS_GHOST) || p.varp(VarPlayerID.PRIESTSTART) >= 1,
                "ItemCollections.GHOSTSPEAK", "ItemID.AMULET_OF_GHOSTSPEAK");
        add(gates, p -> p.finished(Quest.PLAGUE_CITY) || p.varp(VarPlayerID.ELENAQUEST) >= 2,
                "ItemID.GASMASK");
        add(gates, p -> p.finished(Quest.LUNAR_DIPLOMACY) || p.varbit(VarbitID.LUNAR_QUEST_MAIN) >= 10,
                "ItemID.LUNAR_SEAL_OF_PASSAGE");
        add(gates, p -> p.finished(Quest.LEGENDS_QUEST) || p.varp(VarPlayerID.LEGENDSQUEST) >= 1,
                "ItemID.THKARAMJAMAP");
        add(gates, p -> p.varbit(VarbitID._100_PIRATE_QUEST_VAR) >= 40,
                "ItemID.HUNDRED_PIRATE_DIVING_BACKPACK", "ItemID.HUNDRED_PIRATE_DIVING_HELMET");

        // Where an earlier unlock has not been verified, completed origin quest
        // or an already-owned accepted item is the conservative boundary.
        after(gates, Quest.ICTHLARINS_LITTLE_HELPER, "ItemID.ICS_LITTLE_AMULET_OF_CATSPEAK");
        after(gates, Quest.A_TAIL_OF_TWO_CATS, "ItemID.TWOCATS_AMULETOFCATSPEAK");
        after(gates, Quest.MERLINS_CRYSTAL, "ItemID.EXCALIBUR");
        after(gates, Quest.LOST_CITY, "ItemID.DRAMEN_STAFF", "ItemID.DRAMEN_BRANCH", "ItemCollections.FAIRY_STAFF");
        after(gates, Quest.DEATH_PLATEAU, "ItemCollections.CLIMBING_BOOTS", "ItemID.DEATH_CLIMBINGBOOTS", "ItemID.DEATH_SPIKEDBOOTS");
        after(gates, Quest.NATURE_SPIRIT, "ItemID.DRUID_POUCH");
        after(gates, Quest.IN_AID_OF_THE_MYREQUE, "ItemCollections.ROD_OF_IVANDIS");
        after(gates, Quest.A_TASTE_OF_HOPE, "ItemID.IVANDIS_FLAIL");
        after(gates, Quest.SINS_OF_THE_FATHER, "ItemID.BLISTERWOOD_FLAIL",
                "ItemID.VYRELORD_TORSO", "ItemID.VYRELORD_LEGS", "ItemID.VYRELORD_SHOES");
        after(gates, Quest.CREATURE_OF_FENKENSTRAIN, "ItemID.RING_OF_CHAROS");
        after(gates, Quest.GARDEN_OF_TRANQUILLITY, "ItemID.RING_OF_CHAROS_UNLOCKED");
        after(gates, Quest.DESERT_TREASURE_I, "ItemID.FD_RING_VISIBILITY");
        after(gates, Quest.MONKEY_MADNESS_I, "ItemID.MM_AMULET_OF_MONKEY_SPEAK", "ItemID.MM_MONKEY_TALISMAN",
                "ItemID.MM_MONKEY_GREEGREE_FOR_SMALL_NINJA_MONKEY", "ItemID.MM_MONKEY_GREEGREE_FOR_NORMAL_GORILLA",
                "ItemID.MM_MONKEY_GREEGREE_FOR_SMALL_ZOMBIE_MONKEY", "ItemID.MM_MONKEY_NUTS");
        after(gates, Quest.THE_GRAND_TREE, "ItemID.GRANDTREE_TRANSLATIONBOOK");
        after(gates, Quest.WANTED, "ItemID.WANTED_CRYSTAL_BALL");
        after(gates, Quest.BIG_CHOMPY_BIRD_HUNTING, "ItemID.EMPTY_OGRE_BELLOWS", "ItemID.OGRE_BOW", "ItemID.RAW_CHOMPY");
        after(gates, Quest.MOURNINGS_END_PART_I, "ItemID.MOURNING_MOURNER_BOOTS", "ItemID.MOURNING_MOURNER_CLOAK",
                "ItemID.MOURNING_MOURNER_GLOVES", "ItemID.MOURNING_MOURNER_TOP", "ItemID.MOURNING_MOURNER_LEGS");
        after(gates, Quest.THE_FREMENNIK_TRIALS, "ItemID.VT_USELESS_ROCK");
        after(gates, Quest.ONE_SMALL_FAVOUR, "ItemID.FAVOUR_ANIMATE_ROCK");
        return Collections.unmodifiableMap(gates);
    }

    private static void after(Map<String, Gate> gates, Quest quest, String... sources)
    {
        add(gates, p -> p.finished(quest), sources);
    }

    private static void add(Map<String, Gate> gates, Gate gate, String... sources)
    {
        for (String source : sources) gates.put(source, gate);
    }
}
