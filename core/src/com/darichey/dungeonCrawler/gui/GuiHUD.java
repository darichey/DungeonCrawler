package com.darichey.dungeonCrawler.gui;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.darichey.dungeonCrawler.entity.living.EntityPlayer;
import com.darichey.dungeonCrawler.inventory.Slot;
import com.darichey.dungeonCrawler.reference.Names;
import com.darichey.dungeonCrawler.reference.TextureLibrary;

public class GuiHUD extends GuiInventory
{
    private EntityPlayer player;
    private Image selectedSlot = new Image(new TextureRegionDrawable(new TextureRegion(TextureLibrary.slotSelected)));
    private boolean showInventory = false;

    public GuiHUD(EntityPlayer player)
    {
        super(player.getInventory(), Names.HUD, new Stage());
        this.player = player;

        this.selectedSlot.setScale(2);
        getStage().addActor(selectedSlot);

        setShowInventory(false);
    }

    @Override
    public void render()
    {
        // Render the selection indicator around the selected slot.
        Vector2 selectedDisplayPos = this.inventory.getSlot(player.getSelectedSlotIndex()).getDisplayPos();
        this.selectedSlot.setPosition(selectedDisplayPos.x, selectedDisplayPos.y);
        super.render();
    }

    public void setShowInventory(boolean showInventory)
    {
        this.showInventory = showInventory;
        for (Slot slot : player.getInventory().getMainSlots())
        {
            if (showInventory)
            {
                getStage().addActor(slot.amountLabel);
                getStage().addActor(slot.itemImage);
                getStage().addActor(slot.slotImage);
            }
            else
            {
                slot.amountLabel.remove();
                slot.itemImage.remove();
                slot.slotImage.remove();
            }
        }
    }

    public boolean getShowInventory()
    {
        return this.showInventory;
    }
}
