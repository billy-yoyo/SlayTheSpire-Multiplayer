package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.DemonFormPower;

/**
 * Created by william on 27/01/2018.
 */
public class DemonFormPowerFactory extends AbstractPowerFactory<DemonFormPower> {
    @Override
    public String getPowerId() {
        return DemonFormPower.POWER_ID;
    }

    @Override
    public DemonFormPower create(AbstractPowerDTO dto, CreateData data) {
        return new DemonFormPower(data.getOwner(), dto.getAmount());
    }
}
