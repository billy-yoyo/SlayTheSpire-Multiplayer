package com.billyoyo.cardcrawl.multiplayer.server;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.*;
import com.billyoyo.cardcrawl.multiplayer.events.listeners.LifecycleEventListener;
import com.billyoyo.cardcrawl.multiplayer.server.player.ClientMonster;
import com.billyoyo.cardcrawl.multiplayer.server.player.ClientPlayer;
import com.megacrit.cardcrawl.cards.AbstractCard;

/**
 * Created by william on 29/01/2018.
 */
public class ServerLifecycleListener extends LifecycleEventListener {

    private ServerHub hub;

    public ServerLifecycleListener(ServerHub hub) {
        this.hub = hub;
    }

    @Override
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

    @Override
    public boolean onPlayCard(PlayCardEvent event) {
        GameSession game = hub.getGameSession();
        GameSession.Player player = game.getPlayer(event.getClientId());
        AbstractCard card = event.getCard();

        if (game.canPlay(player)) {
            ClientPlayer clientPlayer = game.getClientPlayer(player);
            ClientPlayer opponentPlayer = game.getClientPlayer(game.getOtherPlayer(player));

            if (card != null && card.canPlay(card) && card.canUse(clientPlayer, new ClientMonster(opponentPlayer))) {
                game.playCard(player, event.getCard());
            } else {
                hub.postEvent(new InvalidEvent(event));
            }
        } else {
            hub.postEvent(new OutOfOrderEvent(event));
        }

        return true;
    }

    @Override
    public boolean onReady(ReadyEvent event) {
        GameSession game = hub.getGameSession();

        if (game != null) {
            game.onReady(event.getClientId());
        }

        return true;
    }

    @Override
    public boolean onOutOfOrder(OutOfOrderEvent event) {
        return true;
    }

    @Override
    public boolean onInvalid(InvalidEvent event) {
        return true;
    }
}
