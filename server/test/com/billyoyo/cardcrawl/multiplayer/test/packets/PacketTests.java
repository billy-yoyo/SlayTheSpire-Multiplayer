package com.billyoyo.cardcrawl.multiplayer.test.packets;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractCardDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.AbstractRelicDTO;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Created by william on 29/01/2018.
 */
public class PacketTests {

    @Test
    public void can_transform_packet_with_number_and_string() throws IOException {
        testReconstruction(
                new PacketBuilder().setEventId(3)
                        .add(4123)
                        .add("hello").build()
        );
    }

    @Test
    public void can_transform_packet_with_card_and_string() throws IOException {
        testReconstruction(
                new PacketBuilder().setEventId(7)
                        .add(new AbstractCardDTO("hello", false, 3))
                        .add("hello").build()
        );
    }

    @Test
    public void can_transform_packet_with_boolean_and_byte() throws IOException {
        testReconstruction(
                new PacketBuilder().setEventId(20)
                        .add(false)
                        .addByte(10).build()
        );
    }

    @Test
    public void can_transform_packet_with_relic_and_power() throws IOException {
        testReconstruction(
                new PacketBuilder().setEventId(15)
                        .add(new AbstractRelicDTO("hi", 3))
                        .add(new AbstractPowerDTO("id2", 3, -1, null)).build()
        );
    }

    @Test
    public void can_transform_packet_with_null_and_int() throws IOException {
        String nullString = null;

        testReconstruction(
                new PacketBuilder().setEventId(1)
                        .add(nullString)
                        .add(42).build()
        );
    }

    @Test
    public void can_transform_packet_with_lots_of_blocks() throws IOException {
        testReconstruction(
                new PacketBuilder().setEventId(19)
                        .add("1").add(2).add("3").addByte(4).add(5)
                        .add("6").add("7").addByte(8).add(9).add("10").build()
        );
    }

    @Test
    public void can_transform_packet_with_single_block() throws IOException {
        testReconstruction(
                new PacketBuilder().setEventId(11).add("hello").build()
        );
    }

    @Test
    public void can_transform_packet_with_no_blocks() throws IOException {
        testReconstruction(
                new PacketBuilder().setEventId(4).build()
        );
    }

    private void testReconstruction(Packet packet) throws IOException {
        byte[] data = packet.getBytes();
        ByteArrayInputStream stream = new ByteArrayInputStream(data);

        Packet recreated = Packet.read(stream);
        Assert.assertEquals(packet, recreated);
    }
}
