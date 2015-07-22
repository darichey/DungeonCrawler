package com.darichey.dungeonCrawler.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.darichey.dungeonCrawler.entity.EntityPlayer;
import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.init.Entities;
import com.darichey.dungeonCrawler.world.World;

/**
 * Handles mouse and keyboard input
 */
public class InputHandler extends InputAdapter
{
    private World world;
    private OrthographicCamera camera;
    private EntityPlayer player;

    public InputHandler(World world, OrthographicCamera camera)
    {
        this.world = world;
        this.camera = camera;
        this.player = world.player;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {
        Vector3 touchPos = new Vector3(screenX, screenY, 0);
        Vector3 worldPos = camera.unproject(touchPos);
        GameEntity entity = world.getEntityAt(new Vector2(worldPos.x, worldPos.y));
        if (entity == null)
        {
            if (button == 0)
            {
                world.setEntityAt(Entities.block, new Vector2(worldPos.x, worldPos.y));
            }
            else if (button == 1)
            {
                world.setEntityAt(Entities.block2, new Vector2(worldPos.x, worldPos.y));
            }
        }
        else
        {
            world.setEntityAt(null, new Vector2(worldPos.x, worldPos.y));
        }
        return false;
    }

    public void update()
    {
        if (Gdx.input.isKeyPressed(Input.Keys.D))
        {
            player.setVelocityX(player.getMovementSpeed());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.A))
        {
            player.setVelocityX(-player.getMovementSpeed());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.W))
        {
            player.setVelocityY(player.getMovementSpeed());
        }

        if (Gdx.input.isKeyPressed(Input.Keys.S))
        {
            player.setVelocityY(-player.getMovementSpeed());
        }
    }
}