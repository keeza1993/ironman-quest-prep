package com.ironquestprep;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import net.runelite.client.ui.PluginPanel;

public class IronQuestprepPanel extends PluginPanel {
    private static final Color PINK = new Color(255, 20, 147);

    private static final Color REGION_ORANGE = new Color(255, 190, 80);

    private static final Color UNKNOWN_RED = new Color(220, 120, 120);

    private static final Color MUTED_GRAY = new Color(190, 190, 190);

    private final JLabel bankStatus;
    private final JLabel bankItems;
    private final JLabel questProgress;

    private final JButton checklistModeButton;
    private final JButton routeModeButton;
    private final JButton skillsModeButton;

    private final JPanel itemList;

    private final Set<AcquisitionRegion> expandedRegions = EnumSet.noneOf(AcquisitionRegion.class);

    private boolean routeMode = false;
    private boolean skillsMode;
    private boolean panelActive;
    private QuestSkillPlanner.Plan latestPlan;
    private final QuestSkillsPanel skillsPanel = new QuestSkillsPanel();

    private BankTracker currentBankTracker;

    private List<RequiredItem> currentRequiredItems = new ArrayList<>();

    private Consumer<GatheringStep> routeStepSelectionListener = step -> {};

    public IronQuestprepPanel() {
        setLayout(new BorderLayout());

        JPanel content = new JPanel();

        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel title = new JLabel("<html><b>Ironman Quest Prep</b></html>");

        title.setIcon(new javax.swing.ImageIcon(QuestIcon.create()));
        title.setIconTextGap(6);

        title.setForeground(Color.WHITE);

        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        bankStatus = new JLabel("Bank status: Not scanned");

        bankStatus.setForeground(Color.LIGHT_GRAY);

        bankStatus.setAlignmentX(Component.LEFT_ALIGNMENT);

        bankItems = new JLabel("Bank items: --");

        bankItems.setForeground(Color.LIGHT_GRAY);

        bankItems.setAlignmentX(Component.LEFT_ALIGNMENT);

        questProgress = new JLabel("Quest items: 0 / 0");

        questProgress.setForeground(Color.WHITE);

        questProgress.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel modePanel = new JPanel();

        modePanel.setLayout(new BoxLayout(modePanel, BoxLayout.Y_AXIS));

        modePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        modePanel.setBorder(BorderFactory.createEmptyBorder(8, 0, 4, 0));

        checklistModeButton = createModeButton("Checklist");

        routeModeButton = createModeButton("Gathering Route");

        checklistModeButton.addActionListener(
                event -> {
                    if (!routeMode && !skillsMode) {
                        return;
                    }

                    routeMode = false;
                    skillsMode = false;

                    updateModeButtons();

                    renderCurrentView();
                });

        routeModeButton.addActionListener(
                event -> {
                    if (routeMode && !skillsMode) {
                        return;
                    }

                    routeMode = true;
                    skillsMode = false;

                    updateModeButtons();

                    renderCurrentView();
                });

        modePanel.add(checklistModeButton);

        modePanel.add(Box.createVerticalStrut(8));

        modePanel.add(routeModeButton);

        skillsModeButton = createModeButton("Quest Cape Skills");
        skillsModeButton.addActionListener(
                event -> {
                    skillsMode = true;
                    updateModeButtons();
                    renderCurrentView();
                });

        updateModeButtons();

        itemList = new JPanel();

        itemList.setLayout(new BoxLayout(itemList, BoxLayout.Y_AXIS));

        itemList.setAlignmentX(Component.LEFT_ALIGNMENT);

        itemList.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0));

        content.add(title);

        content.add(Box.createVerticalStrut(5));

        content.add(bankStatus);

        content.add(bankItems);

        content.add(questProgress);

        content.add(modePanel);
        modePanel.add(Box.createVerticalStrut(8));
        modePanel.add(skillsModeButton);
        JButton reportBug = createModeButton("Report a bug (Discord)");
        reportBug.setEnabled(SupportLinks.isAvailable());
        reportBug.setToolTipText(
                SupportLinks.isAvailable()
                        ? "Open our Discord server for bugs and fixes"
                        : "Discord bug reporting will be available once the server invite is configured.");
        reportBug.addActionListener(event -> SupportLinks.openBugReport());
        content.add(Box.createVerticalStrut(8));
        content.add(reportBug);
        if (!SupportLinks.isAvailable()) {
            JLabel unavailable = new JLabel("Discord link coming soon");
            unavailable.setForeground(MUTED_GRAY);
            unavailable.setAlignmentX(Component.LEFT_ALIGNMENT);
            content.add(unavailable);
        }

        content.add(itemList);

        add(content, BorderLayout.NORTH);
    }

    public void setRouteStepSelectionListener(Consumer<GatheringStep> listener) {
        routeStepSelectionListener = listener == null ? step -> {} : listener;
    }

    private JButton createModeButton(String text) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 36));
        button.setPreferredSize(new Dimension(205, 36));
        button.setMinimumSize(new Dimension(140, 36));
        button.setFocusPainted(true);
        button.setContentAreaFilled(true);
        button.setOpaque(true);
        styleModeButton(button, false);
        return button;
    }

    private void styleModeButton(JButton button, boolean selected) {
        button.setSelected(selected);
        button.setBackground(selected ? new Color(100, 39, 75) : new Color(58, 58, 63));
        button.setForeground(Color.WHITE);
        button.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                selected ? PINK : new Color(105, 105, 112), 2),
                        BorderFactory.createEmptyBorder(6, 8, 6, 8)));
    }

    private void updateModeButtons() {
        styleModeButton(checklistModeButton, !routeMode && !skillsMode);
        styleModeButton(routeModeButton, routeMode && !skillsMode);
        styleModeButton(skillsModeButton, skillsMode);
    }

    public void resetForAccountChange() {
        SwingUtilities.invokeLater(
                () -> {
                    bankStatus.setText("Bank status: Not scanned");

                    bankStatus.setForeground(Color.LIGHT_GRAY);

                    bankItems.setText("Bank items: --");

                    questProgress.setText("Quest items: 0 / 0");

                    currentBankTracker = null;

                    currentRequiredItems = new ArrayList<>();

                    latestPlan = null;
                    skillsPanel.setPlan(null);
                    expandedRegions.clear();

                    itemList.removeAll();

                    itemList.revalidate();

                    itemList.repaint();
                });
    }

    public void updateBankStatus(int uniqueItems, long totalItems) {
        SwingUtilities.invokeLater(
                () -> {
                    bankStatus.setText("Bank status: Scanned");

                    bankStatus.setForeground(Color.GREEN);

                    bankItems.setText(
                            "Bank: " + uniqueItems + " unique / " + totalItems + " total");
                });
    }

    public void updateChecklist(BankTracker bankTracker, List<RequiredItem> requiredItems) {
        List<RequiredItem> snapshot = new ArrayList<>(requiredItems);

        SwingUtilities.invokeLater(
                () -> {
                    currentBankTracker = bankTracker;

                    currentRequiredItems = snapshot;

                    renderCurrentView();
                });
    }

    public void updateSkills(QuestSkillPlanner.Plan plan) {
        SwingUtilities.invokeLater(
                () -> {
                    latestPlan = plan;
                    if (skillsMode) renderCurrentView();
                });
    }

    @Override
    public void onActivate() {
        SwingUtilities.invokeLater(() -> { panelActive = true; renderCurrentView(); });
    }

    @Override
    public void onDeactivate() {
        SwingUtilities.invokeLater(() -> panelActive = false);
    }

    private void renderCurrentView() {
        if (!panelActive) return;
        itemList.removeAll();
        if (skillsMode) {
            skillsPanel.setPlan(latestPlan);
            itemList.add(skillsPanel);
            itemList.revalidate();
            itemList.repaint();
            return;
        }

        if (currentBankTracker == null) {
            itemList.revalidate();
            itemList.repaint();

            return;
        }

        List<RequiredItem> sortedItems = new ArrayList<>(currentRequiredItems);

        sortedItems.sort(
                Comparator.comparingInt((RequiredItem item) -> item.getRegion().getSortOrder())
                        .thenComparing(this::getDisplayLocation, String.CASE_INSENSITIVE_ORDER)
                        .thenComparing(RequiredItem::getName, String.CASE_INSENSITIVE_ORDER));

        int obtained = 0;

        for (RequiredItem item : sortedItems) {
            if (item.isComplete(currentBankTracker)) {
                obtained++;
            }
        }

        questProgress.setText("Item types ready: " + obtained + " / " + sortedItems.size());

        if (routeMode) {
            renderGatheringRoute(sortedItems, currentBankTracker);
        } else {
            renderChecklist(sortedItems, currentBankTracker);
        }

        itemList.revalidate();
        itemList.repaint();
    }

    private void renderChecklist(List<RequiredItem> sortedItems, BankTracker bankTracker) {
        Map<AcquisitionRegion, List<RequiredItem>> regionItems = new LinkedHashMap<>();

        for (RequiredItem item : sortedItems) {
            regionItems.computeIfAbsent(item.getRegion(), unused -> new ArrayList<>()).add(item);
        }

        List<AcquisitionRegion> regions = new ArrayList<>(regionItems.keySet());

        regions.sort(Comparator.comparingInt(AcquisitionRegion::getSortOrder));

        for (AcquisitionRegion region : regions) {
            List<RequiredItem> items = regionItems.get(region);

            if (region == AcquisitionRegion.ANYWHERE) {
                itemList.add(createChecklistRegionBody(items, bankTracker));
            } else {
                addChecklistRegionSection(region, items, bankTracker);
            }

            itemList.add(Box.createVerticalStrut(6));
        }
    }

    private void addChecklistRegionSection(
            AcquisitionRegion region, List<RequiredItem> items, BankTracker bankTracker) {
        JPanel regionPanel = createRegionPanel();

        int ready = countReady(items, bankTracker);

        boolean expanded = expandedRegions.contains(region);

        JButton regionButton =
                createRegionButton(
                        buildChecklistRegionButtonText(region, ready, items.size(), expanded),
                        region);

        JPanel regionBody = createRegionBodyPanel();
        boolean[] built = {false};
        Runnable populate = () -> {
            if (!built[0]) {
                regionBody.add(createChecklistRegionBody(items, bankTracker));
                built[0] = true;
            }
        };
        if (expanded) populate.run();

        regionBody.setVisible(expanded);

        regionButton.addActionListener(
                event -> {
                    boolean nowExpanded = toggleRegion(region);

                    if (nowExpanded) populate.run();
                    regionBody.setVisible(nowExpanded);

                    regionButton.setText(
                            buildChecklistRegionButtonText(
                                    region, ready, items.size(), nowExpanded));

                    refreshRegionPanels(regionPanel);
                });

        regionPanel.add(regionButton);

        regionPanel.add(regionBody);

        itemList.add(regionPanel);
    }

    private JPanel createChecklistRegionBody(List<RequiredItem> items, BankTracker bankTracker) {
        JPanel body = createRegionBodyPanel();

        Map<String, List<RequiredItem>> locations = new LinkedHashMap<>();
        for (RequiredItem item : items) {
            locations.computeIfAbsent(getDisplayLocation(item), unused -> new ArrayList<>()).add(item);
        }
        for (Map.Entry<String, List<RequiredItem>> entry : locations.entrySet()) {
            body.add(new PagedSupplySection<>(entry.getKey(), entry.getValue(), item -> createItemLabel(item, bankTracker)));
        }

        return body;
    }

    private void renderGatheringRoute(List<RequiredItem> requiredItems, BankTracker bankTracker) {
        List<GatheringStep> steps = GatheringRouteBuilder.build(requiredItems, bankTracker);

        if (steps.isEmpty()) {
            JLabel complete =
                    new JLabel(
                            "<html><b>No missing items in your current prep list.</b><br>Quest-step items and known locked sources are excluded.</html>");

            complete.setForeground(Color.GREEN);

            complete.setAlignmentX(Component.LEFT_ALIGNMENT);

            itemList.add(complete);

            return;
        }

        Map<AcquisitionRegion, List<GatheringStep>> regionSteps = new LinkedHashMap<>();

        for (GatheringStep step : steps) {
            regionSteps.computeIfAbsent(step.getRegion(), unused -> new ArrayList<>()).add(step);
        }

        for (Map.Entry<AcquisitionRegion, List<GatheringStep>> entry : regionSteps.entrySet()) {
            if (entry.getKey() == AcquisitionRegion.ANYWHERE) {
                itemList.add(createRouteRegionBody(entry.getValue()));
            } else {
                addRouteRegionSection(entry.getKey(), entry.getValue());
            }

            itemList.add(Box.createVerticalStrut(6));
        }
    }

    private void addRouteRegionSection(AcquisitionRegion region, List<GatheringStep> steps) {
        JPanel regionPanel = createRegionPanel();

        boolean expanded = expandedRegions.contains(region);

        JButton regionButton =
                createRegionButton(
                        buildRouteRegionButtonText(region, steps.size(), expanded), region);

        JPanel regionBody = createRegionBodyPanel();
        boolean[] built = {false};
        Runnable populate = () -> {
            if (!built[0]) {
                regionBody.add(createRouteRegionBody(steps));
                built[0] = true;
            }
        };
        if (expanded) populate.run();

        regionBody.setVisible(expanded);

        regionButton.addActionListener(
                event -> {
                    boolean nowExpanded = toggleRegion(region);

                    if (nowExpanded) populate.run();
                    regionBody.setVisible(nowExpanded);

                    regionButton.setText(
                            buildRouteRegionButtonText(region, steps.size(), nowExpanded));

                    refreshRegionPanels(regionPanel);
                });

        regionPanel.add(regionButton);

        regionPanel.add(regionBody);

        itemList.add(regionPanel);
    }

    private JPanel createRouteRegionBody(List<GatheringStep> steps) {
        JPanel body = createRegionBodyPanel();

        Map<String, List<GatheringStep>> locations = new LinkedHashMap<>();
        for (GatheringStep step : steps) {
            String location = step.getLocation();
            if (location == null || location.trim().isEmpty()) location = "General / multiple locations";
            locations.computeIfAbsent(location, unused -> new ArrayList<>()).add(step);
        }
        for (Map.Entry<String, List<GatheringStep>> entry : locations.entrySet()) {
            int[] number = {0};
            body.add(new PagedSupplySection<>(entry.getKey(), entry.getValue(), step -> createGatheringStepPanel(step, ++number[0])));
        }

        return body;
    }

    private JPanel createGatheringStepPanel(GatheringStep step, int stepNumber) {
        JPanel panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.setBorder(BorderFactory.createEmptyBorder(4, 18, 7, 0));

        JLabel title =
                new JLabel(
                        "<html><b>"
                                + stepNumber
                                + ". "
                                + escapeHtml(step.getItemName())
                                + "</b> - Need "
                                + step.getQuantityNeeded()
                                + "</html>");

        title.setIcon(new javax.swing.ImageIcon(QuestIcon.create()));
        title.setIconTextGap(6);

        title.setForeground(Color.WHITE);

        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        panel.add(title);

        String instruction = step.getInstruction();

        if (instruction == null || instruction.trim().isEmpty()) {
            instruction = "Obtain " + step.getQuantityNeeded() + " x " + step.getItemName() + ".";
        }

        JLabel method =
                new JLabel(
                        "<html><div style='width:180px;'>"
                                + escapeHtml(instruction)
                                + "</div></html>");

        method.setForeground(Color.LIGHT_GRAY);

        method.setAlignmentX(Component.LEFT_ALIGNMENT);

        method.setBorder(BorderFactory.createEmptyBorder(2, 12, 0, 0));

        panel.add(method);

        if (step.getMethodType() != null) {
            JLabel type = new JLabel("[" + step.getMethodType().getDisplayName() + "]");

            type.setForeground(REGION_ORANGE);

            type.setAlignmentX(Component.LEFT_ALIGNMENT);

            type.setBorder(BorderFactory.createEmptyBorder(2, 12, 0, 0));

            panel.add(type);
        }

        GatheringTarget target = step.getTarget();

        if (target == null) {
            target = GatheringTarget.none();
        }

        JLabel targetLabel =
                new JLabel(
                        "<html><b>Target:</b> " + escapeHtml(target.getDisplayText()) + "</html>");

        targetLabel.setForeground(target.isNavigable() ? PINK : MUTED_GRAY);

        targetLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        targetLabel.setBorder(BorderFactory.createEmptyBorder(4, 12, 0, 0));

        panel.add(targetLabel);

        if (target.hasWorldPoint()) {
            JLabel coordinates =
                    new JLabel(
                            "<html><b>Coordinates:</b> "
                                    + escapeHtml(target.getCoordinateText())
                                    + "</html>");

            coordinates.setForeground(MUTED_GRAY);

            coordinates.setAlignmentX(Component.LEFT_ALIGNMENT);

            coordinates.setBorder(BorderFactory.createEmptyBorder(2, 12, 0, 0));

            panel.add(coordinates);
        }

        JLabel navigationStatus = new JLabel(escapeHtml(target.getNavigationStatus()));

        if (target.isNavigable()) {
            navigationStatus.setForeground(Color.GREEN);
        } else if (target.getType() != GatheringTarget.TargetType.NONE) {
            navigationStatus.setForeground(REGION_ORANGE);
        } else {
            navigationStatus.setForeground(MUTED_GRAY);
        }

        navigationStatus.setAlignmentX(Component.LEFT_ALIGNMENT);

        navigationStatus.setBorder(BorderFactory.createEmptyBorder(2, 12, 0, 0));

        panel.add(navigationStatus);

        if (target.isNavigable()) {
            JButton navigateButton = new JButton("Show destination on map");

            navigateButton.setForeground(PINK);

            navigateButton.setFocusPainted(false);

            navigateButton.setContentAreaFilled(false);

            navigateButton.setOpaque(false);

            navigateButton.setAlignmentX(Component.LEFT_ALIGNMENT);

            navigateButton.setBorder(BorderFactory.createEmptyBorder(4, 12, 2, 0));

            navigateButton.addActionListener(event -> routeStepSelectionListener.accept(step));

            panel.add(navigateButton);
        }

        return panel;
    }

    private JPanel createRegionPanel() {
        JPanel regionPanel = new JPanel();

        regionPanel.setLayout(new BoxLayout(regionPanel, BoxLayout.Y_AXIS));

        regionPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        return regionPanel;
    }

    private JPanel createRegionBodyPanel() {
        JPanel body = new JPanel();

        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));

        body.setAlignmentX(Component.LEFT_ALIGNMENT);

        body.setBorder(BorderFactory.createEmptyBorder(2, 6, 4, 0));

        return body;
    }

    private JButton createRegionButton(String text, AcquisitionRegion region) {
        JButton button = new JButton(text);

        button.setHorizontalAlignment(SwingConstants.LEFT);

        button.setFocusPainted(false);

        button.setContentAreaFilled(false);

        button.setOpaque(false);

        button.setBorder(BorderFactory.createEmptyBorder(5, 2, 5, 2));

        button.setAlignmentX(Component.LEFT_ALIGNMENT);

        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getPreferredSize().height));

        if (region == AcquisitionRegion.UNKNOWN) {
            button.setForeground(UNKNOWN_RED);
        } else if (region == AcquisitionRegion.ANYWHERE) {
            button.setForeground(MUTED_GRAY);
        } else {
            button.setForeground(REGION_ORANGE);
        }

        return button;
    }

    private boolean toggleRegion(AcquisitionRegion region) {
        if (expandedRegions.contains(region)) {
            expandedRegions.remove(region);

            return false;
        }

        expandedRegions.add(region);

        return true;
    }

    private void refreshRegionPanels(JPanel regionPanel) {
        regionPanel.revalidate();
        regionPanel.repaint();

        itemList.revalidate();
        itemList.repaint();
    }

    private String buildChecklistRegionButtonText(
            AcquisitionRegion region, int ready, int total, boolean expanded) {
        return buildArrow(expanded)
                + " "
                + getRegionName(region)
                + "  ("
                + ready
                + "/"
                + total
                + ")";
    }

    private String buildRouteRegionButtonText(
            AcquisitionRegion region, int steps, boolean expanded) {
        return buildArrow(expanded)
                + " "
                + getRegionName(region)
                + "  ("
                + steps
                + (steps == 1 ? " step)" : " steps)");
    }

    private String buildArrow(boolean expanded) {
        return expanded ? "▼" : "▶";
    }

    private String getRegionName(AcquisitionRegion region) {
        return region.getDisplayName().toUpperCase(Locale.ROOT);
    }

    private JLabel createLocationLabel(String location) {
        JLabel label = new JLabel("<html><b>" + escapeHtml(location) + "</b></html>");

        label.setForeground(Color.LIGHT_GRAY);

        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        label.setBorder(BorderFactory.createEmptyBorder(2, 8, 2, 0));

        return label;
    }

    private JLabel createItemLabel(RequiredItem item, BankTracker bankTracker) {
        int owned = item.getOwnedQuantity(bankTracker);

        int needed = item.getRequiredQuantity();

        int missing = item.getMissingQuantity(bankTracker);

        boolean complete = item.isComplete(bankTracker);

        String text;

        if (complete) {
            text = "✓ " + item.getName() + " (" + owned + "/" + needed + ")";
        } else {
            text = "☐ " + item.getName() + " (" + owned + "/" + needed + ") - Need " + missing;
        }

        JLabel label = new JLabel(text);

        label.setForeground(complete ? Color.GREEN : Color.WHITE);

        label.setAlignmentX(Component.LEFT_ALIGNMENT);

        label.setBorder(BorderFactory.createEmptyBorder(2, 18, 2, 0));

        label.setToolTipText(buildTooltip(item));

        return label;
    }

    private int countReady(List<RequiredItem> items, BankTracker bankTracker) {
        int ready = 0;

        for (RequiredItem item : items) {
            if (item.isComplete(bankTracker)) {
                ready++;
            }
        }

        return ready;
    }

    private String getDisplayLocation(RequiredItem item) {
        String location = item.getLocation();

        if (location != null && !location.trim().isEmpty()) {
            return location.trim();
        }

        if (item.getRegion() == AcquisitionRegion.UNKNOWN) {
            return "Unresearched items";
        }

        if (item.getRegion() == AcquisitionRegion.ANYWHERE) {
            return "Any suitable location";
        }

        return "General / multiple locations";
    }

    private String buildTooltip(RequiredItem item) {
        StringBuilder tooltip = new StringBuilder("<html>");

        AcquisitionInfo info = item.getAcquisitionInfo();

        if (!item.getBestMethod().isEmpty()) {
            tooltip.append("<b>How to obtain:</b><br>");

            tooltip.append(escapeHtml(item.getBestMethod()));
        }

        tooltip.append("<br><br>");

        tooltip.append("<b>Region:</b> ");

        tooltip.append(escapeHtml(item.getRegion().getDisplayName()));

        tooltip.append("<br><b>Location:</b> ");

        tooltip.append(escapeHtml(getDisplayLocation(item)));

        if (info != null && info.getMethodType() != null) {
            tooltip.append("<br><b>Method type:</b> ");

            tooltip.append(escapeHtml(info.getMethodType().getDisplayName()));
        }

        if (item.hasAlternates()) {
            tooltip.append("<br><br>");

            tooltip.append("<b>Alternative items accepted:</b> ");

            tooltip.append(item.getItemIds().length);

            tooltip.append(" versions");
        }

        if (item.hasCondition()) {
            tooltip.append("<br><br>");

            tooltip.append("<b>Conditional requirement:</b><br>");

            tooltip.append(escapeHtml(item.getCondition()));
        }

        tooltip.append("</html>");

        return tooltip.toString();
    }

    private String escapeHtml(String text) {
        if (text == null) {
            return "";
        }

        return text.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }
}
