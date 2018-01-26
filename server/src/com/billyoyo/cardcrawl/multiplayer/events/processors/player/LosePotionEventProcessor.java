package com.billyoyo.cardcrawl.multiplayer.events.processors.player;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.LosePotionEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class LosePotionEventProcessor extends EventProcessor<LosePotionEvent> {
    @Override
    public Class<LosePotionEvent> getEventClass() {
        return LosePotionEvent.class;
    }

    @Override
    public Packet processEvent(LosePotionEvent event) {
        return createPacketBuilder(event)
                .add(event.getPotionId()).build();
    }
}
