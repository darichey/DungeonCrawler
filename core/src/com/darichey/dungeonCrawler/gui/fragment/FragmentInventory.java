package com.darichey.dungeonCrawler.gui.fragment;

import com.darichey.dungeonCrawler.inventory.InventoryBase;
import com.darichey.dungeonCrawler.inventory.Slot;

/**
 * A fragment that can display any InventoryBase
 */
public class FragmentInventory extends GuiFragment
{
    public InventoryBase inventory;

    public FragmentInventory(InventoryBase inventory, String name)
    {
        super(name);
        this.inventory = inventory;

        for (Slot slot : inventory.getSlots())
        {
            this.getActors().add(slot.slotImage);
            this.getActors().add(slot.itemImage);
            this.getActors().add(slot.amountLabel);
        }
    }

    @Override
    public void update()
    {
        inventory.updateSlots();
    }
}
