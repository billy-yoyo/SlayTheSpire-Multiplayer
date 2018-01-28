package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AccuracyPower;

/**
 * Created by william on 27/01/2018.
 */
public class AccuracyPowerFactory extends AbstractPowerFactory<AccuracyPower> {
    @Override
    public String getPowerId() {
        return AccuracyPower.POWER_ID;
    }

    @Override
    public AccuracyPower create(AbstractPowerDTO dto, CreateData data) {
        return new AccuracyPower(data.getOwner(), dto.getAmount());
    }
}
