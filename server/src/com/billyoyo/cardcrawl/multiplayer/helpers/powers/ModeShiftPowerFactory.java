package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.ModeShiftPower;

/**
 * Created by william on 27/01/2018.
 */
public class ModeShiftPowerFactory extends AbstractPowerFactory<ModeShiftPower> {
    @Override
    public String getPowerId() {
        return ModeShiftPower.POWER_ID;
    }

    @Override
    public ModeShiftPower create(AbstractPowerDTO dto, CreateData data) {
        return new ModeShiftPower(data.getOwner(), dto.getAmount());
    }
}
