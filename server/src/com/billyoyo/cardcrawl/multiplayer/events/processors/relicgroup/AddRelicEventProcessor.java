package com.billyoyo.cardcrawl.multiplayer.events.processors.relicgroup;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.AddRelicEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 27/01/2018.
 */
public class AddRelicEventProcessor extends EventProcessor<AddRelicEvent> {
    @Override
    public EventId getEventId() {
        return EventId.ADD_RELIC;
    }

    @Override
    public Packet processEvent(AddRelicEvent event) {
        return createPacketBuilder(event)
                .add(event.getRelic()).build();
    }

    @Override
    public AddRelicEvent processPacket(CreateData data, Packet packet) {
        return new AddRelicEvent(data.getClientId(), packet.getRelic(0).create(data));
    }
}
