package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.PlatedArmorPower;

/**
 * Created by william on 27/01/2018.
 */
public class PlatedArmorPowerFactory extends AbstractPowerFactory<PlatedArmorPower> {
    @Override
    public String getPowerId() {
        return PlatedArmorPower.POWER_ID;
    }

    @Override
    public PlatedArmorPower create(AbstractPowerDTO dto, CreateData data) {
        return new PlatedArmorPower(data.getOwner(), dto.getAmount());
    }
}
