package com.billyoyo.cardcrawl.multiplayer.client.game;

import com.billyoyo.cardcrawl.multiplayer.client.ClientHub;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.InputHelper;

import java.util.ArrayList;

/**
 * Created by william on 31/01/2018.
 */
public class OnlineDungeon extends AbstractDungeon {

    private static final String ONLINE_DUNGEON_ID = "Online";

    private ClientHub hub;

    public OnlineDungeon(AbstractPlayer p, ClientHub hub) {
        super(ONLINE_DUNGEON_ID, ONLINE_DUNGEON_ID, p, new ArrayList<>());
        this.hub = hub;
    }

    @Override
    protected void initializeLevelSpecificChances() {

    }

    @Override
    protected ArrayList<String> generateExclusions() {
        return null;
    }

    @Override
    protected void generateMonsters() {

    }

    @Override
    protected void initializeBoss() {

    }

    @Override
    protected void initializeEventList() {

    }

    @Override
    protected void initializeEventImg() {

    }

    @Override
    protected void initializeShrineList() {

    }

    @Override
    public void update() {
        ftue.update();
        InputHelper.justClickedRight = false;
        InputHelper.justClickedLeft = false;
        currMapNode.room.update();
    }

}
