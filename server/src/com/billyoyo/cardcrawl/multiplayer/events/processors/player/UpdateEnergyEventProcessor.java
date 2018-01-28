package com.billyoyo.cardcrawl.multiplayer.events.processors.player;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.UpdateEnergyEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class UpdateEnergyEventProcessor extends EventProcessor<UpdateEnergyEvent> {
    @Override
    public EventId getEventId() {
        return EventId.UPDATE_ENERGY;
    }

    @Override
    public Packet processEvent(UpdateEnergyEvent event) {
        return createPacketBuilder(event)
                .add(event.getEnergy()).build();
    }

    @Override
    public UpdateEnergyEvent processPacket(CreateData data, Packet packet) {
        return new UpdateEnergyEvent(data.getClientId(), packet.getInt(0));
    }
}
