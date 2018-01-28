package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.PanachePower;

/**
 * Created by william on 27/01/2018.
 */
public class PanachePowerFactory extends AbstractPowerFactory<PanachePower> {
    @Override
    public String getPowerId() {
        return PanachePower.POWER_ID;
    }

    @Override
    public PanachePower create(AbstractPowerDTO dto, CreateData data) {
        return new PanachePower(data.getOwner(), dto.getAmount());
    }
}
