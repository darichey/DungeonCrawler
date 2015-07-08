package com.darichey.dungeonCrawler.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.darichey.dungeonCrawler.event.EventManager;
import com.darichey.dungeonCrawler.handler.*;
import com.darichey.dungeonCrawler.handler.listener.CollisionHandler;
import com.darichey.dungeonCrawler.handler.poster.CollisionPoster;
import com.darichey.dungeonCrawler.init.Entities;
import com.darichey.dungeonCrawler.render.Renderer;
import com.darichey.dungeonCrawler.world.World;

/**
 * Main playing screen for the game
 */
public class GameScreen extends ScreenAdapter
{
    private World world;
    private Renderer renderer;
    private HandlerBase movementHandler;
    //private InputAdapter movementHandler;
    private HandlerBase collisionPoster;
    private InputHandler inputHandler;

    public GameScreen()
    {
        Entities.init();

        world = new World();
        renderer = new Renderer(world);
        movementHandler = new MovementHandler(world.player);
        collisionPoster = new CollisionPoster(world);
        inputHandler = new InputHandler(world, renderer.camera);
        EventManager.register(new CollisionHandler());
        Gdx.input.setInputProcessor(inputHandler);
    }

    public void update()
    {
        world.update();
        movementHandler.update();
        collisionPoster.update();
    }

    @Override
    public void render(float delta)
    {
        update();
        renderer.render();
    }
}
