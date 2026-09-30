package com.ironquestprep;

import java.util.concurrent.TimeUnit;

/** Counts only time in the logged-in state, excluding loading and login screens. */
final class SkillRefreshSchedule {
    private static final long INTERVAL = TimeUnit.MINUTES.toNanos(30);
    private boolean playing;
    private boolean initial = true;
    private long lastTime;
    private long elapsed;

    void reset() {
        playing = false;
        initial = true;
        elapsed = 0;
    }

    void setPlaying(boolean next, long now) {
        if (playing) elapsed += now - lastTime;
        playing = next;
        lastTime = now;
    }

    boolean refreshDue(long now) {
        setPlaying(true, now);
        if (!initial && elapsed < INTERVAL) return false;
        initial = false;
        elapsed = 0;
        return true;
    }
}
