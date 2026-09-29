package com.ironquestprep;

import java.util.*;

/** Prepared on ownership/requirement changes, never by the frame renderer. */
final class GroundItemLabels {
    private Map<Integer, String> labels = Collections.emptyMap();

    void rebuild(List<RequiredItem> requirements, BankTracker bank) {
        Map<Integer, String> next = new HashMap<>();
        for (RequiredItem item : requirements) {
            int missing = item.getMissingQuantity(bank);
            if (missing <= 0) continue;
            String label = item.getName() + " [Need " + missing + "]";
            for (int id : item.getItemIds()) next.putIfAbsent(id, label);
        }
        labels = next;
    }
    String get(int id) { return labels.get(id); }
    boolean isEmpty() { return labels.isEmpty(); }
    void clear() { labels = Collections.emptyMap(); }
}
