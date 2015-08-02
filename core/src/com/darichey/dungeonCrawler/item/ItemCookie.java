package com.darichey.dungeonCrawler.item;

import com.darichey.dungeonCrawler.reference.Names;
import com.darichey.dungeonCrawler.reference.TextureLibrary;

public class ItemCookie extends ItemBase
{
    public ItemCookie()
    {
        this.texture = TextureLibrary.cookie;
        this.name = Names.cookie;
    }
}
