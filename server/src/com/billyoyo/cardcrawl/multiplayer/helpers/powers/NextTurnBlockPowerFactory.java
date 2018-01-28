package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;

/**
 * Created by william on 27/01/2018.
 */
public class NextTurnBlockPowerFactory extends AbstractPowerFactory<NextTurnBlockPower> {
    @Override
    public String getPowerId() {
        return NextTurnBlockPower.POWER_ID;
    }

    @Override
    public NextTurnBlockPower create(AbstractPowerDTO dto, CreateData data) {
        return new NextTurnBlockPower(data.getOwner(), dto.getAmount(), "Unknown");
    }
}
