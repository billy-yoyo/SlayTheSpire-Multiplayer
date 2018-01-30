package com.billyoyo.cardcrawl.multiplayer.server.sockets;

import com.billyoyo.cardcrawl.multiplayer.server.ServerSettings;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by william on 29/01/2018.
 */
public class ServerConnectionService extends Thread {

    private static final Logger log = Logger.getLogger(ServerConnectionService.class.getName());
    private static final String ALPHANUMERIC = "abcdefghijklmnopqrstuvwxyABCDEFGHIJKLMNOPQRSTUVWXY0123456789";
    private static final int UNIQUE_ID_LENGTH = 32;
    private final List<String> uniqueIds = new ArrayList<>();

    private final ServerConnectionAcceptor acceptor;
    private final ServerSettings settings;
    private ServerSocket serverSocket;

    public ServerConnectionService(ServerConnectionAcceptor acceptor,
            ServerSettings settings) {
        this.acceptor = acceptor;
        this.settings = settings;
    }

    private String generateId() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < UNIQUE_ID_LENGTH; i++) {
            builder.append(ALPHANUMERIC.charAt(random.nextInt(ALPHANUMERIC.length())));
        }

        return builder.toString();
    }

    private String generateUniqueId() {
        String id = generateId();
        int retries = 0;

        while (uniqueIds.contains(id) && retries < 100) {
            id = generateId();
        }

        if (retries >= 100) {
            throw new RuntimeException("failed to generate unique id");
        }

        return id;
    }

    private void acceptLoop() {
        while (true) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
                ServerConnection connection = new ServerConnection(clientSocket, generateUniqueId());

                if (acceptor.canAccept(connection)) {
                    acceptor.accept(connection);
                } else {
                    connection.close();
                }
            } catch (Exception exception) {
                log.warning("failed to accept client socket");

                if (clientSocket != null) {
                    try {
                        clientSocket.close();
                    } catch (Exception e) {
                        // ignore socket close error
                    }
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            serverSocket = new ServerSocket(settings.getPort());
            acceptLoop();
        } catch (IOException exception) {
            throw new ServerConnectionException("failed to start server", exception);
        }
    }
}
