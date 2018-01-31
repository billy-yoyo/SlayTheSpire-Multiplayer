package com.billyoyo.cardcrawl.multiplayer.test.mocks;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import org.junit.After;
import org.junit.Before;

/**
 * Created by william on 29/01/2018.
 */
public class BaseMockTest {

    public static String PREFERENCES_DIR = "C:\\Program Files (x86)\\Steam\\SteamApps\\common\\SlayTheSpire\\preferences";
    private MockTestApplication mockTestApplication = null;
    private LwjglApplication app = null;

    @Before
    public void initialize() {
        ImageMaster.class.getClassLoader().setClassAssertionStatus(ImageMaster.class.getName(), false);

        try {
            LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
            config.title = "mock-test";
            config.useGL30 = false;
            config.width = 1;
            config.height = 1;

            mockTestApplication = new MockTestApplication();
            app = new LwjglApplication(mockTestApplication, config);
            // app.getGraphics().setUndecorated(true);
        } catch (Exception e) {
            Gdx.app.exit();
        }

        try {
            while (!mockTestApplication.isLoaded()) {
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            if (!mockTestApplication.isLoaded()) {
                throw new RuntimeException("interrupted before app was loaded");
            }
        }
    }

    public void runTest(MockTest test) {
        mockTestApplication.queueTest(test);

        try {
            while (!test.isDone()) {
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            if (!test.isDone()) {
                throw new RuntimeException("interrupted before test finished");
            }
        }
    }

    @After
    public void shutdown() {
        app.stop();
        Gdx.app.exit();
    }

}
