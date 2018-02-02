package com.billyoyo.cardcrawl.multiplayer.client.game;

import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

/**
 * Created by william on 31/01/2018.
 */
public class Opponent extends AbstractMonster {

    // eventually I'd like to update this to fetch the opponent's name from the server
    // but this is good enough for now
    private static final String monsterName = "Opponent Monster";

    // this doesn't matter much as it will be updated by the server anyway
    private static final int monsterMaxHealth = 60;

    public static final String monsterId = "Opponent";

    public Opponent() {
        // values copied from "Champ" as that's what we're using as a placeholder image for the opponent
        super(monsterName, monsterId, monsterMaxHealth, 0.0F, -60.0F, 400.0F, 410.0F, null, -90.0F, 40.0F);
        this.type = EnemyType.BOSS;
        this.dialogX = -100.0F * Settings.scale;
        this.dialogY = 10.0F * Settings.scale;
        this.loadAnimation("images/monsters/theCity/champ/skeleton.atlas", "images/monsters/theCity/champ/skeleton.json", 1.0F);
        this.setMove((byte) -1, Intent.UNKNOWN);
        this.isDying = false;
        this.isEscaping = false;
    }

    @Override
    public void takeTurn() {

    }

    @Override
    protected void getMove(int i) {

    }

    @Override
    public void update() {

    }

}
