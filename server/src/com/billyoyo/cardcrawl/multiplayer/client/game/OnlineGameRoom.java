package com.billyoyo.cardcrawl.multiplayer.client.game;

import com.billyoyo.cardcrawl.multiplayer.client.ClientHub;
import com.megacrit.cardcrawl.actions.common.EndTurnAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.MonsterGroup;
import com.megacrit.cardcrawl.rooms.AbstractRoom;

/**
 * Created by william on 31/01/2018.
 */
public class OnlineGameRoom extends AbstractRoom {

    private ClientHub hub;
    private Opponent opponent;

    public OnlineGameRoom(ClientHub hub, Opponent opponent) {
        this.hub = hub;
        this.opponent = opponent;
        this.mapSymbol = "B";
    }

    @Override
    public void onPlayerEntry() {
        this.monsters = new MonsterGroup(opponent);
        this.monsters.init();
    }

    @Override
    public AbstractCard.CardRarity getCardRarity(int i) {
        return AbstractCard.CardRarity.COMMON;
    }

    @Override
    public void update() {
        // let the server hub update first
        try {
            hub.update();
        // we don't want errors in server hub to prevent us from continuing the game logic
        } catch (Exception e) {}

        switch (phase) {
            case COMBAT:
                break;

            case EVENT:
                break;

            case COMPLETE:
                CardCrawlGame.startOver();
                break;

            case INCOMPLETE:
                break;
        }
    }

    @Override
    public void endTurn() {
        if (hub.isInControl()) {
            AbstractDungeon.player.isEndingTurn = true;
            AbstractDungeon.actionManager.addToBottom(new EndTurnAction());

            hub.endTurn();
            //super.endTurn();
        }
    }

    @Override
    public void endBattle() {
        hub.endGame();
        super.endBattle();
    }
}
