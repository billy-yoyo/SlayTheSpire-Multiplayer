package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.ForcefieldPower;

/**
 * Created by william on 27/01/2018.
 */
public class ForcefieldPowerFactory extends AbstractPowerFactory<ForcefieldPower> {
    @Override
    public String getPowerId() {
        return ForcefieldPower.POWER_ID;
    }

    @Override
    public ForcefieldPower create(AbstractPowerDTO dto, CreateData data) {
        return new ForcefieldPower(data.getOwner());
    }
}
