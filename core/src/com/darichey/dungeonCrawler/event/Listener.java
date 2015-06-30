package com.darichey.dungeonCrawler.event;

public interface Listener<T extends Event>
{
    void handle(T event) throws Exception;
}
