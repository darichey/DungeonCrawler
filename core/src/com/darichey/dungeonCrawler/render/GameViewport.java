package com.darichey.dungeonCrawler.render;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class GameViewport extends ScreenViewport
{
    public GameViewport(OrthographicCamera camera)
    {
        super(camera);
    }

    @Override
    public float getUnitsPerPixel()
    {
        return 1 / 16;
    }
}
