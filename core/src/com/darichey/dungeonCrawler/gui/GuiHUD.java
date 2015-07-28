package com.darichey.dungeonCrawler.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.darichey.dungeonCrawler.entity.living.EntityPlayer;
import com.darichey.dungeonCrawler.inventory.Slot;
import com.darichey.dungeonCrawler.item.stack.ItemStack;
import com.darichey.dungeonCrawler.render.WorldRenderer;

import java.util.ArrayList;

public class GuiHUD extends GuiInventory
{
    private EntityPlayer player;
    private ArrayList<Slot> hotbarSlots;
    private ArrayList<Image> itemImages = new ArrayList<Image>();
    private ArrayList<Label> itemAmounts = new ArrayList<Label>();
    private Label.LabelStyle style = new Label.LabelStyle(new BitmapFont(), Color.WHITE);
    private Image selected;

    private Label fpsLabel = new Label("FPS: " + String.valueOf(Gdx.graphics.getFramesPerSecond()), style);

    public GuiHUD(EntityPlayer player)
    {
        super(player.getInventory(), "HUD", new Stage());
        this.hotbarSlots = player.getInventory().getHotBarSlots();
        this.player = player;
        this.fpsLabel.setPosition(2,2);

        for (int i = 0; i < 10; i++)
        {
            Image slotImage = new Image(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Slot.png")))));
            slotImage.setPosition(28 + ((i * 36)), 975);
            getStage().addActor(slotImage);

            this.selected = new Image(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("SlotSelected.png")))));
            // TODO: Find a way to draw it nicer rather than just drawing it off screen
            this.selected.setPosition(0, 1020);
            getStage().addActor(selected);

            Image itemImage = new Image();
            itemImage.setPosition(30 + (i * 36), 977);
            itemImage.scaleBy(1);
            itemImages.add(itemImage);
            getStage().addActor(itemImage);

            Label amountLabel = new Label("", style);
            amountLabel.setPosition(48 + (i * 36), 983);
            itemAmounts.add(amountLabel);
            getStage().addActor(amountLabel);
        }
    }

    @Override
    public void render()
    {
        this.selected.setPosition(28 + (player.getSelectedSlot() * 36), 975);
        super.render();

        if (WorldRenderer.debugRender)
        {
            fpsLabel.setText("FPS: " + String.valueOf(Gdx.graphics.getFramesPerSecond()));
            getStage().addActor(fpsLabel);
        }

        for (Slot slot : hotbarSlots)
        {
            int slotIndex = hotbarSlots.indexOf(slot);
            ItemStack stack = slot.getItemStack();
            if (stack != null)
            {
                Image stackImage = itemImages.get(slotIndex);
                stackImage.setDrawable(new TextureRegionDrawable(new TextureRegion(stack.getItem().getTexture())));
                stackImage.setSize(stack.getItem().getTexture().getWidth(), stack.getItem().getTexture().getWidth());

                Label stackAmount = itemAmounts.get(slotIndex);
                stackAmount.setText(String.valueOf(stack.getAmount()));
                stackAmount.setX(48 + (slotIndex * 36) + ((-stackAmount.getText().length + 2)* 10));
            }
        }
    }
}
