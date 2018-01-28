package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.ConstrictedPower;

/**
 * Created by william on 27/01/2018.
 */
public class ConstrictedPowerFactory extends AbstractPowerFactory<ConstrictedPower> {
    @Override
    public String getPowerId() {
        return ConstrictedPower.POWER_ID;
    }

    @Override
    public ConstrictedPower create(AbstractPowerDTO dto, CreateData data) {
        return new ConstrictedPower(data.getOwner(), data.getOpponent(), dto.getAmount());
    }
}
