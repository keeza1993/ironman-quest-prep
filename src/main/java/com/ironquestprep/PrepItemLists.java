package com.ironquestprep;

import java.util.ArrayList;
import java.util.List;

/** Keeps each missing requirement in exactly one acquisition section. */
final class PrepItemLists {
    private PrepItemLists() {}

    static List<RequiredItem> missingForSection(
            List<RequiredItem> items, BankTracker bank, boolean shopping) {
        List<RequiredItem> result = new ArrayList<>();
        for (RequiredItem item : items) {
            if (!item.isComplete(bank)
                    && (item.getMethodType() == AcquisitionInfo.MethodType.SHOP) == shopping) {
                result.add(item);
            }
        }
        return result;
    }
}
