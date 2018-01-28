package com.billyoyo.cardcrawl.multiplayer.events.processors.relicgroup;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.ClearRelicsEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 27/01/2018.
 */
public class ClearRelicsEventProcessor extends EventProcessor<ClearRelicsEvent> {
    @Override
    public EventId getEventId() {
        return EventId.CLEAR_RELICS;
    }

    @Override
    public Packet processEvent(ClearRelicsEvent event) {
        return createPacketBuilder(event).build();
    }

    @Override
    public ClearRelicsEvent processPacket(CreateData data, Packet packet) {
        return new ClearRelicsEvent(data.getClientId());
    }
}
