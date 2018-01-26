package com.billyoyo.cardcrawl.multiplayer.events;

import com.billyoyo.cardcrawl.multiplayer.packets.Packet;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketBuilder;
import com.billyoyo.cardcrawl.multiplayer.server.ServerHub;

/**
 * Created by william on 26/01/2018.
 */
public abstract class EventProcessor<T extends Event> {

    public abstract Class<T> getEventClass();
    public abstract Packet processEvent(T event);

    protected PacketBuilder createPacketBuilder(T event) {
        return new PacketBuilder().setEventId(event.getEventId());
    }

    public void sendPacket(ServerHub hub, T event) {
        Packet packet = processEvent(event);

        hub.sendPacket(event.getClientId(), packet);
    }

    public void registerProcessor(EventManager manager) {
        manager.registerEventProcessor(getEventClass(), this);
    }
}
