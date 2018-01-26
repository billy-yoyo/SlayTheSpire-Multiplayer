package com.billyoyo.cardcrawl.multiplayer.packets;

import com.billyoyo.cardcrawl.multiplayer.packets.blocks.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 26/01/2018.
 */
public class PacketBuilder {

    private int eventId = -1;
    private List<PacketBlock> blocks = new ArrayList<>();

    public PacketBuilder setEventId(int eventId) {
        this.eventId = eventId;
        return this;
    }

    public PacketBuilder add(PacketBlock block) {
        blocks.add(block);
        return this;
    }

    public PacketBuilder add(String block) {
        return add(new StringBlock(block));
    }

    public PacketBuilder add(int block) {
        return add(new IntegerBlock(block));
    }

    public PacketBuilder addByte(int block) {
        return add(new ByteBlock(block));
    }

    public PacketBuilder add(boolean block) {
        return add(new BooleanBlock(block));
    }

    public PacketBuilder add(AbstractCard card) {
        return add(new AbstractCardBlock(card));
    }

    public PacketBuilder add(CardGroup.CardGroupType type) {
        return add(new CardGroupTypeBlock(type));
    }

    public Packet build() {
        return new Packet(eventId, (PacketBlock[]) blocks.toArray());
    }
}
