# Add Ironman Quest Prep

Ironman Quest Prep provides quest item checklists, Ironman acquisition advice, manually selected gathering destinations and quest-cape skill planning. It combines reusable requirements, compares bank/inventory ownership, and filters known quest-issued or locked supplies.

The skills panel shows current levels above cape requirements, with expandable training and quest reward details. Navigation includes minimap arrows, blue route text, world-map destinations and specific NPC/object targets where available. A Discord button opens the owner's support server only when clicked; it does not automatically submit reports or account data.

The plugin uses the standard build, adds no production dependencies and performs no gameplay input automation. Quest Helper-derived data retains its BSD attribution. README limitations cover conservative quest gates, started rewards, lamps and access requirements.

## Review-size reduction

In response to the 232,972-token review error, generated records now share identical default metadata and use a compact layout. Exception records keep their full explicit fields. All 1,129 items, 97 advisories and 61 groups are preserved, including every field and their order, verified by a SHA-256 fingerprint captured from the pre-change Java data. Separately committed formatting compacts unusually expanded Java without changing code tokens. No data was removed or hidden from review.

## Validation

Clean local build and 56 automated tests pass against cached RuneLite 1.13.0, targeting Java 11. The owner ran both UI versions in the development client and approved their appearance. This is visual approval only; full navigation, account-switching and other gameplay edge-case testing is not claimed. GitHub CI and the bot's token count must be checked for the latest submitted commit.

## Follow-up to the 212,096-token result

Further reduced repeated classification and item metadata: 1,129 classifications are grouped into 200 quest/type rows, 1,188 item symbols retain their exact compile-time IDs while storing the namespace once, and common item/advisory records share identical defaults. A second fingerprint regression test verifies the entire classification map, including nested child keys and the unknown-key fallback. The complete quest-data fingerprint remains unchanged. No quests, items, classifications or features were removed. Local tokenizer totals are estimates; the review bot must confirm its own final count.
