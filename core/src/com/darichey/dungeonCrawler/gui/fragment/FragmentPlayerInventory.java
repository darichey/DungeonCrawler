package com.darichey.dungeonCrawler.gui.fragment;

import com.darichey.dungeonCrawler.entity.living.EntityPlayer;

public class FragmentPlayerInventory extends FragmentInventory {
	public FragmentPlayerInventory(EntityPlayer player) {
		super(player.getInventory());
	}
}
