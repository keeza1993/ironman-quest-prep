package com.ironquestprep;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

/** Visible, keyboard-accessible disclosure for acquisition instructions. */
final class ItemInfoRow extends JPanel {
    ItemInfoRow(JComponent title, JComponent details, String itemName) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        JPanel header = new JPanel(new BorderLayout(4, 0));
        header.setAlignmentX(Component.LEFT_ALIGNMENT);
        JButton info = new JButton("\u24d8");
        info.setForeground(new Color(255, 20, 147));
        info.setPreferredSize(new Dimension(28, 28));
        info.setMargin(new java.awt.Insets(2, 2, 2, 2));
        info.setToolTipText("How to obtain " + itemName + " (click to expand)");
        info.getAccessibleContext().setAccessibleName("How to obtain " + itemName);
        details.setAlignmentX(Component.LEFT_ALIGNMENT);
        details.setBorder(BorderFactory.createEmptyBorder(4, 8, 8, 0));
        details.setVisible(false);
        info.addActionListener(event -> {
            boolean expanded = !details.isVisible();
            details.setVisible(expanded);
            info.setSelected(expanded);
            info.setToolTipText((expanded ? "Hide details for " : "How to obtain ") + itemName);
            revalidate();
            repaint();
        });
        header.add(title, BorderLayout.CENTER);
        header.add(info, BorderLayout.EAST);
        add(header);
        add(details);
    }
}
