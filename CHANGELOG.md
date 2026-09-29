# Changelog

## 0.1.1 — performance update

- Cache ground-item labels instead of scanning all requirements for every frame lookup.
- Batch ownership-triggered checklist/route refreshes to one game-tick update.
- Cache immutable requirement metadata and reuse skill plans when their inputs are unchanged.
- Avoid rebuilding hidden sidebar contents and unchanged skill views.
- 58 automated tests pass, including cache invalidation and original data integrity checks.
- Released for affected users to evaluate; no claim of verified FPS improvement on older hardware.
## 0.1.0 — initial release candidate

- Quest item checklist with reusable-tool quantities and known source unlock filters.
- Gathering destination guidance with exact-target priority.
- Quest Cape Skills grid with current levels above requirements and expandable fixed-reward XP planning.
- Pink-and-white quest compass and full-width section buttons with selected styling.
- Discord report-a-bug button, opened only on user click.
- Pulsing minimap direction arrow for nearby and distant destinations, steady-arrow option, and blue route text.
- Plugin Hub metadata, reflection-free item lookup and event-driven NPC tracking.
- Compact generated quest metadata: all 1,129 items, 97 advisories and 61 groups preserved field-for-field and in order.
- 56 automated tests, including a complete-data fingerprint regression check.
- User approved both UI iterations visually in the development client. Full gameplay edge-case verification is not claimed.
- Further grouped identical classification and advisory metadata; full classification-map fingerprint verified.
