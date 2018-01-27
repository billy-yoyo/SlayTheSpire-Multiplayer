package com.billyoyo.cardcrawl.multiplayer.packets;

/**
 * Created by william on 26/01/2018.
 */
public enum BlockId {

    STRING(1),
    INTEGER(2),
    BOOLEAN(3),
    ABSTRACT_CARD(4),
    BYTE(5),
    CARD_GROUP_TYPE(6),
    ABSTRACT_RELIC(7),
    ABSTRACT_POWER(8);

    private int id;

    BlockId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
