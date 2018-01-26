package com.billyoyo.cardcrawl.multiplayer.events.processors.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.CardAddGroupEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class CardAddGroupEventProcessor extends EventProcessor<CardAddGroupEvent> {

    @Override
    public Class<CardAddGroupEvent> getEventClass() {
        return CardAddGroupEvent.class;
    }

    @Override
    public Packet processEvent(CardAddGroupEvent event) {
        return createPacketBuilder(event)
                .add(event.getCardGroupType())
                .add(event.getCard())
                .add(event.getPosition()).build();
    }

}
