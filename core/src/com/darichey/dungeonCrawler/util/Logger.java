package com.darichey.dungeonCrawler.util;

import com.badlogic.gdx.Gdx;

public class Logger
{
    public static void log(String log)
    {
        Gdx.app.log("Dungeon Crawler", log);
    }
}
