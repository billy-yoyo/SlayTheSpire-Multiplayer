package com.billyoyo.cardcrawl.multiplayer.events.eventtypes.lifecycle;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.BaseClientEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.EventId;

/**
 * Created by william on 26/01/2018.
 */
public class GameFinishedEvent extends BaseClientEvent {

    private GameState gameState;

    public GameFinishedEvent(String clientId, GameState gameState) {
        super(clientId, EventId.GAME_FINISHED);
        this.gameState = gameState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public enum GameState {
        VICTORY(0),
        DEFEAT(1),
        SURRENDER(2);

        private int id;

        GameState(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
}
