package com.ironquestprep;

import java.util.Arrays;
import java.util.List;
import net.runelite.api.gameval.ItemID;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrepItemListsTest {
    @Test public void separatesSourcesWithoutChangingAreasOrPartialRequirements() {
        RequiredItem shop = item(AcquisitionInfo.MethodType.SHOP);
        RequiredItem gather = item(AcquisitionInfo.MethodType.GATHER);
        List<RequiredItem> items = Arrays.asList(shop, gather);
        BankTracker bank = owned(1);
        assertEquals(Arrays.asList(shop), PrepItemLists.missingForSection(items, bank, true));
        assertEquals(Arrays.asList(gather), PrepItemLists.missingForSection(items, bank, false));
        assertSame(shop, PrepItemLists.missingForSection(items, bank, true).get(0));
        assertEquals(1, shop.getMissingQuantity(bank));
    }

    @Test public void fullQuantityHidesItemsAndShortfallRestoresThem() {
        for (AcquisitionInfo.MethodType type : AcquisitionInfo.MethodType.values()) {
            List<RequiredItem> items = Arrays.asList(item(type));
            boolean shopping = type == AcquisitionInfo.MethodType.SHOP;
            assertTrue(PrepItemLists.missingForSection(items, owned(2), shopping).isEmpty());
            assertEquals(items, PrepItemLists.missingForSection(items, owned(0), shopping));
            assertTrue(PrepItemLists.missingForSection(items, owned(0), !shopping).isEmpty());
        }
    }

    private RequiredItem item(AcquisitionInfo.MethodType type) {
        return new RequiredItem("test", new int[]{ItemID.WOODPLANK}, "Planks", 2,
                new AcquisitionInfo("Obtain planks", AcquisitionRegion.ANYWHERE, "Test shop", type), true, "");
    }

    private BankTracker owned(int quantity) {
        return new BankTracker() {
            @Override public int getQuantity(int id) { return quantity; }
        };
    }
}
