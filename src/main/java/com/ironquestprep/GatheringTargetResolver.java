package com.ironquestprep;

import net.runelite.api.coords.WorldPoint;

public final class GatheringTargetResolver
{
    private GatheringTargetResolver()
    {
    }

    public static GatheringTarget resolve(
            GatheringStep step)
    {
        if (step == null)
        {
            return GatheringTarget.none();
        }

        // Explicit targets supplied by a route/stage are already more specific
        // than any text-derived destination.
        if (step.hasNavigationTarget())
        {
            return step.getTarget();
        }

        GatheringTarget exactTarget =
                AcquisitionTargetDatabase.resolve(
                        step
                );

        if (exactTarget != null)
        {
            return exactTarget;
        }

        AcquisitionPlace logicalPlace =
                AcquisitionPlaceDatabase.infer(
                        step.getRegion(),
                        step.getLocation(),
                        step.getInstruction()
                );

        WorldPoint logicalPlacePoint =
                AcquisitionNavigationDatabase.getWorldPoint(
                        logicalPlace
                );

        if (logicalPlacePoint != null)
        {

            if (step.getMethodType()
                    == AcquisitionInfo.MethodType.SPAWN)
            {
                int[] ids =
                        step.getItemIds();

                if (ids.length > 0)
                {
                    return GatheringTarget.groundItem(
                            ids[0],
                            step.getItemName(),
                            logicalPlacePoint
                    );
                }
            }

            return GatheringTarget.area(
                    logicalPlace.getDisplayName(),
                    logicalPlacePoint
            );
        }

        if (step.getMethodType()
                == AcquisitionInfo.MethodType.SPAWN)
        {
            int[] ids =
                    step.getItemIds();

            if (ids.length > 0)
            {
                return unresolvedGroundItem(
                        ids[0],
                        step.getItemName()
                );
            }
        }

        if (step.getMethodType()
                == AcquisitionInfo.MethodType.NPC)
        {
            return unresolvedArea(
                    step.getLocation()
            );
        }

        if (step.getMethodType()
                == AcquisitionInfo.MethodType.SHOP)
        {
            return unresolvedArea(
                    step.getLocation()
            );
        }

        if (step.getMethodType()
                == AcquisitionInfo.MethodType.GATHER)
        {
            return unresolvedArea(
                    step.getLocation()
            );
        }

        if (step.getMethodType()
                == AcquisitionInfo.MethodType.CRAFT)
        {
            return unresolvedArea(
                    step.getLocation()
            );
        }

        return GatheringTarget.none();
    }

    private static GatheringTarget unresolvedGroundItem(
            int itemId,
            String name)
    {
        return new GatheringTarget(
                GatheringTarget.TargetType.GROUND_ITEM,
                null,
                itemId,
                name
        );
    }

    private static GatheringTarget unresolvedArea(
            String name)
    {
        return new GatheringTarget(
                GatheringTarget.TargetType.AREA,
                null,
                -1,
                name == null
                        ? ""
                        : name
        );
    }
}
