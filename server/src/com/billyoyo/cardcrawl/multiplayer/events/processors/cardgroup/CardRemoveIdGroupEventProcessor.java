package com.billyoyo.cardcrawl.multiplayer.events.processors.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.CardRemoveIdGroupEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class CardRemoveIdGroupEventProcessor extends EventProcessor<CardRemoveIdGroupEvent> {
    @Override
    public EventId getEventId() {
        return EventId.CARD_REMOVE_ID_GROUP;
    }

    @Override
    public Packet processEvent(CardRemoveIdGroupEvent event) {
        return createPacketBuilder(event)
                .add(event.getCardGroupType())
                .add(event.getEventId()).build();
    }

    @Override
    public CardRemoveIdGroupEvent processPacket(CreateData data, Packet packet) {
        return new CardRemoveIdGroupEvent(data.getClientId(), packet.getCardType(0),
                packet.getString(1));
    }
}
