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

    public boolean onAddPower(AddPowerEvent event) { return false; }
    public boolean onClearPowers(ClearPowersEvent event) { return false; }
    public boolean onRemovePower(RemovePowerEvent event) { return false; }
    public boolean onUpdatePowers(UpdatePowersEvent event) { return false; }

    @Override
    public boolean notify(Event event) {
        if (event instanceof AddPowerEvent) {
            return onAddPower((AddPowerEvent) event);
        }

        if (event instanceof ClearPowersEvent) {
            return onClearPowers((ClearPowersEvent) event);
        }

        if (event instanceof RemovePowerEvent) {
            return onRemovePower((RemovePowerEvent) event);
        }

        if (event instanceof UpdatePowersEvent) {
            return onUpdatePowers((UpdatePowersEvent) event);
        }

        return false;
    }
}
