package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.EnergizedPower;

/**
 * Created by william on 27/01/2018.
 */
public class EnergizedPowerFactory extends AbstractPowerFactory<EnergizedPower> {
    @Override
    public String getPowerId() {
        return EnergizedPower.POWER_ID;
    }

    @Override
    public EnergizedPower create(AbstractPowerDTO dto, CreateData data) {
        return new EnergizedPower(data.getOwner(), dto.getAmount());
    }
}
