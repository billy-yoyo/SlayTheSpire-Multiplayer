package com.billyoyo.cardcrawl.multiplayer.events.listeners;

import com.billyoyo.cardcrawl.multiplayer.events.EventListener;
import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.*;

/**
 * Created by william on 28/01/2018.
 */
public class CardGroupEventListener implements EventListener {

    public void onCardAdd(CardAddGroupEvent event) {}
    public void onCardApplyPowers(CardApplyPowersGroupEvent event) {}
    public void onCardRemove(CardRemoveGroupEvent event) {}
    public void onCardRemoveId(CardRemoveIdGroupEvent event) {}
    public void onClearCards(ClearCardsGroupEvent event) {}
    public void onDiscardAll(DiscardAllGroupEvent event) {}
    public void onRemoveTopCard(RemoveTopCardGroupEvent event) {}
    public void onUpdateCards(UpdateCardsGroupEvent event) {}

    @Override
    public void notify(Event event) {
        if (event instanceof CardAddGroupEvent) {
            onCardAdd((CardAddGroupEvent) event);
            return;
        }

        if (event instanceof CardApplyPowersGroupEvent) {
            onCardApplyPowers((CardApplyPowersGroupEvent) event);
            return;
        }

        if (event instanceof CardRemoveGroupEvent) {
            onCardRemove((CardRemoveGroupEvent) event);
            return;
        }

        if (event instanceof CardRemoveIdGroupEvent) {
            onCardRemoveId((CardRemoveIdGroupEvent) event);
            return;
        }

        if (event instanceof ClearCardsGroupEvent) {
            onClearCards((ClearCardsGroupEvent) event);
            return;
        }

        if (event instanceof DiscardAllGroupEvent) {
            onDiscardAll((DiscardAllGroupEvent) event);
            return;
        }

        if (event instanceof RemoveTopCardGroupEvent) {
            onRemoveTopCard((RemoveTopCardGroupEvent) event);
            return;
        }

        if (event instanceof UpdateCardsGroupEvent) {
            onUpdateCards((UpdateCardsGroupEvent) event);
        }
    }

}
