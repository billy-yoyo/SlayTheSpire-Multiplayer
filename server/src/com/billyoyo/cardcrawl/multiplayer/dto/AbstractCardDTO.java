package com.billyoyo.cardcrawl.multiplayer.dto;

import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.helpers.CardLibrary;

/**
 * Created by william on 27/01/2018.
 */
public class AbstractCardDTO implements DTO<AbstractCard> {

    private final String id;
    private final boolean upgraded;
    private final int timesUpgraded;

    public AbstractCardDTO(String id, boolean upgraded, int timesUpgraded) {
        this.id = id;
        this.upgraded = upgraded;
        this.timesUpgraded = timesUpgraded;
    }

    public AbstractCardDTO(AbstractCard card) {
        this(card.cardID, card.upgraded, card.timesUpgraded);
    }

    public String getId() {
        return id;
    }

    public boolean isUpgraded() {
        return upgraded;
    }

    public int getTimesUpgraded() {
        return timesUpgraded;
    }

    @Override
    public boolean matches(AbstractCard card) {
        return card.cardID.equals(id)
                && card.upgraded == upgraded
                && card.timesUpgraded == timesUpgraded;
    }

    @Override
    public AbstractCard create() {
        AbstractCard card = CardLibrary.getCard(id);
        if (card != null) {
            card = card.makeCopy();
            for (int i = 0; i < timesUpgraded; i++) {
                card.upgrade();
            }

            card.upgraded = true;
            card.timesUpgraded = timesUpgraded;
        }
        return card;
    }
}
