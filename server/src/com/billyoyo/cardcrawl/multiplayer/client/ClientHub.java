package com.billyoyo.cardcrawl.multiplayer.client;

import com.billyoyo.cardcrawl.multiplayer.base.Hub;
import com.billyoyo.cardcrawl.multiplayer.client.listeners.*;
import com.billyoyo.cardcrawl.multiplayer.client.sockets.ClientConnection;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.EventManager;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.EndTurnEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.GameFinishedEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.PlayCardEvent;
import com.billyoyo.cardcrawl.multiplayer.packets.Packet;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

/**
 * Created by william on 28/01/2018.
 */
public class ClientHub implements Hub {

    private static final int MAX_PACKET_POPS = 10;

    private EventManager eventManager;
    private boolean connected = true;
    private boolean inControl = false;
    private AbstractMonster opponent;
    private ServerInfo server;
    private AbstractPlayer originalPlayer;

    public ClientHub(AbstractMonster opponent) {
        this.eventManager = new EventManager(this);
        this.opponent = opponent;

        registerEventListeners();
    }

    public AbstractMonster getOpponent() {
        return opponent;
    }

    public void setOriginalPlayer(AbstractPlayer player) {
        this.originalPlayer = player;
    }

    public AbstractPlayer getOriginalPlayer() {
        return originalPlayer;
    }

    public void setInControl(boolean inControl) {
        this.inControl = inControl;
    }

    public boolean isInControl() {
        return inControl;
    }

    private void registerEventListeners() {
        eventManager.registerListener(new ClientCardsListener(this));
        eventManager.registerListener(new ClientLifecycleListener(this));
        eventManager.registerListener(new ClientPlayerListener(this));
        eventManager.registerListener(new ClientPowerGroupListener(this));
        eventManager.registerListener(new ClientRelicGroupListener(this));
    }

    public EventManager getEventManager() {
        return eventManager;
    }

    public void prepareGame() {
        // called just before the client declares itself ready
    }

    public void startGame() {

    }

    public void endGame() {
        setInControl(true);

        if (!opponent.isDead && !AbstractDungeon.player.isDead) {
            postEvent(new GameFinishedEvent(server.getId(), GameFinishedEvent.GameState.SURRENDER));
        }
    }

    public void startLobby(ServerInfo server) {
        this.server = server;

        // wait until server sends us the ready packet
    }

    public void playCard(AbstractCard card) {
        setInControl(false);
        postEvent(new PlayCardEvent(server.getId(), card));
    }

    public void endTurn() {
        setInControl(false);
        postEvent(new EndTurnEvent(server.getId()));
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
        server.getConnection().getOutput().write(packet);
    }

    @Override
    public void receivePacket(String serverId, Packet packet) {
        CreateData data;
        if (opponent == null || AbstractDungeon.player == null) {
            data = new CreateData(serverId);
        } else {
            data = new CreateData(AbstractDungeon.player, opponent, serverId);
        }

        getEventManager().receive(data, packet);
    }

    @Override
    public void update() {
        if (server != null && connected) {
            ClientConnection connection = server.getConnection();

            connected = connection.ensureConnected();
            if (connected) {
                connection.popPackets(this, MAX_PACKET_POPS);
            }
        }
    }
}
