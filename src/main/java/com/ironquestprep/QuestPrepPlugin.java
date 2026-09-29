package com.ironquestprep;

import com.google.inject.Provides;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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
import net.runelite.api.events.StatChanged;
import net.runelite.api.events.NpcSpawned;
import net.runelite.api.events.NpcDespawned;
import net.runelite.api.events.NpcChanged;
import net.runelite.api.events.VarbitChanged;
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
		description = "Quest preparation checklist, gathering destinations and quest reward XP planning",
		tags = {"ironman", "quest", "items", "prep", "checklist"}
)
@lombok.extern.slf4j.Slf4j
public class QuestPrepPlugin extends Plugin
{
	@Inject
	private ClientToolbar clientToolbar;

	@Inject
	private Client client;

	@Inject
	private OverlayManager overlayManager;

	@Inject
	private QuestGroundItemOverlay groundItemOverlay;

	@Inject
	private RouteGuidanceOverlay routeGuidanceOverlay;

	@Inject
	private RouteMinimapOverlay routeMinimapOverlay;

	@Inject
	private ClientThread clientThread;

	private IronQuestprepPanel panel;
	private NavigationButton navButton;

	private final BankTracker bankTracker =
			new BankTracker();

	private List<RequiredItem> activeRequirements =
			Collections.emptyList();

	private final Map<Tile, Integer> groundItemTileCounts =
			new HashMap<>();

	private long lastAccountHash = -1L;

	private boolean questProgressDirty;
    private boolean skillsDirty = true;
    private int lastSkillsRefreshTick = -10;
	private int lastProgressRefreshTick;

	@Override
	protected void startUp()
	{
		bankTracker.clear();
        skillsDirty = true;
        lastSkillsRefreshTick = -10;

		activeRequirements =
				Collections.emptyList();

		groundItemTileCounts.clear();

		routeGuidanceOverlay.clearActiveStep();

		routeGuidanceOverlay.setBankTracker(
				bankTracker
		);

		lastAccountHash =
				client.getAccountHash();

		panel =
				new IronQuestprepPanel();

		/*
		 * Manual route selection from the Gathering Route
		 * panel.
		 */
		panel.setRouteStepSelectionListener(
				step -> clientThread.invokeLater(() -> selectRouteStep(step))
		);

		BufferedImage icon = QuestIcon.create();

		navButton =
				NavigationButton.builder()
						.tooltip(
								"Ironman Quest Prep"
						)
						.icon(icon)
						.priority(5)
						.panel(panel)
						.build();

		clientToolbar.addNavigation(
				navButton
		);

		overlayManager.add(
				groundItemOverlay
		);

		overlayManager.add(
				routeGuidanceOverlay
		);
		overlayManager.add(routeMinimapOverlay);
        clientThread.invokeLater(() -> {
            if (panel != null && client.getGameState() == GameState.LOGGED_IN) routeGuidanceOverlay.seedNpcs();
        });

		log.debug(
				"Ironman Quest Prep started!"
		);
	}

	/*
	 * =====================================================
	 * MANUAL ROUTE SELECTION
	 * =====================================================
	 */

	private void selectRouteStep(
			GatheringStep step)
	{
		if (step == null)
		{
			return;
		}

		if (!step.hasNavigationTarget())
		{
			return;
		}

		routeGuidanceOverlay.setActiveStep(
				step
		);

		log.debug(
				"Ironman Quest Prep: navigating to "
						+ step.getItemName()
						+ " at "
						+ step.getTarget()
						.getCoordinateText()
		);
	}

	/*
	 * =====================================================
	 * ACCOUNT CHANGES
	 * =====================================================
	 */

	@Subscribe
	public void onAccountHashChanged(
			AccountHashChanged event)
	{
		long currentAccountHash =
				client.getAccountHash();

		if (currentAccountHash == -1L)
		{
			return;
		}

		if (lastAccountHash != -1L
				&& currentAccountHash
				!= lastAccountHash)
		{
			bankTracker.clear();

			activeRequirements =
					Collections.emptyList();

			groundItemTileCounts.clear();

			routeGuidanceOverlay.clearActiveStep();

			if (panel != null)
			{
				panel.resetForAccountChange();
                skillsDirty = true;
                lastSkillsRefreshTick = -10;
			}

			log.debug(
					"Ironman Quest Prep: account changed - cached item data cleared."
			);
		}

		lastAccountHash =
				currentAccountHash;
	}

	/*
	 * =====================================================
	 * ITEM CONTAINERS
	 * =====================================================
	 */

	@Subscribe
	public void onItemContainerChanged(
			ItemContainerChanged event)
	{
		int containerId =
				event.getContainerId();

		/*
		 * Player bank.
		 */
		if (containerId
				== InventoryID.BANK)
		{
			bankTracker.scanBank(
					event.getItemContainer()
			);

			refreshChecklist();

			return;
		}

		/*
		 * Group Ironman shared storage.
		 */
		if (containerId
				== InventoryID.INV_GROUP_TEMP)
		{
			bankTracker.scanGroupStorage(
					event.getItemContainer()
			);

			if (bankTracker.hasScannedBank())
			{
				refreshChecklist();
			}

			return;
		}

		/*
		 * Player inventory.
		 *
		 * Inventory now counts towards quest-prep ownership.
		 */
		if (containerId
				== InventoryID.INV)
		{
			bankTracker.scanInventory(
					event.getItemContainer()
			);

			if (bankTracker.hasScannedBank())
			{
				refreshChecklist();
			}
		}
	}

	/*
	 * =====================================================
	 * GROUND ITEMS
	 * =====================================================
	 */

	@Subscribe
	public void onItemSpawned(
			ItemSpawned event)
	{
		Tile tile =
				event.getTile();

		if (tile == null)
		{
			return;
		}

		groundItemTileCounts.merge(
				tile,
				1,
				Integer::sum
		);
	}

	@Subscribe
	public void onItemDespawned(
			ItemDespawned event)
	{
		Tile tile =
				event.getTile();

		if (tile == null)
		{
			return;
		}

		Integer count =
				groundItemTileCounts.get(
						tile
				);

		if (count == null)
		{
			return;
		}

		if (count <= 1)
		{
			groundItemTileCounts.remove(
					tile
			);
		}
		else
		{
			groundItemTileCounts.put(
					tile,
					count - 1
			);
		}
	}

	@Subscribe
	public void onGameStateChanged(
			GameStateChanged event)
	{
		GameState state =
				event.getGameState();
        skillsDirty = true;
        lastSkillsRefreshTick = -10;
        if (state == GameState.LOGGED_IN) routeGuidanceOverlay.seedNpcs();
        if (state == GameState.LOGIN_SCREEN || state == GameState.HOPPING) routeGuidanceOverlay.clearNpcs();
        if (state == GameState.LOGIN_SCREEN && panel != null) panel.updateSkills(null);

		if (state == GameState.LOADING
				|| state == GameState.HOPPING
				|| state == GameState.LOGIN_SCREEN)
		{
			groundItemTileCounts.clear();
		}
		if (state == GameState.LOGIN_SCREEN)
		{
			routeGuidanceOverlay.clearActiveStep();
		}
	}

	/*
	 * =====================================================
	 * CHECKLIST REFRESH
	 * =====================================================
	 */

    @Subscribe
    public void onNpcSpawned(NpcSpawned event) { routeGuidanceOverlay.trackNpc(event.getNpc()); }

    @Subscribe
    public void onNpcDespawned(NpcDespawned event) { routeGuidanceOverlay.untrackNpc(event.getNpc()); }

    @Subscribe
    public void onNpcChanged(NpcChanged event) { routeGuidanceOverlay.trackNpc(event.getNpc()); }

    @Subscribe
    public void onVarbitChanged(VarbitChanged event)
    {
        // Quest progress can unlock a source without any inventory change.
        questProgressDirty = true;
        skillsDirty = true;
    }

    @Subscribe
    public void onStatChanged(StatChanged event) { skillsDirty = true; }

    @Subscribe
    public void onGameTick(GameTick event)
    {
        if (skillsDirty && client.getGameState() == GameState.LOGGED_IN
                && client.getTickCount() - lastSkillsRefreshTick >= 10 && panel != null)
        {
            panel.updateSkills(QuestSkillPlanner.snapshot(client));
            skillsDirty = false;
            lastSkillsRefreshTick = client.getTickCount();
        }
        if (questProgressDirty && bankTracker.hasScannedBank()
                && client.getGameState() == GameState.LOGGED_IN
                && client.getTickCount() - lastProgressRefreshTick >= 10)
        {
            refreshChecklist();
        }
    }

	private void refreshChecklist()
	{
        questProgressDirty = false;
        lastProgressRefreshTick = client.getTickCount();
		List<RequiredItem> requirements =
				QuestItemDatabase
						.getItemsForUnfinishedQuests(
								client,
								bankTracker
						);

		activeRequirements =
				new ArrayList<>(
						requirements
				);

		refreshRouteGuidance(
				requirements
		);

		if (panel != null)
		{
			panel.updateBankStatus(
					bankTracker.getUniqueItemCount(),
					bankTracker.getTotalItemCount()
			);

			panel.updateChecklist(
					bankTracker,
					requirements
			);
		}
	}

	/*
	 * =====================================================
	 * PLAYER POSITION
	 * =====================================================
	 */

	private WorldPoint getPlayerWorldPoint()
	{
		if (client.getLocalPlayer()
				== null)
		{
			return null;
		}

		return client.getLocalPlayer()
				.getWorldLocation();
	}

	/*
	 * =====================================================
	 * ROUTE GUIDANCE
	 * =====================================================
	 */

	private void refreshRouteGuidance(
			List<RequiredItem> requirements)
	{
		WorldPoint playerLocation =
				getPlayerWorldPoint();

		/*
		 * THIS is the important change.
		 *
		 * The route is now built using the player's current
		 * position instead of purely alphabetical ordering.
		 */
		List<GatheringStep> steps =
				GatheringRouteBuilder.build(
						requirements,
						bankTracker,
						playerLocation
				);

		/*
		 * Preserve the manually selected destination while
		 * it is still required.
		 */
		GatheringStep currentStep =
				routeGuidanceOverlay.getActiveStep();

		if (currentStep != null)
		{
			for (GatheringStep step : steps)
			{
				if (!step.hasNavigationTarget())
				{
					continue;
				}

				if (isSameRouteStep(
						currentStep,
						step))
				{
					routeGuidanceOverlay.setActiveStep(
							step
					);

					return;
				}
			}
		}

		/*
		 * Otherwise the FIRST navigable entry is now the
		 * nearest route target produced by
		 * GatheringRouteBuilder.
		 */
		for (GatheringStep step : steps)
		{
			if (!step.hasNavigationTarget())
			{
				continue;
			}

			routeGuidanceOverlay.setActiveStep(
					step
			);

			return;
		}

		routeGuidanceOverlay.clearActiveStep();
	}

	/*
	 * =====================================================
	 * ROUTE STEP IDENTITY
	 * =====================================================
	 */

	private boolean isSameRouteStep(
			GatheringStep first,
			GatheringStep second)
	{
		if (first == null
				|| second == null)
		{
			return false;
		}

		if (first.getRegion()
				!= second.getRegion())
		{
			return false;
		}

		if (!safeText(
				first.getItemName())
				.equalsIgnoreCase(
						safeText(
								second.getItemName()
						)
				))
		{
			return false;
		}

		return safeText(
				first.getLocation())
				.equalsIgnoreCase(
						safeText(
								second.getLocation()
						)
				);
	}

	private String safeText(
			String text)
	{
		return text == null
				? ""
				: text.trim();
	}

	/*
	 * =====================================================
	 * GROUND ITEM OVERLAY DATA
	 * =====================================================
	 */

	String getGroundItemLabel(
			int groundItemId)
	{
		for (RequiredItem item
				: activeRequirements)
		{
			int missing =
					item.getMissingQuantity(
							bankTracker
					);

			if (missing <= 0)
			{
				continue;
			}

			for (int acceptedId
					: item.getItemIds())
			{
				if (acceptedId
						!= groundItemId)
				{
					continue;
				}

				return item.getName()
						+ " [Need "
						+ missing
						+ "]";
			}
		}

		return null;
	}

	Set<Tile> getGroundItemTiles()
	{
		return new HashSet<>(
				groundItemTileCounts.keySet()
		);
	}

	/*
	 * =====================================================
	 * SHUTDOWN
	 * =====================================================
	 */

	@Override
	protected void shutDown()
	{
		overlayManager.remove(
				groundItemOverlay
		);

		overlayManager.remove(
				routeGuidanceOverlay
		);
		overlayManager.remove(routeMinimapOverlay);
        routeGuidanceOverlay.clearNpcs();
        skillsDirty = true;
        lastSkillsRefreshTick = -10;

		routeGuidanceOverlay.clearActiveStep();

		bankTracker.clear();

		activeRequirements =
				Collections.emptyList();

		groundItemTileCounts.clear();

		lastAccountHash = -1L;
        questProgressDirty = false;
        lastProgressRefreshTick = 0;

		if (navButton != null)
		{
			clientToolbar.removeNavigation(
					navButton
			);
		}

		panel = null;
		navButton = null;

		log.debug(
				"Ironman Quest Prep stopped!"
		);
	}

	/*
	 * =====================================================
	 * CONFIG
	 * =====================================================
	 */

	@Provides
	QuestPrepConfig provideConfig(
			ConfigManager configManager)
	{
		return configManager.getConfig(
				QuestPrepConfig.class
		);
	}
}