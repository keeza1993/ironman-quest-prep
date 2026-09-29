package com.ironquestprep;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import net.runelite.api.coords.WorldPoint;

/**
 * Navigation coordinates attached to logical AcquisitionPlace keys.
 *
 * Every concrete place currently registered in AcquisitionPlaceDatabase
 * has a navigation destination here.
 *
 * These points are general arrival/navigation points. They do not replace
 * exact NPC/object/item targets in GatheringTargetResolver, which continue
 * to take priority.
 *
 * Great Kourend and Varlamore are intentionally treated as one general
 * navigation destination each.
 */
public final class AcquisitionNavigationDatabase {
    /*
     * =================================================
     * REGIONAL DESTINATIONS
     * =================================================
     */

    /*
     * All Great Kourend / Kebos acquisition places deliberately share
     * one general navigation point.
     */
    private static final WorldPoint KOUREND_POINT = new WorldPoint(1642, 3673, 0);

    /*
     * All Varlamore acquisition places deliberately share one general
     * navigation point at Civitas illa Fortis.
     */
    private static final WorldPoint VARLAMORE_POINT = new WorldPoint(1690, 3130, 0);

    private static final Map<String, WorldPoint> WORLD_POINTS = buildWorldPoints();

    private AcquisitionNavigationDatabase() {}

    public static WorldPoint getWorldPoint(AcquisitionPlace place) {
        if (place == null) {
            return null;
        }

        /*
         * Keep Kourend as one logical navigation destination.
         *
         * This also automatically covers future Kourend places added
         * to AcquisitionPlaceDatabase.
         */
        if (place.getRegion() == AcquisitionRegion.KOUREND_KEBOS) {
            return KOUREND_POINT;
        }

        /*
         * Keep Varlamore as one logical navigation destination.
         *
         * This also automatically covers future Varlamore places added
         * to AcquisitionPlaceDatabase.
         */
        if (place.getRegion() == AcquisitionRegion.VARLAMORE) {
            return VARLAMORE_POINT;
        }

        return getWorldPoint(place.getKey());
    }

    public static WorldPoint getWorldPoint(String placeKey) {
        if (placeKey == null) {
            return null;
        }

        return WORLD_POINTS.get(placeKey.trim().toLowerCase(Locale.ROOT));
    }

    public static boolean hasWorldPoint(AcquisitionPlace place) {
        return getWorldPoint(place) != null;
    }

    public static int getMappedPlaceCount() {
        return WORLD_POINTS.size();
    }

    private static Map<String, WorldPoint> buildWorldPoints() {
        Map<String, WorldPoint> points = new LinkedHashMap<>();

        /*
         * =================================================
         * MISTHALIN
         * =================================================
         */

        add(points, "lumbridge", 3222, 3218, 0);

        add(points, "lumbridge_general_store", 3212, 3247, 0);

        add(points, "lumbridge_cow_field", 3252, 3276, 0);

        add(points, "lumbridge_sheep_field", 3200, 3268, 0);

        add(points, "lumbridge_chicken_farm", 3228, 3298, 0);

        add(points, "mill_lane_mill", 3166, 3306, 0);

        add(points, "lumbridge_swamp", 3169, 3172, 0);

        add(points, "bobs_axes", 3232, 3203, 0);

        add(points, "draynor_village", 3093, 3244, 0);

        add(points, "varrock", 3212, 3423, 0);

        add(points, "varrock_southeast_mine", 3287, 3367, 0);

        add(points, "cooks_guild", 3143, 3443, 0);

        add(points, "digsite", 3363, 3417, 0);

        add(points, "edgeville", 3087, 3496, 0);

        /*
         * Surface entrance to H.A.M. Hideout.
         */
        add(points, "ham_hideout", 3165, 3251, 0);

        add(points, "doogle_patch", 3152, 3409, 0);

        /*
         * =================================================
         * ASGARNIA
         * =================================================
         */

        add(points, "falador", 2965, 3380, 0);

        add(points, "falador_park", 2997, 3375, 0);

        add(points, "south_falador_farm", 3004, 3298, 0);

        add(points, "rimmington", 2957, 3214, 0);

        add(points, "port_sarim", 3038, 3191, 0);

        /*
         * Surface approach to Dwarven Mine.
         *
         * Exact targets such as Nurmof still override this.
         */
        add(points, "dwarven_mine", 3018, 3450, 0);

        add(points, "burthorpe", 2926, 3559, 0);

        add(points, "taverley", 2895, 3443, 0);

        add(points, "taverley_sawmill", 2888, 3465, 0);

        add(points, "edgeville_monastery", 3052, 3488, 0);

        add(points, "makeover_mage", 2919, 3323, 0);

        add(points, "witchs_house", 2903, 3465, 0);

        add(points, "entrana", 2834, 3335, 0);

        add(points, "goblin_village", 2956, 3506, 0);

        add(points, "hobgoblin_peninsula", 2913, 3293, 0);

        add(points, "chaos_temple_asgarnia", 2947, 3518, 0);

        add(points, "slayer_master_burthorpe", 2931, 3536, 0);

        /*
         * =================================================
         * KHARIDIAN DESERT
         * =================================================
         */

        add(points, "al_kharid", 3293, 3174, 0);

        add(points, "sophanem", 3286, 2785, 0);

        add(points, "pollnivneach", 3358, 2968, 0);

        add(points, "nardah", 3427, 2914, 0);

        add(points, "shantay_pass", 3304, 3116, 0);

        add(points, "desert_quarry", 3170, 2907, 0);

        /*
         * =================================================
         * KANDARIN
         * =================================================
         */

        add(points, "seers_village", 2726, 3486, 0);

        add(points, "catherby", 2808, 3438, 0);

        add(points, "ardougne", 2662, 3305, 0);

        add(points, "yanille", 2606, 3093, 0);

        add(points, "grand_tree", 2465, 3495, 0);

        add(points, "tree_gnome_stronghold", 2461, 3444, 0);

        /*
         * Surface destination for Tree Gnome Village / dungeon.
         */
        add(points, "tree_gnome_village_dungeon", 2541, 3170, 0);

        add(points, "mcgrubors_wood", 2645, 3495, 0);

        add(points, "port_khazard", 2665, 3161, 0);

        add(points, "baxtorian_falls", 2512, 3472, 0);

        add(points, "legends_guild", 2728, 3377, 0);

        add(points, "feldip_hills", 2571, 2984, 0);

        add(points, "clock_tower", 2568, 3245, 0);

        add(points, "catherby_beehives", 2755, 3441, 0);

        add(points, "ottos_grotto", 2500, 3489, 0);

        add(points, "ardougne_outpost", 2437, 3348, 0);

        /*
         * General Mourner / Arandar acquisition area.
         */
        add(points, "mourner_area", 2550, 3320, 0);

        /*
         * =================================================
         * KARAMJA
         * =================================================
         */

        /*
         * General Karamja destination at Musa Point.
         */
        add(points, "karamja", 2915, 3155, 0);

        add(points, "karamja_plantation", 2913, 3167, 0);

        add(points, "tai_bwo_wannai", 2789, 3065, 0);

        add(points, "shilo_village", 2852, 2955, 0);

        add(points, "kharazi_jungle", 2824, 2913, 0);

        add(points, "ape_atoll", 2802, 2765, 0);

        add(points, "karamja_shipyard", 2955, 3025, 0);

        /*
         * =================================================
         * FREMENNIK PROVINCE
         * =================================================
         */

        add(points, "rellekka", 2668, 3630, 0);

        add(points, "jatizso", 2416, 3801, 0);

        /*
         * Surface entrance / approach to Keldagrim.
         */
        add(points, "keldagrim", 2730, 3712, 0);

        add(points, "miscellania", 2535, 3867, 0);

        add(points, "trollheim", 2888, 3676, 0);

        add(points, "white_wolf_mountain", 2848, 3497, 0);

        add(points, "mountain_camp", 2811, 3678, 0);

        /*
         * =================================================
         * MORYTANIA
         * =================================================
         */

        add(points, "canifis", 3494, 3488, 0);

        add(points, "mort_myre_swamp", 3440, 3380, 0);

        add(points, "darkmeyer", 3620, 3355, 0);

        add(points, "paterdomus_limestone", 3375, 3497, 0);

        add(points, "burgh_de_rott", 3497, 3212, 0);

        add(points, "myreque_hideout", 3496, 3406, 0);

        add(points, "harmony", 3798, 2866, 0);

        add(points, "ectofuntus", 3660, 3517, 0);

        /*
         * =================================================
         * TIRANNWN
         * =================================================
         */

        add(points, "isafdar", 2241, 3238, 0);

        /*
         * Prifddinas uses its own map region.
         */
        add(points, "prifddinas", 3264, 6105, 0);

        /*
         * =================================================
         * WILDERNESS
         * =================================================
         */

        add(points, "mage_arena", 3105, 3934, 0);

        /*
         * Route to the Mage of Zamorak / Abyss entrance rather
         * than trying to navigate directly into the Abyss instance.
         */
        add(points, "abyss", 3105, 3559, 0);

        /*
         * =================================================
         * GREAT KOUREND / KEBOS
         * =================================================
         *
         * Intentionally one navigation destination.
         */

        add(points, "arceuus", KOUREND_POINT);

        add(points, "lovakengj", KOUREND_POINT);

        add(points, "hosidius", KOUREND_POINT);

        add(points, "piscarilius", KOUREND_POINT);

        add(points, "shayzien", KOUREND_POINT);

        /*
         * =================================================
         * VARLAMORE
         * =================================================
         *
         * Intentionally one navigation destination.
         */

        add(points, "hunter_guild", VARLAMORE_POINT);

        return Collections.unmodifiableMap(points);
    }

    private static void add(
            Map<String, WorldPoint> points, String placeKey, int x, int y, int plane) {
        add(points, placeKey, new WorldPoint(x, y, plane));
    }

    private static void add(
            Map<String, WorldPoint> points, String placeKey, WorldPoint worldPoint) {
        points.put(placeKey, worldPoint);
    }
}
