package com.darichey.dungeonCrawler.gui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.darichey.dungeonCrawler.gui.fragment.GuiFragment;
import com.darichey.dungeonCrawler.util.Logger;

import java.util.ArrayList;

/**
 * A GUI that can be rendered on screen. Made up of multiple GuiFragments which contain the actual content being rendered.
 */
public abstract class GuiBase
{
    private ArrayList<GuiFragment> fragments = new ArrayList<GuiFragment>();
    private Stage stage;
    private String name;

    public GuiBase(String name, Stage stage)
    {
        this.name = name;
        this.stage = stage;
    }

    public GuiBase(String name, Stage stage, ArrayList<GuiFragment> fragments)
    {
        this(name, stage);
        this.fragments = fragments;
    }

    @SuppressWarnings("unchecked")
    public void addFragment(GuiFragment fragment)
    {
        if (!this.getFragments().contains(fragment))
        {
            if (fragment.parentGui == null)
            {
                this.getFragments().add(fragment);
                fragment.parentGui = this;
                for (Actor actor : fragment.getActors())
                {
                    this.getStage().addActor(actor);
                }
            }
            else
            {
                Logger.log("GuiFragment already belongs to another Gui.");
            }
        }
        else
        {
            Logger.log("Attempt to add already-existing GuiFragment to Gui.");
        }
    }

    public void removeFragment(GuiFragment fragment)
    {
        if (this.getFragments().contains(fragment))
        {
            this.getFragments().remove(fragment);
            fragment.parentGui = null;
            for (Actor actor : fragment.getActors())
            {
                actor.remove();
            }
        }
        else
        {
            Logger.log("Attempt to remove nonexistent GuiFragment from Gui.");
        }
    }

    public boolean hasFragment(GuiFragment fragment)
    {
        return this.getFragments().contains(fragment);
    }

    public ArrayList<GuiFragment> getFragments()
    {
        return this.fragments;
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
        for (GuiFragment fragment : getFragments())
        {
            fragment.update();
        }
        getStage().act();
        getStage().draw();
    }
}
