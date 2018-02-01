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
        //this.ftue = new FtueTip();
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
        bossList.add("Online");
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
        //ftue.update();

        topPanel.update();
        dynamicButton.update();
        dynamicBanner.update();
        currMapNode.room.updateObjects();
        updateFading();

        switch(screen) {
            case NONE:
                currMapNode.room.update();
                scene.update();
                dialog.update();
                genericEventDialog.update();
                break;
            case FTUE:
                ftue.update();
                InputHelper.justClickedRight = false;
                InputHelper.justClickedLeft = false;
                currMapNode.room.update();
                break;
            case MASTER_DECK_VIEW:
                deckViewScreen.update();
                break;
            case GAME_DECK_VIEW:
                gameDeckViewScreen.update();
                break;
            case DISCARD_VIEW:
                discardPileViewScreen.update();
                break;
            case SETTINGS:
                settingsScreen.update();
                break;
            case MAP:
                // do nothing
                break;
            case GRID:
                gridSelectScreen.update();
                break;
            case CARD_REWARD:
                cardRewardScreen.update();
                break;
            case COMBAT_REWARD:
                combatRewardScreen.update();
                break;
            case BOSS_REWARD:
                bossRelicScreen.update();
                currMapNode.room.update();
                break;
            case HAND_SELECT:
                handCardSelectScreen.update();
                break;
            case SHOP:
                shopScreen.update();
                break;
            case DEATH:
                deathScreen.update();
                break;
            case UNLOCK:
                unlockScreen.update();
                break;
            case GASHA_UNLOCK:
                gUnlockScreen.update();
                break;
            case CREDITS:
                creditsScreen.update();
                break;
            default:
                System.out.println("ERROR: UNKNOWN SCREEN TO UPDATE: " + screen.name());
        }


        InputHelper.justClickedRight = false;
        InputHelper.justClickedLeft = false;
        overlayMenu.update();
    }

}
