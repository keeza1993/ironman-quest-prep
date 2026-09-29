package com.ironquestprep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class GatheringStep
{
    private final AcquisitionRegion region;
    private final String location;
    private final String itemName;
    private final int[] itemIds;
    private final int quantityNeeded;
    private final String instruction;
    private final AcquisitionInfo.MethodType methodType;

    /*
     * Existing single-target navigation.
     *
     * We keep this so everything we've already built
     * continues working.
     */
    private final GatheringTarget target;

    /*
     * Optional multi-stage acquisition route.
     *
     * Example:
     *
     * Ball of wool
     *
     * Stage 1:
     * Shear sheep
     *
     * Stage 2:
     * Spin wool
     */
    private final List<GatheringStage> stages;

    /*
     * =====================================================
     * STANDARD CONSTRUCTOR
     * =====================================================
     */

    public GatheringStep(
            AcquisitionRegion region,
            String location,
            String itemName,
            int[] itemIds,
            int quantityNeeded,
            String instruction,
            AcquisitionInfo.MethodType methodType)
    {
        this(
                region,
                location,
                itemName,
                itemIds,
                quantityNeeded,
                instruction,
                methodType,
                GatheringTarget.none(),
                Collections.emptyList()
        );
    }

    /*
     * =====================================================
     * SINGLE-TARGET CONSTRUCTOR
     * =====================================================
     */

    public GatheringStep(
            AcquisitionRegion region,
            String location,
            String itemName,
            int[] itemIds,
            int quantityNeeded,
            String instruction,
            AcquisitionInfo.MethodType methodType,
            GatheringTarget target)
    {
        this(
                region,
                location,
                itemName,
                itemIds,
                quantityNeeded,
                instruction,
                methodType,
                target,
                Collections.emptyList()
        );
    }

    /*
     * =====================================================
     * FULL CONSTRUCTOR
     * =====================================================
     */

    public GatheringStep(
            AcquisitionRegion region,
            String location,
            String itemName,
            int[] itemIds,
            int quantityNeeded,
            String instruction,
            AcquisitionInfo.MethodType methodType,
            GatheringTarget target,
            List<GatheringStage> stages)
    {
        this.region =
                region == null
                        ? AcquisitionRegion.UNKNOWN
                        : region;

        this.location =
                location == null
                        ? ""
                        : location.trim();

        this.itemName =
                itemName == null
                        ? ""
                        : itemName.trim();

        this.itemIds =
                itemIds == null
                        ? new int[0]
                        : itemIds.clone();

        this.quantityNeeded =
                Math.max(
                        0,
                        quantityNeeded
                );

        this.instruction =
                instruction == null
                        ? ""
                        : instruction.trim();

        this.methodType =
                methodType == null
                        ? AcquisitionInfo.MethodType.UNKNOWN
                        : methodType;

        this.target =
                target == null
                        ? GatheringTarget.none()
                        : target;

        if (stages == null
                || stages.isEmpty())
        {
            this.stages =
                    Collections.emptyList();
        }
        else
        {
            List<GatheringStage> safeStages =
                    new ArrayList<>();

            for (GatheringStage stage : stages)
            {
                if (stage != null)
                {
                    safeStages.add(
                            stage
                    );
                }
            }

            this.stages =
                    Collections.unmodifiableList(
                            safeStages
                    );
        }
    }

    /*
     * =====================================================
     * BASIC DATA
     * =====================================================
     */

    public AcquisitionRegion getRegion()
    {
        return region;
    }

    public String getLocation()
    {
        return location;
    }

    public String getItemName()
    {
        return itemName;
    }

    public int[] getItemIds()
    {
        return itemIds.clone();
    }

    public int getQuantityNeeded()
    {
        return quantityNeeded;
    }

    public String getInstruction()
    {
        return instruction;
    }

    public AcquisitionInfo.MethodType getMethodType()
    {
        return methodType;
    }

    /*
     * =====================================================
     * NORMAL SINGLE TARGET
     * =====================================================
     */

    public GatheringTarget getTarget()
    {
        return target;
    }

    public boolean hasNavigationTarget()
    {
        return target != null
                && target.isNavigable();
    }

    /*
     * =====================================================
     * MULTI-STAGE ROUTE
     * =====================================================
     */

    public List<GatheringStage> getStages()
    {
        return stages;
    }

    public boolean hasStages()
    {
        return !stages.isEmpty();
    }

    /*
     * Returns the first stage which has not yet been
     * completed.
     */
    public GatheringStage getCurrentStage(
            BankTracker bankTracker)
    {
        if (stages.isEmpty())
        {
            return null;
        }

        for (GatheringStage stage : stages)
        {
            /*
             * A stage without an inventory completion
             * requirement cannot currently auto-complete,
             * so treat it as the active stage.
             */
            if (!stage.hasCompletionRequirement())
            {
                return stage;
            }

            if (!stage.isComplete(
                    bankTracker))
            {
                return stage;
            }
        }

        /*
         * Every tracked stage is complete.
         */
        return null;
    }

    public boolean areAllStagesComplete(
            BankTracker bankTracker)
    {
        if (stages.isEmpty())
        {
            return false;
        }

        for (GatheringStage stage : stages)
        {
            if (!stage.hasCompletionRequirement())
            {
                return false;
            }

            if (!stage.isComplete(
                    bankTracker))
            {
                return false;
            }
        }

        return true;
    }

    /*
     * Gives future route code the destination for whatever
     * stage the player should currently be doing.
     *
     * Non-multi-stage items simply use the old target.
     */
    public GatheringTarget getCurrentTarget(
            BankTracker bankTracker)
    {
        GatheringStage currentStage =
                getCurrentStage(
                        bankTracker
                );

        if (currentStage != null
                && currentStage.getTarget() != null)
        {
            return currentStage.getTarget();
        }

        return target;
    }

    /*
     * =====================================================
     * COPY HELPERS
     * =====================================================
     */

    public GatheringStep withTarget(
            GatheringTarget newTarget)
    {
        return new GatheringStep(
                region,
                location,
                itemName,
                itemIds,
                quantityNeeded,
                instruction,
                methodType,
                newTarget,
                stages
        );
    }

    public GatheringStep withStages(
            List<GatheringStage> newStages)
    {
        return new GatheringStep(
                region,
                location,
                itemName,
                itemIds,
                quantityNeeded,
                instruction,
                methodType,
                target,
                newStages
        );
    }

    public GatheringStep withTargetAndStages(
            GatheringTarget newTarget,
            List<GatheringStage> newStages)
    {
        return new GatheringStep(
                region,
                location,
                itemName,
                itemIds,
                quantityNeeded,
                instruction,
                methodType,
                newTarget,
                newStages
        );
    }
}