package com.darichey.dungeonCrawler.render;

import com.darichey.dungeonCrawler.gui.Gui;

public class GuiRenderer
{

    /**
     * The gui currently being rendered*
     */
    private Gui gui;

    public void render()
    {
        gui.render();
    }

    public void showGui(Gui gui)
    {
        this.gui = gui;
    }

    public Gui getCurrentGui()
    {
        return this.gui;
    }
}
