package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.FrailPower;

/**
 * Created by william on 27/01/2018.
 */
public class FrailPowerFactory extends AbstractPowerFactory<FrailPower> {
    @Override
    public String getPowerId() {
        return FrailPower.POWER_ID;
    }

    @Override
    public FrailPower create(AbstractPowerDTO dto, CreateData data) {
        return new FrailPower(data.getOwner(), dto.getAmount(), false);
    }
}
