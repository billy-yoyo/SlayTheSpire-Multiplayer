package com.billyoyo.cardcrawl.multiplayer.client;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

/**
 * Created by william on 28/01/2018.
 */
public class ClientGame {

    private ClientHub hub;
    private ServerInfo server;

    public ClientGame(ClientHub hub, ServerInfo server) {
        this.hub = hub;
        this.server = server;
    }

    public ServerInfo getServer() {
        return server;
    }

    public AbstractPlayer getPlayer() {
        return null;
    }

    public AbstractMonster getOpponent() {
        return null;
    }

}
