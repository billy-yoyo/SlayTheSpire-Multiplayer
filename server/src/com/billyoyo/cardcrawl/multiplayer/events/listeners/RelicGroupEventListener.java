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

    public boolean onAddRelic(AddRelicEvent event) { return false; }
    public boolean onClearRelics(ClearRelicsEvent event) { return false; }
    public boolean onRemoveRelic(RemoveRelicEvent event) { return false; }
    public boolean onUpdateRelics(UpdateRelicsEvent event) { return false; }

    @Override
    public boolean notify(Event event) {
        if (event instanceof AddRelicEvent) {
            return onAddRelic((AddRelicEvent) event);
        }

        if (event instanceof ClearRelicsEvent) {
            return onClearRelics((ClearRelicsEvent) event);
        }

        if (event instanceof RemoveRelicEvent) {
            return onRemoveRelic((RemoveRelicEvent) event);
        }

        if (event instanceof UpdateRelicsEvent) {
            return onUpdateRelics((UpdateRelicsEvent) event);
        }

        return false;
    }
}
