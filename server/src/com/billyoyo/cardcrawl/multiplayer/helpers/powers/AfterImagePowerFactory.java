package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AfterImagePower;

/**
 * Created by william on 27/01/2018.
 */
public class AfterImagePowerFactory extends AbstractPowerFactory<AfterImagePower> {
    @Override
    public String getPowerId() {
        return AfterImagePower.POWER_ID;
    }

    @Override
    public AfterImagePower create(AbstractPowerDTO dto, CreateData data) {
        return new AfterImagePower(data.getOwner(), dto.getAmount());
    }
}
