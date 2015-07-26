package com.darichey.dungeonCrawler.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.darichey.dungeonCrawler.inventory.InventoryPlayer;
import com.darichey.dungeonCrawler.inventory.Slot;

public class GuiHUD extends GuiInventory
{
    private Slot[] hotbarSlots;

    public GuiHUD(InventoryPlayer inventory)
    {
        super(inventory, "HUD", new Stage());
        hotbarSlots = inventory.getHotBarSlots();

        for (int i = 0; i < 10; i++)
        {
            Image slotImage = new Image(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Slot.png")))));
            slotImage.setPosition(10 + ((i * 34) + 17), 980);
            getStage().addActor(slotImage);

            Image itemImage = new Image(new TextureRegionDrawable(new TextureRegion(hotbarSlots[i].getItemStack().getItem().getTexture())));
            itemImage.setPosition(10 + ((i * 34) + 17), 980);
            getStage().addActor(itemImage);
        }
    }
}
