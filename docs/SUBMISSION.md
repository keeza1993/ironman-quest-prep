# Plugin Hub submission checklist

Prepared 29 September 2026. This is a source release candidate, not an approved or published Plugin Hub release.

## Validation completed

- Fixed the nonexistent plugin class in runelite-plugin.properties.
- Renamed the entry class and config class to QuestPrepPlugin / QuestPrepConfig.
- Retained the existing config group and plugin-enabled config name.
- Enabled Plugin Hub standard build mode, with no added production dependencies.
- Replaced runtime reflection with 1,188 compile-time item symbol references.
- Replaced stdout diagnostics with debug logging.
- Replaced per-frame full NPC enumeration with spawn/change/despawn tracking and an ID-indexed cache.
- Added BSD licensing and Quest Helper attribution.
- Replaced the template README with real features, setup and known limitations.
- Clean offline build passed with 51 tests on cached RuneLite 1.13.0; Java 11 bytecode, Java 17 build runtime.
- Release source omits Git history, IDE files, build caches, personal instructions and old ZIP exports.
- No production reflection, process execution, network or disk IO was found in the source audit.

These checks are preparation, not the RuneLite maintainers' approval or their current CI result.

## Required manual testing

Extract this COMPLETE project into a new folder. Do not merge it onto the old project: the plugin and config classes have been renamed, and keeping the old Java files could load duplicate plugins.

Run .\gradlew.bat run from this folder. For Jagex Accounts use:
https://github.com/runelite/runelite/wiki/Using-Jagex-Accounts

Record the results below before publishing:

- [ ] Plugin loads once and can be toggled off/on.
- [ ] Existing settings survive the renamed entry/config classes.
- [ ] Bank scan, inventory changes and account switching update/clear ownership correctly.
- [ ] Gather-now list excludes known locked quest items and retains ordinary supplies.
- [ ] Reusable axes combine correctly; consumed quantities remain correct.
- [ ] Exact destinations beat general locations; Kourend and Varlamore remain one general destination each.
- [ ] World, minimap and world-map guidance follow a selected destination.
- [ ] NPC highlight appears, disappears when the NPC despawns, and recovers after region changes/hops.
- [ ] Disabling the plugin removes overlays and map markers.
- [ ] Quest Cape Skills opens without a bank scan and matches current XP.
- [ ] Completed rewards are not counted twice, and training precedes the quest reward.
- [ ] Logout/account switch clears the previous skills view.

Project instructions require user-run in-game testing; the agent has not performed these checks.

## Publishing

The baseline remote is https://github.com/keeza1993/imth3keeza0.git. Confirm that this is the public repository you intend to use. No remote was changed or pushed during preparation.

1. Publish the tested candidate source to your chosen public repository.
2. Record the full 40-character commit hash of that published source.
3. Fork https://github.com/runelite/plugin-hub and add plugins/ironman-quest-prep with two lines:
   repository=https://github.com/keeza1993/imth3keeza0.git
   commit=THE_ACTUAL_PUBLISHED_40_CHARACTER_COMMIT_HASH
4. Use hub-pr-description.md as the submission description. Update the manual testing statement with your actual results.
5. Open the pull request, check its build/check results and address reviewer feedback.

Do not submit a placeholder commit hash or the baseline's old commit: neither identifies these changes.

Official process: https://github.com/runelite/plugin-hub#submitting-a-plugin

## Weekly releases

Develop privately in your local workspace or a private repository. Publish only the tested release source to the public repository, update the version and changelog, then submit the new commit hash to Plugin Hub. Review timing determines when users receive it; weekly availability is not guaranteed.
