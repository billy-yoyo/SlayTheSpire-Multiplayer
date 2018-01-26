package com.billyoyo.cardcrawl.multiplayer.events.processors.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.RemoveTopCardGroupEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class RemoveTopCardGroupEventProcessor extends EventProcessor<RemoveTopCardGroupEvent> {
    @Override
    public Class<RemoveTopCardGroupEvent> getEventClass() {
        return RemoveTopCardGroupEvent.class;
    }

    @Override
    public Packet processEvent(RemoveTopCardGroupEvent event) {
        return createPacketBuilder(event)
                .add(event.getCardGroupType().ordinal()).build();
    }
}
