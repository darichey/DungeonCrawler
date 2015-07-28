package com.darichey.dungeonCrawler.inventory;

import com.darichey.dungeonCrawler.item.stack.ItemStack;

/**
 * Used in Inventories to store items. Each slot stores one {@link com.darichey.dungeonCrawler.item.stack.ItemStack}
 */
public class Slot
{
    /**
     * The itemstack in this slot
     */
    private ItemStack itemStack;

    public void setItemStack(ItemStack newStack)
    {
        this.itemStack = newStack;
    }

    public ItemStack getItemStack()
    {
        return this.itemStack;
    }
}
