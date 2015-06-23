package com.darichey.dungeonCrawler.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.base.LivingEntity;

public class EntityPlayer extends LivingEntity
{
    public EntityPlayer(Vector2 pos)
    {
        setPos(pos);
        setPrevPos(pos);
        this.width = 14;
        this.height = 22;
        setBounds(new Rectangle(pos.x, pos.y, width, height));
    }

    @Override
    public Texture getTexture()
    {
        return new Texture(Gdx.files.internal("player.png"));
    }

    @Override
    public String getName()
    {
        return "Player";
    }
}
