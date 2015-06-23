package com.darichey.dungeonCrawler.init;

import com.darichey.dungeonCrawler.entity.EntityPlayer;
import com.darichey.dungeonCrawler.entity.EntityWall;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.entity.register.EntityRegistry;

public class Entities
{
    public static final GameEntity player = new EntityPlayer();
    public static final GameEntity wall = new EntityWall();

    public void init()
    {
        EntityRegistry.register(player);
        EntityRegistry.register(wall);
    }
}
