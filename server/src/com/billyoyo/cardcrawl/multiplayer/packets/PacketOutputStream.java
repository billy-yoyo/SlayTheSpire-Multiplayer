package com.billyoyo.cardcrawl.multiplayer.packets;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by william on 29/01/2018.
 */
public class PacketOutputStream extends PacketQueueStream {

    private OutputStream output;

    public PacketOutputStream(OutputStream output) {
        this.output = output;
    }

    public void write(Packet packet) {
        queuePacket(packet);
    }

    private boolean writePacket(Packet packet) {
        try {
            packet.write(output);
            return true;
        } catch (IOException e) {
            // do nothing
        }
        return false;
    }

    @Override
    public void run() {
        while (isRunning()) {
            Packet packet = popPacket();
            if (packet != null) {
                if (!writePacket(packet)) {
                    // for now, ignore. could push this packet back to the front of the queue
                    // but could lead to a lockup of the server
                }
            } else {
                safeSleep(100);
            }
        }
    }
}
