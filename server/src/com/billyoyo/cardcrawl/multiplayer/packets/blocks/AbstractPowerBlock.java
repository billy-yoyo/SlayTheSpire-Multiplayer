package com.billyoyo.cardcrawl.multiplayer.packets.blocks;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlock;
import com.billyoyo.cardcrawl.multiplayer.util.IOHelper;
import com.megacrit.cardcrawl.powers.AbstractPower;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 27/01/2018.
 */
public class AbstractPowerBlock extends AbstractPacketBlock {

    private final AbstractPowerDTO power;

    public AbstractPowerBlock(AbstractPowerDTO power) {
        super(BlockId.ABSTRACT_POWER);
        this.power = power;
    }

    public AbstractPowerBlock(AbstractPower power) {
        this(new AbstractPowerDTO(power));
    }

    public AbstractPowerDTO getPower() {
        return power;
    }

    @Override
    public byte[] getBytes() throws IOException {
        List<byte[]> dataList = new ArrayList<>();

        dataList.add(IOHelper.bytesForString(power.getId()));
        dataList.add(IOHelper.bytesForNumber(power.getAmount()));
        dataList.add(IOHelper.bytesForNumber(power.getHpLoss()));
        if (power.getCard() != null) {
            AbstractCardBlock cardBlock = new AbstractCardBlock(power.getCard());

            dataList.add(cardBlock.getBytes());
        }

        return IOHelper.joinBytes(dataList);
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof AbstractPowerBlock && equals((AbstractPowerBlock) object);
    }

    private boolean equals(AbstractPowerBlock block) {
        return block.getPower().equals(getPower());
    }
}
