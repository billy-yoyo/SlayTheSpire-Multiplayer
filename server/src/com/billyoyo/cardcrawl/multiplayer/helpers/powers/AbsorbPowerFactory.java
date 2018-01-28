package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbsorbPower;

/**
 * Created by william on 27/01/2018.
 */
public class AbsorbPowerFactory extends AbstractPowerFactory<AbsorbPower> {
    @Override
    public String getPowerId() {
        return AbsorbPower.POWER_ID;
    }

    @Override
    public AbsorbPower create(AbstractPowerDTO dto, CreateData data) {
        return new AbsorbPower(data.getOwner(), dto.getAmount());
    }
}
