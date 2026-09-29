> Superseded: the owner approved including these UI changes in the initial submission on 29 September 2026. They are no longer reserved for a future update. The review-size fix is included too; check the current PR for validation status.

# First update preview — 29 September 2026

Local branch: codex/first-update-ui. Nothing from this update has been pushed.

## Implemented, awaiting manual verification
- Pink-and-white code-drawn quest compass for toolbar and heading.
- Three full-width section buttons with selected styling.
- Report a bug opens https://discord.gg/SzTtmUkv3 through RuneLite LinkBrowser only when clicked. No report or game data is automatically sent.
- Invite metadata verified: IronQuestHelper server, report-a-bug channel. This invite expires 29 October 2026 at 11:19 UTC. Replace with an owner-supplied non-expiring invite before release.
- Minimap guidance uses a pink arrow for nearby and distant destinations, clipped to the minimap circle. It pulses once per second without fully disappearing. Disable Flash minimap arrow for a steady arrow. Existing route guidance toggle remains unchanged.
- Route HUD and NPC label text use blue. The old HUD direction arrow is removed. Tile/NPC highlight colors remain pink.
- Automated tests: 53 passed after clean offline build. Standalone sidebar preview inspected without controlling RuneScape.

## User checks
1. Restart development client. Confirm toolbar icon and all three section buttons; switch among sections and check selected state.
2. Click Report a bug and confirm your Discord destination.
3. Enable Route guidance, choose a nearby destination and a distant one. Check arrow, minimap rotation/zoom, fixed/resized layouts and blue writing.
4. Toggle Flash minimap arrow off. Confirm the arrow stays steady.
5. Check upstairs destinations and region/hop changes. Disable the plugin or log out and confirm guidance clears.
6. Confirm approved skill grid and XP details still work.

## Current release review blocker
https://github.com/runelite/plugin-hub/pull/17331#issuecomment-5888459342
Reviewer reports: `too many tokens: 232972`; bot requires under 200,000 tokens. This affects the already-submitted initial release, not just this local preview. No fix has been published or claimed.
Largest source file: GeneratedQuestData.java (~683 KB), with very expanded generated records. Investigate a reviewable, behavior-preserving representation and verify every data record plus tests before submitting a reduction. Keep any initial-release fix separate from this future UI branch.

Feedback checked: submission conversation, review summaries and inline comments; source repository issues (all states). No player issues or other actionable review reports were returned at the time of this check. Discord messages were not accessible or reviewed. Recheck after release.