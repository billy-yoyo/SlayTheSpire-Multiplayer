package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.LoseStrengthPower;

/**
 * Created by william on 27/01/2018.
 */
public class LoseStrengthPowerFactory extends AbstractPowerFactory<LoseStrengthPower> {
    @Override
    public String getPowerId() {
        return LoseStrengthPower.POWER_ID;
    }

    @Override
    public LoseStrengthPower create(AbstractPowerDTO dto, CreateData data) {
        return new LoseStrengthPower(data.getOwner(), dto.getAmount());
    }
}
