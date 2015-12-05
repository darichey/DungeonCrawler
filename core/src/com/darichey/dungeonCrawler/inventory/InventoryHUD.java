package com.darichey.dungeonCrawler.inventory;

import com.badlogic.gdx.math.Vector2;

public class InventoryHUD extends InventoryBase {
	private InventoryPlayer inventoryPlayer;

	public InventoryHUD(InventoryPlayer inventoryPlayer) {
		for (int i = 0; i < 10; i++) {
			Slot slot = new Slot(new Vector2(28 + ((i * 36)), 975));
			addSlot(slot);
			slot.setItemStack(inventoryPlayer.getStackInSlot(i));
		}
		this.inventoryPlayer = inventoryPlayer;
	}

	@Override
	public void updateSlots() {
		for (int i = 0; i < 10; i++) {
			getSlot(i).setItemStack(inventoryPlayer.getStackInSlot(i));
			getSlot(i).update();
		}
	}
}
