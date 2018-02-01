package com.billyoyo.cardcrawl.multiplayer.server;

import com.badlogic.gdx.ApplicationListener;
import com.billyoyo.cardcrawl.multiplayer.server.sockets.ServerConnectionAcceptor;
import com.billyoyo.cardcrawl.multiplayer.server.sockets.ServerConnectionService;
import com.megacrit.cardcrawl.core.CardCrawlGame;

import java.util.logging.Logger;

/**
 * Created by william on 29/01/2018.
 */
public class ServerApplicationListener implements ApplicationListener {

    private static final Logger log = Logger.getLogger(ServerApplicationListener.class.getName());

    private ServerConnectionAcceptor acceptor = null;
    private String prefDir;

    public ServerApplicationListener(String prefDir) {
        this.prefDir = prefDir;
    }

    private void initializeCardGame() {
        CardCrawlGame baseGame = new CardCrawlGame(prefDir);
        baseGame.create();
    }

    @Override
    public void create() {
        ServerSettings settings = new ServerSettings();
        initializeCardGame();

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
