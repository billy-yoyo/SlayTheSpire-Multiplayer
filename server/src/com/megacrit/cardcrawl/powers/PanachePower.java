//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.megacrit.cardcrawl.powers;

import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.cards.DamageInfo.DamageType;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ImageMaster;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

public class PanachePower extends AbstractPower {
    public static final String POWER_ID = "Panache";
    private static final PowerStrings powerStrings;
    public static final String NAME;
    public static final String[] DESCRIPTIONS;
    public static final int CARD_AMT = 5;
    private int damage;

    public PanachePower(AbstractCreature owner, int damage) {
        this.name = NAME;
        this.ID = "Panache";
        this.owner = owner;
        this.amount = 5;
        this.damage = damage;
        this.updateDescription();
        this.img = ImageMaster.loadImage("images/powers/32/panache.png");
    }

    public int getDamage() {
        return damage;
    }

    public void updateDescription() {
        if(this.amount == 1) {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1] + this.damage + DESCRIPTIONS[2];
        } else {
            this.description = DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[3] + this.damage + DESCRIPTIONS[2];
        }

    }

    public void stackPower(int stackAmount) {
        this.fontScale = 8.0F;
        this.damage += stackAmount;
        this.updateDescription();
    }

    public void onUseCard(AbstractCard card, UseCardAction action) {
        --this.amount;
        if(this.amount == 0) {
            this.flash();
            this.amount = 5;
            AbstractDungeon.actionManager.addToBottom(new DamageAllEnemiesAction(AbstractDungeon.player, DamageInfo.createDamageMatrix(this.damage, true), DamageType.THORNS, AttackEffect.SLASH_DIAGONAL));
        }

        this.updateDescription();
    }

    public void atStartOfTurn() {
        this.amount = 5;
        this.updateDescription();
    }

    static {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings("Panache");
        NAME = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }
}
