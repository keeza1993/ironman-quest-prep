package com.ironquestprep;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("ironquesthelper")
public interface QuestPrepConfig extends Config
{
	@ConfigItem(
			keyName = "showGroundMarkers",
			name = "Pink ground markers",
			description = "Show pink ground markers for quest-prep items you still need",
			position = 0
	)
	default boolean showGroundMarkers()
	{
		return true;
	}

	@ConfigItem(
			keyName = "routeGuidance",
			name = "Route guidance",
			description = "Show navigation markers, arrows, NPCs and locations for gathering routes",
			position = 1
	)
	default boolean routeGuidance()
	{
		return false;
	}
    @ConfigItem(
            keyName = "flashMinimapArrow",
            name = "Flash minimap arrow",
            description = "Gently pulse the route arrow once per second. Turn off for a steady arrow.",
            position = 2
    )
    default boolean flashMinimapArrow()
    {
        return true;
    }
}