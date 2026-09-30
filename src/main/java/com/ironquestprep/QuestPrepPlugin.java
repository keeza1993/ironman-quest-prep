package com.ironquestprep;

import com.google.inject.Provides;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import net.runelite.client.callback.ClientThread;

import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.Tile;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.events.AccountHashChanged;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.ItemContainerChanged;
import net.runelite.api.events.ItemDespawned;
import net.runelite.api.events.ItemSpawned;
import net.runelite.api.gameval.InventoryID;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.ClientToolbar;
import net.runelite.client.ui.NavigationButton;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
        name = "Ironman Quest Prep",
        configName = "ironquestprepplugin",
        description =
                "Quest preparation checklist, gathering destinations and quest reward XP planning",
        tags = {"ironman", "quest", "items", "prep", "checklist"})
@lombok.extern.slf4j.Slf4j
public class QuestPrepPlugin extends Plugin {
    @Inject private ClientToolbar clientToolbar;

    @Inject private Client client;

    @Inject private OverlayManager overlayManager;

    @Inject private QuestGroundItemOverlay groundItemOverlay;

    @Inject private RouteGuidanceOverlay routeGuidanceOverlay;

    @Inject private ConfigManager configManager;

    @Inject private ClientThread clientThread;

    private IronQuestprepPanel panel;
    private NavigationButton navButton;

    private final BankTracker bankTracker = new BankTracker();

    private List<RequiredItem> activeRequirements = Collections.emptyList();

    private final Map<Tile, Integer> groundItemTileCounts = new HashMap<>();

    private long lastAccountHash = -1L;

    private final GroundItemLabels groundLabels = new GroundItemLabels();
    private final QuestSkillPlanner.Cache skillPlanCache = new QuestSkillPlanner.Cache();
    private QuestSkillPlanner.Plan displayedPlan;
    private boolean ownershipDirty;
    private final SkillRefreshSchedule skillRefreshSchedule = new SkillRefreshSchedule();

    @Override
    protected void startUp() {
        bankTracker.clear();
        groundLabels.clear();
        skillPlanCache.clear();
        displayedPlan = null;
        ownershipDirty = false;
        skillRefreshSchedule.reset();

        activeRequirements = Collections.emptyList();

        groundItemTileCounts.clear();

        routeGuidanceOverlay.clearActiveStep();

        lastAccountHash = client.getAccountHash();

        panel = new IronQuestprepPanel();

        /*
         * Manual route selection from the Gathering Route
         * panel.
         */
        panel.setRouteStepSelectionListener(
                step -> clientThread.invokeLater(() -> selectRouteStep(step)));

        BufferedImage icon = QuestIcon.create();

        navButton =
                NavigationButton.builder()
                        .tooltip("Ironman Quest Prep")
                        .icon(icon)
                        .priority(5)
                        .panel(panel)
                        .build();

        clientToolbar.addNavigation(navButton);

        overlayManager.add(groundItemOverlay);

        log.debug("Ironman Quest Prep started!");
    }

    private void selectRouteStep(GatheringStep step) {
        if (step == null) {
            return;
        }

        if (!step.hasNavigationTarget()) {
            return;
        }

        configManager.setConfiguration("ironquesthelper", "routeGuidance", true);
        routeGuidanceOverlay.clearActiveStep();
        routeGuidanceOverlay.setActiveStep(step);

        log.debug(
                "Ironman Quest Prep: navigating to "
                        + step.getItemName()
                        + " at "
                        + step.getTarget().getCoordinateText());
    }

    @Subscribe
    public void onAccountHashChanged(AccountHashChanged event) {
        long currentAccountHash = client.getAccountHash();

        if (currentAccountHash == -1L) {
            return;
        }

        if (lastAccountHash != -1L && currentAccountHash != lastAccountHash) {
            bankTracker.clear();
            groundLabels.clear();
            skillPlanCache.clear();
            displayedPlan = null;
            ownershipDirty = false;

            activeRequirements = Collections.emptyList();

            groundItemTileCounts.clear();

            routeGuidanceOverlay.clearActiveStep();

            if (panel != null) {
                panel.resetForAccountChange();
                skillRefreshSchedule.reset();
            }

            log.debug("Ironman Quest Prep: account changed - cached item data cleared.");
        }

        lastAccountHash = currentAccountHash;
    }

    @Subscribe
    public void onWidgetLoaded(net.runelite.api.events.WidgetLoaded event) {
        if (event.getGroupId() == net.runelite.api.gameval.InterfaceID.BANKMAIN) {
            net.runelite.api.ItemContainer bank = client.getItemContainer(InventoryID.BANK);
            if (bank != null) {
                bankTracker.scanBank(bank);
                bankTracker.scanInventory(client.getItemContainer(InventoryID.INV));
                ownershipDirty = true;
            }
        }
    }

    @Subscribe
    public void onItemContainerChanged(ItemContainerChanged event) {
        int containerId = event.getContainerId();

        /*
         * Player bank.
         */
        if (containerId == InventoryID.BANK) {
            bankTracker.scanBank(event.getItemContainer());

            ownershipDirty = true;

            return;
        }

        /*
         * Group Ironman shared storage.
         */
        if (containerId == InventoryID.INV_GROUP_TEMP) {
            bankTracker.scanGroupStorage(event.getItemContainer());

            if (bankTracker.hasScannedBank()) {
                ownershipDirty = true;
            }

            return;
        }

        /*
         * Player inventory.
         *
         * Inventory now counts towards quest-prep ownership.
         */
        if (containerId == InventoryID.INV) {
            bankTracker.scanInventory(event.getItemContainer());

            groundLabels.rebuild(activeRequirements, bankTracker);
        }
    }

    @Subscribe
    public void onItemSpawned(ItemSpawned event) {
        Tile tile = event.getTile();

        if (tile == null) {
            return;
        }

        groundItemTileCounts.merge(tile, 1, Integer::sum);
    }

    @Subscribe
    public void onItemDespawned(ItemDespawned event) {
        Tile tile = event.getTile();

        if (tile == null) {
            return;
        }

        Integer count = groundItemTileCounts.get(tile);

        if (count == null) {
            return;
        }

        if (count <= 1) {
            groundItemTileCounts.remove(tile);
        } else {
            groundItemTileCounts.put(tile, count - 1);
        }
    }

    @Subscribe
    public void onConfigChanged(net.runelite.client.events.ConfigChanged event) {
        if ("ironquesthelper".equals(event.getGroup()) && "routeGuidance".equals(event.getKey())) {
            clientThread.invokeLater(() -> routeGuidanceOverlay.setActiveStep(routeGuidanceOverlay.getActiveStep()));
        }
    }

    @Subscribe
    public void onGameStateChanged(GameStateChanged event) {
        GameState state = event.getGameState();
        skillRefreshSchedule.setPlaying(state == GameState.LOGGED_IN, System.nanoTime());
        if (state == GameState.LOGIN_SCREEN || state == GameState.HOPPING) skillRefreshSchedule.reset();
        if (state == GameState.LOGIN_SCREEN) {
            skillPlanCache.clear();
            displayedPlan = null;
            groundLabels.clear();
            if (panel != null) panel.updateSkills(null);
        }

        if (state == GameState.LOADING
                || state == GameState.HOPPING
                || state == GameState.LOGIN_SCREEN) {
            groundItemTileCounts.clear();
        }
        if (state == GameState.LOGIN_SCREEN) {
            routeGuidanceOverlay.clearActiveStep();
        }
    }

    @Subscribe
    public void onGameTick(GameTick event) {
        if (client.getGameState() == GameState.LOGGED_IN
                && panel != null
                && skillRefreshSchedule.refreshDue(System.nanoTime())) {
            QuestSkillPlanner.Plan nextPlan = skillPlanCache.snapshot(client);
            if (nextPlan != displayedPlan) {
                panel.updateSkills(nextPlan);
                displayedPlan = nextPlan;
            }
        }
        if (ownershipDirty
                && bankTracker.hasScannedBank()
                && client.getGameState() == GameState.LOGGED_IN) {
            refreshChecklist();
        }
    }

    private void refreshChecklist() {
        ownershipDirty = false;
        List<RequiredItem> requirements =
                QuestItemDatabase.getItemsForUnfinishedQuests(client, bankTracker);

        activeRequirements = new ArrayList<>(requirements);
        groundLabels.rebuild(activeRequirements, bankTracker);

        refreshRouteGuidance(requirements);

        if (panel != null) {
            panel.updateBankStatus(
                    bankTracker.getUniqueItemCount(), bankTracker.getTotalItemCount());

            panel.updateChecklist(bankTracker.snapshot(), requirements);
        }
    }

    private WorldPoint getPlayerWorldPoint() {
        if (client.getLocalPlayer() == null) {
            return null;
        }

        return client.getLocalPlayer().getWorldLocation();
    }

    private void refreshRouteGuidance(List<RequiredItem> requirements) {
        WorldPoint playerLocation = getPlayerWorldPoint();

        /*
         * THIS is the important change.
         *
         * The route is now built using the player's current
         * position instead of purely alphabetical ordering.
         */
        List<GatheringStep> steps =
                GatheringRouteBuilder.build(requirements, bankTracker, playerLocation);

        /*
         * Preserve the manually selected destination while
         * it is still required.
         */
        GatheringStep currentStep = routeGuidanceOverlay.getActiveStep();

        if (currentStep != null) {
            for (GatheringStep step : steps) {
                if (!step.hasNavigationTarget()) {
                    continue;
                }

                if (isSameRouteStep(currentStep, step)) {
                    routeGuidanceOverlay.setActiveStep(step);

                    return;
                }
            }
        }

        routeGuidanceOverlay.clearActiveStep();
    }

    private boolean isSameRouteStep(GatheringStep first, GatheringStep second) {
        if (first == null || second == null) {
            return false;
        }

        if (first.getRegion() != second.getRegion()) {
            return false;
        }

        if (!safeText(first.getItemName()).equalsIgnoreCase(safeText(second.getItemName()))) {
            return false;
        }

        return safeText(first.getLocation()).equalsIgnoreCase(safeText(second.getLocation()));
    }

    private String safeText(String text) {
        return text == null ? "" : text.trim();
    }

    String getGroundItemLabel(int groundItemId) {
        return groundLabels.get(groundItemId);
    }

    boolean hasGroundItemLabels() { return !groundLabels.isEmpty(); }

    Set<Tile> getGroundItemTiles() {
        // Both the overlay and item events run on the client thread.
        return Collections.unmodifiableSet(groundItemTileCounts.keySet());
    }

    @Override
    protected void shutDown() {
        overlayManager.remove(groundItemOverlay);

        skillRefreshSchedule.reset();

        routeGuidanceOverlay.clearActiveStep();

        bankTracker.clear();
        groundLabels.clear();
        skillPlanCache.clear();
        displayedPlan = null;
        ownershipDirty = false;

        activeRequirements = Collections.emptyList();

        groundItemTileCounts.clear();

        lastAccountHash = -1L;

        if (navButton != null) {
            clientToolbar.removeNavigation(navButton);
        }

        panel = null;
        navButton = null;

        log.debug("Ironman Quest Prep stopped!");
    }

    @Provides
    QuestPrepConfig provideConfig(ConfigManager configManager) {
        return configManager.getConfig(QuestPrepConfig.class);
    }
}
