package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.DrawReductionPower;

/**
 * Created by william on 27/01/2018.
 */
public class DrawReductionPowerFactory extends AbstractPowerFactory<DrawReductionPower> {
    @Override
    public String getPowerId() {
        return DrawReductionPower.POWER_ID;
    }

    @Override
    public DrawReductionPower create(AbstractPowerDTO dto, CreateData data) {
        return new DrawReductionPower(data.getOwner(), dto.getAmount());
    }
}
