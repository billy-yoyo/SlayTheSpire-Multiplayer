package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.HexPower;

/**
 * Created by william on 27/01/2018.
 */
public class HexPowerFactory extends AbstractPowerFactory<HexPower> {
    @Override
    public String getPowerId() {
        return HexPower.POWER_ID;
    }

    @Override
    public HexPower create(AbstractPowerDTO dto, CreateData data) {
        return new HexPower(data.getOwner(), dto.getAmount());
    }
}
