package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.InfiniteBladesPower;

/**
 * Created by william on 27/01/2018.
 */
public class InfiniteBladesPowerFactory extends AbstractPowerFactory<InfiniteBladesPower> {
    @Override
    public String getPowerId() {
        return InfiniteBladesPower.POWER_ID;
    }

    @Override
    public InfiniteBladesPower create(AbstractPowerDTO dto, CreateData data) {
        return new InfiniteBladesPower(data.getOwner(), dto.getAmount());
    }
}
