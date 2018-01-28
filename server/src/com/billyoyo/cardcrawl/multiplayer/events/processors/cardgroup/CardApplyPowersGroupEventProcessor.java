package com.billyoyo.cardcrawl.multiplayer.events.processors.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.CardApplyPowersGroupEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class CardApplyPowersGroupEventProcessor extends EventProcessor<CardApplyPowersGroupEvent> {

    @Override
    public EventId getEventId() {
        return EventId.CARD_APPLY_POWERS_GROUP;
    }

    @Override
    public Packet processEvent(CardApplyPowersGroupEvent event) {
        return createPacketBuilder(event)
                .add(event.getCardGroupType()).build();
    }

    @Override
    public CardApplyPowersGroupEvent processPacket(CreateData data, Packet packet) {
        return new CardApplyPowersGroupEvent(data.getClientId(), packet.getCardType(0));
    }
}
