package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.ThousandCutsPower;

/**
 * Created by william on 28/01/2018.
 */
public class ThousandCutsPowerFactory extends AbstractPowerFactory<ThousandCutsPower> {
    @Override
    public String getPowerId() {
        return ThousandCutsPower.POWER_ID;
    }

    @Override
    public ThousandCutsPower create(AbstractPowerDTO dto, CreateData data) {
        return new ThousandCutsPower(data.getOwner(), dto.getAmount());
    }
}
