package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.BurstPower;

/**
 * Created by william on 27/01/2018.
 */
public class BurstPowerFactory extends AbstractPowerFactory<BurstPower> {
    @Override
    public String getPowerId() {
        return BurstPower.POWER_ID;
    }

    @Override
    public BurstPower create(AbstractPowerDTO dto, CreateData data) {
        return new BurstPower(data.getOwner(), dto.getAmount());
    }
}
