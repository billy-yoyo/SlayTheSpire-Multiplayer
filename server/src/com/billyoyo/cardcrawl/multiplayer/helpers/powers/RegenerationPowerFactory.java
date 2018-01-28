package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.RegenerationPower;

/**
 * Created by william on 28/01/2018.
 */
public class RegenerationPowerFactory extends AbstractPowerFactory<RegenerationPower> {
    @Override
    public String getPowerId() {
        return RegenerationPower.POWER_ID;
    }

    @Override
    public RegenerationPower create(AbstractPowerDTO dto, CreateData data) {
        return new RegenerationPower(data.getOwner(), dto.getAmount(), dto.getHpLoss());
    }
}
