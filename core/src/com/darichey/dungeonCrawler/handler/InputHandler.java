package com.darichey.dungeonCrawler.handler;

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

    private float movementSpeed = .1f;
    private float roundingFactor = movementSpeed * 100;

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
            world.setEntityAt(Entities.block, new Vector2(worldPos.x, worldPos.y));
        }
        else
        {
            world.setEntityAt(null, new Vector2(worldPos.x, worldPos.y));
        }
        return false;
    }

    @Override
    public boolean keyDown(int keycode)
    {
        if (isLeftKey(keycode))
        {
            player.setVelocityX(Math.round((player.getVelocity().x - movementSpeed) * roundingFactor) / roundingFactor);
        }

        if (keycode == Input.Keys.D)
        {
            player.setVelocityX(Math.round((player.getVelocity().x + movementSpeed)*roundingFactor)/roundingFactor);
        }

        if (isDownKey(keycode))
        {
            player.setVelocityY(Math.round((player.getVelocity().y - movementSpeed) * roundingFactor) / roundingFactor);
        }

        if (isUpKey(keycode))
        {
            player.setVelocityY(Math.round((player.getVelocity().y + movementSpeed) * roundingFactor) / roundingFactor);
        }
        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        if (isLeftKey(keycode) || isRightKey(keycode))
        {
            player.setVelocityX(0);
        }

        if (isDownKey(keycode) || isUpKey(keycode))
        {
            player.setVelocityY(0);
        }
        return false;
    }

    private boolean isLeftKey(int keycode)
    {
        return keycode == Input.Keys.A || keycode == Input.Keys.LEFT;
    }

    private boolean isRightKey(int keycode)
    {
        return keycode == Input.Keys.D || keycode == Input.Keys.RIGHT;
    }

    private boolean isDownKey(int keycode)
    {
        return keycode == Input.Keys.S || keycode == Input.Keys.DOWN;
    }

    private boolean isUpKey(int keycode)
    {
        return keycode == Input.Keys.W || keycode == Input.Keys.UP;
    }
}