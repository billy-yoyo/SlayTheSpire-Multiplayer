package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.SharpHidePower;

/**
 * Created by william on 28/01/2018.
 */
public class SharpHidePowerFactory extends AbstractPowerFactory<SharpHidePower> {
    @Override
    public String getPowerId() {
        return SharpHidePower.POWER_ID;
    }

    @Override
    public SharpHidePower create(AbstractPowerDTO dto, CreateData data) {
        return new SharpHidePower(data.getOwner(), dto.getAmount());
    }
}
