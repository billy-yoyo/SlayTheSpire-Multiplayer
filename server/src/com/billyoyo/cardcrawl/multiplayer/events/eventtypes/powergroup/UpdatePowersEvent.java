package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.List;

/**
 * Created by william on 27/01/2018.
 */
public class UpdatePowersEvent extends BasePowerEvent {

    private List<AbstractPower> powers;

    public UpdatePowersEvent(String clientId, boolean ownerIsOpponent, List<AbstractPower> powers) {
        super(clientId, ownerIsOpponent, EventId.UPDATE_POWERS);
        this.powers = powers;
    }

    public List<AbstractPower> getPowers() {
        return powers;
    }
}
