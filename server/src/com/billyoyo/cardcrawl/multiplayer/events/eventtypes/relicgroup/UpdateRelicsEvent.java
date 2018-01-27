package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import java.util.List;

/**
 * Created by william on 27/01/2018.
 */
public class UpdateRelicsEvent extends BaseClientEvent {

    private List<AbstractRelic> relics;

    public UpdateRelicsEvent(String clientId, List<AbstractRelic> relics) {
        super(clientId, EventId.UPDATE_RELICS);

        this.relics = relics;
    }

    public List<AbstractRelic> getRelics() {
        return relics;
    }
}
