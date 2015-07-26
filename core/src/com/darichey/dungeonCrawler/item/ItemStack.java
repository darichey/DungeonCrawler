package com.darichey.dungeonCrawler.item;

import com.darichey.dungeonCrawler.item.base.ItemBase;

public class ItemStack
{
    /**
     * Number of items in the stack
     */
    public int amount;

    /**
     * Max number of items allowed in the stack
     */
    public int maxAmount = 128;

    /**
     * Item in the stack
     */
    public ItemBase item;

    public int getAmount()
    {
        return this.amount;
    }

    public int getMaxAmount()
    {
        return this.maxAmount;
    }

    public ItemBase getItem()
    {
        return this.item;
    }
}
