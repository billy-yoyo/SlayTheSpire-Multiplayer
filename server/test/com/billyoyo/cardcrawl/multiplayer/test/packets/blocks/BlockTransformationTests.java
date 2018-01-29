package com.billyoyo.cardcrawl.multiplayer.test.packets.blocks;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractCardDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.AbstractRelicDTO;
import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlock;
import com.billyoyo.cardcrawl.multiplayer.packets.AbstractPacketBlockFactory;
import com.billyoyo.cardcrawl.multiplayer.packets.blocks.*;
import com.billyoyo.cardcrawl.multiplayer.packets.factories.*;
import com.megacrit.cardcrawl.cards.CardGroup;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by william on 29/01/2018.
 */
public class BlockTransformationTests {

    @Test
    public void can_transform_integer_blocks() throws IOException {
        IntegerBlock block = new IntegerBlock(4142);
        IntegerBlock recreated = recreate(block, new IntegerBlockFactory());

        Assert.assertEquals(block.getValue(), recreated.getValue());
    }

    @Test
    public void can_transform_string_blocks() throws IOException {
        StringBlock block = new StringBlock("exampleId");
        StringBlock recreated = recreate(block, new StringBlockFactory());

        Assert.assertEquals(block.getString(), recreated.getString());
    }

    @Test
    public void can_transform_byte_blocks() throws IOException {
        ByteBlock block = new ByteBlock(123);
        ByteBlock recreated = recreate(block, new ByteBlockFactory());

        Assert.assertEquals(block.getValue(), recreated.getValue());
    }

    @Test
    public void can_transform_empty_blocks() throws IOException {
        TrueBlock trueBlock = new TrueBlock();
        recreate(trueBlock, new TrueBlockFactory());

        FalseBlock falseBlock = new FalseBlock();
        recreate(falseBlock, new FalseBlockFactory());

        NullBlock nullBlock = new NullBlock();
        recreate(nullBlock, new NullBlockFactory());
    }

    @Test
    public void can_transform_abstract_card_blocks() throws IOException {
        AbstractCardBlock block = new AbstractCardBlock(new AbstractCardDTO(
                "exampleId", false, 123
        ));
        AbstractCardBlock recreated = recreate(block, new AbstractCardBlockFactory());


        Assert.assertEquals(block.getCard(), recreated.getCard());


        block = new AbstractCardBlock(new AbstractCardDTO(
                "another example id", true, 2
        ));
        recreated = recreate(block, new AbstractCardBlockFactory());


        Assert.assertEquals(block.getCard(), recreated.getCard());
    }

    @Test
    public void can_transform_abstract_power_blocks() throws IOException {
        AbstractPowerBlock block = new AbstractPowerBlock(new AbstractPowerDTO(
                "an example power id", 13, -1, new AbstractCardDTO("exampleId", false, 123)
        ));
        AbstractPowerBlock recreated = recreate(block, new AbstractPowerBlockFactory());


        Assert.assertEquals(block.getPower(), recreated.getPower());


        block = new AbstractPowerBlock(new AbstractPowerDTO("an id", 200, 5, null));
        recreated = recreate(block, new AbstractPowerBlockFactory());


        Assert.assertEquals(block.getPower(), recreated.getPower());
    }

    @Test
    public void can_transform_abstract_relic_blocks() throws IOException {
        AbstractRelicBlock block = new AbstractRelicBlock(new AbstractRelicDTO(
                "relic id", 823
        ));
        AbstractRelicBlock recreated = recreate(block, new AbstractRelicBlockFactory());


        Assert.assertEquals(block.getRelic(), recreated.getRelic());
    }

    @Test
    public void can_transform_card_type_blocks() throws IOException {
        CardGroupTypeBlock block = new CardGroupTypeBlock(CardGroup.CardGroupType.DISCARD_PILE);
        CardGroupTypeBlock recreated = recreate(block, new CardGroupTypeBlockFactory());


        Assert.assertEquals(block, recreated);
    }

    private <T extends AbstractPacketBlock> T recreate(T block,
            AbstractPacketBlockFactory<T> factory) throws IOException {
        byte[] data = block.getBytes();

        InputStream stream = new ByteArrayInputStream(data);
        return factory.create(stream);
    }
}
