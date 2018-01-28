package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.megacrit.cardcrawl.cards.AbstractCard;

/**
 * Created by william on 28/01/2018.
 */
public class PlayCardEvent extends BaseClientEvent {

    private AbstractCard card;

    public PlayCardEvent(String clientId, AbstractCard card) {
        super(clientId, EventId.PLAY_CARD);
        this.card = card;
    }

    public AbstractCard getCard() {
        return card;
    }
}
