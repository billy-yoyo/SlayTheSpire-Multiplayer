package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.EntanglePower;

/**
 * Created by william on 27/01/2018.
 */
public class EntanglePowerFactory extends AbstractPowerFactory<EntanglePower> {
    @Override
    public String getPowerId() {
        return EntanglePower.POWER_ID;
    }

    @Override
    public EntanglePower create(AbstractPowerDTO dto, CreateData data) {
        return new EntanglePower(data.getOwner());
    }
}
