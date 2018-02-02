package com.billyoyo.cardcrawl.multiplayer.server;

import com.billyoyo.cardcrawl.multiplayer.base.Connection;
import com.billyoyo.cardcrawl.multiplayer.base.Hub;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.EventManager;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.GameFinishedEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.ReadyEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;

import java.util.logging.Logger;

/**
 * Created by william on 26/01/2018.
 */
public class ServerHub implements Hub
{
    private static Logger log = Logger.getLogger(ServerHub.class.getName());
    private static final int MAX_PACKET_POPS = 10;

    private ServerSettings settings;
    private EventManager eventManager;
    private GameSession gameSession;

    public ServerHub(ServerSettings settings) {
        this.settings = settings;
        this.eventManager = new EventManager(this);
    }

    public void startLobby(ClientInfo client1, ClientInfo client2) {
        gameSession = new GameSession(this, client1, client2);
        eventManager.registerListener(new ServerLifecycleListener(this));

        postEvent(new ReadyEvent(client1.getId()));
        postEvent(new ReadyEvent(client2.getId()));
    }

    public GameSession getGameSession() {
        return gameSession;
    }

    public ServerSettings getSettings() {
        return settings;
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    @Override
    public void postEvent(Event event) {
        // log.info("posting event " + event.getEventId() + " to " + event.getClientId());
        getEventManager().post(event);
    }

    @Override
    public void sendPacket(String destination, Packet packet) {
        // right now, if this packet fails to write, it'll be forgotten
        // this could be remedied by adding an 'onerror' callback to the packet
        // but that's enhancement territory.
        log.info("sending packet with id " + EventId.fromId(packet.getEventId()).name() + " to " + destination);
        gameSession.getClientInfo(destination).getConnection().getOutput().write(packet);
    }

    @Override
    public void receivePacket(String source, Packet packet) {
        try {
            GameSession.Player player = gameSession.getPlayer(source);
            GameSession.Player otherPlayer = gameSession.getOtherPlayer(player);

            CreateData data = new CreateData(gameSession.getClientPlayer(player),
                    gameSession.getClientPlayer(otherPlayer), source);

            log.info("received packet with id " + EventId.fromId(packet.getEventId()).name() + " from " + source);
            eventManager.receive(data, packet);
        } catch (Exception exception) {
            log.warning("failed to receive packet with id " + packet.getEventId() + " from client " + source);
            exception.printStackTrace();
        }
    }

    public void closeLobby(GameFinishedEvent.GameState gameState) {
        ClientInfo client1 = gameSession.getClientInfo(GameSession.Player.FIRST);
        ClientInfo client2 = gameSession.getClientInfo(GameSession.Player.SECOND);

        postEvent(new GameFinishedEvent(client1.getId(), gameState));
        postEvent(new GameFinishedEvent(client2.getId(), gameState));

        gameSession = null;
    }

    private boolean popPackets(GameSession.Player player) {
        Connection connection =  gameSession.getClientInfo(player).getConnection();
        connection.update();

        if (!connection.isConnected()) {
            closeLobby(GameFinishedEvent.GameState.SURRENDER);
            return false;
        } else {
            connection.popPackets(this, MAX_PACKET_POPS);
            return true;
        }
    }

    @Override
    public void update() {
        if (gameSession != null) {
            if (popPackets(GameSession.Player.FIRST)) {
                popPackets(GameSession.Player.SECOND);
            }
        }
    }
}
