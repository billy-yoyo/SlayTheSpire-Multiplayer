package com.billyoyo.cardcrawl.multiplayer.server;

import com.billyoyo.cardcrawl.multiplayer.base.Connection;
import com.megacrit.cardcrawl.characters.AbstractPlayer;

/**
 * Created by william on 26/01/2018.
 */
public class ClientInfo {

    private String name;
    private AbstractPlayer.PlayerClass playerClass;
    private Connection connection;
    private boolean ready = false;

    public ClientInfo(Connection connection, String clientName, AbstractPlayer.PlayerClass playerClass) {
        this.name = clientName;
        this.playerClass = playerClass;
        this.connection = connection;
    }

    public ClientInfo(Connection connection) {
        this(connection, "Unknown", AbstractPlayer.PlayerClass.IRONCLAD);
    }

    public AbstractPlayer.PlayerClass getPlayerClass() {
        return playerClass;
    }

    public String getId() {
        return connection.getId();
    }

    public String getName() {
        return name;
    }

    public Connection getConnection() {
        return connection;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }
}
