package com.billyoyo.cardcrawl.multiplayer.events.processors.lifecycle;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.StartTurnEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 27/01/2018.
 */
public class StartTurnEventProcessor extends EventProcessor<StartTurnEvent> {
    @Override
    public Class<StartTurnEvent> getEventClass() {
        return StartTurnEvent.class;
    }

    @Override
    public Packet processEvent(StartTurnEvent event) {
        return createPacketBuilder(event).build();
    }
}
