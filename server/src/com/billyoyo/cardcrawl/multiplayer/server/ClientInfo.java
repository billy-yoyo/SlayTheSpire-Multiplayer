package com.billyoyo.cardcrawl.multiplayer.server;

import com.megacrit.cardcrawl.characters.AbstractPlayer;

/**
 * Created by william on 26/01/2018.
 */
public class ClientInfo {

    private String id;
    private String name;
    private AbstractPlayer.PlayerClass playerClass;

    public ClientInfo(String clientId, String clientName, AbstractPlayer.PlayerClass playerClass) {
        this.id = clientId;
        this.name = clientName;
        this.playerClass = playerClass;
    }

    public ClientInfo(String clientId) {
        this(clientId, "Unknown", AbstractPlayer.PlayerClass.IRONCLAD);
    }

    public AbstractPlayer.PlayerClass getPlayerClass() {
        return playerClass;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
