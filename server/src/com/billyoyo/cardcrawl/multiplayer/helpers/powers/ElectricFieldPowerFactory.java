package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.ElectricFieldPower;

/**
 * Created by william on 27/01/2018.
 */
public class ElectricFieldPowerFactory extends AbstractPowerFactory<ElectricFieldPower> {
    @Override
    public String getPowerId() {
        return ElectricFieldPower.POWER_ID;
    }

    @Override
    public ElectricFieldPower create(AbstractPowerDTO dto, CreateData data) {
        return new ElectricFieldPower(null, data.getOwner(), dto.getAmount());
    }
}
