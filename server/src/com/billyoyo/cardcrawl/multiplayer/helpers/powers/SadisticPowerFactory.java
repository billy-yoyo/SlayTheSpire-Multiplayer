package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.SadisticPower;

/**
 * Created by william on 28/01/2018.
 */
public class SadisticPowerFactory extends AbstractPowerFactory<SadisticPower> {
    @Override
    public String getPowerId() {
        return SadisticPower.POWER_ID;
    }

    @Override
    public SadisticPower create(AbstractPowerDTO dto, CreateData data) {
        return new SadisticPower(data.getOwner(), dto.getAmount());
    }
}
