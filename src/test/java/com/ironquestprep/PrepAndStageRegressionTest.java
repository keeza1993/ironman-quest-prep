package com.ironquestprep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;
import org.junit.Test;
import static org.junit.Assert.*;

public class PrepAndStageRegressionTest
{
    private GeneratedQuestData.RawItem raw(String quest, String variable)
    {
        return GeneratedQuestData.getItems().stream()
                .filter(r -> quest.equals(r.getQuest()) && variable.equals(r.getVariable()))
                .findFirst().orElseThrow(() -> new AssertionError(quest + ":" + variable));
    }

    @Test public void genericAxesAreReusableAcrossQuests()
    {
        List<RequiredItem> axes = new ArrayList<>();
        for (GeneratedQuestData.RawItem row : GeneratedQuestData.getItems())
        {
            if ("ItemCollections.AXES".equals(row.getItemSource()))
            {
                RequiredItem item = QuestItemDatabase.convertItem(row.getQuest(), row);
                if (item != null)
                {
                    assertFalse(item.getKey(), item.isConsumed());
                    axes.add(item);
                }
            }
        }
        assertTrue(axes.size() >= 10);
        List<RequiredItem> merged = QuestItemDatabase.mergeItems(axes);
        assertEquals(1, merged.size());
        assertEquals(1, merged.get(0).getRequiredQuantity());
        int acceptedAxe = merged.get(0).getItemIds()[0];
        BankTracker bank = new BankTracker() {
            @Override public int getQuantity(int id) {return id == acceptedAxe ? 1 : 0;}
        };
        assertEquals(0, merged.get(0).getMissingQuantity(bank));
    }

    @Test public void tenBronzeAxesIsAnExplicitConsumedQuestRequirement()
    {
        RequiredItem axes = QuestItemDatabase.convertItem("InAidOfTheMyreque", raw("InAidOfTheMyreque", "bronzeAxes10"));
        assertTrue(axes.isConsumed());
        assertEquals(10, axes.getRequiredQuantity());
        assertArrayEquals(new int[]{ItemID.BRONZE_AXE}, axes.getItemIds());
    }

    @Test public void consumedItemsSumAndReusableItemsKeepMaximum()
    {
        AcquisitionInfo info = AcquisitionInfo.anywhere("Use supplies", AcquisitionInfo.MethodType.MULTIPLE);
        RequiredItem consumed = new RequiredItem("a", new int[]{ItemID.ROPE}, "Rope", 2, info, true, "");
        assertEquals(4, QuestItemDatabase.mergeItems(Arrays.asList(consumed, consumed)).get(0).getRequiredQuantity());
        RequiredItem tool = new RequiredItem("b", new int[]{ItemID.KNIFE}, "Knife", 2, info, false, "");
        assertEquals(2, QuestItemDatabase.mergeItems(Arrays.asList(tool, tool)).get(0).getRequiredQuantity());
    }

    @Test public void dragonSlayerOneDoesNotPreGatherAnAntifireShield()
    {
        for (GeneratedQuestData.RawItem row : GeneratedQuestData.getItems())
        {
            if ("DragonSlayer".equals(row.getQuest())
                    && (row.getItemSource().contains("ANTIFIRE") || row.getItemName().toLowerCase().contains("shield")))
            {
                assertFalse(GeneratedPrepClassification.isPrepRequired(row.getQuest(), row.getVariable()));
            }
        }
        assertFalse(GeneratedPrepClassification.isPrepRequired("DragonSlayer", "antifireShield"));
        assertTrue(GeneratedPrepClassification.isPrepRequired("DragonSlayerII", "antifireShield"));
    }

    @Test public void obtainedDuringQuestDoesNotMeanDraynor()
    {
        AcquisitionInfo info = IronmanAcquisitionAdvice.getInfo(raw("MourningsEndPartI", "rottenApple"));
        assertEquals("During the quest", info.getLocation());
        assertEquals(AcquisitionRegion.ANYWHERE, info.getRegion());
    }

    private RequiredItem wool(AcquisitionInfo info)
    {
        return new RequiredItem("wool", new int[]{ItemID.BALL_OF_WOOL}, "Ball of wool", 3, info, true, "");
    }

    @Test public void selectedShopIsNotReplacedByWoolRecipe()
    {
        GatheringStep step = GatheringRouteBuilder.build(Arrays.asList(wool(new AcquisitionInfo(
                "Buy balls of wool at this shop", AcquisitionRegion.KANDARIN, "Ardougne", AcquisitionInfo.MethodType.SHOP))),
                new BankTracker(), new WorldPoint(3200, 3200, 0)).get(0);
        assertFalse(step.hasStages());
        assertEquals(AcquisitionNavigationDatabase.getWorldPoint("ardougne"), step.getTarget().getWorldPoint());
    }

    @Test public void woolStageMovesFromSheepToUpstairsWheelThenDisappears()
    {
        List<RequiredItem> items = Arrays.asList(wool(new AcquisitionInfo("Shear a sheep and spin wool",
                AcquisitionRegion.MISTHALIN, "Lumbridge", AcquisitionInfo.MethodType.CRAFT)));
        BankTracker empty = new BankTracker();
        GatheringStep shear = GatheringRouteBuilder.build(items, empty).get(0);
        assertEquals("Shear sheep", shear.getCurrentStage(empty).getName());
        BankTracker woolOwned = new BankTracker() {
            @Override public int getQuantity(int id) {return id == ItemID.WOOL ? 3 : 0;}
        };
        GatheringStep spin = GatheringRouteBuilder.build(items, woolOwned).get(0);
        assertEquals("Spin wool", spin.getCurrentStage(woolOwned).getName());
        assertEquals(1, spin.getTarget().getWorldPoint().getPlane());
        BankTracker ballsOwned = new BankTracker() {
            @Override public int getQuantity(int id) {return id == ItemID.BALL_OF_WOOL ? 3 : 0;}
        };
        assertTrue(GatheringRouteBuilder.build(items, ballsOwned).isEmpty());
    }

}
