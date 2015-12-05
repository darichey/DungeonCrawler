package com.darichey.dungeonCrawler.world.chunk;

import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.init.register.EntityRegistry;
import com.darichey.dungeonCrawler.util.Logger;

import java.util.ArrayList;

/**
 * Generic tile map storing the NON-Dynamic entities in the chunk
 */
public class EntityTileMap {
    /**
     * Underlying 2D array. Each position in the array stores an entity's ID found in {@link EntityRegistry} *
     */
    private int[][] entityMap;
    private int xSize, ySize;

    public EntityTileMap(int xSize, int ySize) {
        this.entityMap = new int[xSize][ySize];
        this.xSize = xSize;
        this.ySize = ySize;
    }

    public void putEntityAt(GameEntity entity, Vector2 chunkPos) {
        int posX = (int) Math.floor(chunkPos.x);
        int posY = (int) Math.floor(chunkPos.y);
        if (entity == null) {
            entityMap[posX][posY] = 0;
        } else {
            entityMap[posX][posY] = EntityRegistry.getIDForEntity(entity);
        }
    }

    public GameEntity getEntityAt(Vector2 chunkPos) {
        int id = entityMap[(int) Math.floor(chunkPos.x)][(int) Math.floor(chunkPos.y)];
        return EntityRegistry.getEntityFromID(id);
    }

    public ArrayList<Vector2> getPositionsForEntity(GameEntity entity) {
        ArrayList<Vector2> positions = new ArrayList<Vector2>();
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                Vector2 pos = new Vector2(x, y);
                if (getEntityAt(pos) == entity) {
                    positions.add(pos);
                }
            }
        }
        return positions;
    }

    public void visualize() {
        for (int y = 0; y < ySize; y++) {
            for (int x = 0; x < xSize; x++) {
                Logger.log(Integer.toString(entityMap[x][ySize - y - 1]));
            }
            Logger.log("");
        }
    }
}
