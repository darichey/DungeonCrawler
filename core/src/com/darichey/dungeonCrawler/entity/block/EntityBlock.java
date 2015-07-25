package com.darichey.dungeonCrawler.entity.block;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.darichey.dungeonCrawler.entity.base.GameEntity;

/**
 * Basic block entity.
 */
public class EntityBlock extends GameEntity
{
    public EntityBlock()
    {
        this.width = 1;
        this.height = 1;
        this.texture = new Texture(Gdx.files.internal("Block.png"));
    }

    @Override
    public String getName()
    {
        return "Block";
    }
}
