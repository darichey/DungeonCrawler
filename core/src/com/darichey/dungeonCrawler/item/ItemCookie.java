package com.darichey.dungeonCrawler.item;

import com.darichey.dungeonCrawler.item.base.ItemBase;
import com.darichey.dungeonCrawler.render.TextureLibrary;

public class ItemCookie extends ItemBase
{
    public ItemCookie()
    {
        this.texture = TextureLibrary.cookie;
        this.name = "Cookie";
    }
}
