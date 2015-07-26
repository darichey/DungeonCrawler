package com.darichey.dungeonCrawler.item.base;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class ItemCoin extends ItemBase
{
    public ItemCoin()
    {
        this.texture = new Texture(Gdx.files.internal("cookie.png"));
        this.name = "Coin";
    }
}
