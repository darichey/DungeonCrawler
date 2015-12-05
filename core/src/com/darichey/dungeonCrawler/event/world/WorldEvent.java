package com.darichey.dungeonCrawler.event.world;

import com.darichey.dungeonCrawler.event.Event;
import com.darichey.dungeonCrawler.world.World;

/**
 * Event happening within the world.
 */
public class WorldEvent extends Event {
	protected World world;

	public WorldEvent(World world) {
		this.world = world;
	}

	public final World getWorld() {
		return this.world;
	}
}
