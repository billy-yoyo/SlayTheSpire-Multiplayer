package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.DancePower;

/**
 * Created by william on 27/01/2018.
 */
public class DancePowerFactory extends AbstractPowerFactory<DancePower> {
    @Override
    public String getPowerId() {
        return DancePower.POWER_ID;
    }

    @Override
    public DancePower create(AbstractPowerDTO dto, CreateData data) {
        return new DancePower(data.getOwner(), dto.getAmount());
    }
}
