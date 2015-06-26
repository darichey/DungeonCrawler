package com.darichey.dungeonCrawler.render;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.entity.base.MovingEntity;
import com.darichey.dungeonCrawler.world.World;

public class Renderer
{
    private SpriteBatch batch;
    private World world;
    private ShapeRenderer debugRenderer = new ShapeRenderer();
    public OrthographicCamera camera;
    public Viewport viewport;
    private boolean debugRender = true;

    // Broken
    private Stage stage = new Stage();
    private Label.LabelStyle labelStyle = new Label.LabelStyle(new BitmapFont(), Color.RED);
    private Label fpsLabel = new Label("FPS: " + Gdx.graphics.getFramesPerSecond(), labelStyle);

    public Renderer(World world)
    {
        this.world = world;
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        viewport = new FitViewport(800, 450, camera);
        viewport.apply();

        // Broken
        fpsLabel.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        stage.addActor(fpsLabel);
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
                        //FIXME: Don't do * 16 use a viewport instead so it looks nice at different resolutions
                        batch.draw(entity.getTexture(), x * 16, y * 16);
                    }
                }
            }
        }

        for (MovingEntity entity : world.getMovingEntities())
        {
            batch.draw(entity.getTexture(), entity.getPos().x, entity.getPos().y);
        }

        batch.end();

        if (debugRender) renderDebug();
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
                if (positionIsOnScreen(new Vector2(x, y)))
                {
                    GameEntity entity = world.getEntityTileMap().getEntityAt(new Vector2(x, y));
                    if (entity != null)
                    {
                        //FIXME: Don't do * 16 use a viewport instead so it looks nice at different resolutions
                        Rectangle bounds = world.getEntityTileMap().getBoundsOfEntity(entity, new Vector2(x, y));
                        debugRenderer.rect(bounds.x * 16, bounds.y * 16, bounds.width, bounds.height);
                    }
                }
            }
        }

        for (MovingEntity entity : world.getMovingEntities())
        {
            Rectangle bounds = entity.getBounds();
            debugRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
        }

        debugRenderer.end();
    }

    public boolean positionIsOnScreen(Vector2 worldPos)
    {
        //FIXME: Don't use 16
        Vector2 pixelPos = new Vector2(worldPos.x * 16, worldPos.y * 16);
        Vector3 screenPos = camera.project(new Vector3(pixelPos.x, pixelPos.y, 0));
        if (screenPos.x < Gdx.graphics.getWidth() + 32 && screenPos.x > -32)
        {
            if (screenPos.y < Gdx.graphics.getHeight() + 32 && screenPos.y > -32)
            {
                return true;
            }
        }
        return false;
    }
}
