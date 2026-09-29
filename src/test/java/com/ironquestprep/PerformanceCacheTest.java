package com.ironquestprep;

import java.util.*;
import net.runelite.api.Skill;
import org.junit.Test;
import static org.junit.Assert.*;

public class PerformanceCacheTest {
    @Test public void groundLabelsPreservePriorityAndRefreshOwnership() {
        int[] calls = {0};
        int[] owned = {0};
        BankTracker bank = new BankTracker() {
            @Override public int getQuantity(int id) { calls[0]++; return id == 42 ? owned[0] : 0; }
        };
        List<RequiredItem> items = Arrays.asList(
                new RequiredItem(new int[]{42, 43}, "First", 3, "", false),
                new RequiredItem(42, "Second", 9, ""));
        GroundItemLabels labels = new GroundItemLabels();
        labels.rebuild(items, bank);
        int afterBuild = calls[0];
        for (int i = 0; i < 1000; i++) {
            assertEquals("First [Need 3]", labels.get(42));
            assertEquals("First [Need 3]", labels.get(43));
            assertNull(labels.get(999));
        }
        assertEquals("Frame lookups must not recalculate ownership", afterBuild, calls[0]);
        owned[0] = 3;
        labels.rebuild(items, bank);
        assertEquals("Second [Need 6]", labels.get(42));
        assertNull(labels.get(43));
        labels.clear();
        assertTrue(labels.isEmpty());
        assertNull(labels.get(42));
    }

    private QuestSkillPlanner.Input input(long xp, Set<String> finished, Set<String> started, int qp) {
        Map<Skill, Long> levels = new EnumMap<>(Skill.class);
        levels.put(Skill.ATTACK, xp);
        return new QuestSkillPlanner.Input(Collections.emptyList(), levels, finished, started,
                qp, Collections.emptyList());
    }

    @Test public void identicalPlannerInputsReuseTheSamePlan() {
        QuestSkillPlanner.Cache cache = new QuestSkillPlanner.Cache();
        Set<String> empty = Collections.emptySet();
        QuestSkillPlanner.Plan first = cache.update(input(0, empty, empty, 0));
        assertSame(first, cache.update(input(0, empty, empty, 0)));
        QuestSkillPlanner.Plan trained = cache.update(input(100, empty, empty, 0));
        assertNotSame(first, trained);
        assertEquals(Long.valueOf(100), trained.current.get(Skill.ATTACK));
        assertNotSame(trained, cache.update(input(100, empty, Collections.singleton("A"), 0)));
        QuestSkillPlanner.Plan completed = cache.update(input(100, Collections.singleton("A"), empty, 1));
        assertNotSame(completed, cache.update(input(100, Collections.singleton("A"), empty, 2)));
        cache.clear();
        assertNotSame(first, cache.update(input(0, empty, empty, 0)));
    }
}
