package com.darichey.dungeonCrawler.entity.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public abstract class GameEntity
{
    private Vector2 pos = new Vector2();
    private Rectangle bounds = new Rectangle();

    public Vector2 getPos()
    {
        return pos;
    }

    public void setPos(Vector2 pos)
    {
        this.pos.set(pos);
    }

    public void setPosX(float posX)
    {
        setPos(new Vector2(posX, getPos().y));
    }

    public void setPosY(float posY)
    {
        setPos(new Vector2(getPos().x, posY));
    }

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
}
