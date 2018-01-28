//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.megacrit.cardcrawl.powers;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDiscardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class StasisPower extends AbstractPower {
    public static final String POWER_ID = "Stasis";
    private static final PowerStrings powerStrings;
    public static final String NAME;
    public static final String[] DESCRIPTIONS;
    private AbstractCard card;

    public StasisPower(AbstractCreature owner, AbstractCard card) {
        this.name = NAME;
        this.ID = "Stasis";
        this.owner = owner;
        this.card = card;
        this.amount = -1;
        this.updateDescription();
        this.loadRegion("stasis");
    }

    public AbstractCard getCard() {
        return card;
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.card.name + DESCRIPTIONS[1];
    }

    public void onDeath() {
        if(AbstractDungeon.player.hand.size() != 10) {
            AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(this.card, 1, false));
        } else {
            AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDiscardAction(this.card, 1));
        }

    }

    static {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings("Stasis");
        NAME = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }
}
