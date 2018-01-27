package com.billyoyo.cardcrawl.multiplayer.packets.blocks;

import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketBlock;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.io.IOException;

/**
 * Created by william on 27/01/2018.
 */
public class AbstractPowerBlock extends PacketBlock {

    private final AbstractPower power;

    public AbstractPowerBlock(AbstractPower power) {
        super(BlockId.ABSTRACT_POWER);
        this.power = power;
    }

    @Override
    public byte[] getBytes() throws IOException {
        return new byte[0];
    }
}
