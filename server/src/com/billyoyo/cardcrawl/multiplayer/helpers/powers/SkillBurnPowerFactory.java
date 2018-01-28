package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.SkillBurnPower;

/**
 * Created by william on 28/01/2018.
 */
public class SkillBurnPowerFactory extends AbstractPowerFactory<SkillBurnPower> {
    @Override
    public String getPowerId() {
        return SkillBurnPower.POWER_ID;
    }

    @Override
    public SkillBurnPower create(AbstractPowerDTO dto, CreateData data) {
        return new SkillBurnPower(data.getOwner(), dto.getAmount());
    }
}
