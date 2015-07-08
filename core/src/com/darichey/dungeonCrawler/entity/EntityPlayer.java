package com.darichey.dungeonCrawler.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.base.LivingEntity;
import com.darichey.dungeonCrawler.world.World;

/**
 * The player entity of the game
 */
public class EntityPlayer extends LivingEntity
{
    public EntityPlayer(World world, Vector2 pos)
    {
        setPos(pos);
        this.width = 1;
        this.height = 2;
        this.world = world;
        this.texture = new Texture(Gdx.files.internal("player.png"));
        this.health = 100;
        world.getDynamicEntities().add(this);
    }

    @Override
    public String getName()
    {
        return "Player";
    }
}
