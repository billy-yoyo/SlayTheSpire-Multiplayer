package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;

/**
 * Created by william on 26/01/2018.
 */
public class UpdateGoldEvent extends BaseClientEvent {
    private int gold;

    public UpdateGoldEvent(String clientId, int gold) {
        super(clientId, EventId.UPDATE_GOLD);
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

}
