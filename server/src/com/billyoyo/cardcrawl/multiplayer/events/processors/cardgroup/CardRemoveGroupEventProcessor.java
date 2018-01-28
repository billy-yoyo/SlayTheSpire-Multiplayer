package com.billyoyo.cardcrawl.multiplayer.events.processors.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.CardRemoveGroupEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class CardRemoveGroupEventProcessor extends EventProcessor<CardRemoveGroupEvent> {
    @Override
    public EventId getEventId() {
        return EventId.CARD_REMOVE_GROUP;
    }

    @Override
    public Packet processEvent(CardRemoveGroupEvent event) {
        return createPacketBuilder(event)
                .add(event.getCardGroupType())
                .add(event.getCard()).build();
    }

    @Override
    public CardRemoveGroupEvent processPacket(CreateData data, Packet packet) {
        return new CardRemoveGroupEvent(data.getClientId(), packet.getCardType(0),
                packet.getCard(1).create(data));
    }
}
