package com.billyoyo.cardcrawl.multiplayer.packets;

import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

/**
 * Created by william on 29/01/2018.
 */
public class PacketOutputStream extends PacketQueueStream {

    private static final Logger log = Logger.getLogger(PacketOutputStream.class.getName());

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
            output.flush();
            return true;
        } catch (IOException e) {
            // do nothing
            log.info("failed to write packet:");
            e.printStackTrace();
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
