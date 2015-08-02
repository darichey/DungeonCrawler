package com.darichey.dungeonCrawler.world;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.living.EntityPlayer;
import com.darichey.dungeonCrawler.entity.base.DynamicEntity;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.init.Items;
import com.darichey.dungeonCrawler.item.stack.ItemStack;
import com.darichey.dungeonCrawler.world.chunk.Chunk;

import java.util.ArrayList;

public class World
{
    public static final int height = 128;
    public static final int width = 128;

    public EntityPlayer player;

    /**
     * List of chunks in the world. Chunks should add themselves to this on construction.
     */
    public ArrayList<Chunk> chunks = new ArrayList<Chunk>();

    /**
     * List of dynamic entities in the world. Entities should add themselves to this on construction.
     */
    private ArrayList<DynamicEntity> dynamicEntities = new ArrayList<DynamicEntity>();

    public World()
    {
        player = new EntityPlayer(this, new Vector2(13, 14));
        player.getInventory().setStackInSlot(0, new ItemStack(Items.stone, 2));
        generate();
    }

    private void generate()
    {
        for (int y = 0; y < height / Chunk.length; y++)
        {
            for (int x = 0; x < width / Chunk.length; x++)
            {
                Chunk chunk = new Chunk(this, new Vector2(x, y));
                chunk.generate();
            }
        }
    }

    public void update()
    {

    }

    public GameEntity getEntityAt(Vector2 pos)
    {
        Chunk chunk = getChunkFromWorldPos(pos);
        GameEntity entity = chunk.getEntityAt(chunk.getChunkPosForPos(pos));
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
        Chunk chunk = getChunkFromWorldPos(pos);
        chunk.setEntityAt(entity, chunk.getChunkPosForPos(pos));
    }

    public ArrayList<DynamicEntity> getDynamicEntities()
    {
        return dynamicEntities;
    }

    public ArrayList<Vector2> getBlockPositions()
    {
        ArrayList<Vector2> list = new ArrayList<Vector2>();
        for (Chunk chunk : chunks)
        {
            ArrayList<Vector2> chunkPoss = chunk.getBlockPositions();
            for (Vector2 blockPos : chunkPoss)
            {
                list.add(chunk.getWorldPosForPos(blockPos));
            }
        }
        return list;
    }

    public Chunk getChunkFromWorldPos(Vector2 worldPos)
    {
        Vector2 chunkPos = new Vector2((float) (Math.floor(worldPos.x / Chunk.length)), (float) (Math.floor(worldPos.y / Chunk.length)));
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
