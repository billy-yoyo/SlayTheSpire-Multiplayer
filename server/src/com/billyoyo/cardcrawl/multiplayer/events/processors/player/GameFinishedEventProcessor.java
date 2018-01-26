package com.billyoyo.cardcrawl.multiplayer.events.processors.player;

import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.GameFinishedEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class GameFinishedEventProcessor extends EventProcessor<GameFinishedEvent> {
    @Override
    public Class<GameFinishedEvent> getEventClass() {
        return GameFinishedEvent.class;
    }

    @Override
    public Packet processEvent(GameFinishedEvent event) {
        return createPacketBuilder(event)
                .add(event.getEventId())
                .add(event.getGameState().getId()).build();
    }
}
