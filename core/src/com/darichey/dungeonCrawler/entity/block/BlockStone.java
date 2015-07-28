package com.darichey.dungeonCrawler.entity.block;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Temporary block for testing
 */
public class BlockStone extends EntityBlockBase
{
    public BlockStone()
    {
        this.texture = new Texture(Gdx.files.internal("stone.png"));
    }
}
