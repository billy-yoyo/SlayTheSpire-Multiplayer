package com.billyoyo.cardcrawl.multiplayer.events.processors.relicgroup;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.RemoveRelicEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 27/01/2018.
 */
public class RemoveRelicEventProcessor extends EventProcessor<RemoveRelicEvent> {
    @Override
    public Class<RemoveRelicEvent> getEventClass() {
        return RemoveRelicEvent.class;
    }

    @Override
    public Packet processEvent(RemoveRelicEvent event) {
        return createPacketBuilder(event)
                .add(event.getRelic()).build();
    }
}
