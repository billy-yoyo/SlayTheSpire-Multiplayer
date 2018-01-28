package com.billyoyo.cardcrawl.multiplayer.events.processors.relicgroup;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.UpdateRelicsEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;
import com.billyoyo.cardcrawl.multiplayer.packets.PacketBuilder;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 27/01/2018.
 */
public class UpdateRelicsEventProcessor extends EventProcessor<UpdateRelicsEvent> {

    @Override
    public EventId getEventId() {
        return EventId.UPDATE_RELICS;
    }

    @Override
    public Packet processEvent(UpdateRelicsEvent event) {
        PacketBuilder builder = createPacketBuilder(event);

        for (AbstractRelic relic : event.getRelics()) {
            builder.add(relic);
        }

        return builder.build();
    }

    @Override
    public UpdateRelicsEvent processPacket(CreateData data, Packet packet) {
        int amountOfRelics = packet.getAmountOfBlocks();
        List<AbstractRelic> relics = new ArrayList<>(amountOfRelics);

        for (int i = 0; i < amountOfRelics; i++) {
            relics.add(packet.getRelic(i).create(data));
        }

        return new UpdateRelicsEvent(data.getClientId(), relics);
    }
}
