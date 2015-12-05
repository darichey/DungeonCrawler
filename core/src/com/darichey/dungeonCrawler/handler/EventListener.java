package com.darichey.dungeonCrawler.handler;

import com.darichey.dungeonCrawler.event.Listener;
import com.darichey.dungeonCrawler.event.Subscribe;
import com.darichey.dungeonCrawler.event.world.block.BlockPlacedEvent;

public class EventListener implements Listener {
	@Subscribe
	public void onBlockPlacedEvent(BlockPlacedEvent event) {
		//event.setCanceled(event.getBlock() == Entities.block);
	}
}
