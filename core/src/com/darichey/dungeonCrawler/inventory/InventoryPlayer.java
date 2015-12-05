package com.darichey.dungeonCrawler.inventory;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class InventoryPlayer extends InventoryBase {
	public InventoryPlayer() {
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 10; x++) {
				Slot slot = new Slot(new Vector2(28 + (x * 36), 975 - (y * 36)));
				addSlot(slot);
			}
		}
	}

	public ArrayList<Slot> getHotBarSlots() {
		ArrayList<Slot> hotBarSlots = new ArrayList<Slot>();
		for (int i = 0; i < 10; i++) {
			hotBarSlots.add(getSlot(i));
		}
		return hotBarSlots;
	}

	public InventoryPlayerNoHotbar getNoHotbarInventory() {
		return new InventoryPlayerNoHotbar(this);
	}

	/**
	 * A version of the player's inventory with no hotbar slots.
	 */
	private class InventoryPlayerNoHotbar extends InventoryBase {
		public InventoryPlayerNoHotbar(InventoryPlayer inventory) {
			super(inventory);
			for (int i = 0; i < 10; i++) {
				this.getSlots().remove(0);
			}
		}
	}
}
