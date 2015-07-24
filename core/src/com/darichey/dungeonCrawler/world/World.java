package com.darichey.dungeonCrawler.world;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.living.EntityPlayer;
import com.darichey.dungeonCrawler.entity.base.DynamicEntity;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.init.Entities;
import com.darichey.dungeonCrawler.world.chunk.Chunk;
import com.darichey.dungeonCrawler.world.chunk.EntityTileMap;

import java.util.ArrayList;

public class World
{
    public static final int height = 128;
    public static final int width = 128;

    public EntityPlayer player;
    public ArrayList<Chunk> chunks = new ArrayList<Chunk>();

    /**
     * List of dynamic entities in the world. Entities should add themselves to this on construction. *
     */
    private ArrayList<DynamicEntity> dynamicEntities = new ArrayList<DynamicEntity>();

    public World()
    {
        player = new EntityPlayer(this, new Vector2(13, 14));
        generate();
    }

    private void generate()
    {
        /*
        for (int y = 0; y < 8; y++)
        {
            for (int x = 0; x < 8; x++)
            {
                Chunk chunk = new Chunk(this, new Vector2(x, y));
                chunk.generate();
            }
        }
        */

        Chunk chunk = new Chunk(this, new Vector2(0,0));
        chunk.generate();
    }

    public void update()
    {

    }

    public GameEntity getEntityAt(Vector2 pos)
    {
        GameEntity entity = getChunkFromWorldPos(pos).getEntityAt(pos);
        if (entity == null)
        {
            for (DynamicEntity dynamicEntity : getDynamicEntities())
            {
                Rectangle bounds = dynamicEntity.getBounds();
                if (bounds.contains(pos.x, pos.y))
                {
                    return dynamicEntity;
                }
            }
        }
        return entity;
    }

    public void setEntityAt(GameEntity entity, Vector2 pos)
    {
        getChunkFromWorldPos(pos).setEntityAt(entity, pos);
    }

    public ArrayList<DynamicEntity> getDynamicEntities()
    {
        return dynamicEntities;
    }

    // TODO: Make this get all types of blocks in a nicer way
    public ArrayList<Vector2> getBlockPositions()
    {
        ArrayList<Vector2> list = new ArrayList<Vector2>();
        for (Chunk chunk : chunks)
        {
            for (Vector2 vector2 : chunk.getBlockPositions())
            {
                list.add(vector2);
            }
        }
        return list;
    }

    public Chunk getChunkFromWorldPos(Vector2 worldPos)
    {
        // FIXME: When passed 15, this returns 15, however I need it to return 0 for numbers 0-15.
        // FIXME: (Chunk.length*(Math.floor(Math.abs(worldPos.x/Chunk.length))))
        Vector2 chunkPos = new Vector2((float) (Chunk.length*(Math.floor(Math.abs(worldPos.x/Chunk.length)))), (float) (Chunk.length*(Math.floor(Math.abs(worldPos.y/Chunk.length)))));
        for (Chunk chunk : chunks)
        {
            if (chunk.getPos().equals(chunkPos))
            {
                return chunk;
            }
        }
        return null;
    }
}
