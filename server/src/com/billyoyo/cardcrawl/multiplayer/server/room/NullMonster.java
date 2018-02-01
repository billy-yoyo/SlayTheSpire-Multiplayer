package com.billyoyo.cardcrawl.multiplayer.server.room;

import com.megacrit.cardcrawl.monsters.AbstractMonster;

/**
 * Created by william on 01/02/2018.
 */
public class NullMonster extends AbstractMonster {
    public NullMonster() {
        super("Null", "Null", 20, 0.0F, -60.0F, 400.0F, 410.0F, null, -90.0F, 40.0F);
    }

    @Override
    public void takeTurn() {

    }

    @Override
    protected void getMove(int i) {

    }
}
