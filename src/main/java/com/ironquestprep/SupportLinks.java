package com.ironquestprep;

import net.runelite.client.util.LinkBrowser;

/** User-initiated support link. No account or game data is submitted. */
final class SupportLinks
{
    // Dedicated support invite supplied by the plugin owner.
    private static final String DISCORD_INVITE = "https://discord.gg/SzTtmUkv3";

    private SupportLinks() { }

    static boolean isAvailable()
    {
        return !DISCORD_INVITE.isEmpty();
    }

    static void openBugReport()
    {
        if (isAvailable()) LinkBrowser.browse(DISCORD_INVITE);
    }
}