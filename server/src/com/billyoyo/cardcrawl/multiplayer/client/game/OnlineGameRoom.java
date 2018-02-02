package com.billyoyo.cardcrawl.multiplayer.client.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.billyoyo.cardcrawl.multiplayer.client.ClientHub;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.EndTurnAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.MonsterGroup;
import com.megacrit.cardcrawl.rooms.MonsterRoomBoss;

/**
 * Created by william on 31/01/2018.
 */
public class OnlineGameRoom extends MonsterRoomBoss {

    private ClientHub hub;
    private Opponent opponent;

    public OnlineGameRoom(ClientHub hub, Opponent opponent) {
        this.hub = hub;
        this.opponent = opponent;
        this.mapSymbol = "B";
        this.phase = RoomPhase.COMBAT;
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

        //super.update();

        this.souls.update();

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

        AbstractDungeon.overlayMenu.showCombatPanels();

        if(Settings.isDebug && Gdx.input.isKeyJustPressed(62)) {
            AbstractDungeon.actionManager.addToTop(new DrawCardAction(AbstractDungeon.player, 1));
        }

        if(!AbstractDungeon.isScreenUp) {
            AbstractDungeon.actionManager.update();
            if(!this.monsters.areMonstersBasicallyDead() && AbstractDungeon.player.currentHealth > 0) {
                AbstractDungeon.player.updateInput();
            }
        }

        if(!AbstractDungeon.screen.equals(AbstractDungeon.CurrentScreen.HAND_SELECT)) {
            AbstractDungeon.player.combatUpdate();
        }

        if(AbstractDungeon.player.isEndingTurn) {
            this.endTurn();
        }

        AbstractDungeon.player.update();
        AbstractDungeon.player.updateAnimations();

    }

    @Override
    public void render(SpriteBatch sb) {
        super.render(sb);
        AbstractDungeon.player.renderRelics(sb);
        AbstractDungeon.player.renderHand(sb);
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
