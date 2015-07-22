package com.darichey.dungeonCrawler.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.darichey.dungeonCrawler.entity.base.GameEntity;

public class EntityBlock2 extends EntityBlock
{
    public EntityBlock2()
    {
        this.width = 1;
        this.height = 1;
        this.texture = new Texture(Gdx.files.internal("Block2.png"));
    }

    @Override
    public String getName()
    {
        return "Wall2";
    }
}
