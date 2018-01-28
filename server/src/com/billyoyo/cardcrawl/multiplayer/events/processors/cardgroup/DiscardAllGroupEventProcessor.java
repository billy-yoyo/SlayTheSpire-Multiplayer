package com.billyoyo.cardcrawl.multiplayer.events.processors.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.DiscardAllGroupEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 27/01/2018.
 */
public class DiscardAllGroupEventProcessor extends EventProcessor<DiscardAllGroupEvent> {
    @Override
    public EventId getEventId() {
        return EventId.DISCARD_ALL_GROUP;
    }

    @Override
    public Packet processEvent(DiscardAllGroupEvent event) {
        return createPacketBuilder(event)
                .add(event.getCardGroupType()).build();
    }

    @Override
    public DiscardAllGroupEvent processPacket(CreateData data, Packet packet) {
        return new DiscardAllGroupEvent(data.getClientId(), packet.getCardType(0));
    }
}
