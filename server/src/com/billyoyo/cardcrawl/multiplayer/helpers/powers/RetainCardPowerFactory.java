package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.RetainCardPower;

/**
 * Created by william on 28/01/2018.
 */
public class RetainCardPowerFactory extends AbstractPowerFactory<RetainCardPower> {
    @Override
    public String getPowerId() {
        return RetainCardPower.POWER_ID;
    }

    @Override
    public RetainCardPower create(AbstractPowerDTO dto, CreateData data) {
        return new RetainCardPower(data.getOwner(), dto.getAmount());
    }
}
