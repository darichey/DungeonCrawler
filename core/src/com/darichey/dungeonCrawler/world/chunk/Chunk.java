package com.darichey.dungeonCrawler.world.chunk;

import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.entity.block.EntityBlock;
import com.darichey.dungeonCrawler.init.register.EntityRegistry;
import com.darichey.dungeonCrawler.init.Entities;
import com.darichey.dungeonCrawler.world.World;

import java.util.ArrayList;

/**
 * The world is made up of Chunks. Each chunk uses an {@link com.darichey.dungeonCrawler.world.chunk.EntityTileMap} to store information
 * about the blocks within the chunk. Chunks are square with their length decided by "length"
 */
public class Chunk
{
    /** Underlying tile map storing entity information**/
    private EntityTileMap entityTileMap = new EntityTileMap(length, length);
    // Side length of the chunk in blocks.
    public static final int length = 16;
    private Vector2 pos = new Vector2();
    /** The world this chunk belongs to. **/
    private World world;

    public Chunk(World world, Vector2 pos) throws IllegalArgumentException
    {
        this.world = world;
        this.pos = pos;

        for (Chunk chunk : world.chunks)
        {
            if (chunk.getPos().equals(this.getPos()))
            {
                throw new IllegalArgumentException("Two chunks in the same world may not share the same position.");
            }
        }

        this.world.chunks.add(this);
    }

    public Vector2 getPos()
    {
        return this.pos;
    }

    public World getWorld()
    {
        return this.world;
    }

    public GameEntity getEntityAt(Vector2 pos)
    {
        return entityTileMap.getEntityAt(pos);
    }

    public void setEntityAt(GameEntity entity, Vector2 pos)
    {
        entityTileMap.putEntityAt(entity, pos);
    }

    public ArrayList<Vector2> getBlockPositions()
    {
        ArrayList<Vector2> pos = new ArrayList<Vector2>();
        for (GameEntity entity : EntityRegistry.getRegisteredEntities())
        {
            if (entity instanceof EntityBlock)
            {
                pos.addAll(entityTileMap.getPositionsForEntity(entity));
            }
        }
        return pos;
    }

    public void generate()
    {
        for (int x = 0; x < length; x++)
        {
            setEntityAt(Entities.block, new Vector2(x, 0));
        }

        for (int x = 0; x < length; x++)
        {
            setEntityAt(Entities.block, new Vector2(x, length - 1));
        }

        for (int y = 1; y < length - 1; y++)
        {
            setEntityAt(Entities.block, new Vector2(0, y));
        }

        for (int y = 1; y < length - 1; y++)
        {
            setEntityAt(Entities.block, new Vector2(length - 1, y));
        }
    }

    /**
     * @param chunkPos Position within chunk
     * @return World position that corresponds with passed chunk pos
     */
    public Vector2 getWorldPosForPos(Vector2 chunkPos)
    {
        return new Vector2((getPos().x * length) + chunkPos.x, (getPos().y * length) + chunkPos.y);
    }

    /**
     * @param worldPos World position
     * @return Position within the chunk that corresponds with passed world pos
     */
    public Vector2 getChunkPosForPos(Vector2 worldPos)
    {
        float x = (float) Math.floor(worldPos.x / length) + (worldPos.x - (getPos().x * length)) - getPos().x;
        float y = (float) Math.floor(worldPos.y / length) + (worldPos.y - (getPos().y * length)) - getPos().y;
        return new Vector2(x, y);
    }

    public void visualizeMap()
    {
        this.entityTileMap.visualize();
    }
}
