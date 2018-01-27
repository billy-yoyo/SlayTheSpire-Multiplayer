package com.billyoyo.cardcrawl.multiplayer.events.processors.relicgroup;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.AddRelicEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 27/01/2018.
 */
public class AddRelicEventProcessor extends EventProcessor<AddRelicEvent> {
    @Override
    public Class<AddRelicEvent> getEventClass() {
        return AddRelicEvent.class;
    }

    @Override
    public Packet processEvent(AddRelicEvent event) {
        return createPacketBuilder(event)
                .add(event.getRelic()).build();
    }
}
