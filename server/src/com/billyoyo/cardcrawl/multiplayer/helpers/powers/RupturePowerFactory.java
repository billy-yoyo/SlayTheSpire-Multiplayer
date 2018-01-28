package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.RupturePower;

/**
 * Created by william on 28/01/2018.
 */
public class RupturePowerFactory extends AbstractPowerFactory<RupturePower> {
    @Override
    public String getPowerId() {
        return RupturePower.POWER_ID;
    }

    @Override
    public RupturePower create(AbstractPowerDTO dto, CreateData data) {
        return new RupturePower(data.getOwner(), dto.getAmount());
    }
}
