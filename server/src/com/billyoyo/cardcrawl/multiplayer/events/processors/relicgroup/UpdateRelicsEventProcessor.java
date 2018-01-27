package com.billyoyo.cardcrawl.multiplayer.events.processors.relicgroup;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.UpdateRelicsEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketBuilder;
import com.megacrit.cardcrawl.relics.AbstractRelic;

/**
 * Created by william on 27/01/2018.
 */
public class UpdateRelicsEventProcessor extends EventProcessor<UpdateRelicsEvent> {


    @Override
    public Class<UpdateRelicsEvent> getEventClass() {
        return UpdateRelicsEvent.class;
    }

    @Override
    public Packet processEvent(UpdateRelicsEvent event) {
        PacketBuilder builder = createPacketBuilder(event);

        for (AbstractRelic relic : event.getRelics()) {
            builder.add(relic);
        }

        return builder.build();
    }
}
