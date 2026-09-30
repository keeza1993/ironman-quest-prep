package com.ironquestprep;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import static org.junit.Assert.*;

public class SkillRefreshScheduleTest {
    private long minutes(long n) { return TimeUnit.MINUTES.toNanos(n); }

    @Test public void refreshesInitiallyAndAfterThirtyMinutes() {
        SkillRefreshSchedule timer = new SkillRefreshSchedule();
        assertTrue(timer.refreshDue(0));
        assertFalse(timer.refreshDue(minutes(29)));
        assertTrue(timer.refreshDue(minutes(30)));
        assertFalse(timer.refreshDue(minutes(59)));
        assertTrue(timer.refreshDue(minutes(60)));
    }

    @Test public void loadingTimeDoesNotCount() {
        SkillRefreshSchedule timer = new SkillRefreshSchedule();
        assertTrue(timer.refreshDue(0));
        timer.setPlaying(false, minutes(10));
        timer.setPlaying(true, minutes(110));
        assertFalse(timer.refreshDue(minutes(129)));
        assertTrue(timer.refreshDue(minutes(130)));
    }

    @Test public void loginStartsWithAFreshSnapshot() {
        SkillRefreshSchedule timer = new SkillRefreshSchedule();
        assertTrue(timer.refreshDue(0));
        assertFalse(timer.refreshDue(minutes(5)));
        timer.reset();
        assertTrue(timer.refreshDue(minutes(100)));
        assertFalse(timer.refreshDue(minutes(129)));
    }
}
