package com.ironquestprep;

import java.util.LinkedHashSet;
import java.util.Set;

public class RequiredItem
{
    private final String key;
    private final int[] itemIds;
    private final String name;
    private final int requiredQuantity;
    private final AcquisitionInfo acquisitionInfo;
    private final boolean consumed;
    private final String condition;

    /*
     * Backwards-compatible constructor.
     */
    public RequiredItem(
            int itemId,
            String name,
            int requiredQuantity,
            String bestMethod)
    {
        this(
                "",
                new int[]{itemId},
                name,
                requiredQuantity,
                AcquisitionInfo.unknown(bestMethod),
                true,
                ""
        );
    }

    /*
     * Backwards-compatible constructor.
     */
    public RequiredItem(
            int itemId,
            String name,
            int requiredQuantity,
            String bestMethod,
            boolean consumed)
    {
        this(
                "",
                new int[]{itemId},
                name,
                requiredQuantity,
                AcquisitionInfo.unknown(bestMethod),
                consumed,
                ""
        );
    }

    /*
     * Backwards-compatible constructor for alternates.
     */
    public RequiredItem(
            int[] itemIds,
            String name,
            int requiredQuantity,
            String bestMethod,
            boolean consumed)
    {
        this(
                "",
                itemIds,
                name,
                requiredQuantity,
                AcquisitionInfo.unknown(bestMethod),
                consumed,
                ""
        );
    }

    /*
     * Backwards-compatible full constructor used by
     * existing generated/database code.
     */
    public RequiredItem(
            String key,
            int[] itemIds,
            String name,
            int requiredQuantity,
            String bestMethod,
            boolean consumed,
            String condition)
    {
        this(
                key,
                itemIds,
                name,
                requiredQuantity,
                AcquisitionInfo.unknown(bestMethod),
                consumed,
                condition
        );
    }

    /*
     * New structured constructor.
     */
    public RequiredItem(
            String key,
            int[] itemIds,
            String name,
            int requiredQuantity,
            AcquisitionInfo acquisitionInfo,
            boolean consumed,
            String condition)
    {
        this.key =
                key == null
                        ? ""
                        : key;

        this.itemIds =
                normaliseItemIds(itemIds);

        this.name =
                name == null
                        ? ""
                        : name;

        this.requiredQuantity =
                requiredQuantity;

        this.acquisitionInfo =
                acquisitionInfo == null
                        ? AcquisitionInfo.unknown("")
                        : acquisitionInfo;

        this.consumed =
                consumed;

        this.condition =
                condition == null
                        ? ""
                        : condition;
    }

    private static int[] normaliseItemIds(
            int[] itemIds)
    {
        if (itemIds == null
                || itemIds.length == 0)
        {
            return new int[0];
        }

        Set<Integer> unique =
                new LinkedHashSet<>();

        for (int itemId : itemIds)
        {
            if (itemId > 0)
            {
                unique.add(itemId);
            }
        }

        int[] result =
                new int[unique.size()];

        int index = 0;

        for (Integer itemId : unique)
        {
            result[index++] =
                    itemId;
        }

        return result;
    }

    public String getKey()
    {
        return key;
    }

    public int getItemId()
    {
        if (itemIds.length == 0)
        {
            return -1;
        }

        return itemIds[0];
    }

    public int[] getItemIds()
    {
        return itemIds.clone();
    }

    public boolean hasAlternates()
    {
        return itemIds.length > 1;
    }

    public boolean hasValidItemId()
    {
        return itemIds.length > 0;
    }

    public String getName()
    {
        return name;
    }

    public int getRequiredQuantity()
    {
        return requiredQuantity;
    }

    /*
     * Kept so the existing panel continues working.
     */
    public String getBestMethod()
    {
        return acquisitionInfo.getMethod();
    }

    public AcquisitionInfo getAcquisitionInfo()
    {
        return acquisitionInfo;
    }

    public AcquisitionRegion getRegion()
    {
        return acquisitionInfo.getRegion();
    }

    public String getLocation()
    {
        return acquisitionInfo.getLocation();
    }

    public AcquisitionInfo.MethodType getMethodType()
    {
        return acquisitionInfo.getMethodType();
    }

    public boolean isConsumed()
    {
        return consumed;
    }

    public String getCondition()
    {
        return condition;
    }

    public boolean hasCondition()
    {
        return !condition.isEmpty();
    }

    /*
     * Adds all acceptable versions from personal bank
     * and GIM storage.
     */
    public int getOwnedQuantity(
            BankTracker bankTracker)
    {
        if (bankTracker == null)
        {
            return 0;
        }

        long total = 0;

        for (int itemId : itemIds)
        {
            total +=
                    bankTracker.getQuantity(
                            itemId
                    );
        }

        if (total > Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }

        return (int) total;
    }

    public boolean isComplete(
            BankTracker bankTracker)
    {
        return getOwnedQuantity(
                bankTracker
        ) >= requiredQuantity;
    }

    public int getMissingQuantity(
            BankTracker bankTracker)
    {
        return Math.max(
                requiredQuantity
                        - getOwnedQuantity(
                        bankTracker
                ),
                0
        );
    }

    public RequiredItem withRequiredQuantity(
            int quantity)
    {
        return new RequiredItem(
                key,
                itemIds,
                name,
                quantity,
                acquisitionInfo,
                consumed,
                condition
        );
    }

    public RequiredItem withAcquisitionInfo(
            AcquisitionInfo info)
    {
        return new RequiredItem(
                key,
                itemIds,
                name,
                requiredQuantity,
                info,
                consumed,
                condition
        );
    }
}