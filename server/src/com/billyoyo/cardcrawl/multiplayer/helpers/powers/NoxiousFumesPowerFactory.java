package com.billyoyo.cardcrawl.multiplayer.helpers.powers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.helpers.AbstractPowerFactory;
import com.megacrit.cardcrawl.powers.NoxiousFumesPower;

/**
 * Created by william on 27/01/2018.
 */
public class NoxiousFumesPowerFactory extends AbstractPowerFactory<NoxiousFumesPower> {
    @Override
    public String getPowerId() {
        return NoxiousFumesPower.POWER_ID;
    }

    @Override
    public NoxiousFumesPower create(AbstractPowerDTO dto, CreateData data) {
        return new NoxiousFumesPower(data.getOwner(), dto.getAmount());
    }
}
