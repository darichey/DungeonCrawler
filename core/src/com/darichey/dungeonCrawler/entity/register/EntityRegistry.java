package com.darichey.dungeonCrawler.entity.register;

import com.darichey.dungeonCrawler.entity.base.DynamicEntity;
import com.darichey.dungeonCrawler.entity.base.GameEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Registry for NON-Dynamic entities
 */
public class EntityRegistry
{
    private static HashMap<Integer, GameEntity> entities = new HashMap<Integer, GameEntity>();
    private static int nextID = 0;

    /**
     * Registers the passed entity, giving it a unique ID
     * @param entity The entity to register
     */
    public static void register(GameEntity entity)
    {
        if (entity instanceof DynamicEntity)
        {
            throw new IllegalArgumentException("Dynamic entities are not to be registered in the EntityRegistry.");
        }

        if (entities.containsValue(entity))
        {
            throw new IllegalArgumentException("Attempt to register an already-registered entity.");
        }
        entities.put(++nextID, entity);
    }

    /**
     * Gets the entity linked to the passed ID
     * @param id ID of the entity being searched for
     * @return The linked entity
     */
    public static GameEntity getEntityFromID(int id)
    {
        return entities.get(id);
    }

    /**
     * Gets the ID linked to the passed entity
     * @param entity Entity to find ID for
     * @return ID of entity
     */
    public static Integer getIDForEntity(GameEntity entity)
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
