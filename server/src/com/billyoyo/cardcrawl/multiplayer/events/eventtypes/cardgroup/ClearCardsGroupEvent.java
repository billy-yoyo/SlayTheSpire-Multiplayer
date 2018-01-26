package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.megacrit.cardcrawl.cards.CardGroup;

/**
 * Created by william on 26/01/2018.
 */
public class ClearCardsGroupEvent extends BaseCardGroupEvent {

    public ClearCardsGroupEvent(String clientId, CardGroup.CardGroupType type) {
        super(clientId, type, EventId.CLEAR_CARDS_GROUP);
    }
}
