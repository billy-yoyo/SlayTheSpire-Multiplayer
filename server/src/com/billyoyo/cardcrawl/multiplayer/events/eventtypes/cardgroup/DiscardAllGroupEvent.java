package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.megacrit.cardcrawl.cards.CardGroup;

/**
 * Created by william on 27/01/2018.
 */
public class DiscardAllGroupEvent extends BaseCardGroupEvent {
    public DiscardAllGroupEvent(String clientId, CardGroup.CardGroupType type) {
        super(clientId, type, EventId.DISCARD_ALL_GROUP);
    }
}
