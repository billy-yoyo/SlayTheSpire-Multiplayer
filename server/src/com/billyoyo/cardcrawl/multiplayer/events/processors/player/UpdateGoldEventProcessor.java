package com.billyoyo.cardcrawl.multiplayer.events.processors.player;

import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.EventProcessor;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.UpdateGoldEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 26/01/2018.
 */
public class UpdateGoldEventProcessor extends EventProcessor<UpdateGoldEvent> {

    @Override
    public EventId getEventId() {
        return EventId.UPDATE_GOLD;
    }

    @Override
    public Packet processEvent(UpdateGoldEvent event) {
        return createPacketBuilder(event)
                .add(event.getGold()).build();
    }

    @Override
    public UpdateGoldEvent processPacket(CreateData data, Packet packet) {
        return new UpdateGoldEvent(data.getClientId(), packet.getInt(0));
    }
}
