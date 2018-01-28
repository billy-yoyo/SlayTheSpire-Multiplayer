package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.ConfusionPower;

/**
 * Created by william on 27/01/2018.
 */
public class ConfusionPowerFactory extends AbstractPowerFactory<ConfusionPower> {
    @Override
    public String getPowerId() {
        return ConfusionPower.POWER_ID;
    }

    @Override
    public ConfusionPower create(AbstractPowerDTO dto, CreateData data) {
        return new ConfusionPower(data.getOwner());
    }
}
