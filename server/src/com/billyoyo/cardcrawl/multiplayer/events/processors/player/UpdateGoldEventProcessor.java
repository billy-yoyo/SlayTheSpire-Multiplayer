package com.billyoyo.cardcrawl.multiplayer.events.processors.player;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.UpdateGoldEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class UpdateGoldEventProcessor extends EventProcessor<UpdateGoldEvent> {

    @Override
    public Class<UpdateGoldEvent> getEventClass() {
        return UpdateGoldEvent.class;
    }

    @Override
    public Packet processEvent(UpdateGoldEvent event) {
        return createPacketBuilder(event)
                .add(event.getGold()).build();
    }
}
