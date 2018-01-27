package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;

/**
 * Created by william on 27/01/2018.
 */
public class ClearPowersEvent extends BaseClientEvent {
    public ClearPowersEvent(String clientId) {
        super(clientId, EventId.CLEAR_POWERS);
    }
}
