package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.ImpulsePower;

/**
 * Created by william on 27/01/2018.
 */
public class ImpulsePowerFactory extends AbstractPowerFactory<ImpulsePower> {
    @Override
    public String getPowerId() {
        return ImpulsePower.POWER_ID;
    }

    @Override
    public ImpulsePower create(AbstractPowerDTO dto, CreateData data) {
        return new ImpulsePower(data.getOwner(), dto.getAmount());
    }
}
