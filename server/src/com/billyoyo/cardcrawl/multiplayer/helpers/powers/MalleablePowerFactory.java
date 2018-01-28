package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.MalleablePower;

/**
 * Created by william on 27/01/2018.
 */
public class MalleablePowerFactory extends AbstractPowerFactory<MalleablePower> {
    @Override
    public String getPowerId() {
        return MalleablePower.POWER_ID;
    }

    @Override
    public MalleablePower create(AbstractPowerDTO dto, CreateData data) {
        return new MalleablePower(data.getOwner());
    }
}
