package com.billyoyo.cardcrawl.multiplayer.server.player;

import com.billyoyo.cardcrawl.multiplayer.dto.AbstractCardDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.AbstractRelicDTO;
import com.billyoyo.cardcrawl.multiplayer.dto.CreateData;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.UpdateCardsGroupEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.*;
import com.billyoyo.cardcrawl.multiplayer.server.room.GameRoom;
import com.billyoyo.cardcrawl.multiplayer.server.ClientInfo;
import com.billyoyo.cardcrawl.multiplayer.server.ServerHub;
import com.billyoyo.cardcrawl.multiplayer.server.StaticGameHandler;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.characters.Ironclad;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.relics.AbstractRelic;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by william on 26/01/2018.
 */
public class ClientPlayer extends AbstractPlayer {

    private ServerHub hub;
    private ClientInfo client;

    public ClientPlayer(ServerHub hub, ClientInfo client, String name, PlayerClass setClass) {
        super(name, setClass);
        this.initializeClass((String)null, "images/characters/ironclad/shoulder2.png", "images/characters/ironclad/shoulder.png", "images/characters/ironclad/corpse.png", Ironclad.getLoadout(), 20.0F, -10.0F, 220.0F, 290.0F, new EnergyManager(3));
        this.loadAnimation("images/characters/ironclad/idle/skeleton.atlas", "images/characters/ironclad/idle/skeleton.json", 1.0F);

        this.hub = hub;
        this.client = client;

        this.masterDeck = new ClientCardGroup(hub, client, CardGroup.CardGroupType.MASTER_DECK);
        this.drawPile = new ClientCardGroup(hub, client, CardGroup.CardGroupType.DRAW_PILE);
        this.hand = new ClientCardGroup(hub, client, CardGroup.CardGroupType.HAND);
        this.discardPile = new ClientCardGroup(hub, client, CardGroup.CardGroupType.DISCARD_PILE);
        this.exhaustPile = new ClientCardGroup(hub, client, CardGroup.CardGroupType.EXHAUST_PILE);
        this.limbo = new ClientCardGroup(hub, client, CardGroup.CardGroupType.UNSPECIFIED);

        this.relics = new ClientRelicArrayList(hub, client);
        this.powers = new ClientPowersArrayList(hub, client);
    }

    public ClientPlayerSnapshot getSnapshot() {
        return new ClientPlayerSnapshot(this);
    }

    public void sessionSetDeck(List<AbstractCardDTO> dtos) {
        List<AbstractCard> cards = new ArrayList<>();

        for (AbstractCardDTO dto : dtos) {
            cards.add(dto.create(new CreateData(this)));
        }

        this.masterDeck.group.addAll(cards);
        hub.postEvent(new UpdateCardsGroupEvent(client.getId(), this.masterDeck.type,
                this.masterDeck.group));

        this.drawPile.group.addAll(cards);
        hub.postEvent(new UpdateCardsGroupEvent(client.getId(), this.drawPile.type,
                this.drawPile.group));
    }

    public void sessionSetRelics(List<AbstractRelicDTO> dtos) {
        List<AbstractRelic> relics = new ArrayList<>();

        for (AbstractRelicDTO dto : dtos) {
            relics.add(dto.create(new CreateData(this)));
        }

        this.relics.addAll(relics);
    }

    public void sessionPlayCard(AbstractCard card, ClientMonster opponent) {
        StaticGameHandler.exhaustActions();

        if (card.target != AbstractCard.CardTarget.ENEMY && card.target != AbstractCard.CardTarget.SELF_AND_ENEMY) {
            AbstractDungeon.actionManager.cardQueue.add(new CardQueueItem(card, null));
        } else {
            AbstractDungeon.actionManager.cardQueue.add(new CardQueueItem(card, opponent));
        }

        StaticGameHandler.exhaustActions();
    }

    public void sessionStartGame(GameRoom room) {
        for (AbstractRelic relic : relics) {
            relic.onEnterRoom(room);
        }
        this.preBattlePrep();

        StaticGameHandler.exhaustActions();

        hub.postEvent(new UpdateStatsEvent(client.getId(), getSnapshot()));
    }

    public void sessionEndTurn() {
        AbstractDungeon.actionManager.endTurn();

        // make sure the action manager is empty, just in case
        StaticGameHandler.exhaustActions();
    }

    public void sessionStartTurn(boolean firstTurn) {
        if (!firstTurn) {
            AbstractDungeon.actionManager.endTurn();
            StaticGameHandler.exhaustTurn();
        }

        this.draw(6);

        StaticGameHandler.exhaustActions();
    }

    @Override
    protected void initializeStarterRelics(PlayerClass chosenClass) {
        // do nothing
    }

    @Override
    protected void initializeStarterDeck() {
        // do nothing
    }

    @Override
    public void loseGold(int goldAmount) {
        super.loseGold(goldAmount);

        // hub.postEvent(new UpdateGoldEvent(client.getId(), gold));
    }

    @Override
    public void gainGold(int amount) {
        super.gainGold(amount);

        // hub.postEvent(new UpdateGoldEvent(client.getId(), gold));
    }

    @Override
    public void damage(DamageInfo info) {
        super.damage(info);

        // hub.postEvent(new UpdateHealthEvent(client.getId(), currentHealth, isDead, isBloodied));
    }

    @Override
    public void heal(int healAmount) {
        super.heal(healAmount);

        // hub.postEvent(new UpdateHealthEvent(client.getId(), currentHealth, isDead, isBloodied));
    }

    @Override
    public void gainEnergy(int e) {
        super.gainEnergy(e);

        // hub.postEvent(new UpdateEnergyEvent(client.getId(), EnergyPanel.getCurrentEnergy()));
    }

    @Override
    public void loseEnergy(int e) {
        super.loseEnergy(e);

        // hub.postEvent(new UpdateEnergyEvent(client.getId(), EnergyPanel.getCurrentEnergy()));
    }

    @Override
    public boolean losePotion(String id) {
        boolean result = super.losePotion(id);

        if (result) {
            // hub.postEvent(new LosePotionEvent(client.getId(), id));
        }

        return result;
    }
}
