package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.FlightPower;

/**
 * Created by william on 27/01/2018.
 */
public class FlightPowerFactory extends AbstractPowerFactory<FlightPower> {
    @Override
    public String getPowerId() {
        return FlightPower.POWER_ID;
    }

    @Override
    public FlightPower create(AbstractPowerDTO dto, CreateData data) {
        return new FlightPower(data.getOwner(), dto.getAmount());
    }
}
