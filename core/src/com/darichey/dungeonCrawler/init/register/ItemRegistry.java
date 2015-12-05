package com.darichey.dungeonCrawler.init.register;

import com.darichey.dungeonCrawler.item.ItemBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Registry for Items
 */
public class ItemRegistry {
	private static HashMap<Integer, ItemBase> items = new HashMap<Integer, ItemBase>();
	private static int nextID = 0;

	/**
	 * Registers the passed item, giving it a unique ID
	 *
	 * @param item The item to register
	 */
	public static void register(ItemBase item) {
		if (items.containsValue(item)) {
			throw new IllegalArgumentException("Attempt to register an already-registered item: " + item.getName());
		}
		items.put(++nextID, item);
	}

	/**
	 * Gets the item linked to the passed ID
	 *
	 * @param id ID of the item being searched for
	 * @return The linked item
	 */
	public static ItemBase getItemFromID(int id) {
		return items.get(id);
	}

	/**
	 * Gets the ID linked to the passed item
	 *
	 * @param item Item to find ID for
	 * @return ID of item
	 */
	public static Integer getIDForItem(ItemBase item) {
		Set<Map.Entry<Integer, ItemBase>> entries = items.entrySet();
		for (Map.Entry entry : entries) {
			if (entry.getValue().equals(item)) {
				return (Integer) entry.getKey();
			}
		}
		return null;
	}

	/**
	 * @return A list of all registered items
	 */
	public static ArrayList<ItemBase> getRegisteredItems() {
		ArrayList<ItemBase> returnList = new ArrayList<ItemBase>();
		Set<Map.Entry<Integer, ItemBase>> entries = items.entrySet();
		for (Map.Entry entry : entries) {
			returnList.add((ItemBase) entry.getValue());
		}
		return returnList;
	}
}
