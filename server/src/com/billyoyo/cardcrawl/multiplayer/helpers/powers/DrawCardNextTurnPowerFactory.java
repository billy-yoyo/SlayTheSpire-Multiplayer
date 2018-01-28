package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.DrawCardNextTurnPower;

/**
 * Created by william on 27/01/2018.
 */
public class DrawCardNextTurnPowerFactory extends AbstractPowerFactory<DrawCardNextTurnPower> {
    @Override
    public String getPowerId() {
        return DrawCardNextTurnPower.POWER_ID;
    }

    @Override
    public DrawCardNextTurnPower create(AbstractPowerDTO dto, CreateData data) {
        return new DrawCardNextTurnPower(data.getOwner(), dto.getAmount());
    }
}
