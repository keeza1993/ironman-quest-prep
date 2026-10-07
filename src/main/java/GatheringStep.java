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

    private final GatheringTarget target;

    private final List<GatheringStage> stages;

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

    public GatheringTarget getTarget()
    {
        return target;
    }

    public boolean hasNavigationTarget()
    {
        return target != null
                && target.isNavigable();
    }

    public List<GatheringStage> getStages()
    {
        return stages;
    }

    public boolean hasStages()
    {
        return !stages.isEmpty();
    }

    public GatheringStage getCurrentStage(
            BankTracker bankTracker)
    {
        if (stages.isEmpty())
        {
            return null;
        }

        for (GatheringStage stage : stages)
        {

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
