package com.darichey.dungeonCrawler.inventory;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class InventoryPlayer extends InventoryBase
{
    public InventoryPlayer()
    {
        for (int i = 0; i < 50; i++)
        {
            Slot slot = new Slot(this, Vector2.Zero);
        }
    }

    public ArrayList<Slot> getHotBarSlots()
    {
        ArrayList<Slot> hotBarSlots = new ArrayList<Slot>();
        for (int i = 0; i < 10; i++)
        {
            hotBarSlots.add(getSlot(i));
        }
        return hotBarSlots;
    }
}
