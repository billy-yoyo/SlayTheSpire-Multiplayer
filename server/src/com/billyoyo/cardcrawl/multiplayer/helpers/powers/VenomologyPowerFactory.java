package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.VenomologyPower;

/**
 * Created by william on 28/01/2018.
 */
public class VenomologyPowerFactory extends AbstractPowerFactory<VenomologyPower> {
    @Override
    public String getPowerId() {
        return VenomologyPower.POWER_ID;
    }

    @Override
    public VenomologyPower create(AbstractPowerDTO dto, CreateData data) {
        return new VenomologyPower(data.getOwner(), dto.getAmount());
    }
}
