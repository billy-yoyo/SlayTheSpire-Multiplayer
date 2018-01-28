package com.billyoyo.cardcrawl.multiplayer.packets.blocks;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractCardDTO;
import com.billyoyo.cardcrawl.multiplayer.packets.BlockId;
import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlock;
import com.billyoyo.cardcrawl.multiplayer.util.IOHelper;
import com.megacrit.cardcrawl.cards.AbstractCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 26/01/2018.
 */
public class AbstractCardBlock extends AbstractPacketBlock {

    private AbstractCardDTO card;

    public AbstractCardBlock(AbstractCardDTO card) {
        super(BlockId.ABSTRACT_CARD);

        this.card = card;
    }

    public AbstractCardBlock(AbstractCard card) {
        this(new AbstractCardDTO(card));
    }

    public AbstractCardDTO getCard() {
        return card;
    }

    @Override
    public byte[] getBytes() throws IOException {
        List<byte[]> dataList = new ArrayList<>();

        dataList.add(IOHelper.bytesForString(card.getId()));
        dataList.add(IOHelper.bytesForBoolean(card.isUpgraded()));
        dataList.add(IOHelper.bytesForNumber(card.getTimesUpgraded()));

        return IOHelper.joinBytes(dataList);
    }
}
