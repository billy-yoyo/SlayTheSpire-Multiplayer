package com.billyoyo.cardcrawl.multiplayer.events.processors.powergroup;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup.UpdatePowersEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketBuilder;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 27/01/2018.
 */
public class UpdatePowersEventProcessor extends EventProcessor<UpdatePowersEvent> {
    @Override
    public EventId getEventId() {
        return EventId.UPDATE_POWERS;
    }

    @Override
    public Packet processEvent(UpdatePowersEvent event) {
        PacketBuilder builder = createPacketBuilder(event);

        builder.add(event.isOwnerOpponent());

        for (AbstractPower power : event.getPowers()) {
            builder.add(power);
        }

        return builder.build();
    }

    @Override
    public UpdatePowersEvent processPacket(CreateData data, Packet packet) {
        int amountOfBlocks = packet.getAmountOfBlocks();
        List<AbstractPower> powers = new ArrayList<>(amountOfBlocks - 1);

        for (int i = 1; i < amountOfBlocks; i++) {
            powers.add(packet.getPower(i).create(data));
        }

        return new UpdatePowersEvent(data.getClientId(), packet.getBoolean(0), powers);
    }
}
