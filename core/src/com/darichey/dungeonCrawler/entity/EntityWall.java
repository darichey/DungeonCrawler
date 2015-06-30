package com.darichey.dungeonCrawler.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.world.World;

public class EntityWall extends GameEntity
{
    public EntityWall()
    {
        this.width = 1;
        this.height = 1;
        this.texture = new Texture(Gdx.files.internal("wall.png"));
    }

    @Override
    public String getName()
    {
        return "Wall";
    }
}
