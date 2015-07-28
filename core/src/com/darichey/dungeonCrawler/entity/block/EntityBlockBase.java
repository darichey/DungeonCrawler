package com.darichey.dungeonCrawler.entity.block;
import com.darichey.dungeonCrawler.entity.base.GameEntity;

/**
 * Basic block entity.
 */
public abstract class EntityBlockBase extends GameEntity
{
    public EntityBlockBase()
    {
        this.width = 1;
        this.height = 1;
        this.name = "Block";
    }
}
