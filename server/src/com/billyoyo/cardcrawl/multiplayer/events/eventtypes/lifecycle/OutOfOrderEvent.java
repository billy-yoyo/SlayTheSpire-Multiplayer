package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle;

import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;

/**
 * Created by william on 30/01/2018.
 */
public class OutOfOrderEvent extends BaseClientEvent{

    private int invalidEventId;

    public OutOfOrderEvent(String clientId, int invalidEventId) {
        super(clientId, EventId.OUT_OF_ORDER);
        this.invalidEventId = invalidEventId;
    }

    public OutOfOrderEvent(String clientId, Event event) {
        this(clientId, event.getEventId());
    }

    public OutOfOrderEvent(BaseClientEvent event) {
        this(event.getClientId(), event);
    }

    public int getInvalidEventId() {
        return invalidEventId;
    }
}
