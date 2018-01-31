package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;

/**
 * Created by william on 31/01/2018.
 */
public abstract class BasePowerEvent extends BaseClientEvent {

    private boolean ownerIsOpponent;

    public BasePowerEvent(String clientId, boolean ownerIsOpponent, EventId eventId) {
        super(clientId, eventId);
        this.ownerIsOpponent = ownerIsOpponent;
    }

    public boolean isOwnerOpponent(){
        return ownerIsOpponent;
    }

}
