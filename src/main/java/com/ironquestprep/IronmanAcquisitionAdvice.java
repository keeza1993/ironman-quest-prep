package com.ironquestprep;

public final class IronmanAcquisitionAdvice
{
    private IronmanAcquisitionAdvice()
    {
    }

    public static String get(
            GeneratedQuestData.RawItem raw)
    {
        return getInfo(raw).getMethod();
    }

    public static AcquisitionInfo getInfo(
            GeneratedQuestData.RawItem raw)
    {
        String source =
                safe(raw.getItemSource());

        String name =
                safe(raw.getItemName());

        String extracted =
                GeneratedAcquisitionAdvice.get(
                        raw.getQuest()
                                + ":"
                                + raw.getVariable()
                );

        /*
         * Quest Helper tooltips frequently contain a better, quest-specific
         * Ironman source than our generic item rule.  For example, the
         * Fremennik Isles ore requirements explicitly point at the Jatizso
         * mine.  Prefer those hints when they identify a real place.
         */
        AcquisitionInfo questSpecific =
                getQuestSpecificInfo(
                        raw,
                        extracted
                );

        if (questSpecific != null
                && questSpecific.hasSpecificPlace())
        {
            return questSpecific;
        }

        AcquisitionInfo base =
                getExactInfo(source);

        if (base == null)
        {
            base =
                    getCollectionInfo(source);
        }

        if (base == null)
        {
            base =
                    getCategoryInfo(
                            source,
                            name
                    );
        }

        if (base == null)
        {
            base =
                    getCommonItemInfo(
                            source,
                            name
                    );
        }

        if (base == null
                && questSpecific != null)
        {
            base = questSpecific;
        }

        if (base == null)
        {
            base = fallbackInfo(name);
        }

        /*
         * Keep useful caveats from Quest Helper even when a stronger generic
         * acquisition route supplied the actual place.
         */
        if (extracted != null
                && !extracted.trim().isEmpty()
                && (questSpecific == null
                || !questSpecific.hasSpecificPlace()))
        {
            base =
                    base.withAdditionalNote(
                            extracted
                    );
        }

        return base;
    }

    private static AcquisitionInfo getExactInfo(
            String source)
    {
        switch (source)
        {
            case "ItemID.ROPE":
                return new AcquisitionInfo(
                        "Buy from Ned.",
                        AcquisitionRegion.MISTHALIN,
                        "Draynor Village",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.HAMMER":
                return new AcquisitionInfo(
                        "Buy from a general store or use a nearby hammer spawn.",
                        AcquisitionRegion.ANYWHERE,
                        "Any convenient general store",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.KNIFE":
                return new AcquisitionInfo(
                        "Pick up or buy a knife.",
                        AcquisitionRegion.MISTHALIN,
                        "Lumbridge",
                        AcquisitionInfo.MethodType.SPAWN
                );

            /*
             * =================================================
             * SOUTH FALADOR FARM
             * =================================================
             */

            case "ItemID.SPADE":
                return southFaladorFarmingShop(
                        "Buy a spade from Sarah's Farming shop."
                );

            case "ItemID.RAKE":
                return southFaladorFarmingShop(
                        "Buy a rake from Sarah's Farming shop."
                );

            case "ItemID.DIBBER":
                return southFaladorFarmingShop(
                        "Buy a seed dibber from Sarah's Farming shop."
                );

            case "ItemID.SECATEURS":
                return southFaladorFarmingShop(
                        "Buy secateurs from Sarah's Farming shop."
                );

            /*
             * =================================================
             * GENERAL TOOLS
             * =================================================
             */

            case "ItemID.TINDERBOX":
                return AcquisitionInfo.anywhere(
                        "Buy from a general store.",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.CHISEL":
                return AcquisitionInfo.anywhere(
                        "Buy from a general store or Crafting shop.",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.NEEDLE":
                return new AcquisitionInfo(
                        "Buy from a Crafting shop.",
                        AcquisitionRegion.ASGARNIA,
                        "Rimmington",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.THREAD":
                return new AcquisitionInfo(
                        "Buy from a Crafting shop.",
                        AcquisitionRegion.ASGARNIA,
                        "Rimmington",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.PESTLE_AND_MORTAR":
                return AcquisitionInfo.anywhere(
                        "Buy from an appropriate Herblore or general-purpose shop.",
                        AcquisitionInfo.MethodType.SHOP
                );

            /*
             * =================================================
             * BASIC GATHERING / PROCESSING
             * =================================================
             */

            case "ItemID.BUCKET_MILK":
                return new AcquisitionInfo(
                        "Use an empty bucket on a dairy cow.",
                        AcquisitionRegion.MISTHALIN,
                        "Lumbridge cow field",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.BUCKET_WATER":
                return AcquisitionInfo.anywhere(
                        "Fill an empty bucket at a water source.",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.VIAL_WATER":
                return AcquisitionInfo.anywhere(
                        "Fill an empty vial at a water source or buy water-filled vials.",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.POT_FLOUR":
                return new AcquisitionInfo(
                        "Take grain upstairs in the windmill, operate the hopper, then collect the flour downstairs with an empty pot.",
                        AcquisitionRegion.MISTHALIN,
                        "Lumbridge windmill",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.BALL_OF_WOOL":
                return new AcquisitionInfo(
                        "Shear a sheep and spin the wool on a spinning wheel.",
                        AcquisitionRegion.MISTHALIN,
                        "Lumbridge",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.BOW_STRING":
                return new AcquisitionInfo(
                        "Pick flax and spin it on a spinning wheel.",
                        AcquisitionRegion.KANDARIN,
                        "Seers' Village",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.LEATHER":
                return new AcquisitionInfo(
                        "Kill cows for cowhide, then have it tanned.",
                        AcquisitionRegion.MISTHALIN,
                        "Lumbridge / Al Kharid",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.HARD_LEATHER":
                return new AcquisitionInfo(
                        "Take cowhide to a tanner and choose hard leather.",
                        AcquisitionRegion.DESERT,
                        "Al Kharid",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.SOFTCLAY":
                return AcquisitionInfo.anywhere(
                        "Mine clay and use water on it.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.MOLTEN_GLASS":
                return AcquisitionInfo.anywhere(
                        "Smelt soda ash and a bucket of sand together.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            /*
             * =================================================
             * BARS
             * =================================================
             */

            case "ItemID.BRONZE_BAR":
                return AcquisitionInfo.anywhere(
                        "Smelt one copper ore and one tin ore.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.IRON_BAR":
                return AcquisitionInfo.anywhere(
                        "Smelt iron ore. A ring of forging guarantees successful smelting.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.STEEL_BAR":
                return AcquisitionInfo.anywhere(
                        "Smelt one iron ore with two coal.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.SILVER_BAR":
                return AcquisitionInfo.anywhere(
                        "Smelt silver ore in a furnace.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.GOLD_BAR":
                return AcquisitionInfo.anywhere(
                        "Smelt gold ore in a furnace.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            /*
             * =================================================
             * ORES
             * =================================================
             */

            case "ItemID.COPPER_ORE":
                return AcquisitionInfo.anywhere(
                        "Mine copper rocks.",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.TIN_ORE":
                return AcquisitionInfo.anywhere(
                        "Mine tin rocks.",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.IRON_ORE":
                return AcquisitionInfo.anywhere(
                        "Mine iron rocks.",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.COAL":
                return AcquisitionInfo.anywhere(
                        "Mine coal or use existing supplies from drops and skilling.",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.CLAY":
                return AcquisitionInfo.anywhere(
                        "Mine clay rocks.",
                        AcquisitionInfo.MethodType.GATHER
                );

            /*
             * =================================================
             * LOGS
             * =================================================
             */

            case "ItemID.LOGS":
                return AcquisitionInfo.anywhere(
                        "Chop any normal tree.",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.OAK_LOGS":
                return AcquisitionInfo.anywhere(
                        "Chop an oak tree.",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.WILLOW_LOGS":
                return AcquisitionInfo.anywhere(
                        "Chop a willow tree.",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.MAPLE_LOGS":
                return AcquisitionInfo.anywhere(
                        "Chop a maple tree.",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.YEW_LOGS":
                return AcquisitionInfo.anywhere(
                        "Chop a yew tree.",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.MAGIC_LOGS":
                return AcquisitionInfo.anywhere(
                        "Chop magic trees or use existing supplies from PvM/skilling.",
                        AcquisitionInfo.MethodType.GATHER
                );

            /*
             * =================================================
             * PLANKS
             * =================================================
             */

            case "ItemID.WOODPLANK":
                return new AcquisitionInfo(
                        "Take normal logs to a sawmill and convert them into planks.",
                        AcquisitionRegion.ASGARNIA,
                        "Taverley sawmill",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.PLANK_OAK":
                return new AcquisitionInfo(
                        "Take oak logs to a sawmill and convert them into oak planks.",
                        AcquisitionRegion.ASGARNIA,
                        "Taverley sawmill",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.PLANK_MAHOGANY":
                return new AcquisitionInfo(
                        "Take mahogany logs to a sawmill and convert them into mahogany planks.",
                        AcquisitionRegion.ASGARNIA,
                        "Taverley sawmill",
                        AcquisitionInfo.MethodType.CRAFT
                );

            /*
             * =================================================
             * DYES
             * =================================================
             */

            case "ItemID.REDDYE":
                return new AcquisitionInfo(
                        "Take the required red-dye ingredients and coins to Aggie.",
                        AcquisitionRegion.MISTHALIN,
                        "Draynor Village",
                        AcquisitionInfo.MethodType.NPC
                );

            case "ItemID.BLUEDYE":
                return new AcquisitionInfo(
                        "Take the required blue-dye ingredients and coins to Aggie.",
                        AcquisitionRegion.MISTHALIN,
                        "Draynor Village",
                        AcquisitionInfo.MethodType.NPC
                );

            case "ItemID.YELLOWDYE":
                return new AcquisitionInfo(
                        "Take the required yellow-dye ingredients and coins to Aggie.",
                        AcquisitionRegion.MISTHALIN,
                        "Draynor Village",
                        AcquisitionInfo.MethodType.NPC
                );

            case "ItemID.ORANGEDYE":
                return new AcquisitionInfo(
                        "Make red and yellow dye through Aggie, then combine them.",
                        AcquisitionRegion.MISTHALIN,
                        "Draynor Village",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.PURPLEDYE":
                return new AcquisitionInfo(
                        "Make red and blue dye through Aggie, then combine them.",
                        AcquisitionRegion.MISTHALIN,
                        "Draynor Village",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.COINS":
                return AcquisitionInfo.anywhere(
                        "Use coins already accumulated through normal Ironman progression.",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            default:
                return null;
        }
    }

    /*
     * =====================================================
     * ITEM COLLECTIONS
     * =====================================================
     */

    private static AcquisitionInfo getCollectionInfo(
            String source)
    {
        switch (source)
        {
            case "ItemCollections.AXES":
                return new AcquisitionInfo(
                        "Use any accepted axe. Buy one from Bob if you still need one.",
                        AcquisitionRegion.MISTHALIN,
                        "Bob's Axes, Lumbridge",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemCollections.PICKAXES":
                return new AcquisitionInfo(
                        "Use any accepted pickaxe. Buy one from Nurmof if needed.",
                        AcquisitionRegion.ASGARNIA,
                        "Dwarven Mine",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemCollections.HAMMER":
                return AcquisitionInfo.anywhere(
                        "Use any accepted hammer.",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.CHISEL":
                return AcquisitionInfo.anywhere(
                        "Use any accepted chisel.",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.SAW":
                return AcquisitionInfo.anywhere(
                        "Use any accepted saw.",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.MACHETE":
                return new AcquisitionInfo(
                        "Obtain any accepted machete before travelling into jungle areas.",
                        AcquisitionRegion.KARAMJA,
                        "Tai Bwo Wannai area",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.COINS":
                return AcquisitionInfo.anywhere(
                        "Use coins already accumulated through normal Ironman progression.",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.NAILS":
                return AcquisitionInfo.anywhere(
                        "Smith suitable nails from bars at an anvil.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemCollections.LIGHT_SOURCES":
                return AcquisitionInfo.anywhere(
                        "Use any accepted light source. Prefer a reusable lantern when available.",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.WATERING_CANS":
                return southFaladorFarmingShop(
                        "Buy a watering can from Sarah's Farming shop and fill it."
                );

            case "ItemCollections.GHOSTSPEAK":
                return new AcquisitionInfo(
                        "Use a ghostspeak amulet or another accepted ghostspeak item. Father Urhney replaces the amulet if needed.",
                        AcquisitionRegion.MISTHALIN,
                        "Father Urhney, Lumbridge Swamp",
                        AcquisitionInfo.MethodType.NPC
                );

            case "ItemCollections.CLIMBING_BOOTS":
                return new AcquisitionInfo(
                        "Buy climbing boots from Tenzing if you do not already have an accepted pair.",
                        AcquisitionRegion.ASGARNIA,
                        "Tenzing's house, Burthorpe",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemCollections.GOOD_EATING_FOOD":
            case "ItemCollections.FISH_FOOD":
                return new AcquisitionInfo(
                        "Use suitable food already banked, cook it, fish it, or buy food from an accessible food shop.",
                        AcquisitionRegion.ANYWHERE,
                        "Multiple possible food sources",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.BOWS":
                return new AcquisitionInfo(
                        "Use any accepted bow. Fletch one or obtain one from an appropriate ranged-weapon shop.",
                        AcquisitionRegion.ANYWHERE,
                        "Fletching or ranged-weapon shops",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.CROSSBOWS":
                return new AcquisitionInfo(
                        "Use any accepted crossbow. Make one with Fletching/Smithing or obtain one from an appropriate shop or drop.",
                        AcquisitionRegion.ANYWHERE,
                        "Fletching, Smithing, shops or drops",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.METAL_ARROWS":
                return new AcquisitionInfo(
                        "Use accepted unpoisoned metal arrows. Fletch them or buy suitable arrows from a ranged shop.",
                        AcquisitionRegion.ANYWHERE,
                        "Fletching or ranged shops",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.ANTIFIRE_SHIELDS":
                return new AcquisitionInfo(
                        "Use an accepted anti-dragon shield. Duke Horacio supplies the basic shield after Dragon Slayer starts.",
                        AcquisitionRegion.MISTHALIN,
                        "Duke Horacio, Lumbridge Castle",
                        AcquisitionInfo.MethodType.NPC
                );

            case "ItemCollections.ROD_OF_IVANDIS":
                return new AcquisitionInfo(
                        "Use an accepted Rod of Ivandis / flail variant. Replace quest versions through the Myreque where available.",
                        AcquisitionRegion.MORYTANIA,
                        "Myreque Hideout",
                        AcquisitionInfo.MethodType.NPC
                );

            case "ItemCollections.TREE_SAPLINGS":
                return new AcquisitionInfo(
                        "Grow an accepted tree sapling from a seed in a filled plant pot.",
                        AcquisitionRegion.ANYWHERE,
                        "Farming supplies and a suitable patch",
                        AcquisitionInfo.MethodType.SKILLING
                );

            case "ItemCollections.ALLOTMENT_SEEDS":
                return new AcquisitionInfo(
                        "Use any accepted allotment seed from Farming, seed shops, pickpocketing or monster drops.",
                        AcquisitionRegion.ANYWHERE,
                        "Multiple seed sources",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.SLAYER_HELMETS":
                return new AcquisitionInfo(
                        "Use any accepted Slayer helmet variant you already own.",
                        AcquisitionRegion.ANYWHERE,
                        "Slayer equipment",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.ANTIPOISONS":
                return new AcquisitionInfo(
                        "Use any accepted antipoison. Make one with Herblore or use an existing potion.",
                        AcquisitionRegion.ANYWHERE,
                        "Herblore or existing supplies",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemCollections.FAIRY_STAFF":
                return new AcquisitionInfo(
                        "Use an accepted dramen or lunar staff. Replace a dramen staff from Entrana if needed.",
                        AcquisitionRegion.ASGARNIA,
                        "Entrana",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.AIR_STAFF":
                return new AcquisitionInfo(
                        "Use any accepted air staff. Buy a basic staff from an accessible magic shop or use one already banked.",
                        AcquisitionRegion.ANYWHERE,
                        "Magic weapon shops or existing supplies",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.FIRE_STAFF":
                return new AcquisitionInfo(
                        "Use any accepted fire staff. Buy a basic staff from an accessible magic shop or use one already banked.",
                        AcquisitionRegion.ANYWHERE,
                        "Magic weapon shops or existing supplies",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.SWORDS":
                return new AcquisitionInfo(
                        "Use any accepted sword. Smith one or buy an appropriate sword from an equipment shop.",
                        AcquisitionRegion.ANYWHERE,
                        "Smithing or equipment shops",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.QUICKLIME_GLOVES":
                return new AcquisitionInfo(
                        "Use any gloves accepted for handling quicklime.",
                        AcquisitionRegion.ANYWHERE,
                        "Existing suitable gloves",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.RESTORE_POTIONS":
                return new AcquisitionInfo(
                        "Use any accepted restore potion. Make one with Herblore or use existing supplies.",
                        AcquisitionRegion.ANYWHERE,
                        "Herblore or existing supplies",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemCollections.THROWING_KNIVES":
                return new AcquisitionInfo(
                        "Use accepted throwing knives. Smith them where possible or obtain them from shops/drops.",
                        AcquisitionRegion.ANYWHERE,
                        "Smithing, shops or drops",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.PRAYER_POTIONS":
                return new AcquisitionInfo(
                        "Use an accepted prayer-restoring potion. Make one with Herblore or use existing supplies.",
                        AcquisitionRegion.ANYWHERE,
                        "Herblore or existing supplies",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemCollections.FLOWERS":
                return new AcquisitionInfo(
                        "Use accepted flowers. Pick/buy an appropriate flower for the requirement.",
                        AcquisitionRegion.ANYWHERE,
                        "Flower patches, shops or spawns",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.LOGS_FOR_FIRE":
                return AcquisitionInfo.anywhere(
                        "Chop or use any accepted logs suitable for the fire requirement.",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemCollections.SLASH_WEB_KNIFE":
                return new AcquisitionInfo(
                        "Use a knife or another accepted slash weapon for cutting webs.",
                        AcquisitionRegion.MISTHALIN,
                        "Lumbridge / existing slash weapon",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemCollections.AIR_ALTAR":
                return altarAccessInfo("Air");

            case "ItemCollections.EARTH_ALTAR":
                return altarAccessInfo("Earth");

            case "ItemCollections.FIRE_ALTAR":
                return altarAccessInfo("Fire");

            case "ItemCollections.WATER_ALTAR":
                return altarAccessInfo("Water");

            case "ItemCollections.MIND_ALTAR":
                return altarAccessInfo("Mind");

            case "ItemCollections.DEATH_ALTAR":
                return altarAccessInfo("Death");

            case "ItemCollections.CHAOS_ALTAR":
                return altarAccessInfo("Chaos");

            default:
                return null;
        }
    }

    /*
     * =====================================================
     * GENERIC CATEGORIES
     * =====================================================
     */

    private static AcquisitionInfo getCategoryInfo(
            String source,
            String name)
    {
        String lower =
                name.toLowerCase();

        if (lower.contains("rune"))
        {
            return AcquisitionInfo.anywhere(
                    "Use existing runes, Runecraft them, or buy them from an appropriate rune shop.",
                    AcquisitionInfo.MethodType.MULTIPLE
            );
        }

        if (lower.contains("ore"))
        {
            return AcquisitionInfo.anywhere(
                    "Mine the required ore or use existing supplies.",
                    AcquisitionInfo.MethodType.GATHER
            );
        }

        if (lower.contains("bar"))
        {
            return AcquisitionInfo.anywhere(
                    "Smelt the appropriate ores or use existing bars.",
                    AcquisitionInfo.MethodType.CRAFT
            );
        }

        if (lower.contains("logs")
                || lower.endsWith(" log"))
        {
            return AcquisitionInfo.anywhere(
                    "Chop the appropriate tree or use logs already banked.",
                    AcquisitionInfo.MethodType.GATHER
            );
        }

        if (lower.contains("plank"))
        {
            return new AcquisitionInfo(
                    "Convert the appropriate logs at a sawmill.",
                    AcquisitionRegion.ASGARNIA,
                    "Taverley sawmill",
                    AcquisitionInfo.MethodType.CRAFT
            );
        }

        if (lower.contains("seed"))
        {
            return AcquisitionInfo.anywhere(
                    "Use existing seeds or obtain them through Farming, pickpocketing, drops, contracts or shops.",
                    AcquisitionInfo.MethodType.MULTIPLE
            );
        }

        if (lower.contains("dye"))
        {
            return new AcquisitionInfo(
                    "Make the required basic dye through Aggie where applicable.",
                    AcquisitionRegion.MISTHALIN,
                    "Draynor Village",
                    AcquisitionInfo.MethodType.NPC
            );
        }

        if (lower.contains("potion"))
        {
            return AcquisitionInfo.anywhere(
                    "Make the required potion with Herblore or use one already banked.",
                    AcquisitionInfo.MethodType.CRAFT
            );
        }

        if (lower.contains("bones"))
        {
            return AcquisitionInfo.anywhere(
                    "Kill a creature that drops the required bones or use existing banked bones.",
                    AcquisitionInfo.MethodType.DROP
            );
        }

        return null;
    }

    /*
     * =====================================================
     * QUEST-SPECIFIC TOOLTIP ROUTES
     * =====================================================
     */

    private static AcquisitionInfo getQuestSpecificInfo(
            GeneratedQuestData.RawItem raw,
            String extracted)
    {
        if (extracted == null
                || extracted.trim().isEmpty())
        {
            return null;
        }

        String lower =
                extracted.trim().toLowerCase();

        if (!looksLikeAcquisitionAdvice(lower))
        {
            return null;
        }

        String itemName =
                safe(raw.getItemName())
                        .toLowerCase();

        /*
         * The same Quest Helper wording is used for both animals at the farm
         * north of Lumbridge.  Use the item to choose the correct logical
         * place rather than allowing a text-only matcher to guess.
         */
        if (lower.contains("farm north of lumbridge"))
        {
            if (itemName.contains("chicken")
                    || itemName.equals("egg"))
            {
                return new AcquisitionInfo(
                        extracted,
                        AcquisitionRegion.MISTHALIN,
                        "Lumbridge chicken farm",
                        AcquisitionInfo.MethodType.GATHER
                );
            }

            if (itemName.contains("beef")
                    || itemName.contains("cowhide")
                    || itemName.contains("milk"))
            {
                return new AcquisitionInfo(
                        extracted,
                        AcquisitionRegion.MISTHALIN,
                        "Lumbridge cow field",
                        AcquisitionInfo.MethodType.GATHER
                );
            }
        }

        AcquisitionPlace place =
                AcquisitionPlaceDatabase.inferFromText(
                        extracted
                );

        AcquisitionInfo.MethodType methodType =
                AcquisitionInfo.inferMethodType(
                        extracted
                );

        if (place != null)
        {
            return new AcquisitionInfo(
                    extracted,
                    place.getRegion(),
                    place.getDisplayName(),
                    methodType,
                    place
            );
        }

        if (containsAny(
                lower,
                "during the quest",
                "during quest",
                "obtainable during quest",
                "obtainable during the quest",
                "purchasable during the quest"))
        {
            return new AcquisitionInfo(
                    extracted,
                    AcquisitionRegion.ANYWHERE,
                    "During the quest",
                    methodType
            );
        }

        if (methodType == AcquisitionInfo.MethodType.CRAFT
                || methodType == AcquisitionInfo.MethodType.GATHER
                || methodType == AcquisitionInfo.MethodType.DROP)
        {
            return AcquisitionInfo.anywhere(
                    extracted,
                    methodType
            );
        }

        return null;
    }

    private static boolean looksLikeAcquisitionAdvice(
            String lower)
    {
        return containsAny(
                lower,
                "buy ",
                "bought ",
                "purchasable",
                "purchased",
                "get another",
                "get one",
                "get some",
                "can get",
                "can find",
                "can pick",
                "can mine",
                "can kill",
                "obtain",
                "mine ",
                "mined ",
                "kill ",
                "pick ",
                "pick up",
                "fish ",
                "chop ",
                "make ",
                "made ",
                "cook ",
                "grind ",
                "search ",
                "spawn",
                "from the ",
                "from father ",
                "from rasolo",
                "from askeladden"
        );
    }

    /*
     * =====================================================
     * COMMON IRONMAN SOURCES
     * =====================================================
     *
     * These rules cover normal quest-supply items that do not have a special
     * Quest Helper tooltip.  The aim is complete structured data first: every
     * prep item gets a method and a logical place, while genuinely multi-source
     * items stay marked as such instead of pretending one route is universally
     * optimal.
     */

    private static AcquisitionInfo getCommonItemInfo(
            String source,
            String name)
    {
        switch (source)
        {
            case "ItemID.POT_EMPTY":
            case "ItemID.BUCKET_EMPTY":
            case "ItemID.BOWL_EMPTY":
            case "ItemID.JUG_EMPTY":
                return new AcquisitionInfo(
                        "Buy the empty container from a general store if you do not already have one.",
                        AcquisitionRegion.MISTHALIN,
                        "Lumbridge General Store",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.VIAL_EMPTY":
                return new AcquisitionInfo(
                        "Buy vials from an accessible Herblore shop or use vials already banked.",
                        AcquisitionRegion.ASGARNIA,
                        "Taverley",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.FEATHER":
            case "ItemID.FISHING_ROD":
            case "ItemID.FISHING_BAIT":
            case "ItemID.NET":
            case "ItemID.LOBSTER_POT":
                return new AcquisitionInfo(
                        "Buy the fishing supply from Gerrant if you do not already have it.",
                        AcquisitionRegion.ASGARNIA,
                        "Gerrant's Fishy Business, Port Sarim",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.SILK":
                return new AcquisitionInfo(
                        "Obtain silk from the silk stall/trader in Ardougne or use existing silk.",
                        AcquisitionRegion.KANDARIN,
                        "Ardougne market",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.BANANA":
                return new AcquisitionInfo(
                        "Pick bananas from the plantation on Karamja.",
                        AcquisitionRegion.KARAMJA,
                        "Karamja banana plantation",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.DRAMEN_STAFF":
                return new AcquisitionInfo(
                        "Cut another dramen branch on Entrana and craft it into a dramen staff.",
                        AcquisitionRegion.ASGARNIA,
                        "Entrana",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.ECTOTOKEN":
                return new AcquisitionInfo(
                        "Earn Ecto-tokens by worshipping at the Ectofuntus.",
                        AcquisitionRegion.MORYTANIA,
                        "Ectofuntus",
                        AcquisitionInfo.MethodType.SKILLING
                );

            case "ItemID.FD_RING_VISIBILITY":
                return new AcquisitionInfo(
                        "Get a replacement ring of visibility from Rasolo when available.",
                        AcquisitionRegion.KANDARIN,
                        "Rasolo, south-east of Baxtorian Falls",
                        AcquisitionInfo.MethodType.NPC
                );

            case "ItemID.LUNAR_SEAL_OF_PASSAGE":
                return new AcquisitionInfo(
                        "Get or replace the seal of passage through Brundt after the relevant Lunar quest progress.",
                        AcquisitionRegion.FREMENNIK,
                        "Rellekka",
                        AcquisitionInfo.MethodType.NPC
                );

            case "ItemID.AMULET_OF_GHOSTSPEAK":
                return new AcquisitionInfo(
                        "Get a replacement ghostspeak amulet from Father Urhney.",
                        AcquisitionRegion.MISTHALIN,
                        "Father Urhney, Lumbridge Swamp",
                        AcquisitionInfo.MethodType.NPC
                );

            case "ItemID.BLESSEDSTAR":
                return new AcquisitionInfo(
                        "Craft or obtain a holy symbol; use an existing one if already owned.",
                        AcquisitionRegion.ANYWHERE,
                        "Crafting or existing supplies",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.SWAMP_TAR":
                return new AcquisitionInfo(
                        "Pick up swamp tar from a swamp tar spawn.",
                        AcquisitionRegion.MISTHALIN,
                        "Lumbridge Swamp",
                        AcquisitionInfo.MethodType.SPAWN
                );

            case "ItemID.ASHES":
                return AcquisitionInfo.anywhere(
                        "Burn normal logs and collect the ashes, or use ashes already banked.",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.BRONZECRAFTWIRE":
                return AcquisitionInfo.anywhere(
                        "Smith bronze wire from a bronze bar at an anvil.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.SHEARS":
                return new AcquisitionInfo(
                        "Pick up or buy shears near Lumbridge before shearing sheep.",
                        AcquisitionRegion.MISTHALIN,
                        "Lumbridge",
                        AcquisitionInfo.MethodType.SPAWN
                );

            case "ItemID.CAKE_TIN":
                return new AcquisitionInfo(
                        "Buy a cake tin from a cooking/general store if you do not have one.",
                        AcquisitionRegion.MISTHALIN,
                        "Lumbridge / Cooks' Guild",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.CLOTH":
                return new AcquisitionInfo(
                        "Buy bolts of cloth from a Construction supply source.",
                        AcquisitionRegion.ASGARNIA,
                        "Taverley sawmill area",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.GLASSBLOWINGPIPE":
                return new AcquisitionInfo(
                        "Obtain a glassblowing pipe from a Crafting supply source.",
                        AcquisitionRegion.ASGARNIA,
                        "Rimmington / Crafting supplies",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.GASMASK":
                return new AcquisitionInfo(
                        "Use the gas mask obtained through Plague City; replace it through the quest area if needed.",
                        AcquisitionRegion.KANDARIN,
                        "Ardougne",
                        AcquisitionInfo.MethodType.NPC
                );

            case "ItemID.ICE_GLOVES":
                return new AcquisitionInfo(
                        "Kill the Ice Queen for another pair of ice gloves if needed.",
                        AcquisitionRegion.FREMENNIK,
                        "White Wolf Mountain",
                        AcquisitionInfo.MethodType.DROP
                );

            case "ItemID.LOCKPICK":
                return new AcquisitionInfo(
                        "Obtain several lockpicks from thieving sources or an accessible shop/drop.",
                        AcquisitionRegion.ANYWHERE,
                        "Thieving, shops or monster drops",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.PAPYRUS":
                return new AcquisitionInfo(
                        "Buy papyrus from an accessible desert/general supply source.",
                        AcquisitionRegion.DESERT,
                        "Desert supply shops",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.BEER":
                return new AcquisitionInfo(
                        "Buy a beer from a pub or brewery shop.",
                        AcquisitionRegion.ANYWHERE,
                        "Any convenient pub or brewery shop",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.NAILS":
            case "ItemID.NAILS_BRONZE":
                return AcquisitionInfo.anywhere(
                        "Smith the required nails from suitable metal bars at an anvil, or use nails already banked.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.SWAMPPASTE":
                return new AcquisitionInfo(
                        "Buy swamp paste from the Khazard General Store. You can also make it from swamp tar and flour on a fire.",
                        AcquisitionRegion.KANDARIN,
                        "Port Khazard",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.RAW_CHICKEN":
            case "ItemID.EGG":
                return new AcquisitionInfo(
                        "Get this from the chickens at the farm north-east of Lumbridge.",
                        AcquisitionRegion.MISTHALIN,
                        "Lumbridge chicken farm",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.BRONZE_AXE":
                return new AcquisitionInfo(
                        "Buy a bronze axe from Bob if you do not already have an accepted axe.",
                        AcquisitionRegion.MISTHALIN,
                        "Bob's Axes, Lumbridge",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.BRONZE_PICKAXE":
                return new AcquisitionInfo(
                        "Buy a bronze pickaxe from Nurmof if you do not already have an accepted pickaxe.",
                        AcquisitionRegion.ASGARNIA,
                        "Dwarven Mine",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.BUCKET_WAX":
                return new AcquisitionInfo(
                        "Use insect repellent on a beehive, then use an empty bucket on it to collect wax.",
                        AcquisitionRegion.KANDARIN,
                        "Catherby beehives",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.BULLSEYE_LANTERN_LENS":
            case "ItemID.STAFFORB":
            case "ItemID.POTLID":
                return AcquisitionInfo.anywhere(
                        "Make this with the relevant Crafting materials, or use one already banked.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.CHARCOAL":
                return new AcquisitionInfo(
                        "Buy charcoal from a suitable Karamja shop, or use charcoal already banked.",
                        AcquisitionRegion.KARAMJA,
                        "Tai Bwo Wannai / Shilo Village",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.CHOCOLATE_DUST":
                return AcquisitionInfo.anywhere(
                        "Use a pestle and mortar on a chocolate bar.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.DESERT_ROBE":
            case "ItemID.DESERT_SHIRT":
                return new AcquisitionInfo(
                        "Buy the desert clothing from Shantay's shop before entering the desert.",
                        AcquisitionRegion.DESERT,
                        "Shantay Pass",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.EMPTY_OGRE_BELLOWS":
            case "ItemID.OGRE_ARROW":
            case "ItemID.RAW_CHOMPY":
                return new AcquisitionInfo(
                        "Obtain this while preparing for ogre/chompy content around Rantz's area.",
                        AcquisitionRegion.KANDARIN,
                        "Feldip Hills / Rantz",
                        AcquisitionInfo.MethodType.QUEST
                );

            case "ItemID.FUR":
                return new AcquisitionInfo(
                        "Kill a bear for bear fur, or use another accepted fur source if the quest allows it.",
                        AcquisitionRegion.ANYWHERE,
                        "Bear spawns or other accepted fur sources",
                        AcquisitionInfo.MethodType.DROP
                );

            case "ItemID.GOBLIN_ARMOUR":
                return new AcquisitionInfo(
                        "Kill goblins until you get goblin mail.",
                        AcquisitionRegion.ASGARNIA,
                        "Goblin Village",
                        AcquisitionInfo.MethodType.DROP
                );

            case "ItemID.MOURNING_MOURNER_CLOAK":
            case "ItemID.MOURNING_MOURNER_LEGS":
            case "ItemID.MOURNING_MOURNER_TOP":
                return new AcquisitionInfo(
                        "Obtain or replace the Mourner gear through the Mourner/Arandar quest area.",
                        AcquisitionRegion.KANDARIN,
                        "Mourner / Arandar area",
                        AcquisitionInfo.MethodType.QUEST
                );

            case "ItemID.SNAPE_GRASS":
                return new AcquisitionInfo(
                        "Pick snape grass from a ground spawn or grow it through Farming.",
                        AcquisitionRegion.ASGARNIA,
                        "Hobgoblin Peninsula west of the Crafting Guild",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.UNLIT_CANDLE":
                return new AcquisitionInfo(
                        "Buy an unlit candle from the Catherby candlemaker if needed.",
                        AcquisitionRegion.KANDARIN,
                        "Catherby",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.VODKA":
                return new AcquisitionInfo(
                        "Buy vodka from an accessible alcohol shop or pub that stocks it.",
                        AcquisitionRegion.ANYWHERE,
                        "Alcohol shops / pubs",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.XBOWS_GRAPPLE_TIP_BOLT_MITHRIL_ROPE":
                return AcquisitionInfo.anywhere(
                        "Make a mith grapple by combining a mith grapple tip with a mithril bolt, then attach rope.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "KeyringCollection.DUSTY_KEY":
                return new AcquisitionInfo(
                        "Get the dusty key from Velrak if you need the key route into deep Taverley Dungeon.",
                        AcquisitionRegion.ASGARNIA,
                        "Taverley Dungeon",
                        AcquisitionInfo.MethodType.NPC
                );

            case "ItemID.ANMA_P_BUTTONS":
                return new AcquisitionInfo(
                        "Pickpocket H.A.M. members for buttons, then polish the buttons.",
                        AcquisitionRegion.MISTHALIN,
                        "H.A.M. Hideout",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.ARCLIGHT":
                return new AcquisitionInfo(
                        "Bring any silver weapon accepted by the quest (for example Silverlight or a valid upgraded variant), a blessed axe, or Efaritay's aid if that alternative is available.",
                        AcquisitionRegion.MORYTANIA,
                        "Myreque / Morytania quest route",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.BASS":
            case "ItemID.SHRIMP":
                return AcquisitionInfo.anywhere(
                        "Catch the required fish at an appropriate fishing spot, cook it if required, or use one already banked.",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.BEER_GLASS":
            case "ItemID.CUP_EMPTY":
                return AcquisitionInfo.anywhere(
                        "Buy or pick up the empty container from an appropriate food/drink source.",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.BLACK_BEAD":
            case "ItemID.RED_BEAD":
            case "ItemID.WHITE_BEAD":
            case "ItemID.YELLOW_BEAD":
                return AcquisitionInfo.anywhere(
                        "Kill imps until the required bead drops, or use one already banked.",
                        AcquisitionInfo.MethodType.DROP
                );

            case "ItemID.BLANKRUNE_HIGH":
                return new AcquisitionInfo(
                        "Mine pure essence through an essence-mine teleport, or use existing pure essence.",
                        AcquisitionRegion.MISTHALIN,
                        "Varrock essence mine access",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.BONES":
                return AcquisitionInfo.anywhere(
                        "Kill a nearby creature for any accepted bones or raw meat.",
                        AcquisitionInfo.MethodType.DROP
                );

            case "ItemID.BRAIN_INV_WOODEN_CAT":
                return new AcquisitionInfo(
                        "Obtain the wooden cat through the Great Brain Robbery quest route.",
                        AcquisitionRegion.MORYTANIA,
                        "Harmony / quest route",
                        AcquisitionInfo.MethodType.QUEST
                );

            case "ItemID.BRUT_ROE":
                return new AcquisitionInfo(
                        "Use Barbarian Fishing to obtain roe while training with Otto.",
                        AcquisitionRegion.KANDARIN,
                        "Otto's Grotto",
                        AcquisitionInfo.MethodType.SKILLING
                );

            case "ItemID.BUCKET_COMPOST":
            case "ItemID.BUCKET_SUPERCOMPOST":
            case "ItemID.PLANTPOT_COMPOST":
            case "ItemID.PLANT_CURE":
            case "ItemID.GARDENING_TROWEL":
                return new AcquisitionInfo(
                        "Buy or make the required Farming supply before travelling to the quest step.",
                        AcquisitionRegion.ASGARNIA,
                        "Sarah's Farming shop, south of Falador",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.BUCKET_ECTOPLASM":
                return new AcquisitionInfo(
                        "Collect slime from the Ectofuntus dungeon with an empty bucket.",
                        AcquisitionRegion.MORYTANIA,
                        "Ectofuntus",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.BUCKET_SAND":
                return AcquisitionInfo.anywhere(
                        "Fill an empty bucket at a sand pit, or use bucket of sand already banked.",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.BULLSEYE_LANTERN_UNLIT":
                return AcquisitionInfo.anywhere(
                        "Make an unlit bullseye lantern through Smithing/Crafting or use one already banked.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.BURNT_MEAT":
                return AcquisitionInfo.anywhere(
                        "Cook meat until it burns. If your Cooking level prevents burning it normally, use a quest-appropriate method or existing burnt meat.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.COOKED_MEAT":
                return AcquisitionInfo.anywhere(
                        "Kill an animal for raw meat and cook it, or use cooked meat already banked.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.CUP_OF_TEA":
                return new AcquisitionInfo(
                        "Obtain a cup of tea from a tea source around Varrock/Digsite, or make one if available.",
                        AcquisitionRegion.MISTHALIN,
                        "Varrock / Digsite area",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.DOOGLELEAVES":
                return new AcquisitionInfo(
                        "Pick doogle leaves from the patch near Gertrude's house.",
                        AcquisitionRegion.MISTHALIN,
                        "Doogle leaf patch near Gertrude's house",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.DRAGONSTONE":
                return AcquisitionInfo.anywhere(
                        "Use a dragonstone from a crystal chest, monster drop, impling, or existing supplies.",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.DRUID_POUCH":
                return new AcquisitionInfo(
                        "Fill a druid pouch with Mort Myre fungi/branches/pears in Mort Myre Swamp.",
                        AcquisitionRegion.MORYTANIA,
                        "Mort Myre Swamp",
                        AcquisitionInfo.MethodType.QUEST
                );

            case "ItemID.ENAKH_GRANITE_MEDIUM":
            case "ItemID.ENAKH_GRANITE_SMALL":
                return new AcquisitionInfo(
                        "Mine the required granite at the desert quarry.",
                        AcquisitionRegion.DESERT,
                        "Desert Quarry",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.EQUA_LEAVES":
            case "ItemID.FRUIT_BLAST":
            case "ItemID.GREENMANS_ALE":
            case "ItemID.SPICESPOT":
            case "ItemID.TOAD_CRUNCHIES":
                return new AcquisitionInfo(
                        "Obtain this from gnome food/drink supplies or make it through Gnome Cooking as appropriate.",
                        AcquisitionRegion.KANDARIN,
                        "Tree Gnome Stronghold / Grand Tree",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.EXCALIBUR":
                return new AcquisitionInfo(
                        "Get Excalibur from the Lady of the Lake as part of the Merlin's Crystal quest line.",
                        AcquisitionRegion.ASGARNIA,
                        "Taverley",
                        AcquisitionInfo.MethodType.NPC
                );

            case "ItemID.EYE_OF_NEWT":
                return new AcquisitionInfo(
                        "Buy an eye of newt from Betty's Magic Emporium.",
                        AcquisitionRegion.ASGARNIA,
                        "Port Sarim",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.FAIRY_SKULL":
                return new AcquisitionInfo(
                        "Retrieve the Draynor skull from the grave associated with the Fairytale quest step.",
                        AcquisitionRegion.MISTHALIN,
                        "Draynor Village / Draynor Manor area",
                        AcquisitionInfo.MethodType.QUEST
                );

            case "ItemID.FEUD_CAMEL_POOH_BUCKET":
                return new AcquisitionInfo(
                        "Collect Ugthanki dung using the desert quest method.",
                        AcquisitionRegion.DESERT,
                        "Pollnivneach / desert area",
                        AcquisitionInfo.MethodType.QUEST
                );

            case "ItemID.FISHING_EXPLOSIVE":
            case "ItemID.SLAYER_BAG_OF_SALT":
            case "ItemID.SLAYER_GEM":
            case "ItemID.SLAYER_ICY_WATER":
                return new AcquisitionInfo(
                        "Buy the Slayer supply from a Slayer Master or Slayer equipment shop.",
                        AcquisitionRegion.ASGARNIA,
                        "Burthorpe Slayer Master",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.GOLRIE_KEY_WATERFALL_QUEST":
                return new AcquisitionInfo(
                        "Obtain the dungeon key from the Tree Gnome Village dungeon quest route.",
                        AcquisitionRegion.KANDARIN,
                        "Tree Gnome Village / dungeon",
                        AcquisitionInfo.MethodType.QUEST
                );

            case "ItemID.GLARIALS_PEBBLE_WATERFALL_QUEST":
                return new AcquisitionInfo(
                        "Obtain Glarial's pebble from Golrie during the Waterfall Quest route.",
                        AcquisitionRegion.KANDARIN,
                        "Tree Gnome Village dungeon",
                        AcquisitionInfo.MethodType.QUEST
                );

            case "ItemID.GRAIN":
                return new AcquisitionInfo(
                        "Pick grain from a wheat field.",
                        AcquisitionRegion.MISTHALIN,
                        "Lumbridge wheat field",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.GRAPES":
                return AcquisitionInfo.anywhere(
                        "Obtain grapes from a suitable drop, shop, activity, or existing supplies.",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.HAM_BADGE":
            case "ItemID.HAM_CLOAK":
            case "ItemID.HAM_HOOD":
            case "ItemID.HAM_ROBE":
            case "ItemID.HAM_SHIRT":
                return new AcquisitionInfo(
                        "Pickpocket H.A.M. members for the required H.A.M. clothing piece.",
                        AcquisitionRegion.MISTHALIN,
                        "H.A.M. Hideout",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.HUNTING_JERBOA_TAIL":
                return new AcquisitionInfo(
                        "Hunt jerboas for a jerboa tail, or use the alternative quest requirement if available.",
                        AcquisitionRegion.VARLAMORE,
                        "Hunter Guild / Varlamore hunting area",
                        AcquisitionInfo.MethodType.SKILLING
                );

            case "ItemID.ICS_LITTLE_LINEN":
                return new AcquisitionInfo(
                        "Buy linen in Sophanem for the quest.",
                        AcquisitionRegion.DESERT,
                        "Sophanem",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.IRON_SPEAR":
                return AcquisitionInfo.anywhere(
                        "Use an iron spear or a better accepted spear. Smith, buy, or obtain one from a drop.",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.IVANDIS_FLAIL":
                return new AcquisitionInfo(
                        "Use or replace an accepted Ivandis/Blisterwood flail through the Myreque quest line.",
                        AcquisitionRegion.MORYTANIA,
                        "Myreque Hideout",
                        AcquisitionInfo.MethodType.QUEST
                );

            case "ItemID.KEG_OF_BEER":
                return new AcquisitionInfo(
                        "Buy the required kegs of beer from an appropriate Fremennik/Kandarin source, or pay the alternative coins when the requirement allows it.",
                        AcquisitionRegion.FREMENNIK,
                        "Rellekka / Fremennik area",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.LIMESTONEBRICK":
                return new AcquisitionInfo(
                        "Mine limestone near Paterdomus and use a chisel to make limestone bricks, or use existing bricks.",
                        AcquisitionRegion.MORYTANIA,
                        "Limestone mine near Paterdomus",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.LIMPWURT_ROOT":
                return AcquisitionInfo.anywhere(
                        "Grow limpwurt roots in flower patches or obtain them from monster drops.",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.MITHRIL_AXE":
                return AcquisitionInfo.anywhere(
                        "Smith, buy, or obtain a mithril axe from an appropriate source.",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.MM_MONKEY_GREEGREE_FOR_SMALL_NINJA_MONKEY":
                return new AcquisitionInfo(
                        "Make the required ninja monkey greegree during the Monkey Madness quest line.",
                        AcquisitionRegion.KARAMJA,
                        "Ape Atoll",
                        AcquisitionInfo.MethodType.QUEST
                );

            case "ItemID.PINK_SKIRT":
                return new AcquisitionInfo(
                        "Buy a pink skirt from Thessalia's clothes shop.",
                        AcquisitionRegion.MISTHALIN,
                        "Varrock",
                        AcquisitionInfo.MethodType.SHOP
                );

            case "ItemID.POH_SAW":
                return AcquisitionInfo.anywhere(
                        "Buy or pick up any accepted saw.",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.POH_TABLET_TELEGRAB":
                return AcquisitionInfo.anywhere(
                        "Bring the runes or an accepted staff/rune combination for Telekinetic Grab.",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.RAW_BEAR_MEAT":
                return AcquisitionInfo.anywhere(
                        "Kill a bear and take the raw bear meat.",
                        AcquisitionInfo.MethodType.DROP
                );

            case "ItemID.RAW_BEEF":
                return new AcquisitionInfo(
                        "Kill a cow and take the raw beef.",
                        AcquisitionRegion.MISTHALIN,
                        "Lumbridge cow field",
                        AcquisitionInfo.MethodType.DROP
                );

            case "ItemID.RAW_RAT_MEAT":
                return AcquisitionInfo.anywhere(
                        "Kill a rat and take the raw rat meat.",
                        AcquisitionInfo.MethodType.DROP
                );

            case "ItemID.RCU_POUCH_LARGE":
                return new AcquisitionInfo(
                        "Obtain a large Runecraft pouch from Abyssal creatures, or use an accepted colossal pouch.",
                        AcquisitionRegion.WILDERNESS,
                        "Abyss",
                        AcquisitionInfo.MethodType.DROP
                );

            case "ItemID.RED_SPIDERS_EGGS":
                return AcquisitionInfo.anywhere(
                        "Pick up red spiders' eggs from a spawn or obtain them from an accepted drop/source.",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "ItemID.SACK_EMPTY":
                return AcquisitionInfo.anywhere(
                        "Buy empty sacks from a Farming shop or make them through Crafting.",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.SECRET_GHOST_BOTTOM":
            case "ItemID.SECRET_GHOST_CLOAK":
            case "ItemID.SECRET_GHOST_HAT":
            case "ItemID.SECRET_GHOST_TOP":
                return new AcquisitionInfo(
                        "Obtain the required ghostly robes through the Curse of the Empty Lord miniquest route.",
                        AcquisitionRegion.ANYWHERE,
                        "Curse of the Empty Lord miniquest locations",
                        AcquisitionInfo.MethodType.QUEST
                );

            case "ItemID.SILVER_SICKLE":
                return AcquisitionInfo.anywhere(
                        "Craft a silver sickle from a silver bar using a sickle mould, or use one already banked.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.SNAIL_CORPSE1":
                return new AcquisitionInfo(
                        "Kill snails in Mort Myre Swamp and collect the raw snail meat.",
                        AcquisitionRegion.MORYTANIA,
                        "Mort Myre Swamp",
                        AcquisitionInfo.MethodType.DROP
                );

            case "ItemID.SNAKE_FLUTE":
                return new AcquisitionInfo(
                        "Obtain the snake charm during the Pollnivneach/Ratcatchers quest route.",
                        AcquisitionRegion.DESERT,
                        "Pollnivneach",
                        AcquisitionInfo.MethodType.QUEST
                );

            case "ItemID.SPIT_IRON":
                return AcquisitionInfo.anywhere(
                        "Smith an iron spit from an iron bar at an anvil.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.THKARAMJAMAP":
                return new AcquisitionInfo(
                        "Get or replace Radimus notes from Radimus Erkle.",
                        AcquisitionRegion.KANDARIN,
                        "Legends' Guild",
                        AcquisitionInfo.MethodType.NPC
                );

            case "ItemID.TORCH_LIT":
                return AcquisitionInfo.anywhere(
                        "Bring an accepted lit torch or candle and light it before the quest step.",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.UNICORN_HORN_DUST":
                return AcquisitionInfo.anywhere(
                        "Kill a unicorn for a horn, then grind it with a pestle and mortar.",
                        AcquisitionInfo.MethodType.CRAFT
                );

            case "ItemID.VYRELORD_LEGS":
            case "ItemID.VYRELORD_SHOES":
            case "ItemID.VYRELORD_TORSO":
            case "ItemID.VYRE_LEGS":
            case "ItemID.VYRE_SHOES":
            case "ItemID.VYRE_TORSO":
                return new AcquisitionInfo(
                        "Obtain or replace the required Vyre/Vyrewatch disguise through the Morytania quest line.",
                        AcquisitionRegion.MORYTANIA,
                        "Darkmeyer / Myreque quest area",
                        AcquisitionInfo.MethodType.QUEST
                );

            case "ItemID.WANTED_CRYSTAL_BALL":
                return new AcquisitionInfo(
                        "Get or replace the Commorb from Sir Tiffy Cashien.",
                        AcquisitionRegion.ASGARNIA,
                        "Falador Park",
                        AcquisitionInfo.MethodType.NPC
                );

            case "ItemID.WINE_OF_ZAMORAK":
                return new AcquisitionInfo(
                        "Use Telekinetic Grab on a Wine of Zamorak spawn, or use another accepted source.",
                        AcquisitionRegion.ASGARNIA,
                        "Chaos Temple north-west of Goblin Village",
                        AcquisitionInfo.MethodType.MULTIPLE
                );

            case "ItemID.WOOL":
                return new AcquisitionInfo(
                        "Shear a sheep to obtain wool.",
                        AcquisitionRegion.MISTHALIN,
                        "Lumbridge sheep field",
                        AcquisitionInfo.MethodType.GATHER
                );

            case "KeyringCollection.BATTERED_KEY":
                return new AcquisitionInfo(
                        "Get the battered key for the Elemental Workshop quest route in Seers' Village.",
                        AcquisitionRegion.KANDARIN,
                        "Seers' Village / Elemental Workshop",
                        AcquisitionInfo.MethodType.QUEST
                );

            case "KeyringCollection.ENCHANTED_KEY":
                return new AcquisitionInfo(
                        "Get or replace the enchanted key through Jorral's quest route.",
                        AcquisitionRegion.KANDARIN,
                        "Outpost west of Ardougne",
                        AcquisitionInfo.MethodType.QUEST
                );

            default:
                break;
        }

        String lower =
                name.toLowerCase();

        if (containsAny(
                lower,
                "marrentill",
                "guam",
                "harralander",
                "irit",
                "kwuarm",
                "toadflax",
                "ranarr",
                "cadantine",
                "lantadyme",
                "dwarf weed",
                "torstol"))
        {
            return new AcquisitionInfo(
                    "Obtain the herb from Farming, herb drops, or an existing supply.",
                    AcquisitionRegion.ANYWHERE,
                    "Herb patches or monster drops",
                    AcquisitionInfo.MethodType.MULTIPLE
            );
        }

        if (containsAny(
                lower,
                "sapphire",
                "emerald",
                "ruby",
                "diamond",
                "opal",
                "jade",
                "topaz"))
        {
            return new AcquisitionInfo(
                    "Obtain the gem through Mining, gem rocks, monster drops, implings, or existing supplies.",
                    AcquisitionRegion.ANYWHERE,
                    "Mining / gem rocks / monster drops",
                    AcquisitionInfo.MethodType.MULTIPLE
            );
        }

        if (containsAny(
                lower,
                "fishing rod",
                "fishing bait",
                "fishing net",
                "lobster pot",
                "harpoon"))
        {
            return new AcquisitionInfo(
                    "Buy the fishing tool from Gerrant if you do not already own one.",
                    AcquisitionRegion.ASGARNIA,
                    "Gerrant's Fishy Business, Port Sarim",
                    AcquisitionInfo.MethodType.SHOP
            );
        }

        if (containsAny(
                lower,
                "raw sardine",
                "raw mackerel",
                "raw cod",
                "raw tuna",
                "raw salmon",
                "raw trout",
                "raw shark",
                "raw karambwan",
                "slimy eel",
                "swordfish",
                "tuna",
                "salmon",
                "trout"))
        {
            return new AcquisitionInfo(
                    "Fish the required fish at an appropriate fishing spot or use an existing catch.",
                    AcquisitionRegion.ANYWHERE,
                    "Appropriate fishing spot",
                    AcquisitionInfo.MethodType.GATHER
            );
        }

        if (containsAny(
                lower,
                "bread",
                "cake",
                "cheese",
                "stew",
                "pie",
                "cream"))
        {
            return new AcquisitionInfo(
                    "Cook/make the food or obtain it from an accessible food shop or stall.",
                    AcquisitionRegion.ANYWHERE,
                    "Kitchen, food shop or food stall",
                    AcquisitionInfo.MethodType.MULTIPLE
            );
        }

        if (containsAny(
                lower,
                "banana",
                "orange",
                "lemon",
                "potato",
                "onion",
                "tomato",
                "cabbage",
                "berries"))
        {
            return new AcquisitionInfo(
                    "Pick/grow the produce or obtain it from an appropriate food shop or stall.",
                    AcquisitionRegion.ANYWHERE,
                    "Farm fields, Farming patches or food shops",
                    AcquisitionInfo.MethodType.MULTIPLE
            );
        }

        if (containsAny(
                lower,
                "mould",
                "needle",
                "thread",
                "glassblowing pipe"))
        {
            return new AcquisitionInfo(
                    "Buy the Crafting tool from an accessible Crafting shop if you do not already own one.",
                    AcquisitionRegion.ASGARNIA,
                    "Rimmington Crafting supplies",
                    AcquisitionInfo.MethodType.SHOP
            );
        }

        if (containsAny(
                lower,
                "full helm",
                "med helm",
                "platebody",
                "platelegs",
                "chainbody",
                "longsword",
                "2h sword",
                " sword",
                "dagger",
                "mace",
                "warhammer",
                "shield",
                "boots",
                "gloves",
                "bow",
                "crossbow",
                "arrows"))
        {
            return new AcquisitionInfo(
                    "Use an existing item, make it with the relevant skill, buy it from an equipment shop, or obtain it from a drop.",
                    AcquisitionRegion.ANYWHERE,
                    "Equipment shops, skilling or monster drops",
                    AcquisitionInfo.MethodType.MULTIPLE
            );
        }

        if (containsAny(
                lower,
                "amulet",
                "necklace",
                "ring",
                "symbol"))
        {
            return new AcquisitionInfo(
                    "Craft, replace, or obtain the jewellery/item from its normal Ironman source.",
                    AcquisitionRegion.ANYWHERE,
                    "Crafting, quest replacement NPCs or drops",
                    AcquisitionInfo.MethodType.MULTIPLE
            );
        }

        if (lower.contains("food"))
        {
            return new AcquisitionInfo(
                    "Use suitable food already banked, cook it, fish it, or obtain it from an accessible food source.",
                    AcquisitionRegion.ANYWHERE,
                    "Cooking, Fishing or food shops",
                    AcquisitionInfo.MethodType.MULTIPLE
            );
        }

        return null;
    }

    private static AcquisitionInfo fallbackInfo(String name)
    {
        String cleanName = safe(name);

        return new AcquisitionInfo(
                "Obtain "
                        + (cleanName.isEmpty()
                        ? "this quest item"
                        : cleanName)
                        + " from its normal Ironman source. This item has multiple or progression-dependent sources, so no single fixed source is forced.",
                AcquisitionRegion.ANYWHERE,
                "Multiple possible sources",
                AcquisitionInfo.MethodType.MULTIPLE
        );
    }

    private static AcquisitionInfo altarAccessInfo(String runeType)
    {
        return new AcquisitionInfo(
                "Use an accepted "
                        + runeType
                        + " altar access item (talisman/tiara or another valid method such as the Abyss where allowed).",
                AcquisitionRegion.ANYWHERE,
                "Runecrafting altar access / Abyss",
                AcquisitionInfo.MethodType.MULTIPLE
        );
    }

    private static boolean containsAny(
            String text,
            String... values)
    {
        if (text == null)
        {
            return false;
        }

        for (String value : values)
        {
            if (value != null
                    && !value.isEmpty()
                    && text.contains(value))
            {
                return true;
            }
        }

        return false;
    }

    private static String safe(String value)
    {
        return value == null
                ? ""
                : value.trim();
    }

    /*
     * =====================================================
     * SHARED ACQUISITION LOCATIONS
     * =====================================================
     */

    private static AcquisitionInfo southFaladorFarmingShop(
            String instruction)
    {
        return new AcquisitionInfo(
                instruction,
                AcquisitionRegion.ASGARNIA,
                "Sarah's Farming shop, South Falador Farm",
                AcquisitionInfo.MethodType.SHOP
        );
    }
}