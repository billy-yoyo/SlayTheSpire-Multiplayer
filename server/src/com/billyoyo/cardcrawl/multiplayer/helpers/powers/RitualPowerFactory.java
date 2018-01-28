package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.RitualPower;

/**
 * Created by william on 28/01/2018.
 */
public class RitualPowerFactory extends AbstractPowerFactory<RitualPower> {
    @Override
    public String getPowerId() {
        return RitualPower.POWER_ID;
    }

    @Override
    public RitualPower create(AbstractPowerDTO dto, CreateData data) {
        return new RitualPower(data.getOwner(), dto.getAmount());
    }
}
