package com.billyoyo.cardcrawl.multiplayer.server.room;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.monsters.MonsterGroup;
import com.megacrit.cardcrawl.rooms.MonsterRoom;

/**
 * Created by william on 27/01/2018.
 */
public class GameRoom extends MonsterRoom {

    public GameRoom() {

    }

    @Override
    public void onPlayerEntry() {
        this.monsters = new MonsterGroup(new NullMonster());
    }

    @Override
    public AbstractCard.CardRarity getCardRarity(int i) {
        return AbstractCard.CardRarity.UNCOMMON;
    }
}
