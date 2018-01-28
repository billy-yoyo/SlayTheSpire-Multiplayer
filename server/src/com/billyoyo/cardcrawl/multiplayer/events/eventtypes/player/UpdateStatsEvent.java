package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.server.player.ClientPlayerSnapshot;

/**
 * Created by william on 27/01/2018.
 */
public class UpdateStatsEvent extends BaseClientEvent {

    private ClientPlayerSnapshot snapshot;

    public UpdateStatsEvent(String clientId, ClientPlayerSnapshot snapshot) {
        super(clientId, EventId.UPDATE_STATS);

        this.snapshot = snapshot;
    }

    public ClientPlayerSnapshot getSnapshot() {
        return snapshot;
    }
}
