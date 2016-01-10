package com.darichey.dungeonCrawler.gui.fragment;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.darichey.dungeonCrawler.gui.GuiBase;

import java.util.ArrayList;

/**
 * A group of actors that make up a gui.
 */
public abstract class Fragment {
	/** A list of this fragment's actors. These will be added to the parentGui's stage **/
	private ArrayList<Actor> actors = new ArrayList<>();

	/** The Gui that this fragment belongs to **/
	public GuiBase parentGui;

	public ArrayList<Actor> getActors() {
		return this.actors;
	}

	public void update() {}

}
