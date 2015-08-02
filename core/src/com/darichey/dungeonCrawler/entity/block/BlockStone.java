package com.darichey.dungeonCrawler.entity.block;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.darichey.dungeonCrawler.render.TextureLibrary;

/**
 * Temporary block for testing
 */
public class BlockStone extends EntityBlockBase
{
    public BlockStone()
    {
        this.texture = TextureLibrary.stone;
    }
}
