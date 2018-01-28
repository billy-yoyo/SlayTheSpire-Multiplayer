package com.billyoyo.cardcrawl.multiplayer.events.processors.lifecycle;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.StartTurnEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 27/01/2018.
 */
public class StartTurnEventProcessor extends EventProcessor<StartTurnEvent> {
    @Override
    public EventId getEventId() {
        return EventId.START_TURN;
    }

    @Override
    public Packet processEvent(StartTurnEvent event) {
        return createPacketBuilder(event).build();
    }

    @Override
    public StartTurnEvent processPacket(CreateData data, Packet packet) {
        return new StartTurnEvent(data.getClientId());
    }
}
