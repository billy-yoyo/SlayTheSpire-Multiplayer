package com.billyoyo.cardcrawl.multiplayer.events.processors.lifecycle;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.ContinueTurnEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 28/01/2018.
 */
public class ContinueTurnEventProcessor extends EventProcessor<ContinueTurnEvent> {
    @Override
    public EventId getEventId() {
        return EventId.CONTINUE_TURN;
    }

    @Override
    public Packet processEvent(ContinueTurnEvent event) {
        return createPacketBuilder(event).build();
    }

    @Override
    public ContinueTurnEvent processPacket(CreateData data, Packet packet) {
        return new ContinueTurnEvent(data.getClientId());
    }
}
