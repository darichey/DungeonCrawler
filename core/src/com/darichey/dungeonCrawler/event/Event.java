package com.darichey.dungeonCrawler.event;

public abstract class Event {
    private String name;
    private boolean isCanceled;

    public String getName() {
        return this.name == null ? this.getClass().getSimpleName() : this.name;
    }

    public boolean isCanceled() {
        return this.isCanceled;
    }

    public void setCanceled(boolean canceled) {
        if (this.isCancelable()) this.isCanceled = canceled;
    }

    public boolean isCancelable() {
        return false;
    }
}
