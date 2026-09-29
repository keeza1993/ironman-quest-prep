package com.ironquestprep;

import net.runelite.api.coords.WorldPoint;

public final class GatheringTarget
{
    public enum TargetType
    {
        NPC("NPC"),
        OBJECT("Object"),
        GROUND_ITEM("Ground item"),
        TILE("Tile"),
        AREA("Area"),
        NONE("None");

        private final String displayName;

        TargetType(
                String displayName)
        {
            this.displayName =
                    displayName;
        }

        public String getDisplayName()
        {
            return displayName;
        }
    }

    private final TargetType type;
    private final WorldPoint worldPoint;
    private final int targetId;
    private final String targetName;

    public GatheringTarget(
            TargetType type,
            WorldPoint worldPoint,
            int targetId,
            String targetName)
    {
        this.type =
                type == null
                        ? TargetType.NONE
                        : type;

        this.worldPoint =
                worldPoint;

        this.targetId =
                targetId;

        this.targetName =
                targetName == null
                        ? ""
                        : targetName.trim();
    }

    public static GatheringTarget npc(
            int npcId,
            String name,
            WorldPoint worldPoint)
    {
        return new GatheringTarget(
                TargetType.NPC,
                worldPoint,
                npcId,
                name
        );
    }

    public static GatheringTarget object(
            int objectId,
            String name,
            WorldPoint worldPoint)
    {
        return new GatheringTarget(
                TargetType.OBJECT,
                worldPoint,
                objectId,
                name
        );
    }

    public static GatheringTarget groundItem(
            int itemId,
            String name,
            WorldPoint worldPoint)
    {
        return new GatheringTarget(
                TargetType.GROUND_ITEM,
                worldPoint,
                itemId,
                name
        );
    }

    public static GatheringTarget tile(
            String name,
            WorldPoint worldPoint)
    {
        return new GatheringTarget(
                TargetType.TILE,
                worldPoint,
                -1,
                name
        );
    }

    public static GatheringTarget area(
            String name,
            WorldPoint worldPoint)
    {
        return new GatheringTarget(
                TargetType.AREA,
                worldPoint,
                -1,
                name
        );
    }

    public static GatheringTarget none()
    {
        return new GatheringTarget(
                TargetType.NONE,
                null,
                -1,
                ""
        );
    }

    public TargetType getType()
    {
        return type;
    }

    public WorldPoint getWorldPoint()
    {
        return worldPoint;
    }

    public int getTargetId()
    {
        return targetId;
    }

    public String getTargetName()
    {
        return targetName;
    }

    public boolean hasWorldPoint()
    {
        return worldPoint != null;
    }

    public boolean hasTargetId()
    {
        return targetId >= 0;
    }

    public boolean hasTargetName()
    {
        return !targetName.isEmpty();
    }

    public boolean isNavigable()
    {
        return type != TargetType.NONE
                && worldPoint != null;
    }

    /*
     * Example:
     *
     * 3097, 3257, 0
     */
    public String getCoordinateText()
    {
        if (worldPoint == null)
        {
            return "";
        }

        return worldPoint.getX()
                + ", "
                + worldPoint.getY()
                + ", "
                + worldPoint.getPlane();
    }

    /*
     * Human-readable target description for the
     * Gathering Route sidebar.
     *
     * Examples:
     *
     * NPC: Ned
     * Area: Mill Lane Mill
     * Ground item: Knife
     */
    public String getDisplayText()
    {
        if (type == TargetType.NONE)
        {
            return "No target";
        }

        if (hasTargetName())
        {
            return type.getDisplayName()
                    + ": "
                    + targetName;
        }

        return type.getDisplayName();
    }

    /*
     * Used by the panel so we can immediately see which
     * acquisition entries have usable navigation data.
     */
    public String getNavigationStatus()
    {
        if (type == TargetType.NONE)
        {
            return "No navigation target";
        }

        if (worldPoint != null)
        {
            return "Navigation ready";
        }

        if (hasTargetName())
        {
            return "Target recognised - coordinates needed";
        }

        return "Location data needed";
    }
}