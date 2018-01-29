package com.billyoyo.cardcrawl.multiplayer.packets.blocks;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractRelicDTO;
import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlock;
import com.billyoyo.cardcrawl.multiplayer.util.IOHelper;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 27/01/2018.
 */
public class AbstractRelicBlock extends AbstractPacketBlock {

    private final AbstractRelicDTO relic;

    public AbstractRelicBlock(AbstractRelicDTO relic) {
        super(BlockId.ABSTRACT_RELIC);

        this.relic = relic;
    }

    public AbstractRelicBlock(AbstractRelic relic) {
        this(new AbstractRelicDTO(relic));
    }

    public AbstractRelicDTO getRelic() {
        return relic;
    }

    @Override
    public byte[] getBytes() throws IOException {
        List<byte[]> dataList = new ArrayList<>();

        dataList.add(IOHelper.bytesForString(relic.getId()));
        dataList.add(IOHelper.bytesForNumber(relic.getCounter()));

        return IOHelper.joinBytes(dataList);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof AbstractRelicBlock && equals((AbstractRelicBlock) obj);
    }

    private boolean equals(AbstractRelicBlock block) {
        return block.getRelic().equals(getRelic());
    }
}
