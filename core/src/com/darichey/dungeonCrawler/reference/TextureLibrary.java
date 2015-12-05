package com.darichey.dungeonCrawler.reference;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureLibrary {
    public static final Texture stone = new Texture(Gdx.files.internal("stone.png"));
    public static final Texture player = new Texture(Gdx.files.internal("player.png"));
    public static final Texture cookie = new Texture(Gdx.files.internal("cookie.png"));

    public static final Texture slotSelected = new Texture(Gdx.files.internal("slotSelected.png"));
}
