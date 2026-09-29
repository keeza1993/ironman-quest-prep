package com.ironquestprep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * AUTO-GENERATED FILE.
 *
 * Generated from the cleaned Ironman Quest Prep CSV data.
 * Common unconditional records use a defaulting constructor to avoid repeated metadata.
 * All original fields are preserved; the integrity test fingerprints every field and row order.
 */
public final class GeneratedQuestData
{
    private static final List<RawItem> ITEMS = buildItems();
    private static final List<RawGroup> GROUPS = buildGroups();
    private static final List<RawItem> ADVISORIES = buildAdvisories();

    private GeneratedQuestData()
    {
    }

    public static List<RawItem> getItems()
    {
        return ITEMS;
    }

    public static List<RawGroup> getGroups()
    {
        return GROUPS;
    }

    public static List<RawItem> getAdvisories()
    {
        return ADVISORIES;
    }

    private static List<RawItem> buildItems()
    {
        List<RawItem> rows = new ArrayList<>(1129);
        addItems0(rows);
        addItems1(rows);
        addItems2(rows);
        addItems3(rows);
        addItems4(rows);
        addItems5(rows);
        addItems6(rows);
        addItems7(rows);
        addItems8(rows);
        addItems9(rows);
        addItems10(rows);
        addItems11(rows);
        addItems12(rows);
        addItems13(rows);
        addItems14(rows);
        addItems15(rows);
        return Collections.unmodifiableList(rows);
    }

    private static void addItems0(List<RawItem> rows)
    {
        rows.add(new RawItem("AKingdomDivided", "anyAxe", "Any axe", "ItemCollections.AXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("AKingdomDivided", "darkEssenceBlock", "Dark essence block", "ItemID.ARCEUUS_ESSENCE_BLOCK_DARK", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("AKingdomDivided", "defencePotion", "Defence Potion (3) or (4)", "ItemID._4DOSE1DEFENSE", "ITEM_ID", "1", true, "ItemID._3DOSE1DEFENSE"));
        rows.add(new RawItem("AKingdomDivided", "moltenGlass", "Molten glass", "ItemID.MOLTEN_GLASS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("AKingdomDivided", "volcanicSulphur", "Volcanic sulphur", "ItemID.LOVAKENGJ_SULPHUR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("AlfredGrimhandsBarcrawl", "coins208", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "208", true, ""));
        rows.add(new RawItem("ANightAtTheTheatre", "axe", "An axe", "ItemCollections.AXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("ANightAtTheTheatre", "flail", "Ivandis/Blisterwood flail", "ItemID.IVANDIS_FLAIL", "ITEM_ID", "1", false, "ItemID.BLISTERWOOD_FLAIL"));
        rows.add(new RawItem("ANightAtTheTheatre", "food", "Food", "ItemCollections.GOOD_EATING_FOOD", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("ANightAtTheTheatre", "ghostSpeakAmulet", "Ghostspeak amulet", "ItemCollections.GHOSTSPEAK", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("ANightAtTheTheatre", "saw", "Saw", "ItemCollections.SAW", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("AnimalMagnetism", "ectoToken20", "Ecto-token", "ItemID.ECTOTOKEN", "ITEM_ID", "20", true, ""));
        rows.add(new RawItem("AnimalMagnetism", "ghostspeak", "Ghostspeak amulet", "ItemID.AMULET_OF_GHOSTSPEAK", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("AnimalMagnetism", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("AnimalMagnetism", "hardLeather", "Hard Leather", "ItemID.HARD_LEATHER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("AnimalMagnetism", "holySymbol", "Holy Symbol", "ItemID.BLESSEDSTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("AnimalMagnetism", "ironBar5", "Iron Bar", "ItemID.IRON_BAR", "ITEM_ID", "5", true, ""));
        rows.add(new RawItem("AnimalMagnetism", "mithrilAxe", "Mithril Axe", "ItemID.MITHRIL_AXE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("AnimalMagnetism", "polishedButtons", "Polished Buttons", "ItemID.ANMA_P_BUTTONS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("AnotherSliceOfHam", "lightSource", "A light source", "ItemCollections.LIGHT_SOURCES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem( "AnotherSliceOfHam", "ropeForEntrance", "ItemRequirement", "Rope", "ItemID.ROPE", "ITEM_ID", "1", true, "", "HIDE:addedRopeToHole", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"addedRopeToHole\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "AnotherSliceOfHam.java" ));
        rows.add(new RawItem("AnotherSliceOfHam", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("APorcineOfInterest", "rope", "Rope", "ItemID.ROPE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("APorcineOfInterest", "slashItem", "A knife or slash weapon", "ItemID.KNIFE", "ITEM_ID", "1", false, "ItemID.DRAGON_SCIMITAR|ItemID.RUNE_SCIMITAR|ItemID.ADAMANT_SCIMITAR|ItemID.MITHRIL_SCIMITAR|ItemID.STEEL_SCIMITAR|ItemID.IRON_SCIMITAR|ItemID.BRONZE_SCIMITAR|ItemID.DRAGON_LONGSWORD|ItemID.RUNE_LONGSWORD|ItemID.ADAMANT_LONGSWORD|ItemID.MITHRIL_LONGSWORD|ItemID.STEEL_LONGSWORD|ItemID.IRON_LONGSWORD|ItemID.BRONZE_LONGSWORD"));
        rows.add(new RawItem("ASoulsBane", "rope", "Rope", "ItemID.ROPE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ATailOfTwoCats", "catspeak", "Catspeak amulet", "ItemID.ICS_LITTLE_AMULET_OF_CATSPEAK", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("ATailOfTwoCats", "chocolateCake", "Chocolate cake", "ItemID.CHOCOLATE_CAKE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ATailOfTwoCats", "deathRune5", "Death runes", "ItemID.DEATHRUNE", "ITEM_ID", "5", true, ""));
        rows.add(new RawItem("ATailOfTwoCats", "desertBottom", "Desert robe", "ItemID.DESERT_ROBE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("ATailOfTwoCats", "desertTop", "Desert shirt", "ItemID.DESERT_SHIRT", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("ATailOfTwoCats", "dibber", "Seed dibber", "ItemID.DIBBER", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("ATailOfTwoCats", "logs", "Logs", "ItemID.LOGS", "ITEM_ID", "1", true, "ItemCollections.LOGS_FOR_FIRE"));
        rows.add(new RawItem("ATailOfTwoCats", "milk", "Bucket of milk", "ItemID.BUCKET_MILK", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("ATailOfTwoCats", "potatoSeed4", "Potato seeds", "ItemID.POTATO_SEED", "ITEM_ID", "4", true, ""));
        rows.add(new RawItem("ATailOfTwoCats", "rake", "Rake", "ItemID.RAKE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("ATailOfTwoCats", "shears", "Shears", "ItemID.SHEARS", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("ATailOfTwoCats", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("ATailOfTwoCats", "vialOfWater", "Vial of water", "ItemID.VIAL_WATER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "ATasteOfHope", "airRune3", "ItemRequirement", "Air rune", "ItemCollections.AIR_RUNE", "ITEM_COLLECTION", "3", true, "", "", "enchantRunes.child1", "[]", "BANK_CHECKABLE", "", "", "ATasteOfHope.java" ));
        rows.add(new RawItem( "ATasteOfHope", "airStaff", "ItemRequirement", "Air staff", "ItemCollections.AIR_STAFF", "ITEM_COLLECTION", "1", false, "", "", "enchantRunes.child1", "[]", "BANK_CHECKABLE", "", "", "ATasteOfHope.java" ));
        rows.add(new RawItem("ATasteOfHope", "chisel", "Chisel", "ItemCollections.CHISEL", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("ATasteOfHope", "coins1000", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "1000", true, ""));
        rows.add(new RawItem( "ATasteOfHope", "cosmicRune", "ItemRequirement", "Cosmic rune", "ItemID.COSMICRUNE", "ITEM_ID", "1", true, "", "", "enchantRunes", "[]", "BANK_CHECKABLE", "", "", "ATasteOfHope.java" ));
        rows.add(new RawItem("ATasteOfHope", "emerald", "Emerald", "ItemID.EMERALD", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "ATasteOfHope", "enchantTablet", "ItemRequirement", "Emerald enchant tablet", "ItemID.POH_TABLET_ENCHANTEMERALD", "ITEM_ID", "1", true, "", "", "enchantEmeraldRunesOrTablet", "[]", "BANK_CHECKABLE", "", "", "ATasteOfHope.java" ));
        rows.add(new RawItem("ATasteOfHope", "rodOfIvandis", "Rod of Ivandis", "ItemCollections.ROD_OF_IVANDIS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("ATasteOfHope", "vialOfWaterNoTip", "Vial of water", "ItemID.VIAL_WATER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "AtFirstLight", "boxTrap", "ItemRequirement", "Box trap", "ItemID.HUNTING_BOX_TRAP", "ITEM_ID", "1", false, "", "", "jerboaTail2OrBoxTrap", "[]", "BANK_CHECKABLE", "", "", "AtFirstLight.java" ));
        rows.add(new RawItem( "AtFirstLight", "costumeNeedle", "ItemRequirement", "Costume needle", "ItemID.COSTUMENEEDLE", "ITEM_ID", "1", true, "", "", "needleOrCostumeNeedle", "[]", "BANK_CHECKABLE", "", "", "AtFirstLight.java" ));
        rows.add(new RawItem("AtFirstLight", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("AtFirstLight", "jerboaTail", "Jerboa tail", "ItemID.HUNTING_JERBOA_TAIL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "AtFirstLight", "jerboaTail2OrBoxTrap.child1", "ItemRequirement", "Jerboa tail", "ItemID.HUNTING_JERBOA_TAIL", "ITEM_ID", "2", true, "", "", "jerboaTail2OrBoxTrap", "[]", "BANK_CHECKABLE", "", "", "AtFirstLight.java" ));
        rows.add(new RawItem( "AtFirstLight", "needle", "ItemRequirement", "Needle", "ItemID.NEEDLE", "ITEM_ID", "1", false, "", "", "needleOrCostumeNeedle", "[]", "BANK_CHECKABLE", "", "", "AtFirstLight.java" ));
        rows.add(new RawItem("BarbarianTraining", "antifireShield", "Anti-dragon shield or DFS", "ItemCollections.ANTIFIRE_SHIELDS", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("BarbarianTraining", "attackPotion", "Attack potion (2)", "ItemID._2DOSE1ATTACK", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BarbarianTraining", "axe", "Any axe", "ItemCollections.AXES", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("BarbarianTraining", "bow", "Any bow", "ItemCollections.BOWS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("BarbarianTraining", "bronzeBar", "Bronze bar", "ItemID.BRONZE_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BarbarianTraining", "feathers", "Feathers", "ItemID.FEATHER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BarbarianTraining", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("BarbarianTraining", "knife", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BarbarianTraining", "logs", "Logs", "ItemID.LOGS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BarbarianTraining", "oakLogs", "Oak logs", "ItemID.OAK_LOGS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BarbarianTraining", "roe", "Roe", "ItemID.BRUT_ROE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BarbarianTraining", "sapling", "Any sapling you can plant", "ItemCollections.TREE_SAPLINGS", "ITEM_COLLECTION", "1", true, "ItemCollections.FRUIT_TREE_SAPLINGS"));
        rows.add(new RawItem("BarbarianTraining", "seed", "Any seed that can be planted directly", "ItemCollections.ALLOTMENT_SEEDS", "ITEM_COLLECTION", "1", true, "ItemCollections.HERB_SEEDS|ItemCollections.FLOWER_SEEDS|ItemCollections.BUSH_SEEDS|ItemCollections.HOPS_SEEDS"));
        rows.add(new RawItem("BarbarianTraining", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BarbarianTraining", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BarrowsHelper", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "BearYourSoul", "dustyKeyOr70AgilOrKeyMasterTeleport", "KeyringRequirement", "Dusty key, or another way to get into the deep Taverley Dungeon", "KeyringCollection.DUSTY_KEY", "KEYRING", "1", false, "", "", "", "[]", "BANK_CHECKABLE", "", "", "BearYourSoul.java" ));
        rows.add(new RawItem("BearYourSoul", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("BelowIceMountain", "bread", "Bread", "ItemID.BREAD", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BelowIceMountain", "coins", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "3", true, ""));
        rows.add(new RawItem("BelowIceMountain", "cookedMeat", "Cooked Meat", "ItemID.COOKED_MEAT", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BelowIceMountain", "knife", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", false, ""));
    }

    private static void addItems1(List<RawItem> rows)
    {
        rows.add(new RawItem("BeneathCursedSands", "coal", "Coal", "ItemID.COAL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BeneathCursedSands", "ironBar", "Iron bar", "ItemID.IRON_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BeneathCursedSands", "meat", "Any cooked or raw meat", "ItemID.COOKED_MEAT", "ITEM_ID", "1", true, "ItemID.RAW_BEEF|ItemID.RAW_BEAR_MEAT|ItemID.RAW_BOAR_MEAT|ItemID.RAW_RAT_MEAT|ItemID.RAW_CHICKEN"));
        rows.add(new RawItem("BeneathCursedSands", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("BeneathCursedSands", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("BetweenARock", "cannonMould", "Ammo mould", "ItemID.AMMO_MOULD", "ITEM_ID", "1", true, "ItemID.DOUBLE_AMMO_MOULD"));
        rows.add(new RawItem("BetweenARock", "coins1000", "Coins for travelling", "ItemCollections.COINS", "ITEM_COLLECTION", "1000", true, ""));
        rows.add(new RawItem("BetweenARock", "goldBars4", "Gold bars", "ItemID.GOLD_BAR", "ITEM_ID", "4", true, ""));
        rows.add(new RawItem("BetweenARock", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("BetweenARock", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("BigChompyBirdHunting", "axe", "Any axe", "ItemCollections.AXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("BigChompyBirdHunting", "cabbage", "Cabbage", "ItemID.CABBAGE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BigChompyBirdHunting", "chisel", "Chisel", "ItemCollections.CHISEL", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("BigChompyBirdHunting", "doogle", "Doogle leaves", "ItemID.DOOGLELEAVES", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BigChompyBirdHunting", "equa", "Equa leaves", "ItemID.EQUA_LEAVES", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BigChompyBirdHunting", "feathers", "Feathers", "ItemID.FEATHER", "ITEM_ID", "100", true, ""));
        rows.add(new RawItem("BigChompyBirdHunting", "knife", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("BigChompyBirdHunting", "onion", "Onion", "ItemID.ONION", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BigChompyBirdHunting", "potato", "Potato", "ItemID.POTATO", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BigChompyBirdHunting", "tomato", "Tomato", "ItemID.TOMATO", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BigChompyBirdHunting", "wolfBones4", "Wolf bones", "ItemID.WOLF_BONES", "ITEM_ID", "4", true, ""));
        rows.add(new RawItem("Biohazard", "gasMask", "Gas mask", "ItemID.GASMASK", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("BlackKnightFortress", "bronzeMed", "Bronze med helm", "ItemID.BRONZE_MED_HELM", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("BlackKnightFortress", "cabbage", "Cabbage (NOT from Draynor Manor)", "ItemID.CABBAGE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BlackKnightFortress", "ironChainbody", "Iron chainbody", "ItemID.IRON_CHAINBODY", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("BoneVoyage", "marrentillPotionUnf", "Marrentill potion (unf)", "ItemID.MARRENTILLVIAL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("BoneVoyage", "vodka2", "Vodka", "ItemID.VODKA", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("CastleWarsBalloonFlight", "yewLogs", "Yew logs", "ItemID.YEW_LOGS", "ITEM_ID", "10", true, ""));
        rows.add(new RawItem("ClientOfKourend", "feather", "Feather", "ItemID.FEATHER", "ITEM_ID", "1", true, "ItemID.HUNTING_POLAR_FEATHER|ItemID.HUNTING_WOODLAND_FEATHER|ItemID.HUNTING_JUNGLE_FEATHER|ItemID.HUNTING_DESERT_FEATHER|ItemID.HUNTING_EAGLE_FEATHER|ItemID.HUNTING_STRIPY_BIRD_FEATHER"));
        rows.add(new RawItem("ClockTower", "bucketOfWater", "Bucket of Water or a pair of ice gloves or smiths gloves(i)", "ItemID.BUCKET_WATER", "ITEM_ID", "1", true, "ItemID.ICE_GLOVES|ItemID.SMITHING_UNIFORM_GLOVES_ICE"));
        rows.add(new RawItem("ColdWar", "clockworkOrSteelBar", "Clockwork or Steel Bar", "ItemID.STEEL_BAR", "ITEM_ID", "1", true, "ItemID.POH_CLOCKWORK_MECHANISM"));
        rows.add(new RawItem("ColdWar", "feathers", "Feathers", "ItemID.FEATHER", "ITEM_ID", "5", true, ""));
        rows.add(new RawItem("ColdWar", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("ColdWar", "leather", "Leather", "ItemID.LEATHER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ColdWar", "mahoganyPlank", "Mahogany Plank", "ItemID.PLANK_MAHOGANY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ColdWar", "oakPlanks", "Oak Planks (unnoted)", "ItemID.PLANK_OAK", "ITEM_ID", "10", true, ""));
        rows.add(new RawItem("ColdWar", "plank", "Normal Plank", "ItemID.WOODPLANK", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ColdWar", "rawCodOrCharos", "Raw Cod", "ItemID.RAW_COD", "ITEM_ID", "1", true, "ItemID.RING_OF_CHAROS_UNLOCKED"));
        rows.add(new RawItem("ColdWar", "silk", "Silk", "ItemID.SILK", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ColdWar", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("ColdWar", "steelNails", "Steel Nails", "ItemID.NAILS", "ITEM_ID", "10", true, ""));
        rows.add(new RawItem("ColdWar", "swampTar", "Swamp Tar", "ItemID.SWAMP_TAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("Contact", "lightSource", "A light source", "ItemCollections.LIGHT_SOURCES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("Contact", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem( "CooksAssistant", "egg", "ItemRequirement", "Egg", "ItemID.EGG", "ITEM_ID", "1", true, "", "HIDE:or(hasTurnedInEgg, hasTurnedInEverything)", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"or(hasTurnedInEgg, hasTurnedInEverything)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "CooksAssistant.java" ));
        rows.add(new RawItem( "CooksAssistant", "flour", "ItemRequirement", "Pot of flour", "ItemID.POT_FLOUR", "ITEM_ID", "1", true, "", "HIDE:or(hasTurnedInFlour, hasTurnedInEverything)", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"or(hasTurnedInFlour, hasTurnedInEverything)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "CooksAssistant.java" ));
        rows.add(new RawItem( "CooksAssistant", "milk", "ItemRequirement", "Bucket of milk", "ItemID.BUCKET_MILK", "ITEM_ID", "1", true, "", "HIDE:or(hasTurnedInMilk, hasTurnedInEverything)", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"or(hasTurnedInMilk, hasTurnedInEverything)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "CooksAssistant.java" ));
        rows.add(new RawItem("CraftingGuildBalloonFlight", "oakLogs", "Oak logs", "ItemID.OAK_LOGS", "ITEM_ID", "10", true, ""));
        rows.add(new RawItem("CreatureOfFenkenstrain", "bronzeWire", "Bronze wire", "ItemID.BRONZECRAFTWIRE", "ITEM_ID", "3", true, ""));
        rows.add(new RawItem("CreatureOfFenkenstrain", "coins", "Coins at least", "ItemCollections.COINS", "ITEM_COLLECTION", "100", true, ""));
        rows.add(new RawItem( "CreatureOfFenkenstrain", "coins50", "ItemRequirement", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "50", true, "", "", "telegrabOrCoins", "[]", "BANK_CHECKABLE", "", "", "CreatureOfFenkenstrain.java" ));
        rows.add(new RawItem("CreatureOfFenkenstrain", "ghostSpeakAmulet", "Ghostspeak amulet", "ItemCollections.GHOSTSPEAK", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("CreatureOfFenkenstrain", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("CreatureOfFenkenstrain", "needle", "Needle", "ItemID.NEEDLE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("CreatureOfFenkenstrain", "silverBar", "Silver bar", "ItemID.SILVER_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("CreatureOfFenkenstrain", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem( "CreatureOfFenkenstrain", "telegrab.child1", "ItemRequirement", "Law rune", "ItemID.LAWRUNE", "ITEM_ID", "1", true, "", "", "telegrab", "[]", "BANK_CHECKABLE", "", "", "CreatureOfFenkenstrain.java" ));
        rows.add(new RawItem( "CreatureOfFenkenstrain", "telegrab.child2", "ItemRequirement", "Air rune", "ItemID.AIRRUNE", "ITEM_ID", "1", true, "", "", "telegrab", "[]", "BANK_CHECKABLE", "", "", "CreatureOfFenkenstrain.java" ));
        rows.add(new RawItem("CreatureOfFenkenstrain", "thread", "Thread", "ItemID.THREAD", "ITEM_ID", "5", true, ""));
        rows.add(new RawItem( "CurrentAffairs", "charcoalRequirement", "ItemRequirement", "Charcoal", "ItemID.CHARCOAL", "ITEM_ID", "1", false, "", "HIDE:filledFormCr4p", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"filledFormCr4p\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "CurrentAffairs.java" ));
        rows.add(new RawItem( "CurrentAffairs", "coinsRequirement", "ItemRequirement", "Coins", "ItemID.COINS", "ITEM_ID", "50", true, "", "HIDE:boughtFishbowl", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"boughtFishbowl\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "CurrentAffairs.java" ));
        rows.add(new RawItem("CurseOfTheEmptyLord", "ghostspeakItems", "Ghostspeak amulet or Morytania legs 2 or better", "ItemID.AMULET_OF_GHOSTSPEAK", "ITEM_ID", "1", false, "ItemID.MORYTANIA_LEGS_MEDIUM|ItemID.MORYTANIA_LEGS_HARD|ItemID.MORYTANIA_LEGS_ELITE"));
        rows.add(new RawItem( "CurseOfTheEmptyLord", "knife", "ItemRequirement", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", false, "", "SHOW:new VarbitRequirement(VarbitID.SECRET_GHOST_RANDOMISER, 3)", "", "[{\"Mode\":\"SHOW\",\"Expression\":\"new VarbitRequirement(VarbitID.SECRET_GHOST_RANDOMISER, 3)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "CurseOfTheEmptyLord.java" ));
        rows.add(new RawItem("CurseOfTheEmptyLord", "ringOfVis", "Ring of visibility", "ItemID.FD_RING_VISIBILITY", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("DaddysHome", "bolt5", "Bolt of cloth", "ItemID.CLOTH", "ITEM_ID", "5", true, ""));
        rows.add(new RawItem("DaddysHome", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("DaddysHome", "nails20", "Nails (bring more in case you fail with some)", "ItemCollections.NAILS", "ITEM_COLLECTION", "14", true, ""));
        rows.add(new RawItem("DaddysHome", "plank10", "Plank", "ItemID.WOODPLANK", "ITEM_ID", "10", true, ""));
        rows.add(new RawItem("DaddysHome", "saw", "Saw", "ItemCollections.SAW", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("DarknessOfHallowvale", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("DarknessOfHallowvale", "knife", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("DarknessOfHallowvale", "nails8", "Nails", "ItemCollections.NAILS", "ITEM_COLLECTION", "8", true, ""));
        rows.add(new RawItem("DarknessOfHallowvale", "planks2", "Plank", "ItemID.WOODPLANK", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("DeathPlateau", "bread", "Bread (UNNOTED)", "ItemID.BREAD", "ITEM_ID", "10", true, ""));
        rows.add(new RawItem("DeathPlateau", "coins", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "60", true, ""));
    }

    private static void addItems2(List<RawItem> rows)
    {
        rows.add(new RawItem("DeathPlateau", "ironBar", "Iron bar", "ItemID.IRON_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DeathPlateau", "premadeBlurb", "Premade blurb' sp.", "ItemID.PREMADE_BLURBERRY_SPECIAL", "ITEM_ID", "1", true, "ItemID.BLURBERRY_SPECIAL"));
        rows.add(new RawItem("DeathPlateau", "trout", "Trout (UNNOTED)", "ItemID.TROUT", "ITEM_ID", "10", true, ""));
        rows.add(new RawItem( "DeathToTheDorgeshuun", "hamBoot2", "ItemRequirement", "Ham boots", "ItemID.HAM_BOOTS", "ITEM_ID", "2", false, "", "", "hamSet2", "[]", "BANK_CHECKABLE", "", "", "DeathToTheDorgeshuun.java" ));
        rows.add(new RawItem( "DeathToTheDorgeshuun", "hamCloak2", "ItemRequirement", "Ham cloak", "ItemID.HAM_CLOAK", "ITEM_ID", "2", false, "", "", "hamSet2", "[]", "BANK_CHECKABLE", "", "", "DeathToTheDorgeshuun.java" ));
        rows.add(new RawItem( "DeathToTheDorgeshuun", "hamGloves2", "ItemRequirement", "Ham gloves", "ItemID.HAM_GLOVES", "ITEM_ID", "2", false, "", "", "hamSet2", "[]", "BANK_CHECKABLE", "", "", "DeathToTheDorgeshuun.java" ));
        rows.add(new RawItem( "DeathToTheDorgeshuun", "hamHood2", "ItemRequirement", "Ham hood", "ItemID.HAM_HOOD", "ITEM_ID", "2", false, "", "", "hamSet2", "[]", "BANK_CHECKABLE", "", "", "DeathToTheDorgeshuun.java" ));
        rows.add(new RawItem( "DeathToTheDorgeshuun", "hamLogo2", "ItemRequirement", "Ham logo", "ItemID.HAM_BADGE", "ITEM_ID", "2", false, "", "", "hamSet2", "[]", "BANK_CHECKABLE", "", "", "DeathToTheDorgeshuun.java" ));
        rows.add(new RawItem( "DeathToTheDorgeshuun", "hamRobe2", "ItemRequirement", "Ham robe", "ItemID.HAM_ROBE", "ITEM_ID", "2", false, "", "", "hamSet2", "[]", "BANK_CHECKABLE", "", "", "DeathToTheDorgeshuun.java" ));
        rows.add(new RawItem( "DeathToTheDorgeshuun", "hamShirt2", "ItemRequirement", "Ham shirt", "ItemID.HAM_SHIRT", "ITEM_ID", "2", false, "", "", "hamSet2", "[]", "BANK_CHECKABLE", "", "", "DeathToTheDorgeshuun.java" ));
        rows.add(new RawItem("DeathToTheDorgeshuun", "lightSource", "A light source", "ItemCollections.LIGHT_SOURCES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("DeathToTheDorgeshuun", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("DeathToTheDorgeshuun", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("DefenderOfVarrock", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("DemonSlayer", "bones", "Bones (UNNOTED)", "ItemID.BONES", "ITEM_ID", "25", true, ""));
        rows.add(new RawItem("DemonSlayer", "bucketOfWaterOptional", "Bucket of water", "ItemID.BUCKET_WATER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DemonSlayer", "coin", "Coin", "ItemCollections.COINS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("DesertTreasure", "ashes", "Ashes", "ItemID.ASHES", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DesertTreasure", "bloodRune", "Blood rune", "ItemID.BLOODRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DesertTreasure", "bones", "Bones", "ItemID.BONES", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DesertTreasure", "cake", "Cake", "ItemID.CAKE", "ITEM_ID", "1", true, "ItemID.PARTIAL_CAKE|ItemID.CAKE_SLICE|ItemID.CHOCOLATE_CAKE|ItemID.PARTIAL_CHOCOLATE_CAKE|ItemID.CHOCOLATE_SLICE|ItemID.APPLE_PIE|ItemID.HALF_AN_APPLE_PIE|ItemID.BANANA|ItemID.CHOCOLATE_BAR|ItemID.CHOCOLATY_MILK|ItemID.COOKING_APPLE|ItemID.ORANGE|ItemID.ORANGE_CHUNKS|ItemID.ORANGE_SLICES|ItemID.PINEAPPLE_CHUNKS|ItemID.PINEAPPLE_RING|ItemID.PINEAPPLE_PIZZA|ItemID.HALF_PINEAPPLE_PIZZA|ItemID.REDBERRIES|ItemID.REDBERRY_PIE|ItemID.HALF_A_REDBERRY_PIE"));
        rows.add(new RawItem("DesertTreasure", "charcoal", "Charcoal", "ItemID.CHARCOAL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DesertTreasure", "climbingBoots", "Climbing boots", "ItemCollections.CLIMBING_BOOTS", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("DesertTreasure", "coins650", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "650", true, ""));
        rows.add(new RawItem("DesertTreasure", "faceMask", "Facemask (or other face covering)", "ItemID.SLAYER_FACEMASK", "ITEM_ID", "1", false, "ItemID.SLAYER_FACEMASK|ItemID.SLAYER_HELM|ItemID.SLAYER_HELM_I|ItemID.SW_SLAYER_HELM_I|ItemID.GASMASK"));
        rows.add(new RawItem("DesertTreasure", "garlicPowder", "Garlic powder", "ItemID.FD_CRUSHED_GARLIC", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DesertTreasure", "iceGloves", "Ice gloves/smiths gloves(i)", "ItemID.ICE_GLOVES", "ITEM_ID", "1", false, "ItemID.SMITHING_UNIFORM_GLOVES_ICE"));
        rows.add(new RawItem("DesertTreasure", "magicLogs12", "Magic logs (can be noted)", "ItemID.MAGIC_LOGS", "ITEM_ID", "12", true, "ItemID.Cert.MAGIC_LOGS"));
        rows.add(new RawItem("DesertTreasure", "moltenGlass6", "Molten glass (can be noted)", "ItemID.MOLTEN_GLASS", "ITEM_ID", "6", true, "ItemID.Cert.MOLTEN_GLASS"));
        rows.add(new RawItem("DesertTreasure", "silverBar", "Silver bar", "ItemID.SILVER_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DesertTreasure", "spice", "Spice", "ItemID.SPICESPOT", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DesertTreasure", "spikedBoots", "Spiked boots", "ItemID.DEATH_SPIKEDBOOTS", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("DesertTreasure", "steelBars6", "Steel bar (can be noted)", "ItemID.STEEL_BAR", "ITEM_ID", "6", true, "ItemID.Cert.STEEL_BAR"));
        rows.add(new RawItem("DesertTreasure", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem( "DesertTreasureII", "allBursts.child1", "ItemRequirement", "Death runes", "ItemID.DEATHRUNE", "ITEM_ID", "8", true, "", "", "allBursts", "[]", "BANK_CHECKABLE", "", "", "DesertTreasureII.java" ));
        rows.add(new RawItem( "DesertTreasureII", "allBursts.child2", "ItemRequirement", "Chaos runes", "ItemID.CHAOSRUNE", "ITEM_ID", "16", true, "", "", "allBursts", "[]", "BANK_CHECKABLE", "", "", "DesertTreasureII.java" ));
        rows.add(new RawItem( "DesertTreasureII", "allBursts.child3", "ItemRequirement", "Blood runes", "ItemID.BLOODRUNE", "ITEM_ID", "2", true, "", "", "allBursts", "[]", "BANK_CHECKABLE", "", "", "DesertTreasureII.java" ));
        rows.add(new RawItem( "DesertTreasureII", "allBursts.child4", "ItemRequirement", "Water runes", "ItemID.WATERRUNE", "ITEM_ID", "4", true, "", "", "allBursts", "[]", "BANK_CHECKABLE", "", "", "DesertTreasureII.java" ));
        rows.add(new RawItem( "DesertTreasureII", "allBursts.child5", "ItemRequirement", "Soul runes", "ItemID.SOULRUNE", "ITEM_ID", "2", true, "", "", "allBursts", "[]", "BANK_CHECKABLE", "", "", "DesertTreasureII.java" ));
        rows.add(new RawItem( "DesertTreasureII", "allBursts.child6", "ItemRequirement", "Air runes", "ItemID.AIRRUNE", "ITEM_ID", "3", true, "", "", "allBursts", "[]", "BANK_CHECKABLE", "", "", "DesertTreasureII.java" ));
        rows.add(new RawItem( "DesertTreasureII", "allBursts.child7", "ItemRequirement", "Fire runes", "ItemID.FIRERUNE", "ITEM_ID", "2", true, "", "", "allBursts", "[]", "BANK_CHECKABLE", "", "", "DesertTreasureII.java" ));
        rows.add(new RawItem("DesertTreasureII", "facemask", "Facemask", "ItemCollections.SLAYER_HELMETS", "ITEM_COLLECTION", "1", true, "ItemID.SLAYER_FACEMASK|ItemID.GASMASK"));
        rows.add(new RawItem("DesertTreasureII", "ringOfVisibility", "Ring of visibility", "ItemID.FD_RING_VISIBILITY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DeviousMinds", "bowString", "Bow String", "ItemID.BOW_STRING", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DeviousMinds", "largePouch", "Large/Colossal Pouch (non-degraded)", "ItemID.RCU_POUCH_LARGE", "ITEM_ID", "1", true, "ItemID.DEVIOUS_GLOWINGPOUCH|ItemID.RCU_POUCH_COLOSSAL|ItemID.DEVIOUS_GLOWINGPOUCH_COLOSSAL"));
        rows.add(new RawItem("DeviousMinds", "mith2h", "Mithril 2h Sword", "ItemID.MITHRIL_2H_SWORD", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DoricsQuest", "clay", "Clay (UNNOTED)", "ItemID.CLAY", "ITEM_ID", "6", true, ""));
        rows.add(new RawItem("DoricsQuest", "copper", "Copper ore (UNNOTED)", "ItemID.COPPER_ORE", "ITEM_ID", "4", true, ""));
        rows.add(new RawItem("DoricsQuest", "iron", "Iron ore (UNNOTED)", "ItemID.IRON_ORE", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("DragonSlayer", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("DragonSlayer", "lobsterPot", "Lobster pot", "ItemID.LOBSTER_POT", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DragonSlayer", "mindBomb", "Wizard's mind bomb", "ItemID.WIZARDS_MIND_BOMB", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DragonSlayer", "nails90", "Steel nails", "ItemID.NAILS", "ITEM_ID", "90", true, ""));
        rows.add(new RawItem("DragonSlayer", "planks3", "Planks", "ItemID.WOODPLANK", "ITEM_ID", "3", true, ""));
        rows.add(new RawItem("DragonSlayer", "silk", "Silk", "ItemID.SILK", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "DragonSlayer", "telegrab", "ItemRequirement", "Telekinetic grab", "ItemID.POH_TABLET_TELEGRAB", "ITEM_ID", "1", true, "", "", "telegrabOrTenK", "[]", "BANK_CHECKABLE", "", "", "DragonSlayer.java" ));
        rows.add(new RawItem( "DragonSlayer", "telegrabOrTenK.child1", "ItemRequirement", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "10000", true, "", "", "telegrabOrTenK", "[]", "BANK_CHECKABLE", "", "", "DragonSlayer.java" ));
        rows.add(new RawItem("DragonSlayer", "twoThousandCoins", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "2000", true, ""));
        rows.add(new RawItem("DragonSlayer", "unfiredBowl", "Unfired bowl", "ItemID.BOWL_UNFIRED", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "DragonSlayerII", "airRune15", "ItemRequirement", "Air rune", "ItemID.AIRRUNE", "ITEM_ID", "15", true, "", "", "fireWave3Runes", "[]", "BANK_CHECKABLE", "", "", "DragonSlayerII.java" ));
        rows.add(new RawItem( "DragonSlayerII", "airRune21", "ItemRequirement", "Air rune", "ItemID.AIRRUNE", "ITEM_ID", "21", true, "", "", "fireSurge3Runes", "[]", "BANK_CHECKABLE", "", "", "DragonSlayerII.java" ));
        rows.add(new RawItem("DragonSlayerII", "antifireShield", "Antifire shield", "ItemCollections.ANTIFIRE_SHIELDS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("DragonSlayerII", "astralRune", "Astral rune", "ItemID.ASTRALRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DragonSlayerII", "axe", "Any axe", "ItemCollections.AXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem( "DragonSlayerII", "bloodRune3", "ItemRequirement", "Blood rune", "ItemID.BLOODRUNE", "ITEM_ID", "3", true, "", "", "fireWave3Runes", "[]", "BANK_CHECKABLE", "", "", "DragonSlayerII.java" ));
        rows.add(new RawItem("DragonSlayerII", "catspeakAmulet", "Catspeak amulet (e)", "ItemID.TWOCATS_AMULETOFCATSPEAK", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("DragonSlayerII", "chisel", "Chisel", "ItemCollections.CHISEL", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("DragonSlayerII", "dragonstone", "Dragonstone", "ItemID.DRAGONSTONE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "DragonSlayerII", "fireRune21", "ItemRequirement", "Fire rune", "ItemID.FIRERUNE", "ITEM_ID", "21", true, "", "", "fireWave3Runes", "[]", "BANK_CHECKABLE", "", "", "DragonSlayerII.java" ));
        rows.add(new RawItem( "DragonSlayerII", "fireRune30", "ItemRequirement", "Fire rune", "ItemID.FIRERUNE", "ITEM_ID", "30", true, "", "", "fireSurge3Runes", "[]", "BANK_CHECKABLE", "", "", "DragonSlayerII.java" ));
        rows.add(new RawItem("DragonSlayerII", "ghostspeakOrMory2", "Ghostspeak amulet", "ItemCollections.GHOSTSPEAK", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("DragonSlayerII", "glassblowingPipe", "Glassblowing pipe", "ItemID.GLASSBLOWINGPIPE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("DragonSlayerII", "goutweed", "Goutweed", "ItemID.EADGAR_GOUTWEED_HERB", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DragonSlayerII", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("DragonSlayerII", "lightSource", "A light source", "ItemCollections.LIGHT_SOURCES", "ITEM_COLLECTION", "1", false, ""));
    }

    private static void addItems3(List<RawItem> rows)
    {
        rows.add(new RawItem("DragonSlayerII", "machete", "Any machete", "ItemCollections.MACHETE", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("DragonSlayerII", "moltenGlass2", "Molten glass", "ItemID.MOLTEN_GLASS", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("DragonSlayerII", "nails12OrMore", "Nails, bring more in case some break", "ItemCollections.NAILS", "ITEM_COLLECTION", "12", true, ""));
        rows.add(new RawItem("DragonSlayerII", "oakPlank8", "Oak planks", "ItemID.PLANK_OAK", "ITEM_ID", "8", true, ""));
        rows.add(new RawItem("DragonSlayerII", "pestleAndMortarHighlighted", "Pestle and mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("DragonSlayerII", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("DragonSlayerII", "saw", "Saw", "ItemCollections.SAW", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("DragonSlayerII", "sealOfPassage", "Seal of passage", "ItemID.LUNAR_SEAL_OF_PASSAGE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DragonSlayerII", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("DragonSlayerII", "swampPaste10", "Swamp paste", "ItemID.SWAMPPASTE", "ITEM_ID", "10", true, ""));
        rows.add(new RawItem("DragonSlayerII", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem( "DragonSlayerII", "wrathRune3", "ItemRequirement", "Wrath rune", "ItemID.WRATHRUNE", "ITEM_ID", "3", true, "", "", "fireSurge3Runes", "[]", "BANK_CHECKABLE", "", "", "DragonSlayerII.java" ));
        rows.add(new RawItem("DreamMentor", "astralRune", "Astral rune", "ItemID.ASTRALRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DreamMentor", "goutweed", "Goutweed", "ItemID.EADGAR_GOUTWEED_HERB", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DreamMentor", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("DreamMentor", "pestleAndMortar", "Pestle and mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("DreamMentor", "sealOfPassage", "Seal of passage", "ItemID.LUNAR_SEAL_OF_PASSAGE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("DreamMentor", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("DruidicRitual", "rawBear", "Raw bear meat", "ItemID.RAW_BEAR_MEAT", "ITEM_ID", "1", true, "ItemID.ENCHANTED_BEAR_MEAT"));
        rows.add(new RawItem("DruidicRitual", "rawBeef", "Raw beef", "ItemID.RAW_BEEF", "ITEM_ID", "1", true, "ItemID.ENCHANTED_BEEF"));
        rows.add(new RawItem("DruidicRitual", "rawChicken", "Raw chicken", "ItemID.RAW_CHICKEN", "ITEM_ID", "1", true, "ItemID.ENCHANTED_CHICKEN"));
        rows.add(new RawItem("DruidicRitual", "rawRat", "Raw rat meat", "ItemID.RAW_RAT_MEAT", "ITEM_ID", "1", true, "ItemID.ENCHANTED_RAT_MEAT"));
        rows.add(new RawItem("DwarfCannon", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem( "EadgarsRuse", "climbingBoots", "ItemRequirement", "Climbing boots", "ItemCollections.CLIMBING_BOOTS", "ITEM_COLLECTION", "1", false, "", "", "climbingBootsOr12Coins", "[]", "BANK_CHECKABLE", "", "", "EadgarsRuse.java" ));
        rows.add(new RawItem( "EadgarsRuse", "coins12", "ItemRequirement", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "12", true, "", "", "climbingBootsOr12Coins", "[]", "BANK_CHECKABLE", "", "", "EadgarsRuse.java" ));
        rows.add(new RawItem("EadgarsRuse", "grain10", "Grain", "ItemID.GRAIN", "ITEM_ID", "10", true, ""));
        rows.add(new RawItem("EadgarsRuse", "logs2", "Logs", "ItemID.LOGS", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("EadgarsRuse", "pestleAndMortar", "Pestle and Mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("EadgarsRuse", "pineappleChunks", "Pineapple chunks", "ItemID.PINEAPPLE_CHUNKS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("EadgarsRuse", "ranarrPotionUnf", "Ranarr potion (unf)", "ItemID.RANARRVIAL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("EadgarsRuse", "rawChicken5", "Raw chicken", "ItemID.RAW_CHICKEN", "ITEM_ID", "5", true, ""));
        rows.add(new RawItem("EadgarsRuse", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("EadgarsRuse", "vodka", "Vodka", "ItemID.VODKA", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("EaglesPeak", "coins", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "50", true, ""));
        rows.add(new RawItem("EaglesPeak", "tar", "Swamp tar", "ItemID.SWAMP_TAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("EaglesPeak", "yellowDye", "Yellow dye", "ItemID.YELLOWDYE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ElementalWorkshopI", "coal4", "Coal", "ItemID.COAL", "ITEM_ID", "4", true, ""));
        rows.add(new RawItem("ElementalWorkshopI", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("ElementalWorkshopI", "knife", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("ElementalWorkshopI", "leather", "Leather", "ItemID.LEATHER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ElementalWorkshopI", "needle", "Needle", "ItemID.NEEDLE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("ElementalWorkshopI", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("ElementalWorkshopI", "thread", "Thread", "ItemID.THREAD", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "ElementalWorkshopII", "batteredKey", "KeyringRequirement", "Battered Key", "KeyringCollection.BATTERED_KEY", "KEYRING", "1", true, "", "", "", "[]", "BANK_CHECKABLE", "", "", "ElementalWorkshopII.java" ));
        rows.add(new RawItem("ElementalWorkshopII", "coal", "Coal", "ItemID.COAL", "ITEM_ID", "8", true, ""));
        rows.add(new RawItem("ElementalWorkshopII", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("ElementalWorkshopII", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("EnakhrasLament", "breadOrCake", "Bread or cake", "ItemID.BREAD", "ITEM_ID", "1", true, "ItemID.CAKE|ItemID.CHOCOLATE_CAKE|ItemID.REDBERRY_PIE|ItemID.MEAT_PIE|ItemID.APPLE_PIE|ItemID.GARDEN_PIE|ItemID.FISH_PIE|ItemID.ADMIRAL_PIE|ItemID.WILD_PIE|ItemID.SUMMER_PIE|ItemID.PLAIN_PIZZA|ItemID.MEAT_PIZZA|ItemID.ANCHOVIE_PIZZA|ItemID.PINEAPPLE_PIZZA|ItemID.POTATO_BUTTER|ItemID.POTATO_CHILLI_CARNE|ItemID.POTATO_CHEESE|ItemID.POTATO_EGG_TOMATO|ItemID.POTATO_MUSHROOM_ONION|ItemID.POTATO_TUNA_SWEETCORN"));
        rows.add(new RawItem("EnakhrasLament", "candle", "Candle", "ItemID.UNLIT_CANDLE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("EnakhrasLament", "chiselHighlighted", "Chisel", "ItemCollections.CHISEL", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("EnakhrasLament", "coal", "Coal", "ItemID.COAL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("EnakhrasLament", "granite2", "Granite (5kg)", "ItemID.ENAKH_GRANITE_MEDIUM", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("EnakhrasLament", "log", "Logs", "ItemID.LOGS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("EnakhrasLament", "mapleLog", "Maple logs", "ItemID.MAPLE_LOGS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("EnakhrasLament", "oakLog", "Oak logs", "ItemID.OAK_LOGS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("EnakhrasLament", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("EnakhrasLament", "softClay", "Soft clay", "ItemID.SOFTCLAY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("EnakhrasLament", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("EnakhrasLament", "willowLog", "Willow logs", "ItemID.WILLOW_LOGS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "EnchantedKey", "key", "KeyringRequirement", "Enchanted key", "KeyringCollection.ENCHANTED_KEY", "KEYRING", "1", true, "", "", "", "[]", "BANK_CHECKABLE", "", "", "EnchantedKey.java" ));
        rows.add(new RawItem("EnchantedKey", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("EnlightenedJourney", "ballOfWool", "Ball of wool", "ItemID.BALL_OF_WOOL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("EnlightenedJourney", "bowl", "Bowl", "ItemID.BOWL_EMPTY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("EnlightenedJourney", "emptySack8", "Empty sack", "ItemID.SACK_EMPTY", "ITEM_ID", "8", true, "ItemID.ZEP_SANDBAG"));
        rows.add(new RawItem("EnlightenedJourney", "logs10", "Logs", "ItemID.LOGS", "ITEM_ID", "10", true, ""));
        rows.add(new RawItem("EnlightenedJourney", "papyrus3", "Papyrus", "ItemID.PAPYRUS", "ITEM_ID", "3", true, ""));
        rows.add(new RawItem("EnlightenedJourney", "redDye", "Red dye", "ItemID.REDDYE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("EnlightenedJourney", "sackOfPotatoes", "Sack of potatoes (10)", "ItemID.SACK_POTATO_10", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("EnlightenedJourney", "silk10", "Silk", "ItemID.SILK", "ITEM_ID", "10", true, ""));
        rows.add(new RawItem("EnlightenedJourney", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("EnlightenedJourney", "unlitCandle", "Unlit candle", "ItemID.UNLIT_CANDLE", "ITEM_ID", "1", true, "ItemID.UNLIT_BLACK_CANDLE"));
        rows.add(new RawItem("EnlightenedJourney", "willowBranches12", "Willow branches", "ItemID.WILLOW_BRANCH", "ITEM_ID", "12", true, ""));
        rows.add(new RawItem("EnlightenedJourney", "yellowDye", "Yellow dye", "ItemID.YELLOWDYE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("FairytaleI", "dramenOrLunarStaff", "Dramen or lunar staff", "ItemID.DRAMEN_STAFF", "ITEM_ID", "1", false, "ItemID.LUNAR_MOONCLAN_LIMINAL_STAFF"));
        rows.add(new RawItem("FairytaleI", "draynorSkull", "Draynor skull", "ItemID.FAIRY_SKULL", "ITEM_ID", "1", true, ""));
    }

    private static void addItems4(List<RawItem> rows)
    {
        rows.add(new RawItem("FairytaleI", "ghostspeak", "Ghostspeak amulet", "ItemCollections.GHOSTSPEAK", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("FairytaleI", "secateurs", "Secateurs", "ItemID.SECATEURS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("FairytaleI", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("FairytaleII", "dramenOrLunarStaff", "Dramen or lunar staff", "ItemID.DRAMEN_STAFF", "ITEM_ID", "1", false, "ItemID.LUNAR_MOONCLAN_LIMINAL_STAFF"));
        rows.add(new RawItem("FairytaleII", "pestleAndMortar", "Pestle and mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("FairytaleII", "vialOfWater", "Vial of water", "ItemID.VIAL_WATER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("FallenFromGrace", "chisel", "Chisel", "ItemCollections.CHISEL", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("FallenFromGrace", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("FallenFromGrace", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("FamilyCrest", "antipoison", "At least one dose of antipoison or superantipoison", "ItemCollections.ANTIPOISONS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("FamilyCrest", "bass", "Bass", "ItemID.BASS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("FamilyCrest", "necklaceMould", "Necklace mould", "ItemID.NECKLACE_MOULD", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("FamilyCrest", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("FamilyCrest", "ringMould", "Ring mould", "ItemID.RING_MOULD", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("FamilyCrest", "ruby2", "Ruby", "ItemID.RUBY", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("FamilyCrest", "salmon", "Salmon", "ItemID.SALMON", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("FamilyCrest", "shrimp", "Shrimps", "ItemID.SHRIMP", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("FamilyCrest", "swordfish", "Swordfish", "ItemID.SWORDFISH", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("FamilyCrest", "tuna", "Tuna", "ItemID.TUNA", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("FamilyPest", "coins", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "500000", true, ""));
        rows.add(new RawItem("FightArena", "coins", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "5", true, ""));
        rows.add(new RawItem("FishingContest", "coins", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "5", true, ""));
        rows.add(new RawItem("FishingContest", "fishingRod", "Fishing Rod", "ItemID.FISHING_ROD", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("FishingContest", "garlic", "Garlic", "ItemID.GARLIC", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("FishingContest", "redVineWorm", "Red Vine Worm", "ItemID.RED_VINE_WORM", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("FishingContest", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("ForgettableTale", "barleyMalt2", "Barley malt", "ItemID.BARLEY_MALT", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("ForgettableTale", "beer", "Beer", "ItemID.BEER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ForgettableTale", "beerGlass", "Beer glass", "ItemID.BEER_GLASS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ForgettableTale", "bucketOfWater2", "Bucket of water", "ItemID.BUCKET_WATER", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("ForgettableTale", "coins500", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "500", true, ""));
        rows.add(new RawItem("ForgettableTale", "dibber", "Seed dibber", "ItemID.DIBBER", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("ForgettableTale", "dwarvenStout", "Dwarven stout", "ItemID.DWARVEN_STOUT", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ForgettableTale", "kebab", "Kebab", "ItemID.KEBAB", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ForgettableTale", "rake", "Rake", "ItemID.RAKE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("GardenOfTranquillity", "cabbageSeed3", "Cabbage seeds (6 to be safe)", "ItemID.CABBAGE_SEED", "ITEM_ID", "3", true, ""));
        rows.add(new RawItem("GardenOfTranquillity", "compost2", "Normal/Super/Ultra compost", "ItemID.BUCKET_COMPOST", "ITEM_ID", "2", true, "ItemID.BUCKET_SUPERCOMPOST|ItemID.BUCKET_ULTRACOMPOST"));
        rows.add(new RawItem("GardenOfTranquillity", "dibber", "Seed dibber", "ItemID.DIBBER", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("GardenOfTranquillity", "essence", "Rune/Pure essence", "ItemID.BLANKRUNE", "ITEM_ID", "1", true, "ItemID.BLANKRUNE_HIGH"));
        rows.add(new RawItem("GardenOfTranquillity", "fishingRod", "Fishing rod", "ItemID.FISHING_ROD", "ITEM_ID", "1", false, "ItemID.FLY_FISHING_ROD"));
        rows.add(new RawItem("GardenOfTranquillity", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("GardenOfTranquillity", "marigoldSeed", "Marigold seed", "ItemID.MARIGOLD_SEED", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("GardenOfTranquillity", "onionSeed3", "Onion seeds (6 to be safe)", "ItemID.ONION_SEED", "ITEM_ID", "3", true, ""));
        rows.add(new RawItem("GardenOfTranquillity", "pestle", "Pestle and mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("GardenOfTranquillity", "plantCure2", "Plant cure", "ItemID.PLANT_CURE", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("GardenOfTranquillity", "plantPot", "Filled plant pot", "ItemID.PLANTPOT_COMPOST", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("GardenOfTranquillity", "rake", "Rake", "ItemID.RAKE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("GardenOfTranquillity", "ringOfCharos", "Ring of Charos", "ItemID.RING_OF_CHAROS", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("GardenOfTranquillity", "secateurs", "Secateurs", "ItemID.SECATEURS", "ITEM_ID", "1", false, "ItemID.FAIRY_ENCHANTED_SECATEURS"));
        rows.add(new RawItem("GardenOfTranquillity", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("GardenOfTranquillity", "trowel", "Gardening trowel", "ItemID.GARDENING_TROWEL", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("GardenOfTranquillity", "wateringCan", "Watering can", "ItemCollections.WATERING_CANS", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem( "GertrudesCat", "bucketOfMilk", "ItemRequirement", "Bucket of milk", "ItemID.BUCKET_MILK", "ITEM_ID", "1", true, "", "HIDE:hasGivenFluffsMilkAndSardine", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"hasGivenFluffsMilkAndSardine\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "GertrudesCat.java" ));
        rows.add(new RawItem("GertrudesCat", "coins", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "100", true, ""));
        rows.add(new RawItem( "GertrudesCat", "sardineHighlighted", "ItemRequirement", "Raw Sardine", "ItemID.RAW_SARDINE", "ITEM_ID", "1", true, "", "HIDE:hasGivenFluffsMilkAndSardine", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"hasGivenFluffsMilkAndSardine\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "GertrudesCat.java" ));
        rows.add(new RawItem("GettingAhead", "bearFur", "Bear Fur", "ItemID.FUR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("GettingAhead", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("GettingAhead", "knife", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("GettingAhead", "nails", "Nails", "ItemCollections.NAILS", "ITEM_COLLECTION", "6", true, ""));
        rows.add(new RawItem("GettingAhead", "needle", "Needle", "ItemID.NEEDLE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("GettingAhead", "planks", "Planks", "ItemID.WOODPLANK", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("GettingAhead", "potOfFlour", "Pot of Flour", "ItemID.POT_FLOUR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("GettingAhead", "redDye", "Red Dye", "ItemID.REDDYE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("GettingAhead", "saw", "Any saw", "ItemID.POH_SAW", "ITEM_ID", "1", false, "ItemID.EYEGLO_CRYSTAL_SAW|ItemID.WEARABLE_SAW"));
        rows.add(new RawItem("GettingAhead", "softClay", "Soft Clay", "ItemID.SOFTCLAY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("GettingAhead", "thread", "Thread", "ItemID.THREAD", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "GhostsAhoy", "blueDye", "ItemRequirement", "Blue dye", "ItemID.BLUEDYE", "ITEM_ID", "3", true, "", "", "dyes", "[]", "BANK_CHECKABLE", "", "", "GhostsAhoy.java" ));
        rows.add(new RawItem("GhostsAhoy", "bucketOfSlime", "Bucket of slime", "ItemID.BUCKET_ECTOPLASM", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("GhostsAhoy", "charos", "Ring of Charos (a)", "ItemID.RING_OF_CHAROS_UNLOCKED", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem( "GhostsAhoy", "costumeNeedle", "ItemRequirement", "Costume needle", "ItemID.COSTUMENEEDLE", "ITEM_ID", "1", true, "", "", "needleThreadOrCostumeNeedle", "[]", "BANK_CHECKABLE", "", "", "GhostsAhoy.java" ));
        rows.add(new RawItem("GhostsAhoy", "ectoTokensCharos", "Ecto-token, OR 10 Ecto-Tokens and coins to travel by Charter Ship", "ItemID.ECTOTOKEN", "ITEM_ID", "20", true, ""));
        rows.add(new RawItem("GhostsAhoy", "ectoTokensNoCharos", "Ecto-token, OR 25 Ecto-Tokens and coins to travel by Charter Ship", "ItemID.ECTOTOKEN", "ITEM_ID", "31", true, ""));
        rows.add(new RawItem("GhostsAhoy", "ghostspeak", "Ghostspeak amulet", "ItemID.AMULET_OF_GHOSTSPEAK", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("GhostsAhoy", "knife", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("GhostsAhoy", "milk", "Bucket of milk", "ItemID.BUCKET_MILK", "ITEM_ID", "1", true, ""));
    }

    private static void addItems5(List<RawItem> rows)
    {
        rows.add(new RawItem( "GhostsAhoy", "needle", "ItemRequirement", "Needle", "ItemID.NEEDLE", "ITEM_ID", "1", false, "", "", "needleThread", "[]", "BANK_CHECKABLE", "", "", "GhostsAhoy.java" ));
        rows.add(new RawItem("GhostsAhoy", "nettleTea", "Nettle tea", "ItemID.BOWL_NETTLETEA", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("GhostsAhoy", "oakLongbow", "Oak longbow", "ItemID.OAK_LONGBOW", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "GhostsAhoy", "redDye", "ItemRequirement", "Red dye", "ItemID.REDDYE", "ITEM_ID", "3", true, "", "", "dyes", "[]", "BANK_CHECKABLE", "", "", "GhostsAhoy.java" ));
        rows.add(new RawItem("GhostsAhoy", "silk", "Silk", "ItemID.SILK", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("GhostsAhoy", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem( "GhostsAhoy", "thread", "ItemRequirement", "Thread", "ItemID.THREAD", "ITEM_ID", "1", true, "", "", "needleThread", "[]", "BANK_CHECKABLE", "", "", "GhostsAhoy.java" ));
        rows.add(new RawItem( "GhostsAhoy", "yellowDye", "ItemRequirement", "Yellow dye", "ItemID.YELLOWDYE", "ITEM_ID", "3", true, "", "", "dyes", "[]", "BANK_CHECKABLE", "", "", "GhostsAhoy.java" ));
        rows.add(new RawItem("GoblinDiplomacy", "blueDye", "Blue dye", "ItemID.BLUEDYE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("GoblinDiplomacy", "mailReq", "Goblin mail", "ItemID.GOBLIN_ARMOUR", "ITEM_ID", "3", true, ""));
        rows.add(new RawItem("GoblinDiplomacy", "orangeDye", "Orange dye", "ItemID.ORANGEDYE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("GrandTreeBalloonFlight", "magicLogs", "Magic logs", "ItemID.MAGIC_LOGS", "ITEM_ID", "3", true, ""));
        rows.add(new RawItem("GrimTales", "axe", "Any axe", "ItemCollections.AXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("GrimTales", "can", "Watering can with at least 1 use", "ItemCollections.WATERING_CANS", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem( "GrimTales", "dibber", "ItemRequirement", "Seed dibber", "ItemID.DIBBER", "ITEM_ID", "1", false, "", "HIDE:knowsBarbarianPlanting", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"knowsBarbarianPlanting\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "GrimTales.java" ));
        rows.add(new RawItem("GrimTales", "houseKey", "Door key", "ItemID.WITCHES_DOORKEY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("GrimTales", "tarrominUnf2", "Tarromin potion (unf)", "ItemID.TARROMINVIAL", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("HeroesQuest", "blackFullHelm", "Black full helm", "ItemID.BLACK_FULL_HELM", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("HeroesQuest", "blackPlatebody", "Black platebody", "ItemID.BLACK_PLATEBODY", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("HeroesQuest", "blackPlatelegs", "Black platelegs", "ItemID.BLACK_PLATELEGS", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem( "HeroesQuest", "dustyKeyHint", "KeyringRequirement", "Dusty key (obtainable in quest)", "KeyringCollection.DUSTY_KEY", "KEYRING", "1", false, "", "", "", "[]", "BANK_CHECKABLE", "", "", "HeroesQuest.java" ));
        rows.add(new RawItem("HeroesQuest", "fishingBait", "Fishing bait", "ItemID.FISHING_BAIT", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("HeroesQuest", "fishingRod", "Fishing rod", "ItemID.FISHING_ROD", "ITEM_ID", "1", false, "ItemID.OILY_FISHING_ROD"));
        rows.add(new RawItem("HeroesQuest", "harralanderUnf", "Harralander potion (unf)", "ItemID.HARRALANDERVIAL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("HeroesQuest", "iceGloves", "Ice gloves/Smiths gloves (i)", "ItemID.ICE_GLOVES", "ITEM_ID", "1", false, "ItemID.SMITHING_UNIFORM_GLOVES_ICE"));
        rows.add(new RawItem("HeroesQuest", "pickaxe", "Any pickaxe", "ItemID.BRONZE_PICKAXE", "ITEM_ID", "1", false, "ItemCollections.PICKAXES"));
        rows.add(new RawItem("HisFaithfulServants", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("HolyGrail", "excalibur", "Excalibur", "ItemID.EXCALIBUR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("HopespearsWill", "dramenStaff", "Dramen or lunar staff", "ItemCollections.FAIRY_STAFF", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("HopespearsWill", "ghostspeakAmulet", "Ghostspeak amulet", "ItemCollections.GHOSTSPEAK", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("HopespearsWill", "goblinPotion", "Goblin potion", "Arrays.asList(ItemID.LOTG_1DOSEGOBLIN, ItemID.LOTG_2DOSEGOBLIN, ItemID.LOTG_3DOSEGOBLIN, ItemID.LOTG_4DOSEGOBLIN)", "ITEM_LIST", "1", true, ""));
        rows.add(new RawItem("HopespearsWill", "ringOfVisibility", "Ring of Visibility", "ItemID.FD_RING_VISIBILITY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("HorrorFromTheDeep", "airRune", "Air rune", "ItemID.AIRRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("HorrorFromTheDeep", "arrow", "Any arrow", "ItemCollections.METAL_ARROWS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("HorrorFromTheDeep", "earthRune", "Earth rune", "ItemID.EARTHRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("HorrorFromTheDeep", "fireRune", "Fire rune", "ItemID.FIRERUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("HorrorFromTheDeep", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("HorrorFromTheDeep", "moltenGlass", "Molten glass", "ItemID.MOLTEN_GLASS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("HorrorFromTheDeep", "plank2", "Plank", "ItemID.WOODPLANK", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("HorrorFromTheDeep", "steelNails", "Steel nails", "ItemID.NAILS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("HorrorFromTheDeep", "swampTar1", "Swamp tar", "ItemID.SWAMP_TAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("HorrorFromTheDeep", "sword", "Any sword you're willing to lose", "ItemCollections.SWORDS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("HorrorFromTheDeep", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("HorrorFromTheDeep", "waterRune", "Water rune", "ItemID.WATERRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "IcthlarinsLittleHelper", "bagOfSaltOrBucket", "ItemRequirement", "Bag of Salt from a Slayer Master, or an empty bucket to get some", "ItemID.SLAYER_BAG_OF_SALT", "ITEM_ID", "1", true, "ItemID.ICS_LITTLE_PILEOFSALT|ItemID.BUCKET_EMPTY", "HIDE:givenSalt", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"givenSalt\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "IcthlarinsLittleHelper.java" ));
        rows.add(new RawItem( "IcthlarinsLittleHelper", "bucketOfSap", "ItemRequirement", "Bucket of sap", "ItemID.ICS_LITTLE_SAP_BUCKET", "ITEM_ID", "1", true, "", "HIDE:givenSap", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"givenSap\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "IcthlarinsLittleHelper.java" ));
        rows.add(new RawItem( "IcthlarinsLittleHelper", "coins30", "ItemRequirement", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "30", true, "", "HIDE:givenLinen", "coinsOrLinen", "[{\"Mode\":\"HIDE\",\"Expression\":\"givenLinen\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "IcthlarinsLittleHelper.java" ));
        rows.add(new RawItem("IcthlarinsLittleHelper", "coins600", "Coins or more for various payments", "ItemCollections.COINS", "ITEM_COLLECTION", "600", true, ""));
        rows.add(new RawItem( "IcthlarinsLittleHelper", "linen", "ItemRequirement", "Linen", "ItemID.ICS_LITTLE_LINEN", "ITEM_ID", "1", true, "", "HIDE:givenLinen", "coinsOrLinen", "[{\"Mode\":\"HIDE\",\"Expression\":\"givenLinen\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "IcthlarinsLittleHelper.java" ));
        rows.add(new RawItem("IcthlarinsLittleHelper", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("IcthlarinsLittleHelper", "waterskin4", "Waterskin(4), bring a few to avoid drinking it", "ItemID.WATER_SKIN4", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "IcthlarinsLittleHelper", "willowLog", "ItemRequirement", "Willow logs", "ItemID.WILLOW_LOGS", "ITEM_ID", "1", true, "", "HIDE:givenCarpenterLogs", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"givenCarpenterLogs\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "IcthlarinsLittleHelper.java" ));
        rows.add(new RawItem("ImpCatcher", "blackBead", "Black bead", "ItemID.BLACK_BEAD", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ImpCatcher", "redBead", "Red bead", "ItemID.RED_BEAD", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ImpCatcher", "whiteBead", "White bead", "ItemID.WHITE_BEAD", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ImpCatcher", "yellowBead", "Yellow bead", "ItemID.YELLOW_BEAD", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("InAidOfTheMyreque", "bronzeAxes10", "Bronze axe", "ItemID.BRONZE_AXE", "ITEM_ID", "10", true, ""));
        rows.add(new RawItem("InAidOfTheMyreque", "bucketTo5", "buckets (Can use 1 but is much slower)", "ItemID.BUCKET_EMPTY", "ITEM_ID", "5", true, ""));
        rows.add(new RawItem("InAidOfTheMyreque", "coal", "Coal", "ItemID.COAL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("InAidOfTheMyreque", "cosmicRune", "Cosmic rune", "ItemID.COSMICRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("InAidOfTheMyreque", "efaritaysAidOrSilverWeapon", "\"Silver weapon (including Silverlight + varieties), blessed \" +\n\t\t\t\"axe or Efaritay's Aid to damage vampyres\"", "ItemID.ARCLIGHT", "ITEM_ID", "1", true, "ItemID.DARKLIGHT|ItemID.SILVERLIGHT|ItemID.AGRITH_SILVERLIGHT_DYED|ItemID.POH_TROPHY_SILVERLIGHT|ItemID.SILVER_SICKLE_BLESSED|ItemID.SILVER_SICKLE|ItemID.VAMPYRE_RING|ItemID.DAGGER_WOLFBANE"));
        rows.add(new RawItem("InAidOfTheMyreque", "foodForChest", "Food to put in a chest, multiple pieces in case a Ghast eats some", "ItemCollections.GOOD_EATING_FOOD", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("InAidOfTheMyreque", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem( "InAidOfTheMyreque", "mackerel10", "ItemRequirement", "Raw mackerel", "ItemID.RAW_MACKEREL", "ITEM_ID", "10", true, "", "", "rawMackerelOrSnail10", "[]", "BANK_CHECKABLE", "", "", "InAidOfTheMyreque.java" ));
        rows.add(new RawItem("InAidOfTheMyreque", "mithrilBar", "Mithril bar", "ItemID.MITHRIL_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("InAidOfTheMyreque", "nails44", "Any nails", "ItemCollections.NAILS", "ITEM_COLLECTION", "44", true, ""));
        rows.add(new RawItem("InAidOfTheMyreque", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("InAidOfTheMyreque", "planks11", "Plank", "ItemID.WOODPLANK", "ITEM_ID", "11", true, ""));
        rows.add(new RawItem("InAidOfTheMyreque", "rope", "Rope", "ItemID.ROPE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("InAidOfTheMyreque", "sapphire", "Sapphire", "ItemID.SAPPHIRE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("InAidOfTheMyreque", "silverBar", "Silver bar", "ItemID.SILVER_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "InAidOfTheMyreque", "snails10", "ItemRequirement", "Raw snail", "ItemID.SNAIL_CORPSE1", "ITEM_ID", "1", true, "ItemID.SNAIL_CORPSE3|ItemID.SNAIL_CORPSE2", "", "rawMackerelOrSnail10", "[]", "BANK_CHECKABLE", "", "", "InAidOfTheMyreque.java" ));
        rows.add(new RawItem("InAidOfTheMyreque", "softClay", "Soft clay", "ItemID.SOFTCLAY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("InAidOfTheMyreque", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("InAidOfTheMyreque", "steelBars2", "Steel bar", "ItemID.STEEL_BAR", "ITEM_ID", "2", true, ""));
    }

    private static void addItems6(List<RawItem> rows)
    {
        rows.add(new RawItem("InAidOfTheMyreque", "swampPaste", "Swamp paste", "ItemID.SWAMPPASTE", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("InAidOfTheMyreque", "tinderboxes4", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "4", true, ""));
        rows.add(new RawItem("InAidOfTheMyreque", "waterRune", "Water rune", "ItemID.WATERRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("InSearchOfKnowledge", "food5", "Food", "ItemCollections.FISH_FOOD", "ITEM_COLLECTION", "5", true, ""));
        rows.add(new RawItem("InSearchOfKnowledge", "knife", "Knife or slash weapon to cut through a web", "ItemID.KNIFE", "ITEM_ID", "1", false, "ItemID.CERT_REINITIALISATION_15_INACTIVE|ItemID.WILDERNESS_SWORD_EASY|ItemID.WILDERNESS_SWORD_MEDIUM|ItemID.WILDERNESS_SWORD_HARD|ItemID.WILDERNESS_SWORD_ELITE"));
        rows.add(new RawItem( "InSearchOfTheMyreque", "coins10OrCharos.child1", "ItemRequirement", "Ring of Charos (a)", "ItemID.RING_OF_CHAROS_UNLOCKED", "ITEM_ID", "1", true, "", "", "coins10OrCharos", "[]", "BANK_CHECKABLE", "", "", "InSearchOfTheMyreque.java" ));
        rows.add(new RawItem( "InSearchOfTheMyreque", "coins10OrCharos.child2", "ItemRequirement", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "10", true, "", "", "coins10OrCharos", "[]", "BANK_CHECKABLE", "", "", "InSearchOfTheMyreque.java" ));
        rows.add(new RawItem("InSearchOfTheMyreque", "druidPouch5", "Charges in a druid pouch", "ItemID.DRUID_POUCH", "ITEM_ID", "5", true, ""));
        rows.add(new RawItem("InSearchOfTheMyreque", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("InSearchOfTheMyreque", "plank6", "Plank", "ItemID.WOODPLANK", "ITEM_ID", "6", true, ""));
        rows.add(new RawItem("InSearchOfTheMyreque", "steeldagger", "Steel dagger", "ItemID.STEEL_DAGGER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("InSearchOfTheMyreque", "steelLong", "Steel longsword", "ItemID.STEEL_LONGSWORD", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("InSearchOfTheMyreque", "steelMace", "Steel mace", "ItemID.STEEL_MACE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("InSearchOfTheMyreque", "steelNails225", "Steel nails", "ItemID.NAILS", "ITEM_ID", "225", true, ""));
        rows.add(new RawItem("InSearchOfTheMyreque", "steelSword2", "Steel sword", "ItemID.STEEL_SWORD", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("InSearchOfTheMyreque", "steelWarhammer", "Steel warhammer", "ItemID.STEEL_WARHAMMER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("KingsRansom", "animateRock", "Animate rock scroll", "ItemID.FAVOUR_ANIMATE_ROCK", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("KingsRansom", "blackKnightBody", "Black platebody", "ItemID.BLACK_PLATEBODY", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("KingsRansom", "blackKnightHelm", "Black full helm", "ItemID.BLACK_FULL_HELM", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("KingsRansom", "blackKnightLeg", "Black platelegs", "ItemID.BLACK_PLATELEGS", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("KingsRansom", "bronzeMed", "Bronze med helm", "ItemID.BRONZE_MED_HELM", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "KingsRansom", "grabOrLockpick.child1", "ItemRequirement", "Lockpick", "ItemID.LOCKPICK", "ITEM_ID", "1", true, "", "", "grabOrLockpick", "[]", "BANK_CHECKABLE", "", "", "KingsRansom.java" ));
        rows.add(new RawItem("KingsRansom", "granite", "Any granite", "ItemID.ENAKH_GRANITE_SMALL", "ITEM_ID", "1", true, "ItemID.ENAKH_GRANITE_MEDIUM|ItemID.ENAKH_GRANITE_TINY"));
        rows.add(new RawItem("KingsRansom", "ironChain", "Iron chainbody", "ItemID.IRON_CHAINBODY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "KingsRansom", "telegrab.child1", "ItemRequirement", "Law rune", "ItemID.LAWRUNE", "ITEM_ID", "1", true, "", "", "telegrab", "[]", "BANK_CHECKABLE", "", "", "KingsRansom.java" ));
        rows.add(new RawItem( "KingsRansom", "telegrab.child2.child1", "ItemRequirement", "Air runes", "ItemCollections.AIR_RUNE", "ITEM_COLLECTION", "1", true, "", "", "telegrab.child2", "[]", "BANK_CHECKABLE", "", "", "KingsRansom.java" ));
        rows.add(new RawItem( "KingsRansom", "telegrab.child2.child2", "ItemRequirement", "Air staff", "ItemCollections.AIR_STAFF", "ITEM_COLLECTION", "1", true, "", "", "telegrab.child2", "[]", "BANK_CHECKABLE", "", "", "KingsRansom.java" ));
        rows.add(new RawItem( "LandOfTheGoblins", "blueDye", "ItemRequirement", "Blue dye", "ItemID.BLUEDYE", "ITEM_ID", "1", true, "", "HIDE:new Conditions(LogicType.OR, unlockedDoor, ekeleshuunKey)", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"new Conditions(LogicType.OR, unlockedDoor, ekeleshuunKey)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "LandOfTheGoblins.java" ));
        rows.add(new RawItem( "LandOfTheGoblins", "coins", "ItemRequirement", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "5", true, "", "HIDE:new Conditions(LogicType.OR, unlockedDoor, saragorgakKey)", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"new Conditions(LogicType.OR, unlockedDoor, saragorgakKey)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "LandOfTheGoblins.java" ));
        rows.add(new RawItem( "LandOfTheGoblins", "fishingRod", "ItemRequirement", "Fishing rod", "ItemID.FISHING_ROD", "ITEM_ID", "1", true, "", "HIDE:new Conditions(LogicType.OR, unlockedDoor, saragorgakKey)", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"new Conditions(LogicType.OR, unlockedDoor, saragorgakKey)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "LandOfTheGoblins.java" ));
        rows.add(new RawItem( "LandOfTheGoblins", "goblinMail", "ItemRequirement", "Goblin mail", "ItemID.GOBLIN_ARMOUR", "ITEM_ID", "1", true, "", "HIDE:unlockedDoor", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"unlockedDoor\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "LandOfTheGoblins.java" ));
        rows.add(new RawItem("LandOfTheGoblins", "lightSource", "Light source", "ItemCollections.LIGHT_SOURCES", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem( "LandOfTheGoblins", "orangeDye", "ItemRequirement", "Orange dye", "ItemID.ORANGEDYE", "ITEM_ID", "1", true, "", "HIDE:new Conditions(LogicType.OR, unlockedDoor, nargoshuunKey)", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"new Conditions(LogicType.OR, unlockedDoor, nargoshuunKey)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "LandOfTheGoblins.java" ));
        rows.add(new RawItem( "LandOfTheGoblins", "pestleAndMortar", "ItemRequirement", "Pestle and mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", true, "", "HIDE:new Conditions(LogicType.OR, unlockedDoor, huzamogaarbKey)", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"new Conditions(LogicType.OR, unlockedDoor, huzamogaarbKey)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "LandOfTheGoblins.java" ));
        rows.add(new RawItem( "LandOfTheGoblins", "purpleDye", "ItemRequirement", "Purple dye", "ItemID.PURPLEDYE", "ITEM_ID", "1", true, "", "HIDE:new Conditions(LogicType.OR, unlockedDoor, horogothgarKey)", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"new Conditions(LogicType.OR, unlockedDoor, horogothgarKey)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "LandOfTheGoblins.java" ));
        rows.add(new RawItem( "LandOfTheGoblins", "rawSlimyEel", "ItemRequirement", "Raw slimy eel", "ItemID.MORT_SLIMEY_EEL", "ITEM_ID", "1", true, "", "HIDE:new Conditions(LogicType.OR, unlockedDoor, saragorgakKey)", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"new Conditions(LogicType.OR, unlockedDoor, saragorgakKey)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "LandOfTheGoblins.java" ));
        rows.add(new RawItem("LandOfTheGoblins", "toadflaxPotionUnf", "Toadflax potion (unf)", "ItemID.TOADFLAXVIAL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "LandOfTheGoblins", "vial", "ItemRequirement", "Vial", "ItemID.VIAL_EMPTY", "ITEM_ID", "1", true, "", "HIDE:new Conditions(LogicType.OR, unlockedDoor, huzamogaarbKey)", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"new Conditions(LogicType.OR, unlockedDoor, huzamogaarbKey)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "LandOfTheGoblins.java" ));
        rows.add(new RawItem( "LandOfTheGoblins", "yellowDye", "ItemRequirement", "Yellow dye", "ItemID.YELLOWDYE", "ITEM_ID", "1", true, "", "HIDE:new Conditions(LogicType.OR, unlockedDoor, yurkolgokhKey)", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"new Conditions(LogicType.OR, unlockedDoor, yurkolgokhKey)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "LandOfTheGoblins.java" ));
        rows.add(new RawItem( "LegendsQuest", "air30", "ItemRequirement", "Air runes", "ItemID.AIRRUNE", "ITEM_ID", "30", true, "", "SHOW:new SkillRequirement(Skill.MAGIC, 66)", "elemental30", "[{\"Mode\":\"SHOW\",\"Expression\":\"new SkillRequirement(Skill.MAGIC, 66)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "LegendsQuest.java" ));
        rows.add(new RawItem("LegendsQuest", "anyNotes", "Radimus notes", "ItemID.THKARAMJAMAP", "ITEM_ID", "1", true, "ItemID.THKARAMJAMAPCOMP"));
        rows.add(new RawItem("LegendsQuest", "ardrigal", "Ardrigal", "ItemID.ARDRIGAL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("LegendsQuest", "charcoal3", "Charcoal", "ItemID.CHARCOAL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "LegendsQuest", "cosmic3", "ItemRequirement", "Cosmic rune", "ItemID.COSMICRUNE", "ITEM_ID", "3", true, "", "", "chargeOrbRunes", "[]", "BANK_CHECKABLE", "", "", "LegendsQuest.java" ));
        rows.add(new RawItem("LegendsQuest", "diamond", "Diamond", "ItemID.DIAMOND", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "LegendsQuest", "earth30", "ItemRequirement", "Earth runes", "ItemID.EARTHRUNE", "ITEM_ID", "30", true, "", "SHOW:new SkillRequirement(Skill.MAGIC, 60)", "elemental30", "[{\"Mode\":\"SHOW\",\"Expression\":\"new SkillRequirement(Skill.MAGIC, 60)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "LegendsQuest.java" ));
        rows.add(new RawItem("LegendsQuest", "earthRune", "Earth rune", "ItemID.EARTHRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("LegendsQuest", "emerald", "Emerald", "ItemID.EMERALD", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "LegendsQuest", "fire30", "ItemRequirement", "Fire runes", "ItemID.FIRERUNE", "ITEM_ID", "30", true, "", "SHOW:new SkillRequirement(Skill.MAGIC, 63)", "elemental30", "[{\"Mode\":\"SHOW\",\"Expression\":\"new SkillRequirement(Skill.MAGIC, 63)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "LegendsQuest.java" ));
        rows.add(new RawItem("LegendsQuest", "goldBar2", "Gold bar", "ItemID.GOLD_BAR", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("LegendsQuest", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("LegendsQuest", "jade", "Jade", "ItemID.JADE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("LegendsQuest", "lawRune2", "Law rune", "ItemID.LAWRUNE", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("LegendsQuest", "lockpick", "Lockpick (multiple in case they break)", "ItemID.LOCKPICK", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("LegendsQuest", "machete", "A machete", "ItemCollections.MACHETE", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("LegendsQuest", "mindRune", "Mind rune", "ItemID.MINDRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("LegendsQuest", "opal", "Opal", "ItemID.OPAL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("LegendsQuest", "papyrus3", "Papyrus", "ItemID.PAPYRUS", "ITEM_ID", "3", true, ""));
        rows.add(new RawItem("LegendsQuest", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("LegendsQuest", "rope", "Rope", "ItemID.ROPE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("LegendsQuest", "ruby", "Ruby", "ItemID.RUBY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("LegendsQuest", "runeOrDragonAxe", "Rune or Dragon axe", "ItemID.RUNE_AXE", "ITEM_ID", "1", false, "ItemID.DRAGON_AXE"));
        rows.add(new RawItem("LegendsQuest", "sapphire", "Sapphire", "ItemID.SAPPHIRE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("LegendsQuest", "snakeWeed", "Snake weed", "ItemID.SNAKE_WEED", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("LegendsQuest", "soulRune", "Soul rune", "ItemID.SOULRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("LegendsQuest", "topaz", "Red topaz", "ItemID.RED_TOPAZ", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("LegendsQuest", "unpoweredOrb", "Unpowered orb", "ItemID.STAFFORB", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("LegendsQuest", "vialOfWater", "Vial of water", "ItemID.VIAL_WATER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "LegendsQuest", "water30", "ItemRequirement", "Water runes", "ItemID.WATERRUNE", "ITEM_ID", "30", true, "", "SHOW:new SkillRequirement(Skill.MAGIC, 56)", "elemental30", "[{\"Mode\":\"SHOW\",\"Expression\":\"new SkillRequirement(Skill.MAGIC, 56)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "LegendsQuest.java" ));
        rows.add(new RawItem("LostCity", "axe", "Any axe", "ItemID.BRONZE_AXE", "ITEM_ID", "1", false, "ItemCollections.AXES"));
        rows.add(new RawItem("LostCity", "knife", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("LunarDiplomacy", "airTalisman", "Access to the Air Altar", "ItemCollections.AIR_ALTAR", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("LunarDiplomacy", "bullseyeLantern", "Bullseye lantern", "ItemID.BULLSEYE_LANTERN_UNLIT", "ITEM_ID", "1", false, "ItemID.TOG_SAPPHIRE_LANTERN_UNLIT"));
        rows.add(new RawItem("LunarDiplomacy", "dramenStaff", "Dramen staff", "ItemID.DRAMEN_STAFF", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("LunarDiplomacy", "earthTalisman", "Access to the Earth Altar", "ItemCollections.EARTH_ALTAR", "ITEM_COLLECTION", "1", false, ""));
    }

    private static void addItems7(List<RawItem> rows)
    {
        rows.add(new RawItem("LunarDiplomacy", "fireTalisman", "Access to the Fire Altar", "ItemCollections.FIRE_ALTAR", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("LunarDiplomacy", "guam", "Guam leaf", "ItemID.GUAM_LEAF", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("LunarDiplomacy", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("LunarDiplomacy", "marrentill", "Marrentill", "ItemID.MARENTILL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("LunarDiplomacy", "needle", "Needle", "ItemID.NEEDLE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("LunarDiplomacy", "pestle", "Pestle and mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("LunarDiplomacy", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("LunarDiplomacy", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("LunarDiplomacy", "thread", "Thread", "ItemID.THREAD", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("LunarDiplomacy", "tinderboxHighlighted", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("LunarDiplomacy", "waterTalisman", "Access to the Water Altar", "ItemCollections.WATER_ALTAR", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("MA2Locator", "guthixStaff", "Guthix staff", "ItemID.GUTHIX_STAFF", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MA2Locator", "knife", "Knife or sharp weapon to cut through a web", "ItemID.KNIFE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MA2Locator", "saradominStaff", "Saradomin staff", "ItemID.SARADOMIN_STAFF", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MA2Locator", "zamorakStaff", "Zamorak staff", "ItemID.ZAMORAK_STAFF", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MakingFriendsWithMyArm", "boltOfCloth", "Bolt of cloth", "ItemID.CLOTH", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MakingFriendsWithMyArm", "cadavaBerries", "Cadava berries", "ItemID.CADAVABERRIES", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MakingFriendsWithMyArm", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("MakingFriendsWithMyArm", "mahogPlanks5", "Mahogany plank", "ItemID.PLANK_MAHOGANY", "ITEM_ID", "5", true, ""));
        rows.add(new RawItem("MakingFriendsWithMyArm", "saw", "Saw", "ItemCollections.SAW", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("MakingHistory", "ghostSpeakAmulet", "Ghostspeak amulet", "ItemCollections.GHOSTSPEAK", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("MakingHistory", "saphAmulet", "Sapphire amulet", "ItemID.STRUNG_SAPPHIRE_AMULET", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MakingHistory", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("MerlinsCrystal", "batBones", "Bat bones", "ItemID.BAT_BONES", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MerlinsCrystal", "bread", "Bread", "ItemID.BREAD", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MerlinsCrystal", "bucketOfWax", "Bucket of wax", "ItemID.BUCKET_WAX", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MerlinsCrystal", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("MonkeyMadnessI", "ballOfWool", "Ball of wool", "ItemID.BALL_OF_WOOL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MonkeyMadnessI", "bananaReq", "Banana", "ItemID.BANANA", "ITEM_ID", "5", true, ""));
        rows.add(new RawItem("MonkeyMadnessI", "goldBar", "Gold bar", "ItemID.GOLD_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MonkeyMadnessI", "monkeyBonesOrCorpse", "Monkey bones or corpse", "ItemID.MM_NORMAL_MONKEY_BONES", "ITEM_ID", "1", true, "ItemID.TBWT_MONKEY_CORPSE"));
        rows.add(new RawItem("MonkeyMadnessII", "chiselSidebar", "Chisel (obtainable in quest)", "ItemCollections.CHISEL", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("MonkeyMadnessII", "grape", "Grapes", "ItemID.GRAPES", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MonkeyMadnessII", "hammerSidebar", "Hammer (obtainable in quest)", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("MonkeyMadnessII", "lemon", "Lemon", "ItemID.LEMON", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MonkeyMadnessII", "lightSource", "A lightsource", "ItemCollections.LIGHT_SOURCES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("MonkeyMadnessII", "logs", "Logs", "ItemID.LOGS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MonkeyMadnessII", "mspeakAmulet", "M'speak amulet", "ItemID.MM_AMULET_OF_MONKEY_SPEAK", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("MonkeyMadnessII", "ninjaGreegree", "Ninja greegree", "ItemID.MM_MONKEY_GREEGREE_FOR_SMALL_NINJA_MONKEY", "ITEM_ID", "1", false, "ItemID.MM_MONKEY_GREEGREE_FOR_MEDIUM_NINJA_MONKEY"));
        rows.add(new RawItem("MonkeyMadnessII", "pestle", "Pestle and mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("MonkeyMadnessII", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem( "MonkeyMadnessII", "talisman", "ItemRequirement", "Monkey talisman", "ItemID.MM_MONKEY_TALISMAN", "ITEM_ID", "1", true, "", "", "talismanOr1000Coins", "[]", "BANK_CHECKABLE", "", "", "MonkeyMadnessII.java" ));
        rows.add(new RawItem( "MonkeyMadnessII", "talismanOr1000Coins.child2", "ItemRequirement", "1000 coins", "ItemCollections.COINS", "ITEM_COLLECTION", "1000", true, "", "", "talismanOr1000Coins", "[]", "BANK_CHECKABLE", "", "", "MonkeyMadnessII.java" ));
        rows.add(new RawItem("MonkeyMadnessII", "translationBook", "Translation book", "ItemID.GRANDTREE_TRANSLATIONBOOK", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MonksFriend", "jugOfWater", "Jug of Water", "ItemID.JUG_WATER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MonksFriend", "log", "Logs", "ItemID.LOGS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MountainDaughter", "axe", "Any axe", "ItemCollections.AXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("MountainDaughter", "gloves", "Almost any gloves", "ItemID.LEATHER_GLOVES", "ITEM_ID", "1", false, "ItemID.HUNDRED_GAUNTLETS_LEVEL_10|ItemID.HUNDRED_GAUNTLETS_LEVEL_9|ItemID.HUNDRED_GAUNTLETS_LEVEL_8|ItemID.HUNDRED_GAUNTLETS_LEVEL_7|ItemID.HUNDRED_GAUNTLETS_LEVEL_6|ItemID.HUNDRED_GAUNTLETS_LEVEL_5|ItemID.HUNDRED_GAUNTLETS_LEVEL_4|ItemID.HUNDRED_GAUNTLETS_LEVEL_3|ItemID.HUNDRED_GAUNTLETS_LEVEL_2|ItemID.HUNDRED_GAUNTLETS_LEVEL_1|ItemID.FEROCIOUS_GLOVES|ItemID.GRACEFUL_GLOVES|ItemID.GRANITE_GLOVES"));
        rows.add(new RawItem("MountainDaughter", "pickaxe", "Any pickaxe", "ItemID.BRONZE_PICKAXE", "ITEM_ID", "1", false, "ItemCollections.PICKAXES"));
        rows.add(new RawItem("MountainDaughter", "plank", "Any plank", "ItemID.WOODPLANK", "ITEM_ID", "1", false, "ItemID.PLANK_OAK|ItemID.PLANK_TEAK|ItemID.PLANK_MAHOGANY"));
        rows.add(new RawItem("MountainDaughter", "pole", "A staff or a pole", "ItemID.MDAUGHTER_STICK", "ITEM_ID", "1", false, "ItemID.LUNAR_MOONCLAN_LIMINAL_STAFF|ItemID.PLAINSTAFF|ItemID.BATTLESTAFF|ItemCollections.AIR_STAFF|ItemCollections.WATER_STAFF|ItemCollections.EARTH_STAFF|ItemCollections.FIRE_STAFF"));
        rows.add(new RawItem("MountainDaughter", "rope", "Rope", "ItemID.ROPE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MourningsEndPartI", "bearFur", "Bear fur", "ItemID.FUR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MourningsEndPartI", "blueDye", "Blue dye", "ItemID.BLUEDYE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "MourningsEndPartI", "coal20AndTar.child2", "ItemRequirement", "Barrel of coal tar + 10-20 coal", "ItemID.COAL", "ITEM_ID", "10", true, "", "", "coal20AndTar", "[]", "BANK_CHECKABLE", "", "", "MourningsEndPartI.java" ));
        rows.add(new RawItem( "MourningsEndPartI", "coalTar", "ItemRequirement", "Barrel of coal tar", "ItemID.REGICIDE_BARREL_TAR", "ITEM_ID", "1", true, "", "", "coal20AndTar", "[]", "BANK_CHECKABLE", "", "", "MourningsEndPartI.java" ));
        rows.add(new RawItem("MourningsEndPartI", "feather", "Feather", "ItemID.FEATHER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MourningsEndPartI", "greenDye", "Green dye", "ItemID.GREENDYE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MourningsEndPartI", "leather", "Leather", "ItemID.LEATHER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MourningsEndPartI", "magicLogs", "Magic logs", "ItemID.MAGIC_LOGS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "MourningsEndPartI", "naphtha", "ItemRequirement", "Barrel of naphtha", "ItemID.REGICIDE_BARREL_NAPHTHA", "ITEM_ID", "1", true, "", "", "coal20OrNaphtha", "[]", "BANK_CHECKABLE", "", "", "MourningsEndPartI.java" ));
        rows.add(new RawItem("MourningsEndPartI", "ogreBellows", "Ogre bellows", "ItemID.EMPTY_OGRE_BELLOWS", "ITEM_ID", "1", false, "ItemID.FILLED_OGRE_BELLOW1|ItemID.FILLED_OGRE_BELLOW2|ItemID.FILLED_OGRE_BELLOW3"));
        rows.add(new RawItem("MourningsEndPartI", "redDye", "Red dye", "ItemID.REDDYE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MourningsEndPartI", "rottenApple", "Rotten apple", "ItemID.ROTTENAPPLES", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MourningsEndPartI", "silk2", "Silk", "ItemID.SILK", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("MourningsEndPartI", "toadCrunchies", "Toad crunchies (can be Premade t'd crunch)", "ItemID.TOAD_CRUNCHIES", "ITEM_ID", "1", true, "ItemID.ALUFT_TOAD_CRUNCHIES|ItemID.PREMADE_TOAD_CRUNCHIES"));
        rows.add(new RawItem("MourningsEndPartI", "waterBucket", "Bucket of water", "ItemID.BUCKET_WATER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MourningsEndPartI", "yellowDye", "Yellow dye", "ItemID.YELLOWDYE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MourningsEndPartII", "chisel", "Chisel", "ItemCollections.CHISEL", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("MourningsEndPartII", "deathTalismanHeader", "Access to the Death Altar or 50 items asked of you by a dwarf", "ItemCollections.DEATH_ALTAR", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem( "MourningsEndPartII", "gasMask", "ItemRequirement", "Gas mask", "ItemID.GASMASK", "ITEM_ID", "1", false, "", "", "mournersOutfit", "[]", "BANK_CHECKABLE", "", "", "MourningsEndPartII.java" ));
        rows.add(new RawItem( "MourningsEndPartII", "mournerBoots", "ItemRequirement", "Mourner boots", "ItemID.MOURNING_MOURNER_BOOTS", "ITEM_ID", "1", false, "", "", "mournersOutfit", "[]", "BANK_CHECKABLE", "", "", "MourningsEndPartII.java" ));
        rows.add(new RawItem( "MourningsEndPartII", "mournerCloak", "ItemRequirement", "Mourner cloak", "ItemID.MOURNING_MOURNER_CLOAK", "ITEM_ID", "1", false, "", "", "mournersOutfit", "[]", "BANK_CHECKABLE", "", "", "MourningsEndPartII.java" ));
        rows.add(new RawItem( "MourningsEndPartII", "mournerGloves", "ItemRequirement", "Mourner gloves", "ItemID.MOURNING_MOURNER_GLOVES", "ITEM_ID", "1", false, "", "", "mournersOutfit", "[]", "BANK_CHECKABLE", "", "", "MourningsEndPartII.java" ));
        rows.add(new RawItem( "MourningsEndPartII", "mournerTop", "ItemRequirement", "Mourner top", "ItemID.MOURNING_MOURNER_TOP", "ITEM_ID", "1", false, "", "", "mournersOutfit", "[]", "BANK_CHECKABLE", "", "", "MourningsEndPartII.java" ));
    }

    private static void addItems8(List<RawItem> rows)
    {
        rows.add(new RawItem( "MourningsEndPartII", "mournerTrousers", "ItemRequirement", "Mourner trousers", "ItemID.MOURNING_MOURNER_LEGS", "ITEM_ID", "1", false, "", "", "mournersOutfit", "[]", "BANK_CHECKABLE", "", "", "MourningsEndPartII.java" ));
        rows.add(new RawItem("MourningsEndPartII", "rope", "Rope", "ItemID.ROPE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MurderMystery", "pot", "Pot", "ItemID.POT_EMPTY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("MyArmsBigAdventure", "bucket", "Bucket", "ItemID.BUCKET_EMPTY", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("MyArmsBigAdventure", "climbingBoots", "Climbing boots", "ItemCollections.CLIMBING_BOOTS", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("MyArmsBigAdventure", "dibber", "Seed dibber", "ItemID.DIBBER", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("MyArmsBigAdventure", "rake", "Rake", "ItemID.RAKE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("MyArmsBigAdventure", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("MyArmsBigAdventure", "superCompost8", "Supercompost", "ItemID.BUCKET_SUPERCOMPOST", "ITEM_ID", "8", true, ""));
        rows.add(new RawItem("MyArmsBigAdventure", "ugthanki3", "Ugthanki dung", "ItemID.FEUD_CAMEL_POOH_BUCKET", "ITEM_ID", "3", true, ""));
        rows.add(new RawItem("NatureSpirit", "ghostspeak", "Ghostspeak amulet", "ItemID.AMULET_OF_GHOSTSPEAK", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("NatureSpirit", "silverSickle", "Silver sickle", "ItemID.SILVER_SICKLE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ObservatoryQuest", "bronzeBar", "Bronze bar", "ItemID.BRONZE_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ObservatoryQuest", "moltenGlass", "Molten glass", "ItemID.MOLTEN_GLASS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ObservatoryQuest", "plank", "Plank", "ItemID.WOODPLANK", "ITEM_ID", "3", true, ""));
        rows.add(new RawItem("OlafsQuest", "axe", "Any axe", "ItemCollections.AXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("OlafsQuest", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("OlafsQuest", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("OneSmallFavour", "bronzeBar", "Bronze bar", "ItemID.BRONZE_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("OneSmallFavour", "chisel", "Chisel", "ItemCollections.CHISEL", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("OneSmallFavour", "emptyCup", "Empty cup", "ItemID.CUP_EMPTY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("OneSmallFavour", "guam2", "Guam leaf", "ItemID.GUAM_LEAF", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("OneSmallFavour", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("OneSmallFavour", "harralander", "Harralander", "ItemID.HARRALANDER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("OneSmallFavour", "hotWaterBowl", "Bowl of hot water", "ItemID.BOWL_HOT_WATER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("OneSmallFavour", "ironBar", "Iron bar", "ItemID.IRON_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("OneSmallFavour", "marrentill", "Marrentill", "ItemID.MARENTILL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("OneSmallFavour", "pot", "Pot", "ItemID.POT_EMPTY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("OneSmallFavour", "steelBars4", "Steel bar", "ItemID.STEEL_BAR", "ITEM_ID", "4", true, ""));
        rows.add(new RawItem("Pandemonium", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("Pandemonium", "saw", "Saw", "ItemCollections.SAW", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("PerilousMoon", "bigFishingNet", "Big fishing net", "ItemID.BIG_NET", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("PerilousMoon", "knife", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("PerilousMoon", "pestleAndMortar", "Pestle and mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("PerilousMoon", "rope", "Rope", "ItemID.ROPE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("PiratesTreasure", "sixtyCoins", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "60", true, ""));
        rows.add(new RawItem("PiratesTreasure", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("PiratesTreasure", "tenBananas", "Bananas", "ItemID.BANANA", "ITEM_ID", "10", true, ""));
        rows.add(new RawItem("PlagueCity", "bucketOfMilk", "Bucket of milk", "ItemID.BUCKET_MILK", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("PlagueCity", "chocolateDust", "Chocolate dust", "ItemID.CHOCOLATE_DUST", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("PlagueCity", "dwellberries", "Dwellberries", "ItemID.DWELLBERRIES", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("PlagueCity", "rope", "Rope", "ItemID.ROPE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("PlagueCity", "snapeGrass", "Snape grass", "ItemID.SNAPE_GRASS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("PlagueCity", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("PriestInPeril", "bucket", "Bucket", "ItemID.BUCKET_EMPTY", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("PriestInPeril", "runeEssence", "Rune or Pure Essence", "ItemID.BLANKRUNE", "ITEM_ID", "50", true, "ItemID.BLANKRUNE_HIGH"));
        rows.add(new RawItem("PrinceAliRescue", "ashes", "Ashes", "ItemID.ASHES", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("PrinceAliRescue", "ballsOfWool3", "Balls of wool", "ItemID.BALL_OF_WOOL", "ITEM_ID", "3", true, ""));
        rows.add(new RawItem("PrinceAliRescue", "beers3", "Beers", "ItemID.BEER", "ITEM_ID", "3", true, ""));
        rows.add(new RawItem("PrinceAliRescue", "bronzeBar", "Bronze bar", "ItemID.BRONZE_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("PrinceAliRescue", "bucketOfWater", "Bucket of water", "ItemID.BUCKET_WATER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("PrinceAliRescue", "coins100", "Coins minimum", "ItemCollections.COINS", "ITEM_COLLECTION", "100", true, ""));
        rows.add(new RawItem("PrinceAliRescue", "pinkSkirt", "Pink skirt", "ItemID.PINK_SKIRT", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("PrinceAliRescue", "potOfFlour", "Pot of flour", "ItemID.POT_FLOUR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("PrinceAliRescue", "redberries", "Redberries", "ItemID.REDBERRIES", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("PrinceAliRescue", "rope", "Rope", "ItemID.ROPE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("PrinceAliRescue", "softClay", "Soft clay", "ItemID.SOFTCLAY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("PrinceAliRescue", "yellowDye", "Yellow dye", "ItemID.YELLOWDYE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("PryingTimes", "captainsLogRequirement", "Captain's log", "ItemID.SAILING_LOG", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("PryingTimes", "hammerRequirement", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("PryingTimes", "redberryPieRequirement", "Redberry pie", "ItemID.REDBERRY_PIE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("PryingTimes", "steelBarRequirement", "Steel bar", "ItemID.STEEL_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RagAndBoneManI", "coins", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("RagAndBoneManI", "logs", "Logs", "ItemID.LOGS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RagAndBoneManI", "pots", "Pot", "ItemID.POT_EMPTY", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RagAndBoneManI", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RagAndBoneManII", "axe", "Any axe", "ItemCollections.AXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("RagAndBoneManII", "coins", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem( "RagAndBoneManII", "dustyKey", "KeyringRequirement", "Dusty Key", "KeyringCollection.DUSTY_KEY", "KEYRING", "1", false, "", "", "", "[]", "BANK_CHECKABLE", "", "", "RagAndBoneManII.java" ));
        rows.add(new RawItem("RagAndBoneManII", "fishingExplosive", "Fishing explosive", "ItemID.FISHING_EXPLOSIVE", "ITEM_ID", "10", true, "ItemID.SLAYERGUIDE_FISHING_EXPLOSIVE"));
        rows.add(new RawItem("RagAndBoneManII", "iceCooler", "Ice coolers", "ItemID.SLAYER_ICY_WATER", "ITEM_ID", "10", true, ""));
        rows.add(new RawItem("RagAndBoneManII", "lightSource", "Light source", "ItemCollections.LIGHT_SOURCES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("RagAndBoneManII", "logs", "Logs", "ItemID.LOGS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RagAndBoneManII", "mirrorShield", "Mirror shield", "ItemID.SLAYER_MIRROR_SHIELD", "ITEM_ID", "1", false, "ItemID.VIKINGEXILE_V_SHIELD|ItemID.V_SHIELD"));
        rows.add(new RawItem("RagAndBoneManII", "pots", "Pot", "ItemID.POT_EMPTY", "ITEM_ID", "1", false, ""));
    }

    private static void addItems9(List<RawItem> rows)
    {
        rows.add(new RawItem("RagAndBoneManII", "rangedWeapon", "Ranged weapon for killing vultures", "ItemCollections.CROSSBOWS", "ITEM_COLLECTION", "1", true, "ItemCollections.BOWS"));
        rows.add(new RawItem("RagAndBoneManII", "rope", "Rope", "ItemID.ROPE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RagAndBoneManII", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RatCatchers", "bucketOfMilk", "Bucket of milk", "ItemID.BUCKET_MILK", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RatCatchers", "catspeakAmuletOrDS2", "Catspeak amulet", "ItemID.ICS_LITTLE_AMULET_OF_CATSPEAK", "ITEM_ID", "1", true, "ItemID.TWOCATS_AMULETOFCATSPEAK"));
        rows.add(new RawItem("RatCatchers", "cheese", "Cheese", "ItemID.CHEESE", "ITEM_ID", "1", true, "ItemID.RATCATCHERS_POISONEDCHEESE"));
        rows.add(new RawItem("RatCatchers", "coins101", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "101", true, ""));
        rows.add(new RawItem("RatCatchers", "fish8", "Fish or more, raw or cooked", "ItemCollections.FISH_FOOD", "ITEM_COLLECTION", "8", true, "ItemCollections.RAW_FISH"));
        rows.add(new RawItem("RatCatchers", "kwuarm", "Clean kwuarm", "ItemID.KWUARM", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RatCatchers", "marrentill", "Marrentill", "ItemID.MARENTILL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RatCatchers", "potOfWeeds", "Pot of weeds", "ItemID.RATCATCHERS_WEEDPOT", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RatCatchers", "redEggs", "Red spiders' eggs", "ItemID.RED_SPIDERS_EGGS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RatCatchers", "snakeCharm", "Snake charm", "ItemID.SNAKE_FLUTE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RatCatchers", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RatCatchers", "unicornHornDust", "Unicorn horn dust", "ItemID.UNICORN_HORN_DUST", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RatCatchers", "vial", "Empty vial", "ItemID.VIAL_EMPTY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("Regicide", "arrows", "Arrows (metal, unpoisoned)", "ItemCollections.METAL_ARROWS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("Regicide", "bow", "Bow (not crossbow)", "ItemCollections.BOWS", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("Regicide", "coal20", "Coal", "ItemID.COAL", "ITEM_ID", "20", true, ""));
        rows.add(new RawItem("Regicide", "cookedRabbit", "Cooked rabbit", "ItemID.COOKED_RABBIT", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("Regicide", "gloves", "Gloves which fully cover your hand", "ItemCollections.QUICKLIME_GLOVES", "ITEM_COLLECTION", "1", false, "ItemCollections.GRACEFUL_GLOVES"));
        rows.add(new RawItem("Regicide", "limestone", "Limestone", "ItemID.LIMESTONE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("Regicide", "pestle", "Pestle and mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("Regicide", "pot", "Pot", "ItemID.POT_EMPTY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("Regicide", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("Regicide", "stripOfCloth", "Strip of cloth", "ItemID.REGICIDE_CLOTH", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("Regicide", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RFDAwowogei", "bananaHighlighted", "Banana", "ItemID.BANANA", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDAwowogei", "gorillaGreegree", "Gorilla greegree", "ItemID.MM_MONKEY_GREEGREE_FOR_NORMAL_GORILLA", "ITEM_ID", "1", false, "ItemID.MM_MONKEY_GREEGREE_FOR_ANCIENT_MONKEY_SKULL|ItemID.MM_MONKEY_GREEGREE_FOR_BEARDED_GORILLA"));
        rows.add(new RawItem("RFDAwowogei", "knife", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RFDAwowogei", "mAmulet", "M'speak amulet", "ItemID.MM_AMULET_OF_MONKEY_SPEAK", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDAwowogei", "monkeyNutsHighlighted", "Monkey nuts", "ItemID.MM_MONKEY_NUTS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDAwowogei", "ninjaGreegree", "Ninja greegree", "ItemID.MM_MONKEY_GREEGREE_FOR_SMALL_NINJA_MONKEY", "ITEM_ID", "1", false, "ItemID.MM_MONKEY_GREEGREE_FOR_MEDIUM_NINJA_MONKEY|ItemID.MM2_KRUK_GREEGREE"));
        rows.add(new RawItem("RFDAwowogei", "pestleAndMortar", "Pestle and mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RFDAwowogei", "ropeHighlighted", "Rope", "ItemID.ROPE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RFDAwowogei", "zombieGreegree", "Zombie greegree", "ItemID.MM_MONKEY_GREEGREE_FOR_SMALL_ZOMBIE_MONKEY", "ITEM_ID", "1", false, "ItemID.MM_MONKEY_GREEGREE_FOR_LARGE_ZOMBIE_MONKEY"));
        rows.add(new RawItem("RFDDwarf", "asgarniaAle4", "Asgarnian ale", "ItemID.ASGARNIAN_ALE", "ITEM_ID", "4", true, ""));
        rows.add(new RawItem("RFDDwarf", "bowlOfWater", "Bowl of water", "ItemID.BOWL_WATER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDDwarf", "coins320", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "320", true, ""));
        rows.add(new RawItem("RFDDwarf", "egg", "Egg", "ItemID.EGG", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDDwarf", "flour", "Pot of flour", "ItemID.POT_FLOUR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDDwarf", "iceGloves", "Ice gloves/smiths gloves(i)/normal gloves/telekinetic grab", "ItemID.ICE_GLOVES", "ITEM_ID", "1", false, "ItemID.LEATHER_GLOVES|ItemID.SMITHING_UNIFORM_GLOVES_ICE"));
        rows.add(new RawItem("RFDDwarf", "milk", "Bucket of milk", "ItemID.BUCKET_MILK", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDFinal", "iceGloves", "Ice gloves", "ItemID.ICE_GLOVES", "ITEM_ID", "1", false, "ItemID.SMITHING_UNIFORM_GLOVES_ICE"));
        rows.add(new RawItem("RFDFinal", "restorePotions", "Restore potions for Karamel", "ItemCollections.RESTORE_POTIONS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("RFDGoblins", "blueGreenPurpledye", "A blue, green, or purple dye", "ItemID.BLUEDYE", "ITEM_ID", "1", true, "ItemID.GREENDYE|ItemID.PURPLEDYE"));
        rows.add(new RawItem("RFDGoblins", "bread", "Bread", "ItemID.BREAD", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDGoblins", "bucketOfWater", "Bucket of water", "ItemID.BUCKET_WATER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDGoblins", "charcoal", "Charcoal", "ItemID.CHARCOAL", "ITEM_ID", "1", true, "ItemID.GROUND_CHARCOAL"));
        rows.add(new RawItem("RFDGoblins", "fishingBait", "Fishing bait", "ItemID.FISHING_BAIT", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDGoblins", "knife", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RFDGoblins", "orange", "Orange", "ItemID.ORANGE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDGoblins", "spice", "Spice or gnome spice", "ItemID.SPICESPOT", "ITEM_ID", "1", false, "ItemID.GNOME_SPICE"));
        rows.add(new RawItem("RFDLumbridgeGuide", "egg", "Egg", "ItemID.EGG", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDLumbridgeGuide", "flour", "Pot of flour", "ItemID.POT_FLOUR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDLumbridgeGuide", "milk", "Bucket of milk", "ItemID.BUCKET_MILK", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDLumbridgeGuide", "tin", "Cake tin", "ItemID.CAKE_TIN", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDPiratePete", "breadHighlighted", "Bread (more if you burn cake)", "ItemID.BREAD", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDPiratePete", "bronzeWire3", "Bronze wire", "ItemID.BRONZECRAFTWIRE", "ITEM_ID", "3", true, ""));
        rows.add(new RawItem("RFDPiratePete", "fishBowl", "Empty fishbowl", "ItemID.FISHBOWL_EMPTY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDPiratePete", "knifeHighlighted", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RFDPiratePete", "needle", "Needle", "ItemID.NEEDLE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RFDPiratePete", "pestleHighlighted", "Pestle and mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RFDPiratePete", "rawCodHighlighted", "Raw cod (more if you burn cake)", "ItemID.RAW_COD", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDSirAmikVarze", "axe", "Any axe", "ItemCollections.AXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("RFDSirAmikVarze", "bucketOfMilk", "Bucket of milk", "ItemID.BUCKET_MILK", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDSirAmikVarze", "cornflour", "Pot of cornflour", "ItemID.CHICKENQUEST_POT_CORNFLOUR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDSirAmikVarze", "dramenBranch", "Dramen branch", "ItemID.DRAMEN_BRANCH", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDSirAmikVarze", "dramenStaffOrLunar", "Dramen/lunar staff", "ItemID.DRAMEN_STAFF", "ITEM_ID", "1", false, "ItemID.LUNAR_MOONCLAN_LIMINAL_STAFF"));
        rows.add(new RawItem("RFDSirAmikVarze", "iceGloves", "Ice gloves or smiths gloves(i)", "ItemID.ICE_GLOVES", "ITEM_ID", "1", false, "ItemID.SMITHING_UNIFORM_GLOVES_ICE"));
        rows.add(new RawItem( "RFDSirAmikVarze", "machete", "ItemRequirement", "Any machete", "ItemCollections.MACHETE", "ITEM_COLLECTION", "1", false, "", "", "macheteAndRadimus.whenFalse.child1|macheteAndRadimus.whenTrue", "[]", "BANK_CHECKABLE", "", "", "RFDSirAmikVarze.java" ));
        rows.add(new RawItem("RFDSirAmikVarze", "pestleAndMortar", "Pestle and mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RFDSirAmikVarze", "potOfCream", "Pot of cream", "ItemID.POT_OF_CREAM", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "RFDSirAmikVarze", "radimusNotes", "ItemRequirement", "Radimus notes", "ItemID.THKARAMJAMAP", "ITEM_ID", "1", false, "ItemID.THKARAMJAMAPCOMP", "", "macheteAndRadimus.whenFalse.child1", "[]", "BANK_CHECKABLE", "", "", "RFDSirAmikVarze.java" ));
        rows.add(new RawItem("RFDSirAmikVarze", "rawChicken", "Raw chicken", "ItemID.RAW_CHICKEN", "ITEM_ID", "1", true, ""));
    }

    private static void addItems10(List<RawItem> rows)
    {
        rows.add(new RawItem("RFDSirAmikVarze", "vanillaPod", "Vanilla pod", "ItemID.CHICKENQUEST_VANILLA_POD", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDSkrachUglogwee", "axeHighlighted", "Any axe", "ItemCollections.AXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("RFDSkrachUglogwee", "ballOfWool", "Balls of wool", "ItemID.BALL_OF_WOOL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDSkrachUglogwee", "chompy", "Raw chompy", "ItemID.RAW_CHOMPY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDSkrachUglogwee", "ironSpit", "Iron spit", "ItemID.SPIT_IRON", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RFDSkrachUglogwee", "log", "Any log to burn", "ItemCollections.LOGS_FOR_FIRE", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem( "RFDSkrachUglogwee", "ogreArrows", "ItemRequirement", "Ogre arrow", "ItemID.OGRE_ARROW", "ITEM_ID", "1", true, "ItemID.ZOGRE_BRUTAL_BRONZE|ItemID.ZOGRE_BRUTAL_IRON|ItemID.ZOGRE_BRUTAL_STEEL|ItemID.ZOGRE_BRUTAL_BLACK|ItemID.ZOGRE_BRUTAL_MITHRIL|ItemID.ZOGRE_BRUTAL_ADAMANT|ItemID.ZOGRE_BRUTAL_RUNE", "", "ogreBowAndArrows", "[]", "BANK_CHECKABLE", "", "", "RFDSkrachUglogwee.java" ));
        rows.add(new RawItem("RFDSkrachUglogwee", "ogreBellows", "Ogre bellows", "ItemID.EMPTY_OGRE_BELLOWS", "ITEM_ID", "1", false, "ItemID.FILLED_OGRE_BELLOW1|ItemID.FILLED_OGRE_BELLOW2|ItemID.FILLED_OGRE_BELLOW3"));
        rows.add(new RawItem( "RFDSkrachUglogwee", "ogreBow", "ItemRequirement", "Ogre bow", "ItemID.OGRE_BOW", "ITEM_ID", "1", false, "ItemID.ZOGRE_BOW", "", "ogreBowAndArrows", "[]", "BANK_CHECKABLE", "", "", "RFDSkrachUglogwee.java" ));
        rows.add(new RawItem("RFDSkrachUglogwee", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("RFDSkrachUglogwee", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RFDStart", "ashes", "Ashes", "ItemID.ASHES", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDStart", "eyeOfNewt", "Eye of newt", "ItemID.EYE_OF_NEWT", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDStart", "fruitBlast", "Fruit blast", "ItemID.FRUIT_BLAST", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDStart", "greenmansAle", "Greenman's ale", "ItemID.GREENMANS_ALE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RFDStart", "rottenTomato", "Rotten tomato", "ItemID.ROTTEN_TOMATO", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RomeoAndJuliet", "cadavaBerry", "Cadava berries", "ItemID.CADAVABERRIES", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("RovingElves", "keyHint", "Key (obtainable in quest)", "ItemID.GOLRIE_KEY_WATERFALL_QUEST", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RovingElves", "pebbleHint", "Glarial's pebble (obtainable in quest)", "ItemID.GLARIALS_PEBBLE_WATERFALL_QUEST", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RovingElves", "rope", "Rope", "ItemID.ROPE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RovingElves", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem( "RoyalTrouble", "coal5", "ItemRequirement", "Coal", "ItemID.COAL", "ITEM_ID", "5", true, "", "", "coalOrPickaxe.whenFalse|coalOrPickaxe.whenTrue.child1", "[]", "BANK_CHECKABLE", "", "", "RoyalTrouble.java" ));
        rows.add(new RawItem( "RoyalTrouble", "pickaxe", "ItemRequirement", "A pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, "", "", "coalOrPickaxe.whenTrue.child1", "[]", "BANK_CHECKABLE", "", "", "RoyalTrouble.java" ));
        rows.add(new RawItem("RumDeal", "dibber", "Seed dibber", "ItemID.DIBBER", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RumDeal", "rake", "Rake", "ItemID.RAKE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("RumDeal", "slayerGloves", "Slayer gloves", "ItemID.SLAYERGUIDE_SLAYER_GLOVES", "ITEM_ID", "1", false, "ItemID.DEAL_SLAYER_GLOVES"));
        rows.add(new RawItem( "ScorpionCatcher", "dustyKey", "KeyringRequirement", "Dusty Key", "KeyringCollection.DUSTY_KEY", "KEYRING", "1", false, "", "HIDE:has70Agility", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"has70Agility\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "ScorpionCatcher.java" ));
        rows.add(new RawItem( "Scrambled", "bowlOfWater", "ItemRequirement", "Bowl of water", "ItemID.BOWL_WATER", "ITEM_ID", "1", true, "", "SHOW:stillNeedToHelpNezketi", "", "[{\"Mode\":\"SHOW\",\"Expression\":\"stillNeedToHelpNezketi\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "Scrambled.java" ));
        rows.add(new RawItem( "Scrambled", "hammer", "ItemRequirement", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", true, "", "SHOW:or(stillNeedToHelpAcatzin, stillNeedToHelpKauayotl)", "", "[{\"Mode\":\"SHOW\",\"Expression\":\"or(stillNeedToHelpAcatzin, stillNeedToHelpKauayotl)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "Scrambled.java" ));
        rows.add(new RawItem( "Scrambled", "saw", "ItemRequirement", "Saw", "ItemCollections.SAW", "ITEM_COLLECTION", "1", true, "", "SHOW:stillNeedToHelpKauayotl", "", "[{\"Mode\":\"SHOW\",\"Expression\":\"stillNeedToHelpKauayotl\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "Scrambled.java" ));
        rows.add(new RawItem( "Scrambled", "sixNails", "ItemRequirement", "Nail", "ItemCollections.NAILS", "ITEM_COLLECTION", "6", true, "", "SHOW:stillNeedToHelpKauayotl", "", "[{\"Mode\":\"SHOW\",\"Expression\":\"stillNeedToHelpKauayotl\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "Scrambled.java" ));
        rows.add(new RawItem( "Scrambled", "twoPlanks", "ItemRequirement", "Plank", "ItemID.WOODPLANK", "ITEM_ID", "2", true, "", "SHOW:stillNeedToHelpKauayotl", "", "[{\"Mode\":\"SHOW\",\"Expression\":\"stillNeedToHelpKauayotl\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "Scrambled.java" ));
        rows.add(new RawItem("SeaSlug", "swampPaste", "Swamp paste", "ItemID.SWAMPPASTE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SecretsOfTheNorth", "coins", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "100", true, ""));
        rows.add(new RawItem("SecretsOfTheNorth", "lockpick", "Lockpick", "ItemID.LOCKPICK", "ITEM_ID", "1", false, "ItemID.KR_HAIRCLIP"));
        rows.add(new RawItem("SecretsOfTheNorth", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("ShadesOfMortton", "ashes2", "Ashes", "ItemID.ASHES", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("ShadesOfMortton", "coins5000", "Coins for building materials, or 18000 if you want to buy a Flamtaer hammer", "ItemCollections.COINS", "ITEM_COLLECTION", "5000", true, ""));
        rows.add(new RawItem("ShadesOfMortton", "hammerOrFlam", "Hammer or Flamtaer Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, "ItemID.FLAMTAER_HAMMER"));
        rows.add(new RawItem("ShadesOfMortton", "log", "A log whose pyre version you can burn", "ItemID.LOGS", "ITEM_ID", "1", true, "ItemID.OAK_LOGS|ItemID.MAPLE_LOGS|ItemID.WILLOW_LOGS|ItemID.YEW_LOGS|ItemID.MAGIC_LOGS|ItemID.REDWOOD_LOGS"));
        rows.add(new RawItem("ShadesOfMortton", "tarrominUnf2", "Tarromin potion (unf)", "ItemID.TARROMINVIAL", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("ShadesOfMortton", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("ShadowOfTheStorm", "darkItems", "pieces of black clothing", "ItemID.AGRITH_DESERT_SHIRT_DYED", "ITEM_ID", "3", false, "ItemID.AGRITH_DESERT_ROBE_DYED|ItemID.BLACK_CHAINBODY|ItemID.BLACK_PLATEBODY|ItemID.BLACK_PLATELEGS|ItemID.BLACK_FULL_HELM|ItemID.BLACK_MED_HELM|ItemID.HUNDRED_GAUNTLETS_LEVEL_5|ItemID.PRIEST_GOWN|ItemID.PRIEST_ROBE|ItemID.MYSTIC_HAT_DARK|ItemID.MYSTIC_ROBE_BOTTOM_DARK|ItemID.MYSTIC_ROBE_TOP_DARK|ItemID.SECRET_GHOST_BOOTS|ItemID.SECRET_GHOST_CLOAK|ItemID.SECRET_GHOST_GLOVES|ItemID.SECRET_GHOST_HAT|ItemID.SECRET_GHOST_TOP|ItemID.SECRET_GHOST_BOTTOM|ItemID.BLACKROBEBOTTOM|ItemID.BLACKROBETOP|ItemID.ANTISANTA_BOOTS|ItemID.ANTISANTA_GLOVES|ItemID.ANTISANTA_JACKET|ItemID.ANTISANTA_MASK|ItemID.ANTISANTA_PANTS|ItemID.BLACKWIZHAT|ItemID.BLACK_CAPE|ItemID.BLACK_PARTYHAT|ItemID.HALLOWEENMASK_BLACK|ItemID.DRAGONMASK_BLACK|ItemID.BLACK_UNICORN_MASK|ItemID.BLACK_DEMON_MASK|ItemID.BLACK_DRAGONHIDE_BODY|ItemID.BLACK_DRAGONHIDE_CHAPS|ItemID.BLACK_DRAGON_VAMBRACES|ItemID.BLACK_ROBE|ItemID.GRACEFUL_BOOTS_HALLOWED|ItemID.GRACEFUL_CAPE_HALLOWED|ItemID.GRACEFUL_GLOVES_HALLOWED|ItemID.GRACEFUL_HOOD_HALLOWED|ItemID.GRACEFUL_LEGS_HALLOWED|ItemID.GRACEFUL_TOP_HALLOWED"));
        rows.add(new RawItem("ShadowOfTheStorm", "silverBar", "Silver bar", "ItemID.SILVER_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ShadowOfTheStorm", "silverlight", "Silverlight", "ItemID.SILVERLIGHT", "ITEM_ID", "1", false, "ItemID.AGRITH_SILVERLIGHT_DYED"));
        rows.add(new RawItem( "ShadowsOfCustodia", "fishingRod", "ItemRequirement", "Fishing rod", "ItemID.FISHING_ROD", "ITEM_ID", "1", true, "", "SHOW:needToFishClothFromLog", "", "[{\"Mode\":\"SHOW\",\"Expression\":\"needToFishClothFromLog\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "ShadowsOfCustodia.java" ));
        rows.add(new RawItem( "ShadowsOfCustodia", "fourMapleLogs", "ItemRequirement", "Maple logs", "ItemID.MAPLE_LOGS", "ITEM_ID", "4", true, "", "SHOW:needToReinforceWall", "", "[{\"Mode\":\"SHOW\",\"Expression\":\"needToReinforceWall\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "ShadowsOfCustodia.java" ));
        rows.add(new RawItem( "ShadowsOfCustodia", "fourWillowLongbows", "ItemRequirement", "Willow longbow", "ItemID.WILLOW_LONGBOW", "ITEM_ID", "4", true, "", "SHOW:needsToHandInWillowLongbows", "", "[{\"Mode\":\"SHOW\",\"Expression\":\"needsToHandInWillowLongbows\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "ShadowsOfCustodia.java" ));
        rows.add(new RawItem( "ShadowsOfCustodia", "hammer", "ItemRequirement", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", true, "", "SHOW:needToReinforceWall", "", "[{\"Mode\":\"SHOW\",\"Expression\":\"needToReinforceWall\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "ShadowsOfCustodia.java" ));
        rows.add(new RawItem("SheepHerder", "coins100", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "100", true, ""));
        rows.add(new RawItem("SheepShearer", "shears", "Shears", "ItemID.SHEARS", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("ShieldOfArravPhoenixGang", "twentyCoins", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "20", true, ""));
        rows.add(new RawItem("ShiloVillage", "bones3", "Bones", "ItemID.BONES", "ITEM_ID", "3", true, ""));
        rows.add(new RawItem("ShiloVillage", "bronzeWire", "Bronze wire", "ItemID.BRONZECRAFTWIRE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ShiloVillage", "chisel", "Chisel", "ItemCollections.CHISEL", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("ShiloVillage", "rope", "Rope", "ItemID.ROPE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ShiloVillage", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("ShiloVillage", "torchOrCandle", "Lit torch or candle", "ItemID.TORCH_LIT", "ITEM_ID", "1", true, "ItemID.LIT_CANDLE"));
        rows.add(new RawItem("SinsOfTheFather", "axe", "Any axe", "ItemCollections.AXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("SinsOfTheFather", "chisel", "Chisel", "ItemCollections.CHISEL", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem( "SinsOfTheFather", "cosmicRune", "ItemRequirement", "Cosmic rune", "ItemID.COSMICRUNE", "ITEM_ID", "1", true, "", "", "enchantRunes", "[]", "BANK_CHECKABLE", "", "", "SinsOfTheFather.java" ));
        rows.add(new RawItem( "SinsOfTheFather", "enchantTablet", "ItemRequirement", "Ruby enchant tablet", "ItemID.POH_TABLET_ENCHANTRUBY", "ITEM_ID", "1", true, "", "", "enchantRubyRunesOrTablet", "[]", "BANK_CHECKABLE", "", "", "SinsOfTheFather.java" ));
        rows.add(new RawItem( "SinsOfTheFather", "fireRune5", "ItemRequirement", "Fire rune", "ItemCollections.FIRE_RUNE", "ITEM_COLLECTION", "5", true, "", "", "enchantRunes.child1", "[]", "BANK_CHECKABLE", "", "", "SinsOfTheFather.java" ));
        rows.add(new RawItem( "SinsOfTheFather", "fireStaff", "ItemRequirement", "Fire staff", "ItemCollections.FIRE_STAFF", "ITEM_COLLECTION", "1", true, "", "", "enchantRunes.child1", "[]", "BANK_CHECKABLE", "", "", "SinsOfTheFather.java" ));
        rows.add(new RawItem("SinsOfTheFather", "ivandisFlail", "Ivandis flail", "ItemID.IVANDIS_FLAIL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SinsOfTheFather", "knife", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("SinsOfTheFather", "ruby", "Ruby", "ItemID.RUBY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "SinsOfTheFather", "vyrewatchOutfit.child1", "ItemRequirement", "Vyrewatch top", "ItemID.VYRE_TORSO", "ITEM_ID", "1", true, "", "", "vyrewatchOutfit", "[]", "BANK_CHECKABLE", "", "", "SinsOfTheFather.java" ));
        rows.add(new RawItem( "SinsOfTheFather", "vyrewatchOutfit.child2", "ItemRequirement", "Vyrewatch legs", "ItemID.VYRE_LEGS", "ITEM_ID", "1", true, "", "", "vyrewatchOutfit", "[]", "BANK_CHECKABLE", "", "", "SinsOfTheFather.java" ));
        rows.add(new RawItem( "SinsOfTheFather", "vyrewatchOutfit.child3", "ItemRequirement", "Vyrewatch shoes", "ItemID.VYRE_SHOES", "ITEM_ID", "1", true, "", "", "vyrewatchOutfit", "[]", "BANK_CHECKABLE", "", "", "SinsOfTheFather.java" ));
        rows.add(new RawItem( "SinsOfTheFather", "vyrewatchOutfitOrCoins.child2", "ItemRequirement", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "1950", true, "", "", "vyrewatchOutfitOrCoins", "[]", "BANK_CHECKABLE", "", "", "SinsOfTheFather.java" ));
        rows.add(new RawItem("SkippyAndTheMogres", "bucketOfMilk", "Bucket of milk", "ItemID.BUCKET_MILK", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SkippyAndTheMogres", "bucketOfWater", "Bucket of water", "ItemID.BUCKET_WATER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SkippyAndTheMogres", "chocolateDust", "Chocolate dust", "ItemID.CHOCOLATE_DUST", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SkippyAndTheMogres", "nettleTea", "Nettle tea", "ItemID.BOWL_NETTLETEA", "ITEM_ID", "1", true, ""));
    }

    private static void addItems11(List<RawItem> rows)
    {
        rows.add(new RawItem("SkippyAndTheMogres", "snapeGrass", "Snape grass", "ItemID.SNAPE_GRASS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SleepingGiants", "chisel", "Chisel", "ItemCollections.CHISEL", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("SleepingGiants", "hammer", "Hammer", "ItemID.HAMMER", "ITEM_ID", "1", true, "ItemID.IMCANDO_HAMMER"));
        rows.add(new RawItem("SleepingGiants", "nails", "Nails", "ItemID.NAILS_BRONZE", "ITEM_ID", "1", true, "ItemID.NAILS_IRON|ItemID.NAILS|ItemID.NAILS_BLACK|ItemID.NAILS_MITHRIL|ItemID.NAILS_ADAMANT|ItemID.NAILS_RUNE"));
        rows.add(new RawItem("SleepingGiants", "oakLogs", "Oak Logs", "ItemID.OAK_LOGS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SleepingGiants", "wool", "Wool", "ItemID.WOOL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SongOfTheElves", "adamantChainbody", "Adamant chainbody", "ItemID.ADAMANT_CHAINBODY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SongOfTheElves", "axe", "Any axe", "ItemCollections.AXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("SongOfTheElves", "blackKnifeOrBlackDagger", "Black knife or black dagger", "ItemID.BLACK_KNIFE", "ITEM_ID", "1", true, "ItemID.BLACK_KNIFE_P|ItemID.BLACK_KNIFE_P_|ItemID.BLACK_KNIFE_P__|ItemID.BLACK_DAGGER|ItemID.BLACK_DAGGER_P|ItemID.BLACK_DAGGER_P_|ItemID.BLACK_DAGGER_P__"));
        rows.add(new RawItem("SongOfTheElves", "cabbage", "Cabbage", "ItemID.CABBAGE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SongOfTheElves", "cadantineSeed", "Cadantine seed", "ItemID.CADANTINE_SEED", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "SongOfTheElves", "gasMask", "ItemRequirement", "Gas mask", "ItemID.GASMASK", "ITEM_ID", "1", false, "", "", "mournersOutfit", "[]", "BANK_CHECKABLE", "", "", "SongOfTheElves.java" ));
        rows.add(new RawItem("SongOfTheElves", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("SongOfTheElves", "iritLeafOrFlowers", "Irit leaf or a flower", "ItemID.IRIT_LEAF", "ITEM_ID", "1", true, "ItemID.FLOWERS_WATERFALL_QUEST_RED|ItemID.FLOWERS_WATERFALL_QUEST_YELLOW|ItemID.FLOWERS_WATERFALL_QUEST_PURPLE|ItemID.FLOWERS_WATERFALL_QUEST_ORANGE|ItemID.FLOWERS_WATERFALL_QUEST_MIXED|ItemID.FLOWERS_WATERFALL_QUEST|ItemID.FLOWERS_WATERFALL_QUEST_BLACK|ItemID.FLOWERS_WATERFALL_QUEST_WHITE"));
        rows.add(new RawItem("SongOfTheElves", "limestoneBricks8", "Limestone brick", "ItemID.LIMESTONEBRICK", "ITEM_ID", "8", true, ""));
        rows.add(new RawItem( "SongOfTheElves", "mournerBoots", "ItemRequirement", "Mourner boots", "ItemID.MOURNING_MOURNER_BOOTS", "ITEM_ID", "1", false, "", "", "mournersOutfit", "[]", "BANK_CHECKABLE", "", "", "SongOfTheElves.java" ));
        rows.add(new RawItem( "SongOfTheElves", "mournerCloak", "ItemRequirement", "Mourner cloak", "ItemID.MOURNING_MOURNER_CLOAK", "ITEM_ID", "1", false, "", "", "mournersOutfit", "[]", "BANK_CHECKABLE", "", "", "SongOfTheElves.java" ));
        rows.add(new RawItem( "SongOfTheElves", "mournerGloves", "ItemRequirement", "Mourner gloves", "ItemID.MOURNING_MOURNER_GLOVES", "ITEM_ID", "1", false, "", "", "mournersOutfit", "[]", "BANK_CHECKABLE", "", "", "SongOfTheElves.java" ));
        rows.add(new RawItem( "SongOfTheElves", "mournerTop", "ItemRequirement", "Mourner top", "ItemID.MOURNING_MOURNER_TOP", "ITEM_ID", "1", false, "", "", "mournersOutfit", "[]", "BANK_CHECKABLE", "", "", "SongOfTheElves.java" ));
        rows.add(new RawItem( "SongOfTheElves", "mournerTrousers", "ItemRequirement", "Mourner trousers", "ItemID.MOURNING_MOURNER_LEGS", "ITEM_ID", "1", false, "", "", "mournersOutfit", "[]", "BANK_CHECKABLE", "", "", "SongOfTheElves.java" ));
        rows.add(new RawItem("SongOfTheElves", "natureRune", "Nature rune", "ItemID.NATURERUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SongOfTheElves", "pestleAndMortar", "Pestle and mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("SongOfTheElves", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("SongOfTheElves", "purpleDye", "Purple dye", "ItemID.PURPLEDYE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SongOfTheElves", "redDye", "Red dye", "ItemID.REDDYE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SongOfTheElves", "rope", "Rope", "ItemID.ROPE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("SongOfTheElves", "runiteBar", "Runite bar", "ItemID.RUNITE_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SongOfTheElves", "saw", "Saw", "ItemCollections.SAW", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("SongOfTheElves", "seedDibber", "Seed dibber", "ItemID.DIBBER", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("SongOfTheElves", "silk", "Silk", "ItemID.SILK", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SongOfTheElves", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("SongOfTheElves", "steelFullHelm", "Steel full helm", "ItemID.STEEL_FULL_HELM", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SongOfTheElves", "steelPlatebody", "Steel platebody", "ItemID.STEEL_PLATEBODY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SongOfTheElves", "steelPlatelegs", "Steel platelegs", "ItemID.STEEL_PLATELEGS", "ITEM_ID", "1", true, "ItemID.ARDOUGNE_KNIGHT_LEGS"));
        rows.add(new RawItem("SongOfTheElves", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("SongOfTheElves", "vialOfWater", "Vial of water", "ItemID.VIAL_WATER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SongOfTheElves", "wineOfZamorakOrZamorakBrew", "Wine of Zamorak or Zamorak brew", "ItemID.WINE_OF_ZAMORAK", "ITEM_ID", "1", true, "ItemID._1DOSEPOTIONOFZAMORAK|ItemID._2DOSEPOTIONOFZAMORAK|ItemID._3DOSEPOTIONOFZAMORAK|ItemID._4DOSEPOTIONOFZAMORAK"));
        rows.add(new RawItem("SpiritsOfTheElid", "airRune", "Air Rune", "ItemID.AIRRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SpiritsOfTheElid", "arrows", "Arrows for bow", "ItemCollections.METAL_ARROWS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("SpiritsOfTheElid", "bow", "Any bow", "ItemCollections.BOWS", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("SpiritsOfTheElid", "knife", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("SpiritsOfTheElid", "lawRune", "Law Rune", "ItemID.LAWRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SpiritsOfTheElid", "lightSource", "Light source", "ItemCollections.LIGHT_SOURCES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("SpiritsOfTheElid", "needle", "Needle", "ItemID.NEEDLE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("SpiritsOfTheElid", "pickaxe", "Any Pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("SpiritsOfTheElid", "rope", "Rope", "ItemID.ROPE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SpiritsOfTheElid", "thread", "Thread", "ItemID.THREAD", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("SwanSong", "blood5", "Blood rune", "ItemID.BLOODRUNE", "ITEM_ID", "5", true, ""));
        rows.add(new RawItem("SwanSong", "bones7", "Bones", "ItemID.BONES", "ITEM_ID", "7", true, ""));
        rows.add(new RawItem("SwanSong", "hammerPanel", "Hammer (obtainable in quest)", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("SwanSong", "ironBar5", "Iron bar", "ItemID.IRON_BAR", "ITEM_ID", "5", true, ""));
        rows.add(new RawItem("SwanSong", "lava10", "Lava rune", "ItemID.LAVARUNE", "ITEM_ID", "10", true, ""));
        rows.add(new RawItem("SwanSong", "log", "Any log", "ItemID.LOGS", "ITEM_ID", "1", true, "ItemID.OAK_LOGS|ItemID.WILLOW_LOGS|ItemID.MAPLE_LOGS|ItemID.YEW_LOGS|ItemID.MAGIC_LOGS|ItemID.TEAK_LOGS|ItemID.MAHOGANY_LOGS|ItemID.REDWOOD_LOGS"));
        rows.add(new RawItem("SwanSong", "mist10", "Mist rune", "ItemID.MISTRUNE", "ITEM_ID", "10", true, ""));
        rows.add(new RawItem("SwanSong", "pot", "Pot", "ItemID.POT_EMPTY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SwanSong", "potLid", "Pot lid", "ItemID.POTLID", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("SwanSong", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TaiBwoWannaiTrio", "agilityPotion4", "Agility Potion (4)", "ItemID._4DOSE1AGILITY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TaiBwoWannaiTrio", "coins", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("TaiBwoWannaiTrio", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem( "TaiBwoWannaiTrio", "knife", "ItemRequirement", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", false, "", "", "slicedBananaOrKnife", "[]", "BANK_CHECKABLE", "", "", "TaiBwoWannaiTrio.java" ));
        rows.add(new RawItem("TaiBwoWannaiTrio", "logsForFire", "Any logs to make a fire", "ItemCollections.LOGS_FOR_FIRE", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("TaiBwoWannaiTrio", "pestleAndMortar", "Pestle And Mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TaiBwoWannaiTrio", "rawKarambwan", "Raw karambwan", "ItemID.TBWT_RAW_KARAMBWAN", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "TaiBwoWannaiTrio", "slicedBanana", "ItemRequirement", "Sliced Banana", "ItemID.TBWT_SLICED_BANANA", "ITEM_ID", "1", true, "", "", "slicedBananaOrKnife", "[]", "BANK_CHECKABLE", "", "", "TaiBwoWannaiTrio.java" ));
        rows.add(new RawItem("TaiBwoWannaiTrio", "smallFishingNet", "Small Fishing Net", "ItemID.NET", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TaiBwoWannaiTrio", "spear", "Iron spear or better (You will lose the spear)", "ItemID.IRON_SPEAR", "ITEM_ID", "1", true, "ItemID.STEEL_SPEAR|ItemID.MITHRIL_SPEAR|ItemID.ADAMANT_SPEAR|ItemID.RUNE_SPEAR|ItemID.DRAGON_SPEAR"));
        rows.add(new RawItem("TaiBwoWannaiTrio", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TaleOfTheRighteous", "pickaxe", "A pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TaleOfTheRighteous", "rope", "Rope", "ItemID.ROPE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TearsOfGuthix", "chisel", "Chisel", "ItemCollections.CHISEL", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TearsOfGuthix", "litSapphireLantern", "Sapphire lantern", "ItemID.TOG_SAPPHIRE_LANTERN_LIT", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TearsOfGuthix", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TearsOfGuthix", "rope", "Rope", "ItemID.ROPE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TearsOfGuthix", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
    }

    private static void addItems12(List<RawItem> rows)
    {
        rows.add(new RawItem("TempleOfIkov", "knife", "Knife to get the boots of lightness", "ItemID.KNIFE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TempleOfIkov", "lightSource", "A light source to get the boots of lightness", "ItemCollections.LIGHT_SOURCES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TempleOfIkov", "limpwurt20", "Limpwurt (unnoted)", "ItemID.LIMPWURT_ROOT", "ITEM_ID", "20", true, ""));
        rows.add(new RawItem( "TempleOfIkov", "throwableWeapon", "ItemRequirement", "Throwable Weapon", "ItemCollections.THROWING_KNIVES", "ITEM_COLLECTION", "1", true, "ItemCollections.DARTS|ItemCollections.THROWING_AXES", "", "yewOrBetterBowOrThrowableWeapon", "[]", "BANK_CHECKABLE", "", "", "TempleOfIkov.java" ));
        rows.add(new RawItem( "TempleOfIkov", "yewOrBetterBow", "ItemRequirement", "Yew, magic, or dark bow", "ItemID.YEW_SHORTBOW", "ITEM_ID", "1", false, "ItemID.YEW_LONGBOW|ItemID.TRAIL_COMPOSITE_BOW_YEW|ItemID.MAGIC_SHORTBOW|ItemID.MAGIC_SHORTBOW_I|ItemID.MAGIC_LONGBOW|ItemID.DARKBOW", "", "yewOrBetterBowOrThrowableWeapon", "[]", "BANK_CHECKABLE", "", "", "TempleOfIkov.java" ));
        rows.add(new RawItem("TempleOfTheEye", "bucketOfWater", "Bucket of water", "ItemID.BUCKET_WATER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TempleOfTheEye", "chisel", "Chisel", "ItemCollections.CHISEL", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("TempleOfTheEye", "pickaxe", "Pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("TheBloodMoonRises", "blisterwoodFlail", "Blisterwood flail", "ItemID.BLISTERWOOD_FLAIL", "ITEM_ID", "1", true, "ItemID.HALLOWED_FLAIL"));
        rows.add(new RawItem( "TheBloodMoonRises", "vyreNobleOutfit.child1", "ItemRequirement", "Vyre noble top", "ItemID.VYRELORD_TORSO", "ITEM_ID", "1", true, "", "", "vyreNobleOutfit", "[]", "BANK_CHECKABLE", "", "", "TheBloodMoonRises.java" ));
        rows.add(new RawItem( "TheBloodMoonRises", "vyreNobleOutfit.child2", "ItemRequirement", "Vyre noble legs", "ItemID.VYRELORD_LEGS", "ITEM_ID", "1", true, "", "", "vyreNobleOutfit", "[]", "BANK_CHECKABLE", "", "", "TheBloodMoonRises.java" ));
        rows.add(new RawItem( "TheBloodMoonRises", "vyreNobleOutfit.child3", "ItemRequirement", "Vyre noble shoes", "ItemID.VYRELORD_SHOES", "ITEM_ID", "1", true, "", "", "vyreNobleOutfit", "[]", "BANK_CHECKABLE", "", "", "TheBloodMoonRises.java" ));
        rows.add(new RawItem( "TheCurseOfArrav", "anyGrappleableCrossbow", "ItemRequirement", "Any crossbow", "ItemCollections.CROSSBOWS", "ITEM_COLLECTION", "1", false, "", "HIDE:haveMetArrav", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"haveMetArrav\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "TheCurseOfArrav.java" ));
        rows.add(new RawItem( "TheCurseOfArrav", "anyPickaxe", "ItemRequirement", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, "", "HIDE:haveMinedAFullPath", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"haveMinedAFullPath\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "TheCurseOfArrav.java" ));
        rows.add(new RawItem( "TheCurseOfArrav", "dwellberries3", "ItemRequirement", "Dwellberries", "ItemID.DWELLBERRIES", "ITEM_ID", "3", true, "", "HIDE:haveMadeCanopicJar", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"haveMadeCanopicJar\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "TheCurseOfArrav.java" ));
        rows.add(new RawItem("TheCurseOfArrav", "insulatedBoots", "Insulated boots", "ItemID.SLAYER_BOOTS", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem( "TheCurseOfArrav", "mithrilGrapple", "ItemRequirement", "Mith grapple", "ItemID.XBOWS_GRAPPLE_TIP_BOLT_MITHRIL_ROPE", "ITEM_ID", "1", false, "", "HIDE:haveMetArrav", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"haveMetArrav\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "TheCurseOfArrav.java" ));
        rows.add(new RawItem( "TheCurseOfArrav", "ringOfLife", "ItemRequirement", "Ring of life", "ItemID.RING_OF_LIFE", "ITEM_ID", "1", true, "", "HIDE:haveMadeCanopicJar", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"haveMadeCanopicJar\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "TheCurseOfArrav.java" ));
        rows.add(new RawItem("TheDigSite", "charcoal", "Charcoal", "ItemID.CHARCOAL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheDigSite", "opal", "Opal", "ItemID.OPAL", "ITEM_ID", "1", true, "ItemID.UNCUT_OPAL"));
        rows.add(new RawItem("TheDigSite", "pestleAndMortar", "Pestle and mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheDigSite", "ropes2", "Rope", "ItemID.ROPE", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem( "TheDigSite", "tea", "ItemRequirement", "Cup of tea", "ItemID.CUP_OF_TEA", "ITEM_ID", "1", true, "", "HIDE:talkedToGuide", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"talkedToGuide\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "TheDigSite.java" ));
        rows.add(new RawItem("TheDigSite", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheDigSite", "vial", "Vial", "ItemID.VIAL_EMPTY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheEyesOfGlouphrie", "bucketOfSap", "Bucket of sap", "ItemID.ICS_LITTLE_SAP_BUCKET", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheEyesOfGlouphrie", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TheEyesOfGlouphrie", "mapleLog", "Maple logs", "ItemID.MAPLE_LOGS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheEyesOfGlouphrie", "mudRune", "Mud rune", "ItemID.MUDRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheEyesOfGlouphrie", "oakLog", "Oak logs", "ItemID.OAK_LOGS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheEyesOfGlouphrie", "pestleAndMortar", "Pestle and mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheEyesOfGlouphrie", "saw", "Saw", "ItemCollections.SAW", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TheFeud", "coins", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "800", true, ""));
        rows.add(new RawItem("TheFeud", "gloves", "Leather or Graceful Gloves", "ItemID.LEATHER_GLOVES", "ITEM_ID", "1", false, "ItemCollections.GRACEFUL_GLOVES"));
        rows.add(new RawItem( "TheFinalDawn", "bone", "ItemRequirement", "Any type of bone or raw meat", "ItemID.BONES", "ITEM_ID", "1", true, "ItemID.BIG_BONES|ItemID.BONES_BURNT|ItemID.WOLF_BONES|ItemID.BAT_BONES|ItemID.DAGANNOTH_KING_BONES|ItemID.TBWT_BEAST_BONES|ItemID.WYRM_BONES|ItemID.BABYWYRM_BONES|ItemID.BABYDRAGON_BONES|ItemID.WYVERN_BONES|ItemID.DRAGON_BONES|ItemID.DRAKE_BONES|ItemID.HYDRA_BONES|ItemID.LAVA_DRAGON_BONES|ItemID.DRAGON_BONES_SUPERIOR|ItemID.MM_NORMAL_MONKEY_BONES|ItemID.MM_BEARDED_GORILLA_MONKEY_BONES|ItemID.MM_NORMAL_GORILLA_MONKEY_BONES|ItemID.MM_LARGE_ZOMBIE_MONKEY_BONES|ItemID.MM_SMALL_ZOMBIE_MONKEY_BONES|ItemID.MM_SMALL_NINJA_MONKEY_BONES|ItemID.MM_MEDIUM_NINJA_MONKEY_BONES|ItemID.TBWT_JOGRE_BONES|ItemID.TBWT_BURNT_JOGRE_BONES|ItemID.ZOGRE_BONES|ItemID.ZOGRE_ANCESTRAL_BONES_FAYG|ItemID.ZOGRE_ANCESTRAL_BONES_RAURG|ItemID.ZOGRE_ANCESTRAL_BONES_OURG|ItemID.ALAN_BONES|ItemID.RAW_BEAR_MEAT|ItemID.RAW_BOAR_MEAT|ItemID.RAW_RAT_MEAT|ItemID.RAW_UGTHANKI_MEAT|ItemID.YAK_MEAT_RAW", "HIDE:givenBoneToDog", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"givenBoneToDog\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "TheFinalDawn.java" ));
        rows.add(new RawItem("TheFremennikExiles", "astralRunes", "Astral runes", "ItemID.ASTRALRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "TheFremennikExiles", "coins650", "ItemRequirement", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "650", true, "", "", "kegs2Or650Coins", "[]", "BANK_CHECKABLE", "", "", "TheFremennikExiles.java" ));
        rows.add(new RawItem("TheFremennikExiles", "fishingOrFlyFishingRod", "Fishing rod", "ItemID.FISHING_ROD", "ITEM_ID", "1", false, "ItemID.FLY_FISHING_ROD"));
        rows.add(new RawItem("TheFremennikExiles", "fremennikShield", "Fremennik shield", "ItemID.VIKING_SHIELD", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheFremennikExiles", "glassblowingPipe", "Glassblowing pipe", "ItemID.GLASSBLOWINGPIPE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheFremennikExiles", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TheFremennikExiles", "iceGloves", "Ice gloves or smiths gloves(i)", "ItemID.ICE_GLOVES", "ITEM_ID", "1", false, "ItemID.SMITHING_UNIFORM_GLOVES_ICE"));
        rows.add(new RawItem( "TheFremennikExiles", "kegs2Or650Coins.child1", "ItemRequirement", "Kegs of beer", "ItemID.KEG_OF_BEER", "ITEM_ID", "2", true, "", "", "kegs2Or650Coins", "[]", "BANK_CHECKABLE", "", "", "TheFremennikExiles.java" ));
        rows.add(new RawItem("TheFremennikExiles", "kegsOfBeer", "Kegs of beer", "ItemID.KEG_OF_BEER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheFremennikExiles", "mirrorShield", "Mirror shield", "ItemID.SLAYER_MIRROR_SHIELD", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheFremennikExiles", "moltenGlass", "Molten glass", "ItemID.MOLTEN_GLASS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheFremennikExiles", "petRock", "Pet rock", "ItemID.VT_USELESS_ROCK", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheFremennikExiles", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TheFremennikExiles", "runeThrowingaxeOrFriend", "\"Rune thrownaxe, or a friend to help enter Waterbirth Isle \" +\n\t\t\t\"Dungeon\"", "ItemID.RUNE_THROWNAXE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheFremennikExiles", "sealOfPassage", "Seal of passage", "ItemID.LUNAR_SEAL_OF_PASSAGE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheFremennikIsles", "axe", "Any axe", "ItemCollections.AXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TheFremennikIsles", "bronzeNail", "Bronze nail", "ItemID.NAILS_BRONZE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "TheFremennikIsles", "coal", "ItemRequirement", "Coal", "ItemID.COAL", "ITEM_ID", "7", true, "", "SHOW:useCoal", "miningOreRequirement", "[{\"Mode\":\"SHOW\",\"Expression\":\"useCoal\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "TheFremennikIsles.java" ));
        rows.add(new RawItem("TheFremennikIsles", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TheFremennikIsles", "knife", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem( "TheFremennikIsles", "mithrilOre", "ItemRequirement", "Mithril ore", "ItemID.MITHRIL_ORE", "ITEM_ID", "6", true, "", "SHOW:useMithrilOre", "miningOreRequirement", "[{\"Mode\":\"SHOW\",\"Expression\":\"useMithrilOre\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "TheFremennikIsles.java" ));
        rows.add(new RawItem("TheFremennikIsles", "needle", "Needle", "ItemID.NEEDLE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheFremennikIsles", "rope9", "Rope", "ItemID.ROPE", "ITEM_ID", "9", true, ""));
        rows.add(new RawItem("TheFremennikIsles", "thread", "Thread", "ItemID.THREAD", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "TheFremennikIsles", "tinOre", "ItemRequirement", "Tin ore", "ItemID.TIN_ORE", "ITEM_ID", "8", true, "", "SHOW:useTin", "miningOreRequirement", "[{\"Mode\":\"SHOW\",\"Expression\":\"useTin\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "TheFremennikIsles.java" ));
        rows.add(new RawItem("TheFremennikIsles", "tuna", "Raw tuna", "ItemID.RAW_TUNA", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheFremennikTrials", "axe", "Any axe", "ItemCollections.AXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TheFremennikTrials", "coins", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "5250", true, ""));
        rows.add(new RawItem("TheFremennikTrials", "knife", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheFremennikTrials", "rawShark", "Raw shark, manta ray or sea turtle", "ItemID.RAW_SHARK", "ITEM_ID", "1", true, "ItemID.RAW_MANTARAY|ItemID.RAW_SEATURTLE"));
        rows.add(new RawItem("TheFremennikTrials", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheGardenOfDeath", "secateurs", "Secateurs (Obtainable in quest)", "ItemID.SECATEURS", "ITEM_ID", "1", true, "ItemID.FAIRY_ENCHANTED_SECATEURS"));
        rows.add(new RawItem("TheGeneralsShadow", "coins40", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "40", true, ""));
        rows.add(new RawItem("TheGeneralsShadow", "ghostlyBody", "Ghostly robe (top)", "ItemID.SECRET_GHOST_TOP", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheGeneralsShadow", "ghostlyBoots", "Ghostly boots", "ItemID.SECRET_GHOST_BOOTS", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheGeneralsShadow", "ghostlyCloak", "Ghostly cloak", "ItemID.SECRET_GHOST_CLOAK", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheGeneralsShadow", "ghostlyGloves", "Ghostly gloves", "ItemID.SECRET_GHOST_GLOVES", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheGeneralsShadow", "ghostlyHood", "Ghostly hood", "ItemID.SECRET_GHOST_HAT", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheGeneralsShadow", "ghostlyLegs", "Ghostly robe (bottom)", "ItemID.SECRET_GHOST_BOTTOM", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheGeneralsShadow", "ghostspeak", "Ghostspeak amulet", "ItemID.AMULET_OF_GHOSTSPEAK", "ITEM_ID", "1", false, "ItemID.AMULET_OF_GHOSTSPEAK_ENCHANTED"));
    }

    private static void addItems13(List<RawItem> rows)
    {
        rows.add(new RawItem("TheGeneralsShadow", "ringOfVisibility", "Ring of visibility", "ItemID.FD_RING_VISIBILITY", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheGiantDwarf", "airRune", "Air rune", "ItemID.AIRRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheGiantDwarf", "coal", "Coal", "ItemID.COAL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheGiantDwarf", "coins2500", "coins", "ItemCollections.COINS", "ITEM_COLLECTION", "2500", true, ""));
        rows.add(new RawItem("TheGiantDwarf", "ironBar", "Iron bar", "ItemID.IRON_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheGiantDwarf", "lawRune", "Law rune", "ItemID.LAWRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheGiantDwarf", "logs", "Logs", "ItemID.LOGS", "ITEM_ID", "1", true, "ItemID.OAK_LOGS|ItemID.WILLOW_LOGS|ItemID.TEAK_LOGS|ItemID.MAPLE_LOGS|ItemID.MAHOGANY_LOGS|ItemID.YEW_LOGS|ItemID.MAGIC_LOGS"));
        rows.add(new RawItem("TheGiantDwarf", "redberryPie", "Redberry pie", "ItemID.REDBERRY_PIE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheGiantDwarf", "sapphires3", "Cut sapphires", "ItemID.SAPPHIRE", "ITEM_ID", "3", true, ""));
        rows.add(new RawItem("TheGiantDwarf", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheGolem", "clay4Highlight", "Soft clay", "ItemID.SOFTCLAY", "ITEM_ID", "4", true, ""));
        rows.add(new RawItem("TheGolem", "papyrus", "Papyrus", "ItemID.PAPYRUS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheGolem", "pestleAndMortar", "Pestle and mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheGolem", "vial", "Vial", "ItemID.VIAL_EMPTY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "TheGrandTree", "oneThousandCoins", "ItemRequirement", "Coins to enter the Stronghold if you didn't help Femi previously", "ItemCollections.COINS", "ITEM_COLLECTION", "1000", true, "", "HIDE:new QuestRequirement(QuestHelperQuest.TREE_GNOME_VILLAGE, QuestState.FINISHED)", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"new QuestRequirement(QuestHelperQuest.TREE_GNOME_VILLAGE, QuestState.FINISHED)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "TheGrandTree.java" ));
        rows.add(new RawItem( "TheGreatBrainRobbery", "catsOrResources.child1", "ItemRequirement", "Wooden cat", "ItemID.BRAIN_INV_WOODEN_CAT", "ITEM_ID", "10", true, "", "", "catsOrResources", "[]", "BANK_CHECKABLE", "", "", "TheGreatBrainRobbery.java" ));
        rows.add(new RawItem( "TheGreatBrainRobbery", "catsOrResources.child2.child1", "ItemRequirement", "Plank", "ItemID.WOODPLANK", "ITEM_ID", "10", true, "", "", "catsOrResources.child2", "[]", "BANK_CHECKABLE", "", "", "TheGreatBrainRobbery.java" ));
        rows.add(new RawItem( "TheGreatBrainRobbery", "catsOrResources.child2.child2", "ItemRequirement", "Fur", "ItemID.FUR", "ITEM_ID", "10", true, "ItemID.WEREWOLVE_FUR|ItemID.GREY_WOLF_FUR", "", "catsOrResources.child2", "[]", "BANK_CHECKABLE", "", "", "TheGreatBrainRobbery.java" ));
        rows.add(new RawItem("TheGreatBrainRobbery", "divingApparatus", "Diving apparatus", "ItemID.HUNDRED_PIRATE_DIVING_BACKPACK", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheGreatBrainRobbery", "fishbowlHelmet", "Fishbowl helmet", "ItemID.HUNDRED_PIRATE_DIVING_HELMET", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheGreatBrainRobbery", "fur", "Fur", "ItemID.FUR", "ITEM_ID", "1", true, "ItemID.WEREWOLVE_FUR|ItemID.GREY_WOLF_FUR"));
        rows.add(new RawItem("TheGreatBrainRobbery", "hammer", "Hammer", "ItemID.HAMMER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheGreatBrainRobbery", "holySymbol", "Holy symbol", "ItemID.BLESSEDSTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheGreatBrainRobbery", "nails", "Nails", "ItemCollections.NAILS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("TheGreatBrainRobbery", "plank", "Plank", "ItemID.WOODPLANK", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheGreatBrainRobbery", "ringOfCharos", "Ring of Charos", "ItemID.RING_OF_CHAROS", "ITEM_ID", "1", false, "ItemID.RING_OF_CHAROS_UNLOCKED"));
        rows.add(new RawItem("TheGreatBrainRobbery", "woodenCats", "Wooden cat", "ItemID.BRAIN_INV_WOODEN_CAT", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheHandInTheSand", "beerOr2Coins", "Beer or 2 gp", "ItemID.BEER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheHandInTheSand", "bucketOfSand", "Bucket of sand", "ItemID.BUCKET_SAND", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheHandInTheSand", "coins", "Coins or more for boat travel", "ItemCollections.COINS", "ITEM_COLLECTION", "150", true, ""));
        rows.add(new RawItem("TheHandInTheSand", "earthRunes5", "Earth runes", "ItemID.EARTHRUNE", "ITEM_ID", "5", true, ""));
        rows.add(new RawItem("TheHandInTheSand", "lanternLens", "Lantern lens", "ItemID.BULLSEYE_LANTERN_LENS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheHandInTheSand", "redberries", "Redberries", "ItemID.REDBERRIES", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheHandInTheSand", "vial2", "Vial", "ItemID.VIAL_EMPTY", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("TheHandInTheSand", "whiteberries", "White berries", "ItemID.WHITE_BERRIES", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheHeartOfDarkness", "coins", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("TheHeartOfDarkness", "food", "Food", "ItemCollections.GOOD_EATING_FOOD", "ITEM_COLLECTION", "10", true, ""));
        rows.add(new RawItem("TheHeartOfDarkness", "prayerPotions", "Prayer potions", "ItemCollections.PRAYER_POTIONS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("TheKnightsSword", "ironBars", "Iron bar", "ItemID.IRON_BAR", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("TheKnightsSword", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TheKnightsSword", "redberryPie", "Redberry pie", "ItemID.REDBERRY_PIE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheLostTribe", "lightSource", "A light source", "ItemCollections.LIGHT_SOURCES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TheLostTribe", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TheMageArenaI", "knife", "Knife or sharp weapon to cut through a web", "ItemCollections.SLASH_WEB_KNIFE", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TheMageArenaII", "guthixStaff", "Guthix staff", "ItemID.GUTHIX_STAFF", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheMageArenaII", "knife", "Knife or sharp weapon to cut through a web", "ItemCollections.SLASH_WEB_KNIFE", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TheMageArenaII", "saradominStaff", "Saradomin staff", "ItemID.SARADOMIN_STAFF", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("TheMageArenaII", "zamorakStaff", "Zamorak staff", "ItemID.ZAMORAK_STAFF", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("ThePathOfGlouphrie", "crossbow", "Any crossbow", "ItemCollections.CROSSBOWS", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("ThePathOfGlouphrie", "mithGrapple", "Mith grapple", "ItemID.XBOWS_GRAPPLE_TIP_BOLT_MITHRIL_ROPE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem( "ThePathOfGlouphrie", "treeGnomeVillageDungeonKey", "ItemRequirement", "Tree Gnome Village dungeon key", "ItemID.GOLRIE_KEY_WATERFALL_QUEST", "ITEM_ID", "1", true, "", "SHOW:rovingElvesNotStarted", "", "[{\"Mode\":\"SHOW\",\"Expression\":\"rovingElvesNotStarted\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "Conditional requirement", "ThePathOfGlouphrie.java" ));
        rows.add(new RawItem("TheQueenOfThieves", "stew", "Stew", "ItemID.STEW", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheRibbitingTaleOfALilyPadLabourDispute", "axe", "Any axe", "ItemCollections.AXES", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem( "TheSlugMenace", "airTalisman", "ItemRequirement", "Access to the Air Altar", "ItemCollections.AIR_ALTAR", "ITEM_COLLECTION", "1", false, "", "", "accessToAltars", "[]", "BANK_CHECKABLE", "", "", "TheSlugMenace.java" ));
        rows.add(new RawItem("TheSlugMenace", "chisel", "Chisel", "ItemCollections.CHISEL", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TheSlugMenace", "commorb", "Commorb (can get another from Sir Tiffy)", "ItemID.WANTED_CRYSTAL_BALL", "ITEM_ID", "1", false, "ItemID.SLUG2_CRYSTAL_BALL"));
        rows.add(new RawItem( "TheSlugMenace", "earthTalisman", "ItemRequirement", "Access to the Earth Altar", "ItemCollections.EARTH_ALTAR", "ITEM_COLLECTION", "1", false, "", "", "accessToAltars", "[]", "BANK_CHECKABLE", "", "", "TheSlugMenace.java" ));
        rows.add(new RawItem("TheSlugMenace", "essence5", "Rune/pure essence, 15 to be safe", "ItemID.BLANKRUNE_HIGH", "ITEM_ID", "5", true, "ItemID.BLANKRUNE"));
        rows.add(new RawItem( "TheSlugMenace", "fireTalisman", "ItemRequirement", "Access to the Fire Altar", "ItemCollections.FIRE_ALTAR", "ITEM_COLLECTION", "1", false, "", "", "accessToAltars", "[]", "BANK_CHECKABLE", "", "", "TheSlugMenace.java" ));
        rows.add(new RawItem( "TheSlugMenace", "mindTalisman", "ItemRequirement", "Access to the Mind Altar", "ItemCollections.MIND_ALTAR", "ITEM_COLLECTION", "1", false, "", "", "accessToAltars", "[]", "BANK_CHECKABLE", "", "", "TheSlugMenace.java" ));
        rows.add(new RawItem("TheSlugMenace", "swampPaste", "Swamp paste", "ItemID.SWAMPPASTE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "TheSlugMenace", "waterTalisman", "ItemRequirement", "Access to the Water Altar", "ItemCollections.WATER_ALTAR", "ITEM_COLLECTION", "1", false, "", "", "accessToAltars", "[]", "BANK_CHECKABLE", "", "", "TheSlugMenace.java" ));
        rows.add(new RawItem("TheTouristTrap", "bronzeBar3", "Bronze bars", "ItemID.BRONZE_BAR", "ITEM_ID", "3", true, ""));
        rows.add(new RawItem("TheTouristTrap", "desertBoot", "Desert boots", "ItemID.DESERT_BOOTS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheTouristTrap", "desertBottom", "Desert robe", "ItemID.DESERT_ROBE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheTouristTrap", "desertTop", "Desert shirt", "ItemID.DESERT_SHIRT", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TheTouristTrap", "feather50", "Feather", "ItemID.FEATHER", "ITEM_ID", "50", true, ""));
        rows.add(new RawItem("TheTouristTrap", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("ThroneOfMiscellania", "bow", "Any normal/oak/willow/maple/yew shortbow or longbow (if courting Astrid)", "ItemID.SHORTBOW", "ITEM_ID", "1", true, "ItemID.LONGBOW|ItemID.OAK_SHORTBOW|ItemID.OAK_LONGBOW|ItemID.WILLOW_SHORTBOW|ItemID.WILLOW_LONGBOW|ItemID.MAPLE_SHORTBOW|ItemID.MAPLE_LONGBOW|ItemID.YEW_SHORTBOW|ItemID.YEW_LONGBOW"));
        rows.add(new RawItem("ThroneOfMiscellania", "cake", "Cake (if courting Brand)", "ItemID.CAKE", "ITEM_ID", "1", true, "ItemID.CHOCOLATE_CAKE"));
        rows.add(new RawItem("ThroneOfMiscellania", "flowers", "Flowers", "ItemCollections.FLOWERS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("ThroneOfMiscellania", "ironBar", "Iron bar", "ItemID.IRON_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ThroneOfMiscellania", "logs", "Logs", "ItemID.LOGS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ThroneOfMiscellania", "reputationItems", "One of: ", "ItemID.LOBSTER_POT", "ITEM_ID", "1", true, "ItemCollections.PICKAXES|ItemCollections.AXES|ItemID.HARPOON|ItemID.LOBSTER_POT"));
        rows.add(new RawItem("ThroneOfMiscellania", "ring", "Any non-silver ring you are willing to lose", "ItemID.GOLD_RING", "ITEM_ID", "1", true, "ItemID.SAPPHIRE_RING|ItemID.EMERALD_RING|ItemID.RUBY_RING|ItemID.DIAMOND_RING"));
    }

    private static void addItems14(List<RawItem> rows)
    {
        rows.add(new RawItem("TowerOfLife", "beer", "Beer", "ItemID.BEER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TowerOfLife", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TowerOfLife", "saw", "Saw", "ItemCollections.SAW", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem( "TreeGnomeVillage", "sixLogs", "ItemRequirement", "Logs", "ItemID.LOGS", "ITEM_ID", "6", true, "", "HIDE:givenWood", "", "[{\"Mode\":\"HIDE\",\"Expression\":\"givenWood\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "TreeGnomeVillage.java" ));
        rows.add(new RawItem("TrollRomance", "bucketOfWax", "Bucket of wax", "ItemID.BUCKET_WAX", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TrollRomance", "cakeTin", "Cake tin", "ItemID.CAKE_TIN", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TrollRomance", "climbingBoots", "Climbing boots", "ItemCollections.CLIMBING_BOOTS", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("TrollRomance", "ironBar", "Iron bar", "ItemID.IRON_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TrollRomance", "mapleLog", "Maple/yew logs", "ItemID.MAPLE_LOGS", "ITEM_ID", "1", true, "ItemID.YEW_LOGS"));
        rows.add(new RawItem("TrollRomance", "rope", "Rope", "ItemID.ROPE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("TrollRomance", "swampTar", "Swamp tar", "ItemID.SWAMP_TAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "TrollStronghold", "climbingBoots", "ItemRequirement", "Climbing boots", "ItemCollections.CLIMBING_BOOTS", "ITEM_COLLECTION", "1", false, "", "", "climbingBootsOr12Coins", "[]", "BANK_CHECKABLE", "", "", "TrollStronghold.java" ));
        rows.add(new RawItem( "TrollStronghold", "coins12", "ItemRequirement", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "12", true, "", "", "climbingBootsOr12Coins", "[]", "BANK_CHECKABLE", "", "", "TrollStronghold.java" ));
        rows.add(new RawItem("TroubledTortugans", "anyAxe", "Any axe", "ItemCollections.AXES", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("TroubledTortugans", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("TroubledTortugans", "saw", "Saw", "ItemCollections.SAW", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("UndergroundPass", "arrows", "Arrows (metal, unpoisoned)", "ItemCollections.METAL_ARROWS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("UndergroundPass", "bow", "Bow (not crossbow)", "ItemCollections.BOWS", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("UndergroundPass", "bucket", "Bucket", "ItemID.BUCKET_EMPTY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("UndergroundPass", "plank", "Plank", "ItemID.WOODPLANK", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("UndergroundPass", "rope2", "Rope, multiple in case you fail an agility check", "ItemID.ROPE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("UndergroundPass", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("UndergroundPass", "tinderbox", "Tinderbox", "ItemID.TINDERBOX", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem( "ValeTotems", "fourDecorativeItems", "ItemRequirement", "Oak shield/longbow/shortbow", "List.of(ItemID.OAK_SHIELD, ItemID.UNSTRUNG_OAK_LONGBOW, ItemID.OAK_LONGBOW, ItemID.UNSTRUNG_OAK_SHORTBOW, ItemID.OAK_SHORTBOW)", "ITEM_LIST", "4", true, "", "", "", "[]", "BANK_CHECKABLE", "", "Complex item source expression", "ValeTotems.java" ));
        rows.add(new RawItem("ValeTotems", "knife", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("ValeTotems", "oneOakLog", "Oak log", "ItemID.OAK_LOGS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "VampyreSlayer", "beer", "ItemRequirement", "Beer", "ItemID.BEER", "ITEM_ID", "1", true, "", "", "beerOrTwoCoins", "[]", "BANK_CHECKABLE", "", "", "VampyreSlayer.java" ));
        rows.add(new RawItem("VampyreSlayer", "hammer", "Hammer", "ItemCollections.HAMMER", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem( "VampyreSlayer", "twoCoins", "ItemRequirement", "Coins", "ItemID.COINS", "ITEM_ID", "2", true, "", "", "beerOrTwoCoins", "[]", "BANK_CHECKABLE", "", "", "VampyreSlayer.java" ));
        rows.add(new RawItem("VarrockBalloonFlight", "willowLogs", "Willow logs", "ItemID.WILLOW_LOGS", "ITEM_ID", "10", true, ""));
        rows.add(new RawItem( "Wanted", "enchantedGem", "ItemRequirement", "Enchanted gem", "ItemID.SLAYER_GEM", "ITEM_ID", "1", true, "", "", "commorbComponents", "[]", "BANK_CHECKABLE", "", "", "Wanted.java" ));
        rows.add(new RawItem( "Wanted", "lawRune", "ItemRequirement", "A law rune", "ItemID.LAWRUNE", "ITEM_ID", "1", true, "", "", "commorbComponents", "[]", "BANK_CHECKABLE", "", "", "Wanted.java" ));
        rows.add(new RawItem("Wanted", "lightSource", "A light source", "ItemCollections.LIGHT_SOURCES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem( "Wanted", "moltenGlass", "ItemRequirement", "Molten glass", "ItemID.MOLTEN_GLASS", "ITEM_ID", "1", true, "", "", "commorbComponents", "[]", "BANK_CHECKABLE", "", "", "Wanted.java" ));
        rows.add(new RawItem( "Wanted", "pureEssence", "ItemRequirement", "20 Pure Essence (UNNOTED)", "ItemID.BLANKRUNE_HIGH", "ITEM_ID", "20", true, "", "", "essence", "[]", "BANK_CHECKABLE", "", "", "Wanted.java" ));
        rows.add(new RawItem("Wanted", "rope", "A rope", "ItemID.ROPE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "Wanted", "runeEssence", "ItemRequirement", "20 Rune Essence (UNNOTED)", "ItemID.BLANKRUNE", "ITEM_ID", "20", true, "", "", "essence", "[]", "BANK_CHECKABLE", "", "", "Wanted.java" ));
        rows.add(new RawItem( "Wanted", "tenThousandGp", "ItemRequirement", "10k gp", "ItemCollections.COINS", "ITEM_COLLECTION", "10000", true, "", "", "commorbComponentsOrTenThousandGp", "[]", "BANK_CHECKABLE", "", "", "Wanted.java" ));
        rows.add(new RawItem("Watchtower", "batBones", "Bat bones", "ItemID.BAT_BONES", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("Watchtower", "coins20", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "20", true, ""));
        rows.add(new RawItem("Watchtower", "deathRune", "Death rune", "ItemID.DEATHRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("Watchtower", "dragonBones", "Dragon bones", "ItemID.DRAGON_BONES", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("Watchtower", "goldBar", "Gold bar", "ItemID.GOLD_BAR", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("Watchtower", "guamUnf", "Guam potion (unf)", "ItemID.GUAMVIAL", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("Watchtower", "jangerberries", "Jangerberries", "ItemID.JANGERBERRIES", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("Watchtower", "lightSource", "A light source", "ItemCollections.LIGHT_SOURCES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("Watchtower", "pestleAndMortar", "Pestle and mortar", "ItemID.PESTLE_AND_MORTAR", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("Watchtower", "pickaxe", "Any pickaxe", "ItemCollections.PICKAXES", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem("Watchtower", "rope2", "Rope", "ItemID.ROPE", "ITEM_ID", "2", true, ""));
        rows.add(new RawItem("WaterfallQuest", "airRunes", "Air runes", "ItemID.AIRRUNE", "ITEM_ID", "6", true, ""));
        rows.add(new RawItem("WaterfallQuest", "earthRunes", "Earth runes", "ItemID.EARTHRUNE", "ITEM_ID", "6", true, ""));
        rows.add(new RawItem("WaterfallQuest", "waterRunes", "Water runes", "ItemID.WATERRUNE", "ITEM_ID", "6", true, ""));
        rows.add(new RawItem("WhatLiesBelow", "bowl", "Bowl", "ItemID.BOWL_EMPTY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("WhatLiesBelow", "chaosRunes15", "Chaos runes", "ItemID.CHAOSRUNE", "ITEM_ID", "15", true, ""));
        rows.add(new RawItem("WhatLiesBelow", "chaosTalismanOrAbyss", "Access to the Chaos Altar", "ItemCollections.CHAOS_ALTAR", "ITEM_COLLECTION", "1", false, ""));
        rows.add(new RawItem( "WhileGuthixSleeps", "air30", "ItemRequirement", "Air runes", "ItemID.AIRRUNE", "ITEM_ID", "30", true, "", "SHOW:new SkillRequirement(Skill.MAGIC, 66)", "elemental30", "[{\"Mode\":\"SHOW\",\"Expression\":\"new SkillRequirement(Skill.MAGIC, 66)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "WhileGuthixSleeps.java" ));
        rows.add(new RawItem("WhileGuthixSleeps", "airRune", "Air rune", "ItemID.AIRRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("WhileGuthixSleeps", "astralRune", "Astral rune", "ItemID.ASTRALRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("WhileGuthixSleeps", "bronzeMedHelm", "Bronze med helm", "ItemID.BRONZE_MED_HELM", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("WhileGuthixSleeps", "coins", "Coins", "ItemCollections.COINS", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem( "WhileGuthixSleeps", "cosmic3", "ItemRequirement", "Cosmic rune", "ItemID.COSMICRUNE", "ITEM_ID", "3", true, "", "", "chargeOrbSpell", "[]", "BANK_CHECKABLE", "", "", "WhileGuthixSleeps.java" ));
        rows.add(new RawItem("WhileGuthixSleeps", "cosmicRune", "Cosmic rune", "ItemID.COSMICRUNE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("WhileGuthixSleeps", "dibber", "Seed dibber (only if not done barb training)", "ItemID.DIBBER", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "WhileGuthixSleeps", "earth30", "ItemRequirement", "Earth runes", "ItemID.EARTHRUNE", "ITEM_ID", "30", true, "", "SHOW:new SkillRequirement(Skill.MAGIC, 60)", "elemental30", "[{\"Mode\":\"SHOW\",\"Expression\":\"new SkillRequirement(Skill.MAGIC, 60)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "WhileGuthixSleeps.java" ));
        rows.add(new RawItem( "WhileGuthixSleeps", "fire30", "ItemRequirement", "Fire runes", "ItemID.FIRERUNE", "ITEM_ID", "30", true, "", "SHOW:new SkillRequirement(Skill.MAGIC, 63)", "elemental30", "[{\"Mode\":\"SHOW\",\"Expression\":\"new SkillRequirement(Skill.MAGIC, 63)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "WhileGuthixSleeps.java" ));
        rows.add(new RawItem("WhileGuthixSleeps", "food", "Food", "ItemCollections.GOOD_EATING_FOOD", "ITEM_COLLECTION", "1", true, ""));
        rows.add(new RawItem("WhileGuthixSleeps", "ironChainbody", "Iron chainbody", "ItemID.IRON_CHAINBODY", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("WhileGuthixSleeps", "knife", "Knife", "ItemID.KNIFE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("WhileGuthixSleeps", "lanternLens", "Lantern lens", "ItemID.BULLSEYE_LANTERN_LENS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("WhileGuthixSleeps", "litSapphireLantern", "Lit sapphire lantern", "ItemID.TOG_SAPPHIRE_LANTERN_LIT", "ITEM_ID", "1", false, ""));
        rows.add(new RawItem("WhileGuthixSleeps", "logs", "Logs", "ItemID.LOGS", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("WhileGuthixSleeps", "unpoweredOrb", "Unpowered orb", "ItemID.STAFFORB", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem( "WhileGuthixSleeps", "water30", "ItemRequirement", "Water runes", "ItemID.WATERRUNE", "ITEM_ID", "30", true, "", "SHOW:new SkillRequirement(Skill.MAGIC, 56)", "elemental30", "[{\"Mode\":\"SHOW\",\"Expression\":\"new SkillRequirement(Skill.MAGIC, 56)\"}]", "BANK_CHECKABLE", "Runtime condition preserved; do not treat as unconditional", "", "WhileGuthixSleeps.java" ));
        rows.add(new RawItem("WitchsHouse", "cheese", "Cheese (multiple if you mess up)", "ItemID.CHEESE", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("WitchsHouse", "leatherGloves", "Leather gloves", "ItemID.LEATHER_GLOVES", "ITEM_ID", "1", false, ""));
    }

    private static void addItems15(List<RawItem> rows)
    {
        rows.add(new RawItem("WitchsPotion", "burntMeat", "Burnt meat", "ItemID.BURNT_MEAT", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("WitchsPotion", "eyeOfNewt", "Eye of newt", "ItemID.EYE_OF_NEWT", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("WitchsPotion", "onion", "Onion", "ItemID.ONION", "ITEM_ID", "1", true, ""));
        rows.add(new RawItem("XMarksTheSpot", "spade", "Spade", "ItemID.SPADE", "ITEM_ID", "1", false, ""));
    }

    private static List<RawGroup> buildGroups()
    {
        List<RawGroup> rows = new ArrayList<>(61);
        addGroups0(rows);
        return Collections.unmodifiableList(rows);
    }

    private static void addGroups0(List<RawGroup> rows)
    {
        rows.add(new RawGroup( "ATasteOfHope", "enchantEmeraldRunesOrTablet", "OR", "enchantRunes|enchantTablet", "Runes or tablet for Enchant Emerald", "LogicType.OR, \"Runes or tablet for Enchant Emerald\", enchantRunes, enchantTablet", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "ATasteOfHope.java" ));
        rows.add(new RawGroup( "ATasteOfHope", "enchantRunes", "AND", "enchantRunes.child1|cosmicRune", "Emerald enchant runes", "\"Emerald enchant runes\", new ItemRequirements(LogicType.OR, \"3 air runes\", airRune3, airStaff), cosmicRune", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "ATasteOfHope.java" ));
        rows.add(new RawGroup( "ATasteOfHope", "enchantRunes.child1", "OR", "airRune3|airStaff", "3 air runes", "LogicType.OR, \"3 air runes\", airRune3, airStaff", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "ATasteOfHope.java" ));
        rows.add(new RawGroup( "AtFirstLight", "jerboaTail2OrBoxTrap", "OR", "jerboaTail2OrBoxTrap.child1|boxTrap", "2 Jerboa tails, or a box trap to get some", "LogicType.OR, \"2 Jerboa tails, or a box trap to get some\", jerboaTail.quantity(2), boxTrap", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "AtFirstLight.java" ));
        rows.add(new RawGroup( "AtFirstLight", "needleOrCostumeNeedle", "OR", "needle|costumeNeedle", "Needle or Costume needle", "LogicType.OR, \"Needle or Costume needle\", needle, costumeNeedle", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "AtFirstLight.java" ));
        rows.add(new RawGroup( "CreatureOfFenkenstrain", "telegrab", "AND", "telegrab.child1|telegrab.child2", "Telegrab runes", "\"Telegrab runes\", new ItemRequirement(\"Law rune\",\n\t\t\tItemID.LAWRUNE), new ItemRequirement(\"Air rune\", ItemID.AIRRUNE)", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "CreatureOfFenkenstrain.java" ));
        rows.add(new RawGroup( "CreatureOfFenkenstrain", "telegrabOrCoins", "OR", "coins50|telegrab", "33 Magic and runes to cast telegrab, or 50 coins", "LogicType.OR,\n\t\t\t\"33 Magic and runes to cast telegrab, or 50 coins\",\n\t\t\tcoins50, telegrab", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "CreatureOfFenkenstrain.java" ));
        rows.add(new RawGroup( "DeathToTheDorgeshuun", "hamSet2", "AND", "hamShirt2|hamRobe2|hamHood2|hamBoot2|hamGloves2|hamLogo2|hamCloak2", "2 full ham robe sets (7 pieces/set)", "\"2 full ham robe sets (7 pieces/set)\", hamShirt2, hamRobe2, hamHood2, hamBoot2, hamGloves2, hamLogo2, hamCloak2", "", "[]", false, "BANK_CHECKABLE", "", "", "[]", "DeathToTheDorgeshuun.java" ));
        rows.add(new RawGroup( "DesertTreasureII", "allBursts", "AND", "allBursts.child1|allBursts.child2|allBursts.child3|allBursts.child4|allBursts.child5|allBursts.child6|allBursts.child7", "Runes for shadow, smoke, blood, and ice burst", "\"Runes for shadow, smoke, blood, and ice burst\",\n\t\t\tnew ItemRequirement(\"Death runes\", ItemID.DEATHRUNE, 8),\n\t\t\tnew ItemRequirement(\"Chaos runes\", ItemID.CHAOSRUNE, 16),\n\t\t\tnew ItemRequirement(\"Blood runes\", ItemID.BLOODRUNE, 2),\n\t\t\tnew ItemRequirement(\"Water runes\", ItemID.WATERRUNE, 4),\n\t\t\tnew ItemRequirement(\"Soul runes\", ItemID.SOULRUNE, 2),\n\t\t\tnew ItemRequirement(\"Air runes\", ItemID.AIRRUNE, 3),\n\t\t\tnew ItemRequirement(\"Fire runes\", ItemID.FIRERUNE, 2)", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "DesertTreasureII.java" ));
        rows.add(new RawGroup( "DragonSlayer", "telegrabOrTenK", "OR", "telegrabOrTenK.child1|telegrab", "Either 33 Magic for Telegrab and a ranged/mage weapon, or 10,000 coins", "LogicType.OR, \"Either 33 Magic for Telegrab and a ranged/mage weapon, or 10,000 coins\",\n\t\t\tnew ItemRequirement(\"Coins\", ItemCollections.COINS, 10000), telegrab", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "DragonSlayer.java" ));
        rows.add(new RawGroup( "DragonSlayerII", "fireSurge3Runes", "AND", "wrathRune3|fireRune30|airRune21", "3 casts of Fire Surge", "\"3 casts of Fire Surge\", wrathRune3, fireRune30, airRune21", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "DragonSlayerII.java" ));
        rows.add(new RawGroup( "DragonSlayerII", "fireWave3Runes", "AND", "bloodRune3|fireRune21|airRune15", "3 casts of Fire Wave", "\"3 casts of Fire Wave\", bloodRune3, fireRune21, airRune15", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "DragonSlayerII.java" ));
        rows.add(new RawGroup( "DragonSlayerII", "runesForFireWaveOrSurge3", "OR", "fireWave3Runes|fireSurge3Runes", "3 casts of Fire Wave or Fire Surge", "LogicType.OR, \"3 casts of Fire Wave or Fire Surge\", fireWave3Runes, fireSurge3Runes", "", "[]", true, "BANK_CHECKABLE", "", "Complex group needs further expansion", "[]", "DragonSlayerII.java" ));
        rows.add(new RawGroup( "EadgarsRuse", "climbingBootsOr12Coins", "OR", "coins12|climbingBoots", "Climbing boots or 12 coins", "LogicType.OR, \"Climbing boots or 12 coins\", coins12, climbingBoots", "", "[]", false, "BANK_CHECKABLE", "", "", "[]", "EadgarsRuse.java" ));
        rows.add(new RawGroup( "GhostsAhoy", "dyes", "AND", "redDye|blueDye|yellowDye", "3 colours of dyes. Which you'll need is random. To be prepared, bring 3 red/blue/yellow dyes", "\"3 colours of dyes. Which you'll need is random. To be prepared, bring 3 red/blue/yellow dyes\",\n\t\t\tredDye, blueDye, yellowDye", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "GhostsAhoy.java" ));
        rows.add(new RawGroup( "GhostsAhoy", "needleThread", "AND", "needle|thread", "", "needle, thread", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "GhostsAhoy.java" ));
        rows.add(new RawGroup( "GhostsAhoy", "needleThreadOrCostumeNeedle", "OR", "needleThread|costumeNeedle", "Needle/Thread or Costume needle", "LogicType.OR, \"Needle/Thread or Costume needle\", needleThread, costumeNeedle", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "GhostsAhoy.java" ));
        rows.add(new RawGroup( "IcthlarinsLittleHelper", "coinsOrLinen", "OR", "coins30|linen", "1 x Linen or 30 coins to buy some", "LogicType.OR, \"1 x Linen or 30 coins to buy some\", coins30, linen", "HIDE:givenLinen", "[{\"Mode\":\"HIDE\",\"Expression\":\"givenLinen\"}]", true, "BANK_CHECKABLE", "", "", "[]", "IcthlarinsLittleHelper.java" ));
        rows.add(new RawGroup( "InAidOfTheMyreque", "rawMackerelOrSnail10", "AND", "mackerel10|snails10", "10 Raw mackerel or raw snail meat (random for each player)", "\"10 Raw mackerel or raw snail meat (random for each player)\",\n\t\t\tmackerel10,\n\t\t\tsnails10", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "InAidOfTheMyreque.java" ));
        rows.add(new RawGroup( "InSearchOfTheMyreque", "coins10OrCharos", "OR", "coins10OrCharos.child1|coins10OrCharos.child2", "10 coins or a Ring of Charos (a)", "LogicType.OR, \"10 coins or a Ring of Charos (a)\",\n\t\t\tnew ItemRequirement(\"Ring of Charos (a)\", ItemID.RING_OF_CHAROS_UNLOCKED),\n\t\t\tnew ItemRequirement(\"Coins\", ItemCollections.COINS, 10)", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "InSearchOfTheMyreque.java" ));
        rows.add(new RawGroup( "KingsRansom", "grabOrLockpick", "OR", "grabOrLockpick.child1|telegrab", "Runes for telekinetic grab or a lockpick", "LogicType.OR, \"Runes for telekinetic grab or a lockpick\", new ItemRequirement(\"Lockpick\", ItemID.LOCKPICK), telegrab", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "KingsRansom.java" ));
        rows.add(new RawGroup( "KingsRansom", "telegrab", "AND", "telegrab.child1|telegrab.child2", "Telegrab runes", "\"Telegrab runes\", new ItemRequirement(\"Law rune\", ItemID.LAWRUNE),\n\t\t\tnew ItemRequirements(LogicType.OR, \"Air runes or staff\", new ItemRequirement(\"Air runes\", ItemCollections.AIR_RUNE), new ItemRequirement(\"Air staff\", ItemCollections.AIR_STAFF))", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "KingsRansom.java" ));
        rows.add(new RawGroup( "KingsRansom", "telegrab.child2", "OR", "telegrab.child2.child1|telegrab.child2.child2", "Air runes or staff", "LogicType.OR, \"Air runes or staff\", new ItemRequirement(\"Air runes\", ItemCollections.AIR_RUNE), new ItemRequirement(\"Air staff\", ItemCollections.AIR_STAFF)", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "KingsRansom.java" ));
        rows.add(new RawGroup( "LegendsQuest", "chargeOrbRunes", "AND", "cosmic3|elemental30", "Runes for any charge orb spell you have the level to cast", "LogicType.AND, \"Runes for any charge orb spell you have the level to cast\", cosmic3, elemental30", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "LegendsQuest.java" ));
        rows.add(new RawGroup( "LegendsQuest", "elemental30", "OR", "air30|water30|earth30|fire30", "Elemental runes", "LogicType.OR, \"Elemental runes\", air30, water30, earth30, fire30", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "LegendsQuest.java" ));
        rows.add(new RawGroup( "MA2Locator", "runesForCasts", "AND", "runesForCasts.child1|runesForCasts.child2|runesForCasts.child3", "Runes for 50+ casts of god spells", "\"Runes for 50+ casts of god spells\",\n\t\t\tnew ItemRequirement(\"Blood runes\", ItemID.BLOODRUNE, -1),\n\t\t\tnew ItemRequirement(\"Air runes\", ItemID.AIRRUNE, -1),\n\t\t\tnew ItemRequirement(\"Fire runes\", ItemID.FIRERUNE, -1)", "", "[]", true, "MANUAL", "Contains manual requirements or conditional branch selection", "", "[]", "MA2Locator.java" ));
        rows.add(new RawGroup( "MonkeyMadnessII", "talismanOr1000Coins", "OR", "talisman|talismanOr1000Coins.child2", "Monkey talisman or 1000 coins", "LogicType.OR, \"Monkey talisman or 1000 coins\", talisman, new ItemRequirement(\"1000 coins\", ItemCollections.COINS, 1000)", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "MonkeyMadnessII.java" ));
        rows.add(new RawGroup( "MourningsEndPartI", "coal20AndTar", "AND", "coalTar|coal20AndTar.child2", "", "coalTar, new ItemRequirement(\"Barrel of coal tar + 10-20 coal\", ItemID.COAL, 10)", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "MourningsEndPartI.java" ));
        rows.add(new RawGroup( "MourningsEndPartI", "coal20OrNaphtha", "OR", "coal20AndTar|naphtha", "Barrel of coal tar + 10-20 coal, or a barrel of naphtha", "LogicType.OR, \"Barrel of coal tar + 10-20 coal, or a barrel of naphtha\", coal20AndTar, naphtha", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "MourningsEndPartI.java" ));
        rows.add(new RawGroup( "MourningsEndPartII", "mournersOutfit", "AND", "gasMask|mournerTop|mournerTrousers|mournerCloak|mournerBoots|mournerGloves", "Full mourners' outfit", "\"Full mourners' outfit\", gasMask, mournerTop, mournerTrousers, mournerCloak, mournerBoots, mournerGloves", "", "[]", false, "BANK_CHECKABLE", "", "", "[]", "MourningsEndPartII.java" ));
        rows.add(new RawGroup( "RFDSirAmikVarze", "macheteAndRadimus", "CONDITIONAL", "macheteAndRadimus.whenTrue|macheteAndRadimus.whenFalse", "Legends Quest finished while logged in: machete; otherwise machete AND Radimus notes", "if (client.getGameState() == GameState.LOGGED_IN && QuestHelperQuest.LEGENDS_QUEST.getState(client, configManager) == QuestState.FINISHED) { machete } else { new ItemRequirements(\"Machete and Radimus notes\",\n\t\t\t\tmachete, radimusNotes) }", "", "[]", true, "CONDITIONAL", "Runtime branch selection required; use BranchesJson", "", "[{\"Child\":\"macheteAndRadimus.whenTrue\",\"Predicate\":{\"Kind\":\"LOGGED_IN_AND_QUEST_FINISHED\",\"Quest\":\"LEGENDS_QUEST\"},\"Negate\":false},{\"Child\":\"macheteAndRadimus.whenFalse\",\"Predicate\":{\"Kind\":\"LOGGED_IN_AND_QUEST_FINISHED\",\"Quest\":\"LEGENDS_QUEST\"},\"Negate\":true}]", "RFDSirAmikVarze.java" ));
        rows.add(new RawGroup( "RFDSirAmikVarze", "macheteAndRadimus.whenFalse", "AND", "macheteAndRadimus.whenFalse.child1", "", "new ItemRequirements(\"Machete and Radimus notes\",\n\t\t\t\tmachete, radimusNotes)", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "RFDSirAmikVarze.java" ));
        rows.add(new RawGroup( "RFDSirAmikVarze", "macheteAndRadimus.whenFalse.child1", "AND", "machete|radimusNotes", "Machete and Radimus notes", "\"Machete and Radimus notes\",\n\t\t\t\tmachete, radimusNotes", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "RFDSirAmikVarze.java" ));
        rows.add(new RawGroup( "RFDSirAmikVarze", "macheteAndRadimus.whenTrue", "AND", "machete", "", "machete", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "RFDSirAmikVarze.java" ));
        rows.add(new RawGroup( "RFDSkrachUglogwee", "ogreBowAndArrows", "AND", "ogreBow|ogreArrows", "Ogre bow + ogre arrows", "\"Ogre bow + ogre arrows\", ogreBow, ogreArrows", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "RFDSkrachUglogwee.java" ));
        rows.add(new RawGroup( "RoyalTrouble", "coalOrPickaxe", "CONDITIONAL", "coalOrPickaxe.whenTrue|coalOrPickaxe.whenFalse", "Mining 30+: coal OR pickaxe; below 30: coal only", "if (client.getRealSkillLevel(Skill.MINING) >= 30) { new ItemRequirements(LogicType.OR, \"Either 5 coal or a pickaxe\", coal5, pickaxe) } else { coal5 }", "", "[]", true, "CONDITIONAL", "Runtime branch selection required; use BranchesJson", "", "[{\"Child\":\"coalOrPickaxe.whenTrue\",\"Predicate\":{\"Level\":30,\"Skill\":\"MINING\",\"Kind\":\"SKILL_AT_LEAST\"},\"Negate\":false},{\"Child\":\"coalOrPickaxe.whenFalse\",\"Predicate\":{\"Level\":30,\"Skill\":\"MINING\",\"Kind\":\"SKILL_AT_LEAST\"},\"Negate\":true}]", "RoyalTrouble.java" ));
        rows.add(new RawGroup( "RoyalTrouble", "coalOrPickaxe.whenFalse", "AND", "coal5", "", "coal5", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "RoyalTrouble.java" ));
        rows.add(new RawGroup( "RoyalTrouble", "coalOrPickaxe.whenTrue", "AND", "coalOrPickaxe.whenTrue.child1", "", "new ItemRequirements(LogicType.OR, \"Either 5 coal or a pickaxe\", coal5, pickaxe)", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "RoyalTrouble.java" ));
        rows.add(new RawGroup( "RoyalTrouble", "coalOrPickaxe.whenTrue.child1", "OR", "coal5|pickaxe", "Either 5 coal or a pickaxe", "LogicType.OR, \"Either 5 coal or a pickaxe\", coal5, pickaxe", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "RoyalTrouble.java" ));
        rows.add(new RawGroup( "SinsOfTheFather", "enchantRubyRunesOrTablet", "OR", "enchantRunes|enchantTablet", "Runes or tablet for Enchant Ruby", "LogicType.OR, \"Runes or tablet for Enchant Ruby\", enchantRunes, enchantTablet", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "SinsOfTheFather.java" ));
        rows.add(new RawGroup( "SinsOfTheFather", "enchantRunes", "AND", "enchantRunes.child1|cosmicRune", "Ruby enchant runes", "\"Ruby enchant runes\", new ItemRequirements(LogicType.OR, \"3 air runes\", fireRune5, fireStaff), cosmicRune", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "SinsOfTheFather.java" ));
        rows.add(new RawGroup( "SinsOfTheFather", "enchantRunes.child1", "OR", "fireRune5|fireStaff", "3 air runes", "LogicType.OR, \"3 air runes\", fireRune5, fireStaff", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "SinsOfTheFather.java" ));
        rows.add(new RawGroup( "SinsOfTheFather", "vyrewatchOutfit", "AND", "vyrewatchOutfit.child1|vyrewatchOutfit.child2|vyrewatchOutfit.child3", "Vyrewatch outfit", "\"Vyrewatch outfit\",\n\t\t\tnew ItemRequirement(\"Vyrewatch top\", ItemID.VYRE_TORSO),\n\t\t\tnew ItemRequirement(\"Vyrewatch legs\", ItemID.VYRE_LEGS),\n\t\t\tnew ItemRequirement(\"Vyrewatch shoes\", ItemID.VYRE_SHOES)", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "SinsOfTheFather.java" ));
        rows.add(new RawGroup( "SinsOfTheFather", "vyrewatchOutfitOrCoins", "OR", "vyrewatchOutfit|vyrewatchOutfitOrCoins.child2", "Vyrewatch outfit or 1950 coins", "LogicType.OR, \"Vyrewatch outfit or 1950 coins\", vyrewatchOutfit,\n\t\t\tnew ItemRequirement(\"Coins\", ItemCollections.COINS, 1950)", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "SinsOfTheFather.java" ));
        rows.add(new RawGroup( "SongOfTheElves", "mournersOutfit", "AND", "gasMask|mournerTop|mournerTrousers|mournerCloak|mournerBoots|mournerGloves", "Full mourners' outfit", "\"Full mourners' outfit\", gasMask, mournerTop, mournerTrousers, mournerCloak, mournerBoots, mournerGloves", "", "[]", false, "BANK_CHECKABLE", "", "", "[]", "SongOfTheElves.java" ));
        rows.add(new RawGroup( "TaiBwoWannaiTrio", "slicedBananaOrKnife", "OR", "slicedBanana|knife", "Sliced banana or a knife", "LogicType.OR, \"Sliced banana or a knife\", slicedBanana, knife", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "TaiBwoWannaiTrio.java" ));
        rows.add(new RawGroup( "TempleOfIkov", "yewOrBetterBowOrThrowableWeapon", "OR", "yewOrBetterBow|throwableWeapon", "Yew, magic, dark bow, or thrown ranged weapons (darts, knives, thrownaxes)", "LogicType.OR, \"Yew, magic, dark bow, or thrown ranged weapons (darts, knives, thrownaxes)\", yewOrBetterBow, throwableWeapon", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "TempleOfIkov.java" ));
        rows.add(new RawGroup( "TheBloodMoonRises", "vyreNobleOutfit", "AND", "vyreNobleOutfit.child1|vyreNobleOutfit.child2|vyreNobleOutfit.child3", "Vyre noble outfit", "\"Vyre noble outfit\",\n\t\t\tnew ItemRequirement(\"Vyre noble top\", ItemID.VYRELORD_TORSO),\n\t\t\tnew ItemRequirement(\"Vyre noble legs\", ItemID.VYRELORD_LEGS),\n\t\t\tnew ItemRequirement(\"Vyre noble shoes\", ItemID.VYRELORD_SHOES)", "", "[]", false, "BANK_CHECKABLE", "", "", "[]", "TheBloodMoonRises.java" ));
        rows.add(new RawGroup( "TheFremennikExiles", "kegs2Or650Coins", "OR", "kegs2Or650Coins.child1|coins650", "2x kegs of beer or 650 coins", "LogicType.OR, \"2x kegs of beer or 650 coins\", kegsOfBeer.quantity(2), coins650", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "TheFremennikExiles.java" ));
        rows.add(new RawGroup( "TheFremennikIsles", "miningOreRequirement", "CONDITIONAL", "mithrilOre|coal|tinOre", "Ironman conditional: 6 mithril ore if Mining 55+, otherwise 7 coal at Mining 2-54, otherwise 8 tin ore at Mining 1", "Ironman conditional: 6 mithril ore if Mining 55+, otherwise 7 coal at Mining 2-54, otherwise 8 tin ore at Mining 1", "", "[]", true, "MANUAL", "Contains manual requirements or conditional branch selection", "", "[]", "TheFremennikIsles.java" ));
        rows.add(new RawGroup( "TheGreatBrainRobbery", "catsOrResources", "OR", "catsOrResources.child1|catsOrResources.child2", "10 Wooden cats, or 10 planks and 10 furs to make them", "LogicType.OR, \"10 Wooden cats, or 10 planks and 10 furs to make them\",\n\t\t\twoodenCats.quantity(10), new ItemRequirements(plank.quantity(10), fur.quantity(10))", "", "[]", true, "BANK_CHECKABLE", "", "Complex group needs further expansion", "[]", "TheGreatBrainRobbery.java" ));
        rows.add(new RawGroup( "TheGreatBrainRobbery", "catsOrResources.child2", "AND", "catsOrResources.child2.child1|catsOrResources.child2.child2", "", "plank.quantity(10), fur.quantity(10)", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "TheGreatBrainRobbery.java" ));
        rows.add(new RawGroup( "TheMageArenaII", "runesForCasts", "AND", "runesForCasts.child1|runesForCasts.child2|runesForCasts.child3", "Runes for 50+ casts of god spells", "\"Runes for 50+ casts of god spells\",\n\t\t\tnew ItemRequirement(\"Blood runes\", ItemID.BLOODRUNE, -1),\n\t\t\tnew ItemRequirement(\"Air runes\", ItemID.AIRRUNE, -1),\n\t\t\tnew ItemRequirement(\"Fire runes\", ItemID.FIRERUNE, -1)", "", "[]", true, "MANUAL", "Contains manual requirements or conditional branch selection", "", "[]", "TheMageArenaII.java" ));
        rows.add(new RawGroup( "TheSlugMenace", "accessToAltars", "AND", "airTalisman|waterTalisman|earthTalisman|fireTalisman|mindTalisman", "Access to the Air, Water, Earth, Fire, and Mind runecrafting altars", "\"Access to the Air, Water, Earth, Fire, and Mind runecrafting altars\",\n\t\t\tairTalisman, waterTalisman, earthTalisman, fireTalisman, mindTalisman", "", "[]", false, "BANK_CHECKABLE", "", "", "[]", "TheSlugMenace.java" ));
        rows.add(new RawGroup( "TrollStronghold", "climbingBootsOr12Coins", "OR", "climbingBoots|coins12", "Climbing boots or 12 coins", "LogicType.OR, \"Climbing boots or 12 coins\", climbingBoots, coins12", "", "[]", false, "BANK_CHECKABLE", "", "", "[]", "TrollStronghold.java" ));
        rows.add(new RawGroup( "VampyreSlayer", "beerOrTwoCoins", "OR", "beer|twoCoins", "A beer, or 2 coins to buy one", "LogicType.OR, \"A beer, or 2 coins to buy one\", beer, twoCoins", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "VampyreSlayer.java" ));
        rows.add(new RawGroup( "Wanted", "commorbComponents", "AND", "lawRune|enchantedGem|moltenGlass", "A law rune, an enchanted gem and some molten glass", "\"A law rune, an enchanted gem and some molten glass\", lawRune, enchantedGem, moltenGlass", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "Wanted.java" ));
        rows.add(new RawGroup( "Wanted", "commorbComponentsOrTenThousandGp", "OR", "commorbComponents|tenThousandGp", "A law rune, an enchanted gem and some molten glass OR 10k gp", "LogicType.OR, \"A law rune, an enchanted gem and some molten glass OR 10k gp\", commorbComponents, tenThousandGp", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "Wanted.java" ));
        rows.add(new RawGroup( "Wanted", "essence", "OR", "runeEssence|pureEssence", "20 Rune or Pure Essence (UNNOTED)", "LogicType.OR, \"20 Rune or Pure Essence (UNNOTED)\", runeEssence, pureEssence", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "Wanted.java" ));
        rows.add(new RawGroup( "WhileGuthixSleeps", "chargeOrbSpell", "AND", "cosmic3|elemental30", "Runes for any charge orb spell you have the level to cast", "LogicType.AND, \"Runes for any charge orb spell you have the level to cast\", cosmic3, elemental30", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "WhileGuthixSleeps.java" ));
        rows.add(new RawGroup( "WhileGuthixSleeps", "elemental30", "OR", "air30|water30|earth30|fire30", "Elemental runes", "LogicType.OR, \"Elemental runes\", air30, water30, earth30, fire30", "", "[]", true, "BANK_CHECKABLE", "", "", "[]", "WhileGuthixSleeps.java" ));
    }

    private static List<RawItem> buildAdvisories()
    {
        List<RawItem> rows = new ArrayList<>(97);
        addAdvisories0(rows);
        addAdvisories1(rows);
        return Collections.unmodifiableList(rows);
    }

    private static void addAdvisories0(List<RawItem> rows)
    {
        rows.add(new RawItem( "AKingdomDivided", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "AKingdomDivided.java" ));
        rows.add(new RawItem( "AKingdomDivided", "combatGearForJudgeOfYama", "ItemRequirement", "Melee combat gear to fight Judge of Yama", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "AKingdomDivided.java" ));
        rows.add(new RawItem( "AKingdomDivided", "combatGearForXamphur", "ItemRequirement", "Melee or range gear to fight Xamphur.", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "AKingdomDivided.java" ));
        rows.add(new RawItem( "AKingdomDivided", "fireSpellGear", "ItemRequirement", "Runes/equipment to cast FIRE bolt or better", "-1", "MANUAL", "1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement", "Non-specific item requirement", "AKingdomDivided.java" ));
        rows.add(new RawItem( "AKingdomDivided", "food", "ItemRequirement", "Decent food", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "AKingdomDivided.java" ));
        rows.add(new RawItem( "ANightAtTheTheatre", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "ANightAtTheTheatre.java" ));
        rows.add(new RawItem( "AnotherSliceOfHam", "combatGearRangedMagic", "ItemRequirement", "Magic or ranged combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "AnotherSliceOfHam.java" ));
        rows.add(new RawItem( "APorcineOfInterest", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "APorcineOfInterest.java" ));
        rows.add(new RawItem( "ASoulsBane", "combatGear", "ItemRequirement", "Combat gear + food", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "ASoulsBane.java" ));
        rows.add(new RawItem( "ATasteOfHope", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "ATasteOfHope.java" ));
        rows.add(new RawItem( "BarbarianTraining", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "BarbarianTraining.java" ));
        rows.add(new RawItem( "BarrowsHelper", "combatGear", "ItemRequirement", "Combat gear to kill all 6 Barrows Brothers", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "BarrowsHelper.java" ));
        rows.add(new RawItem( "Contact", "combatGear", "ItemRequirement", "Combat gear, preferably magic/ranged", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "Contact.java" ));
        rows.add(new RawItem( "Contact", "food", "ItemRequirement", "Food", "ItemCollections.GOOD_EATING_FOOD", "ITEM_COLLECTION", "-1", true, "", "", "", "[]", "MANUAL", "Variable or unknown quantity", "Non-fixed quantity", "Contact.java" ));
        rows.add(new RawItem( "Contact", "prayerPotions", "ItemRequirement", "Prayer potions", "ItemCollections.PRAYER_POTIONS", "ITEM_COLLECTION", "-1", true, "", "", "", "[]", "MANUAL", "Variable or unknown quantity", "Non-fixed quantity", "Contact.java" ));
        rows.add(new RawItem( "CreatureOfFenkenstrain", "armor", "ItemRequirement", "Armour and weapons defeat a level 51 monster and run past level 72 monsters", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "CreatureOfFenkenstrain.java" ));
        rows.add(new RawItem( "DeathToTheDorgeshuun", "combatGear", "ItemRequirement", "Magic or melee combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "DeathToTheDorgeshuun.java" ));
        rows.add(new RawItem( "DefenderOfVarrock", "combatGear", "ItemRequirement", "Combat gear and food", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "DefenderOfVarrock.java" ));
        rows.add(new RawItem( "DemonSlayer", "combatGear", "ItemRequirement", "Armour", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "DemonSlayer.java" ));
        rows.add(new RawItem( "DemonSlayer", "food", "ItemRequirement", "Food", "ItemCollections.GOOD_EATING_FOOD", "ITEM_COLLECTION", "-1", true, "", "", "", "[]", "MANUAL", "Variable or unknown quantity", "Non-fixed quantity", "DemonSlayer.java" ));
        rows.add(new RawItem( "DesertTreasure", "manyLockpicks", "ItemRequirement", "Many lockpicks", "ItemID.LOCKPICK", "ITEM_ID", "-1", true, "", "", "", "[]", "MANUAL", "Variable or unknown quantity", "Non-fixed quantity", "DesertTreasure.java" ));
        rows.add(new RawItem( "DesertTreasureII", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "DesertTreasureII.java" ));
        rows.add(new RawItem( "DragonSlayer", "combatGear", "ItemRequirement", "Combat equipment", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "DragonSlayer.java" ));
        rows.add(new RawItem( "DreamMentor", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "DreamMentor.java" ));
        rows.add(new RawItem( "DreamMentor", "foodAll1", "ItemRequirement", "some type of food", "-1", "MANUAL", "7", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement", "Non-specific item requirement", "DreamMentor.java" ));
        rows.add(new RawItem( "DreamMentor", "foodAll2", "ItemRequirement", "some other type of food", "-1", "MANUAL", "7", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement", "Non-specific item requirement", "DreamMentor.java" ));
        rows.add(new RawItem( "DreamMentor", "foodAll3", "ItemRequirement", "a third type of food", "-1", "MANUAL", "6", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement", "Non-specific item requirement", "DreamMentor.java" ));
        rows.add(new RawItem( "EnakhrasLament", "airSpellRunes", "ItemRequirement", "Runes to cast Wind Bolt or stronger", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "EnakhrasLament.java" ));
        rows.add(new RawItem( "EnakhrasLament", "crumbleUndeadRunes", "ItemRequirement", "Runes for crumble undead spell", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "EnakhrasLament.java" ));
        rows.add(new RawItem( "EnakhrasLament", "fireSpellRunes", "ItemRequirement", "Runes to cast Fire Bolt or stronger", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "EnakhrasLament.java" ));
        rows.add(new RawItem( "EnakhrasLament", "sandstone52", "ItemRequirement", "52 kg of sandstone", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "EnakhrasLament.java" ));
        rows.add(new RawItem( "FallenFromGrace", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "FallenFromGrace.java" ));
        rows.add(new RawItem( "FallenFromGrace", "raftOrSkiff", "ItemRequirement", "A raft or a skiff", "-1", "MANUAL", "1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement", "Non-specific item requirement", "FallenFromGrace.java" ));
        rows.add(new RawItem( "FamilyCrest", "runesForBlasts", "ItemRequirement", "Runes for casting each of the 4 blast spells", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "FamilyCrest.java" ));
        rows.add(new RawItem( "ForgettableTale", "randomItem", "ItemRequirement", "A random item per player", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "ForgettableTale.java" ));
        rows.add(new RawItem( "GettingAhead", "itemsTip", "ItemRequirement", "You can get all the required items during the quest.", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "GettingAhead.java" ));
        rows.add(new RawItem( "GhostsAhoy", "coins400", "ItemRequirement", "400+ coins", "ItemCollections.COINS", "ITEM_COLLECTION", "-1", true, "", "", "", "[]", "MANUAL", "Variable or unknown quantity", "Non-fixed quantity", "GhostsAhoy.java" ));
        rows.add(new RawItem( "GrimTales", "combatGear", "ItemRequirement", "Combat gear and food", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "GrimTales.java" ));
        rows.add(new RawItem( "HauntedMine", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "HauntedMine.java" ));
        rows.add(new RawItem( "HeroesQuest", "rangedMage", "ItemRequirement", "A ranged or magic attack method", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "HeroesQuest.java" ));
        rows.add(new RawItem( "HisFaithfulServants", "combatGear", "ItemRequirement", "Combat gear to kill all 6 Barrows Brothers", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "HisFaithfulServants.java" ));
        rows.add(new RawItem( "HopespearsWill", "potionsAndFood", "ItemRequirement", "Food and potions to defeat 5 enemies without armour, weapons, or magic", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "HopespearsWill.java" ));
        rows.add(new RawItem( "HorrorFromTheDeep", "combatRunes", "ItemRequirement", "20+ casts of each element spell", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "HorrorFromTheDeep.java" ));
        rows.add(new RawItem( "InSearchOfKnowledge", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "InSearchOfKnowledge.java" ));
        rows.add(new RawItem( "LandOfTheGoblins", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "LandOfTheGoblins.java" ));
        rows.add(new RawItem( "LegendsQuest", "combatGear", "ItemRequirement", "Combat gear, food and potions", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "LegendsQuest.java" ));
        rows.add(new RawItem( "MA2Locator", "runesForCasts.child1", "ItemRequirement", "Blood runes", "ItemID.BLOODRUNE", "ITEM_ID", "-1", true, "", "", "runesForCasts", "[]", "MANUAL", "Variable or unknown quantity", "", "MA2Locator.java" ));
        rows.add(new RawItem( "MA2Locator", "runesForCasts.child2", "ItemRequirement", "Air runes", "ItemID.AIRRUNE", "ITEM_ID", "-1", true, "", "", "runesForCasts", "[]", "MANUAL", "Variable or unknown quantity", "", "MA2Locator.java" ));
        rows.add(new RawItem( "MA2Locator", "runesForCasts.child3", "ItemRequirement", "Fire runes", "ItemID.FIRERUNE", "ITEM_ID", "-1", true, "", "", "runesForCasts", "[]", "MANUAL", "Variable or unknown quantity", "", "MA2Locator.java" ));
        rows.add(new RawItem( "MakingFriendsWithMyArm", "combatRangeMelee", "ItemRequirement", "Combat gear, preferably ranged or melee", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "MakingFriendsWithMyArm.java" ));
        rows.add(new RawItem( "MerlinsCrystal", "combatGear", "ItemRequirement", "Combat gear + food for Sir Mordred (level 39)", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "MerlinsCrystal.java" ));
        rows.add(new RawItem( "PerilousMoon", "combatGear", "ItemRequirement", "Combat armour with high defensive bonuses", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "PerilousMoon.java" ));
        rows.add(new RawItem( "RFDEvilDave", "stews", "ItemRequirement", "Many stews", "ItemID.STEW", "ITEM_ID", "-1", true, "", "", "", "[]", "MANUAL", "Variable or unknown quantity", "Non-fixed quantity", "RFDEvilDave.java" ));
        rows.add(new RawItem( "RFDFinal", "combatGear", "ItemRequirement", "Combat gear, food and potions", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "RFDFinal.java" ));
        rows.add(new RawItem( "RoyalTrouble", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "RoyalTrouble.java" ));
        rows.add(new RawItem( "RumDeal", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "RumDeal.java" ));
        rows.add(new RawItem( "Scrambled", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "Scrambled.java" ));
        rows.add(new RawItem( "SecretsOfTheNorth", "combatGear", "ItemRequirement", "Combat Gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "SecretsOfTheNorth.java" ));
        rows.add(new RawItem( "SecretsOfTheNorth", "food", "ItemRequirement", "Food", "ItemCollections.GOOD_EATING_FOOD", "ITEM_COLLECTION", "-1", true, "", "", "", "[]", "MANUAL", "Variable or unknown quantity", "Non-fixed quantity", "SecretsOfTheNorth.java" ));
        rows.add(new RawItem( "SinsOfTheFather", "combatGear", "ItemRequirement", "Combat gear + food", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "SinsOfTheFather.java" ));
        rows.add(new RawItem( "SpiritsOfTheElid", "crushWep", "ItemRequirement", "Crush Weapon Style", "-1", "MANUAL", "1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement", "Non-specific item requirement", "SpiritsOfTheElid.java" ));
        rows.add(new RawItem( "SpiritsOfTheElid", "slashWep", "ItemRequirement", "Slash Weapon Style", "-1", "MANUAL", "1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement", "Non-specific item requirement", "SpiritsOfTheElid.java" ));
        rows.add(new RawItem( "SpiritsOfTheElid", "stabWep", "ItemRequirement", "Stab Weapon Style", "-1", "MANUAL", "1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement", "Non-specific item requirement", "SpiritsOfTheElid.java" ));
        rows.add(new RawItem( "TaiBwoWannaiTrio", "rangedOrMagic", "ItemRequirement", "Ranged or Magic equipment to kill a level 3 monkey", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "TaiBwoWannaiTrio.java" ));
        rows.add(new RawItem( "TaleOfTheRighteous", "rangedWeapon", "ItemRequirement", "Any ranged weapon + ammo", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "TaleOfTheRighteous.java" ));
        rows.add(new RawItem( "TaleOfTheRighteous", "runesForCombat", "ItemRequirement", "Runes for a few casts of a combat spell", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "TaleOfTheRighteous.java" ));
        rows.add(new RawItem( "TheCorsairCurse", "combatGear", "ItemRequirement", "Combat gear + food to defeat Ithoi (level 34), who uses magic", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "TheCorsairCurse.java" ));
        rows.add(new RawItem( "TheFeud", "combatGear", "ItemRequirement", "Combat Gear bring Range or Mage Gear if safe spotting.", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "TheFeud.java" ));
        rows.add(new RawItem( "TheFinalDawn", "combatGear", "ItemRequirement", "Melee Combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "TheFinalDawn.java" ));
        rows.add(new RawItem( "TheFremennikExiles", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "TheFremennikExiles.java" ));
        rows.add(new RawItem( "TheGeneralsShadow", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "TheGeneralsShadow.java" ));
        rows.add(new RawItem( "TheGiantDwarf", "oresBars", "ItemRequirement", "Various ores and bars", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "TheGiantDwarf.java" ));
        rows.add(new RawItem( "TheGreatBrainRobbery", "noPet", "ItemRequirement", "No pet following you or in your inventory", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "TheGreatBrainRobbery.java" ));
        rows.add(new RawItem( "TheHeartOfDarkness", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "TheHeartOfDarkness.java" ));
        rows.add(new RawItem( "TheMageArenaI", "runesForCasts", "ItemRequirement", "Runes for fighting Kolodion", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "TheMageArenaI.java" ));
    }

    private static void addAdvisories1(List<RawItem> rows)
    {
        rows.add(new RawItem( "TheMageArenaII", "runesForCasts.child1", "ItemRequirement", "Blood runes", "ItemID.BLOODRUNE", "ITEM_ID", "-1", true, "", "", "runesForCasts", "[]", "MANUAL", "Variable or unknown quantity", "", "TheMageArenaII.java" ));
        rows.add(new RawItem( "TheMageArenaII", "runesForCasts.child2", "ItemRequirement", "Air runes", "ItemID.AIRRUNE", "ITEM_ID", "-1", true, "", "", "runesForCasts", "[]", "MANUAL", "Variable or unknown quantity", "", "TheMageArenaII.java" ));
        rows.add(new RawItem( "TheMageArenaII", "runesForCasts.child3", "ItemRequirement", "Fire runes", "ItemID.FIRERUNE", "ITEM_ID", "-1", true, "", "", "runesForCasts", "[]", "MANUAL", "Variable or unknown quantity", "", "TheMageArenaII.java" ));
        rows.add(new RawItem( "ThePathOfGlouphrie", "combatGear", "ItemRequirement", "Combat equipment", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "ThePathOfGlouphrie.java" ));
        rows.add(new RawItem( "ThePathOfGlouphrie", "food", "ItemRequirement", "Food", "ItemCollections.GOOD_EATING_FOOD", "ITEM_COLLECTION", "-1", true, "", "", "", "[]", "MANUAL", "Variable or unknown quantity", "Non-fixed quantity", "ThePathOfGlouphrie.java" ));
        rows.add(new RawItem( "ThePathOfGlouphrie", "prayerPotions", "ItemRequirement", "Prayer potions", "ItemCollections.PRAYER_POTIONS", "ITEM_COLLECTION", "-1", true, "", "", "", "[]", "MANUAL", "Variable or unknown quantity", "Non-fixed quantity", "ThePathOfGlouphrie.java" ));
        rows.add(new RawItem( "TheRedReef", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "TheRedReef.java" ));
        rows.add(new RawItem( "TheRedReef", "rangedCombatGearOrShipWithCannons", "ItemRequirement", "Ranged/Mage combat gear to skip boat combat, or a boat with cannons to deal with pirates. An upgraded keel helps with survival. (Mithril is more than enough)", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "TheRedReef.java" ));
        rows.add(new RawItem( "TreeGnomeVillage", "combatGear", "ItemRequirement", "Combat gear (magic is best)", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "TreeGnomeVillage.java" ));
        rows.add(new RawItem( "TrollRomance", "combatGear", "ItemRequirement", "Combat gear, food, and potions", "-1", "MANUAL", "-1", true, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "TrollRomance.java" ));
        rows.add(new RawItem( "TroubledTortugans", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "TroubledTortugans.java" ));
        rows.add(new RawItem( "TroubledTortugans", "food", "ItemRequirement", "Food", "ItemCollections.GOOD_EATING_FOOD", "ITEM_COLLECTION", "-1", true, "", "", "", "[]", "MANUAL", "Variable or unknown quantity", "Non-fixed quantity", "TroubledTortugans.java" ));
        rows.add(new RawItem( "TroubledTortugans", "prayer", "ItemRequirement", "Prayer restore", "ItemCollections.PRAYER_POTIONS", "ITEM_COLLECTION", "-1", true, "", "", "", "[]", "MANUAL", "Variable or unknown quantity", "Non-fixed quantity", "TroubledTortugans.java" ));
        rows.add(new RawItem( "TwilightsPromise", "twoCombatStyles", "ItemRequirement", "Two combat styles", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "TwilightsPromise.java" ));
        rows.add(new RawItem( "UndergroundPass", "combatEquipment", "ItemRequirement", "Combat Equipment", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "UndergroundPass.java" ));
        rows.add(new RawItem( "VampyreSlayer", "combatGear", "ItemRequirement", "Combat gear + food to defeat Count Draynor", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "VampyreSlayer.java" ));
        rows.add(new RawItem( "Wanted", "combatGear", "ItemRequirement", "Combat gear", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "Wanted.java" ));
        rows.add(new RawItem( "WhileGuthixSleeps", "magicGear", "ItemRequirement", "Magic weapon", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "WhileGuthixSleeps.java" ));
        rows.add(new RawItem( "WhileGuthixSleeps", "meleeGear", "ItemRequirement", "Melee weapon", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "WhileGuthixSleeps.java" ));
        rows.add(new RawItem( "WhileGuthixSleeps", "rangedGear", "ItemRequirement", "Ranged weapon", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "WhileGuthixSleeps.java" ));
        rows.add(new RawItem( "WitchsHouse", "armourAndWeapon", "ItemRequirement", "Combat gear and food for monsters up to level 53", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "WitchsHouse.java" ));
        rows.add(new RawItem( "ZogreFleshEaters", "combatGear", "ItemRequirement", "Either brutal arrows or Crumble Undead for fighting Slash Bash", "-1", "MANUAL", "-1", false, "", "", "", "[]", "MANUAL", "Non-specific/manual requirement; Variable or unknown quantity", "Non-specific item requirement; Non-fixed quantity", "ZogreFleshEaters.java" ));
    }

    public static final class RawItem
    {
        private final String quest;
        private final String variable;
        private final String requirementClass;
        private final String itemName;
        private final String itemSource;
        private final String sourceType;
        private final String quantity;
        private final boolean consumed;
        private final String alternateSources;
        private final String condition;
        private final String group;
        private final String conditionsJson;
        private final String status;
        private final String reason;
        private final String originalReview;
        private final String sourceFile;

        /** Common unconditional bank-checkable record; exceptional metadata stays explicit below. */
        private RawItem(String quest, String variable, String itemName, String itemSource,
                        String sourceType, String quantity, boolean consumed, String alternateSources)
        {
            this(quest, variable, "ItemRequirement", itemName, itemSource, sourceType, quantity,
                    consumed, alternateSources, "", "", "[]", "BANK_CHECKABLE", "", "", quest + ".java");
        }

        public RawItem(
                String quest,
                String variable,
                String requirementClass,
                String itemName,
                String itemSource,
                String sourceType,
                String quantity,
                boolean consumed,
                String alternateSources,
                String condition,
                String group,
                String conditionsJson,
                String status,
                String reason,
                String originalReview,
                String sourceFile)
        {
            this.quest = quest;
            this.variable = variable;
            this.requirementClass = requirementClass;
            this.itemName = itemName;
            this.itemSource = itemSource;
            this.sourceType = sourceType;
            this.quantity = quantity;
            this.consumed = consumed;
            this.alternateSources = alternateSources;
            this.condition = condition;
            this.group = group;
            this.conditionsJson = conditionsJson;
            this.status = status;
            this.reason = reason;
            this.originalReview = originalReview;
            this.sourceFile = sourceFile;
        }

        public String getQuest() { return quest; }
        public String getVariable() { return variable; }
        public String getRequirementClass() { return requirementClass; }
        public String getItemName() { return itemName; }
        public String getItemSource() { return itemSource; }
        public String getSourceType() { return sourceType; }
        public String getQuantity() { return quantity; }
        public boolean isConsumed() { return consumed; }
        public String getAlternateSources() { return alternateSources; }
        public String getCondition() { return condition; }
        public String getGroup() { return group; }
        public String getConditionsJson() { return conditionsJson; }
        public String getStatus() { return status; }
        public String getReason() { return reason; }
        public String getOriginalReview() { return originalReview; }
        public String getSourceFile() { return sourceFile; }
    }

    public static final class RawGroup
    {
        private final String quest;
        private final String group;
        private final String logic;
        private final String children;
        private final String description;
        private final String argumentText;
        private final String condition;
        private final String conditionsJson;
        private final boolean consumed;
        private final String status;
        private final String reason;
        private final String originalReview;
        private final String branchesJson;
        private final String sourceFile;

        public RawGroup(
                String quest,
                String group,
                String logic,
                String children,
                String description,
                String argumentText,
                String condition,
                String conditionsJson,
                boolean consumed,
                String status,
                String reason,
                String originalReview,
                String branchesJson,
                String sourceFile)
        {
            this.quest = quest;
            this.group = group;
            this.logic = logic;
            this.children = children;
            this.description = description;
            this.argumentText = argumentText;
            this.condition = condition;
            this.conditionsJson = conditionsJson;
            this.consumed = consumed;
            this.status = status;
            this.reason = reason;
            this.originalReview = originalReview;
            this.branchesJson = branchesJson;
            this.sourceFile = sourceFile;
        }

        public String getQuest() { return quest; }
        public String getGroup() { return group; }
        public String getLogic() { return logic; }
        public String getChildren() { return children; }
        public String getDescription() { return description; }
        public String getArgumentText() { return argumentText; }
        public String getCondition() { return condition; }
        public String getConditionsJson() { return conditionsJson; }
        public boolean isConsumed() { return consumed; }
        public String getStatus() { return status; }
        public String getReason() { return reason; }
        public String getOriginalReview() { return originalReview; }
        public String getBranchesJson() { return branchesJson; }
        public String getSourceFile() { return sourceFile; }
    }
}
