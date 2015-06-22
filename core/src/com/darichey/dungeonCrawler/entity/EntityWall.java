package com.darichey.dungeonCrawler.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.base.GameEntity;

public class EntityWall extends GameEntity
{
    public EntityWall(Vector2 pos)
    {
        setPos(pos);
        setBounds(new Rectangle(pos.x, pos.y, 16, 16));
    }

    @Override
    public Texture getTexture()
    {
        return new Texture(Gdx.files.internal("wall.png"));
    }

    @Override
    public String getName()
    {
        return "Wall";
    }
}
