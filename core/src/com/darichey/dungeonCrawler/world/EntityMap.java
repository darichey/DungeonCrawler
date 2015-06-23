package com.darichey.dungeonCrawler.world;

import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.entity.register.EntityRegistry;

public class EntityMap
{
    public static final int width  = 100;
    public static final int height = 100;
    public int[][] map = new int[width][height];

    public GameEntity getEntityAt(Vector2 worldPos)
    {
        int id = map[Math.round(worldPos.x)][Math.round(worldPos.y)];
        return EntityRegistry.getEntityFromID(id);
    }
}
