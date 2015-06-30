package com.darichey.dungeonCrawler.event.world;

import com.darichey.dungeonCrawler.entity.base.GameEntity;

public class EntityCollideEvent extends EntityEvent
{
    protected GameEntity collided;

    public EntityCollideEvent(GameEntity causeEntity, GameEntity collided)
    {
        super(causeEntity.world, causeEntity);
        this.collided = collided;
    }

    public GameEntity getCollided()
    {
        return this.collided;
    }
}
