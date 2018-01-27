package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;

/**
 * Created by william on 27/01/2018.
 */
public class StartTurnEvent extends BaseClientEvent {

    public StartTurnEvent(String clientId) {
        super(clientId, EventId.START_TURN);
    }

}
