package com.billyoyo.cardcrawl.multiplayer.events.processors.player;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.UpdateOpponentStatsEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;
import com.billyoyo.cardcrawl.multiplayer.server.player.ClientPlayerSnapshot;

/**
 * Created by william on 27/01/2018.
 */
public class UpdateOpponentStatsEventProcessor extends EventProcessor<UpdateOpponentStatsEvent> {
    @Override
    public EventId getEventId() {
        return EventId.UPDATE_OPPONENT_STATS;
    }

    @Override
    public Packet processEvent(UpdateOpponentStatsEvent event) {
        ClientPlayerSnapshot snapshot = event.getSnapshot();

        return createPacketBuilder(event)
                .add(snapshot.getBlock())
                .add(snapshot.getHealth())
                .add(snapshot.getMaxHealth())
                .add(snapshot.isBloodied())
                .add(snapshot.isDead()).build();
    }

    @Override
    public UpdateOpponentStatsEvent processPacket(CreateData data, Packet packet) {
        return new UpdateOpponentStatsEvent(data.getClientId(), new ClientPlayerSnapshot(packet.getInt(0),
                packet.getInt(1), packet.getInt(2), 0, 0, packet.getBoolean(3), packet.getBoolean(4)));
    }
}
