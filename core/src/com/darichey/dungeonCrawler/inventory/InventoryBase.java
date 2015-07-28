package com.darichey.dungeonCrawler.inventory;

import com.darichey.dungeonCrawler.item.stack.ItemStack;

import java.util.ArrayList;

/**
 * Inventories are simply a collection of {@link com.darichey.dungeonCrawler.inventory.Slot} objects to hold items
 */
public class InventoryBase
{
    ArrayList<Slot> slots = new ArrayList<Slot>();

    public InventoryBase(int size)
    {
        for (int i = 0; i < size; i++)
        {
            this.slots.add(new Slot());
        }
    }

    public void setStackInSlot(int slotIndex, ItemStack stack)
    {
        this.slots.get(slotIndex).setItemStack(stack);
    }

    public ItemStack getStackInSlot(int slotIndex)
    {
        return this.slots.get(slotIndex).getItemStack();
    }

    public Slot getNextValidSlotFor(ItemStack stack)
    {
        for (Slot slot : slots)
        {
            if (slot.getItemSpace() > 0)
            {
                return slot;
            }
        }
        return null;
    }
}
