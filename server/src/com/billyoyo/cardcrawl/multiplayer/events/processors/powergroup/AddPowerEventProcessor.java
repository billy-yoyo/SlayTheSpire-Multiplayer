package com.billyoyo.cardcrawl.multiplayer.events.processors.powergroup;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup.AddPowerEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 27/01/2018.
 */
public class AddPowerEventProcessor extends EventProcessor<AddPowerEvent> {
    @Override
    public Class<AddPowerEvent> getEventClass() {
        return AddPowerEvent.class;
    }

    @Override
    public Packet processEvent(AddPowerEvent event) {
        return createPacketBuilder(event)
                .add(event.getPower()).build();
    }
}
