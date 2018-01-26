package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;

/**
 * Created by william on 26/01/2018.
 */
public class CardRemoveGroupEvent extends BaseCardGroupEvent {

    private AbstractCard card;

    public CardRemoveGroupEvent(String clientId, CardGroup.CardGroupType type, AbstractCard card) {
        super(clientId, type, EventId.CARD_REMOVE_GROUP);
        this.card = card;
    }

    public AbstractCard getCard() {
        return card;
    }

}
