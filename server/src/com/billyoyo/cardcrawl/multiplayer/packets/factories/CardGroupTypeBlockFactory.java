package com.billyoyo.cardcrawl.multiplayer.packets.factories;

import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlockFactory;
import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.blocks.CardGroupTypeBlock;
import com.billyoyo.cardcrawl.multiplayer.util.IOHelper;
import com.megacrit.cardcrawl.cards.CardGroup;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by william on 28/01/2018.
 */
public class CardGroupTypeBlockFactory extends AbstractPacketBlockFactory<CardGroupTypeBlock> {
    @Override
    public BlockId getBlockId() {
        return BlockId.CARD_GROUP_TYPE;
    }

    @Override
    public CardGroupTypeBlock create(InputStream input) throws IOException {
        int ordinal = IOHelper.readByte(input);

        return new CardGroupTypeBlock(CardGroup.CardGroupType.values()[ordinal]);
    }
}
