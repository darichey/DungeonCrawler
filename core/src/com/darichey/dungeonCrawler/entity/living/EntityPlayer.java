package com.darichey.dungeonCrawler.entity.living;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.base.LivingEntity;
import com.darichey.dungeonCrawler.inventory.InventoryPlayer;
import com.darichey.dungeonCrawler.item.stack.ItemStack;
import com.darichey.dungeonCrawler.world.World;

/**
 * The player entity of the game
 */
public class EntityPlayer extends LivingEntity
{
    private InventoryPlayer inventory = new InventoryPlayer();
    private int selectedSlot = 0;

    public EntityPlayer(World world, Vector2 pos)
    {
        setPos(pos);
        this.width = 1;
        this.height = 2;
        this.world = world;
        this.texture = new Texture(Gdx.files.internal("player.png"));
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

    public int getSelectedSlot()
    {
        return this.selectedSlot;
    }

    public void setSelectedSlot(int slot)
    {
        this.selectedSlot = slot;
    }

    public ItemStack getSelectedStack()
    {
        return getInventory().getStackInSlot(getSelectedSlot());
    }
}
