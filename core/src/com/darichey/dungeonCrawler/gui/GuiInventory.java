package com.darichey.dungeonCrawler.gui;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.darichey.dungeonCrawler.inventory.InventoryBase;
import com.darichey.dungeonCrawler.inventory.Slot;
import com.darichey.dungeonCrawler.screens.GameScreen;

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

        // Add the actors of each slot to the GUI stage
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

    private boolean slotExistsAt(Vector2 pos)
    {
        for (Slot slot : inventory.getSlots())
        {
            Rectangle slotBounds = new Rectangle(slot.getDisplayPos().x, slot.getDisplayPos().y, 32 ,32);
            if (slotBounds.contains(pos))
            {
                return true;
            }
        }
        return false;
    }

}
