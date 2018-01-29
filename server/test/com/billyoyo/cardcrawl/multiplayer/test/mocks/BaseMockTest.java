package com.billyoyo.cardcrawl.multiplayer.test.mocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * Created by william on 29/01/2018.
 */
public class BaseMockTest {

    public void runTest(MockTest listener) {
        LwjglApplication app = null;

        try {
            LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
            config.title = "mock-test";
            config.useGL30 = false;
            config.width = 1;
            config.height = 1;

            app = new LwjglApplication(listener, config);
            // app.getGraphics().setUndecorated(true);
        } catch (Exception e) {
            Gdx.app.exit();
        }

        try {
            while (listener.isLocked()) {
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            if (listener.isLocked()) {
                throw new RuntimeException("interrupted before app finished");
            }
        } finally {
            if (app != null) {
                try {
                    app.stop();
                } catch (Exception e) {
                    // ignore exception
                }
            }
        }

        System.out.println("test finished");
    }

}
