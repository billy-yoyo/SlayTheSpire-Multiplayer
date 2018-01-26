package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.megacrit.cardcrawl.cards.CardGroup;

/**
 * Created by william on 26/01/2018.
 */
public class CardRemoveIdGroupEvent extends BaseCardGroupEvent {

    private String targetId;

    public CardRemoveIdGroupEvent(String clientId, CardGroup.CardGroupType type, String targetId) {
        super(clientId, type, EventId.CARD_REMOVE_ID_GROUP);
        this.targetId = targetId;
    }

    public String getTargetId() {
        return targetId;
    }
}
