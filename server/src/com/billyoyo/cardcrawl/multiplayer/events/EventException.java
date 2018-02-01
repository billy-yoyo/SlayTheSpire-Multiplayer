package com.billyoyo.cardcrawl.multiplayer.events;

/**
 * Created by william on 28/01/2018.
 */
public class EventException extends RuntimeException {

    public EventException(String message) {
        super(message);
    }

    public EventException(String message, Exception cause) {
        super(message, cause);
    }

}
