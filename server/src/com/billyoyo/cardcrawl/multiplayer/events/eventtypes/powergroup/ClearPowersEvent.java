package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;

/**
 * Created by william on 27/01/2018.
 */
public class ClearPowersEvent extends BasePowerEvent {
    public ClearPowersEvent(String clientId, boolean ownerIsOpponent) {
        super(clientId, ownerIsOpponent, EventId.CLEAR_POWERS);
    }
}
