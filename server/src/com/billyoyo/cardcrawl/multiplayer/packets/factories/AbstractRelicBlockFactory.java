package com.billyoyo.cardcrawl.multiplayer.packets.factories;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractRelicDTO;
import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlockFactory;
import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.blocks.AbstractRelicBlock;
import com.billyoyo.cardcrawl.multiplayer.util.IOHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by william on 28/01/2018.
 */
public class AbstractRelicBlockFactory extends AbstractPacketBlockFactory<AbstractRelicBlock> {
    @Override
    public BlockId getBlockId() {
        return BlockId.ABSTRACT_RELIC;
    }

    @Override
    public AbstractRelicBlock create(InputStream input) throws IOException {
        List<byte[]> dataList = IOHelper.readDataList(input);

        if (dataList.size() != 2) {
            throw new IOException("invalid relic block, invalid amount of data points");
        }

        String relicId = IOHelper.stringFromBytes(dataList.get(0));
        int counter = IOHelper.numberFromBytes(dataList.get(1));

        return new AbstractRelicBlock(new AbstractRelicDTO(relicId, counter));
    }
}
