package com.billyoyo.cardcrawl.multiplayer.packets.blocks;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractRelicDTO;
import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketBlock;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import java.io.IOException;

/**
 * Created by william on 27/01/2018.
 */
public class AbstractRelicBlock extends PacketBlock {

    private final AbstractRelicDTO relic;

    public AbstractRelicBlock(AbstractRelicDTO relic) {
        super(BlockId.ABSTRACT_RELIC);

        this.relic = relic;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return new byte[0];
    }
}
