package com.megacrit.cardcrawl.powers;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.FontHelper;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;

/**
 * Created by william on 27/01/2018.
 */
public class NightmarePower extends AbstractPower {
    public static final String POWER_ID = "Night Terror";
    private static final PowerStrings powerStrings;
    public static final String NAME;
    public static final String[] DESCRIPTIONS;
    private AbstractCard card;

    public NightmarePower(AbstractCreature owner, int cardAmt, AbstractCard copyMe) {
        this.name = NAME;
        this.ID = "Night Terror";
        this.owner = owner;
        this.amount = cardAmt;
        this.img = ImageMaster.loadImage("images/powers/32/nightTerror.png");
        this.card = copyMe.makeStatEquivalentCopy();
        this.card.resetAttributes();
        this.updateDescription();
    }

    public AbstractCard getCard() {
        return card;
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.amount + " " + FontHelper.colorString(this.card.name, "y") + DESCRIPTIONS[1];
    }

    public void atStartOfTurn() {
        AbstractDungeon.actionManager.addToBottom(new MakeTempCardInHandAction(this.card, this.amount));
        AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.owner, this.owner, "Night Terror"));
    }

    static {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings("Night Terror");
        NAME = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }
}
