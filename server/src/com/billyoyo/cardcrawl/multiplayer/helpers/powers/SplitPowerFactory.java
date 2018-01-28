package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.SplitPower;

/**
 * Created by william on 28/01/2018.
 */
public class SplitPowerFactory extends AbstractPowerFactory<SplitPower> {
    @Override
    public String getPowerId() {
        return SplitPower.POWER_ID;
    }

    @Override
    public SplitPower create(AbstractPowerDTO dto, CreateData data) {
        return new SplitPower(data.getOwner());
    }
}
