package com.ironquestprep;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import net.runelite.api.Item;
import net.runelite.api.ItemContainer;
import net.runelite.api.Node;
import net.runelite.api.gameval.ItemID;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankBrowsingTest {
    private ItemContainer container(int quantity) {
        return new ItemContainer() {
            public int getId() {return 0;}
            public Item[] getItems() {return new Item[]{new Item(ItemID.HAMMER, quantity)};}
            public Item getItem(int slot) {return getItems()[slot];}
            public boolean contains(int id) {return id == ItemID.HAMMER;}
            public int count(int id) {return contains(id) ? quantity : 0;}
            public int size() {return 1;}
            public int count() {return 1;}
            public int find(int id) {return contains(id) ? 0 : -1;}
            public Node getNext() {return null;}
            public Node getPrevious() {return null;}
            public long getHash() {return 0;}
        };
    }

    @Test public void bankSnapshotStaysFixedUntilNextRefresh() {
        BankTracker live = new BankTracker();
        live.scanBank(container(2));
        live.scanInventory(container(3));
        BankTracker snapshot = live.snapshot();
        live.scanInventory(container(10));
        live.scanBank(container(4));
        assertEquals(5, snapshot.getQuantity(ItemID.HAMMER));
        assertTrue(snapshot.hasScannedBank());
        assertEquals(14, live.snapshot().getQuantity(ItemID.HAMMER));
        live.clear();
        assertEquals(5, snapshot.getQuantity(ItemID.HAMMER));
    }

    @Test public void collapsedListsBuildNoRowsAndExpandInBatches() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            List<Integer> supplies = new ArrayList<>();
            for (int i = 0; i < 45; i++) supplies.add(i);
            AtomicInteger built = new AtomicInteger();
            PagedSupplySection<Integer> section = new PagedSupplySection<>("Shop", supplies, i -> {
                built.incrementAndGet();
                return new JLabel(i.toString());
            });
            assertEquals(0, built.get());
            JButton toggle = (JButton) section.getComponent(0);
            toggle.doClick();
            assertEquals(20, built.get());
            toggle.doClick();
            toggle.doClick();
            assertEquals(20, built.get());
            JPanel body = (JPanel) section.getComponent(1);
            ((JButton) body.getComponent(body.getComponentCount() - 1)).doClick();
            assertEquals(40, built.get());
            ((JButton) body.getComponent(body.getComponentCount() - 1)).doClick();
            assertEquals(45, built.get());
            assertEquals(45, body.getComponentCount());
        });
    }

    @Test public void catalogUsesOnlyKnownNormalStock() {
        assertEquals(AcquisitionRegion.MISTHALIN, ShopSupplyCatalog.preferredSource("ItemID.HAMMER").getRegion());
        assertNull(ShopSupplyCatalog.preferredSource("ItemID.BUCKET_MILK"));
        assertNull(ShopSupplyCatalog.preferredSource("ItemID.PESTLE_AND_MORTAR"));
    }
}
