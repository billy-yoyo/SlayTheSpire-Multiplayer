package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.RepulsePower;

/**
 * Created by william on 28/01/2018.
 */
public class RepulsePowerFactory extends AbstractPowerFactory<RepulsePower> {
    @Override
    public String getPowerId() {
        return RepulsePower.POWER_ID;
    }

    @Override
    public RepulsePower create(AbstractPowerDTO dto, CreateData data) {
        return new RepulsePower(data.getOwner());
    }
}
