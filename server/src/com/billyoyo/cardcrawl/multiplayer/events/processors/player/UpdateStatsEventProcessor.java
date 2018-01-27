package com.billyoyo.cardcrawl.multiplayer.events.processors.player;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.UpdateStatsEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;
import com.billyoyo.cardcrawl.multiplayer.player.ClientPlayerSnapshot;

/**
 * Created by william on 27/01/2018.
 */
public class UpdateStatsEventProcessor extends EventProcessor<UpdateStatsEvent> {
    @Override
    public Class<UpdateStatsEvent> getEventClass() {
        return UpdateStatsEvent.class;
    }

    @Override
    public Packet processEvent(UpdateStatsEvent event) {
        ClientPlayerSnapshot snapshot = event.getSnapshot();

        return createPacketBuilder(event)
                .add(snapshot.getHealth())
                .add(snapshot.getMaxHealth())
                .add(snapshot.getEnergy())
                .add(snapshot.getGold())
                .add(snapshot.getBlock())
                .add(snapshot.isBloodied())
                .add(snapshot.isDead()).build();
    }
}
