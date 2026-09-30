package com.ironquestprep;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/** Normal-stock starter supplies. Source: OSRS Wiki, Lumbridge General Store, 30 Sep 2026. */
final class ShopSupplyCatalog {
    private static final Set<String> LUMBRIDGE = new HashSet<>(Arrays.asList(
            "ItemID.POT_EMPTY", "ItemID.JUG_EMPTY", "ItemID.SHEARS", "ItemID.KNIFE",
            "ItemID.BUCKET_EMPTY", "ItemID.BOWL_EMPTY", "ItemID.CAKE_TIN", "ItemID.TINDERBOX",
            "ItemID.CHISEL", "ItemID.SPADE", "ItemID.HAMMER"));

    static AcquisitionInfo preferredSource(String symbol) {
        if (!LUMBRIDGE.contains(symbol)) return null;
        return new AcquisitionInfo("Buy from Lumbridge General Store; other sources are also available.",
                AcquisitionRegion.MISTHALIN, "Lumbridge General Store", AcquisitionInfo.MethodType.SHOP);
    }
}
