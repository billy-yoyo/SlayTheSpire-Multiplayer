package com.billyoyo.cardcrawl.multiplayer.events.listeners;

import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.EventListener;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup.AddPowerEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup.ClearPowersEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup.RemovePowerEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup.UpdatePowersEvent;

/**
 * Created by william on 28/01/2018.
 */
public class PowerGroupEventListener implements EventListener {

    public void onAddPower(AddPowerEvent event) {}
    public void onClearPowers(ClearPowersEvent event) {}
    public void onRemovePower(RemovePowerEvent event) {}
    public void onUpdatePowers(UpdatePowersEvent event) {}

    @Override
    public void notify(Event event) {
        if (event instanceof AddPowerEvent) {
            onAddPower((AddPowerEvent) event);
            return;
        }

        if (event instanceof ClearPowersEvent) {
            onClearPowers((ClearPowersEvent) event);
            return;
        }

        if (event instanceof RemovePowerEvent) {
            onRemovePower((RemovePowerEvent) event);
            return;
        }

        if (event instanceof UpdatePowersEvent) {
            onUpdatePowers((UpdatePowersEvent) event);
        }
    }
}
