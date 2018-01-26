package com.billyoyo.cardcrawl.multiplayer.packets;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by william on 26/01/2018.
 *
 * Packet structure,
 *
 * Byte 1: event id
 * Byte 2: number of blocks
 *
 */
public class Packet {

    private static byte[] getBytesForNumber(int number) {
        return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(number).array();
    }

    private final int eventId;
    private final PacketBlock[] blocks;

    public Packet(int eventId, PacketBlock[] blocks) {
        this.eventId = eventId;
        this.blocks = blocks;
    }

    public byte[] getBytes() throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        if (eventId >= 256 || eventId < 0) {
            throw new IOException("Invalid event id, must be between 0 and 255 inclusive, " + eventId + " was given");
        }

        if (blocks.length >= 256) {
            throw new IOException("Too many blocks in a single packet, must be between 0 and 255 inclusive, " + blocks.length + " were given");
        }

        // for now there are less than 256 events so we can assume 1 byte
        output.write(eventId);

        output.write(blocks.length);

        for (PacketBlock block : blocks) {
            output.write(block.getBlockId());

            byte[] data = block.getBytes();
            output.write(getBytesForNumber(data.length));
            output.write(data);
        }

        return output.toByteArray();
    }

}
