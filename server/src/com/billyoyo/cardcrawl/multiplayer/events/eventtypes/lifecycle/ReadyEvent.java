package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;

/**
 * Created by william on 29/01/2018.
 */
public class ReadyEvent extends BaseClientEvent {

    public ReadyEvent(String clientId) {
        super(clientId, EventId.READY);
    }

}
