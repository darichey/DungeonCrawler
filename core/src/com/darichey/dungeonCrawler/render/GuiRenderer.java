package com.darichey.dungeonCrawler.render;

import com.darichey.dungeonCrawler.gui.Gui;

public class GuiRenderer
{

    /** The gui currently being rendered**/
    private Gui gui;

    public void render()
    {
        gui.update();
        gui.getStage().act();
        gui.getStage().draw();
    }

    public void showGui(Gui gui)
    {
        this.gui = gui;
    }
}
