package com.billyoyo.cardcrawl.multiplayer.player;

/**
 * Created by william on 27/01/2018.
 */
public class ClientMonsterSnapshot {

    private int health;
    private int maxHealth;
    private int block;

    public ClientMonsterSnapshot(ClientMonster monster) {
        health = monster.currentHealth;
        maxHealth = monster.maxHealth;
        block = monster.currentBlock;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getBlock() {
        return block;
    }

    public void apply(ClientPlayer player) {
        player.currentHealth = getHealth();
        player.maxHealth = getMaxHealth();
        player.currentBlock = getBlock();
    }
}
