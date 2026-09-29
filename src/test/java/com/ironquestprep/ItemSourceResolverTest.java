package com.ironquestprep;

import net.runelite.api.gameval.ItemID;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemSourceResolverTest
{
    @Test public void resolvesNamedConstantWithoutReflection()
    {
        assertArrayEquals(new int[] {ItemID.HAMMER}, ItemSourceResolver.resolve("ItemID.HAMMER", ""));
    }

    @Test public void deduplicatesAlternativesInOrder()
    {
        assertArrayEquals(new int[] {ItemID.HAMMER, ItemID.KNIFE},
                ItemSourceResolver.resolve("ItemID.HAMMER", "ItemID.KNIFE|ItemID.HAMMER"));
    }

    @Test public void resolvesSymbolsInsideExpressions()
    {
        assertArrayEquals(new int[] {ItemID.HAMMER, ItemID.KNIFE},
                ItemSourceResolver.resolve("Arrays.asList(ItemID.HAMMER, ItemID.KNIFE)", ""));
    }

    @Test public void unresolvedAndSpecialSourcesDoNotInventIds()
    {
        assertEquals(0, ItemSourceResolver.resolve("ItemID.NOT_A_REAL_ITEM", "").length);
        assertEquals(0, ItemSourceResolver.resolve("-1", "").length);
        assertEquals(0, ItemSourceResolver.resolve("KeyringCollection.TEST", "").length);
    }

    @Test public void collectionsStillResolve()
    {
        assertTrue(ItemSourceResolver.resolve("ItemCollections.ANTIFIRE_SHIELDS", "").length > 0);
    }
}
