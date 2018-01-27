package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.List;

/**
 * Created by william on 27/01/2018.
 */
public class UpdatePowersEvent extends BaseClientEvent {

    private List<AbstractPower> powers;

    public UpdatePowersEvent(String clientId, List<AbstractPower> powers) {
        super(clientId, EventId.UPDATE_POWERS);
        this.powers = powers;
    }

    public List<AbstractPower> getPowers() {
        return powers;
    }
}
