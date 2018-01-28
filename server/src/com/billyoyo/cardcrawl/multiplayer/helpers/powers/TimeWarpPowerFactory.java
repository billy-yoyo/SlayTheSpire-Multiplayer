package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.TimeWarpPower;

/**
 * Created by william on 28/01/2018.
 */
public class TimeWarpPowerFactory extends AbstractPowerFactory<TimeWarpPower> {
    @Override
    public String getPowerId() {
        return TimeWarpPower.POWER_ID;
    }

    @Override
    public TimeWarpPower create(AbstractPowerDTO dto, CreateData data) {
        return new TimeWarpPower(data.getOwner());
    }
}
