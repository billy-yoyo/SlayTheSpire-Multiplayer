package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.DoubleDamagePower;

/**
 * Created by william on 27/01/2018.
 */
public class DoubleDamagePowerFactory extends AbstractPowerFactory<DoubleDamagePower> {
    @Override
    public String getPowerId() {
        return DoubleDamagePower.POWER_ID;
    }

    @Override
    public DoubleDamagePower create(AbstractPowerDTO dto, CreateData data) {
        return new DoubleDamagePower(data.getOwner(), dto.getAmount(), false);
    }
}
