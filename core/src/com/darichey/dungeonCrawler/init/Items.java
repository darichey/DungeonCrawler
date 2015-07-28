package com.darichey.dungeonCrawler.init;

import com.darichey.dungeonCrawler.init.register.ItemRegistry;
import com.darichey.dungeonCrawler.item.base.ItemBase;
import com.darichey.dungeonCrawler.item.ItemCookie;

public class Items
{
    public static final ItemBase cookie = new ItemCookie();

    public static void init()
    {
        ItemRegistry.register(cookie);
    }
}
