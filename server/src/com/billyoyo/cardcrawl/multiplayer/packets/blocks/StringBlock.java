package com.billyoyo.cardcrawl.multiplayer.packets.blocks;

import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlock;
import com.billyoyo.cardcrawl.multiplayer.util.IOHelper;

import java.io.IOException;

/**
 * Created by william on 26/01/2018.
 */
public class StringBlock extends AbstractPacketBlock {

    private String string;

    public StringBlock(String string) {
        super(BlockId.STRING);
        this.string = string;
    }

    public String getString() {
        return string;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return IOHelper.bytesForString(string);
    }
}
