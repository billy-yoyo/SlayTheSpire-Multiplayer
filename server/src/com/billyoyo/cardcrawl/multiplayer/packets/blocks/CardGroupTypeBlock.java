package com.billyoyo.cardcrawl.multiplayer.packets.blocks;

import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlock;
import com.billyoyo.cardcrawl.multiplayer.util.IOHelper;
import com.megacrit.cardcrawl.cards.CardGroup;

import java.io.IOException;

/**
 * Created by william on 26/01/2018.
 */
public class CardGroupTypeBlock extends AbstractPacketBlock {

    private CardGroup.CardGroupType type;

    public CardGroupTypeBlock(CardGroup.CardGroupType type) {
        super(BlockId.CARD_GROUP_TYPE);
        this.type = type;
    }

    public CardGroup.CardGroupType getCardType() {
        return type;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return IOHelper.bytesForSingleByteInt(type.ordinal());
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CardGroupTypeBlock && equals((CardGroupTypeBlock) obj);
    }

    private boolean equals(CardGroupTypeBlock block) {
        return block.getCardType().equals(getCardType());
    }
}
