package com.ironquestprep;

public enum AcquisitionRegion
{
    MISTHALIN(
            10,
            "Misthalin"
    ),

    ASGARNIA(
            20,
            "Asgarnia"
    ),

    KANDARIN(
            30,
            "Kandarin"
    ),

    KARAMJA(
            40,
            "Karamja"
    ),

    FREMENNIK(
            50,
            "Fremennik"
    ),

    DESERT(
            60,
            "Desert"
    ),

    MORYTANIA(
            70,
            "Morytania"
    ),

    TIRANNWN(
            80,
            "Tirannwn"
    ),

    WILDERNESS(
            90,
            "Wilderness"
    ),

    KOUREND_KEBOS(
            100,
            "Kourend & Kebos"
    ),

    VARLAMORE(
            110,
            "Varlamore"
    ),

    ANYWHERE(
            900,
            "Any region"
    ),

    UNKNOWN(
            999,
            "Needs location review"
    );

    private final int sortOrder;
    private final String displayName;

    AcquisitionRegion(
            int sortOrder,
            String displayName)
    {
        this.sortOrder = sortOrder;
        this.displayName = displayName;
    }

    public int getSortOrder()
    {
        return sortOrder;
    }

    public String getDisplayName()
    {
        return displayName;
    }
}