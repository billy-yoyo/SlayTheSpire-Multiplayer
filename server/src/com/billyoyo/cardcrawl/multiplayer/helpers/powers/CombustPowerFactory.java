package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.CombustPower;

/**
 * Created by william on 27/01/2018.
 */
public class CombustPowerFactory extends AbstractPowerFactory<CombustPower> {

    @Override
    public String getPowerId() {
        return CombustPower.POWER_ID;
    }

    @Override
    public CombustPower create(AbstractPowerDTO dto, CreateData data) {
        return new CombustPower(data.getOwner(), dto.getHpLoss(), dto.getAmount());
    }
}
