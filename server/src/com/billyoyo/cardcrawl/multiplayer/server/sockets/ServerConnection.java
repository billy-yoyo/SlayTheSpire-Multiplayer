package com.billyoyo.cardcrawl.multiplayer.server.sockets;

import com.billyoyo.cardcrawl.multiplayer.base.Connection;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketInputStream;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketOutputStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;

/**
 * Created by william on 26/01/2018.
 */
public class ServerConnection extends Connection {

    private static final Logger log = Logger.getLogger(ServerConnection.class.getName());

    private final String clientId;
    private final PacketInputStream input;
    private final PacketOutputStream output;
    private final Socket clientSocket;

    public ServerConnection(Socket clientSocket, String clientId) throws IOException {
        this.clientSocket = clientSocket;
        this.clientId = clientId;
        this.input = new PacketInputStream(new BufferedInputStream(clientSocket.getInputStream()));
        this.output = new PacketOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));

        this.input.start();
        this.output.start();
    }

    @Override
    public String getId() {
        return clientId;
    }

    @Override
    public PacketOutputStream getOutput() {
        return output;
    }

    @Override
    public PacketInputStream getInput() {
        return input;
    }

    @Override
    public void close() throws IOException {
        input.shutdown();
        output.shutdown();
        clientSocket.close();
    }

    @Override
    public void update() {
        if (!clientSocket.isConnected() || clientSocket.isClosed()) {
            try {
                close();
            } catch (IOException e) {
                log.warning("failed to close client connection");
            }
        }
    }

    @Override
    public boolean isConnected() {
        return clientSocket.isConnected() && !clientSocket.isClosed() && !input.isClosed();
    }
}
