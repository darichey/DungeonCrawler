package com.darichey.dungeonCrawler.inventory;

public class InventoryPlayer extends InventoryBase
{
    public InventoryPlayer()
    {
        this.size = 50;
    }

    public Slot[] getHotBarSlots()
    {
        Slot[] hotbarSlots = new Slot[10];
        //FIXME: I don't understand how this works
        System.arraycopy(this.slots, 0, hotbarSlots, 0, 10);
        return hotbarSlots;
    }
}
