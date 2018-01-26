package com.billyoyo.cardcrawl.multiplayer.events.processors.player;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.UpdateHealthEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class UpdateHealthEventProcessor extends EventProcessor<UpdateHealthEvent> {
    @Override
    public Class<UpdateHealthEvent> getEventClass() {
        return UpdateHealthEvent.class;
    }

    @Override
    public Packet processEvent(UpdateHealthEvent event) {
        return createPacketBuilder(event)
                .add(event.getHealth())
                .add(event.isBloodied())
                .add(event.isDead()).build();
    }
}
