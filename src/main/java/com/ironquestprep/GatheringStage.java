package com.ironquestprep;

import java.util.ArrayList;

import java.util.Collections;

import java.util.List;

public final class GatheringStage {

    private final String name;

    private final String instruction;

    private final GatheringTarget target;

    private final int[] completionItemIds;

    private final int completionQuantity;

    private final List<GatheringPrerequisite> prerequisites;

    public GatheringStage(

            String name,

            String instruction,

            GatheringTarget target,

            int[] completionItemIds,

            int completionQuantity) {

        this(

                name,

                instruction,

                target,

                completionItemIds,

                completionQuantity,

                Collections.emptyList());

    }

    public GatheringStage(

            String name,

            String instruction,

            GatheringTarget target,

            int[] completionItemIds,

            int completionQuantity,

            List<GatheringPrerequisite> prerequisites) {

        this.name = name == null ? "" : name.trim();

        this.instruction = instruction == null ? "" : instruction.trim();

        this.target = target == null ? GatheringTarget.none() : target;

        this.completionItemIds = completionItemIds == null ? new int[0] : completionItemIds.clone();

        this.completionQuantity = Math.max(0, completionQuantity);

        if (prerequisites == null || prerequisites.isEmpty()) {

            this.prerequisites = Collections.emptyList();

        } else {

            List<GatheringPrerequisite> safePrerequisites = new ArrayList<>();

            for (GatheringPrerequisite prerequisite : prerequisites) {

                if (prerequisite != null) {

                    safePrerequisites.add(prerequisite);

                }

            }

            this.prerequisites = Collections.unmodifiableList(safePrerequisites);

        }

    }

    public static GatheringStage itemStage(

            String name,

            String instruction,

            GatheringTarget target,

            int completionItemId,

            int completionQuantity) {

        return new GatheringStage(

                name,

                instruction,

                target,

                new int[] {completionItemId},

                completionQuantity,

                Collections.emptyList());

    }

    public static GatheringStage itemStage(

            String name,

            String instruction,

            GatheringTarget target,

            int completionItemId,

            int completionQuantity,

            List<GatheringPrerequisite> prerequisites) {

        return new GatheringStage(

                name,

                instruction,

                target,

                new int[] {completionItemId},

                completionQuantity,

                prerequisites);

    }

    public static GatheringStage navigationOnly(

            String name, String instruction, GatheringTarget target) {

        return new GatheringStage(

                name, instruction, target, new int[0], 0, Collections.emptyList());

    }

    public String getName() {

        return name;

    }

    public String getInstruction() {

        return instruction;

    }

    public GatheringTarget getTarget() {

        return target;

    }

    public int[] getCompletionItemIds() {

        return completionItemIds.clone();

    }

    public int getCompletionQuantity() {

        return completionQuantity;

    }

    public List<GatheringPrerequisite> getPrerequisites() {

        return prerequisites;

    }

    public boolean hasNavigationTarget() {

        return target != null && target.isNavigable();

    }

    public boolean hasCompletionRequirement() {

        return completionItemIds.length > 0 && completionQuantity > 0;

    }

    public boolean isComplete(BankTracker bankTracker) {

        if (bankTracker == null) {

            return false;

        }

        if (!hasCompletionRequirement()) {

            return false;

        }

        long owned = 0;

        for (int itemId : completionItemIds) {

            if (itemId <= 0) {

                continue;

            }

            owned += bankTracker.getQuantity(itemId);

            if (owned >= completionQuantity) {

                return true;

            }

        }

        return false;

    }

    public int getOwnedQuantity(BankTracker bankTracker) {

        if (bankTracker == null) {

            return 0;

        }

        long owned = 0;

        for (int itemId : completionItemIds) {

            if (itemId <= 0) {

                continue;

            }

            owned += bankTracker.getQuantity(itemId);

        }

        if (owned > Integer.MAX_VALUE) {

            return Integer.MAX_VALUE;

        }

        return (int) owned;

    }

    public int getMissingQuantity(BankTracker bankTracker) {

        if (!hasCompletionRequirement()) {

            return 0;

        }

        return Math.max(completionQuantity - getOwnedQuantity(bankTracker), 0);

    }

    public boolean hasPrerequisites() {

        return !prerequisites.isEmpty();

    }

    public boolean arePrerequisitesSatisfied(BankTracker bankTracker) {

        if (prerequisites.isEmpty()) {

            return true;

        }

        for (GatheringPrerequisite prerequisite : prerequisites) {

            if (!prerequisite.isSatisfied(bankTracker)) {

                return false;

            }

        }

        return true;

    }

    public List<GatheringPrerequisite> getMissingPrerequisites(BankTracker bankTracker) {

        if (prerequisites.isEmpty()) {

            return Collections.emptyList();

        }

        List<GatheringPrerequisite> missing = new ArrayList<>();

        for (GatheringPrerequisite prerequisite : prerequisites) {

            if (!prerequisite.isSatisfied(bankTracker)) {

                missing.add(prerequisite);

            }

        }

        return Collections.unmodifiableList(missing);

    }

    public String getPrerequisiteStatusText(BankTracker bankTracker) {

        if (prerequisites.isEmpty()) {

            return "";

        }

        StringBuilder text = new StringBuilder();

        for (GatheringPrerequisite prerequisite : prerequisites) {

            if (text.length() > 0) {

                text.append(", ");

            }

            text.append(prerequisite.getItemName());

            text.append(" ");

            text.append(

                    Math.min(

                            prerequisite.getOwnedQuantity(bankTracker),

                            prerequisite.getQuantityRequired()));

            text.append("/");

            text.append(prerequisite.getQuantityRequired());

        }

        return text.toString();

    }

}
