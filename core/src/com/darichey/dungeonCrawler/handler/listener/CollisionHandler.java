package com.darichey.dungeonCrawler.handler.listener;

import com.darichey.dungeonCrawler.event.Listener;
import com.darichey.dungeonCrawler.event.Subscribe;
import com.darichey.dungeonCrawler.event.world.entity.EventDynamicCollideDynamic;
import com.darichey.dungeonCrawler.event.world.entity.EventDynamicCollideBlock;

/**
 * Handles collision events posted by {@link com.darichey.dungeonCrawler.handler.poster.CollisionPoster}
 */
public class CollisionHandler implements Listener
{
    @Subscribe
    public void onDynamicCollideDynamic(EventDynamicCollideDynamic event)
    {
        System.out.println("dynamic collide dynamic");
    }

    @Subscribe
    public void onDynamicCollideBlock(EventDynamicCollideBlock event)
    {
        System.out.println("dynamic collide block");
    }
}
