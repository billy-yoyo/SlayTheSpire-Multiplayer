package com.billyoyo.cardcrawl.multiplayer.server;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.*;
import com.billyoyo.cardcrawl.multiplayer.events.listeners.LifecycleEventListener;

/**
 * Created by william on 29/01/2018.
 */
public class ServerLifecycleListener extends LifecycleEventListener {

    private ServerHub hub;

    public ServerLifecycleListener(ServerHub hub) {
        this.hub = hub;
    }

    public boolean onEndTurn(EndTurnEvent event) {
        GameSession game = hub.getGameSession();
        GameSession.Player player = game.getPlayer(event.getClientId());

        if (game.canPlay(player)) {
            game.endTurn();
        } else {
            hub.postEvent(new OutOfOrderEvent(event));
        }

        return true;
    }

    public boolean onPlayCard(PlayCardEvent event) {
        GameSession game = hub.getGameSession();
        GameSession.Player player = game.getPlayer(event.getClientId());

        if (game.canPlay(player)) {
            game.playCard(player, event.getCard());
        } else {
            hub.postEvent(new OutOfOrderEvent(event));
        }

        return true;
    }

    public boolean onReady(ReadyEvent event) {
        GameSession game = hub.getGameSession();

        if (game != null) {
            game.onReady(event.getClientId());
        }

        return true;
    }

}
