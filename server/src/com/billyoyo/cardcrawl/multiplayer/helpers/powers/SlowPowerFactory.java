package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.SlowPower;

/**
 * Created by william on 28/01/2018.
 */
public class SlowPowerFactory extends AbstractPowerFactory<SlowPower> {
    @Override
    public String getPowerId() {
        return SlowPower.POWER_ID;
    }

    @Override
    public SlowPower create(AbstractPowerDTO dto, CreateData data) {
        return new SlowPower(data.getOwner(), dto.getAmount());
    }
}
