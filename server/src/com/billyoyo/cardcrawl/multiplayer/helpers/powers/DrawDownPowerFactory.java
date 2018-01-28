package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.DrawDownPower;

/**
 * Created by william on 27/01/2018.
 */
public class DrawDownPowerFactory extends AbstractPowerFactory<DrawDownPower> {
    @Override
    public String getPowerId() {
        return DrawDownPower.POWER_ID;
    }

    @Override
    public DrawDownPower create(AbstractPowerDTO dto, CreateData data) {
        return new DrawDownPower(data.getOwner(), dto.getAmount());
    }
}
