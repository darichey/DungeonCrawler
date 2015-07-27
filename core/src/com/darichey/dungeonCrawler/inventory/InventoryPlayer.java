package com.darichey.dungeonCrawler.inventory;

import java.util.ArrayList;

public class InventoryPlayer extends InventoryBase
{
    public InventoryPlayer()
    {
        super(50);
    }

    public ArrayList<Slot> getHotBarSlots()
    {
        ArrayList<Slot> hotBarSlots = new ArrayList<Slot>();
        for (int i = 0; i < 10; i++)
        {
            hotBarSlots.add(this.slots.get(i));
        }
        return hotBarSlots;
    }
}
