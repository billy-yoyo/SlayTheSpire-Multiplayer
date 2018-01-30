package com.billyoyo.cardcrawl.multiplayer.packets;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by william on 29/01/2018.
 */
public class PacketInputStream extends PacketQueueStream {

    private InputStream input;

    public PacketInputStream(InputStream input) {
        this.input = input;
    }

    public Packet next() {
        return popPacket();
    }

    private boolean nextPacket() {
        try {
            Packet packet = Packet.read(input);
            if (packet != null) {
                queuePacket(packet);
                return true;
            }
        } catch (IOException e) {
            // errornous packet, skip
        }
        return false;
    }

    @Override
    public void run() {
        while (isRunning()) {
            if (!nextPacket()) {
                safeSleep(100);
            }
        }
    }

}
