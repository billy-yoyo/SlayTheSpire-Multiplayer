package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.megacrit.cardcrawl.powers.AbstractPower;

/**
 * Created by william on 27/01/2018.
 */
public class AddPowerEvent extends BasePowerEvent {

    private AbstractPower power;

    public AddPowerEvent(String clientId, boolean ownerIsOpponent, AbstractPower power) {
        super(clientId, ownerIsOpponent, EventId.ADD_POWER);
    }

    public AbstractPower getPower() {
        return power;
    }
}
