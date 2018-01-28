package com.billyoyo.cardcrawl.multiplayer.events.processors.player;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.GainPotionEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class GainPotionEventProcessor extends EventProcessor<GainPotionEvent> {
    @Override
    public EventId getEventId() {
        return EventId.GAIN_POTION;
    }

    @Override
    public Packet processEvent(GainPotionEvent event) {
        return createPacketBuilder(event)
                .add(event.getPotionId()).build();
    }

    @Override
    public GainPotionEvent processPacket(CreateData data, Packet packet) {
        return new GainPotionEvent(data.getClientId(), packet.getString(0));
    }
}
