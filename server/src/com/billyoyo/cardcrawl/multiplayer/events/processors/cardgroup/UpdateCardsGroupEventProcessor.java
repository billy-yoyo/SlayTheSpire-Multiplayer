package com.billyoyo.cardcrawl.multiplayer.events.processors.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.UpdateCardsGroupEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketBuilder;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 27/01/2018.
 */
public class UpdateCardsGroupEventProcessor extends EventProcessor<UpdateCardsGroupEvent> {

    @Override
    public EventId getEventId() {
        return EventId.UPDATE_CARDS_GROUP;
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

    @Override
    public UpdateCardsGroupEvent processPacket(CreateData data, Packet packet) {
        int numberOfBlocks = packet.getAmountOfBlocks();
        CardGroup.CardGroupType type = packet.getCardType(0);
        List<AbstractCard> cards = new ArrayList<>(numberOfBlocks - 1);

        for (int i = 1; i < numberOfBlocks; i++) {
            cards.add(packet.getCard(i).create(data));
        }

        return new UpdateCardsGroupEvent(data.getClientId(), type, cards);
    }
}
