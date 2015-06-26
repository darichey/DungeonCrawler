package com.darichey.dungeonCrawler.entity.base;
import com.badlogic.gdx.graphics.Texture;

public abstract class GameEntity
{
    public int height;
    public int width;
    public Texture texture;

    public Texture getTexture()
    {
        return this.texture;
    }

    public abstract String getName();
}
