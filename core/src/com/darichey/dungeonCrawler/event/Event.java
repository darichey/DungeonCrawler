package com.darichey.dungeonCrawler.event;

public abstract class Event
{
    private String name;

    public String getName()
    {
        return this.name == null ? this.getClass().getSimpleName() : this.name;
    }
}
