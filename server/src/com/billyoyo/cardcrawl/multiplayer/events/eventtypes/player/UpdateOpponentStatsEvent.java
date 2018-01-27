package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.player.ClientPlayerSnapshot;

/**
 * Created by william on 27/01/2018.
 */
public class UpdateOpponentStatsEvent extends BaseClientEvent {

    private ClientPlayerSnapshot snapshot;

    public UpdateOpponentStatsEvent(String clientId, ClientPlayerSnapshot snapshot) {
        super(clientId, EventId.UPDATE_OPPONENT_STATS);

        this.snapshot = snapshot;
    }

    public ClientPlayerSnapshot getSnapshot() {
        return snapshot;
    }

}
