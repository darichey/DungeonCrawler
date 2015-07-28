package com.darichey.dungeonCrawler.item;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.darichey.dungeonCrawler.item.base.ItemBase;

public class ItemCookie extends ItemBase
{
    public ItemCookie()
    {
        this.texture = new Texture(Gdx.files.internal("cookie.png"));
        this.name = "Cookie";
    }
}
