package com.billyoyo.cardcrawl.multiplayer.packets.blocks;

import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketBlock;
import com.megacrit.cardcrawl.cards.CardGroup;

import java.io.IOException;

/**
 * Created by william on 26/01/2018.
 */
public class CardGroupTypeBlock extends PacketBlock {

    private CardGroup.CardGroupType type;

    public CardGroupTypeBlock(CardGroup.CardGroupType type) {
        super(BlockId.CARD_GROUP_TYPE);
        this.type = type;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return new byte[0];
    }
}
