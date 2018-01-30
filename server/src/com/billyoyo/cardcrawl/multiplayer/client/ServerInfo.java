package com.billyoyo.cardcrawl.multiplayer.client;

/**
 * Created by william on 30/01/2018.
 */
public class ServerInfo {

    private ClientConnection connection;

    public ServerInfo(ClientConnection connection) {
        this.connection = connection;
    }

    public String getId() {
        return connection.getId();
    }

    public ClientConnection getConnection() {
        return connection;
    }
}
