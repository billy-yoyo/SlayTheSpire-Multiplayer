package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.JuggernautPower;

/**
 * Created by william on 27/01/2018.
 */
public class JuggernautPowerFactory extends AbstractPowerFactory<JuggernautPower> {
    @Override
    public String getPowerId() {
        return JuggernautPower.POWER_ID;
    }

    @Override
    public JuggernautPower create(AbstractPowerDTO dto, CreateData data) {
        return new JuggernautPower(data.getOwner(), dto.getAmount());
    }
}
