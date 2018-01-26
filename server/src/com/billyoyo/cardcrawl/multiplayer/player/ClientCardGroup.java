package com.billyoyo.cardcrawl.multiplayer.player;

import com.billyoyo.cardcrawl.multiplayer.events.eventtypes.cardgroup.*;
import com.billyoyo.cardcrawl.multiplayer.server.ClientInfo;
import com.billyoyo.cardcrawl.multiplayer.server.ServerHub;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

/**
 * Created by william on 26/01/2018.
 */
public class ClientCardGroup extends CardGroup {

    private ServerHub hub;
    private ClientInfo client;

    public ClientCardGroup(ServerHub hub, ClientInfo client, CardGroupType type) {
        super(type);
        this.hub = hub;
        this.client = client;
    }

    @Override
    public void clear() {
        super.clear();

        hub.postEvent(new ClearCardsGroupEvent(client.getId(), type));
    }

    @Override
    public void applyPowers() {
        super.clear();

        hub.postEvent(new CardApplyPowersGroupEvent(client.getId(), type));
    }

    @Override
    public void removeCard(AbstractCard card) {
        super.removeCard(card);

        hub.postEvent(new CardRemoveGroupEvent(client.getId(), type, card));
    }

    @Override
    public boolean removeCard(String targetID) {
        boolean result = super.removeCard(targetID);

        if (result) {
            hub.postEvent(new CardRemoveIdGroupEvent(client.getId(), type, targetID));
        }

        return result;
    }

    @Override
    public void addToHand(AbstractCard card) {
        super.addToHand(card);

        hub.postEvent(new CardAddGroupEvent(client.getId(), type, card, 0));
    }

    @Override
    public void addToTop(AbstractCard card) {
        super.addToTop(card);

        hub.postEvent(new CardAddGroupEvent(client.getId(), type, card, 0));
    }

    @Override
    public void addToBottom(AbstractCard card) {
        super.addToBottom(card);

        hub.postEvent(new CardAddGroupEvent(client.getId(), type, card, -1));
    }

    @Override
    public void addToRandomSpot(AbstractCard card) {
        int position = 0;
        if (this.group.size() == 0) {
            this.group.add(card);
        } else {
            position = AbstractDungeon.cardRandomRng.random(this.group.size() - 1);
            this.group.add(position, card);
        }

        hub.postEvent(new CardAddGroupEvent(client.getId(), type, card, position));
    }
}
