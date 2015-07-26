package com.darichey.dungeonCrawler.inventory;

import com.darichey.dungeonCrawler.item.ItemStack;

/**
 * Inventories are simply a collection of {@link com.darichey.dungeonCrawler.inventory.Slot} objects to hold items
 */
public class InventoryBase
{
    Slot[] slots = new Slot[this.size];
    int size;

    public void setStackInSlot(int slotIndex, ItemStack stack)
    {
        this.slots[slotIndex].setItemStack(stack);
    }

    public ItemStack getStackInSlot(int slotIndex)
    {
        return this.slots[slotIndex].getItemStack();
    }
}
