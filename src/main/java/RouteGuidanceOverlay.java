package com.ironquestprep;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.inject.Inject;
import net.runelite.api.Client;
import net.runelite.api.HintArrowType;
import net.runelite.api.Point;
import net.runelite.api.coords.WorldPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPoint;
import net.runelite.client.ui.overlay.worldmap.WorldMapPointManager;

/** Destination changes use the client's hint arrow; there is no per-frame route overlay. */
public class RouteGuidanceOverlay {
    private static final Color PINK = new Color(255, 20, 147);
    private static final Color WHITE = Color.WHITE;
    private static final int WORLD_MAP_MARKER_WIDTH = 24;
    private static final int WORLD_MAP_MARKER_HEIGHT = 30;
    private static final BufferedImage WORLD_MAP_MARKER_IMAGE = createWorldMapMarkerImage();
    private final Client client;
    private final QuestPrepConfig config;
    private final WorldMapPointManager worldMapPointManager;
    private GatheringStep activeStep;
    private WorldMapPoint mapPoint;
    private WorldPoint ownedArrow;

    @Inject
    RouteGuidanceOverlay(Client client, QuestPrepConfig config, WorldMapPointManager manager) {
        this.client = client;
        this.config = config;
        this.worldMapPointManager = manager;
    }

    public GatheringStep getActiveStep() { return activeStep; }

    public void setActiveStep(GatheringStep step) {
        activeStep = step;
        if (step == null || !config.routeGuidance() || !step.hasNavigationTarget()) {
            clearMarkers();
            return;
        }
        WorldPoint point = step.getTarget().getWorldPoint();
        // Ownership refreshes must not repeatedly replace an arrow set by another plugin.
        if (mapPoint != null && point.equals(mapPoint.getWorldPoint())) return;
        clearMarkers();
        client.setHintArrow(point);
        ownedArrow = point;
        mapPoint = new WorldMapPoint(point, WORLD_MAP_MARKER_IMAGE);
        mapPoint.setImagePoint(new Point(WORLD_MAP_MARKER_WIDTH / 2, WORLD_MAP_MARKER_HEIGHT - 2));
        mapPoint.setName("Ironman Quest Prep - " + step.getItemName());
        mapPoint.setTooltip(step.getItemName() + "<br>" + step.getTarget().getDisplayText());
        mapPoint.setTarget(point);
        mapPoint.setJumpOnClick(true);
        mapPoint.setSnapToEdge(true);
        worldMapPointManager.add(mapPoint);
    }

    public void clearActiveStep() {
        activeStep = null;
        clearMarkers();
    }

    private void clearMarkers() {
        if (ownedArrow != null && ownsHintArrow(ownedArrow, client.getHintArrowType(), client.getHintArrowPoint())) client.clearHintArrow();
        ownedArrow = null;
        if (mapPoint != null) worldMapPointManager.remove(mapPoint);
        mapPoint = null;
    }

    static boolean ownsHintArrow(WorldPoint owned, int type, WorldPoint current) {
        return owned != null && type == HintArrowType.COORDINATE && owned.equals(current);
    }

    private static BufferedImage createWorldMapMarkerImage() {
        BufferedImage image =
                new BufferedImage(
                        WORLD_MAP_MARKER_WIDTH,
                        WORLD_MAP_MARKER_HEIGHT,
                        BufferedImage.TYPE_INT_ARGB);

        Graphics2D graphics = image.createGraphics();

        graphics.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        /*
         * Marker tail.
         */
        Polygon tail =
                new Polygon(
                        new int[] {7, WORLD_MAP_MARKER_WIDTH / 2, 17},
                        new int[] {17, WORLD_MAP_MARKER_HEIGHT - 2, 17},
                        3);

        graphics.setColor(PINK);

        graphics.fill(tail);

        /*
         * Main marker circle.
         */
        graphics.fillOval(2, 2, 20, 20);

        graphics.setColor(Color.BLACK);

        graphics.setStroke(new BasicStroke(2.0f));

        graphics.drawOval(2, 2, 20, 20);

        graphics.setColor(WHITE);

        graphics.fillOval(8, 8, 8, 8);

        graphics.dispose();

        return image;
    }

}
