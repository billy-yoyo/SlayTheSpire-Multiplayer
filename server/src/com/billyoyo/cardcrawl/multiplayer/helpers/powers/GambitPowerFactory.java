package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.GambitPower;

/**
 * Created by william on 27/01/2018.
 */
public class GambitPowerFactory extends AbstractPowerFactory<GambitPower> {
    @Override
    public String getPowerId() {
        return GambitPower.POWER_ID;
    }

    @Override
    public GambitPower create(AbstractPowerDTO dto, CreateData data) {
        return new GambitPower(data.getOwner(), dto.getAmount());
    }
}
