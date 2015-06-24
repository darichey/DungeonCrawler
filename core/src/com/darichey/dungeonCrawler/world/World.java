package com.darichey.dungeonCrawler.world;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.EntityPlayer;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.entity.base.LivingEntity;
import com.darichey.dungeonCrawler.init.Entities;

import java.util.ArrayList;

public class World
{
    public static final int height = 100;
    public static final int width  = 100;

    public EntityPlayer player;
    private EntityTileMap entityTileMap = new EntityTileMap();
    private ArrayList<LivingEntity> livingEntities = new ArrayList<LivingEntity>();

    public World()
    {
        player = new EntityPlayer(new Vector2(0, 0));
        livingEntities.add(player);
        generate();
        //entityTileMap.visualize();
    }

    private void generate()
    {
        //for (int y = 0; y < 5; y++)
        {
            for (int x = 0; x < 50; x++)
            {
                setEntityAt(Entities.wall, new Vector2(x, 0));
            }
        }

        for ( int y = 0; y < 27; y++)
        {
            setEntityAt(Entities.wall, new Vector2(0, y + 1));
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

    public ArrayList<LivingEntity> getLivingEntities()
    {
        return livingEntities;
    }

    public EntityTileMap getEntityTileMap()
    {
        return entityTileMap;
    }
}
