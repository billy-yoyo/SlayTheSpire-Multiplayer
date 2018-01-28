package com.billyoyo.cardcrawl.multiplayer.events.processors.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.ClearCardsGroupEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class ClearCardsGroupEventProcessor extends EventProcessor<ClearCardsGroupEvent> {
    @Override
    public EventId getEventId() {
        return EventId.CLEAR_CARDS_GROUP;
    }

    @Override
    public Packet processEvent(ClearCardsGroupEvent event) {
        return createPacketBuilder(event)
                .add(event.getCardGroupType()).build();
    }

    @Override
    public ClearCardsGroupEvent processPacket(CreateData data, Packet packet) {
        return new ClearCardsGroupEvent(data.getClientId(), packet.getCardType(0));
    }
}
