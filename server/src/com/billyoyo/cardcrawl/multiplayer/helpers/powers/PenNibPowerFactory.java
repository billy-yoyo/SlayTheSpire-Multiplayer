package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.PenNibPower;

/**
 * Created by william on 27/01/2018.
 */
public class PenNibPowerFactory extends AbstractPowerFactory<PenNibPower> {
    @Override
    public String getPowerId() {
        return PenNibPower.POWER_ID;
    }

    @Override
    public PenNibPower create(AbstractPowerDTO dto, CreateData data) {
        return new PenNibPower(data.getOwner(), dto.getAmount());
    }
}
