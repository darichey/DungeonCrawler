package com.darichey.dungeonCrawler;

import com.badlogic.gdx.Game;
import com.darichey.dungeonCrawler.screens.GameScreen;

public class DungeonCrawler extends Game
{
    @Override
    public void create()
    {
        int worldPos = 16;
        System.out.println((float) Math.floor(worldPos / 16) + (worldPos - (1 * 16)));
        setScreen(new GameScreen());
    }
}
