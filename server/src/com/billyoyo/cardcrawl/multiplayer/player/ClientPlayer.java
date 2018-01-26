package com.billyoyo.cardcrawl.multiplayer.player;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.LosePotionEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.UpdateEnergyEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.UpdateGoldEvent;
import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.player.UpdateHealthEvent;
import com.billyoyo.cardcrawl.multiplayer.server.ClientInfo;
import com.billyoyo.cardcrawl.multiplayer.server.ServerHub;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.RelicLibrary;
import com.megacrit.cardcrawl.ui.panels.EnergyPanel;

import java.util.List;

/**
 * Created by william on 26/01/2018.
 */
public class ClientPlayer extends AbstractPlayer {

    private ServerHub hub;
    private ClientInfo client;

    public ClientPlayer(ServerHub hub, ClientInfo client, String name, PlayerClass setClass) {
        super(name, setClass);
        this.hub = hub;
        this.client = client;

        this.masterDeck = new ClientCardGroup(hub, client, CardGroup.CardGroupType.MASTER_DECK);
        this.drawPile = new ClientCardGroup(hub, client, CardGroup.CardGroupType.DRAW_PILE);
        this.hand = new ClientCardGroup(hub, client, CardGroup.CardGroupType.HAND);
        this.discardPile = new ClientCardGroup(hub, client, CardGroup.CardGroupType.DISCARD_PILE);
        this.exhaustPile = new ClientCardGroup(hub, client, CardGroup.CardGroupType.EXHAUST_PILE);
        this.limbo = new ClientCardGroup(hub, client, CardGroup.CardGroupType.UNSPECIFIED);

        // this.initializeStarterDeck();
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

    @Override
    public void loseGold(int goldAmount) {
        super.loseGold(goldAmount);

        hub.postEvent(new UpdateGoldEvent(client.getId(), gold));
    }

    @Override
    public void gainGold(int amount) {
        super.gainGold(amount);

        hub.postEvent(new UpdateGoldEvent(client.getId(), gold));
    }

    @Override
    public void damage(DamageInfo info) {
        super.damage(info);

        hub.postEvent(new UpdateHealthEvent(client.getId(), currentHealth, isDead, isBloodied));
    }

    @Override
    public void heal(int healAmount) {
        super.heal(healAmount);

        hub.postEvent(new UpdateHealthEvent(client.getId(), currentHealth, isDead, isBloodied));
    }

    @Override
    public void gainEnergy(int e) {
        super.gainEnergy(e);

        hub.postEvent(new UpdateEnergyEvent(client.getId(), EnergyPanel.getCurrentEnergy()));
    }

    @Override
    public void loseEnergy(int e) {
        super.loseEnergy(e);

        hub.postEvent(new UpdateEnergyEvent(client.getId(), EnergyPanel.getCurrentEnergy()));
    }

    @Override
    public boolean losePotion(String id) {
        boolean result = super.losePotion(id);

        if (result) {
            hub.postEvent(new LosePotionEvent(client.getId(), id));
        }

        return result;
    }
}
