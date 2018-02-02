package com.billyoyo.cardcrawl.multiplayer.packets;

import com.billyoyo.cardcrawl.multiplayer.util.InputFinishedException;

import java.io.IOException;
import java.io.InputStream;
import java.net.SocketException;
import java.util.logging.Logger;

/**
 * Created by william on 29/01/2018.
 */
public class PacketInputStream extends PacketQueueStream {

    private static final Logger log = Logger.getLogger(PacketInputStream.class.getName());

    private InputStream input;
    private boolean closed = false;

    public PacketInputStream(InputStream input) {
        this.input = input;
    }

    public Packet next() {
        return popPacket();
    }

    public boolean isClosed() {
        return closed;
    }

    private boolean nextPacket() {
        try {
            Packet packet = Packet.read(input);
            if (packet != null) {
                queuePacket(packet);
                return true;
            }
        } catch (InputFinishedException | SocketException e) {
            closed = true;
            try {
                input.close();
            } catch (IOException ioe) {
            }
            log.info("input stream closed");
            shutdown();
        } catch (IOException e) {
            // errornous packet, skip
            log.info("packet encountered error: ");
            e.printStackTrace();
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
