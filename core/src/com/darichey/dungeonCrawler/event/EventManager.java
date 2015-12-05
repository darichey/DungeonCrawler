package com.darichey.dungeonCrawler.event;

import java.lang.reflect.Method;
import java.util.ArrayList;

public final class EventManager {
    static ArrayList<Listener> listeners = new ArrayList<Listener>();

    public static void register(Listener listener) {
        if (!listeners.contains(listener)) {
            listeners.add(listener);
        }
    }

    public static void unregister(Listener listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    /**
     * @param event The event to post
     * @return If the event was canceled
     */
    public static boolean post(Event event) {
        for (Listener listener : listeners) {
            Method[] methods = listener.getClass().getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Subscribe.class)) {
                    try {
                        method.invoke(listener.getClass().newInstance(), event);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return event.isCancelable() && event.isCanceled();
    }
}
