package com.billyoyo.cardcrawl.multiplayer.client.sockets;

import com.billyoyo.cardcrawl.multiplayer.base.Connection;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketInputStream;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketOutputStream;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by william on 28/01/2018.
 */
public class ClientConnection extends Connection {

    private final String id;
    private final Socket serverSocket;
    private final PacketInputStream input;
    private final PacketOutputStream output;

    public ClientConnection(Socket serverSocket, String id) throws IOException {
        this.serverSocket = serverSocket;
        this.id = id;
        this.input = new PacketInputStream(serverSocket.getInputStream());
        this.output = new PacketOutputStream(serverSocket.getOutputStream());

        this.input.start();
        this.output.start();
    }

    @Override
    public String getId() {
        return id;
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
        serverSocket.close();
    }

    @Override
    public void update() {

    }

    @Override
    public boolean isConnected() {
        return serverSocket.isConnected() && !serverSocket.isClosed();
    }

    public boolean ensureConnected() {
        try {
            if (!serverSocket.isConnected() || serverSocket.isClosed()) {
                close();
                return false;
            }
        } catch (IOException exception) {
            return false;
        }

        return true;
    }
}
