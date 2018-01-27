package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.megacrit.cardcrawl.powers.AbstractPower;

/**
 * Created by william on 27/01/2018.
 */
public class RemovePowerEvent extends BaseClientEvent {

    private AbstractPower power;

    public RemovePowerEvent(String clientId, AbstractPower power) {
        super(clientId, EventId.REMOVE_POWER);

        this.power = power;
    }

    public AbstractPower getPower() {
        return power;
    }
}
