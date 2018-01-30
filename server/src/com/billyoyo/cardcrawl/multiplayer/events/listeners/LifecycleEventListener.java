package com.billyoyo.cardcrawl.multiplayer.events.listeners;

import com.billyoyo.cardcrawl.multiplayer.events.EventListener;
import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.*;

/**
 * Created by william on 28/01/2018.
 */
public class LifecycleEventListener implements EventListener {

    public boolean onContinueTurn(ContinueTurnEvent event) { return false; }
    public boolean onEndTurn(EndTurnEvent event) { return false; }
    public boolean onGameFinished(GameFinishedEvent event) { return false; }
    public boolean onStartTurn(StartTurnEvent event) { return false; }
    public boolean onPlayCard(PlayCardEvent event) { return false; }
    public boolean onReady(ReadyEvent event) { return false; }
    public boolean onOutOfOrder(OutOfOrderEvent event) { return false; }
    public boolean onInvalid(InvalidEvent event) { return false; }

    @Override
    public boolean notify(Event event) {
        if (event instanceof ContinueTurnEvent) {
            return onContinueTurn((ContinueTurnEvent) event);
        }

        if (event instanceof EndTurnEvent) {
            return onEndTurn((EndTurnEvent) event);
        }

        if (event instanceof GameFinishedEvent) {
            return onGameFinished((GameFinishedEvent) event);
        }

        if (event instanceof StartTurnEvent) {
            return onStartTurn((StartTurnEvent) event);
        }

        if (event instanceof PlayCardEvent) {
            return onPlayCard((PlayCardEvent) event);
        }

        if (event instanceof ReadyEvent) {
            return onReady((ReadyEvent) event);
        }

        if (event instanceof OutOfOrderEvent) {
            return onOutOfOrder((OutOfOrderEvent) event);
        }

        if (event instanceof InvalidEvent) {
            return onInvalid((InvalidEvent) event);
        }

        return false;
    }
}
