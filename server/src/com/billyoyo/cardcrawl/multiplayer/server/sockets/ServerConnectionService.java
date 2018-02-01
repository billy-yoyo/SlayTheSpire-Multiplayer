package com.billyoyo.cardcrawl.multiplayer.server.sockets;

import com.billyoyo.cardcrawl.multiplayer.server.ServerSettings;
import com.billyoyo.cardcrawl.multiplayer.util.IdHelper;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Created by william on 29/01/2018.
 */
public class ServerConnectionService extends Thread {

    private static final Logger log = Logger.getLogger(ServerConnectionService.class.getName());

    private final ServerConnectionAcceptor acceptor;
    private final ServerSettings settings;
    private ServerSocket serverSocket;

    public ServerConnectionService(ServerConnectionAcceptor acceptor,
            ServerSettings settings) {
        this.acceptor = acceptor;
        this.settings = settings;
    }

    private void acceptLoop() {
        while (true) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
                ServerConnection connection = new ServerConnection(clientSocket, IdHelper.generateUniqueId());

                if (acceptor.canAccept(connection)) {
                    log.info("accepted client");
                    acceptor.accept(connection);
                } else {
                    log.info("refused client");
                    connection.close();
                }
            } catch (Exception exception) {
                log.warning("failed to accept client sockets");

                if (clientSocket != null) {
                    try {
                        clientSocket.close();
                    } catch (Exception e) {
                        // ignore sockets close error
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            log.info("starting server...");
            serverSocket = new ServerSocket(settings.getPort());
            acceptLoop();
        } catch (IOException exception) {
            throw new ServerConnectionException("failed to start server", exception);
        }
    }
}
