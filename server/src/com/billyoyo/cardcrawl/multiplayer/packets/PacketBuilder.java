package com.billyoyo.cardcrawl.multiplayer.packets;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractCardDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.AbstractRelicDTO;
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
    private List<AbstractPacketBlock> blocks = new ArrayList<>();

    public PacketBuilder setEventId(int eventId) {
        this.eventId = eventId;
        return this;
    }

    public PacketBuilder add(AbstractPacketBlock block) {
        blocks.add(block);
        return this;
    }

    public PacketBuilder addNull() {
        add(new NullBlock());
        return this;
    }

    public PacketBuilder add(String block) {
        if (block == null) {
            return addNull();
        }
        return add(new StringBlock(block));
    }

    public PacketBuilder add(int block) {
        return add(new IntegerBlock(block));
    }

    public PacketBuilder addByte(int block) {
        return add(new ByteBlock(block));
    }

    public PacketBuilder add(boolean block) {
        if (block) {
            return add(new TrueBlock());
        } else {
            return add(new FalseBlock());
        }
    }

    public PacketBuilder add(AbstractCardDTO block) {
        if (block == null) {
            return addNull();
        }
        return add(new AbstractCardBlock(block));
    }

    public PacketBuilder add(AbstractCard block) {
        if (block == null) {
            return addNull();
        }
        return add(new AbstractCardBlock(block));
    }

    public PacketBuilder add(CardGroup.CardGroupType block) {
        if (block == null) {
            return addNull();
        }
        return add(new CardGroupTypeBlock(block));
    }

    public PacketBuilder add(AbstractRelicDTO block) {
        if (block == null) {
            return addNull();
        }
        return add(new AbstractRelicBlock(block));
    }

    public PacketBuilder add(AbstractRelic block) {
        if (block == null) {
            return addNull();
        }
        return add(new AbstractRelicBlock(block));
    }

    public PacketBuilder add(AbstractPowerDTO block) {
        if (block == null) {
            return addNull();
        }
        return add(new AbstractPowerBlock(block));
    }

    public PacketBuilder add(AbstractPower block) {
        if (block == null) {
            return addNull();
        }
        return add(new AbstractPowerBlock(block));
    }

    public Packet build() {
        return new Packet(eventId, blocks);
    }
}
