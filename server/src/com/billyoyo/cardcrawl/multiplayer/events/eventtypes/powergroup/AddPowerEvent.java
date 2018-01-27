package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.megacrit.cardcrawl.powers.AbstractPower;

/**
 * Created by william on 27/01/2018.
 */
public class AddPowerEvent extends BaseClientEvent {

    private AbstractPower power;

    public AddPowerEvent(String clientId, AbstractPower power) {
        super(clientId, EventId.ADD_POWER);
    }

    public AbstractPower getPower() {
        return power;
    }
}
