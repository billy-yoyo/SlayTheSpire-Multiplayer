package com.billyoyo.cardcrawl.multiplayer.events.processors.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.CardAddGroupEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;
import com.billyoyo.cardcrawl.multiplayer.packets.blocks.AbstractCardBlock;
import com.billyoyo.cardcrawl.multiplayer.packets.blocks.CardGroupTypeBlock;

/**
 * Created by william on 26/01/2018.
 */
public class CardAddGroupEventProcessor extends EventProcessor<CardAddGroupEvent> {

    @Override
    public EventId getEventId() {
        return EventId.CARD_ADD_GROUP;
    }

    @Override
    public Packet processEvent(CardAddGroupEvent event) {
        return createPacketBuilder(event)
                .add(event.getCardGroupType())
                .add(event.getCard())
                .add(event.getPosition()).build();
    }

    @Override
    public CardAddGroupEvent processPacket(CreateData data, Packet packet) {
        return new CardAddGroupEvent(data.getClientId(), packet.getCardType(0),
                packet.getCard(1).create(data), packet.getInt(2));
    }

}
