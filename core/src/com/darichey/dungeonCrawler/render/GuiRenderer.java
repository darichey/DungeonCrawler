package com.darichey.dungeonCrawler.render;

import com.darichey.dungeonCrawler.gui.GuiBase;

public class GuiRenderer {
	/** The current gui being displayed **/
	private GuiBase gui;

	public void render() {
		gui.updateFragments();
		gui.getStage().act();
		gui.getStage().draw();
	}

	public void setGui(GuiBase gui) {
		this.gui = gui;
	}

	public GuiBase getGui() {
		return this.gui;
	}
}
