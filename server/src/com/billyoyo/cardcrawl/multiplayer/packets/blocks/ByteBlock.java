package com.billyoyo.cardcrawl.multiplayer.packets.blocks;

import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlock;
import com.billyoyo.cardcrawl.multiplayer.util.IOHelper;

import java.io.IOException;

/**
 * Created by william on 26/01/2018.
 */
public class ByteBlock extends AbstractPacketBlock {

    private int b;

    public ByteBlock(int b) {
        super(BlockId.BYTE);
        this.b = b;
    }

    public int getValue() {
        return b;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return IOHelper.bytesForSingleByteInt(b);
    }
}
