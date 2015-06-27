package com.darichey.dungeonCrawler.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.entity.base.DynamicEntity;
import com.darichey.dungeonCrawler.world.World;

public class Renderer
{
    private SpriteBatch batch;
    private World world;
    private ShapeRenderer debugRenderer = new ShapeRenderer();
    public OrthographicCamera camera;
    private boolean debugRender = true;

    private int VIEWPORT_WIDTH  = 50;
    private int VIEWPORT_HEIGHT = 30;

    public Renderer(World world)
    {
        this.world = world;
        batch = new SpriteBatch();
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
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

        for (int y = 0; y < World.height; y++)
        {
            for (int x = 0; x < World.width; x++)
            {
                if (positionIsOnScreen(new Vector2(x ,y)))
                {
                    GameEntity entity = world.getEntityTileMap().getEntityAt(new Vector2(x, y));
                    if (entity != null)
                    {
                        batch.draw(entity.getTexture(), x, y, entity.width, entity.height);
                    }
                }
            }
        }

        for (DynamicEntity entity : world.getDynamicEntities())
        {
            System.out.println(entity.getName());
            if (positionIsOnScreen(entity.getPos()))
                batch.draw(entity.getTexture(), entity.getPos().x, entity.getPos().y, entity.width, entity.height);
        }

        batch.end();

        if (debugRender) renderDebug();
    }

    public void renderDebug()
    {
        debugRenderer.setProjectionMatrix(camera.combined);
        debugRenderer.begin(ShapeRenderer.ShapeType.Line);
        debugRenderer.setColor(1, 1, 0, 1);

        for (int y = 0; y < World.height; y++)
        {
            for (int x = 0; x < World.width; x++)
            {
                if (positionIsOnScreen(new Vector2(x, y)))
                {
                    GameEntity entity = world.getEntityTileMap().getEntityAt(new Vector2(x, y));
                    if (entity != null)
                    {
                        debugRenderer.rect(x, y, entity.width, entity.height);
                    }
                }
            }
        }

        for (DynamicEntity entity : world.getDynamicEntities())
        {
            if (positionIsOnScreen(entity.getPos()))
            {
                debugRenderer.rect(entity.getPos().x, entity.getPos().y, entity.width, entity.height);
            }
        }

        debugRenderer.end();
    }

    public boolean positionIsOnScreen(Vector2 worldPos)
    {
        Vector2 pixelPos = new Vector2(worldPos.x, worldPos.y);
        Vector3 screenPos = camera.project(new Vector3(pixelPos.x, pixelPos.y, 0));
        if (screenPos.x < Gdx.graphics.getWidth() + 2 && screenPos.x > -2)
        {
            if (screenPos.y < Gdx.graphics.getHeight() + 2 && screenPos.y > -2)
            {
                return true;
            }
        }
        return false;
    }
}
