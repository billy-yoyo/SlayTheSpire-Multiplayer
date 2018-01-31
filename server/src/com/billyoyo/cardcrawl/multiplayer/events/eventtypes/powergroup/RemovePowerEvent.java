package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.megacrit.cardcrawl.powers.AbstractPower;

/**
 * Created by william on 27/01/2018.
 */
public class RemovePowerEvent extends BasePowerEvent {

    private AbstractPower power;

    public RemovePowerEvent(String clientId, boolean ownerIsOpponent, AbstractPower power) {
        super(clientId, ownerIsOpponent, EventId.REMOVE_POWER);

        this.power = power;
    }

    public AbstractPower getPower() {
        return power;
    }
}
