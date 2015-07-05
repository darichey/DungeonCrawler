package com.darichey.dungeonCrawler.world;

import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.entity.register.EntityRegistry;

import java.util.ArrayList;

/**
 * Generic tile map storing the NON-Dynamic entities in the world
 */
public class EntityTileMap
{
    /**
     * Underlying 2D array. Each position in the array stores an entity's ID found in {@link EntityRegistry} *
     */
    private int[][] entityMap = new int[World.width][World.height];

    public void putEntityAt(GameEntity entity, Vector2 worldPos)
    {
        int posX = (int) Math.floor(worldPos.x);
        int posY = (int) Math.floor(worldPos.y);
        if (entity == null)
        {
            entityMap[posX][posY] = 0;
        }
        else
        {
            entityMap[posX][posY] = EntityRegistry.getIDForEntity(entity);
        }
    }

    public GameEntity getEntityAt(Vector2 worldPos)
    {
        int id = entityMap[(int) Math.floor(worldPos.x)][(int) Math.floor(worldPos.y)];
        return EntityRegistry.getEntityFromID(id);
    }

    public ArrayList<Vector2> getPositionsForEntity(GameEntity entity)
    {
        ArrayList<Vector2> positions = new ArrayList<Vector2>();
        for (int y = 0; y < World.height; y++)
        {
            for (int x = 0; x < World.width; x++)
            {
                Vector2 pos = new Vector2(x, y);
                if (getEntityAt(pos) == entity)
                {
                    positions.add(pos);
                }
            }
        }
        return positions;
    }

    public void visualize()
    {
        for (int y = 0; y < World.height; y++)
        {
            for (int x = 0; x < World.width; x++)
            {
                System.out.print(entityMap[x][y]);
            }
            System.out.println("");
        }
    }
}
