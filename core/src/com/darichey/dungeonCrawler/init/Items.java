package com.darichey.dungeonCrawler.init;

import com.darichey.dungeonCrawler.init.register.ItemRegistry;
import com.darichey.dungeonCrawler.item.base.ItemBase;
import com.darichey.dungeonCrawler.item.base.ItemCoin;

public class Items
{
    public static final ItemBase coin = new ItemCoin();

    public static void init()
    {
        ItemRegistry.register(coin);
    }
}
