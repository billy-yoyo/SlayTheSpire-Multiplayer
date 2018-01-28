package com.billyoyo.cardcrawl.multiplayer.server;

import com.billyoyo.cardcrawl.multiplayer.base.Hub;
import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.EventManager;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

import java.util.List;

/**
 * Created by william on 26/01/2018.
 */
public class ServerHub implements Hub
{
    private EventManager eventManager;
    private GameSession gameSession;

    public ServerHub(EventManager eventManager) {
        this.eventManager = eventManager;
    }

    public ServerHub() {
        this.eventManager = new EventManager(this);
    }

    public void startLobby(ClientInfo client1, ClientInfo client2) {
        gameSession = new GameSession(this, client1, client2);
    }



    public EventManager getEventManager() {
        return eventManager;
    }

    @Override
    public void postEvent(Event event) {
        getEventManager().post(event);
    }

    @Override
    public void sendPacket(String destination, Packet packet) {

    }

    @Override
    public void receivePacket(String clientId, Packet packet) {

    }
}
