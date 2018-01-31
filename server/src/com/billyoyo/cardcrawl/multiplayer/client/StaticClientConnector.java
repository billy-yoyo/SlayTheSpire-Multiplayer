package com.billyoyo.cardcrawl.multiplayer.client;

import com.billyoyo.cardcrawl.multiplayer.client.sockets.ClientConnection;
import com.billyoyo.cardcrawl.multiplayer.util.IdHelper;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Created by william on 30/01/2018.
 */
public class StaticClientConnector {

    public static int DEFAULT_PORT = 9432;
    public static String DEFAULT_HOST = "localhost";

    private static final Logger log = Logger.getLogger(StaticClientConnector.class.getName());

    // once you've connected, all you need to do to keep the game
    // running is call ClientHub.update() regularly
    public static ClientHub connectToServer(String host, int port, AbstractMonster opponent) {
        try {
            Socket serverSocket = new Socket(host, port);

            ClientHub hub = new ClientHub(opponent);
            ClientConnection connection = new ClientConnection(serverSocket, IdHelper.generateUniqueId());
            ServerInfo info = new ServerInfo(connection);

            if (serverSocket.isClosed() || !serverSocket.isConnected()) {
                connection.close();
            } else {
                hub.startLobby(info);
                return hub;
            }
        } catch (IOException exception) {
            log.warning("failed to connect to server");
        }
        return null;
    }

}
