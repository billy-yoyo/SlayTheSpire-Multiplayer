package com.billyoyo.cardcrawl.multiplayer.packets.blocks;

import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketBlock;

import java.io.IOException;

/**
 * Created by william on 26/01/2018.
 */
public class ByteBlock extends PacketBlock {

    private int b;

    public ByteBlock(int b) {
        super(BlockId.BYTE);
        this.b = b;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return new byte[0];
    }
}
