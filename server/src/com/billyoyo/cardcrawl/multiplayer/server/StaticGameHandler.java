package com.billyoyo.cardcrawl.multiplayer.server;

import com.billyoyo.cardcrawl.multiplayer.server.player.ClientPlayer;
import com.billyoyo.cardcrawl.multiplayer.server.room.GameRoom;
import com.megacrit.cardcrawl.actions.GameActionManager;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.map.MapRoomNode;

/**
 * Created by william on 27/01/2018.
 */
public class StaticGameHandler {

    public static void switchToPlayer(ClientPlayer player) {
        AbstractDungeon.player = player;
    }

    public static void switchToRoom(GameRoom room) {
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

}
