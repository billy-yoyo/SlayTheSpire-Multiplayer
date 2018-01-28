package com.billyoyo.cardcrawl.multiplayer.packets;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by william on 28/01/2018.
 */
public abstract class AbstractPacketBlockFactory<T extends AbstractPacketBlock> {

    public abstract BlockId getBlockId();
    public abstract T create(InputStream input) throws IOException;

    public void register() {
        PacketBlockReader.register(getBlockId().getId(), this);
    }
}
