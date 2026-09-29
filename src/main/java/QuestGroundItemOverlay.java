package com.ironquestprep;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

import net.runelite.api.Client;
import net.runelite.api.Perspective;
import net.runelite.api.Point;
import net.runelite.api.Tile;
import net.runelite.api.TileItem;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.OverlayUtil;

public class QuestGroundItemOverlay extends Overlay
{
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
                    35
            );

    private final Client client;
    private final QuestPrepPlugin plugin;
    private final QuestPrepConfig config;

    @Inject
    QuestGroundItemOverlay(
            Client client,
            QuestPrepPlugin plugin,
            QuestPrepConfig config)
    {
        this.client = client;
        this.plugin = plugin;
        this.config = config;

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

    @Override
    public Dimension render(
            Graphics2D graphics)
    {
        /*
         * Ground-item highlighting is completely
         * independent from route guidance.
         */
        if (!config.showGroundMarkers())
        {
            return null;
        }

        for (Tile tile
                : plugin.getGroundItemTiles())
        {
            if (tile == null)
            {
                continue;
            }

            Set<Integer> renderedIds =
                    new HashSet<>();

            int textOffset = 0;
            boolean tileHighlighted = false;

            for (TileItem tileItem
                    : tile.getGroundItems())
            {
                if (tileItem == null)
                {
                    continue;
                }

                int itemId =
                        tileItem.getId();

                if (!renderedIds.add(
                        itemId))
                {
                    continue;
                }

                String label =
                        plugin.getGroundItemLabel(
                                itemId
                        );

                if (label == null)
                {
                    continue;
                }

                if (!tileHighlighted)
                {
                    drawTileHighlight(
                            graphics,
                            tile
                    );

                    tileHighlighted = true;
                }

                String displayText =
                        label;

                if (tileItem.getQuantity() > 1)
                {
                    displayText +=
                            " | Ground x"
                                    + tileItem.getQuantity();
                }

                Point textLocation =
                        Perspective.getCanvasTextLocation(
                                client,
                                graphics,
                                tile.getLocalLocation(),
                                displayText,
                                0
                        );

                if (textLocation == null)
                {
                    continue;
                }

                Point adjusted =
                        new Point(
                                textLocation.getX(),
                                textLocation.getY()
                                        - textOffset
                        );

                OverlayUtil.renderTextLocation(
                        graphics,
                        adjusted,
                        displayText,
                        PINK
                );

                textOffset += 14;
            }
        }

        return null;
    }

    private void drawTileHighlight(
            Graphics2D graphics,
            Tile tile)
    {
        Polygon polygon =
                Perspective.getCanvasTilePoly(
                        client,
                        tile.getLocalLocation()
                );

        if (polygon == null)
        {
            return;
        }

        Color previous =
                graphics.getColor();

        graphics.setColor(
                PINK_FILL
        );

        graphics.fill(
                polygon
        );

        graphics.setColor(
                previous
        );

        OverlayUtil.renderPolygon(
                graphics,
                polygon,
                PINK
        );
    }
}