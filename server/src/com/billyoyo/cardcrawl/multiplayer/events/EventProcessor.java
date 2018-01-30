package com.billyoyo.cardcrawl.multiplayer.events;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketBuilder;

/**
 * Created by william on 26/01/2018.
 */
public abstract class EventProcessor<T extends Event> {

    public abstract EventId getEventId();
    public abstract Packet processEvent(T event);
    public abstract T processPacket(CreateData data, Packet packet);

    protected PacketBuilder createPacketBuilder(T event) {
        return new PacketBuilder().setEventId(event.getEventId());
    }

    public void registerProcessor(EventManager manager) {
        manager.registerEventProcessor(getEventId().getId(), this);
    }
}
