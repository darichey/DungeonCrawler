package com.darichey.dungeonCrawler.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.darichey.dungeonCrawler.DungeonCrawler;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1920;
        config.height = 1017;
        config.resizable = true;
        new LwjglApplication(new DungeonCrawler(), config);
    }
}
