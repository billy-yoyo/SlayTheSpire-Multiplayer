package com.billyoyo.cardcrawl.multiplayer.client;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

/**
 * Created by william on 28/01/2018.
 */
public class ClientGame {

    private ClientHub hub;

    public ClientGame(ClientHub hub) {
        this.hub = hub;
    }

    public AbstractPlayer getPlayer() {
        return null;
    }

    public AbstractMonster getOpponent() {
        return null;
    }

}
