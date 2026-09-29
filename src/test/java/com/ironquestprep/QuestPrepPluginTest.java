package com.ironquestprep;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

public class QuestPrepPluginTest
{
    /**
     * Developer launcher retained for running the plugin in RuneLite.
     */
    public static void main(String[] args) throws Exception
    {
        ExternalPluginManager.loadBuiltin(QuestPrepPlugin.class);
        RuneLite.main(args);
    }

    /**
     * Protects the generated quest-prep dataset from silently gaining blank or
     * unresolved acquisition records when the upstream quest data is refreshed.
     */
    @Test
    public void everyQuestItemHasStructuredAcquisitionData()
    {
        int checked = 0;
        int prepRequired = 0;

        for (GeneratedQuestData.RawItem raw : GeneratedQuestData.getItems())
        {
            checked++;
            if (GeneratedPrepClassification.isPrepRequired(
                    raw.getQuest(),
                    raw.getVariable()))
            {
                prepRequired++;
            }
            AcquisitionInfo info = IronmanAcquisitionAdvice.getInfo(raw);

            assertNotNull(key(raw) + " info", info);
            assertNotNull(key(raw) + " method", info.getMethod());
            assertFalse(key(raw) + " method is blank", info.getMethod().trim().isEmpty());
            assertNotNull(key(raw) + " location", info.getLocation());
            assertFalse(key(raw) + " location is blank", info.getLocation().trim().isEmpty());
            assertNotNull(key(raw) + " region", info.getRegion());
            assertNotSame(key(raw) + " region unresolved", AcquisitionRegion.UNKNOWN, info.getRegion());
            assertNotNull(key(raw) + " method type", info.getMethodType());
            assertNotSame(key(raw) + " method type unresolved", AcquisitionInfo.MethodType.UNKNOWN, info.getMethodType());
            assertNotNull(key(raw) + " logical place", info.getPlace());
            assertFalse(
                    key(raw) + " still uses the unresolved fallback route",
                    info.getMethod().contains("progression-dependent sources")
            );
        }

        assertTrue("Expected the full generated quest item dataset", checked > 1100);
        assertTrue("Expected the full prep-required subset", prepRequired > 1000);
    }

    private static String key(GeneratedQuestData.RawItem raw)
    {
        return raw.getQuest() + ":" + raw.getVariable();
    }
}
