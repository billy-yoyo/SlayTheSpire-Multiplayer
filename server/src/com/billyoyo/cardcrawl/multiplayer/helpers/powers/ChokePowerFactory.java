package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.ChokePower;

/**
 * Created by william on 27/01/2018.
 */
public class ChokePowerFactory extends AbstractPowerFactory<ChokePower> {
    @Override
    public String getPowerId() {
        return ChokePower.POWER_ID;
    }

    @Override
    public ChokePower create(AbstractPowerDTO dto, CreateData data) {
        return new ChokePower(data.getOwner(), dto.getAmount());
    }
}
