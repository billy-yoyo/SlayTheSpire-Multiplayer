package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.ArtifactPower;

/**
 * Created by william on 27/01/2018.
 */
public class ArtifactPowerFactory extends AbstractPowerFactory<ArtifactPower> {
    @Override
    public String getPowerId() {
        return ArtifactPower.POWER_ID;
    }

    @Override
    public ArtifactPower create(AbstractPowerDTO dto, CreateData data) {
        return new ArtifactPower(data.getOwner(), dto.getAmount());
    }
}
