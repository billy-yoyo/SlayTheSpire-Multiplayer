package com.billyoyo.cardcrawl.multiplayer.events.processors.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.DiscardAllGroupEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 27/01/2018.
 */
public class DiscardAllGroupEventProcessor extends EventProcessor<DiscardAllGroupEvent> {
    @Override
    public Class<DiscardAllGroupEvent> getEventClass() {
        return DiscardAllGroupEvent.class;
    }

    @Override
    public Packet processEvent(DiscardAllGroupEvent event) {
        return createPacketBuilder(event)
                .add(event.getCardGroupType()).build();
    }
}
