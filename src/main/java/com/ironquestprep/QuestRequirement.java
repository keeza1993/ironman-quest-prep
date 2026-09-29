package com.ironquestprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import net.runelite.api.Quest;

public class QuestRequirement
{
    private final String sourceKey;
    private final Quest quest;
    private final List<RequiredItem> items;
    private final List<RequirementGroup> groups;
    private final List<String> rootRequirements;
    private final List<String> advisories;

    /*
     * Existing constructor.
     *
     * This keeps the current manually-written QuestItemDatabase
     * completely compatible while we build the generated database.
     */
    public QuestRequirement(
            Quest quest,
            RequiredItem... items)
    {
        this(
                quest == null ? "" : quest.name(),
                quest,
                Arrays.asList(items),
                Collections.emptyList(),
                Collections.emptyList(),
                Collections.emptyList()
        );
    }

    /*
     * Constructor used by generated quest data.
     */
    public QuestRequirement(
            String sourceKey,
            Quest quest,
            List<RequiredItem> items,
            List<RequirementGroup> groups,
            List<String> rootRequirements,
            List<String> advisories)
    {
        this.sourceKey =
                sourceKey == null
                        ? ""
                        : sourceKey;

        this.quest = quest;

        this.items = Collections.unmodifiableList(
                new ArrayList<>(items)
        );

        this.groups = Collections.unmodifiableList(
                new ArrayList<>(groups)
        );

        this.rootRequirements = Collections.unmodifiableList(
                new ArrayList<>(rootRequirements)
        );

        this.advisories = Collections.unmodifiableList(
                new ArrayList<>(advisories)
        );
    }

    public String getSourceKey()
    {
        return sourceKey;
    }

    public Quest getQuest()
    {
        return quest;
    }

    public List<RequiredItem> getItems()
    {
        return items;
    }

    public List<RequirementGroup> getGroups()
    {
        return groups;
    }

    public List<String> getRootRequirements()
    {
        return rootRequirements;
    }

    public List<String> getAdvisories()
    {
        return advisories;
    }

    public boolean hasGeneratedStructure()
    {
        return !groups.isEmpty()
                || !rootRequirements.isEmpty()
                || !advisories.isEmpty();
    }
}