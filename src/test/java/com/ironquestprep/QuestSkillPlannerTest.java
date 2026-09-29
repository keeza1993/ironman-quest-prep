package com.ironquestprep;

import java.util.*;
import net.runelite.api.Quest;
import net.runelite.api.Skill;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuestSkillPlannerTest
{
    private QuestSkillPlanner.QuestData q(String id, String level, String reward, String deps)
    { return new QuestSkillPlanner.QuestData(id, true, level, reward, deps, 0, 1, "", ""); }
    private Map<Skill, Long> xp(long thieving)
    {
        Map<Skill, Long> xp = new EnumMap<>(Skill.class);
        xp.put(Skill.THIEVING, thieving);
        return xp;
    }
    private QuestSkillPlanner.Plan plan(List<QuestSkillPlanner.QuestData> quests, long xp)
    { return QuestSkillPlanner.calculate(quests, xp(xp), Collections.emptySet(), Collections.emptySet(), 0); }

    @Test public void twoRewardsCanRemoveTrainingGap()
    {
        long goal = QuestSkillPlanner.threshold(30);
        QuestSkillPlanner.Plan p = plan(Arrays.asList(
                q("C", "THIEVING:30", "", "B"),
                q("B", "", "THIEVING:5000", "A"),
                q("A", "", "THIEVING:5000", "")), goal - 10000);
        assertEquals(0L, p.training.getOrDefault(Skill.THIEVING, 0L).longValue());
        assertEquals("A", p.steps.get(0).quest.id);
        assertEquals("B", p.steps.get(1).quest.id);
        assertEquals("C", p.steps.get(2).quest.id);
    }

    @Test public void ownRewardCannotPayItsEntryRequirement()
    {
        QuestSkillPlanner.Plan p = plan(Collections.singletonList(q("A", "THIEVING:70", "THIEVING:100000", "")), 0);
        assertEquals(QuestSkillPlanner.threshold(70), p.training.get(Skill.THIEVING).longValue());
    }

    @Test public void dependentRewardCannotPayEarlierRequirement()
    {
        QuestSkillPlanner.Plan p = plan(Arrays.asList(q("A", "THIEVING:30", "", ""),
                q("B", "", "THIEVING:100000", "A")), 0);
        assertEquals(QuestSkillPlanner.threshold(30), p.training.get(Skill.THIEVING).longValue());
    }

    @Test public void completedQuestRewardIsNotCountedTwice()
    {
        QuestSkillPlanner.Plan p = QuestSkillPlanner.calculate(Arrays.asList(q("A", "", "THIEVING:10000", ""),
                q("B", "THIEVING:30", "", "A")), xp(10000), Collections.singleton("A"), Collections.emptySet(), 1);
        assertEquals(QuestSkillPlanner.threshold(30)-10000, p.training.get(Skill.THIEVING).longValue());
        assertEquals(1, p.steps.size());
    }

    @Test public void startedQuestRewardIsConservativelyExcluded()
    {
        QuestSkillPlanner.Plan p = QuestSkillPlanner.calculate(Arrays.asList(q("A", "", "THIEVING:10000", ""),
                q("B", "THIEVING:30", "", "A")), xp(0), Collections.emptySet(), Collections.singleton("A"), 0);
        assertEquals(QuestSkillPlanner.threshold(30), p.training.get(Skill.THIEVING).longValue());
    }

    @Test public void exactXpWithinLevelIsUsed()
    {
        long current = QuestSkillPlanner.threshold(29)+250;
        QuestSkillPlanner.Plan p = plan(Collections.singletonList(q("A", "THIEVING:30", "", "")), current);
        assertEquals(QuestSkillPlanner.threshold(30)-current, p.training.get(Skill.THIEVING).longValue());
    }

    @Test public void unrelatedMiniquestDoesNotRaiseCapeTargets()
    {
        QuestSkillPlanner.QuestData mini = new QuestSkillPlanner.QuestData("MINI", false, "THIEVING:99", "", "", 0, 0, "", "");
        QuestSkillPlanner.Plan p = plan(Arrays.asList(mini, q("A", "THIEVING:30", "", "")), 0);
        assertEquals(30, p.targets.get(Skill.THIEVING).intValue());
    }

    @Test public void requiredMiniquestIsIncluded()
    {
        QuestSkillPlanner.QuestData mini = new QuestSkillPlanner.QuestData("MINI", false, "THIEVING:40", "", "", 0, 0, "", "");
        QuestSkillPlanner.Plan p = plan(Arrays.asList(mini, q("A", "THIEVING:30", "", "MINI")), 0);
        assertEquals(40, p.targets.get(Skill.THIEVING).intValue());
    }

    @Test public void cyclesAreReportedWithoutInventingRewards()
    {
        QuestSkillPlanner.Plan p = plan(Arrays.asList(q("A", "", "THIEVING:10000", "B"), q("B", "", "", "A")), 0);
        assertEquals(2, p.unresolved.size());
        assertTrue(p.steps.isEmpty());
    }

    @Test public void questPointsGateRewardOrder()
    {
        QuestSkillPlanner.QuestData gated = new QuestSkillPlanner.QuestData("A", true, "", "THIEVING:1000", "", 1, 1, "", "");
        QuestSkillPlanner.Plan p = plan(Arrays.asList(gated, q("B", "", "", "")), 0);
        assertEquals("B", p.steps.get(0).quest.id);
        assertEquals("A", p.steps.get(1).quest.id);
    }

    @Test public void generatedCatalogueResolvesAndCanBeOrdered()
    {
        List<QuestSkillPlanner.QuestData> rows = GeneratedQuestSkills.load();
        assertEquals(198, rows.size());
        for (QuestSkillPlanner.QuestData row : rows) Quest.valueOf(row.id);
        Map<Skill, Long> xp = new EnumMap<>(Skill.class);
        for (Skill skill : Skill.values()) if (skill != Skill.OVERALL) xp.put(skill, 0L);
        QuestSkillPlanner.Plan p = QuestSkillPlanner.calculate(rows, xp, Collections.emptySet(), Collections.emptySet(), 0);
        assertEquals(Collections.emptyList(), p.unresolved);
        assertEquals(72, p.targets.get(Skill.THIEVING).intValue());
        assertEquals(75, p.targets.get(Skill.MAGIC).intValue());
        assertTrue(p.training.get(Skill.THIEVING) < QuestSkillPlanner.threshold(72));
        System.out.println("Catalogue: " + rows.size() + "; ordered cape/prerequisite quests: " + p.steps.size());
    }

    @Test public void maxedAccountNeedsNoTraining()
    {
        Map<Skill, Long> xp = new EnumMap<>(Skill.class);
        for (Skill skill : Skill.values()) if (skill != Skill.OVERALL) xp.put(skill, 200000000L);
        QuestSkillPlanner.Plan p = QuestSkillPlanner.calculate(GeneratedQuestSkills.load(), xp, Collections.emptySet(), Collections.emptySet(), 0);
        assertTrue(p.training.isEmpty());
    }

    @Test public void completedRequirementsDoNotCreateTrainingOrFalseSavings()
    {
        QuestSkillPlanner.Plan p = QuestSkillPlanner.calculate(
                Collections.singletonList(q("A", "THIEVING:70", "THIEVING:10000", "")),
                xp(1000), Collections.singleton("A"), Collections.emptySet(), 1);
        assertEquals(70, p.targets.get(Skill.THIEVING).intValue());
        assertTrue(p.remainingTargets.isEmpty());
        assertTrue(p.training.isEmpty());
        assertTrue(p.steps.isEmpty());
    }

    @Test public void accountSnapshotsDoNotShareProgress()
    {
        List<QuestSkillPlanner.QuestData> quests = Collections.singletonList(q("A", "THIEVING:30", "", ""));
        QuestSkillPlanner.Plan first = plan(quests, 100000);
        QuestSkillPlanner.Plan second = plan(quests, 0);
        assertTrue(first.training.isEmpty());
        assertEquals(QuestSkillPlanner.threshold(30), second.training.get(Skill.THIEVING).longValue());
        assertEquals(100000L, first.current.get(Skill.THIEVING).longValue());
    }
}
