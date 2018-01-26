package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;

/**
 * Created by william on 26/01/2018.
 */
public class UpdateEnergyEvent extends BaseClientEvent {

    private int energy;

    public UpdateEnergyEvent(String clientId, int energy) {
        super(clientId, EventId.UPDATE_ENERGY);
        this.energy = energy;
    }

    public int getEnergy() {
        return energy;
    }
}
