package com.billyoyo.cardcrawl.multiplayer.events;

import com.billyoyo.cardcrawl.multiplayer.base.Hub;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.InvalidEvent;
import com.billyoyo.cardcrawl.multiplayer.events.filters.CardGroupFilter;
import com.billyoyo.cardcrawl.multiplayer.events.processors.cardgroup.*;
import com.billyoyo.cardcrawl.multiplayer.events.processors.lifecycle.*;
import com.billyoyo.cardcrawl.multiplayer.events.processors.player.*;
import com.billyoyo.cardcrawl.multiplayer.events.processors.powergroup.AddPowerEventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.processors.powergroup.ClearPowersEventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.processors.powergroup.RemovePowerEventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.processors.powergroup.UpdatePowersEventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.processors.relicgroup.AddRelicEventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.processors.relicgroup.ClearRelicsEventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.processors.relicgroup.RemoveRelicEventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.processors.relicgroup.UpdateRelicsEventProcessor;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by william on 26/01/2018.
 */
public class EventManager {

    private static final Logger log = Logger.getLogger(EventManager.class.getName());

    private Map<Integer, EventProcessor> processorMap;
    private Map<Integer, EventFilter> filterMap;
    private List<EventListener> listeners;
    private Hub hub;

    public EventManager(Hub hub) {
        this.hub = hub;
        this.processorMap = new HashMap<>();
        this.filterMap = new HashMap<>();
        this.listeners = new ArrayList<>();

        initializeProcessors();
        initializeFilters();
    }

    // register all processors
    private void initializeProcessors() {
        // player
        new UpdateGoldEventProcessor().registerProcessor(this);
        new GainPotionEventProcessor().registerProcessor(this);
        new LosePotionEventProcessor().registerProcessor(this);
        new UpdateEnergyEventProcessor().registerProcessor(this);
        new UpdateHealthEventProcessor().registerProcessor(this);
        new UpdateOpponentStatsEventProcessor().registerProcessor(this);
        new UpdateStatsEventProcessor().registerProcessor(this);

        // cardgroup
        new ClearCardsGroupEventProcessor().registerProcessor(this);
        new CardApplyPowersGroupEventProcessor().registerProcessor(this);
        new CardRemoveGroupEventProcessor().registerProcessor(this);
        new CardRemoveIdGroupEventProcessor().registerProcessor(this);
        new CardAddGroupEventProcessor().registerProcessor(this);
        new RemoveTopCardGroupEventProcessor().registerProcessor(this);
        new UpdateCardsGroupEventProcessor().registerProcessor(this);
        new DiscardAllGroupEventProcessor().registerProcessor(this);

        // relicgroup
        new AddRelicEventProcessor().registerProcessor(this);
        new ClearRelicsEventProcessor().registerProcessor(this);
        new RemoveRelicEventProcessor().registerProcessor(this);
        new UpdateRelicsEventProcessor().registerProcessor(this);

        // powergroup
        new AddPowerEventProcessor().registerProcessor(this);
        new ClearPowersEventProcessor().registerProcessor(this);
        new RemovePowerEventProcessor().registerProcessor(this);
        new UpdatePowersEventProcessor().registerProcessor(this);

        // lifecycle
        new EndTurnEventProcessor().registerProcessor(this);
        new StartTurnEventProcessor().registerProcessor(this);
        new ContinueTurnEventProcessor().registerProcessor(this);
        new GameFinishedEventProcessor().registerProcessor(this);
        new PlayCardEventProcessor().registerProcessor(this);
        new ReadyEventProcessor().registerProcessor(this);
        new OutOfOrderEventProcessor().registerProcessor(this);
        new InvalidEventProcessor().registerProcessor(this);
    }

    // register all filters
    private void initializeFilters() {
        new CardGroupFilter().registerFilter(this);
    }

    public void registerEventProcessor(int eventId, EventProcessor eventProcessor) {
        processorMap.put(eventId, eventProcessor);
    }

    public void registerFilter(int eventId, EventFilter eventFilter) {
        filterMap.put(eventId, eventFilter);
    }

    public void registerListener(EventListener listener) {
        listeners.add(listener);
    }

    private Event filterEvent(Event event) {
        if (filterMap.containsKey(event.getEventId())) {
            event = filterMap.get(event.getEventId()).filter(event);
        }

        return event;
    }

    public void post(Event event) {
        try {
            event = filterEvent(event);
            if (event != null) {
                Packet packet = processorMap.get(event.getEventId()).processEvent(event);
                hub.sendPacket(event.getClientId(), packet);
            }
        } catch (Exception e) {
            // fail event
            log.warning("failed to post event with id " + event.getEventId());
            throw new EventException("failed to post event with id " + event.getEventId());
        }
    }

    public boolean notifyListeners(Event event) {
        boolean accepted = false;
        for (EventListener listener : listeners) {
            if (listener.notify(event)) {
                accepted = true;
            }
        }
        return accepted;
    }

    public void receive(CreateData data, Packet packet) {
        try {
            EventProcessor processor = processorMap.get(packet.getEventId());
            Event event = processor.processPacket(data, packet);

            boolean eventAccepted = notifyListeners(event);
            if (!eventAccepted) {
                hub.postEvent(new InvalidEvent(data.getClientId(), event));
            }
        } catch (Exception e) {
            // failed to receive event
            log.warning("failed to receive event with id " + packet.getEventId());
            throw new EventException("failed to receive event with id " + packet.getEventId(), e);
        }
    }
}
