package com.billyoyo.cardcrawl.multiplayer.helpers;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.megacrit.cardcrawl.powers.AbstractPower;

/**
 * Created by william on 27/01/2018.
 */
public abstract class AbstractPowerFactory<T extends AbstractPower> {

    public abstract String getPowerId();
    public abstract T create(AbstractPowerDTO dto, CreateData data);

    public void register() {
        PowerLibrary.register(this);
    }
}
