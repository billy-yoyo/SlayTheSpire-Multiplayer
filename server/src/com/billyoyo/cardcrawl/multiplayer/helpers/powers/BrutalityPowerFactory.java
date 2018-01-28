package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.BrutalityPower;

/**
 * Created by william on 27/01/2018.
 */
public class BrutalityPowerFactory extends AbstractPowerFactory<BrutalityPower> {
    @Override
    public String getPowerId() {
        return BrutalityPower.POWER_ID;
    }

    @Override
    public BrutalityPower create(AbstractPowerDTO dto, CreateData data) {
        return new BrutalityPower(data.getOwner(), dto.getAmount());
    }
}
