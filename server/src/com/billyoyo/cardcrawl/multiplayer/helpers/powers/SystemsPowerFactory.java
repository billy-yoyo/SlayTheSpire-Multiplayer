package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.SystemsPower;

/**
 * Created by william on 28/01/2018.
 */
public class SystemsPowerFactory extends AbstractPowerFactory<SystemsPower> {
    @Override
    public String getPowerId() {
        return SystemsPower.POWER_ID;
    }

    @Override
    public SystemsPower create(AbstractPowerDTO dto, CreateData data) {
        return new SystemsPower(data.getOwner(), dto.getAmount());
    }
}
