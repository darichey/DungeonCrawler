package com.darichey.dungeonCrawler.event.world.block;

import com.darichey.dungeonCrawler.entity.block.EntityBlock;
import com.darichey.dungeonCrawler.event.world.WorldEvent;

public abstract class BlockEvent extends WorldEvent
{
    private EntityBlock block;

    public BlockEvent(EntityBlock block)
    {
        super(block.world);
        this.block = block;
    }

    public EntityBlock getBlock()
    {
        return this.block;
    }
}
