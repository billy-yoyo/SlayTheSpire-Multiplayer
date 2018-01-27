package com.billyoyo.cardcrawl.multiplayer.events.processors.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.UpdateCardsGroupEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketBuilder;
import com.megacrit.cardcrawl.cards.AbstractCard;

/**
 * Created by william on 27/01/2018.
 */
public class UpdateCardsGroupEventProcessor extends EventProcessor<UpdateCardsGroupEvent> {

    @Override
    public Class<UpdateCardsGroupEvent> getEventClass() {
        return UpdateCardsGroupEvent.class;
    }

    @Override
    public Packet processEvent(UpdateCardsGroupEvent event) {
        PacketBuilder builder = createPacketBuilder(event);
        builder.add(event.getCardGroupType());

        for (AbstractCard card : event.getCards()) {
            builder.add(card);
        }

        return builder.build();
    }
}
