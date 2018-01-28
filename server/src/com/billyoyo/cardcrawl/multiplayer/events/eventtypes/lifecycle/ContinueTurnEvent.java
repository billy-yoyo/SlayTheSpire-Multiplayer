package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;

/**
 * Created by william on 28/01/2018.
 */
public class ContinueTurnEvent extends BaseClientEvent{
    public ContinueTurnEvent(String clientId) {
        super(clientId, EventId.CONTINUE_TURN);
    }
}
