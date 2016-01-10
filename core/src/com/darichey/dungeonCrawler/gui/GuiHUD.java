package com.darichey.dungeonCrawler.gui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.darichey.dungeonCrawler.entity.living.EntityPlayer;
import com.darichey.dungeonCrawler.gui.fragment.FragmentHotbar;
import com.darichey.dungeonCrawler.gui.fragment.FragmentPlayerInventory;

public class GuiHUD extends GuiBase {
	public GuiHUD(Stage stage, EntityPlayer player) {
		this.stage = stage;
		this.addFragment(new FragmentHotbar(player));
	}
}
