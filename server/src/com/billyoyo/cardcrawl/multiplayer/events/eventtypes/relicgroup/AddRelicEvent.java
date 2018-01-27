package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.megacrit.cardcrawl.relics.AbstractRelic;

/**
 * Created by william on 27/01/2018.
 */
public class AddRelicEvent extends BaseClientEvent {

    private AbstractRelic relic;

    public AddRelicEvent(String clientId, AbstractRelic relic) {
        super(clientId, EventId.ADD_RELIC);

        this.relic = relic;
    }

    public AbstractRelic getRelic() {
        return relic;
    }
}
