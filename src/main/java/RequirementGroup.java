package com.ironquestprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class RequirementGroup
{
    public enum Logic
    {
        AND,
        OR,
        CONDITIONAL
    }

    private final String key;
    private final Logic logic;
    private final String description;
    private final List<String> children;
    private final List<ConditionalBranch> branches;

    public RequirementGroup(
            String key,
            Logic logic,
            String description,
            String... children)
    {
        this(
                key,
                logic,
                description,
                Arrays.asList(children),
                Collections.emptyList()
        );
    }

    public RequirementGroup(
            String key,
            Logic logic,
            String description,
            List<String> children,
            List<ConditionalBranch> branches)
    {
        this.key =
                key == null
                        ? ""
                        : key;

        this.logic =
                logic == null
                        ? Logic.AND
                        : logic;

        this.description =
                description == null
                        ? ""
                        : description;

        this.children = Collections.unmodifiableList(
                new ArrayList<>(children)
        );

        this.branches = Collections.unmodifiableList(
                new ArrayList<>(branches)
        );
    }

    public String getKey()
    {
        return key;
    }

    public Logic getLogic()
    {
        return logic;
    }

    public String getDescription()
    {
        return description;
    }

    public List<String> getChildren()
    {
        return children;
    }

    public List<ConditionalBranch> getBranches()
    {
        return branches;
    }

    public boolean isConditional()
    {
        return logic == Logic.CONDITIONAL;
    }

    public static final class ConditionalBranch
    {
        public enum PredicateKind
        {
            ALWAYS,
            SKILL_RANGE,
            QUEST_FINISHED,
            LOGGED_IN_AND_QUEST_FINISHED
        }

        private final String child;
        private final PredicateKind predicateKind;
        private final String skill;
        private final int minimumLevel;
        private final int maximumLevel;
        private final String quest;
        private final boolean negate;

        private ConditionalBranch(
                String child,
                PredicateKind predicateKind,
                String skill,
                int minimumLevel,
                int maximumLevel,
                String quest,
                boolean negate)
        {
            this.child = child;
            this.predicateKind = predicateKind;
            this.skill = skill == null ? "" : skill;
            this.minimumLevel = minimumLevel;
            this.maximumLevel = maximumLevel;
            this.quest = quest == null ? "" : quest;
            this.negate = negate;
        }

        public static ConditionalBranch always(
                String child)
        {
            return new ConditionalBranch(
                    child,
                    PredicateKind.ALWAYS,
                    "",
                    0,
                    Integer.MAX_VALUE,
                    "",
                    false
            );
        }

        public static ConditionalBranch skillRange(
                String child,
                String skill,
                int minimumLevel,
                int maximumLevel)
        {
            return new ConditionalBranch(
                    child,
                    PredicateKind.SKILL_RANGE,
                    skill,
                    minimumLevel,
                    maximumLevel,
                    "",
                    false
            );
        }

        public static ConditionalBranch questFinished(
                String child,
                String quest)
        {
            return new ConditionalBranch(
                    child,
                    PredicateKind.QUEST_FINISHED,
                    "",
                    0,
                    Integer.MAX_VALUE,
                    quest,
                    false
            );
        }

        public static ConditionalBranch loggedInAndQuestFinished(
                String child,
                String quest,
                boolean negate)
        {
            return new ConditionalBranch(
                    child,
                    PredicateKind.LOGGED_IN_AND_QUEST_FINISHED,
                    "",
                    0,
                    Integer.MAX_VALUE,
                    quest,
                    negate
            );
        }

        public String getChild()
        {
            return child;
        }

        public PredicateKind getPredicateKind()
        {
            return predicateKind;
        }

        public String getSkill()
        {
            return skill;
        }

        public int getMinimumLevel()
        {
            return minimumLevel;
        }

        public int getMaximumLevel()
        {
            return maximumLevel;
        }

        public String getQuest()
        {
            return quest;
        }

        public boolean isNegate()
        {
            return negate;
        }
    }
}