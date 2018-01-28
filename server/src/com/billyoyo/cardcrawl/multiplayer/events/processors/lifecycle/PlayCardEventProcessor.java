package com.billyoyo.cardcrawl.multiplayer.events.processors.lifecycle;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.PlayCardEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 28/01/2018.
 */
public class PlayCardEventProcessor extends EventProcessor<PlayCardEvent> {
    @Override
    public EventId getEventId() {
        return EventId.PLAY_CARD;
    }

    @Override
    public Packet processEvent(PlayCardEvent event) {
        return createPacketBuilder(event).add(event.getCard()).build();
    }

    @Override
    public PlayCardEvent processPacket(CreateData data, Packet packet) {
        return new PlayCardEvent(data.getClientId(), packet.getCard(0).create(data));
    }
}
