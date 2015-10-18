package com.darichey.dungeonCrawler.gui;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.darichey.dungeonCrawler.entity.living.EntityPlayer;
import com.darichey.dungeonCrawler.gui.fragment.FragmentHotbar;
import com.darichey.dungeonCrawler.reference.Names;

public class GuiHUD extends GuiBase
{
    public GuiHUD(EntityPlayer player)
    {
        super(Names.HUD, new Stage());
        this.addFragment(new FragmentHotbar(player));
    }
}
