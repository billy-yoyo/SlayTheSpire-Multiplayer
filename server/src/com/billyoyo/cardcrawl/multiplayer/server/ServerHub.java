package com.billyoyo.cardcrawl.multiplayer.server;

import com.billyoyo.cardcrawl.multiplayer.base.Hub;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.EventManager;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by william on 26/01/2018.
 */
public class ServerHub implements Hub
{
    private static Logger log = Logger.getLogger(ServerHub.class.getName());

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
        try {
            gameSession.getClientInfo(destination).getConnection().getPacketOutputStream().write(packet);
        } catch (IOException exception) {
            log.warning("failed to send packet with id " + packet.getEventId() + " to client " + destination);
            exception.printStackTrace();
        }
    }

    @Override
    public void receivePacket(String source, Packet packet) {
        try {
            GameSession.Player player = gameSession.getPlayer(source);
            GameSession.Player otherPlayer = gameSession.getOtherPlayer(player);

            CreateData data = new CreateData(gameSession.getClientPlayer(player),
                    gameSession.getClientPlayer(otherPlayer), source);

            eventManager.receive(data, packet);
        } catch (Exception exception) {
            log.warning("failed to receive packet with id " + packet.getEventId() + " from client " + source);
            exception.printStackTrace();
        }
    }
}
