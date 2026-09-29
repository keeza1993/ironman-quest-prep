package com.ironquestprep;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * AUTO-GENERATED FILE.
 *
 * Item collection data derived from the Quest Helper source checkout.
 * Do not hand-edit this file.
 */
public final class GeneratedItemCollections
{
    private static final Map<String, String[]> COLLECTIONS = build();

    private GeneratedItemCollections()
    {
    }

    public static String[] get(String name)
    {
        String[] values = COLLECTIONS.get(name);

        if (values == null)
        {
            return new String[0];
        }

        return values.clone();
    }

    public static boolean contains(String name)
    {
        return COLLECTIONS.containsKey(name);
    }

    private static Map<String, String[]> build()
    {
        Map<String, String[]> map = new HashMap<>();
        add0(map);
        add1(map);
        add2(map);
        add3(map);
        add4(map);
        add5(map);
        add6(map);

        return Collections.unmodifiableMap(map);
    }

    private static void add0(Map<String, String[]> map)
    {
        map.put("AIR_ALTAR", new String[]
        {
                "ItemID.ELEMENTAL_TALISMAN",
                "ItemID.AIR_TALISMAN"
        });

        map.put("AIR_RUNE", new String[]
        {
                "ItemID.AIRRUNE",
                "ItemID.MISTRUNE",
                "ItemID.SMOKERUNE",
                "ItemID.DUSTRUNE"
        });

        map.put("AIR_STAFF", new String[]
        {
                "ItemID.AIR_BATTLESTAFF",
                "ItemID.MYSTIC_AIR_STAFF",
                "ItemID.STAFF_OF_AIR",
                "ItemID.SMOKE_BATTLESTAFF",
                "ItemID.MYSTIC_SMOKE_BATTLESTAFF",
                "ItemID.DUST_BATTLESTAFF",
                "ItemID.MYSTIC_DUST_BATTLESTAFF",
                "ItemID.MIST_BATTLESTAFF",
                "ItemID.MYSTIC_MIST_BATTLESTAFF"
        });

        map.put("ALLOTMENT_SEEDS", new String[]
        {
                "ItemID.POTATO_SEED",
                "ItemID.ONION_SEED",
                "ItemID.CABBAGE_SEED",
                "ItemID.TOMATO_SEED",
                "ItemID.SWEETCORN_SEED",
                "ItemID.WATERMELON_SEED",
                "ItemID.SNAPE_GRASS_SEED"
        });

        map.put("ANTIFIRE_SHIELDS", new String[]
        {
                "ItemID.DRAGONFIRE_SHIELD",
                "ItemID.DRAGONFIRE_SHIELD_UNCHARGED",
                "ItemID.DRAGONFIRE_WARD",
                "ItemID.DRAGONFIRE_WARD_UNCHARGED",
                "ItemID.WYVERN_SHIELD",
                "ItemID.WYVERN_SHIELD_UNCHARGED",
                "ItemID.ANTIDRAGONBREATHSHIELD",
                "ItemID.POH_TROPHY_ANTIDRAGONBREATH"
        });

        map.put("ANTIPOISONS", new String[]
        {
                "ItemID.ANTIVENOM_4",
                "ItemID.ANTIVENOM_3",
                "ItemID.ANTIVENOM_2",
                "ItemID.ANTIVENOM_1",
                "ItemID.ANTIVENOM4",
                "ItemID.ANTIVENOM3",
                "ItemID.ANTIVENOM2",
                "ItemID.ANTIVENOM1",
                "ItemID.ANTIDOTE__4",
                "ItemID.ANTIDOTE__3",
                "ItemID.ANTIDOTE__2",
                "ItemID.ANTIDOTE__1",
                "ItemID.ANTIDOTE_4",
                "ItemID.ANTIDOTE_3",
                "ItemID.ANTIDOTE_2",
                "ItemID.ANTIDOTE_1",
                "ItemID._4DOSE2ANTIPOISON",
                "ItemID._3DOSE2ANTIPOISON",
                "ItemID._2DOSE2ANTIPOISON",
                "ItemID._1DOSE2ANTIPOISON",
                "ItemID._4DOSEANTIPOISON",
                "ItemID._3DOSEANTIPOISON",
                "ItemID._2DOSEANTIPOISON",
                "ItemID._1DOSEANTIPOISON",
                "ItemID.RELICYMS_BALM4",
                "ItemID.RELICYMS_BALM3",
                "ItemID.RELICYMS_BALM2",
                "ItemID.RELICYMS_BALM1",
                "ItemID.SANFEW_SALVE_4_DOSE",
                "ItemID.SANFEW_SALVE_3_DOSE",
                "ItemID.SANFEW_SALVE_2_DOSE",
                "ItemID.SANFEW_SALVE_1_DOSE",
                "ItemID.BRUTAL_RELICYMS_BALM2",
                "ItemID.BRUTAL_RELICYMS_BALM1",
                "ItemID.BRUTAL_2DOSEANTIPOISON",
                "ItemID.BRUTAL_1DOSEANTIPOISON",
                "ItemID.BRUTAL_ANTIDOTE_2",
                "ItemID.BRUTAL_ANTIDOTE_1"
        });

        map.put("AXES", new String[]
        {
                "ItemID.CRYSTAL_AXE",
                "ItemID.CRYSTAL_AXE_2H",
                "ItemID._3A_AXE",
                "ItemID.LEAGUE_TRAILBLAZER_AXE",
                "ItemID.TRAILBLAZER_AXE",
                "ItemID.INFERNAL_AXE",
                "ItemID.TRAILBLAZER_AXE_EMPTY",
                "ItemID.INFERNAL_AXE_EMPTY",
                "ItemID.TRAILBLAZER_AXE_NO_INFERNAL",
                "ItemID.DRAGON_AXE",
                "ItemID.DRAGON_AXE_2H",
                "ItemID.RUNE_AXE",
                "ItemID.RUNE_AXE_2H",
                "ItemID.TRAIL_GILDED_AXE",
                "ItemID.ADAMANT_AXE",
                "ItemID.ADAMANT_AXE_2H",
                "ItemID.MITHRIL_AXE",
                "ItemID.MITHRIL_AXE_2H",
                "ItemID.BLACK_AXE",
                "ItemID.BLACK_AXE_2H",
                "ItemID.STEEL_AXE",
                "ItemID.STEEL_AXE_2H",
                "ItemID.IRON_AXE",
                "ItemID.IRON_AXE_2H",
                "ItemID.BRONZE_AXE",
                "ItemID.BRONZE_AXE_2H"
        });

        map.put("BOWS", new String[]
        {
                "ItemID.MAGIC_SHORTBOW",
                "ItemID.MAGIC_SHORTBOW_I",
                "ItemID.DARKBOW",
                "ItemID.MAGIC_LONGBOW",
                "ItemID.YEW_SHORTBOW",
                "ItemID.YEW_LONGBOW",
                "ItemID.MAPLE_SHORTBOW",
                "ItemID.MAPLE_LONGBOW",
                "ItemID.WILLOW_SHORTBOW",
                "ItemID.WILLOW_LONGBOW",
                "ItemID.OAK_SHORTBOW",
                "ItemID.OAK_LONGBOW",
                "ItemID.SHORTBOW",
                "ItemID.LONGBOW"
        });

    }

    private static void add1(Map<String, String[]> map)
    {
        map.put("BUSH_SEEDS", new String[]
        {
                "ItemID.REDBERRY_BUSH_SEED",
                "ItemID.CADAVABERRY_BUSH_SEED",
                "ItemID.DWELLBERRY_BUSH_SEED",
                "ItemID.JANGERBERRY_BUSH_SEED",
                "ItemID.WHITEBERRY_BUSH_SEED",
                "ItemID.POISONIVY_BUSH_SEED"
        });

        map.put("CHAOS_ALTAR", new String[]
        {
                "ItemID.TIARA_CATALYTIC",
                "ItemID.CATALYTIC_TALISMAN",
                "ItemID.TIARA_CHAOS",
                "ItemID.CHAOS_TALISMAN"
        });

        map.put("CHISEL", new String[]
        {
                "ItemID.CHISEL",
                "ItemID.JEWELLERS_CHISEL"
        });

        map.put("CLIMBING_BOOTS", new String[]
        {
                "ItemID.DEATH_CLIMBINGBOOTS",
                "ItemID.CLIMBING_BOOTS_G"
        });

        map.put("COINS", new String[]
        {
                "ItemID.COINS",
                "ItemID.MAGICTRAINING_COINS",
                "ItemID.CERT_ROLL"
        });

        map.put("CROSSBOWS", new String[]
        {
                "ItemID.ZARYTE_XBOW",
                "ItemID.ACB",
                "ItemID.DRAGONHUNTER_XBOW",
                "ItemID.HUNTING_CROSSBOW_SUNLIGHT",
                "ItemID.HUNTING_CROSSBOW",
                "ItemID.DTTD_BONE_CROSSBOW",
                "ItemID.XBOWS_CROSSBOW_BLURITE",
                "ItemID.XBOWS_CROSSBOW_DRAGON",
                "ItemID.LEAGUE_3_RUNE_XBOW",
                "ItemID.XBOWS_CROSSBOW_RUNITE",
                "ItemID.XBOWS_CROSSBOW_ADAMANTITE",
                "ItemID.XBOWS_CROSSBOW_MITHRIL",
                "ItemID.XBOWS_CROSSBOW_STEEL",
                "ItemID.XBOWS_CROSSBOW_IRON",
                "ItemID.XBOWS_CROSSBOW_BRONZE",
                "ItemID.PHOENIX_CROSSBOW",
                "ItemID.CROSSBOW"
        });

        map.put("DARTS", new String[]
        {
                "ItemID.BRONZE_DART",
                "ItemID.BRONZE_DART_P",
                "ItemID.BRONZE_DART_P_",
                "ItemID.BRONZE_DART_P__",
                "ItemID.IRON_DART",
                "ItemID.IRON_DART_P",
                "ItemID.IRON_DART_P_",
                "ItemID.IRON_DART_P__",
                "ItemID.STEEL_DART",
                "ItemID.STEEL_DART_P",
                "ItemID.STEEL_DART_P_",
                "ItemID.STEEL_DART_P__",
                "ItemID.BLACK_DART",
                "ItemID.BLACK_DART_P",
                "ItemID.BLACK_DART_P_",
                "ItemID.BLACK_DART_P__",
                "ItemID.MITHRIL_DART",
                "ItemID.MITHRIL_DART_P",
                "ItemID.MITHRIL_DART_P_",
                "ItemID.MITHRIL_DART_P__",
                "ItemID.ADAMANT_DART",
                "ItemID.ADAMANT_DART_P",
                "ItemID.ADAMANT_DART_P_",
                "ItemID.ADAMANT_DART_P__",
                "ItemID.RUNE_DART",
                "ItemID.RUNE_DART_P",
                "ItemID.RUNE_DART_P_",
                "ItemID.RUNE_DART_P__",
                "ItemID.AMETHYST_DART",
                "ItemID.AMETHYST_DART_P",
                "ItemID.AMETHYST_DART_P_",
                "ItemID.AMETHYST_DART_P__",
                "ItemID.DRAGON_DART",
                "ItemID.DRAGON_DART_P",
                "ItemID.DRAGON_DART_P_",
                "ItemID.DRAGON_DART_P__"
        });

        map.put("DEATH_ALTAR", new String[]
        {
                "ItemID.TIARA_DEATH",
                "ItemID.DEATH_TALISMAN",
                "ItemID.CATALYTIC_TALISMAN",
                "ItemID.TIARA_CATALYTIC"
        });

    }

    private static void add2(Map<String, String[]> map)
    {
        map.put("EARTH_ALTAR", new String[]
        {
                "ItemID.ELEMENTAL_TALISMAN",
                "ItemID.EARTH_TALISMAN"
        });

        map.put("EARTH_STAFF", new String[]
        {
                "ItemID.EARTH_BATTLESTAFF",
                "ItemID.MYSTIC_EARTH_STAFF",
                "ItemID.STAFF_OF_EARTH",
                "ItemID.MUD_BATTLESTAFF",
                "ItemID.MYSTIC_MUD_STAFF",
                "ItemID.DUST_BATTLESTAFF",
                "ItemID.MYSTIC_DUST_BATTLESTAFF",
                "ItemID.LAVA_BATTLESTAFF",
                "ItemID.MYSTIC_LAVA_STAFF"
        });

        map.put("FAIRY_STAFF", new String[]
        {
                "ItemID.LUNAR_MOONCLAN_LIMINAL_STAFF",
                "ItemID.DRAMEN_STAFF_WATER",
                "ItemID.DRAMEN_STAFF_FIRE",
                "ItemID.DRAMEN_STAFF_AIR",
                "ItemID.DRAMEN_STAFF"
        });

        map.put("FIRE_ALTAR", new String[]
        {
                "ItemID.ELEMENTAL_TALISMAN",
                "ItemID.FIRE_TALISMAN"
        });

        map.put("FIRE_RUNE", new String[]
        {
                "ItemID.FIRERUNE",
                "ItemID.LAVARUNE",
                "ItemID.SMOKERUNE",
                "ItemID.STEAMRUNE"
        });

        map.put("FIRE_STAFF", new String[]
        {
                "ItemID.FIRE_BATTLESTAFF",
                "ItemID.MYSTIC_FIRE_STAFF",
                "ItemID.STAFF_OF_FIRE",
                "ItemID.SMOKE_BATTLESTAFF",
                "ItemID.MYSTIC_SMOKE_BATTLESTAFF",
                "ItemID.LAVA_BATTLESTAFF",
                "ItemID.MYSTIC_LAVA_STAFF",
                "ItemID.STEAM_BATTLESTAFF",
                "ItemID.MYSTIC_STEAM_BATTLESTAFF"
        });

        map.put("FISH_FOOD", new String[]
        {
                "ItemID.DARK_CRAB",
                "ItemID.MANTARAY",
                "ItemID.ANGLERFISH",
                "ItemID.SEATURTLE",
                "ItemID.SHARK",
                "ItemID.TBWT_COOKED_KARAMBWAN",
                "ItemID.MONKFISH",
                "ItemID._100_JUBBLY_MEAT_COOKED",
                "ItemID.LAVA_EEL",
                "ItemID.SWORDFISH",
                "ItemID.BASS",
                "ItemID.LOBSTER",
                "ItemID.HUNTING_FISH_SPECIAL",
                "ItemID.TUNA",
                "ItemID.CAVE_EEL",
                "ItemID.SALMON",
                "ItemID.PIKE",
                "ItemID.COD",
                "ItemID.TROUT",
                "ItemID.MACKEREL",
                "ItemID.HERRING",
                "ItemID.SARDINE",
                "ItemID.SHRIMP"
        });

        map.put("FLOWER_SEEDS", new String[]
        {
                "ItemID.MARIGOLD_SEED",
                "ItemID.ROSEMARY_SEED",
                "ItemID.NASTURTIUM_SEED",
                "ItemID.WOAD_SEED",
                "ItemID.LIMPWURT_SEED",
                "ItemID.WHITE_LILY_SEED"
        });

    }

    private static void add3(Map<String, String[]> map)
    {
        map.put("FLOWERS", new String[]
        {
                "ItemID.FLOWERS_WATERFALL_QUEST_RED",
                "ItemID.FLOWERS_WATERFALL_QUEST_YELLOW",
                "ItemID.FLOWERS_WATERFALL_QUEST_PURPLE",
                "ItemID.FLOWERS_WATERFALL_QUEST_ORANGE",
                "ItemID.FLOWERS_WATERFALL_QUEST_MIXED",
                "ItemID.FLOWERS_WATERFALL_QUEST",
                "ItemID.FLOWERS_WATERFALL_QUEST_BLACK",
                "ItemID.FLOWERS_WATERFALL_QUEST_WHITE",
                "ItemID.BREW_RED_FLOWER",
                "ItemID.BREW_BLUE_FLOWER"
        });

        map.put("FRUIT_TREE_SAPLINGS", new String[]
        {
                "ItemID.PLANTPOT_APPLE_SAPLING",
                "ItemID.PLANTPOT_BANANA_SAPLING",
                "ItemID.PLANTPOT_ORANGE_SAPLING",
                "ItemID.PLANTPOT_CURRY_SAPLING",
                "ItemID.PLANTPOT_PINEAPPLE_SAPLING",
                "ItemID.PLANTPOT_PAPAYA_SAPLING",
                "ItemID.PLANTPOT_PALM_SAPLING",
                "ItemID.PLANTPOT_DRAGONFRUIT_SAPLING"
        });

        map.put("GHOSTSPEAK", new String[]
        {
                "ItemID.AMULET_OF_GHOSTSPEAK",
                "ItemID.AMULET_OF_GHOSTSPEAK_ENCHANTED",
                "ItemID.MORYTANIA_LEGS_MEDIUM",
                "ItemID.MORYTANIA_LEGS_HARD",
                "ItemID.MORYTANIA_LEGS_ELITE"
        });

        map.put("GOOD_EATING_FOOD", new String[]
        {
                "ItemID.DARK_CRAB",
                "ItemID.POTATO_TUNA_SWEETCORN",
                "ItemID.MANTARAY",
                "ItemID.SEATURTLE",
                "ItemID.PINEAPPLE_PIZZA",
                "ItemID.SHARK",
                "ItemID.POTATO_MUSHROOM_ONION",
                "ItemID.UGTHANKI_KEBAB_BAD",
                "ItemID.CURRY",
                "ItemID.TBWT_COOKED_KARAMBWAN",
                "ItemID.ANCHOVIE_PIZZA",
                "ItemID.ANGLERFISH",
                "ItemID.MONKFISH",
                "ItemID.POTATO_CHEESE",
                "ItemID.MEAT_PIZZA",
                "ItemID.POTATO_BUTTER",
                "ItemID.SWORDFISH",
                "ItemID.PLAIN_PIZZA",
                "ItemID.BASS",
                "ItemID.LOBSTER",
                "ItemID.CHOCOLATE_CAKE",
                "ItemID.CAKE",
                "ItemID.STEW",
                "ItemID.TUNA",
                "ItemID.SALMON",
                "ItemID.PIKE",
                "ItemID.COD",
                "ItemID.TROUT",
                "ItemID.MACKEREL",
                "ItemID.HERRING",
                "ItemID.BREAD",
                "ItemID.SARDINE",
                "ItemID.COOKED_MEAT",
                "ItemID.COOKED_CHICKEN",
                "ItemID.SHRIMP"
        });

        map.put("GRACEFUL_GLOVES", new String[]
        {
                "ItemID.GRACEFUL_GLOVES",
                "ItemID.GRACEFUL_GLOVES_WORN",
                "ItemID.ZEAH_GRACEFUL_GLOVES_ARCEUUS",
                "ItemID.ZEAH_GRACEFUL_GLOVES_ARCEUUS_WORN",
                "ItemID.ZEAH_GRACEFUL_GLOVES_PISCARILIUS",
                "ItemID.ZEAH_GRACEFUL_GLOVES_PISCARILIUS_WORN",
                "ItemID.ZEAH_GRACEFUL_GLOVES_LOVAKENGJ",
                "ItemID.ZEAH_GRACEFUL_GLOVES_LOVAKENGJ_WORN",
                "ItemID.ZEAH_GRACEFUL_GLOVES_SHAYZIEN",
                "ItemID.ZEAH_GRACEFUL_GLOVES_SHAYZIEN_WORN",
                "ItemID.ZEAH_GRACEFUL_GLOVES_HOSIDIUS",
                "ItemID.ZEAH_GRACEFUL_GLOVES_HOSIDIUS_WORN",
                "ItemID.ZEAH_GRACEFUL_GLOVES_KOUREND",
                "ItemID.ZEAH_GRACEFUL_GLOVES_KOUREND_WORN",
                "ItemID.GRACEFUL_GLOVES_SKILLCAPECOLOUR",
                "ItemID.GRACEFUL_GLOVES_SKILLCAPECOLOUR_WORN",
                "ItemID.GRACEFUL_GLOVES_HALLOWED",
                "ItemID.GRACEFUL_GLOVES_HALLOWED_WORN",
                "ItemID.GRACEFUL_GLOVES_TRAILBLAZER",
                "ItemID.GRACEFUL_GLOVES_TRAILBLAZER_WORN",
                "ItemID.GRACEFUL_GLOVES_ADVENTURER",
                "ItemID.GRACEFUL_GLOVES_ADVENTURER_WORN"
        });

        map.put("HAMMER", new String[]
        {
                "ItemID.HAMMER",
                "ItemID.IMCANDO_HAMMER",
                "ItemID.IMCANDO_HAMMER_OFFHAND"
        });

        map.put("HERB_SEEDS", new String[]
        {
                "ItemID.GUAM_SEED",
                "ItemID.MARRENTILL_SEED",
                "ItemID.TARROMIN_SEED",
                "ItemID.HARRALANDER_SEED",
                "ItemID.RANARR_SEED",
                "ItemID.TOADFLAX_SEED",
                "ItemID.IRIT_SEED",
                "ItemID.AVANTOE_SEED",
                "ItemID.KWUARM_SEED",
                "ItemID.SNAPDRAGON_SEED",
                "ItemID.HUASCA_SEED",
                "ItemID.CADANTINE_SEED",
                "ItemID.LANTADYME_SEED",
                "ItemID.DWARF_WEED_SEED",
                "ItemID.TORSTOL_SEED"
        });

        map.put("HOPS_SEEDS", new String[]
        {
                "ItemID.BARLEY_SEED",
                "ItemID.HAMMERSTONE_HOP_SEED",
                "ItemID.ASGARNIAN_HOP_SEED",
                "ItemID.JUTE_SEED",
                "ItemID.YANILLIAN_HOP_SEED",
                "ItemID.KRANDORIAN_HOP_SEED",
                "ItemID.WILDBLOOD_HOP_SEED"
        });

    }

    private static void add4(Map<String, String[]> map)
    {
        map.put("LIGHT_SOURCES", new String[]
        {
                "ItemID.SKILLCAPE_FIREMAKING_TRIMMED",
                "ItemID.SKILLCAPE_FIREMAKING",
                "ItemID.SKILLCAPE_MAX",
                "ItemID.WINT_TORCH",
                "ItemID.WINT_TORCH_OFFHAND",
                "ItemID.SEERS_HEADBAND_ELITE",
                "ItemID.SEERS_HEADBAND_HARD",
                "ItemID.SEERS_HEADBAND_MEDIUM",
                "ItemID.SEERS_HEADBAND_EASY",
                "ItemID.BULLSEYE_LANTERN_LIT",
                "ItemID.TOG_SAPPHIRE_LANTERN_LIT",
                "ItemID.BULLSEYE_LANTERN_LIT_LUNAR_QUEST",
                "ItemID.OIL_LANTERN_LIT",
                "ItemID.CANDLE_LANTERN_LIT",
                "ItemID.CANDLE_LANTERN_BLACK_LIT",
                "ItemID.CAVE_GOBLIN_MINING_HELMET_LIT",
                "ItemID.OIL_LAMP_LIT",
                "ItemID.TORCH_LIT",
                "ItemID.LIT_CANDLE",
                "ItemID.LIT_BLACK_CANDLE",
                "ItemID.ABYSSAL_LANTERN_NORMAL",
                "ItemID.ABYSSAL_LANTERN_NORMAL_BLUE",
                "ItemID.ABYSSAL_LANTERN_NORMAL_RED",
                "ItemID.ABYSSAL_LANTERN_NORMAL_WHITE",
                "ItemID.ABYSSAL_LANTERN_NORMAL_PURPLE",
                "ItemID.ABYSSAL_LANTERN_NORMAL_GREEN",
                "ItemID.ABYSSAL_LANTERN_OAK",
                "ItemID.ABYSSAL_LANTERN_WILLOW",
                "ItemID.ABYSSAL_LANTERN_MAPLE",
                "ItemID.ABYSSAL_LANTERN_YEW",
                "ItemID.ABYSSAL_LANTERN_BLISTERWOOD",
                "ItemID.ABYSSAL_LANTERN_MAGIC",
                "ItemID.ABYSSAL_LANTERN_REDWOOD",
                "ItemID.LEAGUE_CLUE_COMPASS_TELEPORT"
        });

        map.put("LOGS_FOR_FIRE", new String[]
        {
                "ItemID.LOGS",
                "ItemID.OAK_LOGS",
                "ItemID.WILLOW_LOGS",
                "ItemID.TEAK_LOGS",
                "ItemID.REDWOOD_LOGS",
                "ItemID.MAPLE_LOGS",
                "ItemID.MAHOGANY_LOGS",
                "ItemID.YEW_LOGS",
                "ItemID.MAGIC_LOGS",
                "ItemID.BLISTERWOOD_LOGS",
                "ItemID.ARCTIC_PINE_LOG",
                "ItemID.ACHEY_TREE_LOGS",
                "ItemID.REDWOOD_LOGS_PYRE",
                "ItemID.MAGIC_LOGS_PYRE",
                "ItemID.YEW_LOGS_PYRE",
                "ItemID.MAHOGANY_LOGS_PYRE",
                "ItemID.MAPLE_LOGS_PYRE",
                "ItemID.ARCTIC_PINE_LOGS_PYRE",
                "ItemID.TEAK_LOGS_PYRE",
                "ItemID.WILLOW_LOGS_PYRE",
                "ItemID.OAK_LOGS_PYRE",
                "ItemID.LOGS_PYRE",
                "ItemID.GREEN_LOGS",
                "ItemID.RED_LOGS",
                "ItemID.TRAIL_LOGS_PURPLE",
                "ItemID.TRAIL_LOGS_WHITE",
                "ItemID.BLUE_LOGS"
        });

        map.put("MACHETE", new String[]
        {
                "ItemID.MACHETTE_REDTOPAZ",
                "ItemID.MACHETTE_JADE",
                "ItemID.MACHETTE_OPAL",
                "ItemID.MACHETTE"
        });

        map.put("METAL_ARROWS", new String[]
        {
                "ItemID.RUNE_ARROW",
                "ItemID.ADAMANT_ARROW",
                "ItemID.MITHRIL_ARROW",
                "ItemID.STEEL_ARROW",
                "ItemID.IRON_ARROW",
                "ItemID.BRONZE_ARROW"
        });

        map.put("MIND_ALTAR", new String[]
        {
                "ItemID.CATALYTIC_TALISMAN",
                "ItemID.MIND_TALISMAN"
        });

        map.put("NAILS", new String[]
        {
                "ItemID.NAILS",
                "ItemID.NAILS_IRON",
                "ItemID.NAILS_BRONZE",
                "ItemID.NAILS_BLACK",
                "ItemID.NAILS_MITHRIL",
                "ItemID.NAILS_ADAMANT",
                "ItemID.NAILS_RUNE"
        });

        map.put("PICKAXES", new String[]
        {
                "ItemID.TRAILBLAZER_PICKAXE",
                "ItemID.LEAGUE_TRAILBLAZER_PICKAXE",
                "ItemID.CRYSTAL_PICKAXE",
                "ItemID.CRYSTAL_PICKAXE_INACTIVE",
                "ItemID._3A_PICKAXE",
                "ItemID.INFERNAL_PICKAXE",
                "ItemID.TRAILBLAZER_PICKAXE_NO_INFERNAL",
                "ItemID.DRAGON_PICKAXE_PRETTY",
                "ItemID.ZALCANO_PICKAXE",
                "ItemID.DRAGON_PICKAXE",
                "ItemID.RUNE_PICKAXE",
                "ItemID.TRAIL_GILDED_PICKAXE",
                "ItemID.ADAMANT_PICKAXE",
                "ItemID.MITHRIL_PICKAXE",
                "ItemID.BLACK_PICKAXE",
                "ItemID.STEEL_PICKAXE",
                "ItemID.IRON_PICKAXE",
                "ItemID.BRONZE_PICKAXE"
        });

        map.put("PRAYER_POTIONS", new String[]
        {
                "ItemID._4DOSEPRAYERRESTORE",
                "ItemID._3DOSEPRAYERRESTORE",
                "ItemID._2DOSEPRAYERRESTORE",
                "ItemID._1DOSEPRAYERRESTORE",
                "ItemID._4DOSE2RESTORE",
                "ItemID._3DOSE2RESTORE",
                "ItemID._2DOSE2RESTORE",
                "ItemID._1DOSE2RESTORE",
                "ItemID.HUNTER_MIX_MOONMOTH_2DOSE",
                "ItemID.HUNTER_MIX_MOONMOTH_1DOSE",
                "ItemID.BUTTERFLY_JAR_MOONMOTH"
        });

    }

    private static void add5(Map<String, String[]> map)
    {
        map.put("QUICKLIME_GLOVES", new String[]
        {
                "ItemID.FEROCIOUS_GLOVES",
                "ItemID.HUNDRED_GAUNTLETS_LEVEL_10",
                "ItemID.HUNDRED_GAUNTLETS_LEVEL_9",
                "ItemID.GRANITE_GLOVES",
                "ItemID.HUNDRED_GAUNTLETS_LEVEL_8",
                "ItemID.HUNDRED_GAUNTLETS_LEVEL_7",
                "ItemID.HUNDRED_GAUNTLETS_LEVEL_6",
                "ItemID.HUNDRED_GAUNTLETS_LEVEL_5",
                "ItemID.HUNDRED_GAUNTLETS_LEVEL_4",
                "ItemID.HUNDRED_GAUNTLETS_LEVEL_3",
                "ItemID.HUNDRED_GAUNTLETS_LEVEL_2",
                "ItemID.ANTISANTA_GLOVES",
                "ItemID.WOLFENGLOVES_GREY",
                "ItemID.WOLFENGLOVES_CRIMSON",
                "ItemID.WOLFENGLOVES_TANGERINE",
                "ItemID.WOLFENGLOVES_OCEAN",
                "ItemID.WOLFENGLOVES_PURPLE",
                "ItemID.COW_GLOVES",
                "ItemID.VIKINGGLOVES",
                "ItemID.HUNTING_SILENT_GLOVES",
                "ItemID.SECRET_GHOST_GLOVES",
                "ItemID.HUNDRED_GAUNTLETS_LEVEL_1",
                "ItemID.HAM_GLOVES",
                "ItemID.ICE_GLOVES",
                "ItemID.MAGICTRAINING_INFINITYGLOVES",
                "ItemID.LEATHER_GLOVES",
                "ItemID.LUNAR_GLOVES",
                "ItemID.MACRO_MIME_GLOVES",
                "ItemID.LUNAR_MOONCLAN_GLOVES",
                "ItemID.MOURNING_MOURNER_GLOVES",
                "ItemID.MYSTIC_GLOVES",
                "ItemID.MYSTIC_GLOVES_DARK",
                "ItemID.MYSTIC_GLOVES_DUSK",
                "ItemID.MYSTIC_GLOVES_LIGHT",
                "ItemID.BARBASSAULT_PENANCE_GLOVES",
                "ItemID.DAGGANOTH_MELEE_GLOVES",
                "ItemID.ROGUESDEN_GLOVES",
                "ItemID.SANTA_GLOVES",
                "ItemID.SLAYERGUIDE_SLAYER_GLOVES",
                "ItemID.DAGGANOTH_RANGE_GLOVES",
                "ItemID.PEST_VOID_KNIGHT_GLOVES",
                "ItemID.WHITE_GLOVES",
                "ItemID.MACRO_DIGGER_GLOVES",
                "ItemID.ANCIENT_CEREMONIAL_GLOVES",
                "ItemID.BLOODBARK_GAUNTLETS",
                "ItemID.EASTER16_ONSIE_GLOVES",
                "ItemID.GAUNTLETS_OF_CHAOS",
                "ItemID.CLUE_HUNTER_GLOVES",
                "ItemID.GAUNTLETS_OF_COOKING",
                "ItemID.HUNDRED_PIRATE_CRAB_SHELL_GAUNTLET",
                "ItemID.PIRATE_CRABCLAW_HOOK",
                "ItemID.DRAGONSTONE_GAUNTLETS",
                "ItemID.MGUILD_GLOVES_EXPERT",
                "ItemID.TRAIL_GILDED_DHIDE_VAMBRACES",
                "ItemID.ROBE_DARKNESS_HANDS",
                "ItemID.GAUNTLETS_OF_GOLDSMITHING",
                "ItemID.GROUP_IRONMAN_GLOVES",
                "ItemID.GROUP_IRONMAN_GLOVES_UNRANKED",
                "ItemID.HARDCORE_GROUP_IRONMAN_GLOVES",
                "ItemID.HOLY_WRAPS",
                "ItemID.KLANKS_GAUNTLETS",
                "ItemID.MGUILD_GLOVES",
                "ItemID.ORNATE_GLOVES",
                "ItemID.PIRATEHOOK",
                "ItemID.RANGER_GLOVES",
                "ItemID.JEWL_BRACELET_REGEN",
                "ItemID.SAMURAI_GLOVES",
                "ItemID.SHAYZIEN_GLOVES_5",
                "ItemID.SHAYZIEN_GLOVES_4",
                "ItemID.SHAYZIEN_GLOVES_3",
                "ItemID.SHAYZIEN_GLOVES_2",
                "ItemID.SHAYZIEN_GLOVES_1",
                "ItemID.XMAS17_EVENT_IMP_GLOVES",
                "ItemID.SPLITBARK_GAUNTLETS",
                "ItemID.HW19_GHOST_GLOVES_SLIME",
                "ItemID.HW19_GHOST_GLOVES_TEMP",
                "ItemID.STEEL_GAUNTLETS",
                "ItemID.MGUILD_GLOVES_SUPERIOR",
                "ItemID.SWAMPBARK_GAUNTLETS",
                "ItemID.PYROMANCER_GLOVES",
                "ItemID.ZARYTE_VAMBRACES",
                "ItemID.SMITHING_UNIFORM_GLOVES_ICE",
                "ItemID.ATJUN_GLOVES_ELITE",
                "ItemID.ATJUN_GLOVES_HARD",
                "ItemID.ATJUN_GLOVES_MED",
                "ItemID.ATJUN_GLOVES_EASY"
        });

        map.put("RAW_FISH", new String[]
        {
                "ItemID.RAW_SHRIMP",
                "ItemID.RAW_SARDINE",
                "ItemID.TBWT_RAW_KARAMBWANJI",
                "ItemID.RAW_HERRING",
                "ItemID.RAW_ANCHOVIES",
                "ItemID.RAW_MACKEREL",
                "ItemID.RAW_TROUT",
                "ItemID.RAW_COD",
                "ItemID.RAW_PIKE",
                "ItemID.MORT_SLIMEY_EEL",
                "ItemID.RAW_SALMON",
                "ItemID.RAW_TUNA",
                "ItemID.HUNTING_RAW_FISH_SPECIAL",
                "ItemID.RAW_CAVE_EEL",
                "ItemID.RAW_LOBSTER",
                "ItemID.RAW_BASS",
                "ItemID.RAW_SWORDFISH",
                "ItemID.RAW_LAVA_EEL",
                "ItemID.RAW_MONKFISH",
                "ItemID.TBWT_RAW_KARAMBWAN",
                "ItemID.RAW_SHARK",
                "ItemID.RAW_SEATURTLE",
                "ItemID.RAW_MANTARAY",
                "ItemID.RAW_ANGLERFISH",
                "ItemID.RAW_DARK_CRAB"
        });

        map.put("RESTORE_POTIONS", new String[]
        {
                "ItemID._4DOSE2RESTORE",
                "ItemID._3DOSE2RESTORE",
                "ItemID._2DOSE2RESTORE",
                "ItemID._1DOSE2RESTORE",
                "ItemID._4DOSESTATRESTORE",
                "ItemID._3DOSESTATRESTORE",
                "ItemID._2DOSESTATRESTORE",
                "ItemID._1DOSESTATRESTORE"
        });

        map.put("ROD_OF_IVANDIS", new String[]
        {
                "ItemID.BURGH_ROD_COMMAND_FINAL_10",
                "ItemID.BURGH_ROD_COMMAND_FINAL_9",
                "ItemID.BURGH_ROD_COMMAND_FINAL_8",
                "ItemID.BURGH_ROD_COMMAND_FINAL_7",
                "ItemID.BURGH_ROD_COMMAND_FINAL_6",
                "ItemID.BURGH_ROD_COMMAND_FINAL_5",
                "ItemID.BURGH_ROD_COMMAND_FINAL_4",
                "ItemID.BURGH_ROD_COMMAND_FINAL_3",
                "ItemID.BURGH_ROD_COMMAND_FINAL_2",
                "ItemID.BURGH_ROD_COMMAND_FINAL_1"
        });

        map.put("SAW", new String[]
        {
                "ItemID.POH_SAW",
                "ItemID.WEARABLE_SAW",
                "ItemID.WEARABLE_SAW_OFFHAND",
                "ItemID.EYEGLO_CRYSTAL_SAW"
        });

        map.put("SLASH_WEB_KNIFE", new String[]
        {
                "ItemID.KNIFE",
                "ItemID.WILDERNESS_SWORD_ELITE",
                "ItemID.WILDERNESS_SWORD_HARD",
                "ItemID.WILDERNESS_SWORD_MEDIUM",
                "ItemID.WILDERNESS_SWORD_EASY"
        });

        map.put("SLAYER_HELMETS", new String[]
        {
                "ItemID.SLAYER_HELM",
                "ItemID.SLAYER_HELM_I",
                "ItemID.SW_SLAYER_HELM_I",
                "ItemID.PVPA_SLAYER_HELM_I",
                "ItemID.SLAYER_HELM_BLACK",
                "ItemID.SLAYER_HELM_I_BLACK",
                "ItemID.SW_SLAYER_HELM_I_BLACK",
                "ItemID.PVPA_SLAYER_HELM_I_BLACK",
                "ItemID.SLAYER_HELM_GREEN",
                "ItemID.SLAYER_HELM_I_GREEN",
                "ItemID.SW_SLAYER_HELM_I_GREEN",
                "ItemID.PVPA_SLAYER_HELM_I_GREEN",
                "ItemID.SLAYER_HELM_RED",
                "ItemID.SLAYER_HELM_I_RED",
                "ItemID.SW_SLAYER_HELM_I_RED",
                "ItemID.PVPA_SLAYER_HELM_I_RED",
                "ItemID.SLAYER_HELM_PURPLE",
                "ItemID.SLAYER_HELM_I_PURPLE",
                "ItemID.SW_SLAYER_HELM_I_PURPLE",
                "ItemID.PVPA_SLAYER_HELM_I_PURPLE",
                "ItemID.SLAYER_HELM_TURQUOISE",
                "ItemID.SLAYER_HELM_I_TURQUOISE",
                "ItemID.SW_SLAYER_HELM_I_TURQUOISE",
                "ItemID.PVPA_SLAYER_HELM_I_TURQUOISE",
                "ItemID.SLAYER_HELM_HYDRA",
                "ItemID.SLAYER_HELM_I_HYDRA",
                "ItemID.SW_SLAYER_HELM_I_HYDRA",
                "ItemID.PVPA_SLAYER_HELM_I_HYDRA",
                "ItemID.SLAYER_HELM_TWISTED",
                "ItemID.SLAYER_HELM_I_TWISTED",
                "ItemID.SW_SLAYER_HELM_I_TWISTED",
                "ItemID.PVPA_SLAYER_HELM_I_TWISTED",
                "ItemID.SLAYER_HELM_ZUK",
                "ItemID.SLAYER_HELM_I_ZUK",
                "ItemID.SW_SLAYER_HELM_I_ZUK",
                "ItemID.PVPA_SLAYER_HELM_I_ZUK",
                "ItemID.SLAYER_HELM_VERZIK",
                "ItemID.SLAYER_HELM_I_VERZIK",
                "ItemID.SW_SLAYER_HELM_I_VERZIK",
                "ItemID.PVPA_SLAYER_HELM_I_VERZIK",
                "ItemID.SLAYER_HELM_JAD",
                "ItemID.SLAYER_HELM_I_JAD",
                "ItemID.SW_SLAYER_HELM_I_JAD",
                "ItemID.PVPA_SLAYER_HELM_I_JAD"
        });

        map.put("SWORDS", new String[]
        {
                "ItemID.AIDE_SHORTSWORD",
                "ItemID.BRONZE_SWORD",
                "ItemID.BRONZE_LONGSWORD",
                "ItemID.IRON_SWORD",
                "ItemID.IRON_LONGSWORD",
                "ItemID.STEEL_SWORD",
                "ItemID.STEEL_LONGSWORD",
                "ItemID.BLACK_SWORD",
                "ItemID.BLACK_LONGSWORD",
                "ItemID.WHITE_SWORD",
                "ItemID.WHITE_LONGSWORD",
                "ItemID.MITHRIL_SWORD",
                "ItemID.MITHRIL_LONGSWORD",
                "ItemID.ADAMANT_SWORD",
                "ItemID.ADAMANT_LONGSWORD",
                "ItemID.WILDERNESS_SWORD_EASY",
                "ItemID.WILDERNESS_SWORD_MEDIUM",
                "ItemID.WILDERNESS_SWORD_HARD",
                "ItemID.WILDERNESS_SWORD_ELITE"
        });

    }

    private static void add6(Map<String, String[]> map)
    {
        map.put("THROWING_AXES", new String[]
        {
                "ItemID.BRONZE_THROWNAXE",
                "ItemID.IRON_THROWNAXE",
                "ItemID.STEEL_THROWNAXE",
                "ItemID.MITHRIL_THROWNAXE",
                "ItemID.ADAMNT_THROWNAXE",
                "ItemID.RUNE_THROWNAXE",
                "ItemID.DRAGON_THROWNAXE"
        });

        map.put("THROWING_KNIVES", new String[]
        {
                "ItemID.BRONZE_KNIFE",
                "ItemID.BRONZE_KNIFE_P",
                "ItemID.BRONZE_KNIFE_P_",
                "ItemID.BRONZE_KNIFE_P__",
                "ItemID.IRON_KNIFE",
                "ItemID.IRON_KNIFE_P",
                "ItemID.IRON_KNIFE_P_",
                "ItemID.IRON_KNIFE_P__",
                "ItemID.STEEL_KNIFE",
                "ItemID.STEEL_KNIFE_P",
                "ItemID.STEEL_KNIFE_P_",
                "ItemID.STEEL_KNIFE_P__",
                "ItemID.BLACK_KNIFE",
                "ItemID.BLACK_KNIFE_P",
                "ItemID.BLACK_KNIFE_P_",
                "ItemID.BLACK_KNIFE_P__",
                "ItemID.MITHRIL_KNIFE",
                "ItemID.MITHRIL_KNIFE_P",
                "ItemID.MITHRIL_KNIFE_P_",
                "ItemID.MITHRIL_KNIFE_P__",
                "ItemID.ADAMANT_KNIFE",
                "ItemID.ADAMANT_KNIFE_P",
                "ItemID.ADAMANT_KNIFE_P_",
                "ItemID.ADAMANT_KNIFE_P__",
                "ItemID.RUNE_KNIFE",
                "ItemID.RUNE_KNIFE_P",
                "ItemID.RUNE_KNIFE_P_",
                "ItemID.RUNE_KNIFE_P__",
                "ItemID.DRAGON_KNIFE",
                "ItemID.DRAGON_KNIFE_P",
                "ItemID.DRAGON_KNIFE_P_",
                "ItemID.DRAGON_KNIFE_P__"
        });

        map.put("TREE_SAPLINGS", new String[]
        {
                "ItemID.PLANTPOT_OAK_SAPLING",
                "ItemID.PLANTPOT_WILLOW_SAPLING",
                "ItemID.PLANTPOT_MAPLE_SAPLING",
                "ItemID.PLANTPOT_YEW_SAPLING",
                "ItemID.PLANTPOT_MAGIC_TREE_SAPLING"
        });

        map.put("WATER_ALTAR", new String[]
        {
                "ItemID.ELEMENTAL_TALISMAN",
                "ItemID.WATER_TALISMAN"
        });

        map.put("WATER_STAFF", new String[]
        {
                "ItemID.WATER_BATTLESTAFF",
                "ItemID.MYSTIC_WATER_STAFF",
                "ItemID.STAFF_OF_WATER",
                "ItemID.MUD_BATTLESTAFF",
                "ItemID.MYSTIC_MUD_STAFF",
                "ItemID.MIST_BATTLESTAFF",
                "ItemID.MYSTIC_MIST_BATTLESTAFF",
                "ItemID.STEAM_BATTLESTAFF",
                "ItemID.MYSTIC_STEAM_BATTLESTAFF"
        });

        map.put("WATERING_CANS", new String[]
        {
                "ItemID.ZEAH_WATERINGCAN",
                "ItemID.WATERING_CAN_8",
                "ItemID.WATERING_CAN_7",
                "ItemID.WATERING_CAN_6",
                "ItemID.WATERING_CAN_5",
                "ItemID.WATERING_CAN_4",
                "ItemID.WATERING_CAN_3",
                "ItemID.WATERING_CAN_2",
                "ItemID.WATERING_CAN_1"
        });

    }

}
