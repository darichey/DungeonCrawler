package com.darichey.dungeonCrawler.entity.base;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameEntity
{
    private Rectangle bounds = new Rectangle();
    public int height;
    public int width;

    public Rectangle getBounds()
    {
        return bounds;
    }

    public void setBounds(Rectangle bounds)
    {
        this.bounds = bounds;
    }

    public abstract Texture getTexture();

    public abstract String getName();

    /*
    REDO USING TILE MAP
    public boolean isOnScreen(OrthographicCamera camera)
    {
        Vector3 screenCoords = camera.project(new Vector3(getPos().x, getPos().y, 0));
        if (screenCoords.x < Gdx.graphics.getWidth() + 32 && screenCoords.x > -32)
        {
            if (screenCoords.y < Gdx.graphics.getHeight() + 32 && screenCoords.y > -32)
            {
                return true;
            }
        }
        return false;
    }
    */
}
