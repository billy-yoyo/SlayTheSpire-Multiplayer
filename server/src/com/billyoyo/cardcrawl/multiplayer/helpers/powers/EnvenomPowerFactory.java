package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.EnvenomPower;

/**
 * Created by william on 27/01/2018.
 */
public class EnvenomPowerFactory extends AbstractPowerFactory<EnvenomPower> {
    @Override
    public String getPowerId() {
        return EnvenomPower.POWER_ID;
    }

    @Override
    public EnvenomPower create(AbstractPowerDTO dto, CreateData data) {
        return new EnvenomPower(data.getOwner(), dto.getAmount());
    }
}
