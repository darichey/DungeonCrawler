package com.darichey.dungeonCrawler.init.register;

import com.darichey.dungeonCrawler.entity.base.GameEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Registry for entities
 */
public class EntityRegistry {
    private static HashMap<Integer, GameEntity> entities = new HashMap<Integer, GameEntity>();
    private static int nextID = 0;

    /**
     * Registers the passed entity, giving it a unique ID
     *
     * @param entity The entity to register
     */
    public static void register(GameEntity entity) {
        if (entities.containsValue(entity)) {
            throw new IllegalArgumentException("Attempt to register an already-registered entity: " + entity.getName());
        }
        entities.put(++nextID, entity);
    }

    /**
     * Gets the entity linked to the passed ID
     *
     * @param id ID of the entity being searched for
     * @return The linked entity
     */
    public static GameEntity getEntityFromID(int id) {
        return entities.get(id);
    }

    /**
     * Gets the ID linked to the passed entity
     *
     * @param entity Entity to find ID for
     * @return ID of entity
     */
    public static Integer getIDForEntity(GameEntity entity) {
        Set<Map.Entry<Integer, GameEntity>> entries = entities.entrySet();
        for (Map.Entry entry : entries) {
            if (entry.getValue().equals(entity)) {
                return (Integer) entry.getKey();
            }
        }
        return null;
    }

    /**
     * @return A list of all registered entities
     */
    public static ArrayList<GameEntity> getRegisteredEntities() {
        ArrayList<GameEntity> returnList = new ArrayList<GameEntity>();
        Set<Map.Entry<Integer, GameEntity>> entries = entities.entrySet();
        for (Map.Entry entry : entries) {
            returnList.add((GameEntity) entry.getValue());
        }
        return returnList;
    }
}
