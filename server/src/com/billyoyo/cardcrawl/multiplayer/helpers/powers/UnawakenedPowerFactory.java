package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.UnawakenedPower;

/**
 * Created by william on 28/01/2018.
 */
public class UnawakenedPowerFactory extends AbstractPowerFactory<UnawakenedPower> {
    @Override
    public String getPowerId() {
        return UnawakenedPower.POWER_ID;
    }

    @Override
    public UnawakenedPower create(AbstractPowerDTO dto, CreateData data) {
        return new UnawakenedPower(data.getOwner());
    }
}
