package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.FlameBarrierPower;

/**
 * Created by william on 27/01/2018.
 */
public class FlameBarrierPowerFactory extends AbstractPowerFactory<FlameBarrierPower> {
    @Override
    public String getPowerId() {
        return FlameBarrierPower.POWER_ID;
    }

    @Override
    public FlameBarrierPower create(AbstractPowerDTO dto, CreateData data) {
        return new FlameBarrierPower(data.getOwner(), dto.getAmount());
    }
}
