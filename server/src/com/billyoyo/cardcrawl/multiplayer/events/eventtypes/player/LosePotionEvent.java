package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;

/**
 * Created by william on 26/01/2018.
 */
public class LosePotionEvent extends BaseClientEvent {

    private String potionId;

    public LosePotionEvent(String clientId, String potionId) {
        super(clientId, EventId.LOSE_POTION);

        this.potionId = potionId;
    }

    public String getPotionId() {
        return potionId;
    }
}
