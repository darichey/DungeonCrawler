package com.darichey.dungeonCrawler.entity.base;
import com.badlogic.gdx.graphics.Texture;

public abstract class GameEntity
{
    public int height;
    public int width;

    public abstract Texture getTexture();

    public abstract String getName();
}
