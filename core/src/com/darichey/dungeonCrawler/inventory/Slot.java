package com.darichey.dungeonCrawler.inventory;

import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.item.ItemStack;

/**
 * Used in Inventories to store items. Each slot stores one {@link com.darichey.dungeonCrawler.item.ItemStack}
 */
public class Slot
{
    /**
     * The itemstack in this slot
     */
    private ItemStack itemStack;

    /**
     * The position at which this slot will be displayed in a GUI
     */
    private Vector2 displayPos;

    public void setItemStack(ItemStack newStack)
    {
        this.itemStack = newStack;
    }

    public ItemStack getItemStack()
    {
        return this.itemStack;
    }

    public Vector2 getDisplayPos()
    {
        return this.displayPos;
    }

    public void setDisplayPos(Vector2 newPos)
    {
        this.displayPos = newPos;
    }
}
