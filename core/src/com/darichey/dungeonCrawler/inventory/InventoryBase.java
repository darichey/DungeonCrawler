package com.darichey.dungeonCrawler.inventory;

import com.darichey.dungeonCrawler.entity.living.EntityPlayer;
import com.darichey.dungeonCrawler.item.stack.ItemStack;

import java.util.ArrayList;

/**
 * Inventories are simply a collection of {@link com.darichey.dungeonCrawler.inventory.Slot} objects to hold items
 */
public abstract class InventoryBase {
	private ArrayList<Slot> slots = new ArrayList<Slot>();
	/** The player interacting with this inventory **/
	private EntityPlayer interactingPlayer;

	public InventoryBase() {

	}

	public InventoryBase(InventoryBase inventoryBase) {
		for (int i = 0; i < inventoryBase.getSlots().size(); i++) {
			this.getSlots().add(inventoryBase.getSlot(i));
		}
	}

	public void setStackInSlot(int slotIndex, ItemStack stack) {
		this.slots.get(slotIndex).setItemStack(stack);
	}

	public ItemStack getStackInSlot(int slotIndex) {
		return this.slots.get(slotIndex).getItemStack();
	}

	public Slot getNextValidSlotFor(ItemStack stack) {
		for (Slot slot : slots) {
			if (slot.getItemSpace() > 0) {
				return slot;
			}
		}
		return null;
	}

	public Slot getSlot(int slotIndex) {
		return this.slots.get(slotIndex);
	}

	public ArrayList<Slot> getSlots() {
		return this.slots;
	}

	public void updateSlots() {
		for (Slot slot : getSlots()) {
			slot.update();
		}
	}

	public void addSlot(Slot slot) {
		if (!getSlots().contains(slot)) {
			getSlots().add(slot);
		}
	}

	public EntityPlayer getInteractingPlayer() {
		return interactingPlayer;
	}

	public void setInteractingPlayer(EntityPlayer player) {
		this.interactingPlayer = player;
	}
}
