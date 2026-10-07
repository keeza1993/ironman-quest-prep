package com.ironquestprep;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.swing.*;
import net.runelite.api.Skill;
import net.runelite.client.game.SkillIconManager;

final class QuestSkillsPanel extends JPanel
{
    private QuestSkillPlanner.Plan plan;
    private final Set<Skill> expanded = new HashSet<>();
    private boolean showOrder;
    private boolean showNotes;
    private final SkillIconManager icons = new SkillIconManager();
    private static final Skill[] DISPLAY_ORDER = {
        Skill.ATTACK, Skill.HITPOINTS, Skill.MINING,
        Skill.STRENGTH, Skill.AGILITY, Skill.SMITHING,
        Skill.DEFENCE, Skill.HERBLORE, Skill.FISHING,
        Skill.RANGED, Skill.THIEVING, Skill.COOKING,
        Skill.PRAYER, Skill.CRAFTING, Skill.FIREMAKING,
        Skill.MAGIC, Skill.FLETCHING, Skill.WOODCUTTING,
        Skill.RUNECRAFT, Skill.SLAYER, Skill.FARMING,
        Skill.CONSTRUCTION, Skill.HUNTER
    };
    private final NumberFormat numbers = NumberFormat.getIntegerInstance(Locale.UK);

    QuestSkillsPanel()
    {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        render();
    }

    void setPlan(QuestSkillPlanner.Plan snapshot)
    {
        if (snapshot == plan) return;
        if (snapshot == null) expanded.clear();
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

    private JButton skillTile(Skill skill)
    {
        int level = QuestSkillPlanner.level(plan.current.getOrDefault(skill, 0L));
        int target = plan.targets.getOrDefault(skill, 1);
        boolean selected = expanded.contains(skill);
        Color ink = target == 1 ? new Color(205, 199, 180)
                : level >= target ? new Color(145, 220, 120) : new Color(255, 218, 110);
        JButton tile = new JButton();
        tile.setLayout(new BorderLayout(3, 0));
        tile.setBackground(selected ? new Color(91, 79, 55) : new Color(62, 57, 47));
        tile.setOpaque(true);
        tile.setContentAreaFilled(true);
        tile.setFocusPainted(true);
        tile.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(selected ? new Color(225, 187, 92) : new Color(113, 99, 72)),
                BorderFactory.createEmptyBorder(3, 4, 3, 4)));
        tile.add(new JLabel(new ImageIcon(icons.getSkillImage(skill, true))), BorderLayout.WEST);
        JPanel levels = new JPanel(new GridLayout(2, 1));
        levels.setOpaque(false);
        JLabel current = new JLabel(Integer.toString(level), SwingConstants.CENTER);
        JLabel required = new JLabel(target == 1 ? "—" : Integer.toString(target), SwingConstants.CENTER);
        current.setFont(current.getFont().deriveFont(Font.BOLD, 13f));
        required.setFont(required.getFont().deriveFont(Font.BOLD, 13f));
        current.setForeground(ink);
        required.setForeground(ink);
        current.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(139, 122, 83)));
        levels.add(current);
        levels.add(required);
        tile.add(levels, BorderLayout.CENTER);
        String description = skill.getName() + ": current level " + level
                + (target == 1 ? ", no level requirement" : ", cape requirement " + target);
        tile.setToolTipText(description + ". Click to " + (selected ? "hide" : "show") + " XP and quest rewards.");
        tile.getAccessibleContext().setAccessibleName(description);
        tile.addActionListener(event -> {
            boolean wasSelected = expanded.contains(skill);
            expanded.clear();
            if (!wasSelected) expanded.add(skill);
            render();
        });
        return tile;
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
        line("Current level <b>above</b> / cape requirement <b>below</b>. Click a skill for XP and rewards.");
        JPanel grid = new JPanel(new GridLayout(0, 3, 3, 3));
        grid.setAlignmentX(Component.LEFT_ALIGNMENT);
        grid.setOpaque(false);
        for (Skill skill : DISPLAY_ORDER) grid.add(skillTile(skill));
        // Include new client skills without silently dropping them from the panel.
        for (Skill skill : Skill.values())
            if (skill != Skill.OVERALL && !java.util.Arrays.asList(DISPLAY_ORDER).contains(skill))
                grid.add(skillTile(skill));
        int rows = (grid.getComponentCount() + 2) / 3;
        grid.setPreferredSize(new Dimension(210, rows * 49));
        grid.setMaximumSize(new Dimension(Integer.MAX_VALUE, rows * 49));
        add(grid);
        line("Green = target met. Gold = below target. — = no level requirement.");
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
            if (!expanded.contains(skill)) continue;
            line("<b>" + skill.getName() + "</b> — level " + QuestSkillPlanner.level(current)
                    + " / " + (target == 1 ? "—" : target));
            line(target == 1 ? "No separate skill-level requirement."
                    : (complete ? "Training left after planned rewards: " : "Training in partial plan: ")
                    + "<b>" + n(training) + " XP</b>");
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
        JButton notes = IronQuestprepPanel.createModeButton(showNotes ? "Hide planning notes" : "Planning notes");
        IronQuestprepPanel.styleModeButton(notes, showNotes);
        notes.addActionListener(event -> { showNotes = !showNotes; render(); });
        add(notes);
        if (showNotes)
        {
            line("Conservative base-level targets, without boosts. Training estimates include fixed quest XP in the planned order.");
            line("This is a skill plan, not a fastest route. Combat ability, items and access still need checking.");
            line("Choice lamps and XP from already-started quests are not deducted. Completed rewards are already in your current XP.");
        }
        JButton order = IronQuestprepPanel.createModeButton(showOrder ? "Hide quest order" : "Full quest order");
        IronQuestprepPanel.styleModeButton(order, showOrder);
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
