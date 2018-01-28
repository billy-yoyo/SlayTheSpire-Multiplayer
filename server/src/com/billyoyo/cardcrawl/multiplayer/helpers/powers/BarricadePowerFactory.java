package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.BarricadePower;

/**
 * Created by william on 27/01/2018.
 */
public class BarricadePowerFactory extends AbstractPowerFactory<BarricadePower> {
    @Override
    public String getPowerId() {
        return BarricadePower.POWER_ID;
    }

    @Override
    public BarricadePower create(AbstractPowerDTO dto, CreateData data) {
        return new BarricadePower(data.getOwner());
    }
}
