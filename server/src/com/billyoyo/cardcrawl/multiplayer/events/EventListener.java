package com.billyoyo.cardcrawl.multiplayer.events;

/**
 * Created by william on 28/01/2018.
 */
public interface EventListener {

    // if notify returns false, an 'invalid' event will be sent back to the
    // source of the event
    public boolean notify(Event event);

}
