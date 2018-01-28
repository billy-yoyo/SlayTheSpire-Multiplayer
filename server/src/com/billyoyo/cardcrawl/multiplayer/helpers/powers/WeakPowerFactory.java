package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.WeakPower;

/**
 * Created by william on 28/01/2018.
 */
public class WeakPowerFactory extends AbstractPowerFactory<WeakPower> {
    @Override
    public String getPowerId() {
        return WeakPower.POWER_ID;
    }

    @Override
    public WeakPower create(AbstractPowerDTO dto, CreateData data) {
        return new WeakPower(data.getOwner(), dto.getAmount(), false);
    }
}
