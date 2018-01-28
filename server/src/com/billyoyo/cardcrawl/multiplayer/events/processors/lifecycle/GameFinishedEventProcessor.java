package com.billyoyo.cardcrawl.multiplayer.events.processors.lifecycle;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.GameFinishedEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class GameFinishedEventProcessor extends EventProcessor<GameFinishedEvent> {
    @Override
    public EventId getEventId() {
        return EventId.GAME_FINISHED;
    }

    @Override
    public Packet processEvent(GameFinishedEvent event) {
        return createPacketBuilder(event)
                .add(event.getGameState().getId()).build();
    }

    @Override
    public GameFinishedEvent processPacket(CreateData data, Packet packet) {
        int ordinal = packet.getInt(0);
        return new GameFinishedEvent(data.getClientId(), GameFinishedEvent.GameState.values()[ordinal]);
    }
}
