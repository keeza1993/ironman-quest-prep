package com.ironquestprep;

import org.junit.Test;
import static org.junit.Assert.*;

public class MinimapPulseTest
{
    @Test public void reducedMotionKeepsArrowFullyVisible()
    {
        for (long time : new long[]{-1001, 0, 250, 500, 999, Long.MAX_VALUE})
            assertEquals(1f, RouteGuidanceOverlay.minimapArrowOpacity(time, false), 0f);
    }

    @Test public void pulseNeverDisappearsAndRepeatsOncePerSecond()
    {
        for (int time = -1000; time < 2000; time++)
        {
            float alpha = RouteGuidanceOverlay.minimapArrowOpacity(time, true);
            assertTrue(alpha >= 0.39f && alpha <= 1f);
            assertEquals(alpha, RouteGuidanceOverlay.minimapArrowOpacity(time + 1000, true), 0.0001f);
        }
        assertTrue(RouteGuidanceOverlay.minimapArrowOpacity(0, true)
                > RouteGuidanceOverlay.minimapArrowOpacity(500, true));
    }
}