package com.darichey.dungeonCrawler.gui.fragment;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.darichey.dungeonCrawler.entity.living.EntityPlayer;
import com.darichey.dungeonCrawler.reference.TextureLibrary;

public class FragmentHotbar extends FragmentInventory {
	private Image selectedSlot = new Image(new TextureRegionDrawable(new TextureRegion(TextureLibrary.slotSelected)));
	private EntityPlayer player;

	public FragmentHotbar(EntityPlayer player) {
		super(player.getInventory());
		this.player = player;

		this.selectedSlot.setScale(2);
		this.getActors().add(selectedSlot);
	}

	@Override
	public void update() {
		// Render the selection indicator around the selected slot.
		Vector2 selectedDisplayPos = getInventory().getSlot(player.getSelectedSlotIndex()).getDisplayPos();
		this.selectedSlot.setPosition(selectedDisplayPos.x, selectedDisplayPos.y);
		super.update();
	}
}
