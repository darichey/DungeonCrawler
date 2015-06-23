package com.darichey.dungeonCrawler.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.darichey.dungeonCrawler.handler.CollisionHandler;
import com.darichey.dungeonCrawler.handler.HandlerBase;
import com.darichey.dungeonCrawler.handler.InputHandler;
import com.darichey.dungeonCrawler.handler.MovementHandler;
import com.darichey.dungeonCrawler.init.Entities;
import com.darichey.dungeonCrawler.render.Renderer;
import com.darichey.dungeonCrawler.world.World;

public class GameScreen extends ScreenAdapter
{
    private World world;
    private Renderer renderer;
    private HandlerBase movementHandler;
    private HandlerBase collisionHandler;
    private InputHandler inputHandler;

    public GameScreen()
    {
        Entities.init();

        world = new World();
        renderer = new Renderer(world);
        movementHandler = new MovementHandler(world.player);
        collisionHandler = new CollisionHandler(world);
        inputHandler = new InputHandler(world, renderer.camera);
        Gdx.input.setInputProcessor(inputHandler);
    }

    public void update()
    {
        world.update();
        movementHandler.update();
        //collisionHandler.update();
    }

    @Override
    public void render(float delta)
    {
        update();
        renderer.render();
    }

    @Override
    public void resize(int width, int height)
    {
        renderer.viewport.update(width, height);
    }
}
