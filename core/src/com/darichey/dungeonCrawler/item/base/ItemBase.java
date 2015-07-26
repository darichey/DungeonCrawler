package com.darichey.dungeonCrawler.item.base;

import com.badlogic.gdx.graphics.Texture;

public abstract class ItemBase
{
    /**
     * The texture of the item.
     */
    public Texture texture;

    /**
     * The name of the item
     */
    public String name;

    public  Texture getTexture()
    {
        return this.texture;
    }

    public String getName()
    {
        return this.name;
    }
}
