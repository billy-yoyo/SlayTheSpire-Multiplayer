package com.billyoyo.cardcrawl.multiplayer.packets.factories;

import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlockFactory;
import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.blocks.NullBlock;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by william on 28/01/2018.
 */
public class NullBlockFactory extends AbstractPacketBlockFactory<NullBlock> {
    @Override
    public BlockId getBlockId() {
        return BlockId.NULL;
    }

    @Override
    public NullBlock create(InputStream input) throws IOException {
        return new NullBlock();
    }
}
