package com.ironquestprep;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * AUTO-GENERATED FILE.
 *
 * Grouped by quest and classification; all original explicit entries are preserved.
 */
public final class GeneratedPrepClassification
{
    public enum Type
    {
        PREP_REQUIRED,
        QUEST_OBTAINED,
        OPTIONAL_RECOMMENDED
    }

    private static final Map<String, Type> TYPES = build();

    private GeneratedPrepClassification()
    {
    }

    static Map<String, Type> build()
    {
        Map<String, Type> values = new HashMap<>();

        add(values, Type.PREP_REQUIRED, "AKingdomDivided", "anyAxe darkEssenceBlock defencePotion moltenGlass volcanicSulphur");
        add(values, Type.PREP_REQUIRED, "AlfredGrimhandsBarcrawl", "coins208");
        add(values, Type.PREP_REQUIRED, "ANightAtTheTheatre", "axe flail food ghostSpeakAmulet saw");
        add(values, Type.PREP_REQUIRED, "AnimalMagnetism", "ectoToken20 ghostspeak hammer hardLeather holySymbol ironBar5 mithrilAxe polishedButtons");
        add(values, Type.PREP_REQUIRED, "AnotherSliceOfHam", "lightSource ropeForEntrance tinderbox");
        add(values, Type.PREP_REQUIRED, "APorcineOfInterest", "rope slashItem");
        add(values, Type.PREP_REQUIRED, "ASoulsBane", "rope");
        add(values, Type.PREP_REQUIRED, "ATailOfTwoCats", "catspeak chocolateCake deathRune5 desertBottom desertTop dibber logs milk potatoSeed4 rake shears tinderbox vialOfWater");
        add(values, Type.PREP_REQUIRED, "ATasteOfHope", "airRune3 airStaff chisel coins1000 cosmicRune emerald enchantTablet rodOfIvandis vialOfWaterNoTip");
        add(values, Type.PREP_REQUIRED, "AtFirstLight", "boxTrap costumeNeedle hammer jerboaTail2OrBoxTrap.child1 needle");
        add(values, Type.QUEST_OBTAINED, "AtFirstLight", "jerboaTail");
        add(values, Type.PREP_REQUIRED, "BarbarianTraining", "antifireShield attackPotion axe bow bronzeBar feathers hammer knife logs oakLogs roe sapling seed spade tinderbox");
        add(values, Type.PREP_REQUIRED, "BarrowsHelper", "spade");
        add(values, Type.PREP_REQUIRED, "BearYourSoul", "dustyKeyOr70AgilOrKeyMasterTeleport spade");
        add(values, Type.PREP_REQUIRED, "BelowIceMountain", "bread coins cookedMeat knife");
        add(values, Type.PREP_REQUIRED, "BeneathCursedSands", "coal ironBar meat spade tinderbox");
        add(values, Type.PREP_REQUIRED, "BetweenARock", "cannonMould coins1000 goldBars4 hammer pickaxe");
        add(values, Type.PREP_REQUIRED, "BigChompyBirdHunting", "axe cabbage chisel doogle equa feathers knife onion potato tomato wolfBones4");
        add(values, Type.PREP_REQUIRED, "Biohazard", "gasMask");
        add(values, Type.PREP_REQUIRED, "BlackKnightFortress", "bronzeMed cabbage ironChainbody");
        add(values, Type.PREP_REQUIRED, "BoneVoyage", "marrentillPotionUnf vodka2");
        add(values, Type.PREP_REQUIRED, "CastleWarsBalloonFlight", "yewLogs");
        add(values, Type.PREP_REQUIRED, "ClientOfKourend", "feather");
        add(values, Type.PREP_REQUIRED, "ClockTower", "bucketOfWater");
        add(values, Type.PREP_REQUIRED, "ColdWar", "clockworkOrSteelBar feathers hammer leather mahoganyPlank oakPlanks plank rawCodOrCharos silk spade steelNails swampTar");
        add(values, Type.PREP_REQUIRED, "Contact", "lightSource tinderbox");
        add(values, Type.PREP_REQUIRED, "CooksAssistant", "egg flour milk");
        add(values, Type.PREP_REQUIRED, "CraftingGuildBalloonFlight", "oakLogs");
        add(values, Type.PREP_REQUIRED, "CreatureOfFenkenstrain", "bronzeWire coins coins50 ghostSpeakAmulet hammer needle silverBar spade telegrab.child1 telegrab.child2 thread");
        add(values, Type.PREP_REQUIRED, "CurrentAffairs", "charcoalRequirement coinsRequirement");
        add(values, Type.PREP_REQUIRED, "CurseOfTheEmptyLord", "ghostspeakItems knife ringOfVis");
        add(values, Type.PREP_REQUIRED, "DaddysHome", "bolt5 hammer nails20 plank10 saw");
        add(values, Type.PREP_REQUIRED, "DarknessOfHallowvale", "hammer knife nails8 planks2");
        add(values, Type.PREP_REQUIRED, "DeathPlateau", "bread coins ironBar premadeBlurb trout");
        add(values, Type.PREP_REQUIRED, "DeathToTheDorgeshuun", "hamBoot2 hamCloak2 hamGloves2 hamHood2 hamLogo2 hamRobe2 hamShirt2 lightSource pickaxe tinderbox");
        add(values, Type.PREP_REQUIRED, "DefenderOfVarrock", "pickaxe");
        add(values, Type.PREP_REQUIRED, "DemonSlayer", "bones bucketOfWaterOptional coin");
        add(values, Type.PREP_REQUIRED, "DesertTreasure", "ashes bloodRune bones cake charcoal climbingBoots coins650 faceMask garlicPowder iceGloves magicLogs12 moltenGlass6 silverBar spice spikedBoots steelBars6 tinderbox");
        add(values, Type.PREP_REQUIRED, "DesertTreasureII", "allBursts.child1 allBursts.child2 allBursts.child3 allBursts.child4 allBursts.child5 allBursts.child6 allBursts.child7 facemask ringOfVisibility");
        add(values, Type.PREP_REQUIRED, "DeviousMinds", "bowString largePouch mith2h");
        add(values, Type.PREP_REQUIRED, "DoricsQuest", "clay copper iron");
        add(values, Type.PREP_REQUIRED, "DragonSlayer", "hammer lobsterPot mindBomb nails90 planks3 silk telegrab telegrabOrTenK.child1 twoThousandCoins unfiredBowl");
        add(values, Type.PREP_REQUIRED, "DragonSlayerII", "airRune15 airRune21 antifireShield astralRune axe bloodRune3 catspeakAmulet chisel dragonstone fireRune21 fireRune30 ghostspeakOrMory2 glassblowingPipe goutweed hammer lightSource machete moltenGlass2 nails12OrMore oakPlank8 pestleAndMortarHighlighted pickaxe saw sealOfPassage spade swampPaste10 tinderbox wrathRune3");
        add(values, Type.PREP_REQUIRED, "DreamMentor", "astralRune goutweed hammer pestleAndMortar sealOfPassage tinderbox");
        add(values, Type.PREP_REQUIRED, "DruidicRitual", "rawBear rawBeef rawChicken rawRat");
        add(values, Type.PREP_REQUIRED, "DwarfCannon", "hammer");
        add(values, Type.PREP_REQUIRED, "EadgarsRuse", "climbingBoots coins12 grain10 logs2 pestleAndMortar pineappleChunks ranarrPotionUnf rawChicken5 tinderbox vodka");
        add(values, Type.PREP_REQUIRED, "EaglesPeak", "coins tar yellowDye");
        add(values, Type.PREP_REQUIRED, "ElementalWorkshopI", "coal4 hammer knife leather needle pickaxe thread");
        add(values, Type.PREP_REQUIRED, "ElementalWorkshopII", "batteredKey coal hammer pickaxe");
        add(values, Type.PREP_REQUIRED, "EnakhrasLament", "breadOrCake candle chiselHighlighted coal granite2 log mapleLog oakLog pickaxe softClay tinderbox willowLog");
        add(values, Type.PREP_REQUIRED, "EnchantedKey", "key spade");
        add(values, Type.PREP_REQUIRED, "EnlightenedJourney", "ballOfWool bowl emptySack8 logs10 papyrus3 redDye sackOfPotatoes silk10 tinderbox unlitCandle willowBranches12 yellowDye");
        add(values, Type.PREP_REQUIRED, "FairytaleI", "dramenOrLunarStaff draynorSkull ghostspeak secateurs spade");
        add(values, Type.PREP_REQUIRED, "FairytaleII", "dramenOrLunarStaff pestleAndMortar vialOfWater");
        add(values, Type.PREP_REQUIRED, "FallenFromGrace", "chisel hammer pickaxe");
        add(values, Type.PREP_REQUIRED, "FamilyCrest", "antipoison bass necklaceMould pickaxe ringMould ruby2 salmon shrimp swordfish tuna");
        add(values, Type.PREP_REQUIRED, "FamilyPest", "coins");
        add(values, Type.PREP_REQUIRED, "FightArena", "coins");
        add(values, Type.PREP_REQUIRED, "FishingContest", "coins spade");
        add(values, Type.QUEST_OBTAINED, "FishingContest", "fishingRod garlic redVineWorm");
        add(values, Type.PREP_REQUIRED, "ForgettableTale", "barleyMalt2 beer beerGlass bucketOfWater2 coins500 dibber dwarvenStout kebab rake");
        add(values, Type.PREP_REQUIRED, "GardenOfTranquillity", "cabbageSeed3 compost2 dibber essence fishingRod hammer marigoldSeed onionSeed3 pestle plantCure2 plantPot rake ringOfCharos secateurs spade trowel wateringCan");
        add(values, Type.PREP_REQUIRED, "GertrudesCat", "bucketOfMilk coins sardineHighlighted");
        add(values, Type.PREP_REQUIRED, "GettingAhead", "bearFur hammer knife nails needle planks potOfFlour redDye saw softClay thread");
        add(values, Type.PREP_REQUIRED, "GhostsAhoy", "blueDye bucketOfSlime charos costumeNeedle ectoTokensCharos ectoTokensNoCharos ghostspeak knife milk needle nettleTea oakLongbow redDye silk spade thread yellowDye");
        add(values, Type.PREP_REQUIRED, "GoblinDiplomacy", "blueDye mailReq orangeDye");
        add(values, Type.PREP_REQUIRED, "GrandTreeBalloonFlight", "magicLogs");
        add(values, Type.PREP_REQUIRED, "GrimTales", "axe can dibber houseKey tarrominUnf2");
        add(values, Type.PREP_REQUIRED, "HeroesQuest", "blackFullHelm blackPlatebody blackPlatelegs fishingBait fishingRod harralanderUnf iceGloves pickaxe");
        add(values, Type.QUEST_OBTAINED, "HeroesQuest", "dustyKeyHint");
        add(values, Type.PREP_REQUIRED, "HisFaithfulServants", "spade");
        add(values, Type.PREP_REQUIRED, "HolyGrail", "excalibur");
        add(values, Type.PREP_REQUIRED, "HopespearsWill", "dramenStaff ghostspeakAmulet goblinPotion ringOfVisibility");
        add(values, Type.PREP_REQUIRED, "HorrorFromTheDeep", "airRune arrow earthRune fireRune hammer moltenGlass plank2 steelNails swampTar1 sword tinderbox waterRune");
        add(values, Type.PREP_REQUIRED, "IcthlarinsLittleHelper", "bagOfSaltOrBucket bucketOfSap coins30 coins600 linen tinderbox waterskin4 willowLog");
        add(values, Type.PREP_REQUIRED, "ImpCatcher", "blackBead redBead whiteBead yellowBead");
        add(values, Type.PREP_REQUIRED, "InAidOfTheMyreque", "bronzeAxes10 bucketTo5 coal cosmicRune efaritaysAidOrSilverWeapon foodForChest hammer mackerel10 mithrilBar nails44 pickaxe planks11 rope sapphire silverBar snails10 softClay spade steelBars2 swampPaste tinderboxes4 waterRune");
        add(values, Type.PREP_REQUIRED, "InSearchOfKnowledge", "food5 knife");
        add(values, Type.PREP_REQUIRED, "InSearchOfTheMyreque", "coins10OrCharos.child1 coins10OrCharos.child2 druidPouch5 hammer plank6 steeldagger steelLong steelMace steelNails225 steelSword2 steelWarhammer");
        add(values, Type.PREP_REQUIRED, "KingsRansom", "animateRock blackKnightBody blackKnightHelm blackKnightLeg bronzeMed grabOrLockpick.child1 granite ironChain telegrab.child1 telegrab.child2.child1 telegrab.child2.child2");
        add(values, Type.PREP_REQUIRED, "LandOfTheGoblins", "blueDye coins fishingRod goblinMail lightSource orangeDye pestleAndMortar purpleDye rawSlimyEel toadflaxPotionUnf vial yellowDye");
        add(values, Type.PREP_REQUIRED, "LegendsQuest", "air30 anyNotes ardrigal charcoal3 cosmic3 diamond earth30 earthRune emerald fire30 goldBar2 hammer jade lawRune2 lockpick machete mindRune opal papyrus3 pickaxe rope ruby runeOrDragonAxe sapphire snakeWeed soulRune topaz unpoweredOrb vialOfWater water30");
        add(values, Type.PREP_REQUIRED, "LostCity", "axe knife");
        add(values, Type.PREP_REQUIRED, "LunarDiplomacy", "airTalisman bullseyeLantern dramenStaff earthTalisman fireTalisman guam hammer marrentill needle pestle pickaxe spade thread tinderboxHighlighted waterTalisman");
        add(values, Type.PREP_REQUIRED, "MA2Locator", "guthixStaff knife saradominStaff zamorakStaff");
        add(values, Type.PREP_REQUIRED, "MakingFriendsWithMyArm", "boltOfCloth cadavaBerries hammer mahogPlanks5 saw");
        add(values, Type.PREP_REQUIRED, "MakingHistory", "ghostSpeakAmulet saphAmulet spade");
        add(values, Type.PREP_REQUIRED, "MerlinsCrystal", "batBones bread bucketOfWax tinderbox");
        add(values, Type.PREP_REQUIRED, "MonkeyMadnessI", "ballOfWool bananaReq goldBar");
        add(values, Type.QUEST_OBTAINED, "MonkeyMadnessI", "monkeyBonesOrCorpse");
        add(values, Type.QUEST_OBTAINED, "MonkeyMadnessII", "chiselSidebar hammerSidebar");
        add(values, Type.PREP_REQUIRED, "MonkeyMadnessII", "grape lemon lightSource logs mspeakAmulet ninjaGreegree pestle pickaxe talisman talismanOr1000Coins.child2 translationBook");
        add(values, Type.PREP_REQUIRED, "MonksFriend", "jugOfWater log");
        add(values, Type.PREP_REQUIRED, "MountainDaughter", "axe gloves pickaxe plank pole rope");
        add(values, Type.PREP_REQUIRED, "MourningsEndPartI", "bearFur blueDye coal20AndTar.child2 coalTar feather greenDye leather magicLogs naphtha ogreBellows redDye silk2 toadCrunchies waterBucket yellowDye");
        add(values, Type.QUEST_OBTAINED, "MourningsEndPartI", "rottenApple");
        add(values, Type.PREP_REQUIRED, "MourningsEndPartII", "chisel deathTalismanHeader gasMask mournerBoots mournerCloak mournerGloves mournerTop mournerTrousers rope");
        add(values, Type.PREP_REQUIRED, "MurderMystery", "pot");
        add(values, Type.PREP_REQUIRED, "MyArmsBigAdventure", "bucket climbingBoots dibber rake spade superCompost8 ugthanki3");
        add(values, Type.PREP_REQUIRED, "NatureSpirit", "ghostspeak silverSickle");
        add(values, Type.PREP_REQUIRED, "ObservatoryQuest", "bronzeBar moltenGlass plank");
        add(values, Type.PREP_REQUIRED, "OlafsQuest", "axe spade tinderbox");
        add(values, Type.PREP_REQUIRED, "OneSmallFavour", "bronzeBar chisel emptyCup guam2 hammer harralander hotWaterBowl ironBar marrentill pot steelBars4");
        add(values, Type.PREP_REQUIRED, "Pandemonium", "hammer saw");
        add(values, Type.QUEST_OBTAINED, "PerilousMoon", "bigFishingNet knife pestleAndMortar rope");
        add(values, Type.PREP_REQUIRED, "PiratesTreasure", "sixtyCoins spade tenBananas");
        add(values, Type.PREP_REQUIRED, "PlagueCity", "bucketOfMilk chocolateDust dwellberries rope snapeGrass spade");
        add(values, Type.PREP_REQUIRED, "PriestInPeril", "bucket runeEssence");
        add(values, Type.PREP_REQUIRED, "PrinceAliRescue", "ashes ballsOfWool3 beers3 bronzeBar bucketOfWater coins100 pinkSkirt potOfFlour redberries rope softClay yellowDye");
        add(values, Type.PREP_REQUIRED, "PryingTimes", "captainsLogRequirement hammerRequirement redberryPieRequirement steelBarRequirement");
        add(values, Type.PREP_REQUIRED, "RagAndBoneManI", "coins logs pots tinderbox");
        add(values, Type.PREP_REQUIRED, "RagAndBoneManII", "axe coins dustyKey fishingExplosive iceCooler lightSource logs mirrorShield pots rangedWeapon rope tinderbox");
        add(values, Type.PREP_REQUIRED, "RatCatchers", "bucketOfMilk catspeakAmuletOrDS2 cheese coins101 fish8 kwuarm marrentill potOfWeeds redEggs snakeCharm tinderbox unicornHornDust vial");
        add(values, Type.PREP_REQUIRED, "Regicide", "arrows bow coal20 cookedRabbit gloves limestone pestle pot spade stripOfCloth tinderbox");
        add(values, Type.PREP_REQUIRED, "RFDAwowogei", "bananaHighlighted gorillaGreegree knife mAmulet monkeyNutsHighlighted ninjaGreegree pestleAndMortar ropeHighlighted zombieGreegree");
        add(values, Type.PREP_REQUIRED, "RFDDwarf", "asgarniaAle4 bowlOfWater coins320 egg flour iceGloves milk");
        add(values, Type.PREP_REQUIRED, "RFDFinal", "iceGloves restorePotions");
        add(values, Type.PREP_REQUIRED, "RFDGoblins", "blueGreenPurpledye bread bucketOfWater charcoal fishingBait knife orange spice");
        add(values, Type.PREP_REQUIRED, "RFDLumbridgeGuide", "egg flour milk tin");
        add(values, Type.PREP_REQUIRED, "RFDPiratePete", "breadHighlighted bronzeWire3 fishBowl knifeHighlighted needle pestleHighlighted rawCodHighlighted");
        add(values, Type.PREP_REQUIRED, "RFDSirAmikVarze", "axe bucketOfMilk cornflour dramenBranch dramenStaffOrLunar iceGloves machete pestleAndMortar potOfCream radimusNotes rawChicken vanillaPod");
        add(values, Type.PREP_REQUIRED, "RFDSkrachUglogwee", "axeHighlighted ballOfWool chompy ironSpit log ogreArrows ogreBellows ogreBow pickaxe tinderbox");
        add(values, Type.PREP_REQUIRED, "RFDStart", "ashes eyeOfNewt fruitBlast greenmansAle rottenTomato");
        add(values, Type.PREP_REQUIRED, "RomeoAndJuliet", "cadavaBerry");
        add(values, Type.QUEST_OBTAINED, "RovingElves", "keyHint pebbleHint");
        add(values, Type.PREP_REQUIRED, "RovingElves", "rope spade");
        add(values, Type.PREP_REQUIRED, "RoyalTrouble", "coal5 pickaxe");
        add(values, Type.PREP_REQUIRED, "RumDeal", "dibber rake slayerGloves");
        add(values, Type.QUEST_OBTAINED, "ScorpionCatcher", "dustyKey");
        add(values, Type.PREP_REQUIRED, "Scrambled", "bowlOfWater hammer saw sixNails twoPlanks");
        add(values, Type.PREP_REQUIRED, "SeaSlug", "swampPaste");
        add(values, Type.PREP_REQUIRED, "SecretsOfTheNorth", "coins lockpick tinderbox");
        add(values, Type.PREP_REQUIRED, "ShadesOfMortton", "ashes2 coins5000 hammerOrFlam log tarrominUnf2 tinderbox");
        add(values, Type.PREP_REQUIRED, "ShadowOfTheStorm", "darkItems silverBar silverlight");
        add(values, Type.PREP_REQUIRED, "ShadowsOfCustodia", "fishingRod fourMapleLogs fourWillowLongbows hammer");
        add(values, Type.PREP_REQUIRED, "SheepHerder", "coins100");
        add(values, Type.PREP_REQUIRED, "SheepShearer", "shears");
        add(values, Type.PREP_REQUIRED, "ShieldOfArravPhoenixGang", "twentyCoins");
        add(values, Type.PREP_REQUIRED, "ShiloVillage", "bones3 bronzeWire chisel rope spade torchOrCandle");
        add(values, Type.PREP_REQUIRED, "SinsOfTheFather", "axe chisel cosmicRune enchantTablet fireRune5 fireStaff ivandisFlail knife ruby vyrewatchOutfit.child1 vyrewatchOutfit.child2 vyrewatchOutfit.child3 vyrewatchOutfitOrCoins.child2");
        add(values, Type.PREP_REQUIRED, "SkippyAndTheMogres", "bucketOfMilk bucketOfWater chocolateDust nettleTea snapeGrass");
        add(values, Type.PREP_REQUIRED, "SleepingGiants", "chisel hammer nails oakLogs wool");
        add(values, Type.PREP_REQUIRED, "SongOfTheElves", "adamantChainbody axe blackKnifeOrBlackDagger cabbage cadantineSeed gasMask hammer iritLeafOrFlowers limestoneBricks8 mournerBoots mournerCloak mournerGloves mournerTop mournerTrousers natureRune pestleAndMortar pickaxe purpleDye redDye rope runiteBar saw seedDibber silk spade steelFullHelm steelPlatebody steelPlatelegs tinderbox vialOfWater wineOfZamorakOrZamorakBrew");
        add(values, Type.PREP_REQUIRED, "SpiritsOfTheElid", "airRune knife lawRune lightSource needle pickaxe rope thread");
        add(values, Type.QUEST_OBTAINED, "SpiritsOfTheElid", "arrows bow");
        add(values, Type.PREP_REQUIRED, "SwanSong", "blood5 ironBar5 lava10 log mist10 pot potLid tinderbox");
        add(values, Type.QUEST_OBTAINED, "SwanSong", "bones7 hammerPanel");
        add(values, Type.PREP_REQUIRED, "TaiBwoWannaiTrio", "agilityPotion4 coins hammer knife logsForFire pestleAndMortar rawKarambwan slicedBanana smallFishingNet spear tinderbox");
        add(values, Type.PREP_REQUIRED, "TaleOfTheRighteous", "pickaxe rope");
        add(values, Type.PREP_REQUIRED, "TearsOfGuthix", "chisel litSapphireLantern pickaxe rope tinderbox");
        add(values, Type.PREP_REQUIRED, "TempleOfIkov", "knife lightSource limpwurt20 throwableWeapon yewOrBetterBow");
        add(values, Type.PREP_REQUIRED, "TempleOfTheEye", "bucketOfWater chisel pickaxe");
        add(values, Type.PREP_REQUIRED, "TheBloodMoonRises", "blisterwoodFlail vyreNobleOutfit.child1 vyreNobleOutfit.child2 vyreNobleOutfit.child3");
        add(values, Type.PREP_REQUIRED, "TheCurseOfArrav", "anyGrappleableCrossbow anyPickaxe dwellberries3 insulatedBoots mithrilGrapple ringOfLife");
        add(values, Type.QUEST_OBTAINED, "TheDigSite", "charcoal");
        add(values, Type.PREP_REQUIRED, "TheDigSite", "opal pestleAndMortar ropes2 tea tinderbox vial");
        add(values, Type.PREP_REQUIRED, "TheEyesOfGlouphrie", "bucketOfSap hammer mapleLog mudRune oakLog pestleAndMortar saw");
        add(values, Type.PREP_REQUIRED, "TheFeud", "coins gloves");
        add(values, Type.PREP_REQUIRED, "TheFinalDawn", "bone");
        add(values, Type.PREP_REQUIRED, "TheFremennikExiles", "astralRunes coins650 fishingOrFlyFishingRod glassblowingPipe hammer iceGloves kegs2Or650Coins.child1 mirrorShield moltenGlass petRock pickaxe runeThrowingaxeOrFriend sealOfPassage");
        add(values, Type.QUEST_OBTAINED, "TheFremennikExiles", "fremennikShield kegsOfBeer");
        add(values, Type.PREP_REQUIRED, "TheFremennikIsles", "axe bronzeNail coal hammer knife mithrilOre needle rope9 thread tinOre tuna");
        add(values, Type.PREP_REQUIRED, "TheFremennikTrials", "axe coins knife rawShark tinderbox");
        add(values, Type.QUEST_OBTAINED, "TheGardenOfDeath", "secateurs");
        add(values, Type.PREP_REQUIRED, "TheGeneralsShadow", "coins40 ghostlyBody ghostlyBoots ghostlyCloak ghostlyGloves ghostlyHood ghostlyLegs ghostspeak ringOfVisibility");
        add(values, Type.PREP_REQUIRED, "TheGiantDwarf", "airRune coal coins2500 ironBar lawRune logs redberryPie sapphires3 tinderbox");
        add(values, Type.PREP_REQUIRED, "TheGolem", "clay4Highlight papyrus pestleAndMortar vial");
        add(values, Type.PREP_REQUIRED, "TheGrandTree", "oneThousandCoins");
        add(values, Type.PREP_REQUIRED, "TheGreatBrainRobbery", "catsOrResources.child1 catsOrResources.child2.child1 catsOrResources.child2.child2 divingApparatus fishbowlHelmet hammer holySymbol nails plank ringOfCharos");
        add(values, Type.QUEST_OBTAINED, "TheGreatBrainRobbery", "fur woodenCats");
        add(values, Type.PREP_REQUIRED, "TheHandInTheSand", "beerOr2Coins bucketOfSand coins earthRunes5 lanternLens redberries vial2 whiteberries");
        add(values, Type.PREP_REQUIRED, "TheHeartOfDarkness", "coins food prayerPotions");
        add(values, Type.PREP_REQUIRED, "TheKnightsSword", "ironBars pickaxe redberryPie");
        add(values, Type.PREP_REQUIRED, "TheLostTribe", "lightSource pickaxe");
        add(values, Type.PREP_REQUIRED, "TheMageArenaI", "knife");
        add(values, Type.PREP_REQUIRED, "TheMageArenaII", "guthixStaff knife saradominStaff zamorakStaff");
        add(values, Type.PREP_REQUIRED, "ThePathOfGlouphrie", "crossbow mithGrapple treeGnomeVillageDungeonKey");
        add(values, Type.PREP_REQUIRED, "TheQueenOfThieves", "stew");
        add(values, Type.PREP_REQUIRED, "TheRibbitingTaleOfALilyPadLabourDispute", "axe");
        add(values, Type.PREP_REQUIRED, "TheSlugMenace", "airTalisman chisel commorb earthTalisman essence5 fireTalisman mindTalisman swampPaste waterTalisman");
        add(values, Type.PREP_REQUIRED, "TheTouristTrap", "bronzeBar3 desertBoot desertBottom desertTop feather50 hammer");
        add(values, Type.PREP_REQUIRED, "ThroneOfMiscellania", "bow cake flowers ironBar logs reputationItems ring");
        add(values, Type.PREP_REQUIRED, "TowerOfLife", "beer hammer saw");
        add(values, Type.PREP_REQUIRED, "TreeGnomeVillage", "sixLogs");
        add(values, Type.PREP_REQUIRED, "TrollRomance", "bucketOfWax cakeTin climbingBoots ironBar mapleLog rope swampTar");
        add(values, Type.PREP_REQUIRED, "TrollStronghold", "climbingBoots coins12");
        add(values, Type.PREP_REQUIRED, "TroubledTortugans", "anyAxe hammer saw");
        add(values, Type.PREP_REQUIRED, "UndergroundPass", "arrows bow bucket plank rope2 spade tinderbox");
        add(values, Type.PREP_REQUIRED, "ValeTotems", "fourDecorativeItems knife oneOakLog");
        add(values, Type.PREP_REQUIRED, "VampyreSlayer", "beer hammer twoCoins");
        add(values, Type.PREP_REQUIRED, "VarrockBalloonFlight", "willowLogs");
        add(values, Type.PREP_REQUIRED, "Wanted", "enchantedGem lawRune lightSource moltenGlass pureEssence rope runeEssence tenThousandGp");
        add(values, Type.PREP_REQUIRED, "Watchtower", "batBones coins20 deathRune dragonBones goldBar guamUnf jangerberries lightSource pestleAndMortar pickaxe rope2");
        add(values, Type.PREP_REQUIRED, "WaterfallQuest", "airRunes earthRunes waterRunes");
        add(values, Type.PREP_REQUIRED, "WhatLiesBelow", "bowl chaosRunes15 chaosTalismanOrAbyss");
        add(values, Type.PREP_REQUIRED, "WhileGuthixSleeps", "air30 airRune astralRune bronzeMedHelm coins cosmic3 cosmicRune dibber earth30 fire30 food ironChainbody knife lanternLens litSapphireLantern logs unpoweredOrb water30");
        add(values, Type.PREP_REQUIRED, "WitchsHouse", "cheese leatherGloves");
        add(values, Type.PREP_REQUIRED, "WitchsPotion", "burntMeat eyeOfNewt onion");
        add(values, Type.PREP_REQUIRED, "XMarksTheSpot", "spade");

        return Collections.unmodifiableMap(values);
    }

    /** Each row lists variables sharing the same quest and classification. */
    private static void add(Map<String, Type> values, Type type, String quest, String variables)
    {
        for (String variable : variables.split(" ")) values.put(quest + ":" + variable, type);
    }

    public static Type get(String quest, String variable)
    {
        return TYPES.getOrDefault(
                quest + ":" + variable,
                Type.QUEST_OBTAINED
        );
    }

    public static boolean isPrepRequired(String quest, String variable)
    {
        return get(quest, variable) == Type.PREP_REQUIRED;
    }
}
