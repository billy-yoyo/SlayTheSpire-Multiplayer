package com.billyoyo.cardcrawl.multiplayer.events.processors.lifecycle;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.ReadyEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 29/01/2018.
 */
public class ReadyEventProcessor extends EventProcessor<ReadyEvent> {
    @Override
    public EventId getEventId() {
        return EventId.READY;
    }

    @Override
    public Packet processEvent(ReadyEvent event) {
        return createPacketBuilder(event).build();
    }

    @Override
    public ReadyEvent processPacket(CreateData data, Packet packet) {
        return new ReadyEvent(data.getClientId());
    }
}
