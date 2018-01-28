package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AngerPower;

/**
 * Created by william on 27/01/2018.
 */
public class AngerPowerFactory extends AbstractPowerFactory<AngerPower> {
    @Override
    public String getPowerId() {
        return AngerPower.POWER_ID;
    }

    @Override
    public AngerPower create(AbstractPowerDTO dto, CreateData data) {
        return new AngerPower(data.getOwner(), dto.getAmount());
    }
}
