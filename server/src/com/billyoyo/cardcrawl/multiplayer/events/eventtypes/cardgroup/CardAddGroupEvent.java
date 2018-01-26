package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;

/**
 * Created by william on 26/01/2018.
 */
public class CardAddGroupEvent extends BaseCardGroupEvent {

    private AbstractCard card;
    private int position;

    public CardAddGroupEvent(String clientId, CardGroup.CardGroupType type, AbstractCard card, int position) {
        super(clientId, type, EventId.CARD_ADD_GROUP);
        this.card = card;
        this.position = position;
    }

    public AbstractCard getCard() {
        return card;
    }

    public int getPosition() {
        return position;
    }

}
