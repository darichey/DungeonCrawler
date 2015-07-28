package com.darichey.dungeonCrawler.event.world.block;

import com.darichey.dungeonCrawler.entity.block.EntityBlockBase;
import com.darichey.dungeonCrawler.event.world.WorldEvent;

/**
 * Event involving a block
 */
public abstract class BlockEvent extends WorldEvent
{
    private EntityBlockBase block;

    public BlockEvent(EntityBlockBase block)
    {
        super(block.world);
        this.block = block;
    }

    public EntityBlockBase getBlock()
    {
        return this.block;
    }
}
