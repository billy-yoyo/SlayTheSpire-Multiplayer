package com.billyoyo.cardcrawl.multiplayer.events.processors.powergroup;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup.RemovePowerEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 27/01/2018.
 */
public class RemovePowerEventProcessor extends EventProcessor<RemovePowerEvent> {
    @Override
    public Class<RemovePowerEvent> getEventClass() {
        return RemovePowerEvent.class;
    }

    @Override
    public Packet processEvent(RemovePowerEvent event) {
        return createPacketBuilder(event)
                .add(event.getPower()).build();
    }
}
