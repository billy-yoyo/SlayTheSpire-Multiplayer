package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.PhantasmalPower;

/**
 * Created by william on 27/01/2018.
 */
public class PhantasmalPowerFactory extends AbstractPowerFactory<PhantasmalPower> {
    @Override
    public String getPowerId() {
        return PhantasmalPower.POWER_ID;
    }

    @Override
    public PhantasmalPower create(AbstractPowerDTO dto, CreateData data) {
        return new PhantasmalPower(data.getOwner(), dto.getAmount());
    }
}
