package com.billyoyo.cardcrawl.multiplayer.events.processors.player;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.UpdateEnergyEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class UpdateEnergyEventProcessor extends EventProcessor<UpdateEnergyEvent> {
    @Override
    public Class<UpdateEnergyEvent> getEventClass() {
        return UpdateEnergyEvent.class;
    }

    @Override
    public Packet processEvent(UpdateEnergyEvent event) {
        return createPacketBuilder(event)
                .add(event.getEnergy()).build();
    }
}
