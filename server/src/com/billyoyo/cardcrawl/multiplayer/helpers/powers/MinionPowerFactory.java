package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.MinionPower;

/**
 * Created by william on 27/01/2018.
 */
public class MinionPowerFactory extends AbstractPowerFactory<MinionPower> {
    @Override
    public String getPowerId() {
        return MinionPower.POWER_ID;
    }

    @Override
    public MinionPower create(AbstractPowerDTO dto, CreateData data) {
        return new MinionPower(data.getOwner());
    }
}
