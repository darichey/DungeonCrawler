package com.darichey.dungeonCrawler.event.world.entity;

import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.base.DynamicEntity;

/**
 * Event fired when a dynamic entity collides with a block
 */
public class EventDynamicCollideBlock extends EntityEvent {
	private Vector2 blockPos;

	public EventDynamicCollideBlock(DynamicEntity dynamic, Vector2 blockPos) {
		super(dynamic);
		this.blockPos = blockPos;
	}

	public Vector2 getBlockPos() {
		return this.blockPos;
	}
}
