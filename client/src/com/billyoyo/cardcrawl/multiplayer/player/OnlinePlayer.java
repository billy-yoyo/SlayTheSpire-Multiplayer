package com.billyoyo.cardcrawl.multiplayer.player;

import com.billyoyo.cardcrawl.multiplayer.client.ClientHub;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 26/01/2018.
 */
public class OnlinePlayer extends AbstractPlayer {

    private ClientHub hub;

    public OnlinePlayer(ClientHub hub, String name, PlayerClass setClass) {
        super(name, setClass);
        this.hub = hub;
    }

    @Override
    protected void initializeStarterRelics(PlayerClass chosenClass) {
        int index = 0;
        List<String> relics = hub.getRandomRelics();

        for (String relic : hub.getRandomRelics()) {
            RelicLibrary.getRelic(relic).makeCopy().instantObtain(this, index, false);
        }

        AbstractDungeon.relicsToRemoveOnStart.addAll(relics);
    }
}
