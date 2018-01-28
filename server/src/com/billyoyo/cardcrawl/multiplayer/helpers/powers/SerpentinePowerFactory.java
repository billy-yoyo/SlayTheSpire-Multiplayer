package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.SerpentinePower;

/**
 * Created by william on 28/01/2018.
 */
public class SerpentinePowerFactory extends AbstractPowerFactory<SerpentinePower> {
    @Override
    public String getPowerId() {
        return SerpentinePower.POWER_ID;
    }

    @Override
    public SerpentinePower create(AbstractPowerDTO dto, CreateData data) {
        return new SerpentinePower(data.getOwner());
    }
}
