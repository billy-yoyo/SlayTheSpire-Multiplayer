package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.DarknessPower;

/**
 * Created by william on 27/01/2018.
 */
public class DarknessPowerFactory extends AbstractPowerFactory<DarknessPower> {

    @Override
    public String getPowerId() {
        return DarknessPower.POWER_ID;
    }

    @Override
    public DarknessPower create(AbstractPowerDTO dto, CreateData data) {
        return new DarknessPower(dto.getAmount());
    }
}
