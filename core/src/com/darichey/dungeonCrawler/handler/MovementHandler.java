package com.darichey.dungeonCrawler.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.EntityPlayer;
import com.darichey.dungeonCrawler.entity.EntityWall;
import com.darichey.dungeonCrawler.entity.base.GameEntity;

/**
 * Handles player movement
 */
public class MovementHandler extends HandlerBase
{
    private EntityPlayer player;
    private float movementSpeed = 1f;
    private float roundingFactor = movementSpeed * 100;

    public MovementHandler(EntityPlayer player)
    {
        this.player = player;
    }

    @Override
    public void update()
    {
        if (isLeftKeyPressed())
        {
            if (canMoveTo(new Vector2(player.getPos().x - movementSpeed, player.getPos().y)))
            {
                //player.setPosX(player.getPos().x - movementSpeed);
                player.setPosX(Math.round((player.getPos().x - movementSpeed)*roundingFactor)/roundingFactor);
            }
        }

        if (isRightKeyPressed())
        {
            if (canMoveTo(new Vector2(player.getPos().x + movementSpeed, player.getPos().y)))
            {
                //player.setPosX(player.getPos().x + movementSpeed);
                player.setPosX(Math.round((player.getPos().x + movementSpeed)*roundingFactor)/roundingFactor);
            }
        }

        if (isDownKeyPressed())
        {
            if (canMoveTo(new Vector2(player.getPos().x, player.getPos().y - movementSpeed)))
            {
                //player.setPosY(player.getPos().y - movementSpeed);
                player.setPosY(Math.round((player.getPos().y - movementSpeed) * roundingFactor)/roundingFactor);
            }
        }

        if (isUpKeyPressed())
        {
            if (canMoveTo(new Vector2(player.getPos().x, player.getPos().y + movementSpeed)))
            {
                //player.setPosY(player.getPos().y + movementSpeed);
                player.setPosY(Math.round((player.getPos().y + movementSpeed) * roundingFactor)/roundingFactor);
            }
        }

        System.out.println(player.getPos());
    }

    private boolean isLeftKeyPressed()
    {
        return Gdx.input.isKeyPressed(Input.Keys.A) || Gdx.input.isKeyPressed(Input.Keys.LEFT);
    }

    private boolean isRightKeyPressed()
    {
        return Gdx.input.isKeyPressed(Input.Keys.D) || Gdx.input.isKeyPressed(Input.Keys.RIGHT);
    }

    private boolean isDownKeyPressed()
    {
        return Gdx.input.isKeyPressed(Input.Keys.S) || Gdx.input.isKeyPressed(Input.Keys.DOWN);
    }

    private boolean isUpKeyPressed()
    {
        return Gdx.input.isKeyPressed(Input.Keys.W) || Gdx.input.isKeyPressed(Input.Keys.UP);
    }

    private boolean canMoveTo(Vector2 pos)
    {
        Rectangle playerBounds = new Rectangle(pos.x, pos.y, player.width, player.height);
        for (Vector2 wallPos : player.world.getWallPositions())
        {
            GameEntity wall = player.world.getEntityAt(wallPos);
            Rectangle wallBounds = new Rectangle(wallPos.x, wallPos.y, wall.width, wall.height);
            if (playerBounds.overlaps(wallBounds))
            {
                return false;
            }
        }
        return true;
    }
}
