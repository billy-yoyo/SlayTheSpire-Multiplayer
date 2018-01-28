package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.DexterityPower;

/**
 * Created by william on 27/01/2018.
 */
public class DexterityPowerFactory extends AbstractPowerFactory<DexterityPower> {

    @Override
    public String getPowerId() {
        return DexterityPower.POWER_ID;
    }

    @Override
    public DexterityPower create(AbstractPowerDTO dto, CreateData data) {
        return new DexterityPower(data.getOwner(), dto.getAmount());
    }
}
