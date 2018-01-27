package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;

/**
 * Created by william on 27/01/2018.
 */
public class ClearRelicsEvent extends BaseClientEvent {
    public ClearRelicsEvent(String clientId) {
        super(clientId, EventId.CLEAR_RELICS);
    }
}
