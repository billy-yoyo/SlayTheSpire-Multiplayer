package com.billyoyo.cardcrawl.multiplayer.packets.blocks;

import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketBlock;
import com.megacrit.cardcrawl.cards.AbstractCard;

import java.io.IOException;

/**
 * Created by william on 26/01/2018.
 */
public class AbstractCardBlock extends PacketBlock {

    private AbstractCard card;

    public AbstractCardBlock(AbstractCard card) {
        super(BlockId.ABSTRACT_CARD);

        this.card = card;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return new byte[0];
    }
}
