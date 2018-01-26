package com.billyoyo.cardcrawl.multiplayer.packets.blocks;

import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketBlock;

import java.io.IOException;

/**
 * Created by william on 26/01/2018.
 */
public class IntegerBlock extends PacketBlock {

    private int value;

    public IntegerBlock(int value) {
        super(BlockId.INTEGER);
        this.value = value;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return new byte[0];
    }
}
