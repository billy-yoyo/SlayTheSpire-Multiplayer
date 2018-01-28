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

    // card group
    CLEAR_CARDS_GROUP(7),
    CARD_APPLY_POWERS_GROUP(8),
    CARD_REMOVE_GROUP(9),
    CARD_REMOVE_ID_GROUP(10),
    CARD_ADD_GROUP(11),
    REMOVE_TOP_CARD_GROUP(12),
    UPDATE_CARDS_GROUP(13),
    DISCARD_ALL_GROUP(14),

    // relic group
    ADD_RELIC(15),
    CLEAR_RELICS(16),
    REMOVE_RELIC(17),
    UPDATE_RELICS(18),

    // power group
    ADD_POWER(19),
    CLEAR_POWERS(20),
    REMOVE_POWER(21),
    UPDATE_POWERS(22),

    // player pt. 2
    UPDATE_STATS(23),
    UPDATE_OPPONENT_STATS(24),

    // lifecycle
    START_TURN(25),
    END_TURN(26),
    CONTINUE_TURN(27),
    PLAY_CARD(28);

    private int id;

    EventId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
