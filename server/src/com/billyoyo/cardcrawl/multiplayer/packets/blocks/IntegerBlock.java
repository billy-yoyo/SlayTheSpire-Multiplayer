package com.billyoyo.cardcrawl.multiplayer.packets.blocks;

import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlock;
import com.billyoyo.cardcrawl.multiplayer.util.IOHelper;

import java.io.IOException;

/**
 * Created by william on 26/01/2018.
 */
public class IntegerBlock extends AbstractPacketBlock {

    private int value;

    public IntegerBlock(int value) {
        super(BlockId.INTEGER);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return IOHelper.bytesForNumber(value);
    }
}
