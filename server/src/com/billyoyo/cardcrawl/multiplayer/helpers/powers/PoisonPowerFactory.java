package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.PoisonPower;

/**
 * Created by william on 27/01/2018.
 */
public class PoisonPowerFactory extends AbstractPowerFactory<PoisonPower> {
    @Override
    public String getPowerId() {
        return PoisonPower.POWER_ID;
    }

    @Override
    public PoisonPower create(AbstractPowerDTO dto, CreateData data) {
        return new PoisonPower(data.getOwner(), data.getOpponent(), dto.getAmount());
    }
}
