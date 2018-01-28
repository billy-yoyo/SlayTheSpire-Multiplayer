package com.billyoyo.cardcrawl.multiplayer.events.listeners;

import com.billyoyo.cardcrawl.multiplayer.events.EventListener;
import com.billyoyo.cardcrawl.multiplayer.events.Event;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle.*;

/**
 * Created by william on 28/01/2018.
 */
public class LifecycleEventListener implements EventListener {

    public void onContinueTurn(ContinueTurnEvent event) {}
    public void onEndTurn(EndTurnEvent event) {}
    public void onGameFinished(GameFinishedEvent event) {}
    public void onStartTurn(StartTurnEvent event) {}
    public void onPlayCard(PlayCardEvent event) {}

    @Override
    public void notify(Event event) {
        if (event instanceof ContinueTurnEvent) {
            onContinueTurn((ContinueTurnEvent) event);
            return;
        }

        if (event instanceof EndTurnEvent) {
            onEndTurn((EndTurnEvent) event);
            return;
        }

        if (event instanceof GameFinishedEvent) {
            onGameFinished((GameFinishedEvent) event);
            return;
        }

        if (event instanceof StartTurnEvent) {
            onStartTurn((StartTurnEvent) event);
        }

        if (event instanceof PlayCardEvent) {
            onPlayCard((PlayCardEvent) event);
        }
    }
}
