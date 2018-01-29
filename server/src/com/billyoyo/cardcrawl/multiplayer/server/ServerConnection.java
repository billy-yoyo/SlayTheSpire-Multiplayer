package com.billyoyo.cardcrawl.multiplayer.server;

import com.billyoyo.cardcrawl.multiplayer.base.Connection;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketInputStream;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketOutputStream;

/**
 * Created by william on 26/01/2018.
 */
public class ServerConnection implements Connection {
    @Override
    public PacketInputStream getPacketInputStream() {
        return null;
    }

    @Override
    public PacketOutputStream getPacketOutputStream() {
        return null;
    }
}
