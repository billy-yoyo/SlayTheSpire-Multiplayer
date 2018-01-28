package com.billyoyo.cardcrawl.multiplayer.events.processors.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.RemoveTopCardGroupEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class RemoveTopCardGroupEventProcessor extends EventProcessor<RemoveTopCardGroupEvent> {
    @Override
    public EventId getEventId() {
        return EventId.REMOVE_TOP_CARD_GROUP;
    }

    @Override
    public Packet processEvent(RemoveTopCardGroupEvent event) {
        return createPacketBuilder(event)
                .add(event.getCardGroupType().ordinal()).build();
    }

    @Override
    public RemoveTopCardGroupEvent processPacket(CreateData data, Packet packet) {
        return new RemoveTopCardGroupEvent(data.getClientId(), packet.getCardType(0));
    }
}
