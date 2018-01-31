package com.billyoyo.cardcrawl.multiplayer.server;

import com.badlogic.gdx.ApplicationListener;
import com.billyoyo.cardcrawl.multiplayer.server.sockets.ServerConnectionAcceptor;
import com.billyoyo.cardcrawl.multiplayer.server.sockets.ServerConnectionService;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.characters.Ironclad;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.Random;

/**
 * Created by william on 29/01/2018.
 */
public class ServerApplicationListener implements ApplicationListener {

    private ServerConnectionAcceptor acceptor = null;
    private String prefDir;

    public ServerApplicationListener(String prefDir) {
        this.prefDir = prefDir;
    }

    private void initializeCardGame() {
        CardCrawlGame baseGame = new CardCrawlGame(prefDir);
        baseGame.create();

        Settings.seed = new Random().nextLong();

        AbstractDungeon.player = new Ironclad("hello", AbstractPlayer.PlayerClass.IRONCLAD);
        AbstractDungeon.generateSeeds();
    }

    @Override
    public void create() {
        ServerSettings settings = new ServerSettings();

        acceptor = new ServerConnectionAcceptor(settings);

        ServerConnectionService service = new ServerConnectionService(acceptor, settings);
        service.start();
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void render() {
        if (acceptor != null) {
            acceptor.update();
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
