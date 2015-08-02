package com.darichey.dungeonCrawler.entity.block;

import com.darichey.dungeonCrawler.reference.Names;
import com.darichey.dungeonCrawler.reference.TextureLibrary;

/**
 * Temporary block for testing
 */
public class BlockStone extends EntityBlockBase
{
    public BlockStone()
    {
        this.texture = TextureLibrary.stone;
        this.name = Names.stone;
    }
}
