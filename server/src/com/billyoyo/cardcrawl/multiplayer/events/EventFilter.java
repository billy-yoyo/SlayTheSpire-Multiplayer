package com.billyoyo.cardcrawl.multiplayer.events;

/**
 * Created by william on 26/01/2018.
 */
public abstract class EventFilter<T extends Event> {

    public abstract Class<T> getEventClass();
    public abstract Event filter(T event);

    public void registerFilter(EventManager manager) {
        manager.registerFilter(getEventClass(), this);
    }
}
