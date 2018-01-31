package com.billyoyo.cardcrawl.multiplayer.client.listeners;

import com.billyoyo.cardcrawl.multiplayer.client.ClientHub;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.*;
import com.billyoyo.cardcrawl.multiplayer.events.listeners.LifecycleEventListener;

import java.util.logging.Logger;

/**
 * Created by william on 30/01/2018.
 */
public class ClientLifecycleListener extends LifecycleEventListener {

    private static Logger log = Logger.getLogger(ClientLifecycleListener.class.getName());

    private ClientHub hub;

    public ClientLifecycleListener(ClientHub hub) {
        this.hub = hub;
    }

    @Override
    public boolean onContinueTurn(ContinueTurnEvent event) {
        hub.setInControl(true);

        // handle "end of playing card" logic

        return true;
    }

    @Override
    public boolean onEndTurn(EndTurnEvent event) {

        // handle "end turn" logic

        return true;
    }

    @Override
    public boolean onGameFinished(GameFinishedEvent event) {

        // handle "game finished" logic

        return true;
    }

    @Override
    public boolean onStartTurn(StartTurnEvent event) {
        hub.setInControl(true);

        // handle "start turn" logic

        return true;
    }

    @Override
    public boolean onOutOfOrder(OutOfOrderEvent event) {
        log.warning("packet with id " + event.getInvalidEventId() + " was sent out of order.");
        return true;
    }

    @Override
    public boolean onInvalid(InvalidEvent event) {
        log.warning("packet with id " + event.getInvalidEventId() + " was invalid");
        return true;
    }

    @Override
    public boolean onReady(ReadyEvent event) {
        hub.prepareGame();

        // we can just immediately respond to the ready event
        hub.postEvent(new ReadyEvent(event.getClientId()));

        return true;
    }
}
