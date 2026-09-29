package com.ironquestprep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import net.runelite.api.Item;
import net.runelite.api.ItemContainer;

public class BankTracker
{
    private final Map<Integer, Integer> bankItems =
            new HashMap<>();

    private final Map<Integer, Integer> groupStorageItems =
            new HashMap<>();

    private final Map<Integer, Integer> inventoryItems =
            new HashMap<>();

    private boolean bankScanned = false;
    private boolean groupStorageScanned = false;
    private boolean inventoryScanned = false;

    /*
     * =====================================================
     * SCANNING
     * =====================================================
     */

    public void scanBank(
            ItemContainer bank)
    {
        if (bank == null)
        {
            bankItems.clear();
            bankScanned = false;
            return;
        }

        scanContainer(
                bank,
                bankItems
        );

        bankScanned = true;
    }

    public void scanGroupStorage(
            ItemContainer groupStorage)
    {
        if (groupStorage == null)
        {
            groupStorageItems.clear();
            groupStorageScanned = false;
            return;
        }

        scanContainer(
                groupStorage,
                groupStorageItems
        );

        groupStorageScanned = true;
    }

    public void scanInventory(
            ItemContainer inventory)
    {
        if (inventory == null)
        {
            inventoryItems.clear();
            inventoryScanned = false;
            return;
        }

        scanContainer(
                inventory,
                inventoryItems
        );

        inventoryScanned = true;
    }

    private void scanContainer(
            ItemContainer container,
            Map<Integer, Integer> destination)
    {
        destination.clear();

        for (Item item
                : container.getItems())
        {
            if (item == null)
            {
                continue;
            }

            if (item.getId() <= 0
                    || item.getQuantity() <= 0)
            {
                continue;
            }

            destination.merge(
                    item.getId(),
                    item.getQuantity(),
                    Integer::sum
            );
        }
    }

    /*
     * =====================================================
     * TOTAL OWNERSHIP
     * =====================================================
     *
     * Anything asking:
     *
     * "Does the player own this?"
     *
     * sees:
     *
     * bank
     * + group storage
     * + inventory
     */

    public int getQuantity(
            int itemId)
    {
        long total =
                (long) getBankQuantity(
                        itemId
                )
                        + getGroupStorageQuantity(
                        itemId
                )
                        + getInventoryQuantity(
                        itemId
                );

        if (total > Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }

        return (int) total;
    }

    public int getBankQuantity(
            int itemId)
    {
        return bankItems.getOrDefault(
                itemId,
                0
        );
    }

    public int getGroupStorageQuantity(
            int itemId)
    {
        return groupStorageItems.getOrDefault(
                itemId,
                0
        );
    }

    public int getInventoryQuantity(
            int itemId)
    {
        return inventoryItems.getOrDefault(
                itemId,
                0
        );
    }

    public boolean hasItem(
            int itemId)
    {
        return getQuantity(
                itemId
        ) > 0;
    }

    public boolean hasQuantity(
            int itemId,
            int quantity)
    {
        return getQuantity(
                itemId
        ) >= quantity;
    }

    /*
     * =====================================================
     * BANK SUMMARY
     * =====================================================
     *
     * Deliberately excludes inventory.
     *
     * The sidebar says "Bank", so carrying an item should
     * affect quest readiness but should not change the
     * displayed bank totals.
     */

    public int getUniqueItemCount()
    {
        Set<Integer> uniqueItems =
                new HashSet<>();

        uniqueItems.addAll(
                bankItems.keySet()
        );

        uniqueItems.addAll(
                groupStorageItems.keySet()
        );

        return uniqueItems.size();
    }

    public long getTotalItemCount()
    {
        long total = 0;

        for (int quantity
                : bankItems.values())
        {
            total += quantity;
        }

        for (int quantity
                : groupStorageItems.values())
        {
            total += quantity;
        }

        return total;
    }

    /*
     * =====================================================
     * SCAN STATUS
     * =====================================================
     */

    public boolean hasScannedBank()
    {
        return bankScanned;
    }

    public boolean hasScannedGroupStorage()
    {
        return groupStorageScanned;
    }

    public boolean hasScannedInventory()
    {
        return inventoryScanned;
    }

    /*
     * =====================================================
     * ACCOUNT / PLUGIN RESET
     * =====================================================
     */

    public void clear()
    {
        bankItems.clear();
        groupStorageItems.clear();
        inventoryItems.clear();

        bankScanned = false;
        groupStorageScanned = false;
        inventoryScanned = false;
    }
}