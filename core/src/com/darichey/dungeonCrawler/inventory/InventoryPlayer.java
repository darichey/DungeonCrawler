package com.darichey.dungeonCrawler.inventory;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class InventoryPlayer extends InventoryBase
{
    public InventoryPlayer()
    {
        for (int y = 0; y < 5; y++)
        {
            for (int x = 0; x < 10; x++)
            {
                Slot slot = new Slot(this, new Vector2(28 + x * 36, 975 - (y * 36)));
                addSlot(slot);
            }
        }
    }

    public ArrayList<Slot> getMainSlots()
    {
        ArrayList<Slot> mainSlots = new ArrayList<Slot>();
        for (int i = 10; i < 50; i++)
        {
            mainSlots.add(getSlot(i));
        }
        return mainSlots;
    }

    public ArrayList<Slot> getHotbarSlots()
    {
        ArrayList<Slot> hotbarSlots = new ArrayList<Slot>();
        for (int i = 0; i < 10; i++)
        {
            hotbarSlots.add(getSlot(i));
        }
        return hotbarSlots;
    }
}
