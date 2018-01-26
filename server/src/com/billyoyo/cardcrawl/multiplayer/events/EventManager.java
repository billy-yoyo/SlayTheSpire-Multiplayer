package com.billyoyo.cardcrawl.multiplayer.events;

import com.billyoyo.cardcrawl.multiplayer.events.filters.CardGroupFilter;
import com.billyoyo.cardcrawl.multiplayer.events.processors.cardgroup.*;
import com.billyoyo.cardcrawl.multiplayer.events.processors.player.*;
import com.billyoyo.cardcrawl.multiplayer.server.ServerHub;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by william on 26/01/2018.
 */
public class EventManager {

    private Map<Class<? extends Event>, EventProcessor> processorMap;
    private Map<Class<? extends Event>, EventFilter> filterMap;
    private ServerHub hub;

    public EventManager(ServerHub hub) {
        this.hub = hub;
        this.processorMap = new HashMap<>();
        this.filterMap = new HashMap<>();

        initializeProcessors();
        initializeFilters();
    }

    // register all processors
    private void initializeProcessors() {
        // player
        new UpdateGoldEventProcessor().registerProcessor(this);
        new GainPotionEventProcessor().registerProcessor(this);
        new GameFinishedEventProcessor().registerProcessor(this);
        new LosePotionEventProcessor().registerProcessor(this);
        new UpdateEnergyEventProcessor().registerProcessor(this);
        new UpdateHealthEventProcessor().registerProcessor(this);

        // cardgroup
        new ClearCardsGroupEventProcessor().registerProcessor(this);
        new CardApplyPowersGroupEventProcessor().registerProcessor(this);
        new CardRemoveGroupEventProcessor().registerProcessor(this);
        new CardRemoveIdGroupEventProcessor().registerProcessor(this);
        new CardAddGroupEventProcessor().registerProcessor(this);
        new RemoveTopCardGroupEventProcessor().registerProcessor(this);
    }

    // register all filters
    private void initializeFilters() {
        new CardGroupFilter().registerFilter(this);

    }

    public void registerEventProcessor(Class<? extends Event> eventType, EventProcessor eventProcessor) {
        processorMap.put(eventType, eventProcessor);
    }

    public void registerFilter(Class<? extends Event> eventType, EventFilter eventFilter) {
        filterMap.put(eventType, eventFilter);
    }

    private Event filterEvent(Event event) {
        Class<? extends Event> eventClass = event.getClass();

        if (filterMap.containsKey(eventClass)) {
            event = filterMap.get(eventClass).filter(event);
        }

        return event;
    }

    public void post(Event event) {
        try {
            event = filterEvent(event);
            if (event != null) {
                processorMap.get(event.getClass()).sendPacket(hub, event);
            }
        } catch (Exception e) {
            // fail event
        }
    }
}
