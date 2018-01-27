package com.billyoyo.cardcrawl.multiplayer.events.processors.lifecycle;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.EndTurnEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 27/01/2018.
 */
public class EndTurnEventProcessor extends EventProcessor<EndTurnEvent> {
    @Override
    public Class<EndTurnEvent> getEventClass() {
        return EndTurnEvent.class;
    }

    @Override
    public Packet processEvent(EndTurnEvent event) {
        return createPacketBuilder(event).build();
    }
}
