package com.darichey.dungeonCrawler.handler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.darichey.dungeonCrawler.entity.EntityPlayer;

public class MovementHandler extends HandlerBase
{
    private EntityPlayer player;

    public MovementHandler(EntityPlayer player)
    {
        this.player = player;
    }

    @Override
    public void update()
    {
        if (isLeftKeyPressed())
        {
            player.setPosX(player.getPos().x - 1);
        }

        if (isRightKeyPressed())
        {
            player.setPosX(player.getPos().x + 1);
        }

        if (isDownKeyPressed())
        {
            player.setPosY(player.getPos().y - 1);
        }

        if (isUpKeyPressed())
        {
            player.setPosY(player.getPos().y + 1);
        }
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
}
