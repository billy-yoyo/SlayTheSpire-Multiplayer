package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.ReduceDamagePower;

/**
 * Created by william on 27/01/2018.
 */
public class ReduceDamagePowerFactory extends AbstractPowerFactory<ReduceDamagePower> {
    @Override
    public String getPowerId() {
        return ReduceDamagePower.POWER_ID;
    }

    @Override
    public ReduceDamagePower create(AbstractPowerDTO dto, CreateData data) {
        return new ReduceDamagePower(data.getOwner(), dto.getAmount());
    }
}
