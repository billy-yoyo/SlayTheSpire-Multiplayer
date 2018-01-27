package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.megacrit.cardcrawl.relics.AbstractRelic;

/**
 * Created by william on 27/01/2018.
 */
public class RemoveRelicEvent extends BaseClientEvent {

    private AbstractRelic relic;

    public RemoveRelicEvent(String clientId, AbstractRelic relic) {
        super(clientId, EventId.REMOVE_RELIC);
        this.relic = relic;
    }

    public AbstractRelic getRelic() {
        return relic;
    }
}
