package com.billyoyo.cardcrawl.multiplayer.base;

import com.billyoyo.cardcrawl.multiplayer.packets.Packet;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketInputStream;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketOutputStream;

import java.io.IOException;

/**
 * Created by william on 28/01/2018.
 */
public abstract class Connection {

    public abstract String getId();
    public abstract PacketOutputStream getOutput();
    public abstract PacketInputStream getInput();
    public abstract void close() throws IOException;
    public abstract void update();
    public abstract boolean isConnected();

    public void popPackets(Hub hub, int limit) {
        int i = 0;
        Packet packet;
        while (i < limit && (packet = getInput().next()) != null) {
            hub.receivePacket(getId(), packet);
        }
    }

}
