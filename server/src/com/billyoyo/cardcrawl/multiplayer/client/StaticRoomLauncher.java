package com.billyoyo.cardcrawl.multiplayer.client;

import com.billyoyo.cardcrawl.multiplayer.client.game.OnlineDungeon;
import com.billyoyo.cardcrawl.multiplayer.client.game.OnlineGameRoom;
import com.billyoyo.cardcrawl.multiplayer.client.game.OnlinePlayer;
import com.billyoyo.cardcrawl.multiplayer.client.game.Opponent;
import com.billyoyo.cardcrawl.multiplayer.util.GameSetup;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

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

            GameSetup.setupGame(player, room);

            CardCrawlGame.dungeon = new OnlineDungeon(player, hub);
            CardCrawlGame.dungeon.updateFading();


            CardCrawlGame.dungeon.nextRoomTransition();
        }
    }

}
