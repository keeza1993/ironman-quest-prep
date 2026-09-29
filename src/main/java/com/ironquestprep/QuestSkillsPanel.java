package com.ironquestprep;

import java.awt.Color;
import java.awt.Component;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.swing.*;
import net.runelite.api.Skill;

final class QuestSkillsPanel extends JPanel
{
    private QuestSkillPlanner.Plan plan;
    private final Set<Skill> expanded = new HashSet<>();
    private boolean showOrder;
    private final NumberFormat numbers = NumberFormat.getIntegerInstance(Locale.UK);

    QuestSkillsPanel()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        render();
    }

    void setPlan(QuestSkillPlanner.Plan snapshot)
    {
        plan = snapshot;
        render();
    }

    private void line(String text)
    {
        JLabel label = new JLabel("<html><body style='width:205px'>" + text + "</body></html>");
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setBorder(BorderFactory.createEmptyBorder(3, 0, 3, 0));
        add(label);
    }

    private String n(long value) { return numbers.format(value); }
    private static String escape(String text)
    {
        return text.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }

    private void render()
    {
        removeAll();
        line("<b>Quest Cape Skills</b>");
        if (plan == null)
        {
            line("Log in to load your skills and quest progress. No bank scan needed.");
            revalidate(); repaint(); return;
        }
        boolean complete = plan.unresolved.isEmpty() && plan.unavailable.isEmpty();
        line("Conservative base-level targets, without boosts. Training estimates include fixed quest XP in the order below.");
        line("This is a skill plan, not a fastest route. Combat ability, items and access still need checking.");
        line("Choice lamps and XP from already-started quests are not deducted. Completed rewards are already in your current XP.");
        if (!complete)
            line("<b>Partial plan:</b> " + plan.unresolved.size() + " quests could not be ordered; "
                    + plan.unavailable.size() + " are unsupported by this client. Training totals below are partial.");
        for (Skill skill : Skill.values())
        {
            if (skill == Skill.OVERALL) continue;
            long current = plan.current.getOrDefault(skill, 0L);
            int target = plan.targets.getOrDefault(skill, 1);
            int remainingTarget = plan.remainingTargets.getOrDefault(skill, 1);
            long baseline = Math.max(0, QuestSkillPlanner.threshold(remainingTarget) - current);
            long training = plan.training.getOrDefault(skill, 0L);
            JButton button = new JButton((expanded.contains(skill) ? "- " : "+ ") + skill.getName()
                    + "  " + QuestSkillPlanner.level(current) + " / " + (target == 1 ? "—" : target));
            button.setAlignmentX(Component.LEFT_ALIGNMENT);
            button.setForeground(baseline == 0 ? new Color(115, 215, 140) : Color.WHITE);
            button.addActionListener(event -> {
                if (!expanded.add(skill)) expanded.remove(skill);
                render();
            });
            add(button);
            line(target == 1 ? "No separate skill-level requirement."
                    : (complete ? "Training left in this plan: " : "Training in partial plan: ") + "<b>" + n(training) + " XP</b>");
            if (!expanded.contains(skill)) continue;
            line("Current XP: " + n(current)
                    + "<br>Gap for unfinished quests: " + n(baseline) + " XP"
                    + (complete ? "<br>Training saved by planned rewards: " + n(Math.max(0, baseline - training)) + " XP" : ""));
            if (target > 1) line("Target required by: " + escape(QuestSkillPlanner.name(plan.targetQuests.get(skill))));
            int stepNumber = 0;
            boolean any = false;
            for (QuestSkillPlanner.Step step : plan.steps)
            {
                stepNumber++;
                long train = step.training.getOrDefault(skill, 0L);
                long reward = step.rewards.getOrDefault(skill, 0L);
                if (train == 0 && reward == 0) continue;
                any = true;
                line("<b>" + stepNumber + ". " + escape(QuestSkillPlanner.name(step.quest.id)) + "</b>"
                        + (train > 0 ? "<br>Before quest: train " + n(train) + " XP." : "")
                        + (reward > 0 ? "<br>Quest reward: +" + n(reward) + " XP." : "")
                        + "<br>After this step: level " + QuestSkillPlanner.level(step.after.getOrDefault(skill, current)));
            }
            if (!any) line("No training or fixed quest rewards planned for this skill.");
        }
        JButton order = new JButton(showOrder ? "Hide quest order" : "Show full quest order & lamps");
        order.setAlignmentX(Component.LEFT_ALIGNMENT);
        order.addActionListener(event -> { showOrder = !showOrder; render(); });
        add(order);
        if (showOrder)
        {
            int number = 0;
            for (QuestSkillPlanner.Step step : plan.steps)
            {
                line("<b>" + (++number) + ". " + escape(QuestSkillPlanner.name(step.quest.id)) + "</b>");
                for (Skill skill : step.training.keySet())
                    line("Train " + skill.getName() + ": " + n(step.training.get(skill)) + " XP before this quest.");
                if (!step.quest.notes.isEmpty()) line(escape(step.quest.notes));
                if (!step.quest.choices.isEmpty()) line("Not deducted: " + escape(step.quest.choices));
            }
            for (String id : plan.unresolved) line("Not ordered: " + escape(QuestSkillPlanner.name(id)));
            for (String id : plan.unavailable) line("Unsupported: " + escape(id));
        }
        revalidate(); repaint();
    }
}
