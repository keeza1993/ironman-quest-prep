package com.ironquestprep;

import java.util.List;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.api.gameval.ItemID;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuestSuppliesTest {
    private List<QuestItemDatabase.QuestSupplies> dragon(QuestState state, BankTracker bank) {
        return QuestItemDatabase.getQuestSupplies(null, bank,
                quest -> quest == Quest.DRAGON_SLAYER_I ? state : QuestState.FINISHED);
    }

    @Test public void includesStartedAndUnstartedButNotCompletedQuests() {
        BankTracker bank = new BankTracker();
        assertEquals(QuestState.IN_PROGRESS, dragon(QuestState.IN_PROGRESS, bank).get(0).state);
        assertEquals(QuestState.NOT_STARTED, dragon(QuestState.NOT_STARTED, bank).get(0).state);
        assertTrue(dragon(QuestState.FINISHED, bank).isEmpty());
    }

    @Test public void dragonSlayerQuantitiesStaySpecificToThatQuest() {
        List<RequiredItem> items = dragon(QuestState.IN_PROGRESS, new BankTracker()).get(0).items;
        assertEquals(3, items.stream().filter(i -> i.getName().equals("Planks")).findFirst().get().getRequiredQuantity());
        assertEquals(90, items.stream().filter(i -> i.getName().equals("Steel nails")).findFirst().get().getRequiredQuantity());
        assertTrue(items.stream().anyMatch(i -> i.getName().equals("Unfired bowl")));
    }

    @Test public void ownedSuppliesAreExcludedAndPartialQuantitiesAreSubtracted() {
        BankTracker bank = new BankTracker() {
            @Override public int getQuantity(int id) {
                if (id == ItemID.WOODPLANK) return 2;
                if (id == ItemID.NAILS) return 90;
                if (id == ItemID.LOBSTER_POT) return 1;
                return 0;
            }
        };
        List<GatheringStep> steps = GatheringRouteBuilder.build(dragon(QuestState.IN_PROGRESS, bank).get(0).items, bank);
        assertFalse(steps.stream().anyMatch(s -> s.getItemName().equals("Steel nails")));
        assertFalse(steps.stream().anyMatch(s -> s.getItemName().equals("Lobster pot")));
        assertEquals(1, steps.stream().filter(s -> s.getItemName().equals("Planks")).findFirst().get().getQuantityNeeded());
        assertTrue(steps.stream().allMatch(s -> !s.getInstruction().isEmpty()));
    }
}
