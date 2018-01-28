package com.billyoyo.cardcrawl.multiplayer.packets.factories;

import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlockFactory;
import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.blocks.ByteBlock;
import com.billyoyo.cardcrawl.multiplayer.util.IOHelper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by william on 28/01/2018.
 */
public class ByteBlockFactory extends AbstractPacketBlockFactory<ByteBlock> {
    @Override
    public BlockId getBlockId() {
        return BlockId.BYTE;
    }

    @Override
    public ByteBlock create(InputStream input) throws IOException {
        return new ByteBlock(IOHelper.readByte(input));
    }
}
