package com.darichey.dungeonCrawler.gui.fragment;

import com.darichey.dungeonCrawler.entity.living.EntityPlayer;
import com.darichey.dungeonCrawler.reference.Names;

public class FragmentPlayerInventory extends FragmentInventory {
    public FragmentPlayerInventory(EntityPlayer player) {
        super(player.getInventory().getNoHotbarInventory(), Names.playerInventory);
    }
}
