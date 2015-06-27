package com.darichey.dungeonCrawler.world;

import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.EntityPlayer;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.entity.base.DynamicEntity;
import com.darichey.dungeonCrawler.init.Entities;

import java.util.ArrayList;

public class World
{
    public static final int height = 100;
    public static final int width  = 100;

    public EntityPlayer player;
    private EntityTileMap entityTileMap = new EntityTileMap();
    private ArrayList<DynamicEntity> dynamicEntities = new ArrayList<DynamicEntity>();

    public World()
    {
        player = new EntityPlayer(new Vector2(0, 0));
        dynamicEntities.add(player);
        generate();
    }

    private void generate()
    {
        for (int x = 0; x < 50; x++)
        {
            setEntityAt(Entities.wall, new Vector2(x, 0));
        }

        for (int y = 0; y < 27; y++)
        {
            setEntityAt(Entities.wall, new Vector2(0, y + 1));
        }

        for (int y = 0; y < 25; y++)
        {
            for (int x = 0; x < 25; x++)
            {
                setEntityAt(Entities.wall, new Vector2(x + 5, y + 5));
            }
        }
    }

    public void update()
    {

    }

    public GameEntity getEntityAt(Vector2 pos)
    {
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
}
