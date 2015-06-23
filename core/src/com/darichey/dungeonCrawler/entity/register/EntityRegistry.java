package com.darichey.dungeonCrawler.entity.register;

import com.darichey.dungeonCrawler.entity.base.GameEntity;

import java.util.HashMap;

public class EntityRegistry
{
    private static HashMap<Integer, GameEntity> entities = new HashMap<Integer, GameEntity>();
    private static int nextID = 0;

    public static void register(GameEntity entity)
    {
        if (entities.containsValue(entity))
        {
            throw new IllegalArgumentException("Attempt to register an already-registered entity.");
        }
        entities.put(++nextID, entity);
    }

    public static GameEntity getEntityFromID(int id)
    {
        return entities.get(id);
    }
}
