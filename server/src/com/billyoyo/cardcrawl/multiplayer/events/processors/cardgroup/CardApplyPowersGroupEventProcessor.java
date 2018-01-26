package com.billyoyo.cardcrawl.multiplayer.events.processors.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.CardApplyPowersGroupEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class CardApplyPowersGroupEventProcessor extends EventProcessor<CardApplyPowersGroupEvent> {

    @Override
    public Class<CardApplyPowersGroupEvent> getEventClass() {
        return CardApplyPowersGroupEvent.class;
    }

    @Override
    public Packet processEvent(CardApplyPowersGroupEvent event) {
        return createPacketBuilder(event)
                .add(event.getCardGroupType()).build();
    }
}
