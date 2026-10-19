package com.ironquestprep;

import java.awt.Component;
import java.util.List;
import java.util.function.Function;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/** A collapsed shop/location creates no supply rows; large lists load in small batches. */
final class PagedSupplySection<T> extends JPanel {
    private static final int PAGE_SIZE = 20;
    private final List<T> items;
    private final Function<T, Component> row;
    private final JPanel body = new JPanel();
    private final JButton more = new JButton("Show more supplies");
    private int loaded;

    PagedSupplySection(String title, List<T> items, Function<T, Component> row) {
        this.items = items;
        this.row = row;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentX(Component.LEFT_ALIGNMENT);
        body.setAlignmentX(Component.LEFT_ALIGNMENT);
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        body.setVisible(false);
        JButton toggle = new JButton(sectionTitle(title, items.size(), false));
        toggle.setAlignmentX(Component.LEFT_ALIGNMENT);
        toggle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        toggle.addActionListener(event -> {
            boolean expand = !body.isVisible();
            if (expand && loaded == 0) loadPage();
            body.setVisible(expand);
            toggle.setText(sectionTitle(title, items.size(), expand));
            revalidate();
            repaint();
        });
        more.addActionListener(event -> loadPage());
        more.setAlignmentX(Component.LEFT_ALIGNMENT);
        add(toggle);
        add(body);
    }

    private static String sectionTitle(String title, int count, boolean expanded) {
        String escaped = title.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
        return "<html><div style='width:160px;'>" + (expanded ? "- " : "+ ")
                + escaped + " (" + count + ")</div></html>";
    }

    private void loadPage() {
        body.remove(more);
        int end = Math.min(items.size(), loaded + PAGE_SIZE);
        while (loaded < end) body.add(row.apply(items.get(loaded++)));
        if (loaded < items.size()) body.add(more);
        revalidate();
        repaint();
    }
}
