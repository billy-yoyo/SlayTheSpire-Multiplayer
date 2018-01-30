package com.billyoyo.cardcrawl.multiplayer.events.listeners;

import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.EventListener;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.*;

/**
 * Created by william on 28/01/2018.
 */
public class PlayerEventListener implements EventListener {

    public boolean onGainPotion(GainPotionEvent event) { return false; }
    public boolean onLosePotion(LosePotionEvent event) { return false; }
    public boolean onUpdateEnergy(UpdateEnergyEvent event) { return false; }
    public boolean onUpdateGold(UpdateGoldEvent event) { return false; }
    public boolean onUpdateHealth(UpdateHealthEvent event) { return false; }
    public boolean onUpdateOpponentStats(UpdateOpponentStatsEvent event) { return false; }
    public boolean onUpdateStats(UpdateStatsEvent event) { return false; }

    @Override
    public boolean notify(Event event) {
        if (event instanceof GainPotionEvent) {
            return onGainPotion((GainPotionEvent) event);
        }

        if (event instanceof LosePotionEvent) {
            return onLosePotion((LosePotionEvent) event);
        }

        if (event instanceof UpdateEnergyEvent) {
            return onUpdateEnergy((UpdateEnergyEvent) event);
        }

        if (event instanceof UpdateGoldEvent) {
            return onUpdateGold((UpdateGoldEvent) event);
        }

        if (event instanceof UpdateHealthEvent) {
            return onUpdateHealth((UpdateHealthEvent) event);
        }

        if (event instanceof UpdateOpponentStatsEvent) {
            return onUpdateOpponentStats((UpdateOpponentStatsEvent) event);
        }

        if (event instanceof UpdateStatsEvent) {
            return onUpdateStats((UpdateStatsEvent) event);
        }

        return false;
    }
}
