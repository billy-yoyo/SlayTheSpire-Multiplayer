package com.billyoyo.cardcrawl.multiplayer.events.processors.player;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.LosePotionEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class LosePotionEventProcessor extends EventProcessor<LosePotionEvent> {
    @Override
    public EventId getEventId() {
        return EventId.LOSE_POTION;
    }

    @Override
    public Packet processEvent(LosePotionEvent event) {
        return createPacketBuilder(event)
                .add(event.getPotionId()).build();
    }

    @Override
    public LosePotionEvent processPacket(CreateData data, Packet packet) {
        return new LosePotionEvent(data.getClientId(), packet.getString(0));
    }
}
