package com.billyoyo.cardcrawl.multiplayer.test.mocks;

import com.badlogic.gdx.ApplicationListener;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.localization.LocalizedStrings;

/**
 * Created by william on 29/01/2018.
 */
public abstract class MockTest implements ApplicationListener {

    public final String lockString = "lock";
    private boolean locked = false;

    public boolean isLocked() {
        return locked;
    }

    public abstract void run();

    private void initializeGame() {
        Settings.initialize();
        CardCrawlGame.languagePack = new LocalizedStrings();
    }

    @Override
    public void create() {
        synchronized (lockString) {
            locked = true;

            System.out.println("hello world");
            initializeGame();
            run();
        }

    }

    @Override
    public void resize(int i, int i1) {

    }

    @Override
    public void render() {

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
