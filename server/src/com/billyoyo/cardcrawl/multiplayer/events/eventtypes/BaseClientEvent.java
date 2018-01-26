package com.billyoyo.cardcrawl.multiplayer.events.eventtypes;

import com.billyoyo.cardcrawl.multiplayer.events.Event;

/**
 * Created by william on 26/01/2018.
 */
public abstract class BaseClientEvent implements Event {

    private String clientId;
    private final int eventId;

    public BaseClientEvent(String clientId, EventId eventId) {
        this.clientId = clientId;
        this.eventId = eventId.getId();
    }

    public String getClientId() {
        return clientId;
    }

    public int getEventId() {
        return eventId;
    }
}
