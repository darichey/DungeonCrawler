package com.darichey.dungeonCrawler.event;

import java.lang.reflect.Method;
import java.util.ArrayList;

public final class EventManager
{
    static ArrayList<Listener> listeners = new ArrayList<Listener>();

    public static void register(Listener listener)
    {
        if (!listeners.contains(listener))
        {
            listeners.add(listener);
        }
    }

    public static void unregister(Listener listener)
    {
        if (listeners.contains(listener))
        {
            listeners.remove(listener);
        }
    }

    public static void post(Event event)
    {
        for (Listener listener : listeners)
        {
            Method[] methods = listener.getClass().getMethods();
            for (Method method : methods)
            {
                if (method.isAnnotationPresent(Subscribe.class))
                {
                    try
                    {
                        method.invoke(listener.getClass(), event);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
