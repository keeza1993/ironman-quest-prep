package com.ironquestprep;

import java.util.*;
import net.runelite.api.Client;
import net.runelite.api.Experience;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.api.Skill;
import net.runelite.api.gameval.VarPlayerID;

/** Pure XP planning: each requirement is paid before its quest reward is applied. */
final class QuestSkillPlanner
{
    static final class QuestData
    {
        final String id;
        final boolean cape;
        final Map<Skill, Integer> levels;
        final Map<Skill, Integer> rewards;
        final Set<String> dependencies;
        final int requiredPoints, points;
        final String notes, choices;

        QuestData(String id, boolean cape, String levels, String rewards, String dependencies,
                  int requiredPoints, int points, String notes, String choices)
        {
            this.id = id;
            this.cape = cape;
            this.levels = parse(levels);
            this.rewards = parse(rewards);
            this.dependencies = dependencies.isEmpty() ? Collections.emptySet()
                    : new LinkedHashSet<>(Arrays.asList(dependencies.split(",")));
            this.requiredPoints = requiredPoints;
            this.points = points;
            this.notes = notes;
            this.choices = choices;
        }

        private static Map<Skill, Integer> parse(String value)
        {
            Map<Skill, Integer> result = new EnumMap<>(Skill.class);
            if (!value.isEmpty())
                for (String part : value.split(","))
                {
                    String[] pair = part.split(":");
                    result.put(Skill.valueOf(pair[0]), Integer.parseInt(pair[1]));
                }
            return Collections.unmodifiableMap(result);
        }
    }

    static final class Step
    {
        final QuestData quest;
        final Map<Skill, Long> training, rewards, after;
        Step(QuestData quest, Map<Skill, Long> training, Map<Skill, Long> rewards, Map<Skill, Long> after)
        {
            this.quest = quest;
            this.training = Collections.unmodifiableMap(new EnumMap<>(training));
            this.rewards = Collections.unmodifiableMap(new EnumMap<>(rewards));
            this.after = Collections.unmodifiableMap(new EnumMap<>(after));
        }
    }

    static final class Plan
    {
        final Map<Skill, Integer> targets = new EnumMap<>(Skill.class);
        final Map<Skill, Integer> remainingTargets = new EnumMap<>(Skill.class);
        final Map<Skill, Long> current = new EnumMap<>(Skill.class);
        final Map<Skill, Long> training = new EnumMap<>(Skill.class);
        final List<Step> steps = new ArrayList<>();
        final List<String> unresolved = new ArrayList<>();
        final List<String> unavailable = new ArrayList<>();
        final Map<Skill, String> targetQuests = new EnumMap<>(Skill.class);
    }

    private static final List<QuestData> DATA = GeneratedQuestSkills.load();

    static Plan snapshot(Client client)
    {
        Map<Skill, Long> xp = new EnumMap<>(Skill.class);
        for (Skill skill : Skill.values())
            if (skill != Skill.OVERALL) xp.put(skill, (long) client.getSkillExperience(skill));
        Set<String> finished = new HashSet<>();
        Set<String> started = new HashSet<>();
        List<QuestData> supported = new ArrayList<>();
        List<String> unavailable = new ArrayList<>();
        for (QuestData data : DATA)
        {
            try
            {
                Quest quest = Quest.valueOf(data.id);
                QuestState state = quest.getState(client);
                supported.add(data);
                if (state == QuestState.FINISHED) finished.add(data.id);
                else if (state == QuestState.IN_PROGRESS) started.add(data.id);
            }
            catch (IllegalArgumentException exception)
            {
                // Do not silently describe an older client's incomplete data as a full cape plan.
                unavailable.add(data.id);
            }
        }
        Plan plan = calculate(supported, xp, finished, started, client.getVarpValue(VarPlayerID.QP));
        plan.unavailable.addAll(unavailable);
        return plan;
    }

    static Plan calculate(List<QuestData> data, Map<Skill, Long> current,
                          Set<String> finished, Set<String> started, int questPoints)
    {
        Plan plan = new Plan();
        plan.current.putAll(current);
        Map<String, QuestData> index = new LinkedHashMap<>();
        for (QuestData q : data) index.put(q.id, q);
        Set<String> needed = new LinkedHashSet<>();
        for (QuestData q : data) if (q.cape) collect(q.id, index, needed);
        for (String id : needed)
        {
            QuestData q = index.get(id);
            if (q == null) continue;
            if (!finished.contains(id))
                for (Map.Entry<Skill, Integer> requirement : q.levels.entrySet())
                    plan.remainingTargets.merge(requirement.getKey(), requirement.getValue(), Math::max);
            for (Map.Entry<Skill, Integer> requirement : q.levels.entrySet())
                if (requirement.getValue() > plan.targets.getOrDefault(requirement.getKey(), 1))
                {
                    plan.targets.put(requirement.getKey(), requirement.getValue());
                    plan.targetQuests.put(requirement.getKey(), q.id);
                }
        }
        Set<String> done = new HashSet<>(finished);
        Map<Skill, Long> xp = new EnumMap<>(Skill.class);
        xp.putAll(current);
        List<QuestData> pending = new ArrayList<>();
        for (QuestData q : data) if (needed.contains(q.id) && !done.contains(q.id)) pending.add(q);
        int points = questPoints;
        while (!pending.isEmpty())
        {
            QuestData best = null;
            long bestCost = Long.MAX_VALUE;
            for (QuestData q : pending)
            {
                if (!done.containsAll(q.dependencies) || points < q.requiredPoints) continue;
                long cost = 0;
                for (Map.Entry<Skill, Integer> req : q.levels.entrySet())
                    cost += Math.max(0, threshold(req.getValue()) - xp.getOrDefault(req.getKey(), 0L));
                if (cost < bestCost || (cost == bestCost && (best == null || q.id.compareTo(best.id) < 0)))
                {
                    best = q;
                    bestCost = cost;
                }
            }
            if (best == null)
            {
                for (QuestData q : pending) plan.unresolved.add(q.id);
                break;
            }
            Map<Skill, Long> train = new EnumMap<>(Skill.class);
            Map<Skill, Long> reward = new EnumMap<>(Skill.class);
            for (Map.Entry<Skill, Integer> req : best.levels.entrySet())
            {
                long amount = Math.max(0, threshold(req.getValue()) - xp.getOrDefault(req.getKey(), 0L));
                if (amount > 0)
                {
                    train.put(req.getKey(), amount);
                    plan.training.merge(req.getKey(), amount, Long::sum);
                    xp.merge(req.getKey(), amount, Long::sum);
                }
            }
            // In-quest XP may already be included in live XP. Until stage-specific
            // remaining rewards are mapped, exclude rewards of started quests.
            if (!started.contains(best.id))
                for (Map.Entry<Skill, Integer> gain : best.rewards.entrySet())
                {
                    reward.put(gain.getKey(), gain.getValue().longValue());
                    xp.merge(gain.getKey(), gain.getValue().longValue(), Long::sum);
                }
            plan.steps.add(new Step(best, train, reward, xp));
            if (!("RECIPE_FOR_DISASTER".equals(best.id) && started.contains(best.id))) points += best.points;
            done.add(best.id);
            pending.remove(best);
        }
        return plan;
    }

    private static void collect(String id, Map<String, QuestData> data, Set<String> needed)
    {
        if (!needed.add(id)) return;
        QuestData q = data.get(id);
        if (q != null) for (String dependency : q.dependencies) collect(dependency, data, needed);
    }

    static long threshold(int level) { return Experience.getXpForLevel(level); }
    static int level(long xp) { return Experience.getLevelForXp((int) Math.min(200_000_000L, xp)); }

    static String name(String id)
    {
        try { return Quest.valueOf(id).getName(); }
        catch (IllegalArgumentException exception) { return id.replace('_', ' '); }
    }
}
