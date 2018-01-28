package com.billyoyo.cardcrawl.multiplayer.events.processors.powergroup;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup.RemovePowerEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 27/01/2018.
 */
public class RemovePowerEventProcessor extends EventProcessor<RemovePowerEvent> {
    @Override
    public EventId getEventId() {
        return EventId.REMOVE_POWER;
    }

    @Override
    public Packet processEvent(RemovePowerEvent event) {
        return createPacketBuilder(event)
                .add(event.getPower()).build();
    }

    @Override
    public RemovePowerEvent processPacket(CreateData data, Packet packet) {
        return new RemovePowerEvent(data.getClientId(), packet.getPower(0).create(data));
    }
}
