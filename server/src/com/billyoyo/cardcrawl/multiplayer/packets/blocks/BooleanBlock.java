package com.billyoyo.cardcrawl.multiplayer.packets.blocks;

import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketBlock;

import java.io.IOException;

/**
 * Created by william on 26/01/2018.
 */
public class BooleanBlock extends PacketBlock {

    private boolean bool;

    public BooleanBlock(boolean bool) {
        super(BlockId.BOOLEAN);
        this.bool = bool;
    }


    @Override
    public byte[] getBytes() throws IOException {
        return new byte[0];
    }
}
