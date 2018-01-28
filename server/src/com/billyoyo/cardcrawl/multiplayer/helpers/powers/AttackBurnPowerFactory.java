package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AttackBurnPower;

/**
 * Created by william on 27/01/2018.
 */
public class AttackBurnPowerFactory extends AbstractPowerFactory<AttackBurnPower> {
    @Override
    public String getPowerId() {
        return AttackBurnPower.POWER_ID;
    }

    @Override
    public AttackBurnPower create(AbstractPowerDTO dto, CreateData data) {
        return new AttackBurnPower(data.getOwner(), dto.getAmount());
    }
}
