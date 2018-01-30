package com.billyoyo.cardcrawl.multiplayer.client;

import com.billyoyo.cardcrawl.multiplayer.base.Hub;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.EventManager;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.ReadyEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

/**
 * Created by william on 28/01/2018.
 */
public class ClientHub implements Hub {

    private static final int MAX_PACKET_POPS = 10;

    public EventManager eventManager;
    public ClientGame game;

    public ClientHub() {
        this.eventManager = new EventManager(this);

        registerEventListeners();
    }

    private void registerEventListeners() {

    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public void startGame() {

    }

    public void startLobby(ServerInfo server) {
        game = new ClientGame(this, server);

        // ensure the game is ready

        postEvent(new ReadyEvent(server.getId()));
    }

    @Override
    public void postEvent(Event event) {
        getEventManager().post(event);
    }

    @Override
    public void sendPacket(String serverId, Packet packet) {
        // right now, if this packet fails to write, it'll be forgotten
        // this could be remedied by adding an 'onerror' callback to the packet
        // but that's enhancement territory.
        game.getServer().getConnection().getOutput().write(packet);
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

    @Override
    public void update() {
        if (game != null) {
            game.getServer().getConnection().popPackets(this, MAX_PACKET_POPS);
        }
    }
}
