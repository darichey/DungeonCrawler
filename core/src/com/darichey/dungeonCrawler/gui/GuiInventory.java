package com.darichey.dungeonCrawler.gui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.darichey.dungeonCrawler.inventory.InventoryBase;

/**
 * A GUI that displays any {@link com.darichey.dungeonCrawler.inventory.InventoryBase}
 */
public class GuiInventory extends Gui
{
    private InventoryBase inventory;

    public GuiInventory(InventoryBase inventory, String name, Stage stage)
    {
        super(name, stage);
        this.inventory = inventory;
    }
}
