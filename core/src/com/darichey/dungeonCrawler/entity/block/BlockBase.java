package com.darichey.dungeonCrawler.entity.block;

import com.darichey.dungeonCrawler.entity.base.GameEntity;

/**
 * Basic block entity.
 */
public abstract class BlockBase extends GameEntity {
    public BlockBase() {
        this.width = 1;
        this.height = 1;
    }
}
