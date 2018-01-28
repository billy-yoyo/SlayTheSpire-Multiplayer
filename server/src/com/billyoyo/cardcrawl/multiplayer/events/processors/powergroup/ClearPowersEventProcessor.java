package com.billyoyo.cardcrawl.multiplayer.events.processors.powergroup;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup.ClearPowersEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 27/01/2018.
 */
public class ClearPowersEventProcessor extends EventProcessor<ClearPowersEvent> {
    @Override
    public EventId getEventId() {
        return EventId.CLEAR_POWERS;
    }

    @Override
    public Packet processEvent(ClearPowersEvent event) {
        return createPacketBuilder(event).build();
    }

    @Override
    public ClearPowersEvent processPacket(CreateData data, Packet packet) {
        return new ClearPowersEvent(data.getClientId());
    }
}
