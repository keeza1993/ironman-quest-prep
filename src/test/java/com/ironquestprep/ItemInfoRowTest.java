package com.ironquestprep;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemInfoRowTest {
    @Test public void acquisitionDetailsOpenAndCloseWithoutHidingTheItem() throws Exception {
        SwingUtilities.invokeAndWait(() -> {
            JLabel title = new JLabel("Bucket");
            JLabel details = new JLabel("Buy from a general store.");
            ItemInfoRow row = new ItemInfoRow(title, details, "Bucket");
            JPanel header = (JPanel) row.getComponent(0);
            JButton info = (JButton) header.getComponent(1);
            assertFalse(details.isVisible());
            assertTrue(title.isVisible());
            assertEquals("How to obtain Bucket", info.getAccessibleContext().getAccessibleName());
            info.doClick(0);
            assertTrue(details.isVisible());
            assertTrue(info.isSelected());
            info.doClick(0);
            assertFalse(details.isVisible());
            assertTrue(title.isVisible());
        });
    }
}
