package com.ironquestprep;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.runelite.api.Quest;
import net.runelite.api.gameval.VarPlayerID;
import net.runelite.api.gameval.VarbitID;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrepAvailabilityTest
{
    private static class Progress implements PrepAvailability.Progress
    {
        final Set<Quest> complete = new HashSet<>();
        final Map<Integer, Integer> varps = new HashMap<>();
        final Map<Integer, Integer> varbits = new HashMap<>();
        public boolean finished(Quest quest) { return complete.contains(quest); }
        public int varp(int id) { return varps.getOrDefault(id, 0); }
        public int varbit(int id) { return varbits.getOrDefault(id, 0); }
    }

    private GeneratedQuestData.RawItem raw(String quest, String variable)
    {
        return GeneratedQuestData.getItems().stream()
                .filter(r -> quest.equals(r.getQuest()) && variable.equals(r.getVariable()))
                .findFirst().orElseThrow(() -> new AssertionError(quest + ":" + variable));
    }

    private boolean eligible(String quest, String variable, Progress progress)
    {
        GeneratedQuestData.RawItem row = raw(quest, variable);
        RequiredItem item = QuestItemDatabase.convertItem(quest, row);
        assertNotNull(item);
        return PrepAvailability.canGather(row, item, new BankTracker(), progress);
    }

    @Test public void laterQuestCannotLeakShieldBeforeItsSourceUnlock()
    {
        Progress p = new Progress();
        assertFalse(eligible("DragonSlayerII", "antifireShield", p));
        p.varps.put(VarPlayerID.DRAGONQUEST, 1);
        assertFalse(eligible("DragonSlayerII", "antifireShield", p));
        p.varps.put(VarPlayerID.DRAGONQUEST, 2);
        assertTrue(eligible("DragonSlayerII", "antifireShield", p));
    }

    @Test public void ordinaryDuringQuestSuppliesRemainGatherable()
    {
        Progress p = new Progress();
        assertTrue(eligible("CooksAssistant", "egg", p));
        assertTrue(eligible("CooksAssistant", "milk", p));
        assertTrue(eligible("CooksAssistant", "flour", p));
        assertTrue(eligible("DwarfCannon", "hammer", p));
        assertTrue(eligible("InAidOfTheMyreque", "bronzeAxes10", p));
    }

    @Test public void ghostspeakUnlocksWhenUrhneyCanSupplyIt()
    {
        Progress p = new Progress();
        assertFalse(eligible("AnimalMagnetism", "ghostspeak", p));
        p.varps.put(VarPlayerID.PRIESTSTART, 1);
        assertTrue(eligible("AnimalMagnetism", "ghostspeak", p));
    }

    @Test public void gasMaskIsLockedUntilAlrenaHasSuppliedIt()
    {
        Progress p = new Progress();
        p.varps.put(VarPlayerID.ELENAQUEST, 1);
        assertFalse(eligible("Biohazard", "gasMask", p));
        p.varps.put(VarPlayerID.ELENAQUEST, 2);
        assertTrue(eligible("Biohazard", "gasMask", p));
    }

    @Test public void sealUnlocksAtBrundtsStage()
    {
        Progress p = new Progress();
        assertFalse(eligible("DreamMentor", "sealOfPassage", p));
        p.varbits.put(VarbitID.LUNAR_QUEST_MAIN, 10);
        assertTrue(eligible("DreamMentor", "sealOfPassage", p));
    }

    @Test public void ownQuestStepsNeverBecomePrepShopping()
    {
        Progress p = new Progress();
        p.complete.add(Quest.LEGENDS_QUEST);
        assertFalse(eligible("LegendsQuest", "anyNotes", p));
        assertFalse(eligible("FairytaleI", "draynorSkull", p));
        assertFalse(eligible("ThePathOfGlouphrie", "treeGnomeVillageDungeonKey", p));
    }

    @Test public void samePhysicalItemCanBeQuestStepOrUnlockedLaterPrep()
    {
        Progress p = new Progress();
        assertFalse(eligible("RFDSirAmikVarze", "radimusNotes", p));
        p.varps.put(VarPlayerID.LEGENDSQUEST, 1);
        assertFalse(eligible("LegendsQuest", "anyNotes", p));
        assertTrue(eligible("RFDSirAmikVarze", "radimusNotes", p));
    }

    @Test public void completedOriginAllowsReplacementQuestEquipment()
    {
        Progress p = new Progress();
        assertFalse(eligible("HolyGrail", "excalibur", p));
        p.complete.add(Quest.MERLINS_CRYSTAL);
        assertTrue(eligible("HolyGrail", "excalibur", p));
        assertFalse(eligible("SinsOfTheFather", "ivandisFlail", p));
        p.complete.add(Quest.A_TASTE_OF_HOPE);
        assertTrue(eligible("SinsOfTheFather", "ivandisFlail", p));
    }

    @Test public void anOwnedAcceptedAlternativeIsNotDiscarded()
    {
        GeneratedQuestData.RawItem row = raw("DragonSlayerII", "antifireShield");
        RequiredItem item = QuestItemDatabase.convertItem(row.getQuest(), row);
        int ownedId = item.getItemIds()[0];
        BankTracker bank = new BankTracker() {
            @Override public int getQuantity(int id) { return id == ownedId ? 1 : 0; }
        };
        assertTrue(PrepAvailability.canGather(row, item, bank, new Progress()));
        assertEquals(0, item.getMissingQuantity(bank));
    }

    @Test public void accountProgressDoesNotLeakBetweenSnapshots()
    {
        Progress first = new Progress();
        first.complete.add(Quest.MERLINS_CRYSTAL);
        assertTrue(eligible("HolyGrail", "excalibur", first));
        assertFalse(eligible("HolyGrail", "excalibur", new Progress()));
    }

    @Test public void missingClientStateDoesNotUnlockQuestItems()
    {
        GeneratedQuestData.RawItem row = raw("DragonSlayerII", "antifireShield");
        RequiredItem item = QuestItemDatabase.convertItem(row.getQuest(), row);
        assertFalse(PrepAvailability.canGather(row, item, new BankTracker(), PrepAvailability.snapshot(null)));
    }

    @Test public void auditCurrentCatalogueWithoutQuestUnlocks()
    {
        Progress p = new Progress();
        int blocked = 0;
        for (GeneratedQuestData.RawItem row : GeneratedQuestData.getItems())
        {
            if (!GeneratedPrepClassification.isPrepRequired(row.getQuest(), row.getVariable())) continue;
            RequiredItem item = QuestItemDatabase.convertItem(row.getQuest(), row);
            if (item != null && !PrepAvailability.canGather(row, item, new BankTracker(), p))
            {
                System.out.println("Deferred: " + row.getQuest() + ":" + row.getVariable());
                blocked++;
            }
        }
        assertTrue("Expected multiple cross-quest leaks", blocked >= 40);
        System.out.println("Deferred requirement rows: " + blocked);
    }
}
