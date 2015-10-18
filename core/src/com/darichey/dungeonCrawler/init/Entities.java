package com.darichey.dungeonCrawler.init;

import com.darichey.dungeonCrawler.entity.block.BlockBase;
import com.darichey.dungeonCrawler.entity.block.BlockStone;
import com.darichey.dungeonCrawler.init.register.EntityRegistry;

/**
 * Class used to register NON-dynamic entities. Do not register dynamic entities here because
 * these entities are used for the EntityTileMap which dynamic entities do not belong to. *
 */
public class Entities
{
    public static final BlockBase stone = new BlockStone();

    public static void init()
    {
        EntityRegistry.register(stone);
    }
}
