package com.darichey.dungeonCrawler.handler;

import com.darichey.dungeonCrawler.entity.living.EntityPlayer;

/**
 * Applies velocity set by the {@link InputHandler} to the player.
 */
public class MovementHandler extends HandlerBase {
    private EntityPlayer player;

    public MovementHandler(EntityPlayer player) {
        this.player = player;
    }

    @Override
    public void update(float deltaTime) {
        player.getPos().add(player.getVelocity().scl(deltaTime));
        player.getVelocity().scl(player.getDampingSpeed());
    }
}
