package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.DrawPower;

/**
 * Created by william on 27/01/2018.
 */
public class DrawPowerFactory extends AbstractPowerFactory<DrawPower> {
    @Override
    public String getPowerId() {
        return DrawPower.POWER_ID;
    }

    @Override
    public DrawPower create(AbstractPowerDTO dto, CreateData data) {
        return new DrawPower(data.getOwner(), dto.getAmount());
    }
}
