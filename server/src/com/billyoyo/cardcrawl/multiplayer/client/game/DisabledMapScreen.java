package com.billyoyo.cardcrawl.multiplayer.client.game;

import com.megacrit.cardcrawl.screens.DungeonMapScreen;

/**
 * Created by william on 31/01/2018.
 */
public class DisabledMapScreen extends DungeonMapScreen {

    @Override
    public void update() {
        try {
            this.closeInstantly();
        } catch (Exception e) {}
    }

    @Override
    public void open(boolean doScrollingAnimation) {
        return;
    }

}
