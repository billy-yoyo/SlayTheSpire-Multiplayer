package com.billyoyo.cardcrawl.multiplayer.test.mocks;

import com.badlogic.gdx.ApplicationListener;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.characters.Ironclad;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by william on 29/01/2018.
 */
public class MockTestApplication implements ApplicationListener {

    private final List<MockTest> queuedTests = Collections.synchronizedList(new ArrayList<>());
    private MockTest currentTest = null;
    private boolean loaded = false;

    public void queueTest(MockTest test) {
        synchronized (queuedTests) {
            queuedTests.add(test);
        }
    }

    public boolean isLoaded() {
        return loaded;
    }

    private void nextTest() {
        synchronized (queuedTests) {
            if (queuedTests.size() > 0) {
                currentTest = queuedTests.remove(0);
            }
        }
    }

    @Override
    public void create() {
        CardCrawlGame baseGame = new CardCrawlGame(BaseMockTest.PREFERENCES_DIR);
        baseGame.create();

        Settings.seed = new Random().nextLong();

        AbstractDungeon.player = new Ironclad("hello", AbstractPlayer.PlayerClass.IRONCLAD);
        AbstractDungeon.generateSeeds();
        loaded = true;
    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void render() {
        if (currentTest == null) {
            nextTest();
        }

        if (currentTest != null) {
            currentTest.start();
            currentTest = null;
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
