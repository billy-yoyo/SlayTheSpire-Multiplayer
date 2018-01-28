package com.billyoyo.cardcrawl.multiplayer.events.processors.relicgroup;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.RemoveRelicEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 27/01/2018.
 */
public class RemoveRelicEventProcessor extends EventProcessor<RemoveRelicEvent> {
    @Override
    public EventId getEventId() {
        return EventId.REMOVE_RELIC;
    }

    @Override
    public Packet processEvent(RemoveRelicEvent event) {
        return createPacketBuilder(event)
                .add(event.getRelic()).build();
    }

    @Override
    public RemoveRelicEvent processPacket(CreateData data, Packet packet) {
        return new RemoveRelicEvent(data.getClientId(), packet.getRelic(0).create(data));
    }
}
