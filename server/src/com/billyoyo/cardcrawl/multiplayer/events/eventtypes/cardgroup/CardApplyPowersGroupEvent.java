package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.megacrit.cardcrawl.cards.CardGroup;

/**
 * Created by william on 26/01/2018.
 */
public class CardApplyPowersGroupEvent extends BaseCardGroupEvent {

    public CardApplyPowersGroupEvent(String clientId, CardGroup.CardGroupType type) {
        super(clientId, type, EventId.CARD_APPLY_POWERS_GROUP);
    }
}
