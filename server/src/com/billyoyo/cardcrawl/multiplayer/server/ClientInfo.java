package com.billyoyo.cardcrawl.multiplayer.server;

import com.billyoyo.cardcrawl.multiplayer.base.Connection;
import com.megacrit.cardcrawl.characters.AbstractPlayer;

/**
 * Created by william on 26/01/2018.
 */
public class ClientInfo {

    private String id;
    private String name;
    private AbstractPlayer.PlayerClass playerClass;
    private Connection connection;

    public ClientInfo(String clientId, Connection connection, String clientName, AbstractPlayer.PlayerClass playerClass) {
        this.id = clientId;
        this.name = clientName;
        this.playerClass = playerClass;
        this.connection = connection;
    }

    public ClientInfo(String clientId, Connection connection) {
        this(clientId, connection, "Unknown", AbstractPlayer.PlayerClass.IRONCLAD);
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

    public Connection getConnection() {
        return connection;
    }
}
