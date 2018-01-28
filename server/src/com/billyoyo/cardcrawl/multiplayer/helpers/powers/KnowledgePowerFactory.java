package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.KnowledgePower;

/**
 * Created by william on 27/01/2018.
 */
public class KnowledgePowerFactory extends AbstractPowerFactory<KnowledgePower> {
    @Override
    public String getPowerId() {
        return KnowledgePower.POWER_ID;
    }

    @Override
    public KnowledgePower create(AbstractPowerDTO dto, CreateData data) {
        return new KnowledgePower(data.getOwner(), dto.getAmount());
    }
}
