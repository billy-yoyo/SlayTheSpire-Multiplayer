package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.SporeCloudPower;

/**
 * Created by william on 28/01/2018.
 */
public class SporeCloudPowerFactory extends AbstractPowerFactory<SporeCloudPower> {
    @Override
    public String getPowerId() {
        return SporeCloudPower.POWER_ID;
    }

    @Override
    public SporeCloudPower create(AbstractPowerDTO dto, CreateData data) {
        return new SporeCloudPower(data.getOwner(), dto.getAmount());
    }
}
