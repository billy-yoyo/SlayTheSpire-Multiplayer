package com.billyoyo.cardcrawl.multiplayer.packets.factories;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractCardDTO;
import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlockFactory;
import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.blocks.AbstractCardBlock;
import com.billyoyo.cardcrawl.multiplayer.util.IOHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by william on 28/01/2018.
 */
public class AbstractCardBlockFactory extends AbstractPacketBlockFactory<AbstractCardBlock> {
    @Override
    public BlockId getBlockId() {
        return BlockId.ABSTRACT_CARD;
    }

    @Override
    public AbstractCardBlock create(InputStream input) throws IOException {
        List<byte[]> dataList = IOHelper.readDataList(input);

        if (dataList.size() != 3) {
            throw new IOException("invalid card block, wrong amount of data points");
        }

        String cardId = IOHelper.stringFromBytes(dataList.get(0));
        boolean upgraded = IOHelper.booleanFromBytes(dataList.get(1));
        int timesUpgraded = IOHelper.numberFromBytes(dataList.get(2));

        return new AbstractCardBlock(new AbstractCardDTO(cardId, upgraded, timesUpgraded));
    }
}
