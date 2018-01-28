package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.FireBreathingPower;

/**
 * Created by william on 27/01/2018.
 */
public class FireBreathingPowerFactory extends AbstractPowerFactory<FireBreathingPower> {
    @Override
    public String getPowerId() {
        return FireBreathingPower.POWER_ID;
    }

    @Override
    public FireBreathingPower create(AbstractPowerDTO dto, CreateData data) {
        return new FireBreathingPower(data.getOwner(), dto.getAmount());
    }
}
