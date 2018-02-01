package com.billyoyo.cardcrawl.multiplayer.server;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.billyoyo.cardcrawl.multiplayer.server.player.ClientPlayer;
import com.billyoyo.cardcrawl.multiplayer.server.room.GameRoom;
import com.billyoyo.cardcrawl.multiplayer.util.GameSetup;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.map.MapRoomNode;

/**
 * Created by william on 27/01/2018.
 */
public class StaticGameHandler {

    public static void switchToPlayer(ClientPlayer player) {
        AbstractDungeon.player = player;
    }

    public static void switchToRoom(AbstractPlayer startingPlayer, GameRoom room) {
        GameSetup.setupGame(startingPlayer, room);
        MapRoomNode roomNode = new MapRoomNode(0, 0);
        roomNode.room = room;

        AbstractDungeon.setCurrMapNode(roomNode);
    }

    public static void exhaustActions() {
        GameActionManager manager = AbstractDungeon.actionManager;
        manager.phase = GameActionManager.Phase.EXECUTING_ACTIONS;

        while (!manager.actions.isEmpty() && !manager.preTurnActions.isEmpty()
                && !manager.cardQueue.isEmpty()) {
            manager.update();
        }

        manager.phase = GameActionManager.Phase.WAITING_ON_USER;
    }

    public static void exhaustTurn() {
        GameActionManager manager = AbstractDungeon.actionManager;
        manager.phase = GameActionManager.Phase.EXECUTING_ACTIONS;

        while (manager.turnHasEnded) {
            manager.update();
        }

        manager.phase = GameActionManager.Phase.WAITING_ON_USER;
    }

    public static void launchServer() {
        try {
            LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
            config.title = "mock-test";
            config.useGL30 = false;
            config.width = 1;
            config.height = 1;

            new LwjglApplication(new ServerApplicationListener(config.preferencesDirectory), config);
        } catch (Exception e) {
            Gdx.app.exit();
        }
    }


}
