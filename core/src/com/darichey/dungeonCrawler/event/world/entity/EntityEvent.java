package com.darichey.dungeonCrawler.event.world.entity;

import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.event.world.WorldEvent;
import com.darichey.dungeonCrawler.world.World;

public class EntityEvent extends WorldEvent
{
    protected GameEntity entity;

    public EntityEvent(World world, GameEntity entity)
    {
        super(world);
        this.entity = entity;
    }

    public final GameEntity getEntity()
    {
        return this.entity;
    }
}
