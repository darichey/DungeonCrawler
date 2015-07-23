package com.darichey.dungeonCrawler.world;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.living.EntityPlayer;
import com.darichey.dungeonCrawler.entity.base.DynamicEntity;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.init.Entities;

import java.util.ArrayList;

public class World
{
    public static final int height = 100;
    public static final int width = 100;

    public EntityPlayer player;
    private EntityTileMap entityTileMap = new EntityTileMap();
    /**
     * List of dynamic entities in the world. Entities should add themselves to this on construction. *
     */
    private ArrayList<DynamicEntity> dynamicEntities = new ArrayList<DynamicEntity>();

    public World()
    {
        player = new EntityPlayer(this, new Vector2(1, 1));
        generate();
    }

    private void generate()
    {
        for (int x = 0; x < 60; x++)
        {
            setEntityAt(Entities.block, new Vector2(x, 0));
        }

        for (int x = 0; x < 60; x++)
        {
            setEntityAt(Entities.block, new Vector2(x, 31));
        }

        for (int y = 0; y < 30; y++)
        {
            setEntityAt(Entities.block, new Vector2(0, y + 1));
        }

        for (int y = 0; y < 30; y++)
        {
            setEntityAt(Entities.block, new Vector2(59, y + 1));
        }
    }

    public void update()
    {

    }

    public GameEntity getEntityAt(Vector2 pos)
    {
        GameEntity entity = entityTileMap.getEntityAt(pos);
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
        return entityTileMap.getEntityAt(pos);
    }

    public void setEntityAt(GameEntity entity, Vector2 pos)
    {
        entityTileMap.putEntityAt(entity, pos);
    }

    public ArrayList<DynamicEntity> getDynamicEntities()
    {
        return dynamicEntities;
    }

    public EntityTileMap getEntityTileMap()
    {
        return entityTileMap;
    }

    // TODO: Make this get all types of blocks in a nicer way
    public ArrayList<Vector2> getBlockPositions()
    {
        ArrayList<Vector2> list = entityTileMap.getPositionsForEntity(Entities.block);
        list.addAll(entityTileMap.getPositionsForEntity(Entities.block2));
        return list;
    }
}
