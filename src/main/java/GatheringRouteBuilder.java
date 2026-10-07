package com.ironquestprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.ObjectID;

public final class GatheringRouteBuilder {

    private static volatile WorldPoint routeOrigin;

    private GatheringRouteBuilder() {}

    public static List<GatheringStep> build(
            List<RequiredItem> requirements, BankTracker bankTracker) {
        WorldPoint origin = routeOrigin;

        if (origin == null) {
            return buildBaseSteps(requirements, bankTracker);
        }

        return build(requirements, bankTracker, origin);
    }

    public static List<GatheringStep> build(
            List<RequiredItem> requirements, BankTracker bankTracker, WorldPoint playerLocation) {
        if (playerLocation != null) {
            routeOrigin = playerLocation;
        }

        List<GatheringStep> baseSteps = buildBaseSteps(requirements, bankTracker);

        if (playerLocation == null || baseSteps.isEmpty()) {
            return baseSteps;
        }

        List<GatheringStep> navigable = new ArrayList<>();

        List<GatheringStep> unresolved = new ArrayList<>();

        for (GatheringStep step : baseSteps) {
            if (step != null
                    && step.hasNavigationTarget()
                    && step.getTarget() != null
                    && step.getTarget().getWorldPoint() != null) {
                navigable.add(step);
            } else {
                unresolved.add(step);
            }
        }

        if (navigable.isEmpty()) {
            return baseSteps;
        }

        List<GatheringStep> ordered = buildNearestRoute(navigable, playerLocation);

        ordered.addAll(unresolved);

        return ordered;
    }

    private static List<GatheringStep> buildBaseSteps(
            List<RequiredItem> requirements, BankTracker bankTracker) {
        List<GatheringStep> steps = new ArrayList<>();

        if (requirements == null || bankTracker == null) {
            return steps;
        }

        for (RequiredItem item : requirements) {
            if (item == null) {
                continue;
            }

            int missing = item.getMissingQuantity(bankTracker);

            if (missing <= 0) {
                continue;
            }

            AcquisitionRegion region = item.getRegion();

            if (region == null) {
                region = AcquisitionRegion.UNKNOWN;
            }

            String location = normaliseLocation(item, region);

            String instruction = item.getBestMethod();

            if (instruction == null || instruction.trim().isEmpty()) {
                instruction = "Obtain " + missing + " x " + item.getName() + ".";
            }

            GatheringStep baseStep =
                    new GatheringStep(
                            region,
                            location,
                            item.getName(),
                            item.getItemIds(),
                            missing,
                            instruction,
                            item.getMethodType());

            GatheringTarget target = GatheringTargetResolver.resolve(baseStep);

            GatheringStep finalStep = baseStep.withTarget(target);

            finalStep = applyMultiStageRoute(finalStep, item.getRequiredQuantity(), bankTracker);

            steps.add(finalStep);
        }

        steps.sort(baseComparator());

        return steps;
    }

    private static GatheringStep applyMultiStageRoute(
            GatheringStep step, int totalRequired, BankTracker bankTracker) {
        if (step == null) {
            return null;
        }

        // A recipe must not replace an explicitly selected shop or spawn route.
        if (step.getMethodType() != AcquisitionInfo.MethodType.CRAFT
                && step.getMethodType() != AcquisitionInfo.MethodType.GATHER) {
            return step;
        }

        String itemName = safeText(step.getItemName());

        if (itemName.equalsIgnoreCase("Ball of wool")) {
            int quantityRequired = Math.max(1, totalRequired);

            int[] finalItemIds = step.getItemIds();

            int[] woolOrBalls = combineIds(new int[] {ItemID.WOOL}, finalItemIds);

            GatheringStage shearStage =
                    new GatheringStage(
                            "Shear sheep",
                            "Shear sheep in the field north of Lumbridge until you have enough wool.",
                            GatheringTarget.area(
                                    "Lumbridge sheep field", new WorldPoint(3201, 3268, 0)),
                            woolOrBalls,
                            quantityRequired);

            GatheringStage spinStage =
                    new GatheringStage(
                            "Spin wool",
                            "Use the spinning wheel upstairs in Lumbridge Castle to spin the wool into balls of wool.",
                            GatheringTarget.object(
                                    ObjectID.SPINNINGWHEEL,
                                    "Lumbridge Castle spinning wheel",
                                    new WorldPoint(3209, 3212, 1)),
                            finalItemIds,
                            quantityRequired);

            GatheringStep staged = step.withStages(Arrays.asList(shearStage, spinStage));

            return exposeCurrentStage(staged, bankTracker);
        }

        if (itemName.equalsIgnoreCase("Pot of flour")) {
            int finalQuantityRequired = Math.max(1, totalRequired);

            int productionQuantity = Math.max(1, step.getQuantityNeeded());

            int[] finalItemIds = step.getItemIds();

            GatheringStage potStage =
                    new GatheringStage(
                            "Get empty pots",
                            "Get enough empty pots to collect the flour. Buy any missing pots from the Lumbridge General Store.",
                            GatheringTarget.area(
                                    "Lumbridge General Store", new WorldPoint(3212, 3246, 0)),
                            new int[] {ItemID.POT_EMPTY},
                            productionQuantity);

            GatheringStage grainStage =
                    new GatheringStage(
                            "Pick grain",
                            "Pick enough wheat from the field beside Mill Lane Mill.",
                            GatheringTarget.area(
                                    "Lumbridge wheat field", new WorldPoint(3161, 3292, 0)),
                            new int[] {ItemID.GRAIN},
                            productionQuantity);

            GatheringPrerequisite emptyPotPrerequisite =
                    new GatheringPrerequisite(
                            "Empty pot",
                            ItemID.POT_EMPTY,
                            productionQuantity,
                            "You need one empty pot for each remaining pot of flour.",
                            true);

            GatheringPrerequisite grainPrerequisite =
                    new GatheringPrerequisite(
                            "Grain",
                            ItemID.GRAIN,
                            productionQuantity,
                            "You need one grain for each remaining pot of flour.",
                            true);

            GatheringStage millStage =
                    new GatheringStage(
                            "Make flour",
                            "Take the grain upstairs, fill the hopper, operate the controls, then return downstairs and collect the flour using the empty pots.",
                            GatheringTarget.area("Mill Lane Mill", new WorldPoint(3166, 3306, 0)),
                            finalItemIds,
                            finalQuantityRequired,
                            Arrays.asList(emptyPotPrerequisite, grainPrerequisite));

            GatheringStep staged = step.withStages(Arrays.asList(potStage, grainStage, millStage));

            return exposeCurrentStage(staged, bankTracker);
        }

        return step;
    }

    private static GatheringStep exposeCurrentStage(GatheringStep staged, BankTracker bankTracker) {
        if (staged == null) {
            return null;
        }

        GatheringStage currentStage = staged.getCurrentStage(bankTracker);

        if (currentStage == null) {
            return staged;
        }

        String stageInstruction = currentStage.getName() + ": " + currentStage.getInstruction();

        if (currentStage.hasCompletionRequirement()) {
            stageInstruction +=
                    " ["
                            + currentStage.getOwnedQuantity(bankTracker)
                            + "/"
                            + currentStage.getCompletionQuantity()
                            + "]";
        }

        if (currentStage.hasPrerequisites()) {
            String prerequisiteText = currentStage.getPrerequisiteStatusText(bankTracker);

            if (prerequisiteText != null && !prerequisiteText.isEmpty()) {
                stageInstruction += " Requires: " + prerequisiteText + ".";
            }
        }

        return new GatheringStep(
                staged.getRegion(),
                staged.getLocation(),
                staged.getItemName(),
                staged.getItemIds(),
                staged.getQuantityNeeded(),
                stageInstruction,
                staged.getMethodType(),
                currentStage.getTarget(),
                staged.getStages());
    }

    private static int[] combineIds(int[] first, int[] second) {
        int firstLength = first == null ? 0 : first.length;

        int secondLength = second == null ? 0 : second.length;

        int[] combined = new int[firstLength + secondLength];

        int index = 0;

        if (first != null) {
            for (int id : first) {
                combined[index++] = id;
            }
        }

        if (second != null) {
            for (int id : second) {
                boolean duplicate = false;

                for (int i = 0; i < index; i++) {
                    if (combined[i] == id) {
                        duplicate = true;

                        break;
                    }
                }

                if (!duplicate) {
                    combined[index++] = id;
                }
            }
        }

        if (index == combined.length) {
            return combined;
        }

        return Arrays.copyOf(combined, index);
    }

    private static List<GatheringStep> buildNearestRoute(
            List<GatheringStep> input, WorldPoint startPoint) {
        List<GatheringStep> remaining = new ArrayList<>(input);

        List<GatheringStep> ordered = new ArrayList<>();

        WorldPoint currentPoint = startPoint;

        while (!remaining.isEmpty()) {
            GatheringStep nearest = findNearestStep(remaining, currentPoint);

            if (nearest == null) {
                break;
            }

            ordered.add(nearest);

            remaining.remove(nearest);

            WorldPoint targetPoint = nearest.getTarget().getWorldPoint();

            if (targetPoint != null) {
                currentPoint = targetPoint;
            }
        }

        ordered.addAll(remaining);

        return ordered;
    }

    private static GatheringStep findNearestStep(List<GatheringStep> steps, WorldPoint from) {
        GatheringStep best = null;

        long bestDistance = Long.MAX_VALUE;

        for (GatheringStep step : steps) {
            if (step == null || step.getTarget() == null) {
                continue;
            }

            WorldPoint destination = step.getTarget().getWorldPoint();

            if (destination == null) {
                continue;
            }

            long distance = distanceScore(from, destination);

            if (distance < bestDistance) {
                best = step;

                bestDistance = distance;

                continue;
            }

            if (distance == bestDistance && best != null && compareSteps(step, best) < 0) {
                best = step;
            }
        }

        return best;
    }

    private static long distanceScore(WorldPoint first, WorldPoint second) {
        if (first == null || second == null) {
            return Long.MAX_VALUE;
        }

        long deltaX = Math.abs((long) first.getX() - second.getX());

        long deltaY = Math.abs((long) first.getY() - second.getY());

        long distance = Math.max(deltaX, deltaY);

        if (first.getPlane() != second.getPlane()) {
            distance += 10000L;
        }

        return distance;
    }

    private static Comparator<GatheringStep> baseComparator() {
        return new Comparator<GatheringStep>() {
            @Override
            public int compare(GatheringStep first, GatheringStep second) {
                return compareSteps(first, second);
            }
        };
    }

    private static int compareSteps(GatheringStep first, GatheringStep second) {
        int regionCompare =
                Integer.compare(
                        first.getRegion().getSortOrder(), second.getRegion().getSortOrder());

        if (regionCompare != 0) {
            return regionCompare;
        }

        int locationCompare =
                String.CASE_INSENSITIVE_ORDER.compare(
                        safeText(first.getLocation()), safeText(second.getLocation()));

        if (locationCompare != 0) {
            return locationCompare;
        }

        return String.CASE_INSENSITIVE_ORDER.compare(
                safeText(first.getItemName()), safeText(second.getItemName()));
    }

    private static String normaliseLocation(RequiredItem item, AcquisitionRegion region) {
        String location = item.getLocation();

        if (location != null && !location.trim().isEmpty()) {
            return location.trim();
        }

        if (region == AcquisitionRegion.UNKNOWN) {
            return "Unresearched items";
        }

        if (region == AcquisitionRegion.ANYWHERE) {
            return "Any suitable location";
        }

        return "General / multiple locations";
    }

    private static String safeText(String value) {
        return value == null ? "" : value.trim();
    }
}
