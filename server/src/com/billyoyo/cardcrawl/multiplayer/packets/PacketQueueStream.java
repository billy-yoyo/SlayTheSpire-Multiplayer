package com.billyoyo.cardcrawl.multiplayer.packets;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 30/01/2018.
 */
public class PacketQueueStream extends Thread {

    private final List<Packet> queue = new ArrayList<>();
    private boolean running = true;

    protected void queuePacket(Packet packet) {
        synchronized (queue) {
            queue.add(packet);
        }
    }

    protected Packet popPacket() {
        synchronized (queue) {
            if (queue.size() == 0) {
                return null;
            }
            return queue.remove(0);
        }
    }

    protected void safeSleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            // we don't care if we're interrupted early, this is just to reduce CPU intensity
        }
    }

    public boolean isRunning() {
        return running;
    }

    public void shutdown() {
        this.running = false;
    }
}
