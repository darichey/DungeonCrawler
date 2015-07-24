package com.darichey.dungeonCrawler.world.chunk;

import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.init.Entities;
import com.darichey.dungeonCrawler.world.World;

import java.util.ArrayList;

public class Chunk
{
    private EntityTileMap entityTileMap = new EntityTileMap();
    // Side length of the chunk. Starts at 0.
    public static final int length = 15;
    private Vector2 pos = new Vector2();
    private World world;

    public Chunk(World world, Vector2 pos) throws IllegalArgumentException
    {
        this.world = world;
        this.pos = pos;

        for (Chunk chunk : world.chunks)
        {
            if (chunk.getPos() == this.getPos())
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

    // TODO: Make this get all types of blocks in a nicer way
    public ArrayList<Vector2> getBlockPositions()
    {
        ArrayList<Vector2> list = entityTileMap.getPositionsForEntity(Entities.block);
        list.addAll(entityTileMap.getPositionsForEntity(Entities.block2));
        return list;
    }

    public void generate()
    {

    }
}
