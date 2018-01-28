package com.billyoyo.cardcrawl.multiplayer.server.player;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup.AddPowerEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup.ClearPowersEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup.RemovePowerEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.powergroup.UpdatePowersEvent;
import com.billyoyo.cardcrawl.multiplayer.server.ClientInfo;
import com.billyoyo.cardcrawl.multiplayer.server.ServerHub;
import com.megacrit.cardcrawl.powers.AbstractPower;

/**
 * Created by william on 27/01/2018.
 */
public class ClientPowersArrayList extends AbstractArrayListEventPoster<AbstractPower> {

    private ServerHub hub;
    private ClientInfo client;

    public ClientPowersArrayList(ServerHub hub, ClientInfo client) {
        this.hub = hub;
        this.client = client;
    }

    @Override
    public void onAdd(AbstractPower power) {
        hub.postEvent(new AddPowerEvent(client.getId(), power));
    }

    @Override
    public void onRemove(AbstractPower power) {
        hub.postEvent(new RemovePowerEvent(client.getId(), power));
    }

    @Override
    public void onClear() {
        hub.postEvent(new ClearPowersEvent(client.getId()));
    }

    @Override
    public void onUpdate() {
        hub.postEvent(new UpdatePowersEvent(client.getId(), this));
    }
}
