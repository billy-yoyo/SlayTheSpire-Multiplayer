package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.CorruptionPower;

/**
 * Created by william on 27/01/2018.
 */
public class CorruptionPowerFactory extends AbstractPowerFactory<CorruptionPower> {
    @Override
    public String getPowerId() {
        return CorruptionPower.POWER_ID;
    }

    @Override
    public CorruptionPower create(AbstractPowerDTO dto, CreateData data) {
        return new CorruptionPower(data.getOwner());
    }
}
