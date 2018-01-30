package com.billyoyo.cardcrawl.multiplayer.server.sockets;

import com.billyoyo.cardcrawl.multiplayer.server.ClientInfo;
import com.billyoyo.cardcrawl.multiplayer.server.ServerHub;
import com.billyoyo.cardcrawl.multiplayer.server.ServerSettings;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by william on 29/01/2018.
 */
public class ServerConnectionAcceptor {

    private static final Logger log = Logger.getLogger(ServerConnectionAcceptor.class.getName());

    private final List<ServerConnection> connections = new ArrayList<>();
    private final List<String> uniqueIds = new ArrayList<>();
    private boolean gameRunning = false;

    private ServerHub hub;
    private ServerSettings settings;

    public ServerConnectionAcceptor(ServerSettings settings) {
        this.hub = new ServerHub(settings);
        this.settings = settings;
    }

    public boolean canAccept(ServerConnection connection) {
        synchronized (connections) {
            return connections.size() < 2;
        }
    }

    public void accept(ServerConnection connection) {
        synchronized (connections) {
            connections.add(connection);
        }
    }

    public void resetConnections() {
        synchronized (connections) {
            for (ServerConnection connection : connections) {
                try {
                    connection.close();
                } catch (IOException e) {
                    log.warning("failed to close connection");
                }
            }
            connections.clear();
            uniqueIds.clear();
        }
        gameRunning = false;
    }

    private ClientInfo createClientInfo(ServerConnection connection) {
        return new ClientInfo(connection);
    }

    public void update() {
        if (!gameRunning) {
            try {
                synchronized (connections) {
                    if (connections.size() == 2) {
                        gameRunning = true;

                        ClientInfo client1 = createClientInfo(connections.get(0));
                        ClientInfo client2 = createClientInfo(connections.get(1));
                        hub.startLobby(client1, client2);
                    }
                }
            } catch (Exception e) {
                gameRunning = false;
                resetConnections();
            }
        }

        if (gameRunning) {
            hub.update();
        }
    }

}
