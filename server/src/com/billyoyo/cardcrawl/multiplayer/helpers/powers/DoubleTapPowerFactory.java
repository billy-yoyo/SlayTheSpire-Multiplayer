package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.DoubleTapPower;

/**
 * Created by william on 27/01/2018.
 */
public class DoubleTapPowerFactory extends AbstractPowerFactory<DoubleTapPower> {
    @Override
    public String getPowerId() {
        return DoubleTapPower.POWER_ID;
    }

    @Override
    public DoubleTapPower create(AbstractPowerDTO dto, CreateData data) {
        return new DoubleTapPower(data.getOwner(), dto.getAmount());
    }
}
