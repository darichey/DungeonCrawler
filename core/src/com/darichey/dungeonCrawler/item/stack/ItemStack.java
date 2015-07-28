package com.darichey.dungeonCrawler.item.stack;

import com.darichey.dungeonCrawler.item.base.ItemBase;

public class ItemStack
{
    /**
     * Number of items in the stack. -1 represents an infinite amount
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

    public ItemStack(ItemBase item)
    {
        this.item = item;
        this.amount = -1;
    }

    public ItemStack(ItemBase item, int amount)
    {
        this(item);
        setAmount(amount);
    }

    public int getAmount()
    {
        return this.amount;
    }

    public void setAmount(int amount)
    {
        this.amount = amount > getMaxAmount() ? getMaxAmount() : amount;
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
