package com.billyoyo.cardcrawl.multiplayer.events.listeners;

import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.EventListener;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.AddRelicEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.ClearRelicsEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.RemoveRelicEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.UpdateRelicsEvent;

/**
 * Created by william on 28/01/2018.
 */
public class RelicGroupEventListener implements EventListener {

    public void onAddRelic(AddRelicEvent event) {}
    public void onClearRelics(ClearRelicsEvent event) {}
    public void onRemoveRelic(RemoveRelicEvent event) {}
    public void onUpdateRelics(UpdateRelicsEvent event) {}

    @Override
    public void notify(Event event) {
        if (event instanceof AddRelicEvent) {
            onAddRelic((AddRelicEvent) event);
            return;
        }

        if (event instanceof ClearRelicsEvent) {
            onClearRelics((ClearRelicsEvent) event);
            return;
        }

        if (event instanceof RemoveRelicEvent) {
            onRemoveRelic((RemoveRelicEvent) event);
            return;
        }

        if (event instanceof UpdateRelicsEvent) {
            onUpdateRelics((UpdateRelicsEvent) event);
            return;
        }
    }
}
