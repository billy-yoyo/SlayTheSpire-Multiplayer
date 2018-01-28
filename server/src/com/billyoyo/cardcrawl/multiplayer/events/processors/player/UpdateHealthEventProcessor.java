package com.billyoyo.cardcrawl.multiplayer.events.processors.player;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.UpdateHealthEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class UpdateHealthEventProcessor extends EventProcessor<UpdateHealthEvent> {
    @Override
    public EventId getEventId() {
        return EventId.UPDATE_HEALTH;
    }

    @Override
    public Packet processEvent(UpdateHealthEvent event) {
        return createPacketBuilder(event)
                .add(event.getHealth())
                .add(event.isDead())
                .add(event.isBloodied()).build();
    }

    @Override
    public UpdateHealthEvent processPacket(CreateData data, Packet packet) {
        return new UpdateHealthEvent(data.getClientId(), packet.getInt(0),
                packet.getBoolean(1), packet.getBoolean(2));
    }
}
