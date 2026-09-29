# Third-party notices

GeneratedQuestData, GeneratedPrepClassification, GeneratedQuestMappings, GeneratedItemCollections, GeneratedAcquisitionAdvice and GeneratedQuestSkills include facts or structured data derived from the user's local Quest Helper source snapshot. Quest Helper: https://github.com/Zoinkwiz/quest-helper. Its BSD 2-Clause license is retained in LICENSE-QuestHelper.

GeneratedItemIds references named constants from RuneLite's gameval ItemID API at compile time. It contains only the symbols used by this bundled dataset. Regenerate this lookup when adding new symbolic item references. Unknown symbols resolve to no item, so verify all new source symbols before release.

RuneLite dependencies are resolved during the build and are not bundled into the Plugin Hub plugin JAR.
