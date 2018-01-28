package com.billyoyo.cardcrawl.multiplayer.packets.factories;

import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlockFactory;
import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.blocks.IntegerBlock;
import com.billyoyo.cardcrawl.multiplayer.util.IOHelper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by william on 28/01/2018.
 */
public class IntegerBlockFactory extends AbstractPacketBlockFactory<IntegerBlock> {
    @Override
    public BlockId getBlockId() {
        return BlockId.INTEGER;
    }

    @Override
    public IntegerBlock create(InputStream input) throws IOException {
        return new IntegerBlock(IOHelper.readNumber(input));
    }
}
