package com.billyoyo.cardcrawl.multiplayer.packets;

import com.billyoyo.cardcrawl.multiplayer.packets.blocks.*;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.relics.AbstractRelic;

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

    public PacketBuilder add(AbstractCard block) {
        return add(new AbstractCardBlock(block));
    }

    public PacketBuilder add(CardGroup.CardGroupType block) {
        return add(new CardGroupTypeBlock(block));
    }

    public PacketBuilder add(AbstractRelic block) {
        return add(new AbstractRelicBlock(block));
    }

    public PacketBuilder add(AbstractPower block) {
        return add(new AbstractPowerBlock(block));
    }

    public Packet build() {
        return new Packet(eventId, (PacketBlock[]) blocks.toArray());
    }
}
