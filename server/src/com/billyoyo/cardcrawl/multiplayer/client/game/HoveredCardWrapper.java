package com.billyoyo.cardcrawl.multiplayer.client.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.billyoyo.cardcrawl.multiplayer.client.ClientHub;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

/**
 * Created by william on 31/01/2018.
 */
public class HoveredCardWrapper extends AbstractCard {

    private ClientHub hub;
    private AbstractCard wrapped;

    public HoveredCardWrapper(ClientHub hub, AbstractCard card) {
        super(card.cardID, card.name, card.jokeAssetURL, card.assetURL, card.cost, card.rawDescription, card.type,
                card.color, card.rarity, card.target, 0);

        this.hub = hub;
        this.wrapped = card;

        resyncPosition();
    }

    public void updatePosition() {
        wrapped.current_x = this.current_x;
        wrapped.current_y = this.current_y;
        wrapped.target_x = this.target_x;
        wrapped.target_y = this.target_y;
        wrapped.drawScale = this.drawScale;
        wrapped.targetDrawScale = this.targetDrawScale;
        wrapped.cantUseMessage = this.cantUseMessage;
        wrapped.target = this.target;
        wrapped.hoverTimer = this.hoverTimer;
        wrapped.damage = this.damage;
    }

    private void resyncPosition() {
        this.current_x = wrapped.current_x;
        this.current_y = wrapped.current_y;
        this.target_x = wrapped.target_x;
        this.target_y = wrapped.target_y;
        this.drawScale = wrapped.drawScale;
        this.targetDrawScale = wrapped.targetDrawScale;
        this.cantUseMessage = wrapped.cantUseMessage;
        this.target = wrapped.target;
        this.hoverTimer = wrapped.hoverTimer;
        this.damage = wrapped.damage;
    }

    @Override
    public void upgrade() {
        updatePosition();
        wrapped.upgrade();
        resyncPosition();
    }

    @Override
    public AbstractCard makeCopy() {
        return new HoveredCardWrapper(hub, wrapped);
    }

    @Override
    public void use(AbstractPlayer abstractPlayer, AbstractMonster abstractMonster) {
        updatePosition();
        // don't actually use the card
    }

    @Override
    public void flash(Color color) {
        updatePosition();
        wrapped.flash(color);
        resyncPosition();
    }

    @Override
    public void setAngle(float angle, boolean something) {
        updatePosition();
        wrapped.setAngle(angle, something);
        resyncPosition();
    }

    @Override
    public void updateHoverLogic() {
        updatePosition();
        wrapped.updateHoverLogic();
        resyncPosition();
    }

    @Override
    public boolean canUse(AbstractPlayer player, AbstractMonster monster) {
        // client side protection may need to be removed, since client could be out of sync
        // and is actually able to use card. Not sure about this one.
        if (hub.isInControl()) {
            hub.playCard(wrapped);
        }

        // we always return false since we always want the card the be returned to the hand
        // the server will then remove the card from the hand later
        return false;
    }

    @Override
    public boolean hasEnoughEnergy() {
        updatePosition();
        boolean result = wrapped.hasEnoughEnergy();
        resyncPosition();
        return result;
    }

    @Override
    public void untip() {
        updatePosition();
        wrapped.untip();
        resyncPosition();
    }

    @Override
    public void unhover() {
        updatePosition();
        wrapped.unhover();
        resyncPosition();
    }

    @Override
    public void beginGlowing() {
        updatePosition();
        wrapped.beginGlowing();
        resyncPosition();
    }

    @Override
    public void renderHoverShadow(SpriteBatch sb) {
        updatePosition();
        wrapped.renderHoverShadow(sb);
        resyncPosition();
    }

    @Override
    public void calculateCardDamage(AbstractMonster monster) {
        updatePosition();
        wrapped.calculateCardDamage(monster);
        resyncPosition();
    }

    @Override
    public void render(SpriteBatch sb) {
        updatePosition();
        wrapped.render(sb);
        resyncPosition();
    }

    @Override
    public void applyPowers() {
        updatePosition();
        wrapped.applyPowers();
        resyncPosition();
    }

    @Override
    public void calculateDamageDisplay(AbstractMonster monster) {
        updatePosition();
        wrapped.calculateDamageDisplay(monster);
        resyncPosition();
    }

    @Override
    public boolean equals(Object object) {
        return wrapped.equals(object);
    }

    @Override
    public int hashCode() {
        return wrapped.hashCode();
    }

    @Override
    public String toString() {
        return wrapped.toString();
    }
}
