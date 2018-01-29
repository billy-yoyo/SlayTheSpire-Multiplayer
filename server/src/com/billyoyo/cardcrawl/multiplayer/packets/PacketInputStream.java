package com.billyoyo.cardcrawl.multiplayer.packets;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by william on 29/01/2018.
 */
public class PacketInputStream {

    private InputStream input;

    public PacketInputStream(InputStream input) {
        this.input = input;
    }

    public Packet read() throws IOException {
        return Packet.read(input);
    }
}
