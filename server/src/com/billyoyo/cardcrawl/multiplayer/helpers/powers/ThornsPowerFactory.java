package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.ThornsPower;

/**
 * Created by william on 28/01/2018.
 */
public class ThornsPowerFactory extends AbstractPowerFactory<ThornsPower> {
    @Override
    public String getPowerId() {
        return ThornsPower.POWER_ID;
    }

    @Override
    public ThornsPower create(AbstractPowerDTO dto, CreateData data) {
        return new ThornsPower(data.getOwner(), dto.getAmount());
    }
}
