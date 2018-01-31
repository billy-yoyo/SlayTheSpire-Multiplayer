package com.billyoyo.cardcrawl.multiplayer.client;

import com.billyoyo.cardcrawl.multiplayer.client.game.OnlineDungeon;
import com.billyoyo.cardcrawl.multiplayer.client.game.OnlineGameRoom;
import com.billyoyo.cardcrawl.multiplayer.client.game.OnlinePlayer;
import com.billyoyo.cardcrawl.multiplayer.client.game.Opponent;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.map.MapRoomNode;

/**
 * Created by william on 31/01/2018.
 */
public class StaticRoomLauncher {

    public static void launchRoom() {
        Opponent opponent = new Opponent();

        ClientHub hub = StaticClientConnector.connectToServer(StaticClientConnector.DEFAULT_HOST,
                StaticClientConnector.DEFAULT_PORT, opponent);

        if (hub != null) {
            String name = "Unknown";
            if (AbstractDungeon.player != null) {
                hub.setOriginalPlayer(AbstractDungeon.player);
                name = AbstractDungeon.player.name;
            }

            OnlinePlayer player = new OnlinePlayer(name, hub);
            OnlineGameRoom room = new OnlineGameRoom(hub, opponent);

            AbstractDungeon.player = player;
            AbstractDungeon.setCurrMapNode(new MapRoomNode(1, 1));
            AbstractDungeon.currMapNode.room = room;

            CardCrawlGame.dungeonTransitionScreen = null;
            CardCrawlGame.dungeon = new OnlineDungeon(player, hub);
            CardCrawlGame.mode = CardCrawlGame.GameMode.GAMEPLAY;

            AbstractDungeon.nextRoomTransitionStart();
        }
    }

}
