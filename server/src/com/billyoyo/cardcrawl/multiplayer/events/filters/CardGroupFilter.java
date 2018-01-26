package com.billyoyo.cardcrawl.multiplayer.events.filters;

import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.EventFilter;
import com.billyoyo.cardcrawl.multiplayer.events.EventManager;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.*;
import com.megacrit.cardcrawl.cards.CardGroup;

/**
 * Created by william on 26/01/2018.
 */
public class CardGroupFilter extends EventFilter<BaseCardGroupEvent> {

    private static final Class<? extends Event>[] FILTERED_CLASSES = new Class[] {
            CardAddGroupEvent.class,
            CardApplyPowersGroupEvent.class,
            CardRemoveGroupEvent.class,
            CardRemoveIdGroupEvent.class,
            CardRemoveGroupEvent.class,
            ClearCardsGroupEvent.class,
            RemoveTopCardGroupEvent.class
    };

    @Override
    public Class<BaseCardGroupEvent> getEventClass() {
        return BaseCardGroupEvent.class;
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
        for (Class<? extends Event> clazz : FILTERED_CLASSES) {
            manager.registerFilter(clazz, this);
        }
    }
}
