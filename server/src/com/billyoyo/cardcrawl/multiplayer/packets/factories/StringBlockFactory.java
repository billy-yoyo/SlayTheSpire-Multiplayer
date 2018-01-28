package com.billyoyo.cardcrawl.multiplayer.packets.factories;

import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlockFactory;
import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.blocks.StringBlock;
import com.billyoyo.cardcrawl.multiplayer.util.IOHelper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by william on 28/01/2018.
 */
public class StringBlockFactory extends AbstractPacketBlockFactory<StringBlock> {
    @Override
    public BlockId getBlockId() {
        return BlockId.STRING;
    }

    @Override
    public StringBlock create(InputStream input) throws IOException {
        return new StringBlock(IOHelper.readString(input));
    }
}
