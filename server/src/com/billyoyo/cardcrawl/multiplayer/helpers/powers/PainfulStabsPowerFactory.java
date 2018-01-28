package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.PainfulStabsPower;

/**
 * Created by william on 27/01/2018.
 */
public class PainfulStabsPowerFactory extends AbstractPowerFactory<PainfulStabsPower> {
    @Override
    public String getPowerId() {
        return PainfulStabsPower.POWER_ID;
    }

    @Override
    public PainfulStabsPower create(AbstractPowerDTO dto, CreateData data) {
        return new PainfulStabsPower(data.getOwner());
    }
}
