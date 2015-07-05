package com.darichey.dungeonCrawler.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.base.DynamicEntity;
import com.darichey.dungeonCrawler.world.World;

import java.util.ArrayList;

/**
 * The player entity of the game
 */
public class EntityPlayer extends DynamicEntity
{
    public EntityPlayer(World world, Vector2 pos)
    {
        setPos(pos);
        setPrevPos(pos);
        this.width = 1;
        this.height = 2;
        this.world = world;
        this.texture = new Texture(Gdx.files.internal("player.png"));
        world.getDynamicEntities().add(this);
    }

    @Override
    public String getName()
    {
        return "Player";
    }
}
