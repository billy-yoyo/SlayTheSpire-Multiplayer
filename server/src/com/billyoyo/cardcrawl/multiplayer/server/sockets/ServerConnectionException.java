package com.billyoyo.cardcrawl.multiplayer.server.sockets;

/**
 * Created by william on 29/01/2018.
 */
public class ServerConnectionException extends RuntimeException{

    public ServerConnectionException(String message, Exception source) {
        super(message, source);
    }

    public ServerConnectionException(String message) {
        super(message);
    }

}
