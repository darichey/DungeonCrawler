package com.darichey.dungeonCrawler.gui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.darichey.dungeonCrawler.inventory.InventoryPlayer;

public class GuiPlayerInventory extends GuiInventory
{
    public GuiPlayerInventory(InventoryPlayer inventoryPlayer)
    {
        super(inventoryPlayer, "InventoryPlayer", new Stage());
    }

    @Override
    public void render()
    {
        super.render();
    }
}
