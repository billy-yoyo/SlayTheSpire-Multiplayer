package com.billyoyo.cardcrawl.multiplayer.packets;

import java.io.IOException;

/**
 * Created by william on 26/01/2018.
 */
public abstract class AbstractPacketBlock {

    private int blockId;

    public AbstractPacketBlock(BlockId blockId) {
        this.blockId = blockId.getId();
    }

    public int getBlockId() {
        return blockId;
    }

    public abstract byte[] getBytes() throws IOException;

}
