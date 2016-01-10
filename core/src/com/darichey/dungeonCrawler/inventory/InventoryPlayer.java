package com.darichey.dungeonCrawler.inventory;

import com.badlogic.gdx.math.Vector2;
import com.darichey.dungeonCrawler.entity.living.EntityPlayer;
import com.darichey.dungeonCrawler.item.stack.ItemStack;

import java.util.ArrayList;

public class InventoryPlayer extends InventoryBase {
	public EntityPlayer player;

	public InventoryPlayer(EntityPlayer player) {
		for (int y = 0; y < 5; y++) {
			for (int x = 0; x < 10; x++) {
				Slot slot = new Slot(this, new Vector2(28 + (x * 36), 975 - (y * 36)));
				addSlot(slot);
			}
		}
		setInteractingPlayer(player);
	}
}
