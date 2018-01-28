package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.MetallicizePower;

/**
 * Created by william on 27/01/2018.
 */
public class MetallicizePowerFactory extends AbstractPowerFactory<MetallicizePower> {
    @Override
    public String getPowerId() {
        return MetallicizePower.POWER_ID;
    }

    @Override
    public MetallicizePower create(AbstractPowerDTO dto, CreateData data) {
        return new MetallicizePower(data.getOwner(), dto.getAmount());
    }
}
