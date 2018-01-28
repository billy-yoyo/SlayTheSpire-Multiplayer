package com.billyoyo.cardcrawl.multiplayer.events.processors.powergroup;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup.AddPowerEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 27/01/2018.
 */
public class AddPowerEventProcessor extends EventProcessor<AddPowerEvent> {
    @Override
    public EventId getEventId() {
        return EventId.ADD_POWER;
    }

    @Override
    public Packet processEvent(AddPowerEvent event) {
        return createPacketBuilder(event)
                .add(event.getPower()).build();
    }

    @Override
    public AddPowerEvent processPacket(CreateData data, Packet packet) {
        return new AddPowerEvent(data.getClientId(), packet.getPower(0).create(data));
    }
}
