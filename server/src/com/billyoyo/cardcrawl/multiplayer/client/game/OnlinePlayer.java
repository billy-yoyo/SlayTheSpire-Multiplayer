package com.billyoyo.cardcrawl.multiplayer.client.game;

import com.billyoyo.cardcrawl.multiplayer.client.ClientHub;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.EnergyManager;
import com.megacrit.cardcrawl.screens.CharSelectInfo;

import java.util.ArrayList;

/**
 * Created by william on 31/01/2018.
 */
public class OnlinePlayer extends AbstractPlayer {

    private ClientHub hub;

    public OnlinePlayer(String name, ClientHub hub) {
        // for now ironclad is hardset
        super(name, PlayerClass.IRONCLAD);
        this.initializeClass((String)null, "images/characters/ironclad/shoulder2.png", "images/characters/ironclad/shoulder.png", "images/characters/ironclad/corpse.png", getLoadout(), 20.0F, -10.0F, 220.0F, 290.0F, new EnergyManager(3));
        this.loadAnimation("images/characters/ironclad/idle/skeleton.atlas", "images/characters/ironclad/idle/skeleton.json", 1.0F);

        this.hub = hub;
    }

    private CharSelectInfo getLoadout() {
        return new CharSelectInfo("Name", "Flavour", 50, 50, 50, 6, PlayerClass.IRONCLAD,
                new ArrayList<>(), new ArrayList<>(), false);
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
