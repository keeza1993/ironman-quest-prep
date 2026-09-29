package com.ironquestprep;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import net.runelite.client.ui.overlay.Overlay;
import net.runelite.client.ui.overlay.OverlayLayer;
import net.runelite.client.ui.overlay.OverlayPosition;

/** Minimap guidance must be drawn after the minimap interface itself. */
public final class RouteMinimapOverlay extends Overlay
{
    private final RouteGuidanceOverlay guidance;

    @Inject
    RouteMinimapOverlay(RouteGuidanceOverlay guidance)
    {
        this.guidance = guidance;
        setPosition(OverlayPosition.DYNAMIC);
        setLayer(OverlayLayer.ABOVE_WIDGETS);
        setPriority(PRIORITY_HIGH);
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        guidance.renderMinimap(graphics);
        return null;
    }
}
