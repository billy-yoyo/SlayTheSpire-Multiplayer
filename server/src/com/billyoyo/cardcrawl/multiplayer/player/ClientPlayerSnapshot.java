package com.billyoyo.cardcrawl.multiplayer.player;

import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

/**
 * Created by william on 27/01/2018.
 */
public class ClientPlayerSnapshot {

    private final int block;
    private final int health;
    private final int maxHealth;
    private final int gold;
    private final int energy;
    private final boolean bloodied;
    private final boolean dead;

    public ClientPlayerSnapshot(ClientPlayer player) {
        this.block = player.currentBlock;
        this.health = player.currentHealth;
        this.maxHealth = player.maxHealth;
        this.gold = player.gold;
        this.energy = EnergyPanel.getCurrentEnergy();
        this.bloodied = player.isBloodied;
        this.dead = player.isDead;
    }

    public int getBlock() {
        return block;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getGold() {
        return gold;
    }

    public int getEnergy() {
        return energy;
    }

    public boolean isBloodied() {
        return bloodied;
    }

    public boolean isDead() {
        return dead;
    }
}
