package com.billyoyo.cardcrawl.multiplayer.dto;

import com.billyoyo.cardcrawl.multiplayer.helpers.PowerLibrary;
import com.billyoyo.cardcrawl.multiplayer.helpers.powers.CombustPowerFactory;
import com.billyoyo.cardcrawl.multiplayer.helpers.powers.NightmarePowerFactory;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.powers.*;

/**
 * Created by william on 27/01/2018.
 */
public class AbstractPowerDTO implements DTO<AbstractPower> {



    private final String id;
    private final int amount;
    private final int hpLoss;
    private final AbstractCardDTO card;

    public AbstractPowerDTO(String id, int amount, int hpLoss, AbstractCardDTO card) {
        this.id = id;
        this.amount = amount;
        this.hpLoss = hpLoss;
        this.card = null;
    }

    public AbstractPowerDTO(AbstractPower power) {
        int hpLoss = 0;
        if (power instanceof CombustPower) {
            hpLoss = ((CombustPower) power).getHpLoss();
        }
        if (power instanceof RegenerationPower) {
            hpLoss = ((RegenerationPower) power).getHealAmount();
        }

        AbstractCardDTO card = null;
        if (power instanceof NightmarePower) {
            card = new AbstractCardDTO(((NightmarePower) power).getCard());
        }
        if (power instanceof StasisPower) {
            card = new AbstractCardDTO(((StasisPower) power).getCard());
        }

        int amount = power.amount;
        if (power instanceof PanachePower) {
            amount = ((PanachePower) power).getDamage();
        }

        this.id = power.ID;
        this.amount = amount;
        this.hpLoss = hpLoss;
        this.card = card;
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public int getHpLoss() {
        return hpLoss;
    }

    public AbstractCardDTO getCard() {
        return card;
    }

    @Override
    public boolean matches(AbstractPower obj) {
        return obj.ID.equals(id) && obj.amount == amount;
    }

    @Override
    public AbstractPower create(CreateData data) {
        return PowerLibrary.create(this, data);
    }
}
