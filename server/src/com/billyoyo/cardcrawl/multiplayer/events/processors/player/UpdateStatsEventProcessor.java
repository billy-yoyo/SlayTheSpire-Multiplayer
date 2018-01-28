package com.billyoyo.cardcrawl.multiplayer.events.processors.player;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.UpdateStatsEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;
import com.billyoyo.cardcrawl.multiplayer.server.player.ClientPlayerSnapshot;

/**
 * Created by william on 27/01/2018.
 */
public class UpdateStatsEventProcessor extends EventProcessor<UpdateStatsEvent> {
    @Override
    public EventId getEventId() {
        return EventId.UPDATE_STATS;
    }

    @Override
    public Packet processEvent(UpdateStatsEvent event) {
        ClientPlayerSnapshot snapshot = event.getSnapshot();

        return createPacketBuilder(event)
                .add(snapshot.getBlock())
                .add(snapshot.getHealth())
                .add(snapshot.getMaxHealth())
                .add(snapshot.getGold())
                .add(snapshot.getEnergy())
                .add(snapshot.isBloodied())
                .add(snapshot.isDead()).build();
    }

    @Override
    public UpdateStatsEvent processPacket(CreateData data, Packet packet) {
        return new UpdateStatsEvent(data.getClientId(), new ClientPlayerSnapshot(packet.getInt(0),
                packet.getInt(1), packet.getInt(2), packet.getInt(3), packet.getInt(4), packet.getBoolean(5),
                packet.getBoolean(6)));
    }
}
