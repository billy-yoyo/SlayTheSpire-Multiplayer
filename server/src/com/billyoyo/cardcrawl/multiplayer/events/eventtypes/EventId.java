package com.billyoyo.cardcrawl.multiplayer.events.eventtypes;

/**
 * Created by william on 26/01/2018.
 */
public enum EventId {

    // player
    GAIN_POTION(1),
    GAME_FINISHED(2),
    LOSE_POTION(3),
    UPDATE_ENERGY(4),
    UPDATE_GOLD(5),
    UPDATE_HEALTH(6),

    // card groups
    CLEAR_CARDS_GROUP(7),
    CARD_APPLY_POWERS_GROUP(8),
    CARD_REMOVE_GROUP(9),
    CARD_REMOVE_ID_GROUP(10),
    CARD_ADD_GROUP(11),
    REMOVE_TOP_CARD_GROUP(12);


    private int id;

    EventId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
