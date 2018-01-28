package com.billyoyo.cardcrawl.multiplayer.events.filters;

import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.EventFilter;
import com.billyoyo.cardcrawl.multiplayer.events.EventManager;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.*;
import com.megacrit.cardcrawl.cards.CardGroup;

/**
 * Created by william on 26/01/2018.
 */
public class CardGroupFilter extends EventFilter<BaseCardGroupEvent> {

    private static final int[] FILTERED_CLASSES = new int[] {
            EventId.CARD_ADD_GROUP.getId(),
            EventId.CARD_APPLY_POWERS_GROUP.getId(),
            EventId.CARD_REMOVE_GROUP.getId(),
            EventId.CARD_REMOVE_ID_GROUP.getId(),
            EventId.CLEAR_CARDS_GROUP.getId(),
            EventId.REMOVE_TOP_CARD_GROUP.getId(),
            EventId.UPDATE_CARDS_GROUP.getId(),
            EventId.DISCARD_ALL_GROUP.getId()
    };

    @Override
    public int getEventId() {
        return -1;
    }

    @Override
    public Event filter(BaseCardGroupEvent event) {
        if (event.getCardGroupType().equals(CardGroup.CardGroupType.UNSPECIFIED)) {
            return null;
        }

        return event;
    }

    @Override
    public void registerFilter(EventManager manager) {
        for (int eventId : FILTERED_CLASSES) {
            manager.registerFilter(eventId, this);
        }
    }
}
