package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.VulnerablePower;

/**
 * Created by william on 28/01/2018.
 */
public class VulnerablePowerFactory extends AbstractPowerFactory<VulnerablePower> {
    @Override
    public String getPowerId() {
        return VulnerablePower.POWER_ID;
    }

    @Override
    public VulnerablePower create(AbstractPowerDTO dto, CreateData data) {
        return new VulnerablePower(data.getOwner(), dto.getAmount(), false);
    }
}
