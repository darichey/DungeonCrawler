package com.darichey.dungeonCrawler.gui.fragment;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.darichey.dungeonCrawler.gui.GuiBase;

import java.util.ArrayList;

public abstract class GuiFragment {
	public GuiBase parentGui;
	public String name;

	/**
	 * List of actors that will be added to the parent GUI's stage *
	 */
	private ArrayList<Actor> actors = new ArrayList<Actor>();

	public GuiFragment(String name) {
		this.name = name;
	}

	public GuiBase getParentGui() {
		return this.parentGui;
	}

	public ArrayList<Actor> getActors() {
		return this.actors;
	}

	public void update() {

	}
}
