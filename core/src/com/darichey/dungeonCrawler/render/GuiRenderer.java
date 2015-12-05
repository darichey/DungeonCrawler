package com.darichey.dungeonCrawler.render;

import com.darichey.dungeonCrawler.gui.GuiBase;

public class GuiRenderer {
	private GuiBase gui;

	public void render() {
		gui.render();
	}

	public void showGui(GuiBase gui) {
		this.gui = gui;
	}

	public GuiBase getCurrentGui() {
		return this.gui;
	}
}
