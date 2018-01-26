package com.billyoyo.cardcrawl.multiplayer.packets.blocks;

import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketBlock;

import java.io.IOException;

/**
 * Created by william on 26/01/2018.
 */
public class StringBlock extends PacketBlock {

    private String string;

    public StringBlock(String string) {
        super(BlockId.STRING);
        this.string = string;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return new byte[0];
    }
}
