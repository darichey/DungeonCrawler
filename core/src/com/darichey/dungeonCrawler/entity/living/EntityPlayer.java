package com.darichey.dungeonCrawler.entity.living;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.base.LivingEntity;
import com.darichey.dungeonCrawler.gui.GuiPlayerInventory;
import com.darichey.dungeonCrawler.inventory.InventoryPlayer;
import com.darichey.dungeonCrawler.item.stack.ItemStack;
import com.darichey.dungeonCrawler.render.TextureLibrary;
import com.darichey.dungeonCrawler.screens.GameScreen;
import com.darichey.dungeonCrawler.world.World;

/**
 * The player entity of the game
 */
public class EntityPlayer extends LivingEntity
{
    private InventoryPlayer inventory = new InventoryPlayer();
    private int selectedSlotIndex = 0;

    public EntityPlayer(World world, Vector2 pos)
    {
        setPos(pos);
        this.width = 1;
        this.height = 2;
        this.world = world;
        this.texture = TextureLibrary.player;
        this.health = 100;
        this.movementSpeed = 6F;
        this.dampingSpeed = .08F;
        world.getDynamicEntities().add(this);
    }

    @Override
    public String getName()
    {
        return "Player";
    }

    public InventoryPlayer getInventory()
    {
        return this.inventory;
    }

    public int getSelectedSlotIndex()
    {
        return this.selectedSlotIndex;
    }

    public void setSelectedSlot(int slot)
    {
        this.selectedSlotIndex = slot;
    }

    public ItemStack getSelectedStack()
    {
        return getInventory().getStackInSlot(getSelectedSlotIndex());
    }

    public boolean hasInventoryOpen()
    {
        return GameScreen.guiRenderer.getCurrentGui() instanceof GuiPlayerInventory;
    }
}
