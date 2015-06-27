package com.darichey.dungeonCrawler.world;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.entity.register.EntityRegistry;

public class EntityTileMap
{
    private int[][] entityMap = new int[World.width][World.height];

    public void putEntityAt(GameEntity entity, Vector2 worldPos)
    {
        int posX = Math.round(worldPos.x);
        int posY = Math.round(worldPos.y);
        entityMap[posX][posY] = EntityRegistry.getIDFromEntity(entity);
    }

    public GameEntity getEntityAt(Vector2 worldPos)
    {
        int id = entityMap[Math.round(worldPos.x)][Math.round(worldPos.y)];
        return EntityRegistry.getEntityFromID(id);
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
