package com.ironquestprep;

import net.runelite.api.HintArrowType;
import net.runelite.api.coords.WorldPoint;
import org.junit.Test;
import static org.junit.Assert.*;

public class NativeMarkerTest {
    @Test public void clearsOnlyItsOwnWorldPositionArrow() {
        WorldPoint own = new WorldPoint(3097, 3257, 0);
        assertTrue(RouteGuidanceOverlay.ownsHintArrow(own, HintArrowType.COORDINATE, own));
        assertFalse(RouteGuidanceOverlay.ownsHintArrow(own, HintArrowType.COORDINATE, new WorldPoint(3000, 3200, 0)));
        assertFalse(RouteGuidanceOverlay.ownsHintArrow(own, HintArrowType.NPC, own));
        assertFalse(RouteGuidanceOverlay.ownsHintArrow(own, HintArrowType.NONE, null));
        assertFalse(RouteGuidanceOverlay.ownsHintArrow(null, HintArrowType.COORDINATE, own));
    }
}
