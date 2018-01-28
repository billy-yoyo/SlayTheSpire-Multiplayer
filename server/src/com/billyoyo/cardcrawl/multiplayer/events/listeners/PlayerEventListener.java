package com.billyoyo.cardcrawl.multiplayer.events.listeners;

import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.EventListener;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.*;

/**
 * Created by william on 28/01/2018.
 */
public class PlayerEventListener implements EventListener {

    public void onGainPotion(GainPotionEvent event) {}
    public void onLosePotion(LosePotionEvent event) {}
    public void onUpdateEnergy(UpdateEnergyEvent event) {}
    public void onUpdateGold(UpdateGoldEvent event) {}
    public void onUpdateHealth(UpdateHealthEvent event) {}
    public void onUpdateOpponentStats(UpdateOpponentStatsEvent event) {}
    public void onUpdateStats(UpdateStatsEvent event) {}

    @Override
    public void notify(Event event) {
        if (event instanceof GainPotionEvent) {
            onGainPotion((GainPotionEvent) event);
            return;
        }

        if (event instanceof LosePotionEvent) {
            onLosePotion((LosePotionEvent) event);
            return;
        }

        if (event instanceof UpdateEnergyEvent) {
            onUpdateEnergy((UpdateEnergyEvent) event);
            return;
        }

        if (event instanceof UpdateGoldEvent) {
            onUpdateGold((UpdateGoldEvent) event);
            return;
        }

        if (event instanceof UpdateHealthEvent) {
            onUpdateHealth((UpdateHealthEvent) event);
            return;
        }

        if (event instanceof UpdateOpponentStatsEvent) {
            onUpdateOpponentStats((UpdateOpponentStatsEvent) event);
            return;
        }

        if (event instanceof UpdateStatsEvent) {
            onUpdateStats((UpdateStatsEvent) event);
        }
    }
}
