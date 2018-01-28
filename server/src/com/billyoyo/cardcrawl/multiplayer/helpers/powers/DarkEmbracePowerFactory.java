package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.DarkEmbracePower;

/**
 * Created by william on 27/01/2018.
 */
public class DarkEmbracePowerFactory extends AbstractPowerFactory<DarkEmbracePower> {
    @Override
    public String getPowerId() {
        return DarkEmbracePower.POWER_ID;
    }

    @Override
    public DarkEmbracePower create(AbstractPowerDTO dto, CreateData data) {
        return new DarkEmbracePower(data.getOwner(), dto.getAmount());
    }
}
