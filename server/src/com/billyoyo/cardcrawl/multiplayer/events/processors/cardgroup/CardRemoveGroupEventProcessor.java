package com.billyoyo.cardcrawl.multiplayer.events.processors.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.CardRemoveGroupEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class CardRemoveGroupEventProcessor extends EventProcessor<CardRemoveGroupEvent> {
    @Override
    public Class<CardRemoveGroupEvent> getEventClass() {
        return CardRemoveGroupEvent.class;
    }

    @Override
    public Packet processEvent(CardRemoveGroupEvent event) {
        return createPacketBuilder(event)
                .add(event.getCardGroupType())
                .add(event.getCard()).build();
    }
}
