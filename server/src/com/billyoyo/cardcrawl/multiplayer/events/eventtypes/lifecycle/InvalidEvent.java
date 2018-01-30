package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle;

import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;

/**
 * Created by william on 30/01/2018.
 */
public class InvalidEvent extends BaseClientEvent {

    private int invalidEventId;

    public InvalidEvent(String clientId, int invalidEventId) {
        super(clientId, EventId.INVALID);
        this.invalidEventId = invalidEventId;
    }

    public InvalidEvent(String clientId, Event event) {
        this(clientId, event.getEventId());
    }

    public InvalidEvent(BaseClientEvent event) {
        this(event.getClientId(), event);
    }

    public int getInvalidEventId() {
        return invalidEventId;
    }

}
