package com.billyoyo.cardcrawl.multiplayer.test.mocks;

/**
 * Created by william on 29/01/2018.
 */
public abstract class MockTest {

    private boolean done = false;

    public abstract void run();

    public boolean isDone() {
        return done;
    }

    public void start() {
        run();
        done = true;
    }
}
