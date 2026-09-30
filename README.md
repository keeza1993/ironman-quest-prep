# Ironman Quest Prep

A RuneLite plugin for planning quest supplies, choosing gathering destinations, and estimating skill training towards the quest cape.

## Features

- **Checklist:** combines item requirements for unfinished quests with scanned bank and inventory ownership. Reusable tools use the maximum required quantity rather than one extra tool per quest.
- **Gathering Route:** groups missing supplies by destination, with a selected world-map destination and the native game hint arrow. Exact targets take priority over general locations; Kourend and Varlamore each retain one general destination.
- **Quest Cape Skills:** shows conservative base-level targets and estimates training XP after fixed quest rewards. Expand a skill to see reward quests and training steps.

Open your bank to populate the item checklist. The skills section needs only a logged-in account. Click **Show destination on map** on a gathering step to enable guidance and set its world-map pin and native flashing hint arrow. Select another step to replace the destination; disable **Route guidance** to clear it. Skills refresh on login, then after every 30 minutes of logged-in play. The **Report a bug (Discord)** button opens the support server in your browser when clicked.

## Limitations

This is an early release. Please report incorrect items, destinations or XP estimates with the quest name, quest stage and expected result.

- Gather-now filtering covers known quest-source gates, not every item, skill, shop or area restriction. Some sources wait conservatively until their source quest is finished.
- Guidance points to destinations; it is not collision-aware pathfinding.
- Skill targets do not assume temporary boosts. Combat ability, combat and combined-level gates, items and access still need checking.
- The XP order uses a greedy training estimate, not a proven fastest or minimum-training route.
- Choice lamps and separately claimed single-skill lamps are not deducted automatically.
- Started quests' rewards are excluded to avoid counting XP already earned during the quest twice.
- Recipe for Disaster is grouped as one quest; partially completed subquests are handled conservatively.
- The bundled data is a snapshot and needs maintenance when quests change.

The plugin does not automate gameplay, transmit account data, or save login credentials. Bank ownership is held in memory and cleared when accounts change or the plugin stops.

## Development

The build targets Java 11 bytecode. The included Gradle 9.6 wrapper requires a Java 17 or newer runtime; local validation used Java 17. Plugin Hub uses the standard build configuration.

On Windows, from the project directory:

    .\gradlew.bat build
    .\gradlew.bat run

For a Jagex Account, follow [RuneLite's development login guide](https://github.com/runelite/runelite/wiki/Using-Jagex-Accounts). Never commit or share credential files.

Tests cover navigation selection, requirement quantities, source unlocks, item symbol resolution and quest reward ordering. A passing build does not establish correct in-game behavior.

## Data and licensing

Quest data is derived from the [Quest Helper](https://github.com/Zoinkwiz/quest-helper) local source snapshot extracted on 28 September 2026. See THIRD-PARTY-NOTICES.md and LICENSE-QuestHelper.

Project code is provided under the BSD 2-Clause License. This project is not endorsed by RuneLite or Jagex.
