package com.billyoyo.cardcrawl.multiplayer.packets.factories;

import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlockFactory;
import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.blocks.FalseBlock;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by william on 28/01/2018.
 */
public class FalseBlockFactory extends AbstractPacketBlockFactory<FalseBlock> {
    @Override
    public BlockId getBlockId() {
        return BlockId.FALSE;
    }

    @Override
    public FalseBlock create(InputStream input) throws IOException {
        return new FalseBlock();
    }
}
