package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.ExplosivePower;

/**
 * Created by william on 27/01/2018.
 */
public class ExplosivePowerFactory extends AbstractPowerFactory<ExplosivePower> {
    @Override
    public String getPowerId() {
        return ExplosivePower.POWER_ID;
    }

    @Override
    public ExplosivePower create(AbstractPowerDTO dto, CreateData data) {
        return new ExplosivePower(data.getOwner(), dto.getAmount());
    }
}
