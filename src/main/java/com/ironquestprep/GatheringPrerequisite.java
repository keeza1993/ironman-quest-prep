package com.ironquestprep;

public final class GatheringPrerequisite
{
    private final String itemName;
    private final int[] itemIds;
    private final int quantityRequired;
    private final String instruction;

    /*
     * true:
     * The item is turned into / consumed while making the
     * target item.
     *
     * Example:
     * Empty pot -> Pot of flour
     *
     * false:
     * The item is merely a reusable tool.
     *
     * Example:
     * Hammer
     */
    private final boolean consumed;

    public GatheringPrerequisite(
            String itemName,
            int[] itemIds,
            int quantityRequired,
            String instruction,
            boolean consumed)
    {
        this.itemName =
                itemName == null
                        ? ""
                        : itemName.trim();

        this.itemIds =
                itemIds == null
                        ? new int[0]
                        : itemIds.clone();

        this.quantityRequired =
                Math.max(
                        0,
                        quantityRequired
                );

        this.instruction =
                instruction == null
                        ? ""
                        : instruction.trim();

        this.consumed =
                consumed;
    }

    /*
     * Convenience constructor for one specific item ID.
     */
    public GatheringPrerequisite(
            String itemName,
            int itemId,
            int quantityRequired,
            String instruction,
            boolean consumed)
    {
        this(
                itemName,
                new int[]
                        {
                                itemId
                        },
                quantityRequired,
                instruction,
                consumed
        );
    }

    public String getItemName()
    {
        return itemName;
    }

    public int[] getItemIds()
    {
        return itemIds.clone();
    }

    public int getQuantityRequired()
    {
        return quantityRequired;
    }

    public String getInstruction()
    {
        return instruction;
    }

    public boolean isConsumed()
    {
        return consumed;
    }

    /*
     * Ownership uses the same combined BankTracker count:
     *
     * bank
     * + Group Ironman storage
     * + inventory
     */
    public int getOwnedQuantity(
            BankTracker bankTracker)
    {
        if (bankTracker == null)
        {
            return 0;
        }

        long owned =
                0;

        for (int itemId : itemIds)
        {
            if (itemId <= 0)
            {
                continue;
            }

            owned +=
                    bankTracker.getQuantity(
                            itemId
                    );

            if (owned >= Integer.MAX_VALUE)
            {
                return Integer.MAX_VALUE;
            }
        }

        return (int) owned;
    }

    public int getMissingQuantity(
            BankTracker bankTracker)
    {
        return Math.max(
                quantityRequired
                        - getOwnedQuantity(
                        bankTracker
                ),
                0
        );
    }

    public boolean isSatisfied(
            BankTracker bankTracker)
    {
        return getMissingQuantity(
                bankTracker
        ) <= 0;
    }

    public boolean hasItemIds()
    {
        return itemIds.length > 0;
    }
}