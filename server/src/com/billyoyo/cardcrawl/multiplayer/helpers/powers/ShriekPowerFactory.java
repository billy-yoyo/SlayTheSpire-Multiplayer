package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.ShriekPower;

/**
 * Created by william on 28/01/2018.
 */
public class ShriekPowerFactory extends AbstractPowerFactory<ShriekPower> {
    @Override
    public String getPowerId() {
        return ShriekPower.POWER_ID;
    }

    @Override
    public ShriekPower create(AbstractPowerDTO dto, CreateData data) {
        return new ShriekPower(data.getOwner());
    }
}
