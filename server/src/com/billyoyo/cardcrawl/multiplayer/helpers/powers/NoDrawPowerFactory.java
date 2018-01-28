package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.NoDrawPower;

/**
 * Created by william on 27/01/2018.
 */
public class NoDrawPowerFactory extends AbstractPowerFactory<NoDrawPower> {
    @Override
    public String getPowerId() {
        return NoDrawPower.POWER_ID;
    }

    @Override
    public NoDrawPower create(AbstractPowerDTO dto, CreateData data) {
        return new NoDrawPower(data.getOwner());
    }
}
