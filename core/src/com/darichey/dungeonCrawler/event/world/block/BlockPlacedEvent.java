package com.darichey.dungeonCrawler.event.world.block;

import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.entity.block.EntityBlockBase;

public class BlockPlacedEvent extends BlockEvent
{
    private GameEntity entity;

    /**
     * @param entity The source of the placed block. Normally an {@link com.darichey.dungeonCrawler.entity.living.EntityPlayer}
     * @param block The block placed.
     */
    public BlockPlacedEvent(GameEntity entity, EntityBlockBase block)
    {
        super(block);
        this.entity = entity;
    }

    public GameEntity getEntity()
    {
        return this.entity;
    }

    @Override
    public boolean isCancelable()
    {
        return true;
    }
}
