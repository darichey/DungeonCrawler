package com.darichey.dungeonCrawler.entity.register;

import com.darichey.dungeonCrawler.entity.base.GameEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    public static Integer getIDFromEntity(GameEntity entity)
    {
        Set<Map.Entry<Integer, GameEntity>> entries = entities.entrySet();
        for (Map.Entry entry : entries)
        {
            if (entry.getValue().equals(entity))
            {
                return (Integer)entry.getKey();
            }
        }
        return null;
    }
}
