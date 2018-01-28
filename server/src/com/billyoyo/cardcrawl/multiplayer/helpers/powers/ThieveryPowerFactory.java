package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.ThieveryPower;

/**
 * Created by william on 28/01/2018.
 */
public class ThieveryPowerFactory extends AbstractPowerFactory<ThieveryPower> {
    @Override
    public String getPowerId() {
        return ThieveryPower.POWER_ID;
    }

    @Override
    public ThieveryPower create(AbstractPowerDTO dto, CreateData data) {
        return new ThieveryPower(data.getOwner(), dto.getAmount());
    }
}
