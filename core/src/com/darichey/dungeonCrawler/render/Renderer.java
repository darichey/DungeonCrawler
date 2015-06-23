package com.darichey.dungeonCrawler.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.entity.base.LivingEntity;
import com.darichey.dungeonCrawler.world.EntityTileMap;
import com.darichey.dungeonCrawler.world.World;

public class Renderer
{
    private SpriteBatch batch;
    private World world;
    private ShapeRenderer debugRenderer = new ShapeRenderer();
    public OrthographicCamera camera;
    public Viewport viewport;
    private boolean debugRender = false;

    public Renderer(World world)
    {
        this.world = world;
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new FitViewport(800, 450, camera);
        viewport.apply();
    }

    public void render()
    {
        Gdx.gl.glClearColor(0f, 10f, 200f, 0f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.position.x = world.player.getPos().x;
        camera.position.y = world.player.getPos().y;
        camera.update();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        // Redo rendering with tile map
        for (int y = 0; y < World.height; y++)
        {
            for (int x = 0; x < World.width; x++)
            {
                GameEntity entity = world.getEntityTileMap().getEntityAt(new Vector2(x, y));
                if (entity != null)
                {
                    // Don't do * 16 use a viewport instead so it looks nice at different resolutions
                    batch.draw(entity.getTexture(), x * 16, y * 16);
                }
            }
        }

        for (LivingEntity entity : world.getLivingEntities())
        {
            batch.draw(entity.getTexture(), entity.getPos().x, entity.getPos().y);
        }

        if (debugRender) renderDebug();

        batch.end();
    }

    public void renderDebug()
    {
        debugRenderer.setProjectionMatrix(camera.combined);
        debugRenderer.begin(ShapeRenderer.ShapeType.Line);
        debugRenderer.setColor(1, 1, 0, 1);
        // Redo debug rendering with tile map
        for (int y = 0; y < World.height; y++)
        {
            for (int x = 0; x < World.width; x++)
            {
                GameEntity entity = world.getEntityTileMap().getEntityAt(new Vector2(x, y));
                if (entity != null)
                {
                    Rectangle bounds = entity.getBounds();
                    debugRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
                }
            }
        }

        for (LivingEntity entity : world.getLivingEntities())
        {
            Rectangle bounds = entity.getBounds();
            debugRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
        }

        debugRenderer.end();
    }
}
