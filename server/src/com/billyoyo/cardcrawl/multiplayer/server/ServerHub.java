package com.billyoyo.cardcrawl.multiplayer.server;

import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.EventManager;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

import java.util.List;

/**
 * Created by william on 26/01/2018.
 */
public class ServerHub
{

    private List<String> randomRelics;
    private EventManager eventManager;

    public ServerHub() {
        eventManager = new EventManager(this);
    }

    public List<String> getRandomRelics() {
        return randomRelics;
    }

    public void postEvent(Event event) {
        getEventManager().post(event);
    }

    public void sendPacket(String clientId, Packet packet) {

    }

    public EventManager getEventManager() {
        return eventManager;
    }
}
