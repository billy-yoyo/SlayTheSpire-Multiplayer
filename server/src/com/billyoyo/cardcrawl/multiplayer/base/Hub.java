package com.billyoyo.cardcrawl.multiplayer.base;

import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 28/01/2018.
 */
public interface Hub {

    public void postEvent(Event event);
    public void sendPacket(String destination, Packet packet);
    public void receivePacket(String source, Packet packet);
    public void update();

}
