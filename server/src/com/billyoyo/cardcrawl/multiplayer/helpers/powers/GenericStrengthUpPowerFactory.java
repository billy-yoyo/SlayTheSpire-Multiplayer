package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.GenericStrengthUpPower;

/**
 * Created by william on 27/01/2018.
 */
public class GenericStrengthUpPowerFactory extends AbstractPowerFactory<GenericStrengthUpPower> {
    @Override
    public String getPowerId() {
        return GenericStrengthUpPower.POWER_ID;
    }

    @Override
    public GenericStrengthUpPower create(AbstractPowerDTO dto, CreateData data) {
        return new GenericStrengthUpPower(data.getOwner(), "Unknown", dto.getAmount());
    }
}
