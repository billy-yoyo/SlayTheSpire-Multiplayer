package com.billyoyo.cardcrawl.multiplayer.server;

import com.badlogic.gdx.ApplicationListener;
import com.billyoyo.cardcrawl.multiplayer.server.sockets.ServerConnectionAcceptor;
import com.billyoyo.cardcrawl.multiplayer.server.sockets.ServerConnectionService;

/**
 * Created by william on 29/01/2018.
 */
public class ServerApplicationListener implements ApplicationListener {
    private ServerConnectionAcceptor acceptor = null;

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
