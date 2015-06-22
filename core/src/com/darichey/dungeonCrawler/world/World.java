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
        player = new EntityPlayer(new Vector2(800, 450));
        entities.add(player);
        generate();
    }

    private void generate()
    {
        EntityWall wall = new EntityWall(new Vector2(800, 400));
        entities.add(wall);
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
}
