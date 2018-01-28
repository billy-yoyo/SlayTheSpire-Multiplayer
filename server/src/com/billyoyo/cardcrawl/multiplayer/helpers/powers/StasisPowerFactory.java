package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.StasisPower;

/**
 * Created by william on 28/01/2018.
 */
public class StasisPowerFactory extends AbstractPowerFactory<StasisPower> {
    @Override
    public String getPowerId() {
        return StasisPower.POWER_ID;
    }

    @Override
    public StasisPower create(AbstractPowerDTO dto, CreateData data) {
        return new StasisPower(data.getOwner(), dto.getCard().create(data));
    }
}
