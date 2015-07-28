package com.darichey.dungeonCrawler.init;

import com.darichey.dungeonCrawler.init.register.ItemRegistry;
import com.darichey.dungeonCrawler.item.base.ItemBase;
import com.darichey.dungeonCrawler.item.ItemCookie;
import com.darichey.dungeonCrawler.item.placeable.ItemPlaceableBase;
import com.darichey.dungeonCrawler.item.placeable.ItemPlaceableStone;

public class Items
{
    public static final ItemBase cookie = new ItemCookie();
    public static final ItemPlaceableBase stone = new ItemPlaceableStone();

    public static void init()
    {
        ItemRegistry.register(cookie);
        ItemRegistry.register(stone);
    }
}
