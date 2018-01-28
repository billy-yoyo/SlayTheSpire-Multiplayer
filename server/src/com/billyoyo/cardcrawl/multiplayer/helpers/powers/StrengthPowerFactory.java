package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.StrengthPower;

/**
 * Created by william on 28/01/2018.
 */
public class StrengthPowerFactory extends AbstractPowerFactory<StrengthPower> {
    @Override
    public String getPowerId() {
        return StrengthPower.POWER_ID;
    }

    @Override
    public StrengthPower create(AbstractPowerDTO dto, CreateData data) {
        return new StrengthPower(data.getOwner(), dto.getAmount());
    }
}
