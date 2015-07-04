package com.darichey.dungeonCrawler.handler;

import com.darichey.dungeonCrawler.event.Listener;
import com.darichey.dungeonCrawler.event.Subscribe;
import com.darichey.dungeonCrawler.event.world.entity.EntityEvent;

public class GameListener implements Listener
{
    @Subscribe
    public void onEntityEvent(EntityEvent event)
    {
        System.out.println(event.getName() + " detected by GameListener");
    }
}
