package com.billyoyo.cardcrawl.multiplayer.client.game;

import com.billyoyo.cardcrawl.multiplayer.client.ClientHub;
import com.megacrit.cardcrawl.characters.AbstractPlayer;

/**
 * Created by william on 31/01/2018.
 */
public class OnlinePlayer extends AbstractPlayer {

    private ClientHub hub;

    public OnlinePlayer(String name, ClientHub hub) {
        // for now ironclad is hardset
        super(name, PlayerClass.IRONCLAD);

        this.hub = hub;
    }

    @Override
    public void initializeStarterDeck() {}

    @Override
    public void initializeStarterRelics(PlayerClass playerClass) {}

    @Override
    public void updateInput() {
        if (this.hoveredCard != null && !(this.hoveredCard instanceof HoveredCardWrapper)) {
            this.hoveredCard = new HoveredCardWrapper(hub, this.hoveredCard);
        }

        super.updateInput();

        if (this.hoveredCard != null && this.hoveredCard instanceof HoveredCardWrapper) {
            ((HoveredCardWrapper) this.hoveredCard).updatePosition();
        }
    }
}
