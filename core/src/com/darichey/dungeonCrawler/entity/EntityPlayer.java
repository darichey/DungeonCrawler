package com.darichey.dungeonCrawler.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.base.DynamicEntity;

/**
 * The player entity of the game
 */
public class EntityPlayer extends DynamicEntity
{
    public EntityPlayer(Vector2 pos)
    {
        setPos(pos);
        setPrevPos(pos);
        this.width = 1;
        this.height = 1;
        this.texture = new Texture(Gdx.files.internal("player.png"));
    }

    @Override
    public String getName()
    {
        return "Player";
    }
}
