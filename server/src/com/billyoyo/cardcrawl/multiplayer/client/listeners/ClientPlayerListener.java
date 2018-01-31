package com.billyoyo.cardcrawl.multiplayer.client.listeners;

import com.billyoyo.cardcrawl.multiplayer.client.ClientHub;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.*;
import com.billyoyo.cardcrawl.multiplayer.events.listeners.PlayerEventListener;
import com.billyoyo.cardcrawl.multiplayer.server.player.ClientPlayerSnapshot;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

/**
 * Created by william on 30/01/2018.
 */
public class ClientPlayerListener extends PlayerEventListener {

    private ClientHub hub;

    public ClientPlayerListener(ClientHub hub) {
        this.hub = hub;
    }

    @Override
    public boolean onGainPotion(GainPotionEvent event) {
        // don't support potions for now

        return true;
    }

    @Override
    public boolean onLosePotion(LosePotionEvent event) {
        // don't support potions for now

        return true;
    }

    @Override
    public boolean onUpdateEnergy(UpdateEnergyEvent event) {

        if (AbstractDungeon.player != null) {
            AbstractDungeon.player.energy.energy = event.getEnergy();
        }

        return true;
    }

    @Override
    public boolean onUpdateGold(UpdateGoldEvent event) {

        if (AbstractDungeon.player != null) {
            AbstractDungeon.player.gold = event.getGold();
        }

        return true;
    }

    @Override
    public boolean onUpdateHealth(UpdateHealthEvent event) {

        if (AbstractDungeon.player != null) {
            AbstractDungeon.player.currentHealth = event.getHealth();
        }

        return true;
    }

    @Override
    public boolean onUpdateOpponentStats(UpdateOpponentStatsEvent event) {

        if (hub.getOpponent() != null) {
            AbstractMonster opponent = hub.getOpponent();
            ClientPlayerSnapshot snapshot = event.getSnapshot();

            opponent.currentHealth = snapshot.getHealth();
            opponent.maxHealth = snapshot.getMaxHealth();
            opponent.currentBlock = snapshot.getBlock();
            opponent.isDead = snapshot.isDead();
            opponent.isBloodied = snapshot.isBloodied();
        }

        return true;
    }

    @Override
    public boolean onUpdateStats(UpdateStatsEvent event) {

        if (AbstractDungeon.player != null) {
            ClientPlayerSnapshot snapshot = event.getSnapshot();

            AbstractDungeon.player.currentHealth = snapshot.getHealth();
            AbstractDungeon.player.maxHealth = snapshot.getMaxHealth();
            AbstractDungeon.player.energy.energy = snapshot.getEnergy();
            AbstractDungeon.player.gold = snapshot.getGold();
            AbstractDungeon.player.currentBlock = snapshot.getBlock();
            AbstractDungeon.player.isDead = snapshot.isDead();
            AbstractDungeon.player.isBloodied = snapshot.isBloodied();
        }

        return true;
    }
}
