package com.billyoyo.cardcrawl.multiplayer.server;

/**
 * Created by william on 26/01/2018.
 */
public class ClientInfo {

    private String clientId;

    public ClientInfo(String clientId) {
        this.clientId = clientId;
    }

    public String getId() {
        return clientId;
    }
}
