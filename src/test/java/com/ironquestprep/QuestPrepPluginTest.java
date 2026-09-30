package com.ironquestprep;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;


public class QuestPrepPluginTest
{
    public static void main(String[] args) throws Exception {
        ExternalPluginManager.loadBuiltin(QuestPrepPlugin.class);
        RuneLite.main(args);
    }
}
