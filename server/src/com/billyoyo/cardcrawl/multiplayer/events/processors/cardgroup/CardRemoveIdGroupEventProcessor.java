package com.billyoyo.cardcrawl.multiplayer.events.processors.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.CardRemoveIdGroupEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class CardRemoveIdGroupEventProcessor extends EventProcessor<CardRemoveIdGroupEvent> {
    @Override
    public Class<CardRemoveIdGroupEvent> getEventClass() {
        return CardRemoveIdGroupEvent.class;
    }

    @Override
    public Packet processEvent(CardRemoveIdGroupEvent event) {
        return createPacketBuilder(event)
                .add(event.getCardGroupType())
                .add(event.getEventId()).build();
    }
}
