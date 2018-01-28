package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.RagePower;

/**
 * Created by william on 27/01/2018.
 */
public class RagePowerFactory extends AbstractPowerFactory<RagePower> {
    @Override
    public String getPowerId() {
        return RagePower.POWER_ID;
    }

    @Override
    public RagePower create(AbstractPowerDTO dto, CreateData data) {
        return new RagePower(data.getOwner(), dto.getAmount());
    }
}
