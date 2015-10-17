package com.darichey.dungeonCrawler.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.darichey.dungeonCrawler.event.EventManager;
import com.darichey.dungeonCrawler.handler.*;
import com.darichey.dungeonCrawler.init.Entities;
import com.darichey.dungeonCrawler.init.Items;
import com.darichey.dungeonCrawler.render.WorldRenderer;
import com.darichey.dungeonCrawler.world.World;

/**
 * Main playing screen for the game
 */
public class GameScreen extends ScreenAdapter
{
    private World world;
    private WorldRenderer worldRenderer;
    private HandlerBase movementHandler;
    private HandlerBase collisionHandler;
    private InputHandler inputHandler;

    public static Label.LabelStyle labelStyle = new Label.LabelStyle(new BitmapFont(), Color.WHITE);

    public GameScreen()
    {
        Entities.init();
        Items.init();

        world = new World();
        worldRenderer = new WorldRenderer(world);
        movementHandler = new MovementHandler(world.player);
        collisionHandler = new CollisionHandler(world);
        inputHandler = new InputHandler(world, worldRenderer.camera);

        Gdx.input.setInputProcessor(inputHandler);
        EventManager.register(new EventListener());
    }

    public void update(float delta)
    {
        world.update();
        movementHandler.update(delta);
        collisionHandler.update(delta);
        inputHandler.update();
    }

    @Override
    public void render(float delta)
    {
        update(delta);
        worldRenderer.render();
    }
}
