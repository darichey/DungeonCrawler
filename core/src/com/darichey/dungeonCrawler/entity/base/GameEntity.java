package com.darichey.dungeonCrawler.entity.base;
import com.badlogic.gdx.graphics.Texture;
import com.darichey.dungeonCrawler.world.World;

/**
 * The base entity in the game. All entities should inherit this class.
 */
public abstract class GameEntity
{
    /** The bounds of the entity **/
    public int height;
    public int width;

    /** The texture of the entity **/
    public Texture texture;

    /** The world this entity belongs to */
    public World world;

    public Texture getTexture()
    {
        return this.texture;
    }

    public abstract String getName();

    public World getWorld()
    {
        return this.world;
    }
}
