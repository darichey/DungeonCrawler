package com.darichey.dungeonCrawler.world;

import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.EntityPlayer;
import com.darichey.dungeonCrawler.entity.EntityWall;
import com.darichey.dungeonCrawler.entity.base.GameEntity;

import java.util.ArrayList;

public class World
{
    public EntityPlayer player;
    public ArrayList<GameEntity> entities = new ArrayList<GameEntity>();

    public World()
    {
        player = new EntityPlayer(new Vector2(0, 0));
        entities.add(player);
        generate();
    }

    private void generate()
    {
        for (int i = 0; i < 100; i++)
        {
            EntityWall wall = new EntityWall(new Vector2(i * 16, 0));
            entities.add(wall);
        }

        for (int i = 0; i < 100; i++)
        {
            EntityWall wall = new EntityWall(new Vector2(i * 16, 1600));
            entities.add(wall);
        }

        for (int i = 0; i < 98; i++)
        {
            EntityWall wall = new EntityWall(new Vector2(0, 16 + i * 16));
            entities.add(wall);
        }

        for (int i = 0; i < 98; i++)
        {
            EntityWall wall = new EntityWall(new Vector2(1600, 16 + i * 16));
            entities.add(wall);
        }

    }

    public void update()
    {

    }

    public ArrayList<EntityWall> getWalls()
    {
        ArrayList<EntityWall> returnArray = new ArrayList<EntityWall>();
        for (GameEntity entity : entities)
        {
            if (entity instanceof EntityWall)
            {
                returnArray.add((EntityWall) entity);
            }
        }
        return returnArray;
    }

    public GameEntity getEntityAt(Vector2 pos)
    {
        for (GameEntity entity : entities)
        {
            if (entity.getBounds().contains(pos.x, pos.y)) return entity;
        }
        return null;
    }
}
