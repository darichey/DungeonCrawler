package com.darichey.dungeonCrawler.gui;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.darichey.dungeonCrawler.gui.fragment.Fragment;

import java.util.ArrayList;

public abstract class GuiBase {

	/** The stage to which all of this Gui's actors will be added **/
	protected Stage stage;

	/** A list of this Gui's fragments **/
	private ArrayList<Fragment> fragments = new ArrayList<>();

	public void addFragment(Fragment fragment) {
		// Check if this gui already contains this fragment
		if (!fragments.contains(fragment)) {
			// Check if this fragment already belongs to another gui
			if (fragment.parentGui == null) {
				fragment.parentGui = this;
				fragments.add(fragment);

				// Add every actor from the fragment to this gui's stage
				for (Actor actor : fragment.getActors()) {
					this.stage.addActor(actor);
				}
			}
		}
	}

	public void removeFragment(Fragment fragment) {
		if (fragments.contains(fragment)) {
			fragment.parentGui = null;
			fragments.remove(fragment);
			for (Actor actor : fragment.getActors()) {
				actor.remove();
			}
		}
	}

	public boolean hasFragment(Fragment fragment) {
		return fragments.contains(fragment);
	}

	public Stage getStage() {
		return this.stage;
	}

	public void updateFragments() {
		for (Fragment fragment : fragments) {
			fragment.update();
		}
	}
}
