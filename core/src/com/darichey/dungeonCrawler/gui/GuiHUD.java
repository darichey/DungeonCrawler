package com.darichey.dungeonCrawler.gui;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.darichey.dungeonCrawler.entity.living.EntityPlayer;
import com.darichey.dungeonCrawler.inventory.InventoryHUD;
import com.darichey.dungeonCrawler.reference.Names;
import com.darichey.dungeonCrawler.reference.TextureLibrary;

public class GuiHUD extends GuiInventory
{
    private EntityPlayer player;
    private Image selectedSlot = new Image(new TextureRegionDrawable(new TextureRegion(TextureLibrary.slotSelected)));

    public GuiHUD(EntityPlayer player)
    {
        super(new InventoryHUD(player.getInventory()), Names.HUD, new Stage());
        this.player = player;

        this.selectedSlot.setScale(2);
        getStage().addActor(selectedSlot);
    }

    @Override
    public void render()
    {
        // Render the selection indicator around the selected slot.
        Vector2 selectedDisplayPos = this.inventory.getSlot(player.getSelectedSlotIndex()).getDisplayPos();
        this.selectedSlot.setPosition(selectedDisplayPos.x, selectedDisplayPos.y);
        super.render();
    }
}
