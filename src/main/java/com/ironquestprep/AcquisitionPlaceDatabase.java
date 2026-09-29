package com.ironquestprep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Stable catalogue of acquisition places.
 *
 * The catalogue is intentionally based on logical places rather than map
 * coordinates.  It gives the item database one canonical place name/region to
 * work with.  A later navigation pass can attach verified WorldPoints to these
 * keys without reworking every quest item.
 */
public final class AcquisitionPlaceDatabase
{
    public static final String MULTIPLE_SOURCES = "multiple_sources";
    public static final String ANY_SUITABLE_LOCATION = "any_suitable_location";

    private static final Map<String, AcquisitionPlace> PLACES = buildPlaces();
    private static final List<PlaceRule> RULES = buildRules();

    private AcquisitionPlaceDatabase()
    {
    }

    public static AcquisitionPlace get(String key)
    {
        if (key == null)
        {
            return null;
        }

        return PLACES.get(key.trim().toLowerCase(Locale.ROOT));
    }

    public static List<AcquisitionPlace> getPlaces()
    {
        return Collections.unmodifiableList(
                new ArrayList<>(PLACES.values())
        );
    }

    public static AcquisitionPlace infer(
            AcquisitionRegion suppliedRegion,
            String location,
            String method)
    {
        // The selected source is authoritative; notes may mention alternatives.
        AcquisitionPlace selected = inferFromText(location);
        if (selected != null)
        {
            return selected;
        }
        if (isGenericLocation(location))
        {
            AcquisitionPlace described = inferFromText(method);
            if (described != null
                    && (suppliedRegion == null || suppliedRegion == AcquisitionRegion.UNKNOWN
                    || suppliedRegion == AcquisitionRegion.ANYWHERE
                    || suppliedRegion == described.getRegion()))
            {
                return described;
            }
        }

        AcquisitionRegion region = suppliedRegion == null
                ? AcquisitionRegion.UNKNOWN
                : suppliedRegion;

        String cleanLocation = location == null
                ? ""
                : location.trim();

        if (!cleanLocation.isEmpty()
                && !isGenericLocation(cleanLocation))
        {
            return new AcquisitionPlace(
                    "custom:" + slug(cleanLocation),
                    cleanLocation,
                    region,
                    region != AcquisitionRegion.UNKNOWN
                            && region != AcquisitionRegion.ANYWHERE
            );
        }

        if (region != AcquisitionRegion.UNKNOWN
                && region != AcquisitionRegion.ANYWHERE)
        {
            return new AcquisitionPlace(
                    "region:" + slug(region.getDisplayName()),
                    cleanLocation.isEmpty()
                            ? region.getDisplayName()
                            : cleanLocation,
                    region,
                    false
            );
        }

        if (cleanLocation.toLowerCase(Locale.ROOT).contains("any suitable"))
        {
            return PLACES.get(ANY_SUITABLE_LOCATION);
        }

        return PLACES.get(MULTIPLE_SOURCES);
    }

    public static AcquisitionPlace inferFromText(String text)
    {
        String normalised = normalise(text);

        for (PlaceRule rule : RULES)
        {
            if (rule.matches(normalised))
            {
                return rule.place;
            }
        }

        return null;
    }

    private static Map<String, AcquisitionPlace> buildPlaces()
    {
        Map<String, AcquisitionPlace> places = new LinkedHashMap<>();

        add(places, MULTIPLE_SOURCES, "Multiple possible sources", AcquisitionRegion.ANYWHERE, false);
        add(places, ANY_SUITABLE_LOCATION, "Any suitable location", AcquisitionRegion.ANYWHERE, false);

        add(places, "lumbridge", "Lumbridge", AcquisitionRegion.MISTHALIN, true);
        add(places, "lumbridge_general_store", "Lumbridge General Store", AcquisitionRegion.MISTHALIN, true);
        add(places, "lumbridge_cow_field", "Lumbridge cow field", AcquisitionRegion.MISTHALIN, true);
        add(places, "lumbridge_sheep_field", "Lumbridge sheep field", AcquisitionRegion.MISTHALIN, true);
        add(places, "lumbridge_chicken_farm", "Lumbridge chicken farm", AcquisitionRegion.MISTHALIN, true);
        add(places, "mill_lane_mill", "Mill Lane Mill", AcquisitionRegion.MISTHALIN, true);
        add(places, "lumbridge_swamp", "Lumbridge Swamp", AcquisitionRegion.MISTHALIN, true);
        add(places, "bobs_axes", "Bob's Brilliant Axes, Lumbridge", AcquisitionRegion.MISTHALIN, true);
        add(places, "draynor_village", "Draynor Village", AcquisitionRegion.MISTHALIN, true);
        add(places, "varrock", "Varrock", AcquisitionRegion.MISTHALIN, true);
        add(places, "varrock_southeast_mine", "Varrock south-east mine", AcquisitionRegion.MISTHALIN, true);
        add(places, "cooks_guild", "Cooks' Guild", AcquisitionRegion.MISTHALIN, true);
        add(places, "digsite", "Digsite", AcquisitionRegion.MISTHALIN, true);
        add(places, "edgeville", "Edgeville", AcquisitionRegion.MISTHALIN, true);
        add(places, "ham_hideout", "H.A.M. Hideout", AcquisitionRegion.MISTHALIN, true);
        add(places, "doogle_patch", "Doogle leaf patch near Gertrude's house", AcquisitionRegion.MISTHALIN, true);

        add(places, "falador", "Falador", AcquisitionRegion.ASGARNIA, true);
        add(places, "falador_park", "Falador Park", AcquisitionRegion.ASGARNIA, true);
        add(places, "south_falador_farm", "South Falador Farm", AcquisitionRegion.ASGARNIA, true);
        add(places, "rimmington", "Rimmington", AcquisitionRegion.ASGARNIA, true);
        add(places, "port_sarim", "Port Sarim", AcquisitionRegion.ASGARNIA, true);
        add(places, "dwarven_mine", "Dwarven Mine", AcquisitionRegion.ASGARNIA, true);
        add(places, "burthorpe", "Burthorpe", AcquisitionRegion.ASGARNIA, true);
        add(places, "taverley", "Taverley", AcquisitionRegion.ASGARNIA, true);
        add(places, "taverley_sawmill", "Taverley sawmill", AcquisitionRegion.ASGARNIA, true);
        add(places, "edgeville_monastery", "Edgeville Monastery", AcquisitionRegion.ASGARNIA, true);
        add(places, "makeover_mage", "Makeover Mage", AcquisitionRegion.ASGARNIA, true);
        add(places, "witchs_house", "Witch's House", AcquisitionRegion.ASGARNIA, true);
        add(places, "entrana", "Entrana", AcquisitionRegion.ASGARNIA, true);
        add(places, "goblin_village", "Goblin Village", AcquisitionRegion.ASGARNIA, true);
        add(places, "hobgoblin_peninsula", "Hobgoblin Peninsula", AcquisitionRegion.ASGARNIA, true);
        add(places, "chaos_temple_asgarnia", "Chaos Temple north-west of Goblin Village", AcquisitionRegion.ASGARNIA, true);
        add(places, "slayer_master_burthorpe", "Burthorpe Slayer Master", AcquisitionRegion.ASGARNIA, true);

        add(places, "al_kharid", "Al Kharid", AcquisitionRegion.DESERT, true);
        add(places, "sophanem", "Sophanem", AcquisitionRegion.DESERT, true);
        add(places, "pollnivneach", "Pollnivneach", AcquisitionRegion.DESERT, true);
        add(places, "nardah", "Nardah", AcquisitionRegion.DESERT, true);
        add(places, "shantay_pass", "Shantay Pass", AcquisitionRegion.DESERT, true);
        add(places, "desert_quarry", "Desert Quarry", AcquisitionRegion.DESERT, true);

        add(places, "seers_village", "Seers' Village", AcquisitionRegion.KANDARIN, true);
        add(places, "catherby", "Catherby", AcquisitionRegion.KANDARIN, true);
        add(places, "ardougne", "Ardougne", AcquisitionRegion.KANDARIN, true);
        add(places, "yanille", "Yanille", AcquisitionRegion.KANDARIN, true);
        add(places, "grand_tree", "Grand Tree", AcquisitionRegion.KANDARIN, true);
        add(places, "tree_gnome_stronghold", "Tree Gnome Stronghold", AcquisitionRegion.KANDARIN, true);
        add(places, "tree_gnome_village_dungeon", "Tree Gnome Village dungeon", AcquisitionRegion.KANDARIN, true);
        add(places, "mcgrubors_wood", "McGrubor's Wood", AcquisitionRegion.KANDARIN, true);
        add(places, "port_khazard", "Port Khazard", AcquisitionRegion.KANDARIN, true);
        add(places, "baxtorian_falls", "Baxtorian Falls", AcquisitionRegion.KANDARIN, true);
        add(places, "legends_guild", "Legends' Guild", AcquisitionRegion.KANDARIN, true);
        add(places, "feldip_hills", "Feldip Hills", AcquisitionRegion.KANDARIN, true);
        add(places, "clock_tower", "Clock Tower", AcquisitionRegion.KANDARIN, true);
        add(places, "catherby_beehives", "Beehives west of Catherby", AcquisitionRegion.KANDARIN, true);
        add(places, "ottos_grotto", "Otto's Grotto", AcquisitionRegion.KANDARIN, true);
        add(places, "ardougne_outpost", "Outpost west of Ardougne", AcquisitionRegion.KANDARIN, true);
        add(places, "mourner_area", "Mourner / Arandar area", AcquisitionRegion.KANDARIN, true);

        add(places, "karamja", "Karamja", AcquisitionRegion.KARAMJA, true);
        add(places, "karamja_plantation", "Karamja banana plantation", AcquisitionRegion.KARAMJA, true);
        add(places, "tai_bwo_wannai", "Tai Bwo Wannai", AcquisitionRegion.KARAMJA, true);
        add(places, "shilo_village", "Shilo Village", AcquisitionRegion.KARAMJA, true);
        add(places, "kharazi_jungle", "Kharazi Jungle", AcquisitionRegion.KARAMJA, true);
        add(places, "ape_atoll", "Ape Atoll", AcquisitionRegion.KARAMJA, true);
        add(places, "karamja_shipyard", "Karamja Shipyard", AcquisitionRegion.KARAMJA, true);

        add(places, "rellekka", "Rellekka", AcquisitionRegion.FREMENNIK, true);
        add(places, "jatizso", "Jatizso", AcquisitionRegion.FREMENNIK, true);
        add(places, "keldagrim", "Keldagrim", AcquisitionRegion.FREMENNIK, true);
        add(places, "miscellania", "Miscellania", AcquisitionRegion.FREMENNIK, true);
        add(places, "trollheim", "Trollheim / Troll Stronghold", AcquisitionRegion.FREMENNIK, true);
        add(places, "white_wolf_mountain", "White Wolf Mountain", AcquisitionRegion.FREMENNIK, true);
        add(places, "mountain_camp", "Mountain Camp", AcquisitionRegion.FREMENNIK, true);

        add(places, "canifis", "Canifis", AcquisitionRegion.MORYTANIA, true);
        add(places, "mort_myre_swamp", "Mort Myre Swamp", AcquisitionRegion.MORYTANIA, true);
        add(places, "darkmeyer", "Darkmeyer", AcquisitionRegion.MORYTANIA, true);
        add(places, "paterdomus_limestone", "Limestone mine near Paterdomus", AcquisitionRegion.MORYTANIA, true);
        add(places, "burgh_de_rott", "Burgh de Rott", AcquisitionRegion.MORYTANIA, true);
        add(places, "myreque_hideout", "Myreque Hideout", AcquisitionRegion.MORYTANIA, true);
        add(places, "harmony", "Harmony", AcquisitionRegion.MORYTANIA, true);
        add(places, "ectofuntus", "Ectofuntus", AcquisitionRegion.MORYTANIA, true);

        add(places, "isafdar", "Isafdar", AcquisitionRegion.TIRANNWN, true);
        add(places, "prifddinas", "Prifddinas", AcquisitionRegion.TIRANNWN, true);

        add(places, "mage_arena", "Mage Arena", AcquisitionRegion.WILDERNESS, true);
        add(places, "abyss", "Abyss", AcquisitionRegion.WILDERNESS, true);

        add(places, "arceuus", "Arceuus", AcquisitionRegion.KOUREND_KEBOS, true);
        add(places, "lovakengj", "Lovakengj", AcquisitionRegion.KOUREND_KEBOS, true);
        add(places, "hosidius", "Hosidius", AcquisitionRegion.KOUREND_KEBOS, true);
        add(places, "piscarilius", "Piscarilius", AcquisitionRegion.KOUREND_KEBOS, true);
        add(places, "shayzien", "Shayzien", AcquisitionRegion.KOUREND_KEBOS, true);

        add(places, "hunter_guild", "Hunter Guild", AcquisitionRegion.VARLAMORE, true);

        return Collections.unmodifiableMap(places);
    }

    private static List<PlaceRule> buildRules()
    {
        List<PlaceRule> rules = new ArrayList<>();

        rule(rules, "lumbridge_general_store", "lumbridge general store");
        rule(rules, "lumbridge_cow_field", "lumbridge cow field", "cow field north of lumbridge");
        rule(rules, "lumbridge_sheep_field", "lumbridge sheep field", "sheep field north of lumbridge");
        rule(rules, "lumbridge_chicken_farm", "lumbridge chicken farm", "chicken farm");
        rule(rules, "mill_lane_mill", "lumbridge windmill", "mill lane mill", "windmill");
        rule(rules, "lumbridge_swamp", "lumbridge swamp", "father urhney");
        rule(rules, "bobs_axes", "bob's axes", "bob's brilliant axes", "buy one from bob");

        rule(rules, "south_falador_farm", "south falador farm", "sarah's farming shop");
        rule(rules, "falador_park", "falador park", "wyson");
        rule(rules, "edgeville_monastery", "edgeville monastery");
        rule(rules, "dwarven_mine", "dwarven mine", "nurmof", "nulodion");
        rule(rules, "taverley_sawmill", "taverley sawmill");
        rule(rules, "makeover_mage", "makeover mage");
        rule(rules, "witchs_house", "witch's house", "witchs house");
        rule(rules, "port_sarim", "port sarim", "gerrant", "betty", "wydin");
        rule(rules, "goblin_village", "goblin village");
        rule(rules, "hobgoblin_peninsula", "hobgoblin peninsula");
        rule(rules, "chaos_temple_asgarnia", "chaos temple north-west", "chaos temple northwest");
        rule(rules, "slayer_master_burthorpe", "burthorpe slayer", "turael", "spria");
        rule(rules, "rimmington", "rimmington");
        rule(rules, "burthorpe", "burthorpe", "dunstan", "hild");
        rule(rules, "entrana", "entrana", "dramen tree");
        rule(rules, "falador", "falador", "rising sun inn");
        rule(rules, "taverley", "taverley", "jatix");

        rule(rules, "sophanem", "sophanem", "sphinx");
        rule(rules, "al_kharid", "al kharid", "al-kharid", "father reen");
        rule(rules, "pollnivneach", "pollnivneach");
        rule(rules, "nardah", "nardah");
        rule(rules, "shantay_pass", "shantay pass");
        rule(rules, "desert_quarry", "desert quarry", "granite quarry");

        rule(rules, "mcgrubors_wood", "mcgrubor's wood", "mcgrubors wood");
        rule(rules, "tree_gnome_stronghold", "tree gnome stronghold");
        rule(rules, "tree_gnome_village_dungeon", "tree gnome village dungeon", "tree gnome village / dungeon");
        rule(rules, "grand_tree", "grand tree", "narnode");
        rule(rules, "seers_village", "seers' village", "seers village");
        rule(rules, "port_khazard", "port khazard", "murphy");
        rule(rules, "baxtorian_falls", "baxtorian falls", "rasolo");
        rule(rules, "legends_guild", "legends' guild", "legends guild", "radimus");
        rule(rules, "feldip_hills", "feldip", "feldip hills");
        rule(rules, "clock_tower", "clock tower");
        rule(rules, "catherby_beehives", "beehives west of catherby", "beehives", "bucket of wax");
        rule(rules, "ottos_grotto", "otto's grotto", "ottos grotto", "barbarian fishing");
        rule(rules, "ardougne_outpost", "outpost west of ardougne", "jorral");
        rule(rules, "mourner_area", "mourner hq", "arandar", "mourner area");
        rule(rules, "catherby", "catherby");
        rule(rules, "yanille", "yanille");
        rule(rules, "ardougne", "ardougne", "edmond's house", "wizard cromperty");

        rule(rules, "karamja_shipyard", "shipyard");
        rule(rules, "kharazi_jungle", "kharazi jungle");
        rule(rules, "tai_bwo_wannai", "tai bwo wannai");
        rule(rules, "shilo_village", "shilo village");
        rule(rules, "ape_atoll", "ape atoll", "monkey market", "monkey temple", "solihib");
        rule(rules, "karamja_plantation", "banana plantation");
        rule(rules, "karamja", "karamja", "musa point");

        rule(rules, "jatizso", "jatizso", "flosi");
        rule(rules, "keldagrim", "keldagrim");
        rule(rules, "miscellania", "miscellania");
        rule(rules, "white_wolf_mountain", "white wolf mountain", "ice queen");
        rule(rules, "mountain_camp", "hamal", "mountain camp");
        rule(rules, "trollheim", "trollheim", "troll stronghold", "troll kitchen");
        rule(rules, "rellekka", "rellekka", "askeladden", "brundt");

        rule(rules, "burgh_de_rott", "burgh de rott");
        rule(rules, "myreque_hideout", "myreque hideout", "myreque base", "myreque / morytania", "old man ral", "vertida", "veliaf");
        rule(rules, "harmony", "harmony / quest route", "harmony island");
        rule(rules, "ectofuntus", "ectofuntus", "ecto-token", "ecto token");
        rule(rules, "mort_myre_swamp", "mort myre swamp", "mort myre");
        rule(rules, "darkmeyer", "darkmeyer");
        rule(rules, "paterdomus_limestone", "limestone mine near paterdomus", "paterdomus limestone");
        rule(rules, "canifis", "canifis");

        rule(rules, "isafdar", "isafdar");
        rule(rules, "prifddinas", "prifddinas");

        rule(rules, "mage_arena", "mage arena", "chamber guardian");
        rule(rules, "abyss", "the abyss", "abyssal creatures", "abyssal area");

        rule(rules, "hunter_guild", "hunter guild");
        rule(rules, "lovakengj", "lovakengj");
        rule(rules, "arceuus", "arceuus", "dark altar", "dense essence");
        rule(rules, "hosidius", "hosidius");
        rule(rules, "piscarilius", "piscarilius");
        rule(rules, "shayzien", "shayzien");

        rule(rules, "digsite", "digsite", "specimen tray", "panning");
        rule(rules, "cooks_guild", "cooks' guild", "cooks guild");
        rule(rules, "varrock_southeast_mine", "varrock south-east mine", "varrock southeast mine");
        rule(rules, "draynor_village", "draynor", "aggie", "ned");
        rule(rules, "ham_hideout", "h.a.m. hideout", "ham hideout", "h.a.m. member", "ham member");
        rule(rules, "doogle_patch", "doogle leaves", "doogle leaf");
        rule(rules, "edgeville", "edgeville");
        rule(rules, "varrock", "varrock", "thessalia", "toby");
        rule(rules, "lumbridge", "lumbridge", "culinaromancer's chest", "culinaromancers chest");

        return Collections.unmodifiableList(rules);
    }

    private static void add(
            Map<String, AcquisitionPlace> places,
            String key,
            String name,
            AcquisitionRegion region,
            boolean specific)
    {
        places.put(
                key,
                new AcquisitionPlace(key, name, region, specific)
        );
    }

    private static void rule(
            List<PlaceRule> rules,
            String placeKey,
            String... hints)
    {
        AcquisitionPlace place = PLACES.get(placeKey);

        if (place != null)
        {
            rules.add(new PlaceRule(place, hints));
        }
    }

    private static boolean isGenericLocation(String location)
    {
        String normalised = normalise(location);

        return normalised.isEmpty()
                || normalised.contains("any suitable")
                || normalised.contains("any convenient")
                || normalised.contains("multiple source")
                || normalised.contains("general / multiple")
                || normalised.contains("supply shops")
                || normalised.contains("shops / pubs")
                || normalised.equals("any region");
    }

    private static String normalise(String value)
    {
        return value == null
                ? ""
                : value.trim().toLowerCase(Locale.ROOT);
    }

    private static String slug(String value)
    {
        return normalise(value)
                .replaceAll("[^a-z0-9]+", "_")
                .replaceAll("^_+|_+$", "");
    }

    private static final class PlaceRule
    {
        private final AcquisitionPlace place;
        private final String[] hints;

        private PlaceRule(
                AcquisitionPlace place,
                String[] hints)
        {
            this.place = place;
            this.hints = hints == null
                    ? new String[0]
                    : hints;
        }

        private boolean matches(String text)
        {
            if (text == null || text.isEmpty())
            {
                return false;
            }

            for (String hint : hints)
            {
                if (hint != null
                        && !hint.isEmpty()
                        && AcquisitionTargetDatabase.containsHint(text, hint))
                {
                    return true;
                }
            }

            return false;
        }
    }
}
