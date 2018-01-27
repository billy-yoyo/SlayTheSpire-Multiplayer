package com.billyoyo.cardcrawl.multiplayer.events.processors.player;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.UpdateOpponentStatsEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;
import com.billyoyo.cardcrawl.multiplayer.player.ClientPlayerSnapshot;

/**
 * Created by william on 27/01/2018.
 */
public class UpdateOpponentStatsEventProcessor extends EventProcessor<UpdateOpponentStatsEvent> {
    @Override
    public Class<UpdateOpponentStatsEvent> getEventClass() {
        return UpdateOpponentStatsEvent.class;
    }

    @Override
    public Packet processEvent(UpdateOpponentStatsEvent event) {
        ClientPlayerSnapshot snapshot = event.getSnapshot();

        return createPacketBuilder(event)
                .add(snapshot.getHealth())
                .add(snapshot.getMaxHealth())
                .add(snapshot.getBlock())
                .add(snapshot.isBloodied())
                .add(snapshot.isDead()).build();
    }
}
