package com.billyoyo.cardcrawl.multiplayer.packets;

import com.billyoyo.cardcrawl.multiplayer.packets.factories.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by william on 28/01/2018.
 */
public class PacketBlockReader {

    private static Map<Integer, AbstractPacketBlockFactory> readers = new HashMap<>();
    private static boolean initialized = false;

    public static void register(int blockId, AbstractPacketBlockFactory reader) {
        readers.put(blockId, reader);
    }

    private static void initialize() {
        new AbstractCardBlockFactory().register();
        new AbstractPowerBlockFactory().register();
        new AbstractRelicBlockFactory().register();
        new ByteBlockFactory().register();
        new CardGroupTypeBlockFactory().register();
        new FalseBlockFactory().register();
        new IntegerBlockFactory().register();
        new NullBlockFactory().register();
        new StringBlockFactory().register();
        new TrueBlockFactory().register();
    }

    public static void ensureInitialized() {
        if (!initialized) {
            initialized = true;
            initialize();
        }
    }

    public static AbstractPacketBlock createBlock(int blockId, InputStream stream) throws IOException {
        ensureInitialized();

        AbstractPacketBlockFactory factory = readers.get(blockId);
        return factory.create(stream);
    }

    public static AbstractPacketBlock createBlock(BlockId blockId, InputStream stream) throws IOException {
        return createBlock(blockId.getId(), stream);
    }
}
