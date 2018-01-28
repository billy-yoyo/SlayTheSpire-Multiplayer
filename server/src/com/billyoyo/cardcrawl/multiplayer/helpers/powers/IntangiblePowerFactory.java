package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.IntangiblePower;

/**
 * Created by william on 27/01/2018.
 */
public class IntangiblePowerFactory extends AbstractPowerFactory<IntangiblePower> {
    @Override
    public String getPowerId() {
        return IntangiblePower.POWER_ID;
    }

    @Override
    public IntangiblePower create(AbstractPowerDTO dto, CreateData data) {
        return new IntangiblePower(data.getOwner(), dto.getAmount());
    }
}
