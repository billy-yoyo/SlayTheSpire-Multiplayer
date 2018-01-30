package com.billyoyo.cardcrawl.multiplayer.events.listeners;

import com.billyoyo.cardcrawl.multiplayer.events.EventListener;
import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.*;

/**
 * Created by william on 28/01/2018.
 */
public class CardGroupEventListener implements EventListener {

    public boolean onCardAdd(CardAddGroupEvent event) { return false; }
    public boolean onCardApplyPowers(CardApplyPowersGroupEvent event) { return false; }
    public boolean onCardRemove(CardRemoveGroupEvent event) { return false; }
    public boolean onCardRemoveId(CardRemoveIdGroupEvent event) { return false; }
    public boolean onClearCards(ClearCardsGroupEvent event) { return false; }
    public boolean onDiscardAll(DiscardAllGroupEvent event) { return false; }
    public boolean onRemoveTopCard(RemoveTopCardGroupEvent event) { return false; }
    public boolean onUpdateCards(UpdateCardsGroupEvent event) { return false; }

    @Override
    public boolean notify(Event event) {
        if (event instanceof CardAddGroupEvent) {
            return onCardAdd((CardAddGroupEvent) event);
        }

        if (event instanceof CardApplyPowersGroupEvent) {
            return onCardApplyPowers((CardApplyPowersGroupEvent) event);
        }

        if (event instanceof CardRemoveGroupEvent) {
            return onCardRemove((CardRemoveGroupEvent) event);
        }

        if (event instanceof CardRemoveIdGroupEvent) {
            return onCardRemoveId((CardRemoveIdGroupEvent) event);
        }

        if (event instanceof ClearCardsGroupEvent) {
            return onClearCards((ClearCardsGroupEvent) event);
        }

        if (event instanceof DiscardAllGroupEvent) {
            return onDiscardAll((DiscardAllGroupEvent) event);
        }

        if (event instanceof RemoveTopCardGroupEvent) {
            return onRemoveTopCard((RemoveTopCardGroupEvent) event);
        }

        if (event instanceof UpdateCardsGroupEvent) {
            return onUpdateCards((UpdateCardsGroupEvent) event);
        }

        return false;
    }

}
