package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.GeneratorPower;

/**
 * Created by william on 27/01/2018.
 */
public class GeneratorPowerFactory extends AbstractPowerFactory<GeneratorPower> {
    @Override
    public String getPowerId() {
        return GeneratorPower.POWER_ID;
    }

    @Override
    public GeneratorPower create(AbstractPowerDTO dto, CreateData data) {
        return new GeneratorPower(data.getOwner(), dto.getAmount());
    }
}
