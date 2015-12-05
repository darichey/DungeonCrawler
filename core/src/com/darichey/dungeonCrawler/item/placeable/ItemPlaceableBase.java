package com.darichey.dungeonCrawler.item.placeable;

import com.darichey.dungeonCrawler.entity.base.GameEntity;
import com.darichey.dungeonCrawler.item.ItemBase;

public abstract class ItemPlaceableBase extends ItemBase {
	/**
	 * The entity that is placed by this item.
	 */
	private GameEntity entity;

	public ItemPlaceableBase(GameEntity entity) {
		this.entity = entity;
		this.entity.setPlaceable(this);
		this.texture = entity.getTexture();
	}

	public GameEntity getEntity() {
		return this.entity;
	}
}
