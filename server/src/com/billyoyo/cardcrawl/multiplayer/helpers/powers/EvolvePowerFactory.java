package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.EvolvePower;

/**
 * Created by william on 27/01/2018.
 */
public class EvolvePowerFactory extends AbstractPowerFactory<EvolvePower> {
    @Override
    public String getPowerId() {
        return EvolvePower.POWER_ID;
    }

    @Override
    public EvolvePower create(AbstractPowerDTO dto, CreateData data) {
        return new EvolvePower(data.getOwner(), dto.getAmount());
    }
}
