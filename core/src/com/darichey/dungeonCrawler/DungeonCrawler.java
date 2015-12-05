package com.darichey.dungeonCrawler;

import com.badlogic.gdx.Game;
import com.darichey.dungeonCrawler.screens.GameScreen;

public class DungeonCrawler extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}
