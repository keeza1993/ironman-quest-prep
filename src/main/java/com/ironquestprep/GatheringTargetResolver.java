package com.ironquestprep;

import net.runelite.api.coords.WorldPoint;

/**
 * Resolves a gathering step into the best navigation target available.
 *
 * Resolution order:
 *
 * 1. Exact/high-confidence NPC, shop, spawn or area target.
 * 2. Logical AcquisitionPlace navigation point.
 * 3. Unresolved ground-item target for known spawn items.
 * 4. Generic named-area fallback.
 */
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

        /*
         * =================================================
         * EXACT TARGET DATABASE
         * =================================================
         *
         * NPCs, shops, known gathering areas and high-confidence
         * spawn targets always take priority over a general town or
         * regional navigation point.
         */
        GatheringTarget exactTarget =
                AcquisitionTargetDatabase.resolve(
                        step
                );

        if (exactTarget != null)
        {
            return exactTarget;
        }

        /*
         * =================================================
         * LOGICAL PLACE NAVIGATION
         * =================================================
         *
         * If there is no precise target yet, infer the logical
         * AcquisitionPlace and navigate to its verified WorldPoint.
         *
         * This is also where Kourend and Varlamore collapse to the
         * single regional destinations configured in
         * AcquisitionNavigationDatabase.
         */
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
            /*
             * Ground spawns keep their item ID so the overlay can
             * identify/highlight the item after the player reaches
             * the destination.
             */
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

        /*
         * =================================================
         * UNRESOLVED GROUND SPAWN
         * =================================================
         *
         * We know what item should be highlighted, but do not yet
         * have a reliable navigation coordinate for it.
         */
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

        /*
         * =================================================
         * GENERIC AREA FALLBACKS
         * =================================================
         *
         * These preserve useful sidebar information even when an
         * acquisition method has not yet received an exact target.
         */
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