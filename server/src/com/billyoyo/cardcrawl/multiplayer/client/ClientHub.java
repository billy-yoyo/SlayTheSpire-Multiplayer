package com.billyoyo.cardcrawl.multiplayer.client;

import com.billyoyo.cardcrawl.multiplayer.base.Hub;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.EventManager;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 28/01/2018.
 */
public class ClientHub implements Hub {

    public EventManager eventManager;
    public ClientGame game;

    public ClientHub(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public ClientHub() {
        this.eventManager = new EventManager(this);
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public void startGame() {
        game = new ClientGame(this);
    }

    @Override
    public void postEvent(Event event) {
        getEventManager().post(event);
    }

    @Override
    public void sendPacket(String serverId, Packet packet) {

    }

    @Override
    public void receivePacket(String serverId, Packet packet) {
        CreateData data;
        if (game == null) {
            data = new CreateData(serverId);
        } else {
            data = new CreateData(game.getPlayer(), game.getOpponent(), serverId);
        }

        getEventManager().receive(data, packet);
    }
}
