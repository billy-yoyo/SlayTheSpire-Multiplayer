package com.billyoyo.cardcrawl.multiplayer.packets.factories;

import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlockFactory;
import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.blocks.TrueBlock;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by william on 28/01/2018.
 */
public class TrueBlockFactory extends AbstractPacketBlockFactory<TrueBlock> {
    @Override
    public BlockId getBlockId() {
        return BlockId.TRUE;
    }

    @Override
    public TrueBlock create(InputStream input) throws IOException {
        return new TrueBlock();
    }
}
