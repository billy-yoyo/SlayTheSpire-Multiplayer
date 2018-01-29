package com.billyoyo.cardcrawl.multiplayer.packets;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by william on 29/01/2018.
 */
public class PacketOutputStream {

    private OutputStream output;

    public PacketOutputStream(OutputStream output) {
        this.output = output;
    }

    public void write(Packet packet) throws IOException {
        packet.write(output);
    }
}
