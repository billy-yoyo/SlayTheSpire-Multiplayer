package com.billyoyo.cardcrawl.multiplayer.player;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.AddRelicEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.ClearRelicsEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.RemoveRelicEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.relicgroup.UpdateRelicsEvent;
import com.billyoyo.cardcrawl.multiplayer.server.ClientInfo;
import com.billyoyo.cardcrawl.multiplayer.server.ServerHub;
import com.megacrit.cardcrawl.relics.AbstractRelic;

/**
 * Created by william on 27/01/2018.
 */
public class ClientRelicArrayList extends AbstractArrayListEventPoster<AbstractRelic> {

    private ServerHub hub;
    private ClientInfo client;

    public ClientRelicArrayList(ServerHub hub, ClientInfo client) {
        this.hub = hub;
        this.client = client;
    }

    @Override
    public void onAdd(AbstractRelic relic) {
        if (relic != null) {
            hub.postEvent(new AddRelicEvent(client.getId(), relic));
        }
    }

    @Override
    public void onRemove(AbstractRelic relic) {
        if (relic != null) {
            hub.postEvent(new RemoveRelicEvent(client.getId(), relic));
        }
    }

    @Override
    public void onClear() {
        hub.postEvent(new ClearRelicsEvent(client.getId()));
    }

    @Override
    public void onUpdate() {
        hub.postEvent(new UpdateRelicsEvent(client.getId(), this));
    }


}
