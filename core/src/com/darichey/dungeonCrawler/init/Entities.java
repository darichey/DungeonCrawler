package com.darichey.dungeonCrawler.init;

import com.darichey.dungeonCrawler.entity.EntityWall;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.entity.register.EntityRegistry;

/** Class used to register NON-living entities. Do not register living entities here because
 *  these entities are used for the EntityTileMap which living entities do not belong to. **/
public class Entities
{
    public static final GameEntity wall = new EntityWall();

    public static void init()
    {
        EntityRegistry.register(wall);
    }
}
