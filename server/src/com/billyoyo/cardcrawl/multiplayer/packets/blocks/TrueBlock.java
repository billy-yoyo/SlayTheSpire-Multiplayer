package com.billyoyo.cardcrawl.multiplayer.packets.blocks;

import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlock;

import java.io.IOException;

/**
 * Created by william on 28/01/2018.
 */
public class TrueBlock extends AbstractPacketBlock {

    public TrueBlock() {
        super(BlockId.TRUE);
    }

    @Override
    public byte[] getBytes() throws IOException {
        return new byte[0];
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof TrueBlock;
    }
}
