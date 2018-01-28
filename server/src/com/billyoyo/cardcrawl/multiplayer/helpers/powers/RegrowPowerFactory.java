package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.RegrowPower;

/**
 * Created by william on 28/01/2018.
 */
public class RegrowPowerFactory extends AbstractPowerFactory<RegrowPower> {
    @Override
    public String getPowerId() {
        return RegrowPower.POWER_ID;
    }

    @Override
    public RegrowPower create(AbstractPowerDTO dto, CreateData data) {
        return new RegrowPower(data.getOwner());
    }
}
