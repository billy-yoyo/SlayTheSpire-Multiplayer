package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.WraithFormPower;

/**
 * Created by william on 28/01/2018.
 */
public class WraithFormPowerFactory extends AbstractPowerFactory<WraithFormPower> {
    @Override
    public String getPowerId() {
        return WraithFormPower.POWER_ID;
    }

    @Override
    public WraithFormPower create(AbstractPowerDTO dto, CreateData data) {
        return new WraithFormPower(data.getOwner(), dto.getAmount());
    }
}
