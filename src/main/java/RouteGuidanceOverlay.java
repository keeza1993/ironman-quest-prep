package com.ironquestprep;

import java.awt.BasicStroke;
import java.awt.AlphaComposite;
import java.awt.geom.Ellipse2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import javax.inject.Inject;

import net.runelite.api.Client;
import net.runelite.api.NPC;
import net.runelite.api.Perspective;
import net.runelite.api.Player;
import net.runelite.api.Point;
import net.runelite.api.WorldView;
import net.runelite.api.widgets.Widget;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.coords.LocalPoint;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;

public class RouteGuidanceOverlay extends Overlay
{
    private final Map<Integer, Set<NPC>> trackedNpcs = new HashMap<>();

    void trackNpc(NPC npc)
    {
        untrackNpc(npc);
        trackedNpcs.computeIfAbsent(npc.getId(), id -> new HashSet<>()).add(npc);
    }

    void untrackNpc(NPC npc)
    {
        trackedNpcs.values().forEach(npcs -> npcs.remove(npc));
        trackedNpcs.values().removeIf(Set::isEmpty);
    }

    void clearNpcs() { trackedNpcs.clear(); }

    void seedNpcs()
    {
        clearNpcs();
        WorldView view = client.getTopLevelWorldView();
        if (view != null) for (NPC npc : view.npcs()) trackNpc(npc);
    }

    private static final Color PINK =
            new Color(
                    255,
                    20,
                    147
            );

    private static final Color PINK_FILL =
            new Color(
                    255,
                    20,
                    147,
                    45
            );

    private static final Color ROUTE_BLUE = new Color(95, 180, 255);

    private static final Color WHITE =
            Color.WHITE;

    private static final int WORLD_MAP_MARKER_WIDTH =
            24;

    private static final int WORLD_MAP_MARKER_HEIGHT =
            30;

    private static final int MINIMAP_ARROW_LENGTH =
            13;

    private static final int MINIMAP_ARROW_HALF_WIDTH =
            6;

    private static final BufferedImage WORLD_MAP_MARKER_IMAGE =
            createWorldMapMarkerImage();

    private final Client client;
    private final QuestPrepConfig config;
    private final WorldMapPointManager worldMapPointManager;

    private volatile GatheringStep activeStep;
    private WorldMapPoint activeWorldMapPoint;

    /*
     * Shared ownership tracker so the HUD can show live
     * bank + GIM + inventory stage progress.
     */
    private BankTracker bankTracker;

    @Inject
    RouteGuidanceOverlay(
            Client client,
            QuestPrepConfig config,
            WorldMapPointManager worldMapPointManager)
    {
        this.client =
                client;

        this.config =
                config;

        this.worldMapPointManager =
                worldMapPointManager;

        setPosition(
                OverlayPosition.DYNAMIC
        );

        setLayer(
                OverlayLayer.ABOVE_SCENE
        );

        setPriority(
                PRIORITY_HIGH
        );
    }

    /*
     * =====================================================
     * ACTIVE ROUTE
     * =====================================================
     */

    public void setActiveStep(
            GatheringStep activeStep)
    {
        this.activeStep =
                activeStep;
        if (activeStep != null && config.routeGuidance())
        {
            syncWorldMapPoint(activeStep.getTarget(), activeStep.getTarget().getWorldPoint());
        }
        else
        {
            clearWorldMapPoint();
        }
    }

    public void clearActiveStep()
    {
        activeStep =
                null;

        clearWorldMapPoint();
    }

    public GatheringStep getActiveStep()
    {
        return activeStep;
    }

    public void setBankTracker(
            BankTracker bankTracker)
    {
        this.bankTracker =
                bankTracker;
    }

    /*
     * =====================================================
     * WORLD MAP DESTINATION
     * =====================================================
     *
     * The world-map point mirrors the currently active
     * route destination. It is kept here so every route
     * change automatically stays in sync with the scene /
     * minimap guidance.
     */

    private void syncWorldMapPoint(
            GatheringTarget target,
            WorldPoint targetWorldPoint)
    {
        if (target == null
                || targetWorldPoint == null
                || activeStep == null)
        {
            clearWorldMapPoint();

            return;
        }

        String tooltip =
                buildWorldMapTooltip(
                        target
                );

        if (activeWorldMapPoint != null
                && targetWorldPoint.equals(
                activeWorldMapPoint.getWorldPoint()
        )
                && tooltip.equals(
                activeWorldMapPoint.getTooltip()
        ))
        {
            return;
        }

        clearWorldMapPoint();

        WorldMapPoint mapPoint =
                new WorldMapPoint(
                        targetWorldPoint,
                        WORLD_MAP_MARKER_IMAGE
                );

        /*
         * Anchor the pointed end of the pink marker to the
         * destination tile rather than centring the whole
         * image over it.
         */
        mapPoint.setImagePoint(
                new Point(
                        WORLD_MAP_MARKER_WIDTH / 2,
                        WORLD_MAP_MARKER_HEIGHT - 2
                )
        );

        mapPoint.setTooltip(
                tooltip
        );

        mapPoint.setName(
                "Ironman Quest Prep - "
                        + activeStep.getItemName()
        );

        mapPoint.setJumpOnClick(
                true
        );

        mapPoint.setTarget(
                targetWorldPoint
        );

        /*
         * Keep a directional marker visible at the edge of
         * the world map when the destination itself is
         * outside the current map viewport.
         */
        mapPoint.setSnapToEdge(
                true
        );

        worldMapPointManager.add(
                mapPoint
        );

        activeWorldMapPoint =
                mapPoint;
    }

    private void clearWorldMapPoint()
    {
        if (activeWorldMapPoint == null)
        {
            return;
        }

        worldMapPointManager.remove(
                activeWorldMapPoint
        );

        activeWorldMapPoint =
                null;
    }

    private String buildWorldMapTooltip(
            GatheringTarget target)
    {
        String itemName =
                activeStep == null
                        ? ""
                        : activeStep.getItemName();

        int quantity =
                activeStep == null
                        ? 0
                        : activeStep.getQuantityNeeded();

        StringBuilder tooltip =
                new StringBuilder(
                        "Ironman Quest Prep"
                );

        if (itemName != null
                && !itemName.trim().isEmpty())
        {
            tooltip
                    .append("<br>")
                    .append("Need ")
                    .append(quantity)
                    .append(" x ")
                    .append(itemName.trim());
        }

        if (target != null)
        {
            tooltip
                    .append("<br>")
                    .append(target.getDisplayText());
        }

        return tooltip.toString();
    }

    private static BufferedImage createWorldMapMarkerImage()
    {
        BufferedImage image =
                new BufferedImage(
                        WORLD_MAP_MARKER_WIDTH,
                        WORLD_MAP_MARKER_HEIGHT,
                        BufferedImage.TYPE_INT_ARGB
                );

        Graphics2D graphics =
                image.createGraphics();

        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        /*
         * Marker tail.
         */
        Polygon tail =
                new Polygon(
                        new int[]
                                {
                                        7,
                                        WORLD_MAP_MARKER_WIDTH / 2,
                                        17
                                },
                        new int[]
                                {
                                        17,
                                        WORLD_MAP_MARKER_HEIGHT - 2,
                                        17
                                },
                        3
                );

        graphics.setColor(
                PINK
        );

        graphics.fill(
                tail
        );

        /*
         * Main marker circle.
         */
        graphics.fillOval(
                2,
                2,
                20,
                20
        );

        graphics.setColor(
                Color.BLACK
        );

        graphics.setStroke(
                new BasicStroke(
                        2.0f
                )
        );

        graphics.drawOval(
                2,
                2,
                20,
                20
        );

        graphics.setColor(
                WHITE
        );

        graphics.fillOval(
                8,
                8,
                8,
                8
        );

        graphics.dispose();

        return image;
    }

    /*
     * =====================================================
     * RENDER
     * =====================================================
     */

    @Override
    public Dimension render(
            Graphics2D graphics)
    {
        if (!config.routeGuidance())
        {
            clearWorldMapPoint();

            return null;
        }

        if (activeStep == null)
        {
            clearWorldMapPoint();

            return null;
        }

        GatheringTarget target =
                activeStep.getTarget();

        if (target == null
                || !target.isNavigable())
        {
            clearWorldMapPoint();

            return null;
        }

        WorldPoint targetWorldPoint =
                navigationPoint(target);

        if (targetWorldPoint == null)
        {
            clearWorldMapPoint();

            return null;
        }

        /*
         * Keep the active world-map marker synchronized with
         * the same target used by the HUD/minimap/scene
         * guidance.
         */
        syncWorldMapPoint(
                target,
                targetWorldPoint
        );

        /*
         * HUD stays visible even when the destination is
         * outside the currently loaded scene.
         */
        drawRouteHud(
                graphics,
                target,
                targetWorldPoint
        );

        if (client.isInInstancedRegion())
        {
            return null;
        }

        LocalPoint localPoint =
                null;

        if (targetWorldPoint.getPlane()
                == client.getPlane())
        {
            localPoint =
                    LocalPoint.fromWorld(
                            client,
                            targetWorldPoint.getX(),
                            targetWorldPoint.getY()
                    );
        }

        /*
         * Highlight actual NPC when it is loaded.
         */
        if (target.getType()
                == GatheringTarget.TargetType.NPC
                && target.hasTargetId())
        {
            NPC npc =
                    findTargetNpc(
                            target
                    );

            if (npc != null)
            {
                drawNpcHighlight(
                        graphics,
                        npc,
                        target
                );

                return null;
            }
        }

        /*
         * Fallback scene marker for areas, objects and tiles.
         */
        if (localPoint == null)
        {
            return null;
        }

        drawTargetTile(
                graphics,
                localPoint,
                target
        );

        return null;
    }

    /*
     * =====================================================
     * MINIMAP
     * =====================================================
     */

    /** Called only by the ABOVE_WIDGETS minimap overlay. */
    void renderMinimap(Graphics2D graphics)
    {
        if (!config.routeGuidance() || activeStep == null || client.getLocalPlayer() == null)
        {
            return;
        }
        GatheringTarget target = activeStep.getTarget();
        if (target == null || !target.isNavigable() || client.isInInstancedRegion())
        {
            return;
        }
        Rectangle bounds = minimapBounds();
        if (bounds == null) return;
        Graphics2D minimap = (Graphics2D) graphics.create();
        try
        {
            double diameter = Math.min(bounds.width, bounds.height);
            minimap.clip(new Ellipse2D.Double(bounds.getCenterX() - diameter / 2,
                    bounds.getCenterY() - diameter / 2, diameter, diameter));
            minimap.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                    minimapArrowOpacity(System.nanoTime() / 1_000_000L, config.flashMinimapArrow())));
            WorldPoint destination = navigationPoint(target);
            LocalPoint local = LocalPoint.fromWorld(client, destination.getX(), destination.getY());
            if (local == null || !drawMinimapMarker(minimap, local))
                drawDistantMinimapArrow(minimap, destination);
        }
        finally
        {
            minimap.dispose();
        }
    }

    static float minimapArrowOpacity(long milliseconds, boolean flash)
    {
        if (!flash) return 1f;
        // One smooth pulse per second; never disappear completely.
        double phase = Math.floorMod(milliseconds, 1000L) / 1000.0;
        return (float) (0.7 + 0.3 * Math.cos(phase * 2 * Math.PI));
    }
    private WorldPoint navigationPoint(GatheringTarget target)
    {
        NPC npc = target.getType() == GatheringTarget.TargetType.NPC ? findTargetNpc(target) : null;
        return npc == null ? target.getWorldPoint() : npc.getWorldLocation();
    }

    private boolean drawMinimapMarker(Graphics2D graphics, LocalPoint localPoint)
    {
        Point destination = Perspective.localToMinimap(client, localPoint);
        if (!insideMinimap(destination, minimapBounds(), 18)) return false;
        Point origin = Perspective.localToMinimap(client, client.getLocalPlayer().getLocalLocation());
        if (origin == null) return false;
        if (origin.getX() == destination.getX() && origin.getY() == destination.getY())
            origin = new Point(destination.getX(), destination.getY() - 16);
        drawMinimapArrowHead(graphics, origin, destination);
        return true;
    }
    /*
     * =====================================================
     * DISTANT MINIMAP ARROW
     * =====================================================
     *
     * World destinations can be hundreds of tiles away and therefore have
     * no LocalPoint in the currently loaded scene. Instead of losing the
     * minimap guidance, project a short local vector in the same world
     * direction and place its arrow inside the minimap widget bounds.
     *
     * Using Perspective.localToMinimap for the proxy means RuneLite handles
     * minimap rotation and zoom. We never need to duplicate that maths here.
     */
    private Rectangle minimapBounds()
    {
        int id = !client.isResized() ? InterfaceID.Toplevel.MINIMAP
                : client.getVarbitValue(VarbitID.RESIZABLE_STONE_ARRANGEMENT) == 1
                ? InterfaceID.ToplevelPreEoc.MINIMAP : InterfaceID.ToplevelOsrsStretch.MINIMAP;
        Widget widget = client.getWidget(id);
        return widget == null || widget.isHidden() ? null : widget.getBounds();
    }

    static boolean insideMinimap(Point point, Rectangle bounds, int inset)
    {
        if (point == null || bounds == null) return false;
        double radius = Math.min(bounds.width, bounds.height) / 2.0 - inset;
        return radius > 0 && Math.hypot(point.getX() - bounds.getCenterX(),
                point.getY() - bounds.getCenterY()) <= radius;
    }

    static Point minimapEdgePoint(Point origin, Point projected, Rectangle bounds)
    {
        if (origin == null || projected == null || bounds == null) return null;
        double dx = projected.getX() - origin.getX();
        double dy = projected.getY() - origin.getY();
        double length = Math.hypot(dx, dy);
        double radius = Math.min(bounds.width, bounds.height) / 2.0 - 10;
        if (length == 0 || radius <= 0) return null;
        return new Point((int) Math.round(bounds.getCenterX() + dx / length * radius),
                (int) Math.round(bounds.getCenterY() + dy / length * radius));
    }

    private void drawDistantMinimapArrow(Graphics2D graphics, WorldPoint destination)
    {
        Player player = client.getLocalPlayer();
        Rectangle bounds = minimapBounds();
        if (player == null || destination == null || bounds == null) return;
        WorldPoint position = player.getWorldLocation();
        LocalPoint local = player.getLocalLocation();
        double dx = destination.getX() - position.getX();
        double dy = destination.getY() - position.getY();
        double length = Math.hypot(dx, dy);
        if (length == 0 || local == null) return;
        // RuneLite projects rotation and zoom; only the edge placement is ours.
        LocalPoint proxy = local.plus((int) Math.round(dx / length * 4 * Perspective.LOCAL_TILE_SIZE),
                (int) Math.round(dy / length * 4 * Perspective.LOCAL_TILE_SIZE));
        Point origin = Perspective.localToMinimap(client, local);
        Point projected = Perspective.localToMinimap(client, proxy);
        Point tip = minimapEdgePoint(origin, projected, bounds);
        if (tip != null)
        {
            drawMinimapArrowHead(graphics,
                    new Point((int) bounds.getCenterX(), (int) bounds.getCenterY()), tip);
        }
    }

    private void drawMinimapArrowHead(
            Graphics2D graphics,
            Point playerPoint,
            Point tipPoint)
    {
        int vectorX =
                tipPoint.getX()
                        - playerPoint.getX();

        int vectorY =
                tipPoint.getY()
                        - playerPoint.getY();

        double length =
                Math.sqrt(
                        (double) vectorX * vectorX
                                + (double) vectorY * vectorY
                );

        if (length <= 0)
        {
            return;
        }

        double unitX =
                vectorX / length;

        double unitY =
                vectorY / length;

        double perpendicularX =
                -unitY;

        double perpendicularY =
                unitX;

        int backX =
                tipPoint.getX()
                        - (int) Math.round(
                        unitX
                                * MINIMAP_ARROW_LENGTH
                );

        int backY =
                tipPoint.getY()
                        - (int) Math.round(
                        unitY
                                * MINIMAP_ARROW_LENGTH
                );

        int leftX =
                backX
                        + (int) Math.round(
                        perpendicularX
                                * MINIMAP_ARROW_HALF_WIDTH
                );

        int leftY =
                backY
                        + (int) Math.round(
                        perpendicularY
                                * MINIMAP_ARROW_HALF_WIDTH
                );

        int rightX =
                backX
                        - (int) Math.round(
                        perpendicularX
                                * MINIMAP_ARROW_HALF_WIDTH
                );

        int rightY =
                backY
                        - (int) Math.round(
                        perpendicularY
                                * MINIMAP_ARROW_HALF_WIDTH
                );

        Polygon arrow =
                new Polygon(
                        new int[]
                                {
                                        tipPoint.getX(),
                                        leftX,
                                        rightX
                                },
                        new int[]
                                {
                                        tipPoint.getY(),
                                        leftY,
                                        rightY
                                },
                        3
                );

        Color previousColor =
                graphics.getColor();

        Stroke previousStroke =
                graphics.getStroke();

        graphics.setColor(
                Color.BLACK
        );

        graphics.setStroke(
                new BasicStroke(
                        4.0f,
                        BasicStroke.CAP_ROUND,
                        BasicStroke.JOIN_ROUND
                )
        );

        graphics.draw(
                arrow
        );

        graphics.setColor(
                PINK
        );

        graphics.fill(
                arrow
        );

        graphics.setStroke(
                new BasicStroke(
                        1.5f,
                        BasicStroke.CAP_ROUND,
                        BasicStroke.JOIN_ROUND
                )
        );

        graphics.draw(
                arrow
        );

        graphics.setStroke(
                previousStroke
        );

        graphics.setColor(
                previousColor
        );
    }

    /*
     * =====================================================
     * NPC LOOKUP
     * =====================================================
     */

    private NPC findTargetNpc(
            GatheringTarget target)
    {
        if (target == null
                || !target.hasTargetId())
        {
            return null;
        }

        WorldView worldView =
                client.getTopLevelWorldView();

        if (worldView == null)
        {
            return null;
        }

        WorldPoint expectedLocation =
                target.getWorldPoint();

        NPC bestMatch =
                null;

        long bestDistance =
                Long.MAX_VALUE;

        for (NPC npc : trackedNpcs.getOrDefault(target.getTargetId(), Collections.emptySet()))
        {
            if (npc == null)
            {
                continue;
            }

            if (npc.getId()
                    != target.getTargetId())
            {
                continue;
            }

            WorldPoint npcLocation =
                    npc.getWorldLocation();

            long distance =
                    worldDistance(
                            expectedLocation,
                            npcLocation
                    );

            if (npcLocation.getPlane() != client.getPlane() || distance > 32)
            {
                continue;
            }

            if (bestMatch == null
                    || distance < bestDistance)
            {
                bestMatch =
                        npc;

                bestDistance =
                        distance;
            }
        }

        return bestMatch;
    }

    /*
     * =====================================================
     * NPC HIGHLIGHT
     * =====================================================
     */

    private void drawNpcHighlight(
            Graphics2D graphics,
            NPC npc,
            GatheringTarget target)
    {
        Shape hull =
                npc.getConvexHull();

        if (hull != null)
        {
            Color previousColor =
                    graphics.getColor();

            Stroke previousStroke =
                    graphics.getStroke();

            graphics.setColor(
                    PINK_FILL
            );

            graphics.fill(
                    hull
            );

            graphics.setColor(
                    PINK
            );

            graphics.setStroke(
                    new BasicStroke(
                            3.0f
                    )
            );

            graphics.draw(
                    hull
            );

            graphics.setStroke(
                    previousStroke
            );

            graphics.setColor(
                    previousColor
            );
        }

        String targetName =
                target.getTargetName();

        if (targetName == null
                || targetName.trim().isEmpty())
        {
            targetName =
                    activeStep.getItemName();
        }

        OverlayUtil.renderActorOverlay(
                graphics,
                npc,
                "Next: "
                        + targetName,
                PINK
        );
    }

    /*
     * =====================================================
     * ROUTE HUD
     * =====================================================
     */

    private void drawRouteHud(
            Graphics2D graphics,
            GatheringTarget target,
            WorldPoint targetWorldPoint)
    {
        Player localPlayer =
                client.getLocalPlayer();

        if (localPlayer == null)
        {
            return;
        }

        WorldPoint playerWorldPoint =
                localPlayer.getWorldLocation();

        if (playerWorldPoint == null)
        {
            return;
        }

        int deltaX =
                targetWorldPoint.getX()
                        - playerWorldPoint.getX();

        int deltaY =
                targetWorldPoint.getY()
                        - playerWorldPoint.getY();

        int distance =
                Math.max(
                        Math.abs(
                                deltaX
                        ),
                        Math.abs(
                                deltaY
                        )
                );

        String direction =
                getDirection(
                        deltaX,
                        deltaY
                );

        String targetName =
                target.getTargetName();

        if (targetName == null
                || targetName.trim().isEmpty())
        {
            targetName =
                    activeStep.getItemName();
        }

        OverlayUtil.renderTextLocation(
                graphics,
                new Point(
                        20,
                        45
                ),
                "Route: "
                        + targetName,
                ROUTE_BLUE
        );

        OverlayUtil.renderTextLocation(
                graphics,
                new Point(
                        20,
                        61
                ),
                activeStep.getItemName()
                        + " - Need "
                        + activeStep.getQuantityNeeded(),
                ROUTE_BLUE
        );

        ActiveStageInfo stageInfo =
                findActiveStageInfo();

        int directionY;

        if (stageInfo != null)
        {
            OverlayUtil.renderTextLocation(
                    graphics,
                    new Point(
                            20,
                            77
                    ),
                    buildStageText(
                            stageInfo
                    ),
                    ROUTE_BLUE
            );

            directionY =
                    93;
        }
        else
        {
            directionY =
                    77;
        }

        OverlayUtil.renderTextLocation(
                graphics,
                new Point(
                        20,
                        directionY
                ),
                client.isInInstancedRegion()
                        ? "Destination is outside this instance"
                        : direction + " | " + distance + " tiles (straight line)"
                        + (targetWorldPoint.getPlane() == playerWorldPoint.getPlane()
                        ? "" : " | Go " + (targetWorldPoint.getPlane() > playerWorldPoint.getPlane()
                        ? "up" : "down") + " to floor " + targetWorldPoint.getPlane()),
                ROUTE_BLUE
        );


    }

    /*
     * =====================================================
     * LIVE STAGE TEXT
     * =====================================================
     */

    private String buildStageText(
            ActiveStageInfo stageInfo)
    {
        StringBuilder text =
                new StringBuilder();

        text.append(
                "Stage "
        );

        text.append(
                stageInfo.stageNumber
        );

        text.append(
                "/"
        );

        text.append(
                stageInfo.stageCount
        );

        text.append(
                ": "
        );

        text.append(
                stageInfo.stage.getName()
        );

        if (bankTracker != null
                && stageInfo.stage
                .hasCompletionRequirement())
        {
            int owned =
                    stageInfo.stage
                            .getOwnedQuantity(
                                    bankTracker
                            );

            int required =
                    stageInfo.stage
                            .getCompletionQuantity();

            text.append(
                    " ("
            );

            text.append(
                    Math.min(
                            owned,
                            required
                    )
            );

            text.append(
                    "/"
            );

            text.append(
                    required
            );

            text.append(
                    ")"
            );
        }

        return text.toString();
    }

    /*
     * =====================================================
     * ACTIVE STAGE DETECTION
     * =====================================================
     */

    private ActiveStageInfo findActiveStageInfo()
    {
        if (activeStep == null
                || !activeStep.hasStages())
        {
            return null;
        }

        GatheringTarget activeTarget =
                activeStep.getTarget();

        if (activeTarget == null)
        {
            return null;
        }

        List<GatheringStage> stages =
                activeStep.getStages();

        for (int index = 0;
             index < stages.size();
             index++)
        {
            GatheringStage stage =
                    stages.get(
                            index
                    );

            if (stage == null)
            {
                continue;
            }

            if (sameTarget(
                    activeTarget,
                    stage.getTarget()))
            {
                return new ActiveStageInfo(
                        stage,
                        index + 1,
                        stages.size()
                );
            }
        }

        return null;
    }

    private boolean sameTarget(
            GatheringTarget first,
            GatheringTarget second)
    {
        if (first == null
                || second == null)
        {
            return false;
        }

        if (first.getType()
                != second.getType())
        {
            return false;
        }

        if (first.getTargetId()
                != second.getTargetId())
        {
            return false;
        }

        WorldPoint firstPoint =
                first.getWorldPoint();

        WorldPoint secondPoint =
                second.getWorldPoint();

        if (firstPoint == null
                && secondPoint != null)
        {
            return false;
        }

        if (firstPoint != null
                && secondPoint == null)
        {
            return false;
        }

        if (firstPoint != null)
        {
            if (firstPoint.getX()
                    != secondPoint.getX())
            {
                return false;
            }

            if (firstPoint.getY()
                    != secondPoint.getY())
            {
                return false;
            }

            if (firstPoint.getPlane()
                    != secondPoint.getPlane())
            {
                return false;
            }
        }

        return safeText(
                first.getTargetName()
        ).equalsIgnoreCase(
                safeText(
                        second.getTargetName()
                )
        );
    }

    /*
     * =====================================================
     * DIRECTION ARROW
     * =====================================================
     */

    private void drawTargetTile(
            Graphics2D graphics,
            LocalPoint localPoint,
            GatheringTarget target)
    {
        Polygon polygon =
                Perspective.getCanvasTilePoly(
                        client,
                        localPoint
                );

        if (polygon == null)
        {
            return;
        }

        Color previousColor =
                graphics.getColor();

        Stroke previousStroke =
                graphics.getStroke();

        graphics.setColor(
                PINK_FILL
        );

        graphics.fill(
                polygon
        );

        graphics.setColor(
                PINK
        );

        graphics.setStroke(
                new BasicStroke(
                        3.0f
                )
        );

        graphics.draw(
                polygon
        );

        graphics.setStroke(
                previousStroke
        );

        graphics.setColor(
                previousColor
        );

        String targetName =
                target.getTargetName();

        if (targetName == null
                || targetName.trim().isEmpty())
        {
            targetName =
                    activeStep.getItemName();
        }

        String text =
                "Next: "
                        + targetName;

        Point textLocation =
                Perspective.getCanvasTextLocation(
                        client,
                        graphics,
                        localPoint,
                        text,
                        0
                );

        if (textLocation != null)
        {
            OverlayUtil.renderTextLocation(
                    graphics,
                    textLocation,
                    text,
                    PINK
            );
        }
    }

    /*
     * =====================================================
     * DISTANCE
     * =====================================================
     */

    private long worldDistance(
            WorldPoint first,
            WorldPoint second)
    {
        if (first == null
                || second == null)
        {
            return Long.MAX_VALUE;
        }

        long x =
                Math.abs(
                        (long) first.getX()
                                - second.getX()
                );

        long y =
                Math.abs(
                        (long) first.getY()
                                - second.getY()
                );

        long distance =
                Math.max(
                        x,
                        y
                );

        if (first.getPlane()
                != second.getPlane())
        {
            distance +=
                    10000L;
        }

        return distance;
    }

    /*
     * =====================================================
     * DIRECTION TEXT
     * =====================================================
     */

    private String getDirection(
            int deltaX,
            int deltaY)
    {
        if (deltaX == 0
                && deltaY == 0)
        {
            return "Here";
        }

        double angle =
                Math.toDegrees(
                        Math.atan2(
                                deltaY,
                                deltaX
                        )
                );

        if (angle >= 67.5
                && angle < 112.5)
        {
            return "North";
        }

        if (angle >= 22.5
                && angle < 67.5)
        {
            return "North-east";
        }

        if (angle >= -22.5
                && angle < 22.5)
        {
            return "East";
        }

        if (angle >= -67.5
                && angle < -22.5)
        {
            return "South-east";
        }

        if (angle >= -112.5
                && angle < -67.5)
        {
            return "South";
        }

        if (angle >= -157.5
                && angle < -112.5)
        {
            return "South-west";
        }

        if (angle >= 112.5
                && angle < 157.5)
        {
            return "North-west";
        }

        return "West";
    }

    private String safeText(
            String value)
    {
        return value == null
                ? ""
                : value.trim();
    }

    /*
     * =====================================================
     * STAGE HUD DATA
     * =====================================================
     */

    private static final class ActiveStageInfo
    {
        private final GatheringStage stage;
        private final int stageNumber;
        private final int stageCount;

        private ActiveStageInfo(
                GatheringStage stage,
                int stageNumber,
                int stageCount)
        {
            this.stage =
                    stage;

            this.stageNumber =
                    stageNumber;

            this.stageCount =
                    stageCount;
        }
    }
}