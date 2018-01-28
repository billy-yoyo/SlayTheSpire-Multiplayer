package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.ToolsOfTheTradePower;

/**
 * Created by william on 28/01/2018.
 */
public class ToolsOfTheTradePowerFactory extends AbstractPowerFactory<ToolsOfTheTradePower> {
    @Override
    public String getPowerId() {
        return ToolsOfTheTradePower.POWER_ID;
    }

    @Override
    public ToolsOfTheTradePower create(AbstractPowerDTO dto, CreateData data) {
        return new ToolsOfTheTradePower(data.getOwner(), dto.getAmount());
    }
}
