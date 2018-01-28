package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.FeelNoPainPower;

/**
 * Created by william on 27/01/2018.
 */
public class FeelNoPainPowerFactory extends AbstractPowerFactory<FeelNoPainPower> {
    @Override
    public String getPowerId() {
        return FeelNoPainPower.POWER_ID;
    }

    @Override
    public FeelNoPainPower create(AbstractPowerDTO dto, CreateData data) {
        return new FeelNoPainPower(data.getOwner(), dto.getAmount());
    }
}
