package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.megacrit.cardcrawl.cards.CardGroup;

/**
 * Created by william on 26/01/2018.
 */
public abstract class BaseCardGroupEvent extends BaseClientEvent {

    private CardGroup.CardGroupType type;

    public BaseCardGroupEvent(String clientId, CardGroup.CardGroupType type, EventId eventId) {
        super(clientId, eventId);
        this.type = type;
    }

    public CardGroup.CardGroupType getCardGroupType() {
        return type;
    }

}
