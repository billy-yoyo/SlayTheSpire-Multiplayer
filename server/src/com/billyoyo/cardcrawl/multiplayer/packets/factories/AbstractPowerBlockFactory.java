package com.billyoyo.cardcrawl.multiplayer.packets.factories;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractCardDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlockFactory;
import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketBlockReader;
import com.billyoyo.cardcrawl.multiplayer.packets.blocks.AbstractCardBlock;
import com.billyoyo.cardcrawl.multiplayer.packets.blocks.AbstractPowerBlock;
import com.billyoyo.cardcrawl.multiplayer.util.IOHelper;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by william on 28/01/2018.
 */
public class AbstractPowerBlockFactory extends AbstractPacketBlockFactory<AbstractPowerBlock> {
    @Override
    public BlockId getBlockId() {
        return BlockId.ABSTRACT_POWER;
    }

    @Override
    public AbstractPowerBlock create(InputStream input) throws IOException {
        List<byte[]> dataList = IOHelper.readDataList(input);

        if (dataList.size() < 3 || dataList.size() > 4) {
            throw new IOException("invalid power block, wrong amount of data points");
        }

        String powerId = IOHelper.stringFromBytes(dataList.get(0));
        int amount = IOHelper.numberFromBytes(dataList.get(1));
        int hpLoss = IOHelper.numberFromBytes(dataList.get(2));
        AbstractCardDTO card = null;
        if (dataList.size() > 3) {
            byte[] cardBlockBytes = dataList.get(3);
            InputStream cardBlockBytesStream = new ByteArrayInputStream(cardBlockBytes);
            AbstractCardBlockFactory factory = new AbstractCardBlockFactory();
            AbstractCardBlock cardBlock = factory.create(cardBlockBytesStream);
            card = cardBlock.getCard();
        }

        return new AbstractPowerBlock(new AbstractPowerDTO(powerId, amount, hpLoss, card));
    }
}
