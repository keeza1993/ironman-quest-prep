package com.ironquestprep;

public final class AcquisitionInfo
{
    public enum MethodType
    {
        SHOP("Shop"),
        SPAWN("Ground spawn"),
        GATHER("Gather"),
        CRAFT("Craft"),
        DROP("Monster drop"),
        NPC("NPC"),
        QUEST("Quest progression"),
        SKILLING("Skilling"),
        MULTIPLE("Multiple methods"),
        UNKNOWN("Needs review");

        private final String displayName;

        MethodType(String displayName)
        {
            this.displayName = displayName;
        }

        public String getDisplayName()
        {
            return displayName;
        }
    }

    private final String method;
    private final AcquisitionRegion region;
    private final String location;
    private final MethodType methodType;
    private final AcquisitionPlace place;

    public AcquisitionInfo(
            String method,
            AcquisitionRegion region,
            String location,
            MethodType methodType)
    {
        this(
                method,
                region,
                location,
                methodType,
                null
        );
    }

    public AcquisitionInfo(
            String method,
            AcquisitionRegion region,
            String location,
            MethodType methodType,
            AcquisitionPlace suppliedPlace)
    {
        this.method = safe(method);

        AcquisitionRegion cleanRegion = region == null
                ? AcquisitionRegion.UNKNOWN
                : region;

        String cleanLocation = safe(location);

        AcquisitionPlace resolvedPlace = suppliedPlace;

        if (resolvedPlace == null)
        {
            resolvedPlace = AcquisitionPlaceDatabase.infer(
                    cleanRegion,
                    cleanLocation,
                    this.method
            );
        }

        if (resolvedPlace != null)
        {
            if (cleanRegion == AcquisitionRegion.UNKNOWN)
            {
                cleanRegion = resolvedPlace.getRegion();
            }

            if (cleanLocation.isEmpty())
            {
                cleanLocation = resolvedPlace.getDisplayName();
            }
        }

        if (cleanRegion == AcquisitionRegion.UNKNOWN)
        {
            cleanRegion = AcquisitionRegion.ANYWHERE;
        }

        if (cleanLocation.isEmpty())
        {
            cleanLocation = "Multiple possible sources";
        }

        this.region = cleanRegion;
        this.location = cleanLocation;
        this.methodType = methodType == null
                ? MethodType.UNKNOWN
                : methodType;
        this.place = resolvedPlace == null
                ? AcquisitionPlaceDatabase.get(
                        AcquisitionPlaceDatabase.MULTIPLE_SOURCES
                )
                : resolvedPlace;
    }

    /**
     * Compatibility helper for generated notes that have not yet been given a
     * hand-authored route.  Unlike the old implementation this still produces
     * a complete, non-blank acquisition record.
     */
    public static AcquisitionInfo unknown(String method)
    {
        AcquisitionPlace place = AcquisitionPlaceDatabase.inferFromText(method);
        MethodType inferredType = inferMethodType(method);

        if (place != null)
        {
            return new AcquisitionInfo(
                    method,
                    place.getRegion(),
                    place.getDisplayName(),
                    inferredType,
                    place
            );
        }

        return new AcquisitionInfo(
                method,
                AcquisitionRegion.ANYWHERE,
                "Multiple possible sources",
                inferredType == MethodType.UNKNOWN
                        ? MethodType.MULTIPLE
                        : inferredType,
                AcquisitionPlaceDatabase.get(
                        AcquisitionPlaceDatabase.MULTIPLE_SOURCES
                )
        );
    }

    public static AcquisitionInfo anywhere(
            String method,
            MethodType methodType)
    {
        return new AcquisitionInfo(
                method,
                AcquisitionRegion.ANYWHERE,
                "Any suitable location",
                methodType,
                AcquisitionPlaceDatabase.get(
                        AcquisitionPlaceDatabase.ANY_SUITABLE_LOCATION
                )
        );
    }

    public AcquisitionInfo withAdditionalNote(String note)
    {
        String cleanNote = safe(note);

        if (cleanNote.isEmpty()
                || method.contains(cleanNote))
        {
            return this;
        }

        String combinedMethod;

        if (method.isEmpty())
        {
            combinedMethod = cleanNote;
        }
        else
        {
            combinedMethod = method + " Note: " + cleanNote;
        }

        return new AcquisitionInfo(
                combinedMethod,
                region,
                location,
                methodType,
                place
        );
    }

    public String getMethod()
    {
        return method;
    }

    public AcquisitionRegion getRegion()
    {
        return region;
    }

    public String getLocation()
    {
        return location;
    }

    public MethodType getMethodType()
    {
        return methodType;
    }

    public AcquisitionPlace getPlace()
    {
        return place;
    }

    public boolean hasMethod()
    {
        return !method.isEmpty();
    }

    public boolean hasLocation()
    {
        return !location.isEmpty();
    }

    public boolean hasSpecificPlace()
    {
        return place != null
                && place.isSpecific();
    }

    public static MethodType inferMethodType(String text)
    {
        String lower = safe(text).toLowerCase();

        if (lower.isEmpty())
        {
            return MethodType.UNKNOWN;
        }

        if (containsAny(
                lower,
                "buy ",
                "buy one",
                "buy some",
                "purchasable",
                "purchased",
                "shop",
                "for 1gp",
                "for 2 coins",
                "for 3 coins",
                "for 5 coins",
                "for 20k",
                "for 80k",
                "for 150k"))
        {
            return MethodType.SHOP;
        }

        if (containsAny(
                lower,
                "kill ",
                "killing ",
                "drops ",
                "drop from"))
        {
            return MethodType.DROP;
        }

        if (containsAny(
                lower,
                "mine ",
                "mined ",
                "chop ",
                "pick ",
                "picking ",
                "fish ",
                "shear ",
                "panning"))
        {
            return MethodType.GATHER;
        }

        if (containsAny(
                lower,
                "make ",
                "made ",
                "cook ",
                "grind ",
                "mix ",
                "smelt ",
                "smith ",
                "spin ",
                "use a knife",
                "using a knife",
                "use cooked",
                "convert "))
        {
            return MethodType.CRAFT;
        }

        if (containsAny(
                lower,
                "spawn",
                "pick up",
                "pick this up",
                "find one",
                "find a ",
                "search ",
                "searching ",
                "cabinet",
                "cupboard",
                "crate"))
        {
            return MethodType.SPAWN;
        }

        if (containsAny(
                lower,
                "during the quest",
                "during quest",
                "quest route",
                "quest step",
                "quest line",
                "obtainable in quest",
                "obtained in quest"))
        {
            return MethodType.QUEST;
        }

        if (containsAny(
                lower,
                "get another from",
                "get one from",
                "obtain from",
                "talk to",
                "give ",
                "from father ",
                "from rasolo",
                "from askeladden"))
        {
            return MethodType.NPC;
        }

        return MethodType.MULTIPLE;
    }

    private static boolean containsAny(
            String text,
            String... needles)
    {
        for (String needle : needles)
        {
            if (text.contains(needle))
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
}
