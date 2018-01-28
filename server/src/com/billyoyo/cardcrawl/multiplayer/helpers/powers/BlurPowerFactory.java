package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.BlurPower;

/**
 * Created by william on 27/01/2018.
 */
public class BlurPowerFactory extends AbstractPowerFactory<BlurPower> {
    @Override
    public String getPowerId() {
        return BlurPower.POWER_ID;
    }

    @Override
    public BlurPower create(AbstractPowerDTO dto, CreateData data) {
        return new BlurPower(data.getOwner(), dto.getAmount());
    }
}
