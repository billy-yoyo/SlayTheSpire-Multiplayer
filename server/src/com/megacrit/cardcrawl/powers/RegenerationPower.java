//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.megacrit.cardcrawl.powers;

import com.megacrit.cardcrawl.actions.common.HealAction;
import com.megacrit.cardcrawl.actions.common.ReducePowerAction;
import com.megacrit.cardcrawl.actions.common.RemoveSpecificPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.powers.AbstractPower.PowerType;

public class RegenerationPower extends AbstractPower {
    public static final String POWER_ID = "Regeneration";
    private static final PowerStrings powerStrings;
    public static final String NAME;
    public static final String[] DESCRIPTIONS;
    private int healAmount;

    public RegenerationPower(AbstractCreature owner, int turns, int heal) {
        this.name = NAME;
        this.ID = "Regeneration";
        this.owner = owner;
        this.amount = turns;
        this.healAmount = heal;
        this.updateDescription();
        this.loadRegion("regen");
        this.type = PowerType.BUFF;
    }

    public int getHealAmount() {
        return healAmount;
    }

    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + this.healAmount + DESCRIPTIONS[1] + this.amount + DESCRIPTIONS[2];
    }

    public void atEndOfTurn(boolean isPlayer) {
        this.flash();
        AbstractDungeon.actionManager.addToBottom(new HealAction(this.owner, this.owner, this.healAmount));
        if(this.amount == 0) {
            AbstractDungeon.actionManager.addToBottom(new RemoveSpecificPowerAction(this.owner, this.owner, "Regeneration"));
        } else {
            AbstractDungeon.actionManager.addToBottom(new ReducePowerAction(this.owner, this.owner, "Regeneration", 1));
        }

    }

    static {
        powerStrings = CardCrawlGame.languagePack.getPowerStrings("Regeneration");
        NAME = powerStrings.NAME;
        DESCRIPTIONS = powerStrings.DESCRIPTIONS;
    }
}
