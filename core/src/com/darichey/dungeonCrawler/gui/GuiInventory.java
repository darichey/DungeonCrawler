package com.darichey.dungeonCrawler.gui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.darichey.dungeonCrawler.inventory.InventoryBase;
import com.darichey.dungeonCrawler.inventory.Slot;

/**
 * A GUI that displays any {@link com.darichey.dungeonCrawler.inventory.InventoryBase}
 */
public class GuiInventory extends Gui
{
    public InventoryBase inventory;

    public GuiInventory(InventoryBase inventory, String name, Stage stage)
    {
        super(name, stage);
        this.inventory = inventory;

        for (Slot slot : inventory.getSlots())
        {
            this.getStage().addActor(slot.slotImage);
            this.getStage().addActor(slot.itemImage);
            this.getStage().addActor(slot.amountLabel);
        }
    }

    @Override
    public void render()
    {
        inventory.updateSlots();
        super.render();
    }
}
