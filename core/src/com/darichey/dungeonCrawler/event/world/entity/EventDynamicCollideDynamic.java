package com.darichey.dungeonCrawler.event.world.entity;

import com.darichey.dungeonCrawler.entity.base.DynamicEntity;

/**
 * Event fired when a dynamic entity collides with another dynamic entity
 */
public class EventDynamicCollideDynamic extends EntityEvent {
	private DynamicEntity collided;

	public EventDynamicCollideDynamic(DynamicEntity collider, DynamicEntity collided) {
		super(collider);
		this.collided = collided;
	}

	public DynamicEntity getCollided() {
		return this.collided;
	}
}
