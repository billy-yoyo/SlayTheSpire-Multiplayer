package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;

import java.util.List;

/**
 * Created by william on 27/01/2018.
 */
public class UpdateCardsGroupEvent extends BaseCardGroupEvent {

    private List<AbstractCard> cards;

    public UpdateCardsGroupEvent(String clientId, CardGroup.CardGroupType type,
                                 List<AbstractCard> cards) {
        super(clientId, type, EventId.UPDATE_CARDS_GROUP);

        this.cards = cards;
    }

    public List<AbstractCard> getCards() {
        return cards;
    }

}
