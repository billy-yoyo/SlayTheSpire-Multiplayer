package com.billyoyo.cardcrawl.multiplayer.packets;

/**
 * Created by william on 26/01/2018.
 */
public enum BlockId {

    STRING(1),
    INTEGER(2),
    TRUE(3),
    FALSE(4),
    ABSTRACT_CARD(5),
    BYTE(6),
    CARD_GROUP_TYPE(7),
    ABSTRACT_RELIC(8),
    ABSTRACT_POWER(9),
    NULL(10);

    private int id;

    BlockId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
