package com.billyoyo.cardcrawl.multiplayer.events.processors.lifecycle;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.InvalidEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 30/01/2018.
 */
public class InvalidEventProcessor extends EventProcessor<InvalidEvent> {
    @Override
    public EventId getEventId() {
        return EventId.INVALID;
    }

    @Override
    public Packet processEvent(InvalidEvent event) {
        return createPacketBuilder(event).addByte(event.getInvalidEventId()).build();
    }

    @Override
    public InvalidEvent processPacket(CreateData data, Packet packet) {
        return new InvalidEvent(data.getClientId(), packet.getByte(0));
    }
}
