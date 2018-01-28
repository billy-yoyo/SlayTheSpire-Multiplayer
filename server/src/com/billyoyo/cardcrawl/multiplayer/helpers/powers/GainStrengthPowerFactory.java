package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.GainStrengthPower;

/**
 * Created by william on 27/01/2018.
 */
public class GainStrengthPowerFactory extends AbstractPowerFactory<GainStrengthPower> {
    @Override
    public String getPowerId() {
        return GainStrengthPower.POWER_ID;
    }

    @Override
    public GainStrengthPower create(AbstractPowerDTO dto, CreateData data) {
        return new GainStrengthPower(data.getOwner(), dto.getAmount());
    }
}
