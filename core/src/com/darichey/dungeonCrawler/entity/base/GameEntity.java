package com.darichey.dungeonCrawler.entity.base;

import com.badlogic.gdx.graphics.Texture;
import com.darichey.dungeonCrawler.item.placeable.ItemPlaceableBase;
import com.darichey.dungeonCrawler.world.World;

/**
 * The base entity in the game. All entities should inherit this class.
 */
public abstract class GameEntity {
    /**
     * The bounds of the entity *
     */
    public int height;
    public int width;

    /**
     * The texture of the entity *
     */
    public Texture texture;

    /**
     * The name of the entity.
     */
    public String name;

    /**
     * The world this entity belongs to
     */
    public World world;

    /**
     * The {@link com.darichey.dungeonCrawler.item.placeable.ItemPlaceableBase} associated with this entity.
     */
    public ItemPlaceableBase placeable;

    public Texture getTexture() {
        return this.texture;
    }

    public String getName() {
        return this.name;
    }

    public World getWorld() {
        return this.world;
    }

    public ItemPlaceableBase getPlaceable() {
        return this.placeable;
    }

    public void setPlaceable(ItemPlaceableBase placeable) {
        this.placeable = placeable;
    }
}
