package com.ironquestprep;

/**
 * Logical acquisition location used by the quest-prep data layer.
 *
 * This deliberately does not contain RuneLite WorldPoints yet.  The goal of
 * this layer is to give every acquisition route a stable place identity first;
 * navigation coordinates can then be attached without changing quest/item
 * data again.
 */
public final class AcquisitionPlace
{
    private final String key;
    private final String displayName;
    private final AcquisitionRegion region;
    private final boolean specific;

    public AcquisitionPlace(
            String key,
            String displayName,
            AcquisitionRegion region,
            boolean specific)
    {
        this.key = safe(key);
        this.displayName = safe(displayName);
        this.region = region == null
                ? AcquisitionRegion.UNKNOWN
                : region;
        this.specific = specific;
    }

    public String getKey()
    {
        return key;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public AcquisitionRegion getRegion()
    {
        return region;
    }

    public boolean isSpecific()
    {
        return specific;
    }

    private static String safe(String value)
    {
        return value == null
                ? ""
                : value.trim();
    }
}
