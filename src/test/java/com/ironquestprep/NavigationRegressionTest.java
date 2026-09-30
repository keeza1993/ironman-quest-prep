package com.ironquestprep;

import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;
import org.junit.Test;
import static org.junit.Assert.*;

public class NavigationRegressionTest
{
    private GatheringStep step(String item, String location, String instruction)
    {
        return new GatheringStep(AcquisitionRegion.ANYWHERE, location, item,
                new int[]{ItemID.KNIFE}, 1, instruction, AcquisitionInfo.MethodType.SHOP);
    }

    @Test public void ordinaryWordsDoNotSelectNed()
    {
        assertNull(AcquisitionPlaceDatabase.inferFromText("Obtain the needed item"));
        assertNull(AcquisitionPlaceDatabase.inferFromText("Use a sharpened tool"));
    }

    @Test public void selectedLocationBeatsAlternativeInNotes()
    {
        assertEquals("taverley", AcquisitionPlaceDatabase.infer(AcquisitionRegion.ASGARNIA,
                "Taverley", "Buy here; Falador is another option.").getKey());
    }

    @Test public void itemNameAloneDoesNotInventAnExactSource()
    {
        GatheringTarget result = GatheringTargetResolver.resolve(step("Cake tin", "Rimmington", "Obtain it at this location."));
        assertEquals(AcquisitionNavigationDatabase.getWorldPoint("rimmington"), result.getWorldPoint());
        assertNotEquals("Cooks' Guild", result.getTargetName());
    }

    @Test public void explicitNpcBeatsTown()
    {
        GatheringTarget result = GatheringTargetResolver.resolve(step("Rope", "Draynor Village", "Buy rope from Ned."));
        assertEquals(NpcID.NED, result.getTargetId());
        assertEquals(new WorldPoint(3097, 3257, 0), result.getWorldPoint());
    }

    @Test public void selectedNpcBeatsAlternativeNpcInInstructions()
    {
        GatheringTarget result = GatheringTargetResolver.resolve(step("Supplies", "Betty, Port Sarim", "Buy from Betty; Ned is another option."));
        assertEquals(NpcID.BETTY, result.getTargetId());
    }

    @Test public void itemMentionInNotesDoesNotOverrideLocation()
    {
        GatheringTarget result = GatheringTargetResolver.resolve(step("Cake tin", "Rimmington", "Obtain a cake tin here."));
        assertEquals(AcquisitionNavigationDatabase.getWorldPoint("rimmington"), result.getWorldPoint());
    }

    @Test public void regionalDestinationsStayCollapsed()
    {
        WorldPoint kourend = AcquisitionNavigationDatabase.getWorldPoint("arceuus");
        for (AcquisitionPlace place : AcquisitionPlaceDatabase.getPlaces())
        {
            if (place.getRegion() == AcquisitionRegion.KOUREND_KEBOS)
                assertEquals(kourend, AcquisitionNavigationDatabase.getWorldPoint(place));
            if (place.getRegion() == AcquisitionRegion.VARLAMORE)
                assertEquals(AcquisitionNavigationDatabase.getWorldPoint("hunter_guild"), AcquisitionNavigationDatabase.getWorldPoint(place));
        }
    }
    @Test public void explicitRouteTargetSurvivesTextFallback()
    {
        GatheringTarget exact = GatheringTarget.tile("Selected tile", new WorldPoint(3001, 3201, 0));
        assertSame(exact, GatheringTargetResolver.resolve(step("Rope", "Draynor Village", "Buy from Ned").withTarget(exact)));
    }

    @Test public void crossRegionAlternativeDoesNotReplaceKourend()
    {
        GatheringStep step = new GatheringStep(AcquisitionRegion.KOUREND_KEBOS, "Arceuus", "Supplies",
                new int[]{ItemID.KNIFE}, 1, "Obtain here; Ned in Draynor is an alternative", AcquisitionInfo.MethodType.SHOP);
        assertEquals(AcquisitionNavigationDatabase.getWorldPoint("arceuus"), GatheringTargetResolver.resolve(step).getWorldPoint());
    }

}
