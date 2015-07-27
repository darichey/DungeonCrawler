package com.darichey.dungeonCrawler.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.darichey.dungeonCrawler.entity.living.EntityPlayer;
import com.darichey.dungeonCrawler.init.Items;
import com.darichey.dungeonCrawler.inventory.Slot;
import com.darichey.dungeonCrawler.item.ItemStack;
import com.darichey.dungeonCrawler.render.WorldRenderer;

import java.util.ArrayList;

public class GuiHUD extends GuiInventory
{
    private EntityPlayer player;
    private ArrayList<Slot> hotbarSlots;
    private ArrayList<Image> itemImages = new ArrayList<Image>();
    private Image selected;

    private Label fpsLabel = new Label("FPS: " + String.valueOf(Gdx.graphics.getFramesPerSecond()), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

    public GuiHUD(EntityPlayer player)
    {
        super(player.getInventory(), "HUD", new Stage());
        this.hotbarSlots = player.getInventory().getHotBarSlots();
        this.player = player;
        this.fpsLabel.setPosition(2,2);

        for (int i = 0; i < 10; i++)
        {
            Image slotImage = new Image(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("Slot.png")))));
            slotImage.setPosition(10 + ((i * 36) + 18), 975);
            getStage().addActor(slotImage);

            this.selected = new Image(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("SlotSelected.png")))));
            // TODO: Find a way to draw it nicer rather than just drawing it off screen
            this.selected.setPosition(0, 1020);
            getStage().addActor(selected);

            Image itemImage = new Image();
            itemImage.setPosition(10, 10);
            // FIXME: This doesn't work and is why the item renderer below doesn't work
            itemImage.setDrawable(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("cookie.png")))));
            getStage().addActor(itemImage);

            /*
            Image itemImage = new Image();
            itemImage.setPosition(10 + ((i * 36) + 18), 975);
            itemImage.scaleBy(10);
            itemImages.add(itemImage);
            getStage().addActor(itemImage);
            */

            /*
            Image coin = new Image(new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("cookie.png")))));
            coin.setPosition(30, 977);
            coin.scaleBy(1);
            getStage().addActor(coin);
            */
        }
    }

    @Override
    public void render()
    {
        this.selected.setPosition(10 + ((player.getSelectedSlot() * 36) + 18), 975);
        super.render();

        if (WorldRenderer.debugRender)
        {
            fpsLabel.setText("FPS: " + String.valueOf(Gdx.graphics.getFramesPerSecond()));
            getStage().addActor(fpsLabel);
        }

        for (Image image : itemImages)
        {
            ItemStack stack = hotbarSlots.get(itemImages.indexOf(image)).getItemStack();
            if (stack != null)
            {
                image.setDrawable(new TextureRegionDrawable(new TextureRegion(stack.getItem().getTexture())));
            }
        }
    }
}
