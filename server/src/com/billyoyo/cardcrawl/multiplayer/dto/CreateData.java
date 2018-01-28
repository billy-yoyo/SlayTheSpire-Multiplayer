package com.billyoyo.cardcrawl.multiplayer.dto;

import com.megacrit.cardcrawl.core.AbstractCreature;

/**
 * Created by william on 27/01/2018.
 */
public class CreateData {

    private AbstractCreature owner;
    private AbstractCreature opponent;

    public CreateData() {
    }

    public CreateData(AbstractCreature owner) {
        this.owner = owner;
    }

    public CreateData(AbstractCreature owner, AbstractCreature opponent) {
        this.owner = owner;
        this.opponent = opponent;
    }

    public void setOwner(AbstractCreature owner) {
        this.owner = owner;
    }

    public AbstractCreature getOwner() {
        return this.owner;
    }

    public void setOpponent(AbstractCreature opponent) {
        this.opponent = opponent;
    }

    public AbstractCreature getOpponent() {
        return this.opponent;
    }
}
