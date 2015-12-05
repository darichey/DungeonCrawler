package com.darichey.dungeonCrawler.entity.base;

/**
 * The base class for living entities (They have health and can die).
 */
public abstract class LivingEntity extends DynamicEntity {
	public int health;

	public void setHealth(int health) {
		this.health = health;
	}

	public int getHealth() {
		return this.health;
	}

	public void setDead() {
		setHealth(0);
	}
}
