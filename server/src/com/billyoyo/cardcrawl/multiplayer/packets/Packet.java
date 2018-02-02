package com.billyoyo.cardcrawl.multiplayer.packets;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractCardDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.AbstractPowerDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.AbstractRelicDTO;
import com.billyoyo.cardcrawl.multiplayer.packets.blocks.*;
import com.megacrit.cardcrawl.cards.CardGroup;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static com.billyoyo.cardcrawl.multiplayer.util.IOHelper.safeRead;

/**
 * Created by william on 26/01/2018.
 *
 */
public class Packet {

    private static final Logger log = Logger.getLogger(Packet.class.getName());

    public static Packet read(InputStream input) throws IOException {
        int eventId = safeRead(input);

        int amountOfBlocks = safeRead(input);
        List<AbstractPacketBlock> blocks = new ArrayList<>(amountOfBlocks);

        for (int i = 0; i < amountOfBlocks; i++) {
            int blockId =   safeRead(input);
            blocks.add(PacketBlockReader.createBlock(blockId, input));
        }

        return new Packet(eventId, blocks);
    }

    private final int eventId;
    private final List<AbstractPacketBlock> blocks;

    public Packet(int eventId, List<AbstractPacketBlock> blocks) {
        this.eventId = eventId;
        this.blocks = blocks;
    }

    public int getEventId() {
        return eventId;
    }

    public List<AbstractPacketBlock> getBlocks() {
        return blocks;
    }

    public int getAmountOfBlocks() {
        return blocks.size();
    }

    public <T extends AbstractPacketBlock> T getBlock(int index) {
        AbstractPacketBlock block = blocks.get(index);
        if (block instanceof NullBlock) {
            return null;
        }

        return (T) blocks.get(index);
    }

    public int getInt(int index) {
        IntegerBlock block = getBlock(index);
        return block.getValue();
    }

    public int getByte(int index) {
        ByteBlock block = getBlock(index);
        return block.getValue();
    }

    public AbstractCardDTO getCard(int index) {
        AbstractCardBlock block = getBlock(index);
        return block == null ? null : block.getCard();
    }

    public AbstractPowerDTO getPower(int index) {
        AbstractPowerBlock block = getBlock(index);
        return block == null ? null : block.getPower();
    }

    public AbstractRelicDTO getRelic(int index) {
        AbstractRelicBlock block = getBlock(index);
        return block == null ? null : block.getRelic();
    }

    public CardGroup.CardGroupType getCardType(int index) {
        CardGroupTypeBlock block = getBlock(index);
        return block == null ? null : block.getCardType();
    }

    public boolean getBoolean(int index) {
        AbstractPacketBlock block = blocks.get(index);
        if (block instanceof FalseBlock) {
            return false;
        } else if (block instanceof TrueBlock) {
            return true;
        } else {
            throw new InvalidBlockTypeException("block at index " + index + " is not a boolean");
        }
    }

    public String getString(int index) {
        StringBlock block = getBlock(index);
        return block == null ? null : block.getString();
    }

    public void write(OutputStream output) throws IOException {
        if (eventId >= 256 || eventId < 0) {
            throw new IOException("Invalid event id, must be between 0 and 255 inclusive, " + eventId + " was given");
        }

        if (blocks.size() >= 256) {
            throw new IOException("Too many blocks in a single packet, must be between 0 and 255 inclusive, " + blocks.size() + " were given");
        }

        output.write(eventId);

        output.write(blocks.size());

        for (AbstractPacketBlock block : blocks) {
            output.write(block.getBlockId());

            byte[] data = block.getBytes();
            output.write(data);
        }
    }

    public byte[] getBytes() throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        write(output);

        return output.toByteArray();
    }

    @Override
    public String toString() {
        List<String> blockStrings = new ArrayList<>();
        for (AbstractPacketBlock block : getBlocks()) {
            blockStrings.add(block.getClass().getName());
        }

        String blocks = "[" + String.join(", ", blockStrings) + "]";

        return "Packet[id=" + getEventId() + ", blocks=" + blocks + "]";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Packet && equals((Packet) obj);
    }

    private boolean equals(Packet packet) {
        if (packet.getEventId() != getEventId() || packet.getAmountOfBlocks() != getAmountOfBlocks()) {
            return false;
        }

        for (int i = 0; i < getAmountOfBlocks(); i++) {
            if (!packet.getBlocks().get(i).equals(getBlocks().get(i))) {
                return false;
            }
        }

        return true;
    }
}
