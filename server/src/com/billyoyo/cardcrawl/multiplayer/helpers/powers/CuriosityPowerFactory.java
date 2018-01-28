package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.CuriosityPower;

/**
 * Created by william on 27/01/2018.
 */
public class CuriosityPowerFactory extends AbstractPowerFactory<CuriosityPower> {
    @Override
    public String getPowerId() {
        return CuriosityPower.POWER_ID;
    }

    @Override
    public CuriosityPower create(AbstractPowerDTO dto, CreateData data) {
        return new CuriosityPower(data.getOwner(), dto.getAmount());
    }
}
