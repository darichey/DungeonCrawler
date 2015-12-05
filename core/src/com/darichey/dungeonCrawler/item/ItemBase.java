package com.darichey.dungeonCrawler.item;

import com.badlogic.gdx.graphics.Texture;
import com.darichey.dungeonCrawler.item.placeable.ItemPlaceableBase;

public abstract class ItemBase {
    /**
     * The texture of the item.
     */
    public Texture texture;

    /**
     * The name of the item
     */
    public String name;

    public Texture getTexture() {
        return this.texture;
    }

    public String getName() {
        return this.name;
    }

    public boolean isPlaceable() {
        return this instanceof ItemPlaceableBase;
    }
}
