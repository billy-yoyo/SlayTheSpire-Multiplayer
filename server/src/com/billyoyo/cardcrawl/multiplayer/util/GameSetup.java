package com.billyoyo.cardcrawl.multiplayer.util;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.cards.SoulGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.OverlayMenu;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.daily.DailyMods;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.map.MapRoomNode;
import com.megacrit.cardcrawl.rooms.AbstractRoom;
import com.megacrit.cardcrawl.scenes.TheCityScene;

import java.util.Random;

/**
 * Created by william on 01/02/2018.
 */
public class GameSetup {

    public static void setupGame(AbstractPlayer player, AbstractRoom room) {
        Settings.seed = new Random().nextLong();
        new DailyMods().initialize(new com.megacrit.cardcrawl.random.Random(Settings.seed));
        AbstractDungeon.bossList.add("Online");
        AbstractDungeon.generateSeeds();
        AbstractDungeon.player = player;
        AbstractDungeon.currMapNode = new MapRoomNode(1, 1);
        AbstractDungeon.currMapNode.room = room;
        AbstractDungeon.currMapNode.room.onPlayerEntry();
        AbstractDungeon.scene = new TheCityScene();
        //AbstractDungeon.scene.randomizeScene();
        AbstractDungeon.screen = AbstractDungeon.CurrentScreen.NONE;
        AbstractDungeon.fadeColor = Color.BLUE;
        AbstractDungeon.isFadingIn = true;
        room.souls = new SoulGroup();

        CardCrawlGame.dungeonTransitionScreen = null; //new DungeonTransitionScreen("TheCity");
        CardCrawlGame.mode = CardCrawlGame.GameMode.GAMEPLAY;
        AbstractDungeon.rs = AbstractDungeon.RenderScene.NORMAL;
        AbstractDungeon.nextRoom = AbstractDungeon.currMapNode;
        AbstractDungeon.overlayMenu = new OverlayMenu(player);
    }
}
