package com.darichey.dungeonCrawler.event.world.block;

import com.darichey.dungeonCrawler.entity.block.BlockBase;
import com.darichey.dungeonCrawler.event.world.WorldEvent;

/**
 * Event involving a block
 */
public abstract class BlockEvent extends WorldEvent
{
    private BlockBase block;

    public BlockEvent(BlockBase block)
    {
        super(block.world);
        this.block = block;
    }

    public BlockBase getBlock()
    {
        return this.block;
    }
}
