package com.darichey.dungeonCrawler.gui.fragment;

import com.darichey.dungeonCrawler.inventory.InventoryBase;
import com.darichey.dungeonCrawler.inventory.Slot;

/**
 * A Fragment that automatically stores all of the actors from all of the slots from an InventoryBase
 */
public class FragmentInventory extends Fragment {
	private InventoryBase inventory;

	public FragmentInventory(InventoryBase inventory) {
		this.inventory = inventory;
		for (Slot slot : inventory.getSlots()) {
			getActors().add(slot.slotImage);
			getActors().add(slot.itemImage);
			getActors().add(slot.amountLabel);

		}
	}

	public InventoryBase getInventory() {
		return inventory;
	}

	@Override
	public void update() {
		this.inventory.updateSlots();
	}
}
