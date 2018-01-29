package com.billyoyo.cardcrawl.multiplayer.base;

import com.billyoyo.cardcrawl.multiplayer.packets.PacketInputStream;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketOutputStream;

/**
 * Created by william on 28/01/2018.
 */
public interface Connection {

    public PacketInputStream getPacketInputStream();
    public PacketOutputStream getPacketOutputStream();

}
