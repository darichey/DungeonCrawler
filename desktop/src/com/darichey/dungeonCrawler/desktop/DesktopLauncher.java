package com.darichey.dungeonCrawler.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.darichey.dungeonCrawler.DungeonCrawler;

public class DesktopLauncher
{
	public static void main (String[] arg)
    {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width  = 1600;
        config.height =  900;
        config.resizable = false;
        config.foregroundFPS = 0;
        config.backgroundFPS = -1;
		new LwjglApplication(new DungeonCrawler(), config);
	}
}
