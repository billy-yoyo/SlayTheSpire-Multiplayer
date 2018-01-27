package com.billyoyo.cardcrawl.multiplayer.events.processors.powergroup;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup.UpdatePowersEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketBuilder;
import com.megacrit.cardcrawl.powers.AbstractPower;

/**
 * Created by william on 27/01/2018.
 */
public class UpdatePowersEventProcessor extends EventProcessor<UpdatePowersEvent> {
    @Override
    public Class<UpdatePowersEvent> getEventClass() {
        return UpdatePowersEvent.class;
    }

    @Override
    public Packet processEvent(UpdatePowersEvent event) {
        PacketBuilder builder = createPacketBuilder(event);

        for (AbstractPower power : event.getPowers()) {
            builder.add(power);
        }

        return builder.build();
    }
}
