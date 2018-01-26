package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;

/**
 * Created by william on 26/01/2018.
 */
public class UpdateHealthEvent extends BaseClientEvent {
    private int health;
    private boolean dead;
    private boolean bloodied;

    public UpdateHealthEvent(String clientId, int health, boolean dead, boolean bloodied) {
        super(clientId, EventId.UPDATE_HEALTH);
        this.health = health;
        this.dead = dead;
        this.bloodied = bloodied;
    }

    public int getHealth() {
        return health;
    }

    public boolean isDead() {
        return dead;
    }

    public boolean isBloodied() {
        return bloodied;
    }
}
