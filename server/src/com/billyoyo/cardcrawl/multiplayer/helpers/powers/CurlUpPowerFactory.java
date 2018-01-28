package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.CurlUp;

/**
 * Created by william on 27/01/2018.
 */
public class CurlUpPowerFactory extends AbstractPowerFactory<CurlUp> {
    @Override
    public String getPowerId() {
        return CurlUp.POWER_ID;
    }

    @Override
    public CurlUp create(AbstractPowerDTO dto, CreateData data) {
        return new CurlUp(data.getOwner(), dto.getAmount());
    }
}
