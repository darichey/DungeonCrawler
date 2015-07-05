package com.darichey.dungeonCrawler.init;

import com.darichey.dungeonCrawler.entity.EntityWall;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.entity.register.EntityRegistry;

/**
 * Class used to register NON-dynamic entities. Do not register dynamic entities here because
 * these entities are used for the EntityTileMap which dynamic entities do not belong to. *
 */
public class Entities
{
    public static final GameEntity wall = new EntityWall();

    public static void init()
    {
        EntityRegistry.register(wall);
    }
}
