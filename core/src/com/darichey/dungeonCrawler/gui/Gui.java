package com.darichey.dungeonCrawler.gui;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class Gui
{
    private String name;
    private Stage stage;

    public Gui(String name, Stage stage)
    {
        this.name = name;
        this.stage = stage;
        //this.stage.setViewport(new StretchViewport(60, 32));
    }

    public String getName()
    {
        return this.name;
    }

    public Stage getStage()
    {
        return this.stage;
    }

    public void render()
    {
        getStage().act();
        getStage().draw();
    }
}
