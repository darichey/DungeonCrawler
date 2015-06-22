package com.darichey.dungeonCrawler.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.darichey.dungeonCrawler.entity.EntityWall;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.world.World;

public class Renderer
{
    private SpriteBatch batch;
    private World world;
    private GameViewport viewport;
    private ShapeRenderer debugRenderer = new ShapeRenderer();
    private boolean debugRender = true;

    public Renderer(World world)
    {
        this.world = world;
        batch = new SpriteBatch();
        viewport = new GameViewport(new OrthographicCamera(800, 450));
        viewport.getCamera().position.set(800, 450, 0);
    }

    public void render()
    {
        Gdx.gl.glClearColor(0f, 10f, 200f, 0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        viewport.setScreenPosition(Math.round(world.player.getPos().x), Math.round(world.player.getPos().y));
        viewport.getCamera().update();

        batch.setProjectionMatrix(viewport.getCamera().combined);
        batch.begin();
        for (GameEntity entity : world.entities)
        {
            batch.draw(entity.getTexture(), entity.getPos().x, entity.getPos().y);
        }
        batch.end();

        if (debugRender) renderDebug();
    }

    public void renderDebug()
    {
        debugRenderer.setProjectionMatrix(viewport.getCamera().combined);
        debugRenderer.begin(ShapeRenderer.ShapeType.Line);
        debugRenderer.setColor(1, 1, 0, 1);
        for (GameEntity entity : world.entities)
        {
            Rectangle bounds = entity.getBounds();
            debugRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
        }
        debugRenderer.end();
    }
}
