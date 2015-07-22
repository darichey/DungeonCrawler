package com.darichey.dungeonCrawler.handler;

import com.darichey.dungeonCrawler.entity.EntityPlayer;

/**
 * Handles player movement
 */
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
        player.getPos().add(player.getVelocity());
        player.getVelocity().scl(player.getDampingSpeed());
    }
}
