package com.billyoyo.cardcrawl.multiplayer.events.processors.lifecycle;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.OutOfOrderEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 30/01/2018.
 */
public class OutOfOrderEventProcessor extends EventProcessor<OutOfOrderEvent> {
    @Override
    public EventId getEventId() {
        return EventId.OUT_OF_ORDER;
    }

    @Override
    public Packet processEvent(OutOfOrderEvent event) {
        return createPacketBuilder(event).addByte(event.getInvalidEventId()).build();
    }

    @Override
    public OutOfOrderEvent processPacket(CreateData data, Packet packet) {
        return new OutOfOrderEvent(data.getClientId(), packet.getByte(0));
    }
}
