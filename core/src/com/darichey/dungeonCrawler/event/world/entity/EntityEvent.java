package com.darichey.dungeonCrawler.event.world.entity;

import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.event.world.WorldEvent;
import com.darichey.dungeonCrawler.world.World;

/**
 * Event involving a single entity
 */
public class EntityEvent extends WorldEvent
{
    protected GameEntity entity;

    public EntityEvent(GameEntity entity)
    {
        super(entity.getWorld());
        this.entity = entity;
    }

    public final GameEntity getEntity()
    {
        return this.entity;
    }
}
