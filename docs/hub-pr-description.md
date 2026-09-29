# Add Ironman Quest Prep

Ironman Quest Prep provides quest item checklists, Ironman acquisition advice, manually selected gathering destinations and quest-cape skill planning. It combines reusable requirements, compares bank/inventory ownership, and filters known quest-issued or locked supplies.

The skills panel shows current levels above cape requirements, with expandable training and quest reward details. Navigation includes minimap arrows, blue route text, world-map destinations and specific NPC/object targets where available. A Discord button opens the owner's support server only when clicked; it does not automatically submit reports or account data.

The plugin uses the standard build, adds no production dependencies and performs no gameplay input automation. Quest Helper-derived data retains its BSD attribution. README limitations cover conservative quest gates, started rewards, lamps and access requirements.

## Review-size reduction

In response to the 232,972-token review error, generated records now share identical default metadata and use a compact layout. Exception records keep their full explicit fields. All 1,129 items, 97 advisories and 61 groups are preserved, including every field and their order, verified by a SHA-256 fingerprint captured from the pre-change Java data. Separately committed formatting compacts unusually expanded Java without changing code tokens. No data was removed or hidden from review.

## Validation

Clean local build and 54 automated tests pass against cached RuneLite 1.13.0, targeting Java 11. The owner ran both UI versions in the development client and approved their appearance. This is visual approval only; full navigation, account-switching and other gameplay edge-case testing is not claimed. GitHub CI and the bot's token count must be checked for the latest submitted commit.