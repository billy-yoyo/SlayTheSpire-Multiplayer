package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.RegeneratePower;

/**
 * Created by william on 27/01/2018.
 */
public class RegeneratePowerFactory extends AbstractPowerFactory<RegeneratePower> {
    @Override
    public String getPowerId() {
        return RegeneratePower.POWER_ID;
    }

    @Override
    public RegeneratePower create(AbstractPowerDTO dto, CreateData data) {
        return new RegeneratePower(data.getOwner(), dto.getAmount());
    }
}
