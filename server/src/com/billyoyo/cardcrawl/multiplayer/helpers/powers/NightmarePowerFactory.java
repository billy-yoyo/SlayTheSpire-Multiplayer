package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.NightmarePower;


/**
 * Created by william on 27/01/2018.
 */
public class NightmarePowerFactory extends AbstractPowerFactory<NightmarePower> {

    @Override
    public String getPowerId() {
        return NightmarePower.POWER_ID;
    }

    @Override
    public NightmarePower create(AbstractPowerDTO dto, CreateData data) {
        return new NightmarePower(data.getOwner(), dto.getAmount(), dto.getCard().create(data));
    }
}
